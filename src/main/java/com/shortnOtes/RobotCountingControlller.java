package com.shortnOtes;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.shortnOtes.Robots.Counter;
import com.shortnOtes.Robots.RobotModel;
import com.shortnOtes.Robots.RobotProtokol;
import com.shortnOtes.constructor.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.StringWriter;

@Controller
public class RobotCountingControlller {
    @RequestMapping( value = "/getFinalLinkOrientation" )
    @ResponseBody
    String getFinalLinkOrientation(@RequestParam( "manipulatorFormul" ) String manipulatorFormul) throws IOException {
        RobotProtokol robotProtokol=new RobotProtokol();
        RobotModel robot = robotProtokol.getRobotModelFromFormul(manipulatorFormul);
        Counter counter =new Counter();
        RobotModel.Joint joint = counter.getPosition(robot);
        String ans=robotProtokol.setRobotModelToFormul(joint);
        return  ans;

    }



}