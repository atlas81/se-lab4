package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GT4500Test {

    private GT4500 ship;

    @BeforeEach
    public void init() {
        this.ship = new GT4500();
    }

    @Test
    void fireTorpedo_Single_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.ALL);

        // Assert
        assertEquals(true, result);
    }


    @Test 
    void fireTorpedo_Alt_Fire_Backup() {

        this.ship = new GT4500(2,0,0,0);
        ship.fireTorpedo(FiringMode.SINGLE);
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        assertEquals(true, result);
    }

    @Test 
    void fireLaser_Ret_False() {
        boolean result = ship.fireLaser(FiringMode.ALL);

        assertEquals(false, result);
    }

    @Test 
    void fireTorpedo_Single_Both_Empty() {
        this.ship = new GT4500(0,0,0,0);
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);
        assertEquals(false, result);
    }

    @Test 
    void fireTorpedo_All_Both_Empty() {
        this.ship = new GT4500(0,0,0,0);
        boolean result = ship.fireTorpedo(FiringMode.ALL);
        assertEquals(false, result);
    }

    @Test 
    void fireTorpedo_Primary_Last_Time_But_Sec_Is_Empty() {
        this.ship = new GT4500(1, 0, 0, 0);
        boolean result1 = ship.fireTorpedo(FiringMode.SINGLE);
        boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);

        assertEquals(true, result1);
        assertEquals(false, result2);
    }

}
