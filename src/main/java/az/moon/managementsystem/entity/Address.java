package az.moon.managementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adresses")
public class Address extends BaseDomain {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;







}
