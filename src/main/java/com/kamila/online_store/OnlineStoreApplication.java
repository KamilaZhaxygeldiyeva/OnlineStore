package com.kamila.online_store;

import com.kamila.online_store.entities.User;
import com.kamila.online_store.repos.ClothesRepo;
import com.kamila.online_store.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class OnlineStoreApplication {

	@Autowired
	PasswordEncoder encoder;

	@Bean
	public CommandLineRunner dataLoader(UserRepo userRepo, ClothesRepo clothesRepo) {
		return args -> {
			// adds a new User if the DB still doesn't contain at least one
			if (((List) userRepo.findAll()).isEmpty()) {
				User user = new User();
				user.setUsername("user1");
				user.setPassword(encoder.encode("pass"));
				user.setMoneyBalance(200);
				userRepo.save(user);
			}

			/* adds Product items if the DB still doesn't contain at least one
			if (((List) clothesRepo.findAll()).isEmpty()) {
				Clothes sneakers = new Clothes("sneakers", 1.1, 10);
				Clothes twins = new Clothes("twins", 0.75, 0);
				Clothes kidcut = new Clothes("kidcut", 0.8, 5);
				//Clothes bouncy = new Clothes("bouncy", 0.9, 59);
				//Clothes earth = new Clothes("earth", 0.95, 7);

				clothesRepo.save(sneakers);
				clothesRepo.save(twins);
				clothesRepo.save(kidcut);
				//clothesRepo.save(bouncy);
				//clothesRepo.save(earth);
			}
			//Clothes dress = new Clothes("dress", 65, 5, "Dresses" );
			//Clothes dress1 = new Clothes("dress", 65, 5, Clothes.Type.Dresses);
			//clothesRepo.save(dress1);
			Clothes dresses = new Clothes("dresses", 1.1, 10, Clothes.Type.Dresses);
			Clothes shoes = new Clothes("shoes", 0.75, 0, Clothes.Type.Shoes);
			Clothes coat = new Clothes("coat", 0.8, 5, Clothes.Type.OuterWear);
			Clothes tops = new Clothes("tops", 0.9, 59, Clothes.Type.Tops);
			Clothes bottoms = new Clothes("bottoms", 0.95, 7, Clothes.Type.Bottoms);
			Clothes bag = new Clothes("bag", 0.95, 7, Clothes.Type.Accessories);
			clothesRepo.save(dresses);
			clothesRepo.save(shoes);
			clothesRepo.save(coat);
			clothesRepo.save(tops);
			clothesRepo.save(bottoms);
			clothesRepo.save(bag);*/


		};
	}
	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreApplication.class, args);
	}

}
