import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Frog_Pryg_Skok frog = new Frog_Pryg_Skok();
        List<FrogCommand> commands = new ArrayList<>();
        String value;
        int curCommand = -1;
        System.out.println("Лягушка\n" +
                "+N - прыгни на N шагов направо\n" +
                "-N - прыгни на N шагов налево\n" +
                "<< - Undo (отмени последнюю команду)\n" +
                ">> - Redo (повтори отменённую команду)\n" +
                "!! - повтори последнюю команду\n" +
                "0 - выход");
        while (true) {
            value = reader.readLine();
            switch (value) {
                case "0":
                    return;
                case "<<":
                    if (curCommand < 0) {
                        System.out.println("Нечего отменять!");
                    } else {
                        commands.get(curCommand).undoCommand();
                        curCommand--;
                    }
                    break;
                case ">>":
                    if (curCommand == commands.size() - 1) {
                        System.out.println("Нечего отменять!");
                    } else {
                        curCommand++;
                        commands.get(curCommand).doCommand();
                    }
                    break;
                case "!!":
                    if (curCommand == -1) {
                        System.out.println("Нечего повторять");
                    } else {
                        if (commands.get(curCommand).doCommand()) {
                            commands.add(commands.get(curCommand));
                            curCommand++;
                        } else {
                            System.out.println("лягушка не прыгала");
                        }
                    }
                    break;
                default:
                    if (curCommand != commands.size() - 1) {
                        for (int i = curCommand + 1; i < commands.size(); i++) {
                            commands.remove(i);
                        }
                    } else {
                        if (value.startsWith("+")) {
                            value = value.substring(1);
                        }
                        FrogCommand cmd = FrogCommands.jumpCommand(frog, Integer.parseInt(value));
                        curCommand++;
                        commands.add(cmd);
                        cmd.doCommand();
                    }
                    break;
            }
            for (int i = Frog_Pryg_Skok.MIN_POSITION; i < Frog_Pryg_Skok.MAX_POSITION + 1; i++) {
                if (i == frog.getPosition()) {
                    System.out.print("Ж");
                } else System.out.print(".");
            }
            System.out.println("");
        }

    }

}
