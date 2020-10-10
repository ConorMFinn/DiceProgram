import java.security.SecureRandom;

public class Die {
    private final int numberOfSides;
    private final SecureRandom s = new SecureRandom();
    private final int[] rollCounts;


    public Die(int numberOfSides){
        this.numberOfSides = numberOfSides;
        rollCounts = new int[numberOfSides];
    }

    public int roll() {
        int roll =  s.nextInt(numberOfSides) + 1;
        rollCounts[roll - 1]++;
        return roll;
    }

    public String getResultsString() {
        StringBuilder results = new StringBuilder();
        results.append("|");
        for (int rollCount : rollCounts) {
            results.append(rollCount);
            results.append("|");
        }
        return results.toString();
    }
}
