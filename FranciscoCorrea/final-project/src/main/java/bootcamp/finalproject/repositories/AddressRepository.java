package bootcamp.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.finalproject.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
