public class Main {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        Colleague c1 = new Colleague(mediator);
        Colleague c2 = new Colleague(mediator);
        Colleague c3 = new Colleague(mediator);

        mediator.addColleague(c1);
        mediator.addColleague(c2);
        mediator.addColleague(c3);
        
        c1.sendMessage();
        c2.sendMessage();
        c1.sendMessage(c3.getId());
        c3.sendMessage(c1.getId());

    }
}
