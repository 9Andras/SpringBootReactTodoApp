package com.gdn.fullstack.SpringBootReactTodoApp.datapopulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired
    DataPopulationService populationService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        populationService.populateData();
    }
}
