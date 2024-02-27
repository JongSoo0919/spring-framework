package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String urlPath;
    private QueryStrings queryString;
    public RequestLine(String requestLine) {
//        GET /calculate?operand1=11&operator=+&operand2=55 HTTP/1.1
        String [] tokens = requestLine.split(" ");
        this.method = tokens[0];

//        /calculate?operand1=11&operator=+&operand2=55
        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

//        쿼리스트링이 존재한단 얘기
        if(urlPathTokens.length == 2){
            queryString = new QueryStrings(urlPathTokens[1]);
        }
    }

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = new QueryStrings(queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(method + urlPath + queryString);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof RequestLine)) return false;
        RequestLine requestLine = (RequestLine) obj;
        return this.hashCode() == requestLine.hashCode();
    }

    public boolean isGetResult() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String path) {
        return this.urlPath.equals(path);
    }

    public QueryStrings getQueryStrings() {
        return this.queryString;
    }
}
