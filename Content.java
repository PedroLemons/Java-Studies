public class Content {

    private final String titulo;
    private final String urlImagem;
    private final String localizedName;

    public Content(String titulo, String urlImagem, String localizedName) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.localizedName = localizedName;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getLocalizedName() {
        return localizedName;
    }
}
