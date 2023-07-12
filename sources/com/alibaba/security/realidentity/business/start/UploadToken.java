package com.alibaba.security.realidentity.business.start;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UploadToken implements Serializable {
    public String bucket;
    public String endPoint;
    public long expired;
    public String key;
    public String path;
    public String secret;
    public String token;

    public String getBucket() {
        return this.bucket;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public long getExpired() {
        return this.expired;
    }

    public String getKey() {
        return this.key;
    }

    public String getPath() {
        return this.path;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getToken() {
        return this.token;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setEndPoint(String str) {
        this.endPoint = str;
    }

    public void setExpired(long j) {
        this.expired = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
