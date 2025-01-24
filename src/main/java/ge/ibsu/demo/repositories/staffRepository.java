package ge.ibsu.demo.repositories;

import ge.ibsu.demo.entities.Customer;
import ge.ibsu.demo.entities.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffRepository extends JpaRepository<Staff, Long> {
    @Query("From Customer where concat(concat(firstName, ' '), lastName) like :searchText")
    Page<Staff> searchStaff(@Param("searchText") String searchText, Pageable pageable) {
        return null;
    }

    @Query(value = "select * from customer " +
            "where concat(concat(first_name, ' '), last_name) like :searchText",
            countQuery = "select count(*) from customer " +
                    "where concat(concat(first_name, ' '), last_name) like :searchText",
            nativeQuery = true)
    Page<Staff> searchCustomersViaNativeQuery(@Param("searchText") String searchText, Pageable pageable) {
        return null;
    }
}
