public class App {
    private Client client;
    private ConsoleEventLogger logger;

    public static void main(String[] args) {
        App app = new App();
        app.logger = new ConsoleEventLogger();
        app.client = new Client(100, "Alex");

        app.logEvent("Message for user 100");
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(
                String.valueOf(client.getId()), client.getName()
        );
        logger.logEvent(message);
    }
}
