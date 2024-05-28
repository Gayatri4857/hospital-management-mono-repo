package org.dnyanyog.repo;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository<Users, Long> {
	List<Users> findBymobileNumber(String mobile_number);
}
