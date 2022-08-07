import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ProjectDotaimg {

    public static void main(String[] args) throws Exception {
        
        // fazer uma conexão HTTP e buscar os dados
        String url = "https://api.opendota.com/api/heroes";
        ContentExtractorDota extractor = new ContentExtractorDota();

        ClientHttp http = new ClientHttp();
        String json = http.getData(url);

        List<Content> contents = extractor.contentExtractor(json);

        for (int i = 0; i < 3; i++) {

            Content content = contents.get(i);
           
            InputStream inputStream = new URL(content.getUrlImagem()).openStream();
            String nomeArquivo = content.getTitulo().replace(":", "-").replace("/", "-") + ".png";

            var stickerGen = new StickerGen();
            stickerGen.create(inputStream, nomeArquivo);
        }
        // for (Map<String,String> hero : heroList) {

        //     String heroName = hero.get("name");
        //     String localizedName = hero.get("localized_name");

        //     String urlImagem = "https://cdn.cloudflare.steamstatic.com/apps/dota2/videos/dota_react/heroes/renders/antimage.png";

        //     InputStream inputStream = new URL(urlImagem).openStream();
        //     String nomeArquivo = heroName + "_sticker.png";

        //     var generator = new StickerGen();
        //     generator.cria(inputStream, nomeArquivo);

        //     System.out.println(hero.get("name"));
        // }
    }
}