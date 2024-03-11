package tinycollege;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartTimeTest {

    @Test
    void computePayrollPhd() {
        System.out.println("ComputePayroll For PartTime Phd");
        PartTime pt = new PartTime();

        Assertions Assert = null;

        try {

            int degreeRate = 112;
            int hoursWorked = 30;
            double expResult = (double)(hoursWorked * degreeRate * 2) * 0.75;
            pt.setHoursWorked(hoursWorked);
            pt.setDegree("phd");
            double result = pt.ComputePayroll();
            Assert.assertEquals(expResult, result, 0.0);
        } catch (Exception var7) {
            Assert.fail("");
        }
    }

    @Test
    void computePayrollMaster() {
        System.out.println("ComputePayroll For PartTime Master");
        PartTime pt = new PartTime();

        Assertions Assert = null;

        try {

            int degreeRate = 82;
            int hoursWorked = 20;
            double expResult = (double)(hoursWorked * degreeRate * 2) * 0.75;
            pt.setHoursWorked(hoursWorked);
            pt.setDegree("master");
            double result = pt.ComputePayroll();
            Assert.assertEquals(expResult, result, 0.0);
        } catch (Exception var7) {
            Assert.fail("");
        }
    }

    @Test
    void computePayrollBachelor() {
        System.out.println("ComputePayroll For PartTime Bachelor");
        PartTime pt = new PartTime();

        Assertions Assert = null;

        try {

            int degreeRate = 42;
            int hoursWorked = 30;
            double expResult = (double)(hoursWorked * degreeRate * 2) * 0.75;
            pt.setHoursWorked(hoursWorked);
            pt.setDegree("bachelor");
            double result = pt.ComputePayroll();
            Assert.assertEquals(expResult, result, 0.0);
        } catch (Exception var7) {
            Assert.fail("");
        }
    }
}