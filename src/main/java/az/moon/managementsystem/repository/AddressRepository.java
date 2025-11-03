package az.moon.managementsystem.repository;

import az.moon.managementsystem.dto.request.address.AddressCreateRequest;
import az.moon.managementsystem.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
