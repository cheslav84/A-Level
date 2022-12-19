package com.havryliuk.repository;

public interface CarRepository<T, C> {

    public void save(T car);

    public T[] getAll();

    public T getById(String id);

    public void delete(String id);

    public void insert(int index, T car);

    public void updateColor(String id, final C color);


}
