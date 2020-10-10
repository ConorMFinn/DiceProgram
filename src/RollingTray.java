public class RollingTray {
    private final Die d2 = new Die(2);
    private final Die d4 = new Die(4);
    private final Die d6 = new Die(6);
    private final Die d8 = new Die(8);
    private final Die d10 = new Die(10);
    private final Die d12 = new Die(12);
    private final Die d20 = new Die(20);
    private final Die d100 = new Die(100);

    public int rollSingle(DiceSet die) {
        switch(die) {
            case D2:
                return d2.roll();
            case D4:
                return d4.roll();
            case D6:
                return d6.roll();
            case D8:
                return d8.roll();
            case D10:
                return d10.roll();
            case D12:
                return d12.roll();
            case D20:
                return d20.roll();
            case D100:
                return d100.roll();
            default:
                return -1;
        }
    }

    public int rollMultiple(int rolls, DiceSet die){
        if (rolls < 1) {
            return 0;
        }
        int total = 0;
        for(int i = 0; i < rolls; i++) {
            total += rollSingle(die);
        }
        return total;
    }

    public String getResultsString(DiceSet die){
        switch(die) {
            case D2:
                return d2.getResultsString();
            case D4:
                return d4.getResultsString();
            case D6:
                return d6.getResultsString();
            case D8:
                return d8.getResultsString();
            case D10:
                return d10.getResultsString();
            case D12:
                return d12.getResultsString();
            case D20:
                return d20.getResultsString();
            case D100:
                return d100.getResultsString();
            default:
                return "";
        }
    }


}
