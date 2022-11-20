package backend.repositories;

import model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.district=:district")
    public List<Item> getItemsByDistrict(@Param("district") String district);

    @Query("SELECT i FROM Item i WHERE i.category=:category")
    public List<Item> getItemsByCategory(@Param("category") String category);

    @Query("SELECT i FROM Item i WHERE i.category=:category AND i.district=:district")
    public List<Item> getItemsByCategoryAndDistrict(@Param("category") String category,
                                                    @Param("district") String district);

}
