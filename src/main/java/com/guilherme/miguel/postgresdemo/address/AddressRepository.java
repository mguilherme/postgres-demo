package com.guilherme.miguel.postgresdemo.address;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Miguel Guilherme
 */
public interface AddressRepository extends CrudRepository<Address, String> {
}
