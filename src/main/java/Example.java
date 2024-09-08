public class Example {
    public static void main(String[] args) {
        Dotenv.load();
        String test = (String) Dotenv.get("TEST");
        System.out.println(test);
    }
}
