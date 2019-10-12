import com.*;

public class Task2 {
    public static void countries() {
        Country.BELARUS.setCountry(8600000, 207600);
        Country.CHINA.setCountry(1306313800,9596960);
        Country.FRANCE.setHuman(60_656_200);
        Country.FRANCE.setKm(547030);
        Country.GERMANY.setCountry(82431400, 357021);
        Country.ITALY.setCountry(58103000,301230);
        Country.LATVIA.setCountry(3596600,65200);
        Country.MONACO.setCountry(32410,2);
        Country.NORWAY.setCountry(4593000, 324220);
        Country.POLAND.setCountry(38635100, 312685);
        Country.RUSSIA.setCountry(143420300, 17075200);

        System.out.println("Площадь Беларуси "+Country.valueOf("BELARUS").getArea()+", население: "+Country.valueOf("BELARUS").getPeople()+" человек");
        System.out.println("Площадь Китая "+Country.valueOf("CHINA").getArea()+", население: "+Country.valueOf("CHINA").getPeople()+" человек");
        System.out.println("Площадь Франции "+Country.valueOf("FRANCE").getArea()+", население: "+Country.valueOf("FRANCE").getPeople()+" человек");
        System.out.println("Площадь Германии "+Country.valueOf("GERMANY").getArea()+", население: "+Country.valueOf("GERMANY").getPeople()+" человек");
        System.out.println("Площадь Италии "+Country.valueOf("ITALY").getArea()+", население: "+Country.valueOf("ITALY").getPeople()+" человек");
        System.out.println("Площадь Латвии "+Country.valueOf("LATVIA").getArea()+", население: "+Country.valueOf("LATVIA").getPeople()+" человек");
        System.out.println("Площадь Монако "+Country.valueOf("MONACO").getArea()+", население: "+Country.valueOf("MONACO").getPeople()+" человек");
        System.out.println("Площадь Норвегии "+Country.valueOf("NORWAY").getArea()+", население: "+Country.valueOf("NORWAY").getPeople()+" человек");
        System.out.println("Площадь Польши "+Country.valueOf("POLAND").getArea()+", население: "+Country.valueOf("POLAND").getPeople()+" человек");
        System.out.println("Площадь России "+Country.valueOf("RUSSIA").getArea()+", население: "+Country.valueOf("RUSSIA").getPeople()+" человек\n");

        System.out.println("Сравнение valueOf и элемент энума через оператор =="+(Country.valueOf("CHINA")==Country.CHINA));
        //System.out.println("США "+Country.valueOf("USA").getArea()); //Ошибка No enum constant com.Country.USA
    }
}
