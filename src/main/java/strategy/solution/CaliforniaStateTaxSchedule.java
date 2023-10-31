package strategy.solution;

public class CaliforniaStateTaxSchedule implements StateTaxSchedule {
    @Override
    public double calculateStateTaxes(double periodPay, int payFrequency) {
        return 0.10*periodPay/payFrequency;
    }
}
