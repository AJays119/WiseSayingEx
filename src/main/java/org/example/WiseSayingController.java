package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class WiseSayingController
{
    private long lastWiseSayingId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingController()
    {
        lastWiseSayingId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void write()
    {
        long id = lastWiseSayingId + 1;
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();

        System.out.print("작가 : ");
        String authorName = Container.getScanner().nextLine().trim();

        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", lastWiseSayingId);
        lastWiseSayingId = id;
    }

    public void list()
    {
        System.out.println("번호 | 작가 | 명언");
        System.out.println("-".repeat(30));

        for (int i = wiseSayings.size() - 1; i >= 0; i--)
        {
            WiseSaying wiseSaying = wiseSayings.get(i);

            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(),
                    wiseSaying.getContent());
        }
    }

    public void remove(Rq rq)
    {
        int id = -1;

        try
        {
            id = Integer.parseInt(rq.getParam("id"));
        }

        catch (NumberFormatException e)
        {
            System.out.println("id를 입력해주세요.");
            return;
        }

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }
}
