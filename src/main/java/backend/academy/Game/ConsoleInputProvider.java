package backend.academy.Game;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String getInput(String message) {
        System.out.print(message + " ");
        return scanner.nextLine().toUpperCase();
    }
}
