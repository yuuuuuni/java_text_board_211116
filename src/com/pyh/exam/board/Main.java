package com.pyh.exam.board;

import java.lang.reflect.Array;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    int articlesLastId = 0;
    Article lastArticle = null;  // 그냥 int i = 1; String a = "안녕" 처럼 그냥 저것도 변수타입 변수명 = 값이라고 생각하면 됨  Article이 변수타입, article이 변수명
    ArrayList<Article> articles = new ArrayList<Article>();

    // 테스트 데이터 3개 등록, 시작
    articles.add(new Article(1, "제목1", "내용1"));
    articles.add(new Article(2, "제목2", "내용2"));
    articles.add(new Article(3, "제목3", "내용3"));
    // 테스트 데이터 3개 등록, 끝

    while (true) {
      System.out.printf("명령) ");
      String cmd = sc.nextLine();

      if(cmd.equals("exit")) {
        System.out.println("입력된 명령어 : " + cmd);
        break;
      }
      else if(cmd.equals("/usr/article/list")) {

        System.out.println("- 게시물 리스트 -");
        System.out.println("--------------------");
        System.out.println("번호 / 제목");
        System.out.println("--------------------");

        for (Article article : articles) {
          System.out.println(article.id + "/" + article.title);
        }

      }
      else if(cmd.equals("/usr/article/detail")) {

        if(lastArticle == null) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }

        Article article = lastArticle;

        System.out.println("- 게시물 상세내용 -");
        System.out.println("번호 :" + article.id);
        System.out.println("제목 :" + article.title);
        System.out.println("내용 :" + article.body);

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
        lastArticle = article;  // article에 있는 객체가 lastArticle로 옮겨지는게 아니라 얘네 둘은 그냥 리모콘임 리모콘이 두개가 생기는 것임
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

    return String.format("id : %d, title : \"%s\", body : \"%s\"", id, title, body );
 }
}
