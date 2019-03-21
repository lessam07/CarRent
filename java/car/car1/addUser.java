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
@Table(name="\"users\"")
public class addUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date created_at;
    @NotBlank(message="Location is required")
    private String username;
    @NotBlank(message="Username is required")
    private String password;
    @NotBlank(message="Password is required")
    private String password2;
    @NotBlank(message="Password Repeat is required")
    @PrePersist
    void createdAt() {
        this.created_at = new Date();
    }
}
