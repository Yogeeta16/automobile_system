package com.app.service;

import com.app.dao.UserRepository;
import com.app.dao.VehicleRepository;
import com.app.dto.VehicleRequestDTO;
import com.app.dto.VehicleResponseDTO;
import com.app.entities.User;
import com.app.entities.Vehicle;
import com.app.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    public VehicleResponseDTO addVehicle(VehicleRequestDTO vehicleRequestDTO) {
        User user = userRepository.findById(vehicleRequestDTO.getUid())
                .orElseThrow(() -> new CustomException("User not found"));

        Vehicle vehicle = new Vehicle();
        vehicle.setVname(vehicleRequestDTO.getVname());
        vehicle.setCompany(vehicleRequestDTO.getCompany());
        vehicle.setVnumber(vehicleRequestDTO.getVnumber());
        vehicle.setVtype(vehicleRequestDTO.getVtype());
        vehicle.setUser(user);

        vehicle = vehicleRepository.save(vehicle);

        VehicleResponseDTO responseDTO = new VehicleResponseDTO();
        responseDTO.setId(vehicle.getId());
        responseDTO.setVname(vehicle.getVname());
        responseDTO.setCompany(vehicle.getCompany());
        responseDTO.setVnumber(vehicle.getVnumber());
        responseDTO.setVtype(vehicle.getVtype());
        responseDTO.setUid(vehicle.getUser().getUid());

        return responseDTO;
    }

    public List<VehicleResponseDTO> getVehiclesByUserName(String uname) {
        List<Vehicle> vehicles = vehicleRepository.findByUserUname(uname);

        return vehicles.stream()
                .map(vehicle -> {
                    VehicleResponseDTO responseDTO = new VehicleResponseDTO();
                    responseDTO.setId(vehicle.getId());
                    responseDTO.setVname(vehicle.getVname());
                    responseDTO.setCompany(vehicle.getCompany());
                    responseDTO.setVnumber(vehicle.getVnumber());
                    responseDTO.setVtype(vehicle.getVtype());
                    responseDTO.setUid(vehicle.getUser().getUid());
                    return responseDTO;
                })
                .collect(Collectors.toList());
    }

//    public void deleteVehiclesByUserName(String uname) {
//        vehicleRepository.deleteByUserUname(uname);
//    }

    public void deleteVehicleByUserNameAndId(String uname, Long id) {
        User user = userRepository.findByUname(uname);
        if (user == null) {
            throw new CustomException("User not found");
        }

        Vehicle vehicle = vehicleRepository.findByIdAndUser(id, user);
        if (vehicle == null) {
            throw new CustomException("Vehicle not found for user");
        }

        vehicleRepository.deleteById(vehicle.getId());
    }

}


//package com.app.service;
//
//import com.app.dao.UserRepository;
//import com.app.dao.VehicleRepository;
//import com.app.dto.VehicleRequestDTO;
//import com.app.dto.VehicleResponseDTO;
//import com.app.entities.User;
//import com.app.entities.Vehicle;
//import com.app.exceptions.CustomException;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class VehicleService {
//    @Autowired
//    private VehicleRepository vehicleRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public VehicleResponseDTO addVehicle(VehicleRequestDTO vehicleRequestDTO) {
//        User user = userRepository.findById(vehicleRequestDTO.getUid())
//                .orElseThrow(() -> new CustomException("User not found"));
//
//        Vehicle vehicle = modelMapper.map(vehicleRequestDTO, Vehicle.class);
//        vehicle.setUser(user);
//        vehicle = vehicleRepository.save(vehicle);
//
//        return modelMapper.map(vehicle, VehicleResponseDTO.class);
//    }
//
//    public List<VehicleResponseDTO> getVehiclesByUserName(String uname) {
//        List<Vehicle> vehicles = vehicleRepository.findByUserUname(uname);
//
//        return vehicles.stream()
//                .map(vehicle -> modelMapper.map(vehicle, VehicleResponseDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    public void deleteVehiclesByUserName(String uname) {
//        vehicleRepository.deleteByUserUname(uname);
//    }
//}
