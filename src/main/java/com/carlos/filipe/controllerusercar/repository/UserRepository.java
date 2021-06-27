package com.carlos.filipe.controllerusercar.repository;

import com.carlos.filipe.controllerusercar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
    User findByCpf(String cpf);
    User findByEmail(String email);
    User findByEmailOrCpf(String email, String cpf);
}
