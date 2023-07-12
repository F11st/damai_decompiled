package mtopsdk.network.domain;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.network.util.NetworkUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class Request {
    public final String api;
    public final String appKey;
    public final String authCode;
    @Deprecated
    public final int bizId;
    public final String bizIdStr;
    public final RequestBody body;
    public final int connectTimeoutMills;
    public final int env;
    public String fullTraceId;
    public final Map<String, String> headers;
    public final String method;
    public final int readTimeoutMills;
    public final Object reqContext;
    public final int retryTimes;
    public final String seqNo;
    public final String url;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Builder {
        String api;
        String appKey;
        String authCode;
        @Deprecated
        int bizId;
        String bizIdStr;
        RequestBody body;
        int connectTimeoutMills;
        int env;
        Map<String, String> headers;
        String method;
        int readTimeoutMills;
        Object reqContext;
        int retryTimes;
        String seqNo;
        String url;

        public Builder api(String str) {
            this.api = str;
            return this;
        }

        public Builder appKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder authCode(String str) {
            this.authCode = str;
            return this;
        }

        @Deprecated
        public Builder bizId(int i) {
            this.bizId = i;
            return this;
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder connectTimeout(int i) {
            if (i > 0) {
                this.connectTimeoutMills = i;
            }
            return this;
        }

        public Builder env(int i) {
            this.env = i;
            return this;
        }

        public Builder headers(Map<String, String> map) {
            if (map != null) {
                this.headers = map;
            }
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            if (str != null && str.length() != 0) {
                if (requestBody == null && NetworkUtils.requiresRequestBody(str)) {
                    throw new IllegalArgumentException("method " + str + " must have a request body.");
                }
                this.method = str;
                this.body = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method == null || method.length() == 0");
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder readTimeout(int i) {
            if (i > 0) {
                this.readTimeoutMills = i;
            }
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.remove(str);
            return this;
        }

        public Builder reqContext(Object obj) {
            this.reqContext = obj;
            return this;
        }

        public Builder retryTimes(int i) {
            this.retryTimes = i;
            return this;
        }

        public Builder seqNo(String str) {
            this.seqNo = str;
            return this;
        }

        public Builder setHeader(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.headers.put(str, str2);
            }
            return this;
        }

        public Builder url(String str) {
            if (str != null) {
                this.url = str;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public Builder() {
            this.connectTimeoutMills = 15000;
            this.readTimeoutMills = 15000;
            this.method = "GET";
            this.headers = new HashMap();
        }

        public Builder bizId(String str) {
            this.bizIdStr = str;
            return this;
        }

        private Builder(Request request) {
            this.connectTimeoutMills = 15000;
            this.readTimeoutMills = 15000;
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.headers = request.headers;
            this.seqNo = request.seqNo;
            this.connectTimeoutMills = request.connectTimeoutMills;
            this.readTimeoutMills = request.readTimeoutMills;
            this.retryTimes = request.retryTimes;
            this.bizId = request.bizId;
            this.bizIdStr = request.bizIdStr;
            this.appKey = request.appKey;
            this.authCode = request.authCode;
            this.reqContext = request.reqContext;
            this.api = request.api;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface Environment {
        public static final int DAILY = 2;
        public static final int ONLINE = 0;
        public static final int PRE = 1;

        /* compiled from: Taobao */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes11.dex */
        public @interface Definition {
        }
    }

    public String header(String str) {
        return this.headers.get(str);
    }

    public boolean isHttps() {
        String str = this.url;
        if (str != null) {
            return str.startsWith("https");
        }
        return false;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public void setHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.headers.put(str, str2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Request{ url=");
        sb.append(this.url);
        sb.append(", method=");
        sb.append(this.method);
        sb.append(", appKey=");
        sb.append(this.appKey);
        sb.append(", authCode=");
        sb.append(this.authCode);
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", body=");
        sb.append(this.body);
        sb.append(", seqNo=");
        sb.append(this.seqNo);
        sb.append(", connectTimeoutMills=");
        sb.append(this.connectTimeoutMills);
        sb.append(", readTimeoutMills=");
        sb.append(this.readTimeoutMills);
        sb.append(", retryTimes=");
        sb.append(this.retryTimes);
        sb.append(", bizId=");
        sb.append(!TextUtils.isEmpty(this.bizIdStr) ? this.bizIdStr : String.valueOf(this.bizId));
        sb.append(", env=");
        sb.append(this.env);
        sb.append(", reqContext=");
        sb.append(this.reqContext);
        sb.append(", api=");
        sb.append(this.api);
        sb.append("}");
        return sb.toString();
    }

    private Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
        this.seqNo = builder.seqNo;
        this.connectTimeoutMills = builder.connectTimeoutMills;
        this.readTimeoutMills = builder.readTimeoutMills;
        this.retryTimes = builder.retryTimes;
        this.bizId = builder.bizId;
        this.bizIdStr = builder.bizIdStr;
        this.appKey = builder.appKey;
        this.authCode = builder.authCode;
        this.env = builder.env;
        this.reqContext = builder.reqContext;
        this.api = builder.api;
    }
}
