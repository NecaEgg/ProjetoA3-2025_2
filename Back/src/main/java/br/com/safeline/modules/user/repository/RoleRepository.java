package br.com.safeline.modules.user.repository;


import br.com.safeline.modules.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {


    boolean existsByName(String roleName);
}
