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
                    if (claim.getColor().equals(pixelColor))
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
}
