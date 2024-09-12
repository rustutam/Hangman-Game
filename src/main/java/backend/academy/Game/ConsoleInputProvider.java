package backend.academy.Game;

public class ConsoleInputProvider implements InputProvider {
    @Override
    public String getInput() {
        System.out.println("Введите букву: ");
        return System.console().readLine();
    }
}
