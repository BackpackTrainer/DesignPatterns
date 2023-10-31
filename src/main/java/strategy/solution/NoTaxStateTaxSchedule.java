package strategy.solution;

public class NoTaxStateTaxSchedule implements StateTaxSchedule {
    @Override
    public double calculateStateTaxes(double periodPay, int payFrequency) {
        return 0;
    }
}
