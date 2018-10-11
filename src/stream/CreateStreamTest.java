package stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by yangyou on 2018/10/10.
 */
public class CreateStreamTest {
    public static void main(String[] args) {
        createStreamByValues();
        createStreamByArrays();
        createStreamByFiles();
        createStreamByFiles();
    }

    public static void createStreamByValues() {
        Stream<String> stringStream = Stream.of("hafds", "dswooo", "exception");
        stringStream.map(String::toUpperCase).forEach(System.out::println);
    }

    public static void createStreamByArrays() {
        int[] ints = {1, 34, 32323, 1, 392};
        int sum = Arrays.stream(ints).sum();
        System.out.println(sum);
    }

    public static void createStreamByFiles() {
//        System.out.println(Paths.get("data.txt"));
        long countWords = 0;
//        绝对路径
        Path    path = Paths.get("F:\\tmp\\data.txt");
//        相对路径
        Path path2 = Paths.get("F:\\tmp\\", "data.txt");

        try(Stream<String> lines = Files.lines(path2, Charset.defaultCharset())) {
            countWords = lines.flatMap(a -> Arrays.stream(a.split(""))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(countWords);
    }

}
