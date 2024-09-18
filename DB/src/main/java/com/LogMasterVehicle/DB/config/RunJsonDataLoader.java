package com.LogMasterVehicle.DB.config;


import com.LogMasterVehicle.DB.common.*;
import com.LogMasterVehicle.DB.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class RunJsonDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(RunJsonDataLoader.class);
    private final FuelLogRepo fuelLogRepo;
    private final InsuranceLogRepo insuranceLogRepo;
    private final MaintenanceRepairRepo maintenanceRepairRepo;
    private final VehicleInformationRepo vehicleInformationRepo;
    private final VehicleRegistrationRepo vehicleRegistrationRepo;
    final ObjectMapper objectMapper;

    public RunJsonDataLoader(FuelLogRepo fuelLogRepo, InsuranceLogRepo insuranceLogRepo, MaintenanceRepairRepo maintenanceRepairRepo, VehicleInformationRepo vehicleInformationRepo, VehicleRegistrationRepo vehicleRegistrationRepo, ObjectMapper objectMapper) {
        this.fuelLogRepo = fuelLogRepo;
        this.insuranceLogRepo = insuranceLogRepo;
        this.maintenanceRepairRepo = maintenanceRepairRepo;
        this.vehicleInformationRepo = vehicleInformationRepo;
        this.vehicleRegistrationRepo = vehicleRegistrationRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        if (fuelLogRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/fuelLog.json")) {
                List<FuelLog> fuelLogs = objectMapper.readValue(inputStream, new TypeReference<List<FuelLog>>() {});
                logger.info("Fuel Log loaded from JSON file: {}", fuelLogs);
                fuelLogRepo.saveAll(fuelLogs);

            } catch (IOException e) {
                throw new RuntimeException("Unable to load data from JSON file", e);
            }
        } else {
            logger.info("Data already loaded");
        }

        if (insuranceLogRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/insureInfo.json")) {
                List<InsuranceLog> insuranceLogs = objectMapper.readValue(inputStream, new TypeReference<List<InsuranceLog>>() {});
                logger.info("Insurance Log loaded from JSON file: {}", insuranceLogs);
                insuranceLogRepo.saveAll(insuranceLogs);
            } catch (IOException e) {
                throw new RuntimeException("Unable to load data from JSON file", e);
            }
        }   else{
                logger.info("Insurance Log data already loaded");

            }

        if ( maintenanceRepairRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/maintenanceRepair.json")) {
                List<MaintenanceRepair> maintenanceRepairs = objectMapper.readValue(inputStream, new TypeReference<List<MaintenanceRepair>>() {});
                logger.info(" loaded from JSON file: {}", maintenanceRepairRepo);
                maintenanceRepairRepo.saveAll(maintenanceRepairs);
            } catch (IOException e) {
                throw new RuntimeException("Unable to load data from JSON file", e);
            }
        }   else{
            logger.info("MaintenanceRepair Log data already loaded");

        }


        if (vehicleInformationRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/vehiclesInfo.json")) {
                List<VehicleInformation> vehicleInformations = objectMapper.readValue(inputStream, new TypeReference<List<VehicleInformation>>() {});
                logger.info(" records loaded from JSON file: {}", vehicleInformationRepo);
                vehicleInformationRepo.saveAll(vehicleInformations);
            } catch (IOException e) {
                throw new RuntimeException("Unable to load data from vehiclesInfo.json file", e);
            }
        } else {
            logger.info("VehicleInformation data already loaded");
        }

        if (vehicleRegistrationRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/vehicleRegis.json")) {
                List<VehicleRegistration> vehicleRegistrations = objectMapper.readValue(inputStream, new TypeReference<List<VehicleRegistration>>() {});
                logger.info(" records loaded from JSON file: {}", vehicleRegistrationRepo);
                vehicleRegistrationRepo.saveAll(vehicleRegistrations);
            } catch (IOException e) {
                throw new RuntimeException("Unable to load data from vehiclesInfo.json file", e);
            }
        } else {
            logger.info("vehicleRegistrations data already loaded");
        }
    }
}

