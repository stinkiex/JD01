package DB;

public class Car {
private Motor mName, fuel, volume;
private Wheel radius, season, whName;
private String carName, catLicense;
private int seats;

//public Car(String carName, Motor mName, Motor volume, Motor fuel, String catLicense, int seats, Wheel radius, Wheel season, Wheel whName){
public Car(String carName, String catLicense, int seats){    this.carName=carName;
//    this.mName=mName;
//    this.volume=volume;
//    this.fuel=fuel;
    this.catLicense=catLicense;
    this.seats=seats;
//    this.radius=radius;
//    this.season=season;
//    this.whName=whName;
   }
    public String getCarName() {
        return carName;
    }

    public String getCatLicense() {
        return catLicense;
    }

    public int getSeats() {
        return seats;
    }


/*    public Motor getmName() {
        return mName;
    }

    public Motor getFuel() {
        return fuel;
    }

    public Motor getVolume() {
        return volume;
    }

    public Wheel getRadius() {
        return radius;
    }

    public Wheel getSeason() {
        return season;
    }

    public Wheel getWhName() {
        return whName;
    }
*/



}
