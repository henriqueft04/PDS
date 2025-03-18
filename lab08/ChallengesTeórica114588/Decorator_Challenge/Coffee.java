class Coffee implements CoffeeInterface{
    private String decorations;

    public Coffee(){
        decorations = "";
    }

    public void decorate (String decoration){
        decorations += decoration;
    }

    public void drink(){
        System.out.println("Drinking coffee with " + decorations);
    }
}
