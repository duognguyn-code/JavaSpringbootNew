package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.projection.TimekeepingProjection;
import com.example.manageprojectemployeeretro.entity.Timekeeping;
import com.example.manageprojectemployeeretro.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimekeepingRepository  extends JpaRepository<Timekeeping, Long> {
    boolean existsByUserAndCheckOutTimeIsNull(User user);

    Timekeeping findByUserAndCheckOutTimeIsNull(User user);

    @Query(value = "SELECT check_in_time, check_out_time FROM timekeeping WHERE user_id = :userId AND date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<TimekeepingProjection> findTimekeepingByUserAndDateBetween(@Param("userId") Integer id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Cacheable("checkInOutErrors")
    @Query("SELECT c FROM Timekeeping c WHERE c.user = :user AND YEAR(c.checkInTime) = :year AND MONTH(c.checkInTime) = :month AND c.isError = true")
    List<Timekeeping> findErrorCheckInsByUserAndMonth(@Param("user") User user, @Param("year") int year, @Param("month") int month);
}
