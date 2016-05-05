package com.grapheople.lifeisquest.controllers.viewcontrollers;

import com.grapheople.lifeisquest.dao.UserRepository;
import com.grapheople.lifeisquest.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Steven Jee
 * @since v.
 */
@Controller
public class ViewController {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/greeting")
  public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
    model.addAttribute("name", name);
    return "greeting";
  }

  @RequestMapping("/users")
  public @ResponseBody
  List<User> getUserList() {
    return userRepository.findAll();
  }

}
