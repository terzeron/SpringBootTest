package com.terzeron.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class CityController {
    @Autowired
    private CityRepository repository;

    @RequestMapping("/")
    String home() {
        return "Hello, world!";
    }

    @RequestMapping("/cities")
    Collection<City> cities() {
        repository.save(new City("Seoul", "Korea"));
        repository.save(new City("Busan", "Korea"));
        repository.save(new City("Tokyo", "Japan"));
        repository.save(new City("Beijing", "China"));
        repository.save(new City("Shanghai", "China"));

        return makeCollection(repository.findAll());
    }

    public static <E> Collection<E> makeCollection(Iterable<E> iter) {
        Collection<E> list = new ArrayList<E>();
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }

    @RequestMapping(value="/city/{cityId}", method= RequestMethod.GET)
    public City getCity(@PathVariable Long cityId) {
        return repository.findById(cityId).get();
    }
}
