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
      String cmd = sc.nextLine();

      if(cmd.equals("exit")) {
        System.out.println("입력된 명령어 : " + cmd);
        break;
      }


      else if(cmd.equals("/usr/article/write")) {
        System.out.println("- 게시물 등록 -");
        articlesLastId++;
        int id = articlesLastId;

        System.out.printf("제목 : ");
        String title = sc.nextLine();
        System.out.printf("내용 : ");
        String body = sc.nextLine();



        Article article = new Article(id, title, body);
        System.out.println("생성된 게시물 객체 : " + article);

        System.out.println(article.id + "번 게시물이 등록되었습니다.");
      }
      else {
        System.out.println("입력된 명령어 : " + cmd);
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

  Article(int id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }


@Override
public String toString() {
  return String.format("{ id : " + id + ", title : " + title + ", body : " + body + "}" );
 }
}
