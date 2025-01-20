import controller.UserController;
import service.NotificationService;

public class Main {
    public static void main(String[] args) {
        // Create a single instance of NotificationService
        NotificationService notificationService = new NotificationService();

        // Pass it to the UserController
        UserController controller = new UserController(notificationService);

        // Start processing user interactions
        controller.processUser();
    }
}
