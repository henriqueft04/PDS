public interface Mediator {
    public void broadcast(int senderId, String message);
    public void send_to(int destination, int senderId, String message);
    public void addColleague(Colleague colleague);
}