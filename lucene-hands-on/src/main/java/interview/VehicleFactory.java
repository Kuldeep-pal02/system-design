package interview;

public class VehicleFactory {

    public static Vehicle getVehicleInstance( String type){

        switch ( type){
            case "CAR":
                return new Car();
            case "TRUCK":
                return new Truck();
            default:
                //throw exception

        }
        return  null;

    }
}
