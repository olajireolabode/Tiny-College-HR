package application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FullTimeTest {
    @Test
    public void testComputePayrollPhd() {
        Assertions Assert = null;

        System.out.println("ComputePayRoll Test for FullTime Phd");
        FullTime ft = new FullTime();
        ft.setDegree("PhD");
        int degreeRate = 112;
        double expResult = (double)(32 * degreeRate * 2) * 0.85;
        double result = ft.ComputePayroll();
        Assert.assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testComputePayrollMasters() {
        Assertions Assert = null;

        System.out.println("ComputePayRoll Test for FullTime Master");
        FullTime ft = new FullTime();
        ft.setDegree("master");
        int degreeRate = 82;
        double expResult = (double)(32 * degreeRate * 2) * 0.85;
        double result = ft.ComputePayroll();
        Assert.assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testComputePayrollBachelors() {
        Assertions Assert = null;

        System.out.println("ComputePayRoll Test for FullTime Bachelor");
        FullTime ft = new FullTime();
        ft.setDegree("bachelor");
        int degreeRate = 42;
        double expResult = (double)(32 * degreeRate * 2) * 0.85;
        double result = ft.ComputePayroll();
        Assert.assertEquals(expResult, result, 0.0);
    }
}