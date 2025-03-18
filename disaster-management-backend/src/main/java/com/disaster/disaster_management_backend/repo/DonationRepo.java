package com.disaster.disaster_management_backend.repo;
import com.disaster.disaster_management_backend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepo extends JpaRepository<Donation, Long>{
    @Query("SELECT SUM(d.amount) FROM Donation d")
    public Double totalDonationAmount();
}
