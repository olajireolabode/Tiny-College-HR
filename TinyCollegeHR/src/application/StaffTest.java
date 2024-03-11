package application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    @Test
    public void testComputePayroll() {
        System.out.println("ComputePayroll Test");
        Staff s = new Staff();

        Assertions Assert = null;

        try {
            int workload = 30;
            double expResult = (double)(workload * 32 * 2) * 0.75;
            s.setWorkload(workload);
            double result = s.ComputePayroll();
            Assert.assertEquals(expResult, result, 0.0);
        } catch (Exception var) {
            Assert.fail("");
        }

    }

    @Test
    public void testComputePayroll2() {
        System.out.println("ComputePayroll Test");
        Staff s = new Staff();

        Assertions Assert = null;

        try {
            int workload = 55;
            double expResult = (double)(workload * 32 * 2) * 0.75;
            s.setWorkload(workload);
            double result = s.ComputePayroll();
            Assert.assertEquals(expResult, result, 0.0);
        } catch (Exception var) {
            Assert.fail("");
        }

    }

    @Test
    public void testComputePayroll3() {
        System.out.println("ComputePayroll Test");
        Staff s = new Staff();

        Assertions Assert = null;

        try {
            int workload = 40;
            double expResult = (double)(workload * 32 * 2) * 0.75;
            s.setWorkload(workload);
            double result = s.ComputePayroll();
            Assert.assertEquals(expResult, result, 0.0);
        } catch (Exception var) {
            Assert.fail("");
        }

    }

}