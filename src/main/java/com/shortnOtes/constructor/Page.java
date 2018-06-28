package com.shortnOtes.constructor;

public class Page {
    public  MainMenu mainMenu=new MainMenu();
    public  Advertising advertising=new Advertising();
    public  String hay="привет";
    public  Object pageBody;//тело страницы

    public Page()
    {
        init();

    }
    public Page(Object pageBody)
    {
        this.pageBody=pageBody;
        init();

    }

    private void init()
    {


        //****Основное меню*****//
        mainMenu.addItem("Главная","/");
        mainMenu.addItem("Мелкие утилиты","/utils");
        mainMenu.addItem("Расчет манипуляторов","/countingManipulators");
        //****Сайтовые рекомендации*****//
        advertising.addItem("Продажа электронного оборудования и ПО.","http://oxigen-lpkm.ru");
        advertising.addItem("Online среда разработки под STM","https://www.mbed.com");
        advertising.addItem("Описание метода денавита хартенберга","http://tmm-umk.bmstu.ru/lectures/lect_20.htm");

    }
}
