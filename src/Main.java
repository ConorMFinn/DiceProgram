import java.util.Scanner;

public class Main {
    private final RollingTray rollingTray = new RollingTray();

    public static void main(String[] args){
        Main m = new Main();
        m.start();
    }

    public void start(){
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while(running){
            print("Enter Command:");
            String command = input.next().toLowerCase();
            switch(command){
                case "roll":
                    processRollCommand(input.next());
                    break;
                case "check":
                    processCheckCommand(input.next());
                    break;
                case "help":
                    processHelpCommand();
                    break;
                case "stop":
                    input.nextLine();
                    running = false;
                    break;
            }
        }
    }

    public void processRollCommand(String command){
        String[] parts = command.split("d");
        int rolls;
        try {
            rolls = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            print("Roll commands should be in the form 'roll xdy'");
            return;
        }
        String die = parts[1];
        int result;
        switch(die) {
            case "2":
                result = rollingTray.rollMultiple(rolls, DiceSet.D2);
                break;
            case "4":
                result = rollingTray.rollMultiple(rolls, DiceSet.D4);
                break;
            case "6":
                result = rollingTray.rollMultiple(rolls, DiceSet.D6);
                break;
            case "8":
                result = rollingTray.rollMultiple(rolls, DiceSet.D8);
                break;
            case "10":
                result = rollingTray.rollMultiple(rolls, DiceSet.D10);
                break;
            case "12":
                result = rollingTray.rollMultiple(rolls, DiceSet.D12);
                break;
            case "20":
                result = rollingTray.rollMultiple(rolls, DiceSet.D20);
                break;
            case "100":
                result = rollingTray.rollMultiple(rolls, DiceSet.D100);
                break;
            default:
                print("Invalid die type given!");
                return;
        }
        print("Rolled " + command + ". Total: " + result);
    }

    public void processCheckCommand(String command) {
        command = command.toUpperCase();
        DiceSet d = DiceSet.valueOf(command);
        String output = rollingTray.getResultsString(d);
        print(output);
    }

    private void processHelpCommand() {
        print("Commands:");
        print("roll: Enter dice to Roll in the form: [x]d[y]. E.g: 'roll 4d6' would roll 4 six sided dice.");
        print("check: Check the rolling data for a specific die. E.g: 'check d8' would show the results that have been " +
                "produced by the 8 sided die.");
        print("help: Show this help screen.");
        print("stop: Shut down the program.");
    }

    private void print(String s){
        System.out.println(s);
    }

}
