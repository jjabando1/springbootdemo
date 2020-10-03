package com.jj.demo.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository tR;

    @Autowired
    public TopicService(TopicRepository tR){
        this.tR = tR;
        tR.save(new Topic("1", "Java", "OOP Language"));
    }

    public List<Topic> getAllTopics() {
        List<Topic> topicslist = new ArrayList<>();
        tR.findAll().forEach(topicslist::add);
        return topicslist;
    }

    public Topic getTopic(String id) {
        return tR.findById(id).orElse(null);
    }
    void addTopic(Topic newtopic){
        tR.save(newtopic);
    }
    void updateTopic(Topic modtopic){
        tR.save(modtopic);
    }
    void deleteTopic(String id){
        tR.deleteById(id);
    }
}