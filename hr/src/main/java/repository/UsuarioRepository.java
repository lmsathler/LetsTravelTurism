package repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import entity.User;
	
	@Repository
	public interface UsuarioRepository extends MongoRepository<User, String> {

}

