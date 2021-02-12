package org.launchcode.techjobs_oo.tests;

import org.launchcode.techjobs_oo.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    Job test_job5;

    @Before
    public void createJobObjects() {
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job5 = new Job(" ", new Employer(""), new Location(" "), new PositionType(" "), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        assertFalse(test_job1.getId() == test_job2.getId());
        assertTrue(test_job1.getId() + 1 == test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(test_job3.getName() == "Product tester");
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job3.equals(test_job4));
    }

    @Test
    public void testCustomToStringFormat() {
        assertEquals("\nID: " + test_job3.getId() +
                "\nName: " + test_job3.getName() +
                "\nEmployer: " + test_job3.getEmployer() +
                "\nLocation: " + test_job3.getLocation() +
                "\nPosition Type: " + test_job3.getPositionType() +
                "\nCore Competency: " + test_job3.getCoreCompetency() +
                "\n", test_job3.toString());
    }

    @Test
    public void testEmptyFieldMessage() {

        String noDataMsg = "Data not available";

        assertEquals("\nID: " + test_job5.getId() +
                "\nName: " + noDataMsg +
                "\nEmployer: " + noDataMsg +
                "\nLocation: " + noDataMsg +
                "\nPosition Type: " + noDataMsg +
                "\nCore Competency: " + noDataMsg +
                "\n", test_job5.toString());
    }

    @Test
    public void testEmptyConstructorReturnsErrorMessage() {
        assertTrue(test_job1.toString() == "\nOOPS! This job does not seem to exist.\n");
    }
}
