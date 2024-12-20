import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClaimsReader {
    private File claimsFile;
    private static final String DEFAULT_FILENAME = "claims.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final int NAME_POSITION = 0;
    private static final int R_POSITION = 1;
    private static final int G_POSITION = 2;
    private static final int B_POSITION = 3;
    private static final int CLASS_POSITION = 4;

    public ClaimsReader() {
        this(DEFAULT_FILENAME);
    }

    public ClaimsReader(String fileName) {
        this.claimsFile = new File(fileName);
    }

    public Claim[] getClaims() throws IOException {
        List<Claim> claims = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(claimsFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                Claim newClaim = getClaim(values);
                claims.add(newClaim);
            }
        }
        return claims.toArray(new Claim[claims.size()]);
    }

    private Claim getClaim(String[] values) {
        Claim newClaim = new Claim();
        newClaim.setName(values[NAME_POSITION]);
        final int red = Integer.parseInt(values[R_POSITION]);
        final int green = Integer.parseInt(values[G_POSITION]);
        final int blue = Integer.parseInt(values[B_POSITION]);
        newClaim.setColor(new Color(red, green, blue));
        final int classification = Integer.parseInt(values[CLASS_POSITION]);
        newClaim.setClassification(classification);
        return newClaim;
    }
}
