package com.wipro.tddexample.repository.impl;

import com.wipro.tddexample.repository.SubjectRepository;

import java.util.Arrays;
import java.util.List;

public class SubjectRepositoryStub implements SubjectRepository {

    @Override
    public List<String> getSubjects(String name) {

        return Arrays.asList("SocialScience", "Science", "Geography");
    }
}
