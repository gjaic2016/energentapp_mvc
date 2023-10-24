package hr.apisit.energentmvc.dtoDomain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDTO {

    @NotBlank(message = "First name must not be empty.")
    @NotNull
    private String ime;

    @NotBlank(message = "Last name must not be empty.")
    private String prezime;

    @NotNull(message = "Date of birth must be entered.")
    @Past(message= "Date of birth must be in the past.")
    private LocalDate datumRodenja;

    @NotBlank(message = "JMBAG must not be empty.")
    @Pattern(message = "JMBAG must have 11 digits.", regexp="[\\d]{11}")
    private String oib;

}
