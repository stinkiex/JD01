package DB;

public class Bentley {
public static void main(String[] args) {

}
public static void bentleyCar(String[] args) {
        IDriver D2 = new Driver("Наталья", 2, "B", true);
        Wheel W2 = new Wheel(19, "Лето", "Michelin");
        Motor M2 = new Motor("Бензин", "АИ-95", 3.2);
        Car C2  = new Car("Bentley", "B", 3);
        System.out.print("Автомобиль марки "+ C2.getCarName()+" с двигателем объёмом "+M2.getVolume() +  "литров. тип двигателя: " + M2.getMname());
        System.out.println(" "+ M2.getFuel() +" категории "+C2.getCatLicense());
        System.out.println("c Колёсами марки "+W2.getWhName()+" радиуса R"+W2.getRadius()+" сезон: "+W2.getSeason());
        System.out.print("Водитель "+ ((Driver) D2).getDriverName() + " с водительским удостоверением категории "+((Driver) D2).getDriveLicense());
        System.out.println(" и стажем вождения "+((Driver) D2).getDriveTime() + " лет");

    D2.openCar();
    D2.closeCar();
    D2.driveCar();
    D2.takePeople();
    D2.takeFuel();


    }

}
