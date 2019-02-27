import java.util.Scanner;
import javafx.util.Pair;
import Handlers.*;
import org.json.JSONException;

public class Main {

    private static Scanner scanner    = new Scanner(System.in);
    private static boolean isFinished = false;

    private static Pair<String, String> parseNextCommand(String line) {
        int spacePos = line.indexOf(" ");
        return new Pair<>(line.substring(0, spacePos), line.substring(spacePos));
    }

    public static void main (String[] args) throws JSONException {
        UserHandler.init();
        ProjectHandler.init();
        BidHandler.init();


        while(!isFinished) {
            String line = scanner.nextLine();
            Pair<String, String> command = parseNextCommand(line);

            switch (command.getKey()) {
                case "register":
                    UserHandler.addNewUser(command.getValue());
                    break;

                case "addProject":
                    ProjectHandler.addNewProject(command.getValue());
                    break;

                case "bid":
                    BidHandler.addNewBid(command.getValue());
                    break;

                case "auction":
                    BidHandler.auction(command.getValue());
                    isFinished = true;
                    break;
            }

        }
    }
}
