import annotation.Version;
import com.IFilter;
import com.Phones;


import java.util.*;

/**
 * Домашнее задание (выполнить до 23.10):
 * 2. Написать дженерик класс FilterApplicator который умеет обрабатывать коллекцию ЛЮБЫХ элементов
 * будет иметь следующие методы:
 *  2.1. статический метод filter. У метода filter будет два параметра.
 *  [1] коллекция в которой будет происходить фильтрация,
 *  2 класс который реализует алгоритм фильтрации. И будет возвращать результат фильтрации
 *  [2.2]. статический ДЖЕНЕРИК МЕТОД sort который будет принимать 1 параметр
 *  коллекцию элементов реализующих интерфейс Comparable. И будет возвращать результат сортировки
 *
 */
@Version(value = "1.2.3")
public class FilterApplicator<T extends Collection, E extends IFilter> {

    public Collection filter(T collection, E param){
        collection= (T) param.filter(collection);
        return collection;
    }

    public static List<Phones> sort (List<Phones> collection){
        collection.sort(Phones::compareTo);
        return collection;
    }
}
