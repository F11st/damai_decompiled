package com.meizu.cloud.pushsdk.handler.a.c;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.d.a.C6001c;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.c.d */
/* loaded from: classes10.dex */
public class C6043d {
    private String a;
    private String b;
    private String c;
    private String d;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.handler.a.c.d$a */
    /* loaded from: classes10.dex */
    public static class C6044a {
        private String a;
        private String b;
        private String c;
        private String d;

        public C6044a a(String str) {
            this.a = str;
            return this;
        }

        public C6043d a() {
            return new C6043d(this);
        }

        public C6044a b(String str) {
            this.b = str;
            return this;
        }

        public C6044a c(String str) {
            this.c = str;
            return this;
        }

        public C6044a d(String str) {
            this.d = str;
            return this;
        }
    }

    public C6043d() {
    }

    public C6043d(C6044a c6044a) {
        this.a = !TextUtils.isEmpty(c6044a.a) ? c6044a.a : "";
        this.b = !TextUtils.isEmpty(c6044a.b) ? c6044a.b : "";
        this.c = !TextUtils.isEmpty(c6044a.c) ? c6044a.c : "";
        this.d = TextUtils.isEmpty(c6044a.d) ? "" : c6044a.d;
    }

    public static C6044a a() {
        return new C6044a();
    }

    public String b() {
        C6001c c6001c = new C6001c();
        c6001c.a("task_id", this.a);
        c6001c.a(PushConstants.SEQ_ID, this.b);
        c6001c.a(PushConstants.PUSH_TIMESTAMP, this.c);
        c6001c.a(PushConstants.DEVICE_ID, this.d);
        return c6001c.toString();
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }
}
