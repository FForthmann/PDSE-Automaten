import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.gamelogic.Game;
import de.nordakademie.pdse.grid.IGrid;

import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        ConfigReader configReader;
        File file;

        if (args.length != 0) {
            file = new File(args[0]);
        } else {
            file = new File("src/main/resources/config.properties");
        }

        configReader = new ConfigReader(file);
        Game game = new Game(configReader);
        game.run();

    }
}

