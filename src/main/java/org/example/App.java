package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run()
    {
        System.out.println("== 명언 앱 ==");

        long lastWiseSayingId = 0;
        List<WiseSaying> wiseSayings = new ArrayList<>();
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();


        while (true)
        {
            System.out.print("명령) ");

            String command = Container.getScanner().nextLine().trim();

            if (command.equals("종료"))
            {
                systemController.exit();
                break;
            }

            if (command.equals("등록"))
            {
                wiseSayingController.write();
            }

            if (command.equals("목록"))
            {
                wiseSayingController.list();
            }
        }
    }
}

