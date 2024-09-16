package backend.academy.Game;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {
    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleInputProvider(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    @Override
    public String getInput(String message) {
        out.print(message + " ");
        return scanner.nextLine().toUpperCase();
    }
}
