package com.wipro.tddexample.service;

import com.wipro.tddexample.repository.SubjectRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceMockitoTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private SubjectRepository subjectRepository;

    @Test
    public void testFilterSubjectsStartingWithS() {

        List<String> subjects = Arrays.asList("SocialScience", "Science", "Geography");

        when(subjectRepository.getSubjects("Dummy")).thenReturn(subjects);

        List<String> actual = userService.filterSubjectsStartingWithS("Dummy");

        assertEquals(2, actual.size());

    }

}