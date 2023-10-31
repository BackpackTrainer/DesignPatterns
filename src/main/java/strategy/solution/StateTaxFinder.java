package strategy.solution;

import templatemethodpattern.Address;

public class StateTaxFinder {
    public static StateTaxSchedule getStateTaxSchedule(Address address) {
        String state = address.getState();
        StateTaxSchedule stateTaxSchedule;

        switch (state) {
            case "AL" -> {
                stateTaxSchedule = new AlabamaStateTaxSchedule();
            }

            case "CA" -> {
                stateTaxSchedule = new CaliforniaStateTaxSchedule();
            }

            case "FL" -> {
                stateTaxSchedule = new FloridaStateTaxSchedule();
            }
            default -> {
                stateTaxSchedule = new NoTaxStateTaxSchedule();
            }
        }
        return stateTaxSchedule;
    }
}
