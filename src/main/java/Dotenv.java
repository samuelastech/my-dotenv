import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dotenv {
    private static Map<String, Object> variables = new HashMap<>();

    public static Object get(String key) {
        return Dotenv.variables.get(key);
    }

    public static void load() {
        Dotenv.load(".env");
    }

    public static void load(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("=")) {
                    String[] parts = line.split("=");
                    Dotenv.variables.put(parts[0], parts[1]);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
