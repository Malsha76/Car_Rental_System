package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DriverDTO {
    private String user_id;
    private String name;
    private String contact_no;
    private String address;
    private String email;
    private String nic_no;
    private String license_no;
    private MultipartFile license_img;
    private String driverAvailability;
    private UserDTO user;

}
