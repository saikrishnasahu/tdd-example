package com.wipro.tddexample.service;

import com.wipro.tddexample.repository.SubjectRepository;
import com.wipro.tddexample.repository.impl.SubjectRepositoryStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserServiceStubTest {


    @Test
    public void testFilterSubjectsStartingWithS() {

        SubjectRepository subjectRepository = new SubjectRepositoryStub();
        UserService userService = new UserService(subjectRepository);
        List<String> actual = userService.filterSubjectsStartingWithS("Dummy");

        assertEquals(2, actual.size());

    }

}