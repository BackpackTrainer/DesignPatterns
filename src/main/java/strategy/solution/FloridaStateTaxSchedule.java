package strategy.solution;

public class FloridaStateTaxSchedule implements StateTaxSchedule {
    @Override
    public double calculateStateTaxes(double periodPay, int payFrequency) {
        return 0.03*periodPay/payFrequency;
    }
}
