package mtopsdk.network.domain;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class Response {
    public final ResponseBody body;
    public final int code;
    public final Map<String, List<String>> headers;
    public final String message;
    public final Request request;
    public final NetworkStats stat;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Builder {
        ResponseBody body;
        int code = -1;
        Map<String, List<String>> headers;
        String message;
        Request request;
        NetworkStats stat;

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            if (this.request != null) {
                return new Response(this);
            }
            throw new IllegalStateException("request == null");
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public Builder headers(Map<String, List<String>> map) {
            this.headers = map;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder request(Request request) {
            this.request = request;
            return this;
        }

        public Builder stat(NetworkStats networkStats) {
            this.stat = networkStats;
            return this;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Response{ code=");
        sb.append(this.code);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", headers");
        sb.append(this.headers);
        sb.append(", body");
        sb.append(this.body);
        sb.append(", request");
        sb.append(this.request);
        sb.append(", stat");
        sb.append(this.stat);
        sb.append("}");
        return sb.toString();
    }

    private Response(Builder builder) {
        this.request = builder.request;
        this.code = builder.code;
        this.message = builder.message;
        this.headers = builder.headers;
        this.body = builder.body;
        this.stat = builder.stat;
    }
}
