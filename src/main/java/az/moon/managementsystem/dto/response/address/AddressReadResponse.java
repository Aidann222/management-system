package az.moon.managementsystem.dto.response.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressReadResponse {
    private String district;
    private BigDecimal postalCode;
    private BigDecimal latitude;
}
