import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by yangyou on 2018/9/12.
 */
@FunctionalInterface
public interface BufferReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
