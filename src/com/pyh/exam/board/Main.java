package com.pyh.exam.board;

import java.net.StandardSocketOptions;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    int articlesLastId = 0;

    while (true) {
      System.out.printf("명령) ");
      String str = sc.nextLine();

      if(str.equals("exit")) {
        System.out.println("입력된 명령어 : " + str);
        break;
      }

      else if(str.equals("/usr/article/write")) {
        System.out.println("- 게시물 등록 -");
        System.out.printf("제목 : ");
        String title = sc.nextLine();
        System.out.printf("내용 : ");
        String body = sc.nextLine();

        id = articlesLastId + 1;
        articlesLastId = id;

        Article article = new Article();
        article.id = id;
        article.title = title;
        article.body = body;
        System.out.println("생성된 게시물 객체 : " + article);

        System.out.println(article.id + "번 게시물이 등록되었습니다.");
      }
      else {
        System.out.println("입력된 명령어 : " + str);
      }
    }

        System.out.println("== 프로그램 종료 ==");

        sc.close();


  }
}


class Article {
  int id;
  String title;
  String body;

}
