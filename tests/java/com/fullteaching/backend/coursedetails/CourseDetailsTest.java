package com.fullteaching.backend.coursedetails;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.filegroup.FileGroup;
import com.fullteaching.backend.forum.Forum;
import com.fullteaching.backend.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Testa Getters e Setters pois não há outros métodos nessa classe
class CourseDetailsTest {
    private User teacher = new User("teacher1@gmail.com", "pass", "TEACHER", "", "TEACHER");
    private Course course = new Course("QUALIDADE E TESTE", "", teacher);
    private CourseDetails details = new CourseDetails();

    @Test
    void getId() {
        details.setId(1);
        assertEquals(1, details.getId());
    }


    @Test
    void getInfo() {
        details.setInfo("Curso da Uff em 2020");
        assertEquals("Curso da Uff em 2020", details.getInfo());
    }

    @Test
    void getForum() {
        Forum forum = new Forum();
        details.setForum(forum);
        assertEquals(forum, details.getForum());
    }

    @Test
    void getFiles() {
        List<FileGroup> files = new ArrayList<FileGroup>();
        details.setFiles(files);
        assertEquals(files, details.getFiles());
    }

    @Test
    void getCourse() {
        details.setCourse(course);
        assertEquals(course, details.getCourse());
    }

    @Test
    void testConstructorWithCourse() {
        Course course = Mockito.mock(Course.class);
        CourseDetails courseDetails = new CourseDetails(course);

        assertEquals(course, courseDetails.getCourse());
    }

}