package com.pyh.exam.board;

import java.net.StandardSocketOptions;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);



    while (true) {

      System.out.printf("명령) ");
      String str = sc.nextLine();

      if(str.equals("exit")) {
        break;
      }

      else if(str.equals("/usr/article/write")) {
        System.out.println("- 게시물 등록 -");
        System.out.printf("제목 : ");
        String title = sc.nextLine();
        System.out.printf("내용 : ");
        String body = sc.nextLine();
        int id = 1;
        System.out.println(id + "번 게시물이 등록되었습니다.");
      }
      else {
        System.out.printf("입력된 명령어 : " + str);
      }
    }


//    System.out.println("== 게시판 v 0.1 ==");
//    System.out.println("== 프로그램 시작 ==");
//
//    while(true) {
//      System.out.printf("명령) ");
//      str = sc.nextLine();
//
//      if(str.equals("exit")) {
//        break;
//      }
//
//    }
//
//    System.out.println("입력된 명령어 : " + str);
//    System.out.println("== 프로그램 종료 ==");
//
//    sc.close();
  }
}
