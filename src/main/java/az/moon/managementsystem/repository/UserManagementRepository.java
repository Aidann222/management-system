package az.moon.managementsystem.repository;

import az.moon.managementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserManagementRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
