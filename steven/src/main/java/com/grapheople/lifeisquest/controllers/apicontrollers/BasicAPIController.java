package com.grapheople.lifeisquest.controllers.apicontrollers;

import com.google.common.collect.Maps;

import com.grapheople.lifeisquest.dao.QuestRepository;
import com.grapheople.lifeisquest.dao.UserRepository;
import com.grapheople.lifeisquest.domain.Quest;
import com.grapheople.lifeisquest.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Steven Jee
 * @since v.
 */
@RestController
public class BasicAPIController {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private QuestRepository questRepository;

  @RequestMapping(method = RequestMethod.GET, path = "/api/user/{userId}")
  public User getUser(@PathVariable long userId){
    User user = userRepository.findOne(userId);
    return user;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/api/quest")
  public List<Quest> getQuests(){
    List<Quest> quests = questRepository.findAll();
    return quests;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/api/quest/{userId}")
  public Quest getQuest(@PathVariable long userId){
    Quest quest = questRepository.findOne(userId);
    return quest;
  }


}
