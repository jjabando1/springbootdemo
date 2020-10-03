package com.jj.demo.course;

import java.util.List;

import com.jj.demo.topic.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService cS; //inject dependency

    @RequestMapping("/topics/{topicid}/courses")
    public List<Course> getAllCourses(@PathVariable String topicid){
        return cS.getAllCourses(topicid);
    }

    @RequestMapping("/topics/{topicid}/courses/{courseid}")
    public Course getCourse(@PathVariable String courseid){
        return cS.getCourse(courseid);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicid}/courses")
    public void addCourse(@RequestBody Course newCourse, @PathVariable String topicid){
        newCourse.setTopic(new Topic(topicid, "", ""));
        cS.addCourse(newCourse);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicid}/courses/{id}")
    public void updateCourse(@RequestBody Course modCourse, @PathVariable String topicid){
        modCourse.setTopic(new Topic(topicid, "", ""));
        cS.updateCourse(modCourse);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicid}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        cS.deleteCourse(id);
    }
}