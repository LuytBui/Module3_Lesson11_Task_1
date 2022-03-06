package com.codegym.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> getList();
    T findByID(int id);
    boolean remove(T element);
    boolean add(T element);
    boolean edit(T oldElement, T newElement);
}
