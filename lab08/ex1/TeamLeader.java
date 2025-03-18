package ex1;

public class TeamLeader extends EmployeeDecorator{
    private String teamName;
    
    public TeamLeader(EmployeeInterface employee, String teamName) {
        super(employee);
        this.teamName = teamName;
        if (!employee.getRoles().contains("Team Leader")) {
            employee.addRole("Team Leader");
        }
    }
    
    public void work() {
        System.out.println("Team Leader " + getName() + " is working in team " + teamName);
    }

    public void plan(){
        System.out.println("Team Leader " + getName() + " is planning for team " + teamName);
    }

    public String toString() {
        return super.toString() + " | Team Leader of: " + teamName + "\n";
    }
} 
    

