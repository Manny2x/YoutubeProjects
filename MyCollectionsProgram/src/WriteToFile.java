import java.nio.channels.*;
import java.nio.*;
import java.io.*;
import java.nio.file.*;
public class WriteToFile{
    public static void main(String[]args) throws IOException {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        char[] chars = br.readLine().toCharArray();


        try(FileChannel fileChannel =
                    (FileChannel)
                Files.newByteChannel(
                        Path.of("C:\\Users\\Emman\\writto.txt"),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.WRITE
                )){
            ByteBuffer byteBuffer =
                    ByteBuffer.allocate(chars.length);

            for(int x = 0; x < chars.length; x++){
                byteBuffer.put((byte) chars[x]);
            }

            byteBuffer.rewind();

            fileChannel.write(byteBuffer);
            System.out.println("File successfully created and written to");
        }catch(InvalidPathException | IOException e) {
            e.printStackTrace();

            System.exit(1);
        }
    }
}
