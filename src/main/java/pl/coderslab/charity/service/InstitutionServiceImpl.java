package pl.coderslab.charity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstitutionServiceImpl implements InstitutionService<Institution>{

    private final InstitutionRepository institutionRepository;
    private static final Logger log = LoggerFactory.getLogger(InstitutionServiceImpl.class);

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> getAll() {
       return institutionRepository.findAll()
               .stream()
               .map(institution -> new Institution(institution.getId(), institution.getName(), institution.getDescription()))
               .collect(Collectors.toList());
    }

    @Override
    public List<Institution> getFirstHalf() {
        return institutionRepository.findAll()
                .stream()
                .map(institution -> new Institution(institution.getId(), institution.getName(), institution.getDescription()))
                .collect(Collectors.toList()).subList(0, getAll().size()/2);
    }

    @Override
    public List<Institution> getSecondHalf() {
        return institutionRepository.findAll()
                .stream()
                .map(institution -> new Institution(institution.getId(), institution.getName(), institution.getDescription()))
                .collect(Collectors.toList()).subList(getAll().size()/2, getAll().size());
    }


    @Override
    public void add(Institution institution) {

    }

    @Override
    public Optional<Institution> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Institution institution) {

    }
}
