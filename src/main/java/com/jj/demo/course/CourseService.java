package com.jj.demo.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository cR;

    public List<Course> getAllCourses(String topicid) {
        List<Course> courseslist = new ArrayList<>();
        cR.findByTopicId(topicid).forEach(courseslist::add);;
        return courseslist;
    }

    public Course getCourse(String id) {
        return cR.findById(id).orElse(null);
    }
    void addCourse(Course newCourse){
        cR.save(newCourse);
    }
    void updateCourse(Course modCourse){
        cR.save(modCourse);
    }
    void deleteCourse(String id){
        cR.deleteById(id);
    }
}