package controller;

import dto.CustomDTO;
import dto.DriverDTO;
import dto.UserDTO;
import embeded.Name;
import entity.Driver;
import service.DriverService;
import util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name) {
        driverDTO.setUser(userDTO);
        driverDTO.setName(name);
        service.saveDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/update")
    public ResponseUtil updateDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name) {
        driverDTO.setUser(userDTO);
        driverDTO.setName(name);
        service.updateDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Updated. :" + driverDTO.getUser_id(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteDriver(@RequestParam String id) {
        service.deleteDriver(id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + id, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllDrivers")
    public ResponseUtil getAllDriver() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllDriver());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAvalabilityDrivers")
    public ResponseUtil getAllAvalabileDriver() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllAvalabileDriver());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverIdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate() {
        return service.userIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchDriver", params = {"driver_Id"})
    public Driver searchDriverId(String driver_Id) {
        return service.searchDriverId(driver_Id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverCount")
    public @ResponseBody CustomDTO getSumCustomer() {
        return service.getSumDriver();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverAvailableCount")
    public @ResponseBody CustomDTO getSumAvailableDriver() {
        return service.getSumAvailableDriver();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverUnavailableCount")
    public @ResponseBody CustomDTO getSumUnavailableDriver() {
        return service.getSumUnavailableDriver();
    }
}
