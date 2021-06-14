package pl.coderslab.charity.service;

import java.util.List;
import java.util.Optional;

public interface InstitutionService <T>{


    List<T> getAll();

    List<T> getFirstFour();

    void add(T t);

    Optional<T> get(Long id);

    void delete(Long id);

    void update(T t);

    Long numberOfInstitutions();

}

