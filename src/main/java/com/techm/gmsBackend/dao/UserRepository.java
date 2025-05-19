package com.techm.gmsBackend.dao;

import com.techm.gmsBackend.entity.GymUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<GymUser,Long> {
    Optional<GymUser> findByName(String name);

}
