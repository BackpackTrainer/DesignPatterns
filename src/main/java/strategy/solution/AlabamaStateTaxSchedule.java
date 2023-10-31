package strategy.solution;

public class AlabamaStateTaxSchedule implements StateTaxSchedule {
    @Override
    public double calculateStateTaxes(double periodPay, int payFrequency) {
        return 0.05*periodPay/payFrequency;
    }
}
