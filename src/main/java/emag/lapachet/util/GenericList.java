package emag.lapachet.util;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T>
{
    private List<T> list;

    public GenericList() {
        this.list = new ArrayList<T>();
    }

    public void addElement(T t) {
        this.list.add(t);
    }

    public List<T> getList() {
        return list;
    }
}
