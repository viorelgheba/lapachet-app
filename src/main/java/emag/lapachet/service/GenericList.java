package emag.lapachet.service;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T>
{
    private List<T> list;

    GenericList() {
        this.list = new ArrayList<T>();
    }

    void addElement(T t) {
        this.list.add(t);
    }

    public List<T> getList() {
        return list;
    }
}
