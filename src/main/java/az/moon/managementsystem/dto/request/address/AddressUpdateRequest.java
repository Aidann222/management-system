package az.moon.managementsystem.dto.request.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressUpdateRequest {
    private String street;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
