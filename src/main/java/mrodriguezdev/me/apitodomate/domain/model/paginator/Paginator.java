package mrodriguezdev.me.apitodomate.domain.model.paginator;

import java.util.List;

public class Paginator<T> {
    public List<T> items;
    public Integer pageSize;
    public Integer currentPage;

    public Paginator() {
    }
}
