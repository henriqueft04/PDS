import java.util.HashMap;
import java.util.Map;

public class ChatMediator implements Mediator {
    private Map<Integer,Colleague> colleagues;

    public ChatMediator() {
        colleagues = new HashMap<>();
    }

    public void addColleague(Colleague colleague) {
        colleagues.put(colleague.getId(), colleague);
    }

    public void broadcast(int senderId, String message) {
        for (Integer id : colleagues.keySet()) {
            Colleague colleague = colleagues.get(id);
            if (colleague.getId() != senderId) {
                colleague.receiveMessage(senderId, message);
            }
        }
    }

    public void send_to(int destination, int senderId, String message) {
        Colleague colleague = colleagues.get(destination);
        if (colleague != null) {
            colleague.receiveMessage(senderId, message);
        }
    }
}
