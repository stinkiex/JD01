package dto;

public abstract class Computer implements IComputer {

    private Ram ram;
    private Hdd hdd;


    public Computer(Ram ram, Hdd hdd)
    {
        this.ram = ram;
        this.hdd = hdd;
    }
    public void on() {
        System.out.println("On");
    }

    public void off() {
        System.out.println("off");
    }

    public void reset() {
        System.out.println("reset");
    }

    public abstract void work();

    public Ram getRam() {
        return ram;
    }

    public Hdd getHdd() {
        return hdd;
    }

}
