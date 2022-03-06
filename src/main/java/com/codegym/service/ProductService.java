package com.codegym.service;

import com.codegym.model.com.codegym.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IGeneralService<Product>{
    static private List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "Cocacola lon 330ml", 11000, "Lạnh"));
        list.add(new Product(2, "Pepsi lon 330ml", 12000, "Lạnh"));
        list.add(new Product(3, "Kitkat candy bar", 17000, ""));
        list.add(new Product(4, "Milo milk paper box", 8000, "Lạnh"));
    }

    @Override
    public List<Product> getList() {
        return this.list;
    }

    @Override
    public Product findByID(int id) {
        Product result = null;
        for (Product product : this.list) {
            if (product.getId() == id) {
                result = product;
            }
        }
        return result;
    }

    @Override
    public boolean remove(Product element) {
        return list.remove(element);
    }

    @Override
    public boolean add(Product element) {
        return list.add(element);
    }

    @Override
    public boolean edit(Product oldElement, Product newElement) {
        int index = list.indexOf(oldElement);
        if (index == -1)
            return false;
        list.set(index, newElement);
        return true;
    }
}
