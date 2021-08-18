package com.febatis.pagamento.repository;

import com.febatis.pagamento.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
