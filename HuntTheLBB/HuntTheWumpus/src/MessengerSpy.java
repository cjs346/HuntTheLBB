public class MessengerSpy implements IMessenger {
    @Override
    public String reportArrows(int arrows) {
        return String.valueOf(arrows);
    }

	@Override
	public String reportLossMessage(String reason) {
		return reason;
	}

	@Override
	public String reportWinMessage(String reason) {
		return reason;
	}
}
