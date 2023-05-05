package com.kamila.online_store.repos;

import com.kamila.online_store.entities.Clothes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepo extends CrudRepository<Clothes, Integer> {
    Clothes findFirstByName(String name);
}
