import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }


    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String roadDir, GameProgress save) {
        try (FileOutputStream fos = new FileOutputStream(roadDir);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(save);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void zipFile(String roadZip, List<String> roadFile) {

        int i = 0;

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(roadZip))) {
            for (String rd : roadFile) {
                try (FileInputStream fis = new FileInputStream(rd)) {
                    i++;
                    ZipEntry entry = new ZipEntry("gamesave" + i);
                    zout.putNextEntry(entry);
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    zout.write(bytes);
                    zout.closeEntry();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}

