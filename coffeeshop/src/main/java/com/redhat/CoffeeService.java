package com.redhat;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.redhat.coffeeservice.client.CoffeeResource;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.Collection;
import com.redhat.model.Coffee;


@ApplicationScoped
public class CoffeeService {

    // public void getCoffees() {
    //     System.out.println("hello coffee");
    // }

    @Inject
    @RestClient
    CoffeeResource coffeeResource;

    public Collection<Coffee> getCoffees() {
        return coffeeResource.getCoffees();
    }
    
}