import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.gamelogic.Game;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

/**
 * This class is used to start the program initially. It contains the method getPoints, which creates a user interface for the input of active points.
 *
 * @author Christian Apsel, Rane Petersen
 */
public class Main {
    private ConfigReader configReader;

    public static void main(String[] args) throws Exception {

        Main main = new Main();
        File file;

        if (args.length != 0) {
            file = new File(args[0]);
        } else {
            file = new File("src/main/resources/config.properties");
        }

        main.configReader = new ConfigReader(file);
        Game game = new Game(main.configReader);
        main.setPoints(game);
        game.run();

    }

    private void setPoints(Game game) {
        String run = "";
        Scanner scanner = new Scanner(System.in);
        while (!run.equalsIgnoreCase("run")) {
            System.out.println("Bitte geben Sie aktive Punkte ein: X,Y / Bitte geben Sie run zum starten des Programms ein");
            String temp = scanner.next();
            if (temp.contains(",")) {
                String[] s = temp.split(",");
                if (s.length == 2 && Integer.parseInt(s[0]) < configReader.getGridLength() && Integer.parseInt(s[1]) < configReader.getGridWidth()) {
                    {
                        game.getGird().setValue(new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1])), true);
                    }
                }
            } else if (temp.equalsIgnoreCase("run")) {
                run = "run";
            } else {
                System.out.println("falsche Eingabe");
            }
        }
    }
}
