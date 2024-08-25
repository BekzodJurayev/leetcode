package sollutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Beautify {
    private static final int BUFFER_SIZE = 1024 * 1024; // 1 MB buffer size
    private static int MAX_LEN = 0;

    public static void main(String[] args) {
        String projectDir = System.getProperty("user.dir");
        Path filePath = Paths.get(projectDir + "/src", "input.txt");

        try (FileChannel fileChannel = FileChannel.open(filePath)) {
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            Charset charset = StandardCharsets.UTF_8;
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = CharBuffer.allocate(BUFFER_SIZE);

            int len = 0;
            while (fileChannel.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    decoder.decode(buffer, charBuffer, false);
                    charBuffer.flip();
                    char[] chars = new char[charBuffer.remaining()];
                    charBuffer.get(chars);
                    charBuffer.clear();

                    for (char c : chars) {
                        if (c != '\n' && c != ' ' && c != ',')
                            len++;
                        else {
                            MAX_LEN = Math.max(len, MAX_LEN);
                            len = 0;
                        }
                    }
                }
                buffer.clear();
            }
            fileChannel.position(0);
            char[] word = new char[MAX_LEN + 2];
            int cursor = 0, lineCursor = 0;
            boolean finished = true;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(projectDir + "/src/output.txt", StandardCharsets.UTF_8))) {
                while (fileChannel.read(buffer) != -1) {
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        decoder.decode(buffer, charBuffer, false);
                        charBuffer.flip();
                        char[] chars = new char[charBuffer.remaining()];
                        charBuffer.get(chars);
                        charBuffer.clear();

                        for (char c : chars) {
                            if (c == '\n') {
                                write(chars, cursor, lineCursor, writer);
                                writer.write(c);
                                return;
                            }
                            if (finished && c != ' ' && c != ',')
                                word[cursor++] = c;
                            else if (c == ',') {
                                word[cursor++] = c;
                                if (lineCursor + cursor != MAX_LEN * 3 && cursor < MAX_LEN * 3)
                                    word[cursor++] = ' ';
                                finished = true;
                                write(word, cursor, lineCursor, writer);
                                lineCursor = lineCursor + cursor > MAX_LEN * 3 ? cursor : lineCursor + cursor;
                                cursor = 0;
                            } else {
                                finished = false;
                            }
                        }
                    }
                    buffer.clear();
                }
            }
        } catch (Exception ignored) {
        }
    }

    private static void write(char[] chars, int cursor, int lineCursor, BufferedWriter writer) throws IOException {
        if (lineCursor + cursor > MAX_LEN * 3)
            writer.write('\n');
        for (int i = 0; i <= cursor; i++) {
            writer.write(chars[i]);
        }
    }
}
