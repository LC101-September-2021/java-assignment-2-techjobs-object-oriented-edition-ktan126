package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {

        Job job1 = new Job();
        Job job2 = new Job();
        assertTrue(job1.getId()-job2.getId()==-1);

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //assertTrue(tester3 instanceof Job);
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester",job.getName());
        assertEquals("ACME",job.getEmployer().getValue());
        assertEquals("Desert",job.getLocation().getValue());
        assertEquals("Quality control",job.getPositionType().getValue());
        assertEquals("Persistence",job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));



        char firstChar = job.toString().charAt(0);
        char lastChar = job.toString().charAt(job.toString().length()-1);

        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Boolean labelId = job.toString().contains("ID");
        Boolean labelName = job.toString().contains("Name");
        Boolean labelEmployer = job.toString().contains("Employer");
        Boolean labelLocation = job.toString().contains("Location");
        Boolean labelPositionType = job.toString().contains("Position Type");
        Boolean labelCoreCompetency = job.toString().contains("Core Competency");

        assertTrue(labelId && labelName && labelEmployer && labelLocation && labelPositionType && labelCoreCompetency == true);


        String test = "\nID: " + job.getId() + "\n" +
                "Name: Data not available\n" +
                "Employer: ACME\n" +
                "Location: Data not available\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";
        assertEquals(test, job.toString());

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        assertEquals("OOPS! This job does not seem to exist.",job.toString());
    }

}
