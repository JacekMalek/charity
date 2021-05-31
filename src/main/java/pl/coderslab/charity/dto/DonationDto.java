package pl.coderslab.charity.dto;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DonationDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ilość worków musi być większa od 0")
    @Min(value = 1, message = "Ilość worków musi być większa od 0")
    private Integer quantity;

    @ManyToMany
    @NotEmpty(message = "Musi zostać wybrana minimum jedna kategoria")
    private List<Long> categories;

    @ManyToOne
    @NotNull(message = "Musi zostać wybrana minimum jedna instytucja")
    private Long institution;

    @NotBlank(message = "Nazwa nie może być pusta")
    @Size(message = "Nazwa winna zwierać minimum 3 litery", min = 3)
    private String city;

    @NotBlank(message = "Nazwa nie może być pusta")
    @Size(message = "Nazwa winna zwierać minimum 3 litery", min = 3)
    private String street;

    @Pattern(message = "Proszę podać prawidłowy kod pocztowy w formacie XX-XXX", regexp = "^[0-9]{2}-[0-9]{3}$")
    private String zipCode;

    @NotNull(message = "Pole nie może być puste")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Data musi być z przyszłości")
    private LocalDate pickUpDate;

    @NotNull(message = "Podaj godzinę")
    private LocalTime pickUpTime;

    @NotBlank(message = "Nazwa nie może być pusta")
    @Pattern(message = "Proszę podać prawidłowy numer telefonu", regexp = "[0-9]{9}")
    private String phoneNumber;

    private String pickUpComment;

    private Long user;



    public DonationDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }

    public Long getInstitution() {
        return institution;
    }

    public void setInstitution(Long institution) {
        this.institution = institution;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
