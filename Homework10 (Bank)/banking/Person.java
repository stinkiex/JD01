package banking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable {
    private final String id;
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public Person(String id) {
        this.id = id;
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String nameGenerate(){
        List<String> names = new ArrayList<String>(){{
            add("Аарон");
            add("Абрам");
            add("Аваз");
            add("Августин");
            add("Авраам");
            add("Агап");
            add("Агапит");
            add("Агат");
            add("Агафон");
            add("Адам");
            add("Адриан");
            add("Азамат");
            add("Азат");
            add("Азиз");
            add("Айдар");
            add("Айрат");
            add("Акакий");
            add("Аким");
            add("Алан");
            add("Александр");
            add("Алексей");
            add("Али");
            add("Алик");
            add("Алим");
            add("Алихан");
            add("Алишер");
            add("Алмаз");
            add("Альберт");
            add("Амир");
            add("Амирам");
            add("Анар");
            add("Анастасий");
            add("Анатолий");
            add("Анвар");
            add("Ангел");
            add("Андрей");
            add("Анзор");
            add("Антон");
            add("Анфим");
            add("Арам");
            add("Аристарх");
            add("Аркадий");
            add("Арман");
            add("Армен");
            add("Арсен");
            add("Арсений");
            add("Арслан");
            add("Артём");
            add("Артемий");
            add("Артур");
            add("Архип");
            add("Аскар");
            add("Асхан");
            add("Асхат");
            add("Ахмет");
            add("Ашот");
        }};
        int i = (int) (Math.random()*(names.size()-1));
        name = names.get(i);
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
