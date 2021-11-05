package api;
import entity.Gender;
import entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Integer id;

	private String name;

	private Gender gender;

	private String password;

	private String email;

	public UserDTO(User u) {
		this.id = u.getId();
		this.name = u.getName();
		this.password = u.getPassword();
		this.email = u.getEmail();
		this.gender = u.getGender();
	}
}
