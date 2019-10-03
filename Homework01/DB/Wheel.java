package DB;

public class Wheel {
    private int radius;
    private String season, whName;

    public Wheel(int radius, String season, String whName){
        this.radius=radius;
        this.season=season;
        this.whName=whName;
        }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }
}
