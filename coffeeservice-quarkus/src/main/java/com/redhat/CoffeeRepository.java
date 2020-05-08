package com.redhat;

import java.util.Collection;

import com.redhat.model.Coffee;

public interface CoffeeRepository {
    
    Coffee getCoffee(long id);
    
    Coffee getCoffee(String name);
    
    Collection<Coffee> getCoffees();
}