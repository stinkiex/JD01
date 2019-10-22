import java.util.Collection;
import java.util.List;

public class Filter<T extends Phones> {
    private List<T> list;
    private T filter;

    public Filter(List<T> list, T filter){
        this.list=list;
        this.filter=filter;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }
    public static List<Phones> filter(Collection<?> collection, int filter){
        Collection<Phones> coll2;
        for(int i=0; i<collection.size();i++){
            if (!collection.contains(filter)){
                collection.remove(i);
            }
        }
        return (List<Phones>) collection;
    }
}
