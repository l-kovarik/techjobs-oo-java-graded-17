package org.launchcode.techjobs.oo;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    Job job1;
    Job job2;
    @Test
    public void testSettingJobId() {
       String idMsg = "constructor sets unique ID for each job.";
       job1 = new Job();
       job2 = new Job();
       int expected = job1.getId();
       int actual = job2.getId();
       assertNotEquals(idMsg, expected, actual);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String fieldSetMsg = "constructor correctly sets class and value for all fields.";
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Employer employer1 = new Employer("ACME");

        assertTrue(fieldSetMsg, job1.getName() instanceof String);
        assertTrue(fieldSetMsg, job1.getEmployer() instanceof Employer);
        assertTrue(fieldSetMsg, job1.getLocation() instanceof Location);
        assertTrue(fieldSetMsg, job1.getPositionType() instanceof PositionType);
        assertTrue(fieldSetMsg, job1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(fieldSetMsg, "Product tester", job1.getName());
        assertEquals(fieldSetMsg, "ACME", job1.getEmployer().toString());
        assertEquals(fieldSetMsg, "Desert", job1.getLocation().toString());
        assertEquals(fieldSetMsg, "Quality control", job1.getPositionType().toString());
        assertEquals(fieldSetMsg, "Persistence", job1.getCoreCompetency().toString());

    }

    @Test
    public void testJobsForEquality() {
        String equalMsg = "Jobs with different ids are not equal";
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(equalMsg, job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String newLineMsg = "To string starts and ends with a new line";
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String firstChar = String.valueOf(job1.toString().charAt(0));
        String lastChar = String.valueOf(job1.toString().charAt(job1.toString().length()-1));

        assertEquals(firstChar, lineSeparator());
        assertEquals(lastChar, lineSeparator());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String labelAndDataMsg = "toString uses the correct labels and data";
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expected = System.lineSeparator() +
                "ID: " + job1.getId() + System.lineSeparator() +
                "Name: " + job1.getName() + System.lineSeparator() +
                "Employer: " + job1.getEmployer() + System.lineSeparator() +
                "Location: " + job1.getLocation() + System.lineSeparator() +
                "Position Type: " + job1.getPositionType() + System.lineSeparator() +
                "Core Competency: " + job1.getCoreCompetency() + System.lineSeparator();

        assertEquals(labelAndDataMsg, expected, job1.toString());
    }


}
