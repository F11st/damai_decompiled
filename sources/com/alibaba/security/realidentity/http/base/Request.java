package com.alibaba.security.realidentity.http.base;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Request {
    final String body;
    final String method;
    final String path;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Builder {
        String bodyJSON;
        String method;
        String path;

        public Builder body(String str) {
            this.bodyJSON = str;
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder method(String str) {
            this.method = str;
            return this;
        }

        public Builder path(String str) {
            this.path = str;
            return this;
        }
    }

    public Request(Builder builder) {
        this.method = builder.method;
        this.path = builder.path;
        this.body = builder.bodyJSON;
    }

    public String body() {
        return this.body;
    }

    public String getBodyJSON() {
        return this.body;
    }

    public String method() {
        return this.method;
    }

    public String path() {
        return this.path;
    }
}
