import java.util.Scanner;
import javafx.util.Pair;
import Repositories.*;
import org.json.JSONException;

public class Main {

    private static Scanner scanner    = new Scanner(System.in);
    private static boolean isFinished = false;

    private static Pair<String, String> parseNextCommand(String line) {
        int spacePos = line.indexOf(" ");
        return new Pair<>(line.substring(0, spacePos), line.substring(spacePos));
    }

    public static void main (String[] args) throws JSONException {
        UserRepo.init();
        ProjectRepo.init();
        BidRepo.init();


        while(!isFinished) {
            String line = scanner.nextLine();
            Pair<String, String> command = parseNextCommand(line);

            switch (command.getKey()) {
                case "register":
                    UserRepo.addNewUser(command.getValue());
                    break;

                case "addProject":
                    ProjectRepo.addNewProject(command.getValue());
                    break;

                case "bid":
                    BidRepo.addNewBid(command.getValue());
                    break;

                case "auction":
                    BidRepo.auction(command.getValue());
                    isFinished = true;
                    break;
            }

        }
    }
}
