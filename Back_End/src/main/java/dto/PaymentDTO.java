package dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class PaymentDTO {

    private String payment_ID;
    private String rentID;
    private String payment_type;
    private LocalTime time;
    private LocalDate date;
    private Double lostDamage;
    private Double rentFee;
    private Double driverFee;
    private Double total;
}
