package hr.apisit.energentmvc.dtoDomain;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdDTO {

    private Integer id;

    @NotBlank(message = "Address must not be empty.")
    private String adresa;

    private List<OwnerDTO> vlasnik;

}
