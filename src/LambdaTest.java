import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yangyou on 2018/9/12.
 */
public class LambdaTest {
    public static void main(String[] args) throws IOException {
        printFile(a -> a.readLine() + '\n' + a.readLine());
    }
    public  static void process(Runnable r) {
        r.run();
    }

    public static void printFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("practice.iml"))) {
            System.out.println(br.readLine());
        }
    }

    public static void printFile(BufferReaderProcessor brp) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("practice.iml"))) {
            System.out.println(brp.process(br));
        }
    }

}
