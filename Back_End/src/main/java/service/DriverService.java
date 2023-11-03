package service;

import dto.CustomDTO;
import dto.DriverDTO;
import entity.Driver;

import java.util.ArrayList;

/**
 * @author Malsha Ekanayaka
 */
public interface DriverService {
    void saveDriver(DriverDTO dto);
    void updateDriver(DriverDTO dto);
    void deleteDriver(String reg_ID);
    ArrayList<DriverDTO> getAllDriver();
    ArrayList<DriverDTO> getAllAvalabileDriver();
    CustomDTO userIdGenerate();
    CustomDTO getSumAvailableDriver();
    CustomDTO getSumUnavailableDriver();
    Driver searchDriverId(String id);
    CustomDTO getSumDriver();
}
