package com.wipro.tddexample.service;

import com.wipro.tddexample.repository.SubjectRepository;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceMockTest {

    private UserService userService;

    @Test
    public void testFilterSubjectsStartingWithS() {

        SubjectRepository subjectRepository = mock(SubjectRepository.class);
        List<String> subjects = Arrays.asList("SocialScience", "Science", "Geography");

        when(subjectRepository.getSubjects("Dummy")).thenReturn(subjects);

        userService = new UserService(subjectRepository);
        List<String> actual = userService.filterSubjectsStartingWithS("Dummy");

        assertEquals(2, actual.size());

    }

}