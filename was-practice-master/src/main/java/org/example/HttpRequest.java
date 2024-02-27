package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }

    public boolean isGetRequest() {
        return requestLine.isGetResult();
    }

    public boolean matchPath(String path) {
        return requestLine.matchPath(path);
    }
}
