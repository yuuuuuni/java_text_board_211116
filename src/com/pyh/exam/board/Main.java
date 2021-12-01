package com.pyh.exam.board;

import java.util.*;

public class Main {
       static void makeTestData(List<Article> articles) {
           articles.add(new Article(1, "제목1", "내용1"));
           articles.add(new Article(2, "제목2", "내용2"));
           articles.add(new Article(3, "제목3", "내용3"));
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 게시판 v 0.1 ==");
        System.out.println("== 프로그램 시작 ==");

        int articlesLastId = 0;
        List<Article> articles = new ArrayList<>();


        makeTestData(articles);

        if(articles.size() > 0) {
            articlesLastId = articles.get(articles.size()-1).id;
        }



        while(true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine();

            Rq rq = new Rq(cmd);
            Map<String, String> params = rq.getParams();

            if(rq.getUrlPath().equals("exit")) {
                break;
            }
            else if(rq.getUrlPath().equals("/usr/article/list")) {
                System.out.println("- 게시물 리스트 -");
                System.out.println("--------------------");
                System.out.println("번호 / 제목");
                System.out.println("--------------------");

                for(int i = articles.size()-1; i >= 0; i--) {
                    Article article = articles.get(i);
                    System.out.println(article.id + " / " + article.title);
                }
            }
            else if(rq.getUrlPath().equals("/usr/article/detail")) {
                if(params.containsKey("id") == false) { // containsKey는 params에 id 있냐라고 묻는 것
                    System.out.println("id를 입력해주세요.");
                    continue;
                }

                int id = 0;
                try { // try - catch 문 쓸 때 변수는 밖에다가 선언하는 것이 좋음
                    id = Integer.parseInt(params.get("id"));
                }
                catch(NumberFormatException e) {
                    System.out.println("id를 정수 형태로 입력해주세요.");
                    continue;
                }



                if(id > articles.size()) {
                    System.out.println("게시물이 존재하지 않습니다.");
                    continue;
                }

                Article article = articles.get(id-1);

                System.out.println("- 게시물 상세내용 -");
                System.out.println("번호 : " + article.id);
                System.out.println("제목 : " + article.title);
                System.out.println("내용 : " + article.body);

            }
            else if(rq.getUrlPath().equals("/usr/article/write")) {
                System.out.println("- 게시물 등록 -");
                System.out.printf("제목 : ");
                String title = sc.nextLine();
                System.out.printf("내용 : ");
                String body = sc.nextLine();

                articlesLastId++;
                int id = articlesLastId;

                Article article = new Article(id, title, body);
                articles.add(article);


                System.out.println("생성된 게시물 객체 : " + article);
                System.out.println(id + "번 게시물이 입력되었습니다.");
            }
            else {
                System.out.println("입력된 명령어) " + cmd);
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
        return String.format("{id : %d, title : \"%s\", body : \"%s\"}", id, title, body);
    }
}

class Rq {
    private String url;
    private String urlPath;
    private Map<String, String> params;

    // 필드추가가능

    // 수정가능
    Rq(String url) {
        this.url = url;
        urlPath = Util.getUrlPathFromUrl(this.url);
        params = Util.getParamsFromUrl(this.url);
    }

    // 수정가능, if문 금지
    public Map<String, String> getParams() {
        return params;
    }

    // 수정가능, if문 금지
    public String getUrlPath() {
        return urlPath;
    }
}

// 수정불가능
class Util {
    static Map<String, String> getParamsFromUrl(String url) {
        Map<String, String> params = new HashMap<>();
        String[] urlBits = url.split("\\?", 2);

        if (urlBits.length == 1) {
            return params;
        }

        String queryStr = urlBits[1];
        for (String bit : queryStr.split("&")) {
            String[] bits = bit.split("=", 2);
            if (bits.length == 1) {
                continue;
            }
            params.put(bits[0], bits[1]);
        }

        return params;
    }

    static String getUrlPathFromUrl(String url) {
        return url.split("\\?", 2)[0];
    }
}


