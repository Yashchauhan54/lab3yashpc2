package org.example.hrmanagementyash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Testemployeesalary {
    @Test
    void testtheirsalary(){
        assertEquals(HelloController.salaryperanum(2000),24000);
    }

}