package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Dto.CategoryDto;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService<CategoryDto>{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDto> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryDto(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void add(CategoryDto categoryDto) {

    }

    @Override
    public Optional<CategoryDto> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(CategoryDto categoryDto) {

    }
}
