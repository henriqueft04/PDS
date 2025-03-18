package ex1;

public class TeamMember extends EmployeeDecorator{
    private String teamName;
    
    public TeamMember(EmployeeInterface employee, String teamName) {
        super(employee);
        this.teamName = teamName;
        if (!employee.getRoles().contains("Team Member")) {
            employee.addRole("Team Member");
        }
    }
    
    public void work() {
        System.out.println("Team Member " + getName() + " is working in team " + teamName);
    }

    public void coloborate(){
        System.out.println("Team Member " + getName() + " is coloborating with team " + teamName);
    }

    public String toString() {
        return super.toString() + " | Team Member of: " + teamName + "\n";
    }
}
