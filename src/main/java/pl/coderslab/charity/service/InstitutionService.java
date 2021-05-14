package pl.coderslab.charity.service;

import java.util.List;
import java.util.Optional;

public interface InstitutionService <T>{


    List<T> getAll();

    List<T> getFirstHalf();

    List<T> getSecondHalf();

    void add(T t);

    Optional<T> get(Long id);

    void delete(Long id);

    void update(T t);
}

