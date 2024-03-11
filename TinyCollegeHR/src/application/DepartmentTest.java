package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    private Department department;

    @BeforeEach
    public void setup() {
        System.out.println("Instantiating Department");
        department = new Department();
    }
    @Test
    void contains() {
        Staff s = new Staff();
        assertFalse(department.contains(s));
    }

    @Test
    void testContains() {
        Teacher t = new Teacher();
        assertFalse(department.contains(t));
    }

    @Test
    void addTeacher() throws Exception  {
        Teacher t = new Teacher();
        department.addTeacher(t);
    }

    @Test
    void addTeacher2() throws Exception  {
        Teacher t1 = new Teacher();
        department.addTeacher(t1);
    }

    @Test
    void addStaff() throws Exception {
        Staff s = new Staff();
        department.addStaff(s);
    }

    @Test
    void addStaff2() throws Exception {
        Staff s1 = new Staff();
        department.addStaff(s1);
    }

}