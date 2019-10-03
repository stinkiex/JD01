package DB;

public class Tesla {
public static void main(String[] args) {

}
public static void tesla() {
        IDriver D3 = new Driver("Дарья", 2, "B", false);
        Wheel W3 = new Wheel(18, "Всесезонные", "Белшина");
        Motor M3 = new Motor("Гибрид", "нет", 0);
        Car C3  = new Car("Tesla", "B", 4);
        System.out.print("Автомобиль марки "+ C3.getCarName()+" с двигателем объёмом "+M3.getVolume() +  "литров. тип двигателя: " + M3.getMname());
        System.out.println(" "+ M3.getFuel() +" категории "+C3.getCatLicense());
        System.out.println("c Колёсами марки "+W3.getWhName()+" радиуса R"+W3.getRadius()+" сезон: "+W3.getSeason());
        System.out.print("Водитель "+ ((Driver) D3).getDriverName() + " с водительским удостоверением категории "+((Driver) D3).getDriveLicense());
        System.out.println(" и стажем вождения "+((Driver) D3).getDriveTime() + " лет");

    D3.openCar();
    D3.closeCar();
    D3.driveCar();
    D3.takePeople();
    D3.takeFuel();


    }

    public static void bentley() {
    }
}
