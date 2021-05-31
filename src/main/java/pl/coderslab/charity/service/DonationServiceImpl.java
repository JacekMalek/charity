package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService<DonationDto> {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;


    public DonationServiceImpl(DonationRepository donationRepository, InstitutionRepository institutionRepository,
                               CategoryRepository categoryRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<DonationDto> getAll() {
        return null;
    }

    @Override
    public void add(DonationDto donationDto) {
        Donation donation = new Donation();
        donation.setQuantity(donationDto.getQuantity());
        donation.setInstitution(institutionRepository.findById(donationDto.getInstitution()).orElseThrow(EntityNotFoundException::new));
        donation.setCategories(categoryRepository.findAllById(donationDto.getCategories()));//zmienić na serwisy
        donation.setStreet(donationDto.getStreet());
        donation.setCity(donationDto.getCity());
        donation.setZipCode(donationDto.getZipCode());
        donation.setPhoneNumber(donationDto.getPhoneNumber());
        donation.setPickUpDate(donationDto.getPickUpDate());
        donation.setPickUpTime(donationDto.getPickUpTime());
        donation.setPickUpComment(donationDto.getPickUpComment());
//        donation.getUser(userRepository.findByUsername(donationDto.getUser()));
        donationRepository.save(donation);
    }


    @Override
    public Optional<DonationDto> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(DonationDto donationDto) {

    }

    @Override
    public Long numberOfGifts() {
        return donationRepository.count();
    }

    @Override
    public Integer numberOfBags() {
        return donationRepository.findSumAllBags().orElse(0);
    }
}
