package com.talentofuturo.evaluacion1.calvaradoa;

import com.talentofuturo.evaluacion1.calvaradoa.service.IMenuManager;
import com.talentofuturo.evaluacion1.calvaradoa.service.MenuManager;
import com.talentofuturo.evaluacion1.calvaradoa.service.TaskManager;

public class App 
{    
    public static void main( String[] args )
    {
    	TaskManager taskManager = new TaskManager();
        IMenuManager menu = new MenuManager(taskManager);

        while (true) {
            menu.showMenu();
            menu.getReponse();
        }
    }
}
