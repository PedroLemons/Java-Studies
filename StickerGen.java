import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.imageio.ImageIO;
import javax.swing.plaf.FontUIResource;

public class StickerGen {

    public void cria (InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura de imagem
        // ?????????
        // URL inputStream = new URL("https://cdn.cloudflare.steamstatic.com/apps/dota2/videos/dota_react/heroes/renders/dark_willow.png");
        // ?????????
        // InputStream inputStream = new URL("https://cdn.cloudflare.steamstatic.com/apps/dota2/videos/dota_react/heroes/renders/dark_willow.png").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memoria com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memoria)
        Graphics2D g = (Graphics2D) novaImagem.getGraphics();
        g.drawImage(imagemOriginal, 0, 0, null);

        // estilizar a fonte
        var fonte = new FontUIResource(Font.SANS_SERIF, Font.BOLD, 144);
        g.setColor(Color.RED);
        g.setFont(fonte);

        // escrever uma frase na nova imagem
        Projeto projeto = new Projeto();
        String topText = projeto.localizedName;
        String bottomText = "DOTA 4";
        int posX = 740, posY = 180;
        FontMetrics fm = g.getFontMetrics();
        g.drawString(topText, posX - fm.stringWidth(topText)/2, posY );
        g.drawString(bottomText, posX - fm.stringWidth(bottomText)/2, altura - 80 );

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

    public static void main(String[] args) throws Exception {
        var gen = new StickerGen();
        gen.cria();
    }
    
}
