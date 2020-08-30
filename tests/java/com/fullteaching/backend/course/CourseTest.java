package com.fullteaching.backend.course;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    private Course course;
    private User teacher = new User("teacher1@gmail.com", "pass", "TEACHER", "", "TEACHER");

    @BeforeEach
    void setUp() {
        course = new Course("QUALIDADE E TESTE", "", teacher);
    }

    @Test
    void testEquals_shouldReturnFalseWhenObjectIsNull() {
        assertFalse(course.equals(null));
    }

    @Test
    void testEquals_shouldReturnTrueWhenObjectIsTheObjectItself() {
        assertTrue(course.equals(course));
    }

    // THIS TEST SHOW AN BUG IN CODE; EQUALS FUNCTION NEEDS TO BE IMPROVED
    @Test
    void testEquals_shouldReturnFalseWhenObjectIsNotTheCourse() {
        Course otherCourse = new Course("GOVERNANÇA DE TI", "", teacher);
        otherCourse.setId(400);
        assertFalse(course.equals(otherCourse));
    }

    @Test
    void testEquals_shouldReturnFalseWhenObjectIsNotACourseObject() {
        assertFalse(course.equals(teacher));
    }

    @Test
    void testEquals_shouldReturnTrueWhenObjectIsEqual() {
        Course otherCouse = new Course("QUALIDADE E TESTE", "", teacher);
        assertTrue(course.equals(otherCouse));
    }

    @Test
    void testToString_shouldReturnCourse() {
        String courseName = "Course[title: \"QUALIDADE E TESTE\", teacher: \"TEACHER\", #attenders: 0, #sessions: 0]";
        assertEquals(courseName, course.toString());
    }


    // GETTERS AND SETTERS TO INCREASE CODE COVERAGE
    @Test
    void testGetSetId() {
        course.setId(90);
        assertEquals(90, course.getId());
    }

    @Test
    void testGetSetTile() {
        course.setTitle("GOVERNANÇA DE TI");
        assertEquals("GOVERNANÇA DE TI", course.getTitle());
    }

    @Test
    void testGetSetTeacher() {
        User newTeacher = Mockito.mock(User.class);
        course.setTeacher(newTeacher);
        assertEquals(newTeacher, course.getTeacher());
    }

    @Test
    void testGetSetCourseDetails() {
        CourseDetails details = Mockito.mock(CourseDetails.class);
        course.setCourseDetails(details);
        assertEquals(details, course.getCourseDetails());
    }

    @Test
    void testGetSetImage() {
        String imageURL = "/../assets/images/default_session_image.png";
        course.setImage(imageURL);
        assertEquals(imageURL, course.getImage());
    }

    @Test
    void testGetSetSessions() {
        Session session = Mockito.mock(Session.class);
        Set sessionSet = new HashSet();
        sessionSet.add(session);

        course.setSessions(sessionSet);
        assertEquals(sessionSet, course.getSessions());
    }

    @Test
    void testGetSetAttenders() {
        User attender = Mockito.mock(User.class);
        Set attenders = new HashSet();
        attenders.add(attender);

        course.setAttenders(attenders);
        assertEquals(attenders, course.getAttenders());
    }
}