import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MyFilesList {

    public List<String> findFiles(String dir) throws NullPointerException, FileNotFoundException {
        List<String> listFileNames = new ArrayList<>();
        findFilesAll(dir, listFileNames);
        return listFileNames;
    }

    public List<String> findFilesAll(String dir, List<String> listFileNames)
            throws NullPointerException, FileNotFoundException {

        File file = new File(dir);

        if (dir == null) {
            throw new NullPointerException("ERROR: Parameter 'dir' is empty...");
        }

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
}



