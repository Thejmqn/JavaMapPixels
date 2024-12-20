import java.io.IOException;

public class MapPixelCount {
    public static void main(String[] args) throws IOException {
        final String IMAGE_FILE = "C:\\Users\\jav3fh\\Programming\\GoMapPixels\\CivMCMap32OnlyClaims.png";
        final String CSV_FILE = "claims.csv";
        final String OUTPUT_FILE = "output.csv";

        ClaimsReader reader = new ClaimsReader(CSV_FILE);
        Claim[] claims = reader.getClaims();
        PixelCounter counter = new PixelCounter(IMAGE_FILE);
        claims = counter.setClaimCounts(claims);
        ClaimsOutput writer = new ClaimsOutput(OUTPUT_FILE, claims);
        writer.outputToCSV();
    }
}
