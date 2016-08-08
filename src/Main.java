import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] stringPath = {new File("").getAbsolutePath()};
        if (args.length > 0) {
            stringPath = args;
        }

        MyFilesList myFilesList = new MyFilesList();

        for (int i = 0; i < stringPath.length; i++) {

            String dir = stringPath[i];
            try {

                List listFileNames = myFilesList.findFiles(dir);
                Iterator<String> iterator = listFileNames.iterator();

                while (iterator.hasNext()) {
                    System.out.println(dir + "\\" + iterator.next());
                }

            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
