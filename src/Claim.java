import java.awt.*;

public class Claim {
    private String name;
    private Color color;

    private int pixelCount;
    private int classification;

    public Claim() {
        this.name = "";
        this.color = new Color(0, 0, 0, 255);
        this.pixelCount = 0;
        this.classification = 0;
    }

    public Claim(String name, Color color, int classification) {
        this.name = name;
        this.color = color;
        this.pixelCount = 0;
        this.classification = classification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPixelCount() {
        return pixelCount;
    }

    public void setPixelCount(int pixelCount) {
        this.pixelCount = pixelCount;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", pixelCount=" + pixelCount +
                ", classification=" + classification +
                '}';
    }
}
