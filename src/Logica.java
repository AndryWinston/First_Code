import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logica {
        private static final List<Character> chars = new ArrayList<>();
        public int getScore;

        public static int getScore() {
                String fileName = "E:\\Programs\\Projects\\Caesar\\Code\\text.txt";
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                        int i;
                        while ((i = reader.read()) != -1) {
                                chars.add((char) i);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return chars.size();
        }
}

// затем помещать каждый символ в массив с размером = количеству символов,
// затем перезаписывать в новый массив сравнивая с алфавитом,с размером = количеству символов
// записывать в writer и создавать новый файл
