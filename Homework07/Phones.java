import annotation.Version;

@Version(value = "1.1.1")
public class Phones implements Comparable<Phones> {
    private String vendor;
    private String model;
    private int year;

    @Version(value = "1.0.0")
    public Phones(String vendor, String model, int year){
        this.vendor=vendor;
        this.model=model;
        this.year=year;

    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Phones{" +
                "vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }


    public int compareTo(Phones o) {
        int result = this.vendor.compareTo(o.vendor);
        if (result == 0) {
            result = this.model.compareTo(o.model);
        }
        return result;
        }
}


