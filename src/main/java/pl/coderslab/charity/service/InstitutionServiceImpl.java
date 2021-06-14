package pl.coderslab.charity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstitutionServiceImpl implements InstitutionService<InstitutionDto> {

    private final InstitutionRepository institutionRepository;
    private static final Logger log = LoggerFactory.getLogger(InstitutionServiceImpl.class);

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<InstitutionDto> getAll() {
        return institutionRepository.findAll()
                .stream()
                .map(institution -> new InstitutionDto(institution.getId(), institution.getName(), institution.getDescription()))
                .collect(Collectors.toList());
    }

    @Override
    public List<InstitutionDto> getFirstFour() {
        return institutionRepository.findAll(PageRequest.of(0, 4))
                .map(institution -> new InstitutionDto(institution.getId(), institution.getName(), institution.getDescription()))
                .getContent();
    }

    @Override
    public void add(InstitutionDto institutionDto) {
        Institution institution = new Institution();
        institution.setName(institutionDto.getName());
        institution.setDescription(institutionDto.getDescription());
        log.info("Dodano nową instytucję");
        institutionRepository.save(institution);
    }

    @Override
    public Optional<InstitutionDto> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public void update(InstitutionDto institutionDto) {

    }

    @Override
    public Long numberOfInstitutions() {
        return institutionRepository.count();
    }
}
