package strategy.solution;

public class FederalTaxSchedule {
    public double getFederalTax(double annualPay, int payFrequency) {
        double federalTaxes = 0;
        if (annualPay < 25000 ) {
            federalTaxes = .14* annualPay / payFrequency;
        }
        else if(annualPay >= 25000 && annualPay < 50000) {
            federalTaxes = (3500 + (annualPay - 25000)*.24)/ payFrequency;
        }
        else if(annualPay >= 50000) {
            federalTaxes = (9500 + (annualPay - 50000)*.36)/ payFrequency;
        }
        return federalTaxes;
    }
}
