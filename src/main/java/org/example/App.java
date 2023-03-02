package org.example;

import java.util.*;

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

            Rq rq = new Rq(command);
            switch (rq.getActionCode())
            {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
            }
        }
    }
}

