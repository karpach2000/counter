package com.shortnOtes;


import com.shortnOtes.robots.Counter;
import com.shortnOtes.robots.RobotModel;
import com.shortnOtes.robots.RobotProtokol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

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