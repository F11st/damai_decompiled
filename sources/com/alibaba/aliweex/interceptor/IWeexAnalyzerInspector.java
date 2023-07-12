package com.alibaba.aliweex.interceptor;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IWeexAnalyzerInspector {

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class a {
        public String a;
        public String b;
        public Map<String, String> c;

        public a(String str, String str2, Map<String, String> map) {
            this.a = str;
            this.b = str2;
            this.c = map;
        }

        public String toString() {
            return "InspectorRequest{api='" + this.a + "', method='" + this.b + "', headers=" + this.c + '}';
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class b {
        public String a;
        public int b;
        public Map<String, List<String>> c;
        public String d;

        public b(String str, String str2, int i, Map<String, List<String>> map) {
            this.d = str;
            this.a = str2;
            this.b = i;
            this.c = map;
        }

        public String toString() {
            return "InspectorResponse{data='" + this.a + "', statusCode=" + this.b + ", headers=" + this.c + ", api='" + this.d + "'}";
        }
    }

    boolean isEnabled();

    void onRequest(String str, a aVar);

    void onResponse(String str, b bVar);
}
