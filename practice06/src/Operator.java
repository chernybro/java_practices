public class Operator implements EmployeePosition {
    private double finalSalary;

    public double getFinalSalary() {
        return finalSalary;
    }

    @Override
    public double getCompanyIncome() {
        return 0;
    }

    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return finalSalary = baseSalary;
    }

}
