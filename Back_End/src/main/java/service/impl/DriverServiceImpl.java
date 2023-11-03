package service.impl;

import dto.CustomDTO;
import dto.DriverDTO;
import entity.Driver;
import entity.User;
import repo.DriverRepo;
import service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * @author Malsha Ekanayake
 **/
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {

        Driver driver = new Driver(dto.getUser_id(), dto.getName(), dto.getContact_no(), dto.getAddress(), dto.getEmail(),
                dto.getNic_no(), dto.getLicense_no(), "", dto.getDriverAvailability(),
                new User(dto.getUser().getUser_id(), dto.getUser().getRole(), dto.getUser().getUser_name(), dto.getUser().getPassword()));
        System.out.println(driver);
        if (repo.existsById(dto.getUser_id()))
            throw new RuntimeException("Driver Already Exist. Please enter another id..!");

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getLicense_img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicense_img().getOriginalFilename()));

            driver.setLicense_Img("uploads/" + dto.getLicense_img().getOriginalFilename());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver);
        repo.save(driver);

    }

    @Override
    public void updateDriver(DriverDTO dto) {

        Driver driver = new Driver(dto.getUser_id(), dto.getName(), dto.getContact_no(), dto.getAddress(),
                dto.getEmail(), dto.getNic_no(), dto.getLicense_no(), "", dto.getDriverAvailability(),
                new User(dto.getUser().getUser_id(), dto.getUser().getRole(), dto.getUser().getUser_name(), dto.getUser().getPassword()));
        System.out.println(driver);
        if (!repo.existsById(dto.getUser_id())) {
            throw new RuntimeException("Driver Not Exist. Please enter Valid id..!");
        }

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getLicense_img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicense_img().getOriginalFilename()));

            driver.setLicense_Img("uploads/" + dto.getLicense_img().getOriginalFilename());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver);
        repo.save(driver);

    }

    @Override
    public void deleteDriver(String driver_ID) {
        if (!repo.existsById(driver_ID)) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(driver_ID);
    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<Driver>>() {
        }.getType());
    }

    @Override
    public ArrayList<DriverDTO> getAllAvalabileDriver() {
        return mapper.map(repo.availableDrivers(), new TypeToken<ArrayList<Driver>>() {
        }.getType());
    }

    @Override
    public CustomDTO userIdGenerate() {
        return new CustomDTO(repo.getLastIndex());
    }

    @Override
    public CustomDTO getSumAvailableDriver() {
        return new CustomDTO(repo.getSumAvailableDriver());
    }

    @Override
    public CustomDTO getSumUnavailableDriver() {
        return new CustomDTO(repo.getSumUnavailableDriver());
    }

    @Override
    public Driver searchDriverId(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        return mapper.map(repo.findById(id).get(), Driver.class);
    }

    @Override
    public CustomDTO getSumDriver() {
        return new CustomDTO(repo.getSumDriver());
    }
}