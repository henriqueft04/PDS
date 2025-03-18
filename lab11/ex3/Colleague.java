public class Colleague {
    static int idCount = 0;
    private int id;
    private Mediator mediator;

    Colleague(Mediator mediator) {
        this.mediator = mediator;
        mediator.addColleague(this);
        this.id = idCount++;
    }

    public int getId() {
        return id;
    }

    public void sendMessage() {
        mediator.broadcast(id, "Hello, I'm " + id);
    }

    public void sendMessage(int to) {
        mediator.send_to(to, id, "Hello " + to + ", I'm " + id);
    }
    
    public void receiveMessage(int from, String message) {
        System.out.println("[" + id + "] Message received from " + from + ":\t" + message);
    }
}
