package com.wipro.tddexample.service;

import com.wipro.tddexample.repository.SubjectRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private SubjectRepository subjectRepository;

    public UserService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<String> filterSubjectsStartingWithS(String name) {
        List<String> subjects = subjectRepository.getSubjects(name);
        List<String> filteredSubjects = subjects.stream().filter(subject -> subject.startsWith("S")).collect(Collectors.toList());

        return filteredSubjects;
    }
}
