package dep.src;
public class Individual implements Employee{
        
        private String name;
        private String position;
        
        public Individual(String name, String position){
            this.name = name;
            this.position = position;
        }
        
        public void showDetails(){
            System.out.println("Individual: " + name + ", " + position);
        }
        
        public String getName(){
            return name;
        }
        
        public String getPosition(){
            return position;
        }
        
        public String toString(){
            return "Individual: " + getName() + ", " + getPosition();
        }
}