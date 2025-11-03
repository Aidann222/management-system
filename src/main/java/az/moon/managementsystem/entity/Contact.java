package az.moon.managementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact extends BaseDomain {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String email;
    private String callCenter;
    private String phoneNumber;
    private Long addressId;

}