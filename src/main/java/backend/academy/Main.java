package backend.academy;

import backend.academy.Game.App;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        App app = new App(System.in, System.out);
        app.start();
    }
}

