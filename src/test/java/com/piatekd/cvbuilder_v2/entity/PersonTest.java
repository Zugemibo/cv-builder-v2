package com.piatekd.cvbuilder_v2.entity;

import org.junit.jupiter.api.*;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class PersonTest {

    private Person person;

    @BeforeEach
    void initializePerson(){
        this.person = new Person();
    }
    @AfterEach
    void cleanUp(){
        this.person = null;
    }

    @Test
    void addSkill() {
        String skill1 = "someValue";
        person.addSkill(skill1);
        assertSame(skill1, person.getSkills().get(0));
    }

    @Test
    void addProfile() {
        String profile = "someValue";
        person.addProfile(profile);
        assertSame(profile, person.getProfiles().get(0));
    }

    @Test
    void addHobby() {
        String hobby = "someValue";
        person.addHobby(hobby);
        assertSame(hobby, person.getHobbies().get(0));
    }

    @Test
    void removeHobby() {
        String hobby = "someValue";
        person.addHobby(hobby);
        assertThat(person.getHobbies().size(), equalTo(1));
        person.removeHobby(hobby);
        assertThat(person.getHobbies().size(), equalTo(0));
    }

    @Test
    void removeSkill() {
        String skill = "someValue";
        person.addSkill(skill);
        assertThat(person.getSkills().size(), equalTo(1));
        person.removeSkill(skill);
        assertThat(person.getSkills().size(), equalTo(0));
    }

    @Test
    void removeProfile() {
        String profile = "someValue";
        person.addProfile(profile);
        assertThat(person.getProfiles().size(), equalTo(1));
        person.removeProfile(profile);
        assertThat(person.getProfiles().size(), equalTo(0));
    }

    @Test
    void addEducation() {
        Education educationCreated = new Education(1L, LocalDate.now(), LocalDate.now(), "Psychology", "Mexico City", "Master", "University of Mexico", "Some info blah blah blah", person);
        person.addEducation(educationCreated);

        List<Education> educationList = person.getEducationSet().stream().filter(education -> education.getId() == 1L).collect(Collectors.toList());
        assertTrue(educationCreated.equals(educationList.get(0)));
    }

    @Test
    void removeEducation() {
        Education educationCreated = new Education(1L, LocalDate.now(), LocalDate.now(), "Psychology", "Mexico City", "Master", "University of Mexico", "Some info blah blah blah", person);
        person.addEducation(educationCreated);

        assertThat(person.getEducationSet().size(), is(1));
        person.removeEducation(educationCreated);
        assertThat(person.getEducationSet().size(), is(0));
    }

    @Test
    void addExperience() {
        Experience experienceCreated = new Experience(1L, null, null, "Kraków", "Position", "Company", null, person);
        person.addExperience(experienceCreated);

        List<Experience> experienceList = person.getExperienceSet().stream().filter(experience -> experience.getId() == 1L).collect(Collectors.toList());
        assertTrue(experienceCreated.equals(experienceList.get(0)));
    }

    @Test
    void removeExperience() {
        Experience experienceCreated = new Experience(1L, null, null, "Kraków", "Position", "Company", null, person);
        person.addExperience(experienceCreated);
        assertThat(person.getExperienceSet().size(), equalTo(1));
        person.removeExperience(experienceCreated);
        assertTrue(person.getExperienceSet().size()==0);
    }

    @Test
    @Disabled("Not implemented yet.")
    void addAchievement() {
    }

    @Test
    @Disabled("Not implemented yet.")
    void removeAchievement() {
    }

    @Test
    void addLanguage() {
        ForeignLanguage language = new ForeignLanguage(1L, "english", "C1", null);
        person.addLanguage(language);

        List<ForeignLanguage> languageList = person.getLanguageSet().stream().filter(lang -> lang.getId() == 1L).collect(Collectors.toList());
        assertThat(language, equalToObject(languageList.get(0)));

    }

    @Test
    @Disabled("Not implemented yet.")
    void removeLanguage() {
    }
}