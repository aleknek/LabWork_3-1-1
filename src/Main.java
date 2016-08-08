import java.io.File;

public class Main {

    public static void main(String[] args) {

        String[] arrayStringPath = {new File("").getAbsolutePath()};
        if (args.length > 0) {
            arrayStringPath = args;
        }

        MyFilesList myFilesList = new MyFilesList();
        myFilesList.printListFiles(arrayStringPath);

    }
}
