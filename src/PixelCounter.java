import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelCounter {
    private BufferedImage image;
    private static final String DEFAULT_FILENAME = "map.png";

    public PixelCounter() throws IOException {
        this(DEFAULT_FILENAME);
    }

    public PixelCounter(String fileName) throws IOException {
        this.image = ImageIO.read(new File(fileName));
    }

    public Claim[] setClaimCounts(Claim[] claims) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color pixelColor = getPixelColor(x, y);
                for (Claim claim : claims) {
                    if (areColorsClose(claim.getColor(), pixelColor))
                        claim.setPixelCount(claim.getPixelCount() + 1);
                }
            }
        }
        return claims;
    }

    private Color getPixelColor(int x, int y) {
        int color = image.getRGB(x, y);
        int red = (color & 0x00ff0000) >> 16;
        int green = (color & 0x0000ff00) >> 8;
        int blue = (color & 0x000000ff);
        return new Color(red, green, blue);
    }

    private boolean areColorsClose(Color color1, Color color2) {
        final int MAX_DIFFERENCE = 5; // set to 1 for same color
        return Math.abs(color1.getRed() - color2.getRed()) <= MAX_DIFFERENCE &&
                Math.abs(color1.getGreen() - color2.getGreen()) <= MAX_DIFFERENCE &&
                Math.abs(color1.getBlue() - color2.getBlue()) <= MAX_DIFFERENCE &&
                Math.abs(color1.getAlpha() - color2.getAlpha()) <= MAX_DIFFERENCE;
    }
}
