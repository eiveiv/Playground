package server.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import server.domain.Beer;

import java.util.List;

public interface IBeerDao extends CrudRepository<Beer, Integer> {

    Beer findByBrand(String brand);

    Beer findByBrandAndName(String brand, String name);

    Beer findById(Integer id);

    List<Beer> findAll(Sort sort);

    @Query("select b from Beer b where b.brand like %?1")
    Beer findByBrandEndsWith(String brand);
}
