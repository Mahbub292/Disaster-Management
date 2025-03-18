package com.disaster.disaster_management_backend.repo;
import com.disaster.disaster_management_backend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    public Users findByUserName(String userName);

    @Query("SELECT COUNT(u) FROM Users u WHERE u.role = 'VOLUNTEER' AND u.status = 'APPROVED'")
    public long countVolunteers();
}
