package az.moon.managementsystem.dto.request.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressCreateRequest {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String street;


}
