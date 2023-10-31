package strategy.solution;

public class SocialSecurityTaxSchedule {
    double annualMaxTaxableEarnings = 168000;
    public double calculateSocialSecurityTaxes(double periodPay, int payFrequency, double yearToDateEarnings) {
       double socialSecurityTaxes = 0;
        if (yearToDateEarnings <= annualMaxTaxableEarnings) {
            socialSecurityTaxes = .15*periodPay/payFrequency;
        }
    return socialSecurityTaxes;
    }
}
