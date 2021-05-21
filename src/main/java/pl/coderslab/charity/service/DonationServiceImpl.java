package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Dto.DonationDto;
import pl.coderslab.charity.mappers.DonationMapper;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService<DonationDto> {

    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public List<DonationDto> getAll() {
        return null;
    }

    @Override
    public void add(DonationDto donationDto) {
        Donation donation = new Donation();
        DonationMapper.donationMapper(donationDto, donation);
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
//TODO Do zmiany Optional w numberOfBags
}
