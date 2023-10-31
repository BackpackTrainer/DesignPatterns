package strategy.solution;

import templatemethodpattern.Address;

import java.time.LocalDate;

public  abstract class Employee {
    String name;
    Address address;
    LocalDate birthday;
    double payRate;
    UnionDuesStrategy myUnionDuesStrategy = new NoUnionDuesStrategy();
    double yearToDateEarnings = 0;
    final int payFrequency;

    public Employee(int payFrequency) {
        this.payFrequency = payFrequency;
    }

    public double computeNetPay() {
        FederalTaxSchedule federalTaxSchedule = new FederalTaxSchedule();
        StateTaxSchedule stateTaxSchedule = StateTaxFinder.getStateTaxSchedule(address);
        SocialSecurityTaxSchedule socialSecurityTaxSchedule = new SocialSecurityTaxSchedule();

        double periodPay = 0;
        double annualPay = 0;
        double netPay = 0;

        periodPay = getPeriodPay(periodPay);
        annualPay = periodPay*payFrequency;

        double federalTaxes = federalTaxSchedule.getFederalTax(annualPay, payFrequency);
        double stateTaxes = stateTaxSchedule.calculateStateTaxes(periodPay, payFrequency);
        double socialSecurityTaxes = socialSecurityTaxSchedule.calculateSocialSecurityTaxes(periodPay, payFrequency, yearToDateEarnings);
        double unionDues = calculateUnionDues(periodPay);

        netPay = periodPay - federalTaxes - stateTaxes - socialSecurityTaxes - unionDues;

        transferFunds(netPay);
        yearToDateEarnings += periodPay;

        return netPay;
    }

    private double calculateUnionDues(double periodPay) {
        return myUnionDuesStrategy.calculateUnionDues(periodPay);
    }

    protected abstract double getPeriodPay(double periodPay);

    protected void transferFunds(double netPay) {
        //code here that does the transferring
        //We should probably move this to another class!
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public double getPayRate() {
        return payRate;
    }

    public UnionDuesStrategy getMyUnionDuesStrategy() {
        return myUnionDuesStrategy;
    }

    public void setMyUnionDuesStrategy(UnionDuesStrategy myUnionDuesStrategy) {
        this.myUnionDuesStrategy = myUnionDuesStrategy;
    }
}
