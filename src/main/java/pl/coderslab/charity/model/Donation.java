package pl.coderslab.charity.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ilość worków musi być większa od 0")
    @Min(value = 1, message = "Ilość worków musi być większa od 0")
    private Integer quantity;

    @ManyToMany
    @NotNull(message = "Musi zostać wybrana minimum jedna kategoria")
    private List<Category> categories;

    @ManyToOne
    @NotNull(message = "Musi zostać wybrana minimum jedna instytucja")
    private Institution institution;

    @NotBlank(message = "Nazwa nie może być pusta")
    @Size(message = "Nazwa winna zwierać minimum 3 litery", min = 3)
    private String city;

    @NotBlank(message = "Nazwa nie może być pusta")
    @Size(message = "Nazwa winna zwierać minimum 3 litery", min = 3)
    private String street;

    @NotBlank
    @Pattern(message = "Proszę podać prawidłowy kod pocztowy w formacie XX-XXX", regexp = "^[0-9]{2}-[0-9]{3}$")
    //TODO  Do sprawdzenia czy działa prawidłowo
    private String zipCode;

    //TODO Do sprawdzenia format daty

    @NotNull
    @Column(name = "pick_up_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @NotNull
    @Column(name = "pick_up_time")
    private LocalTime pickUpTime;

    private String pickUpComment;

    //Zapytać czy jest dobrze
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @NotBlank(message = "Nazwa nie może być pusta")
    @Pattern(message = "Proszę podać prawidłowy numer telefonu", regexp = "[0-9]{9}")
    private String phoneNumber;

    public Donation() {
    }

    public Donation(Integer quantity, List<Category> categories, Institution institution, String city, String street,
                    String zipCode, LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment, String phoneNumber) {
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
        this.phoneNumber = phoneNumber;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
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
}