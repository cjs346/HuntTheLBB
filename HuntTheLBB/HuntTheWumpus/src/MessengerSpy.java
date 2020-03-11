public class MessengerSpy implements IMessenger {
    @Override
    public String reportArrows(int arrows) {
        return String.valueOf(arrows);
    }
}
