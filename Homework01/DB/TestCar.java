package DB;

public class TestCar {
public static void main(String[] args) {

}
public static void testCar() {
        IDriver D1 = new Driver("Андрей", 5, "B,C", true);
        Wheel W1 = new Wheel(21, "Зима", "Michelin");
        Motor M1 = new Motor("Бензин", "АИ-95", 3.6);
        Car C1  = new Car("Porsche", "B", 5);
        System.out.print("Автомобиль марки "+ C1.getCarName()+" с двигателем объёмом "+M1.getVolume() +  "литров. тип двигателя: " + M1.getMname());
        System.out.println(" "+ M1.getFuel() +" категории "+C1.getCatLicense());
        System.out.println("c Колёсами марки "+W1.getWhName()+" радиуса R"+W1.getRadius()+" сезон: "+W1.getSeason());
        System.out.print("Водитель "+ ((Driver) D1).getDriverName() + " с водительским удостоверением категории "+((Driver) D1).getDriveLicense());
        System.out.println(" и стажем вождения "+((Driver) D1).getDriveTime() + " лет");

    D1.openCar();
    D1.closeCar();
    D1.driveCar();
    D1.takePeople();
    D1.takeFuel();


    }
}
