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
    private final RegisRepo regisRepo;
    private final ImgVidRepo imgVidRepo;
    private final ExpensesRepo expensesRepo;
    private  final LoginRepo loginRepo;
//    private final ExpenseLogRepo expenseLogRepo;
    final ObjectMapper objectMapper;
    //ExpenseLogRepo expenseLogRepo
    public RunJsonDataLoader(ImgVidRepo imgVidRepo, FuelLogRepo fuelLogRepo, InsuranceLogRepo insuranceLogRepo, MaintenanceRepairRepo maintenanceRepairRepo, VehicleInformationRepo vehicleInformationRepo, VehicleRegistrationRepo vehicleRegistrationRepo, RegisRepo regisRepo, ExpensesRepo expensesRepo, LoginRepo loginRepo, ObjectMapper objectMapper) {
        this.fuelLogRepo = fuelLogRepo;
        this.insuranceLogRepo = insuranceLogRepo;
        this.maintenanceRepairRepo = maintenanceRepairRepo;
        this.vehicleInformationRepo = vehicleInformationRepo;
        this.vehicleRegistrationRepo = vehicleRegistrationRepo;
        this.regisRepo = regisRepo;
        this.imgVidRepo = imgVidRepo;
        this.expensesRepo = expensesRepo;
        this.loginRepo = loginRepo;
//        this.expenseLogRepo = expenseLogRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        // FUEL LOG REPO
        if (fuelLogRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/fuelLog.json")) {
                List<FuelLog> fuelLogs = objectMapper.readValue(inputStream, new TypeReference<List<FuelLog>>() {});
                logger.info("Fuel Log loaded from JSON file: {}", fuelLogs);
                fuelLogRepo.saveAll(fuelLogs);

            } catch (IOException e) {
                throw new RuntimeException("Fuel Log Unable to load data from JSON file", e);
            }
        } else {
            logger.info("Data already loaded");
        }

        // INSURANCE LOG REPO
        if (insuranceLogRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/insureInfo.json")) {
                List<InsuranceLog> insuranceLogs = objectMapper.readValue(inputStream, new TypeReference<List<InsuranceLog>>() {});
                logger.info("Insurance Log loaded from JSON file: {}", insuranceLogs);
                insuranceLogRepo.saveAll(insuranceLogs);
            } catch (IOException e) {
                throw new RuntimeException("Insurance Unable to load data from JSON file", e);
            }
        }   else{
                logger.info("Insurance Log data already loaded");

            }
        // MAINTENANCE REPAIR REPO
        if ( maintenanceRepairRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/maintenanceRepair.json")) {
                List<MaintenanceRepair> maintenanceRepairs = objectMapper.readValue(inputStream, new TypeReference<List<MaintenanceRepair>>() {});
                logger.info(" loaded from JSON file: {}", maintenanceRepairs);
                maintenanceRepairRepo.saveAll(maintenanceRepairs);
            } catch (IOException e) {
                throw new RuntimeException(" MaintenanceRepair Unable to load data from JSON file", e);
            }
        }   else{
            logger.info("MaintenanceRepair Log data already loaded");

        }

        // VEHICLE INFORMATION REPO
        if (vehicleInformationRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/vehiclesInfo.json")) {
                List<VehicleInformation> vehicleInformations = objectMapper.readValue(inputStream, new TypeReference<List<VehicleInformation>>() {});
                logger.info(" records loaded from JSON file: {}", vehicleInformationRepo);
                vehicleInformationRepo.saveAll(vehicleInformations);
            } catch (IOException e) {
                throw new RuntimeException(" VehicleInformation Unable to load data from vehiclesInfo.json file", e);
            }
        } else {
            logger.info("VehicleInformation data already loaded");
        }

        // VEHICLE REGISTRATION REPO
        if (vehicleRegistrationRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/vehicleRegis.json")) {
                List<VehicleRegistration> vehicleRegistrations = objectMapper.readValue(inputStream, new TypeReference<List<VehicleRegistration>>() {});
                logger.info(" records loaded from JSON file: {}", vehicleRegistrationRepo);
                vehicleRegistrationRepo.saveAll(vehicleRegistrations);
            } catch (IOException e) {
                throw new RuntimeException("vehicleRegistrations Unable to load data from vehiclesInfo.json file", e);
            }
        } else {
            logger.info("vehicleRegistrations data already loaded");
        }

        //Resgitration REPO
        if (regisRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/userRegis.json")) {
                List<Registers> registers = objectMapper.readValue(inputStream, new TypeReference<List<Registers>>() {});
                logger.info(" records loaded from JSON file: {}", regisRepo);
                regisRepo.saveAll(registers);
            } catch (IOException e) {
                throw new RuntimeException(" records loaded Unable to load data from vehiclesInfo.json file", e);
            }
        } else {
            logger.info("vehicleRegistrations data already loaded");
        }

        //        this.imgVidRepo = imgVidRepo;

        if (imgVidRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/ImgVidCaptures.json")) {
                List<ImgVidCapture> imgVidCaptures = objectMapper.readValue(inputStream, new TypeReference<List<ImgVidCapture>>() {});
                logger.info(" imgvid loaded from JSON file: {}", imgVidRepo);
                imgVidRepo.saveAll(imgVidCaptures);
            } catch (IOException e) {
                throw new RuntimeException(" imgvid loaded Unable to load data from ImgVidCaptures.json file", e);
            }
        } else {
            logger.info("imgvid data already loaded");
        }


    //this.loginRepo = loginRepo;
        if (loginRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/userLogins.json")) {
                List<Login> logins = objectMapper.readValue(inputStream, new TypeReference<List<Login>>() {});
                logger.info(" logins loaded from JSON file: {}", loginRepo);
                loginRepo.saveAll(logins);
            } catch (IOException e) {
                throw new RuntimeException(" logins loaded Unable to load data from ImgVidCaptures.json file", e);
            }
        } else {
            logger.info("logins data already loaded");
        }

//        this.expensesRepo = expensesRepo;
        if (expensesRepo.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/expensesLog.json")) {
                List<ExpensesLog> expensesLogs = objectMapper.readValue(inputStream, new TypeReference<List<ExpensesLog>>() {});
                logger.info(" expensesLogs loaded from JSON file: {}", expensesRepo);
                expensesRepo.saveAll(expensesLogs);
            } catch (IOException e) {
                throw new RuntimeException(" expensesLogs loaded Unable to load data from ImgVidCaptures.json file", e);
            }
        } else {
            logger.info("expensesLogs data already loaded");}
        // EXPENSE LOG REPO
//        if (expensesRepo.count() == 0) {
//            try (InputStream inputStream = getClass().getResourceAsStream("/data/expensesLog.json")) {
//                List<ExpensesLog> expensesLogs = objectMapper.readValue(inputStream, new TypeReference<List<ExpensesLog>>() {});
//                logger.info("Expenses Log loaded from JSON file: {}", expensesRepo );
//                expensesRepo.saveAll(expensesLogs);
//
//            } catch (IOException e) {
//                throw new RuntimeException("HI Unable to load data from JSON file", e);
//            }
//        } else {
//            logger.info("ExpensesLog Data already loaded");
//        }

    }
}

