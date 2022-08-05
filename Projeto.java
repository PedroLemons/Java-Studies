import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Projeto {

    public static void main(String[] args) throws Exception {
        
        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://api.opendota.com/api/heroes";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        // System.out.println(HttpClient.newHttpClient().send(HttpRequest.newBuilder(URI.create("https://imdb-api.com/en/API/Top250Movies/k_kbldo5ps")).GET().build(), BodyHandlers.ofString()).body());

        // separar somente os dados que nos interessam (título, imagem e nota)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> heroList = parser.parse(body);
        // System.out.println(heroList.size());

        // exibir e manipular os dados
        for (Map<String,String> hero : heroList) {

            String heroName = hero.get("name");
            String localizedName = hero.get("localized_name");

            String urlImagem = "https://cdn.cloudflare.steamstatic.com/apps/dota2/videos/dota_react/heroes/renders/antimage.png";

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = heroName + "_sticker.png";

            var generator = new StickerGen();
            generator.cria(inputStream, nomeArquivo);
        }
    }
}