package az.moon.managementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "contacts")
public class Contact extends BaseDomain<Integer> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String email;
    private String callCenter;
    private String phoneNumber;

}