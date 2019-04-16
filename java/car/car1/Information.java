package car.car1;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Data
@Entity
@Table(name="\"booking\"")
public class Information {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date created_at;
    @NotBlank(message="Location is required")
    private String location;
    @Pattern(regexp="^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message="Must be formatted MM/YY")
    private String pickup_date;
    @Pattern(regexp="^(0[0-9]|1[0-9])([\\/])([0-9][0-9])$",
            message="Must be formatted MM/YY")
    private String return_date;
    @NotBlank(message="Car Type is required")
    protected String car_type;
    public String getcarType() {
        return car_type;
    }
    @PrePersist
    void createdAt() {
        this.created_at = new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

