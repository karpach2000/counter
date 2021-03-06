package com.shortnOtes.Sourse;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.shortnOtes.Sourse.constructor.Bodies.Counter.Counter;
import com.shortnOtes.Sourse.constructor.Bodies.MainPage.MainPage;
import com.shortnOtes.Sourse.constructor.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.StringWriter;

@Controller
public class HelloController {

    public class Todo {
        public String name="";
        public Todo(String name) {
            this.name=name;
        }

        // constructors, getters and setters
    }

    @RequestMapping(value="/")
    @ResponseBody
    String index()  throws IOException{
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("index.html");
        MainPage mainPage=new MainPage();
        Page page=new Page(mainPage);
        StringWriter writer = new StringWriter();
        m.execute(writer, page).flush();
        String html = writer.toString();
        return html;
    }

    @RequestMapping(value="/utils")
    @ResponseBody
    String utils()  throws IOException{
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("utils.html");
        Counter counter=new Counter();
        Page page=new Page(counter);

        StringWriter writer = new StringWriter();
        m.execute(writer, page).flush();
        String html = writer.toString();
        return html;
    }

    @RequestMapping(value="/countingManipulators")
    @ResponseBody
    String countingManipulator()  throws IOException{
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("countingManipulators.html");
        Page page=new Page();

        StringWriter writer = new StringWriter();
        m.execute(writer, page).flush();
        String html = writer.toString();
        return html;
    }
/*
    @RequestMapping( value = "/getFinalLinkOrientation" )
    @ResponseBody
    String getFinalLinkOrientation(@RequestParam( "manipulatorFormul" ) String manipulatorFormul) throws IOException {
        RobotProtokol robotProtokol=new RobotProtokol();
        RobotModel robot = robotProtokol.getRobotModelFromFormul(manipulatorFormul);
        com.shortnOtes.robots.Counter counter =new com.shortnOtes.robots.Counter();
        RobotModel.Joint joint = counter.getPosition(robot);
        String ans=robotProtokol.setRobotModelToFormul(joint);
        return  ans;

    }

*/

}