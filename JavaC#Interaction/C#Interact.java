import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException {
        for(int i = 0; ; i++) {
            System.out.println("Waiting for file... \n\n");
            final File file = new File("C:\\temp\\JavaC#\\README" + i + ".txt");

            //noinspection StatementWithEmptyBody
            while (!file.exists()) ;
            System.out.println(Files.readString(file.toPath()));
        }
    }
}
