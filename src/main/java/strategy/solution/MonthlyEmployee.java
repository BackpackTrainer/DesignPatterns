package strategy.solution;

public class MonthlyEmployee extends Employee {
    private static final int MONTHLY_PAY_FREQUENCY = 12;

    public MonthlyEmployee() {
        super(MONTHLY_PAY_FREQUENCY);
    }

    @Override
    protected int getPayFrequency() {
        return payFrequency;
    }

    @Override
    protected double getPeriodPay(double periodPay) {
        return payRate;
    }

}
