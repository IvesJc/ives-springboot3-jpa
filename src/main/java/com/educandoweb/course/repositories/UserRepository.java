package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// PODERIA UTILIZAR O @REPOSITORY, MAS A JPAREPOSITORY JÁ FAZ COM QUE O SPRING IDENTIFIQUE QUE ESSE É UM
// REPOSITORY
public interface UserRepository extends JpaRepository<User, Long> {


}
