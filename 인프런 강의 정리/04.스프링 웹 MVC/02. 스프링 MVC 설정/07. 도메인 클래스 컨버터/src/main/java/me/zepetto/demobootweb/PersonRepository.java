package me.zepetto.demobootweb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  PersonRepository extends JpaRepository<Person, Long> {
}
