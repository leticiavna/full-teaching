package com.fullteaching.backend.user;

import com.fullteaching.backend.course.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    private User teacher;

    @BeforeEach
    void setUp() {
        user = new User("ana@gmail.com", "pass", "ANA", "", "STUDENT");
        teacher = new User("teacher1@gmail.com", "pass", "TEACHER", "", "TEACHER");
    }

    @Test
    void testEquals_shouldReturnFalseWhenObjectIsNull() {
        assertFalse(user.equals(null));
    }

    @Test
    void testEquals_shouldReturnTrueWhenObjectIsTheObjectItself() {
        assertTrue(user.equals(user));
    }

    @Test
    void testEquals_shouldReturnFalseWhenObjectIsNotTheUser() {
        assertFalse(user.equals(teacher));
    }

    @Test
    void testEquals_shouldReturnFalseWhenObjectIsNotAUserObject() {
        Course course = new Course("QUALIDADE E TESTE", "", teacher);
        assertFalse(user.equals(course));
    }

    @Test
    void testEquals_shouldReturnTrueWhenObjectIsEqual() {
        User otherUser = new User("ana@gmail.com", "pass", "ANA", "", "STUDENT");
        assertTrue(user.equals(otherUser));
    }

    @Test
    void testHashCode_shouldReturnHashCode() {
        assertEquals(user.getName().hashCode(), user.hashCode());
    }

    @Test
    void testToString_shouldReturnNickname() {
        assertEquals("ANA", user.toString());
    }

}