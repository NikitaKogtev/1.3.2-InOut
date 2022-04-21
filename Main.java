import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GameProgress save = new GameProgress(95, 1, 25, 33.2);
        GameProgress save1 = new GameProgress(74, 3, 34, 57.6);
        GameProgress save2 = new GameProgress(32, 6, 55, 89.5);

        String dir = "C://Game//savegames//save1.txt";
        String dir1 = "C://Game//savegames//save2.txt";
        String dir2 = "C://Game//savegames//save3.txt";

        save.saveGame(dir, save);
        save1.saveGame(dir1, save1);
        save2.saveGame(dir2, save2);

        String zip = "C://Game//savegames//saves.zip";

        List<String> dirs = new ArrayList<>();
        dirs.add(dir);
        dirs.add(dir1);
        dirs.add(dir2);

        save.zipFile(zip, dirs);

        File fileDel = new File(dir);
        if (fileDel.delete()) {
            System.out.println("Файл " + fileDel.getName() + " удален");
        }

        File fileDel1 = new File(dir1);
        if (fileDel1.delete()) {
            System.out.println("Файл " + fileDel1.getName() + " удален");
        }

        File fileDel2 = new File(dir2);
        if (fileDel2.delete()) {
            System.out.println("Файл " + fileDel2.getName() + " удален");
        }

    }
}
