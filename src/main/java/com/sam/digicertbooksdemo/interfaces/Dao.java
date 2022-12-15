package com.sam.digicertbooksdemo.interfaces;

import java.util.Collection;

public interface Dao<T> {
    T get(Integer id);
    Collection<T> getAll();
    T create(T t);
    void update(T t);
    void delete(Integer id);
}
