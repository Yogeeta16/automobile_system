package com.app.controller;

import com.app.dto.VehicleRequestDTO;
import com.app.dto.VehicleResponseDTO;
import com.app.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> addVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        return ResponseEntity.status(201).body(vehicleService.addVehicle(vehicleRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesByUserName(@RequestParam String uname) {
        return ResponseEntity.ok(vehicleService.getVehiclesByUserName(uname));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteVehicleByUserNameAndId(
            @RequestParam String uname,
            @RequestParam Long id) {
        vehicleService.deleteVehicleByUserNameAndId(uname, id);
        return ResponseEntity.noContent().build();
    }

}
