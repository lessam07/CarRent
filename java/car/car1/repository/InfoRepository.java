package car.car1.repository;
import car.car1.Information;
import org.springframework.data.repository.CrudRepository;

public interface InfoRepository extends CrudRepository<Information, Integer> {
}

