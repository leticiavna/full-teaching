package com.fullteaching.backend.user;

import com.fullteaching.backend.course.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    void testEquals_shouldReturnFalseWhenObjectHasSameNameButDifferentId() {
        User newUser = new User("ana@gmail.com", "pass", "ANA", "PICTUREURL", "STUDENT");
        newUser.setId((long) 100);
        assertFalse(user.equals(newUser));
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

    @Test
    void testPicture_IfPictureIsNullThenSetDefaultPicture() {
        User newUser = new User("beyonce@email.com", "pass", "BEYONCE", null, "TEACHER");
        String picUrl = "/../assets/images/default_session_image.png";
        assertEquals(picUrl, newUser.getPicture());
    }

    @Test
    void testPicture_IfPictureIsEmptyStringThenSetDefaultPicture() {
        User newUser = new User("lanadelrey@email.com", "pass", "LANA DEL REY", "", "TEACHER");
        String picUrl = "/../assets/images/default_session_image.png";
        assertEquals(picUrl, newUser.getPicture());
    }

    @Test
    void testPicture_IfPictureIsGivenThenUsePicture() {
        User newUser = new User("dojacat@email.com", "pass", "DOJA CAT", "PICTUREURL", "TEACHER");
        assertEquals("PICTUREURL", newUser.getPicture());
    }

    // TESTING GETTERS AND SETTERS TO INCREASE CODE COVERAGE
    @Test
    void testGetSetId() {
        user.setId((long) 9);
        assertEquals(9, user.getId());
    }

    @Test
    void testGetSetName() {
        user.setName("adele@email.com");
        assertEquals("adele@email.com", user.getName());
    }

    @Test
    void testGetSetPasswordHash() {
        user.setPasswordHash("PASSWORDHASH");
        assertEquals("PASSWORDHASH", user.getPasswordHash());
    }

    @Test
    void testGetSetRoles() {
        String[] roles = {"STUDENT", "TEACHER"};
        user.setRoles(Arrays.asList(roles));
        assertEquals(Arrays.asList(roles), user.getRoles());
    }

    @Test
    void testGetSetNickname() {
        user.setNickName("ADELE");
        assertEquals("ADELE", user.getNickName());
    }

    @Test
    void testGetSetPicture() {
        String picture = "PICTUREURL";
        user.setPicture(picture);
        assertEquals(picture, user.getPicture());
    }

    @Test
    void testGetSetRegistrationDate() {
        user.setRegistrationDate(1598820320);
        assertEquals(1598820320, user.getRegistrationDate());
    }

    @Test
    void testGetSetCourses() {
        Set courses = new HashSet<Course>();
        Course course = Mockito.mock(Course.class);
        courses.add(course);

        user.setCourses(courses);
        assertEquals(courses, user.getCourses());
    }
}