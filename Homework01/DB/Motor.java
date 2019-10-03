package DB;

public class Motor {
    private String mName, fuel;
    private double volume;

    public Motor(String mName, String fuel, double volume){
        this.mName=mName;
        this.fuel=fuel;
        this.volume=volume;
    }



    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getMname() {
            return mName;
    }

    public void setMname(String mName) {
        this.mName = mName;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
