package dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
public class UserDTO {
    private String user_id;
    private String role;
    private String user_name;
    private String password;

    public UserDTO(String role, String user_name, String password) {
        this.role = role;
        this.user_name = user_name;
        this.password = password;
    }

}
