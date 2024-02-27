package org.example.gradecalculator;

import java.util.List;

public class Courses {
    private List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourse)
                .sum();
    }

    public int calculateToTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
