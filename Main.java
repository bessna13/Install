import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        List<File> dir = new ArrayList<>();
        dir.add(new File("C://Games/src"));
        dir.add(new File("C://Games/res"));
        dir.add(new File("C://Games/savegames"));
        dir.add(new File("C://Games/temp"));
        dir.add(new File("C://Games/src/main"));
        dir.add(new File("C://Games/src/test"));
        dir.add(new File("C://Games/res/drawables"));
        dir.add(new File("C://Games/res/vectors"));
        dir.add(new File("C://Games/res/icons"));

        List<File> files = new ArrayList<>();

        files.add(new File("C://Games/src/main", "Main.java"));
        files.add(new File("C://Games/src/main", "Utils.java"));
        files.add(new File("C://Games/temp", "temp.txt"));


        for (File file :
                dir) {
            if (file.mkdir()) {
                log.append("New catalog " + file.getName() + "\n");
            } else log.append("Can not create catalog " + file.getName() + "\n");
        }

        System.out.println(log.toString());


        for (File file1 :
                files) {
            try {
                if (file1.createNewFile())
                    System.out.println("File " + file1.getName());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
        try (FileWriter writer = new FileWriter("C://Games/temp/temp.txt", false)) {
            writer.write(log.toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
