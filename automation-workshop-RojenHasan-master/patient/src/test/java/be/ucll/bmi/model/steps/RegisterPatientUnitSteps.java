package be.ucll.bmi.model.steps;

import be.ucll.bmi.data.Persona;
import be.ucll.bmi.model.Gender;
import be.ucll.bmi.model.Patient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterPatientUnitSteps extends UnitSteps {

    @Given("Martha has chosen to add Sara as a patient")
    public void martha_has_chosen_to_add_sara_as_a_patient() {
        LocalDate date = LocalDate.of(Integer.parseInt("1996"), Integer.parseInt("03"), Integer.parseInt("03"));

        Patient patient = new Patient("ssn",date, Gender.MALE);
        context.setPatient(patient);
    }
    @When("Martha registers {word} as SSN")
    public void martha_registers_as_ssn(String ssn) {
        Patient patient = context.getPatient();
        patient.setSocialSecurityNumber(ssn);
        List<String> errors = validatePatient(patient);
        context.setErrors(errors);
    }
    @Then("Sara should be registered as a patient")
    public void sara_should_be_registered_as_a_patient() {
        List<String> errors = context.getErrors();
        assertEquals(0,context.getErrors().size());
    }
//////////////////////

    @Then("Martha should be given an error message about the invalid SSN")
    public void martha_should_be_given_an_error_message_about_the_invalid_ssn() {
        List<String> errors = context.getErrors();
        assertEquals(1,context.getErrors().size());
    }
    ////////////////////////////

    @Given("today's date is {date}")
    public void today_s_date_is(LocalDate date) {
        context.setDate(date);


    }
    @When("Martha registers {date} as birth date for the new patient")
    public void martha_registers_as_birth_date_for_the_new_patient(LocalDate date) {
        //long days = DAYS.between(context.getDate(), LocalDate.now());
        Patient patient = context.getPatient();
        patient.setBirthDate(date);
        List<String> errors = validatePatient(patient);
        context.setErrors(errors);
    }
    @Then("Martha should be given an error message explaining that the patient is not old enough")
    public void martha_should_be_given_an_error_message_explaining_that_the_patient_is_not_old_enough() {
        //List<String> errors = context.getErrors();
        assertEquals(1,context.getErrors().size());
    }


}
