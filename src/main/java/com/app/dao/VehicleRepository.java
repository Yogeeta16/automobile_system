package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;
import com.app.entities.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByUserUname(String uname);
    void deleteByUserUname(String uname);
	Vehicle findByIdAndUser(Long id, User user);
}
