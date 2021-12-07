import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner (System.in);

    public static void main(String[] args) {
        Main main = new Main();

        main.go();
    }

    public void go() {
        PlayerStateModel player = new PlayerStateModel();
    }

    public void printMenu(String [] menu) {
        String [] formattedMenu = formatMenu (menu);

        for (int i = 0; i < formattedMenu.length; i++) {
            if (formattedMenu[i] != null)
                System.out.println ("" + i + ") " + formattedMenu[i]);
        }
    }

    public String [] formatMenu(String [] menu) {
        int maxLength = 0;

        for (String item : menu)
            if (item != null && item.length() > maxLength)
                maxLength = item.length();

        String [] formattedMenu = new String [menu.length];

        for (int i = 0; i < formattedMenu.length; i++)
            if (menu[i] != null)
                formattedMenu [i] = formatString (menu[i], maxLength-menu[i].length());

        return formattedMenu;
    }

    public String formatString(String item, int spacesToAdd) {
        if (spacesToAdd == 0)
            return item;

        return formatString (" " + item, spacesToAdd - 1);
    }

    public int getInt(int low, int high) {
        int result = low - 1;

        while (result < low || result > high) {
            while (! input.hasNextInt())
                input.nextLine();

            result = input.nextInt ();
            input.nextLine ();
        }

        return result;
    }

    public void saveGame(PlayerStateModel player) {
        String saveState = player.saveModel();
        PrintWriter file;
        try {
            file = new PrintWriter ("save.dat");
            file.println(saveState);
            file.close ();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean loadGame(PlayerStateModel model) {
        try {
            Scanner file = new Scanner (new File("save.dat"));
            model.loadModel(file.nextLine());
            file.close ();
            return true;
        }
        catch (FileNotFoundException e) {
            return false;
        }
    }
}