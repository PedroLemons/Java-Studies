import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorDota implements ContentExtractor {

    public List<Content> contentExtractor(String json){

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("name");
            String localizedName = atributos.get("localized_name");
            String urlImagem = "https://cdn.cloudflare.steamstatic.com/apps/dota2/videos/dota_react/heroes/renders/" + titulo + ".png";
            Content content = new Content(titulo, urlImagem, localizedName);
            
            contents.add(content);
        }

        return contents;
    
    }
}
