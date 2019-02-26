package car.car1;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
// tag::allButValidation[]
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
@Data
//@RequiredArgsConstructor
public class Information {
    @NotBlank(message="Location is required")
    private String location;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String pickupDate;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String returnDate;
    @NotBlank(message="Car Type is required")
    private String carType;

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getpickupDate(){
        return pickupDate;
    }
    public void setpickupDate(String pickupDate){
        this.pickupDate = pickupDate;
    }
    public String getreturnDate(){
        return returnDate;
    }
    public void setreturnDate(String returnDate){
        this.returnDate = returnDate;
    }
    public String getcarType(){
        return carType;
    }
    public void setcarType(String carType){
        this.carType = carType;
    }

}

