package pl.coderslab.charity.mappers;

import pl.coderslab.charity.Dto.DonationDto;
import pl.coderslab.charity.model.Donation;

public class DonationMapper {

    public static void donationMapper(DonationDto donationDto, Donation donation) {
        donation.setCategories(donationDto.getCategories());
        donation.setQuantity(donationDto.getQuantity());
        donation.setInstitution(donationDto.getInstitution());
        donation.setStreet(donationDto.getStreet());
        donation.setCity(donationDto.getCity());
        donation.setZipCode(donationDto.getZipCode());
        donation.setPhoneNumber(donationDto.getPhoneNumber());
        donation.setPickUpDate(donationDto.getPickUpDate());
        donation.setPickUpTime(donationDto.getPickUpTime());
        donation.setPickUpComment(donationDto.getPickUpComment());
    }
}
