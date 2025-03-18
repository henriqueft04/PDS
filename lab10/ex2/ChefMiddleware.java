package ex2;

public abstract class ChefMiddleware {

    private FoodType suportedFoodType;
    private ChefMiddleware next;

    public ChefMiddleware(FoodType suportedFoodType) {
        this.suportedFoodType = suportedFoodType;
    }

    public static ChefMiddleware link(ChefMiddleware first, ChefMiddleware... chain){
        ChefMiddleware head = first;
        for (ChefMiddleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public void handleOrder(FoodItem item) {
        if (item.getType() == suportedFoodType) {
            cook(item);
        } else if (next != null) {
            System.out.println(this.toString() + ": I can't cook that.");
            next.handleOrder(item);
        } else {
            System.out.println(this.toString() + ": I can't cook that.");
            System.out.println("We're sorry but that request can't be satisfied by our service!\n");
        }
    }   

    private void cook(FoodItem item) {
        System.out.println(this.toString() + ": Starting to cook a " + item.toString() + ". Out in " + item.getTimeToCook() + " minutes!\n");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(suportedFoodType.toString());
        sb.append("Chef");
        
        return sb.toString();
    }
}
