package id.ac.ui.cs.advprog.tutorial1.transport.core;

import id.ac.ui.cs.advprog.tutorial1.transport.exceptions.InvalidDistanceException;

public class MotorCostCalculator implements TransportCostCalculator {
    @Override
    public Cost getCosts(Double distanceInKm) {
        //TODO: implement method
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
    public Double getTransportFare(Double distanceInKm) {
        //TODO: implement method
        double fare = 5000;
        if (distanceInKm < 2){
            return fare;
        }

        for (int i = 0; i < (distanceInKm - 2); i++){
            fare += 1500;
        }

        return fare;
    }
    
    @Override
    public Double getTransportTimeInHour(Double distanceInKm) {
        //TODO: implement method
        double time = distanceInKm / 40;
        return time;
    }
    
    @Override
    public Integer getTransportSatisfaction(Double distanceInKm) {
        //TODO: implement method
        int satisfaction = 10;

        if (distanceInKm > 10){
            double tempDistance = distanceInKm-10;
            int temp = (int)(tempDistance/10);
            satisfaction -= temp;
        }

        if (satisfaction <= 1){
            satisfaction = 1;
        }

        return satisfaction;
    }
    
    private void assertWithinDistanceLimit(Double distanceInKm){
        //TODO: implement method, throws InvalidDistanceException if requirements are not met
        if (distanceInKm > 25){
            throw new InvalidDistanceException();
        }
    }
}
