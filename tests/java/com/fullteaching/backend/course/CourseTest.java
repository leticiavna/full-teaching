package com.fullteaching.backend.course;

import com.fullteaching.backend.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void testEquals_shouldReturnFalseWhenObjectIsNotTheCourse() {
        Course otherCourse = new Course("GOVERNANÇA DE TI", "", teacher);
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
}