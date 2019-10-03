package DB;

public class Driver implements IDriver {
    private int driveTime;
    private String driverName, driveLicense, sKey;
    private boolean carKey;

    public Driver(String driverName, int driveTime, String driveLicense, boolean carKey){
        this.driverName=driverName;
        this.driveTime=driveTime;
        this.driveLicense=driveLicense;
        this.carKey=carKey;
        //this.sKey=sKey;
    }

    public void openCar(){
        System.out.println(driverName + " октрывает машину");
    }

    public void closeCar(){
        System.out.println(driverName + " закрывает машину");
    }

    public void driveCar(){
        System.out.println(driverName + " управляет автомобилем");
    }

    public void takePeople(){
        System.out.println(driverName + " подбирает пассажиров");
    }

    public void takeFuel(){
        System.out.println(driverName + " заправляет автомобиль топливом");
    }

    public int getDriveTime() {
        return driveTime;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriveLicense() {
        return driveLicense;
    }

    public boolean getCarKey() {
        return carKey;
    }

    public String haveKey(String s){
        carKey=carKey;
        if (carKey==true)
         s= " имеет ";
         else sKey = "не  имеет ";
         return sKey;
    }
}
