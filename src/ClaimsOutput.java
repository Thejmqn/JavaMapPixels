import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ClaimsOutput {
    private File outputFile;
    private Claim[] claimData;
    private static final String DEFAULT_FILENAME = "output.csv";


    public ClaimsOutput() {
        this(DEFAULT_FILENAME, new Claim[]{});
    }

    public ClaimsOutput(String fileName, Claim[] claimData) {
        this.outputFile = new File(fileName);
        this.claimData = claimData;
    }

    public void outputToCSV() throws IOException {
        if (!outputFile.createNewFile())
            throw new IOException("Failed to create file");

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Name, Size, R, G, B, Class\n");
            for (Claim claim : claimData)
                writer.write(
                        claim.getName() + "," +
                        claim.getPixelCount() + "," +
                        claim.getColor().getRed() + "," +
                        claim.getColor().getGreen() + "," +
                        claim.getColor().getBlue() + "," +
                        claim.getClassification() + "\n");
        }
    }
}
