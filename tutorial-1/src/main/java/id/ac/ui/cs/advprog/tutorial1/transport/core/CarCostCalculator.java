package id.ac.ui.cs.advprog.tutorial1.transport.core;

import id.ac.ui.cs.advprog.tutorial1.transport.exceptions.InvalidDistanceException;

public class CarCostCalculator implements TransportCostCalculator {
    @Override
    public Cost getCosts(Double distanceInKm) {
        // TODO: implement method
        try{
            assertWithinDistanceLimit(distanceInKm);
        }catch (InvalidDistanceException err){
            return null;
        }

        double fee = getTransportFare(distanceInKm);

        double time = getTransportTimeInHour(distanceInKm);

        int satisfaction = getTransportSatisfaction(distanceInKm);

        return new Cost(fee, time, satisfaction);
    }
    
    @Override
    public Double getTransportTimeInHour(Double distanceInKm) {
        // TODO: implement method
        double time = distanceInKm / 30;
        return time;
    }

    @Override
    public Double getTransportFare(Double distanceInKm) {
        // TODO: implement method
        double fare = 10000;
        if (distanceInKm < 2){
            return fare;
        }

        for (int i = 0; i < (distanceInKm - 2); i++){
            fare += 3500;
        }

        return fare;
    }

    @Override
    public Integer getTransportSatisfaction(Double distanceInKm) {
        // TODO: implement method
        int satisfaction = 10;

        if (distanceInKm > 5){
            int temp = (int)(distanceInKm/5);
            satisfaction -= temp;
        }

        if (satisfaction <= 1){
            satisfaction = 1;
        }

        return satisfaction;
    }

    private void assertWithinDistanceLimit(Double distanceInKm){
        // TODO: implement method, throws InvalidDistanceException if requirements are not met
        if (distanceInKm > 50){
            throw new InvalidDistanceException();
        }
    }
}
