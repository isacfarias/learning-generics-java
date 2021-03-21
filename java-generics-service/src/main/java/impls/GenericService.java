package impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<T extends Convertible<DTO>, DTO, ID> {

	JpaRepository<T, ID> getRepository();

	default DTO findById(ID id) {
		Optional<T> result = getRepository().findById(id);
		return result.get().convert();
	}

	default  List<DTO> findAll() {
		return getRepository().findAll()
				                 .stream()
				                 .map(employee -> employee.convert())
				                 .collect(Collectors.toList());
	}
}