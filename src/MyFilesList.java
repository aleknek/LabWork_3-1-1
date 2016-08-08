import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyFilesList {

    public List<String> findFiles(String dir) throws FileNotFoundException {
        List<String> listFileNames = new ArrayList<>();
        findFilesAll(dir, listFileNames);
        return listFileNames;
    }

    public List<String> findFilesAll(String dir, List<String> listFileNames) throws FileNotFoundException {

        File file = new File(dir);

        if (!file.exists()) {
            throw new FileNotFoundException("ERROR: File not found");
        }

        for (File s : file.listFiles()) {
            if (s.isFile()) {
                listFileNames.add(s.getName());
            } else if (s.isDirectory()) {
                findFilesAll(s.getAbsolutePath(), listFileNames);
            }
        }

        return listFileNames;
    }

    public void printListFiles(String[] stringPath) {

        for (int i = 0; i < stringPath.length; i++) {

            String dir = stringPath[i];
            try {

                List listFileNames = findFiles(dir);
                Iterator<String> iterator = listFileNames.iterator();

                while (iterator.hasNext()) {
                    System.out.println(dir + "\\" + iterator.next());
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}



