package com.alibaba.wireless.security.aopsdk.h;

import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.internal.interfaces.IWaStat;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReportData.java */
/* loaded from: classes.dex */
public class b {
    private int a;
    private int b;
    private String c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private long m;

    /* compiled from: ReportData.java */
    /* loaded from: classes.dex */
    public static final class a {
        private int a;
        private int b;
        private String c;
        private int d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;
        private long m;

        public a a(int i) {
            this.a = i;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(int i) {
            this.b = i;
            return this;
        }

        public a d(String str) {
            this.k = str;
            return this;
        }

        public a e(String str) {
            this.e = str;
            return this;
        }

        public a f(String str) {
            this.f = str;
            return this;
        }

        public a g(String str) {
            this.i = str;
            return this;
        }

        public a h(String str) {
            this.g = str;
            return this;
        }

        public a i(String str) {
            this.h = str;
            return this;
        }

        public a a(String str) {
            this.l = str;
            return this;
        }

        public a b(int i) {
            this.d = i;
            return this;
        }

        public a c(String str) {
            this.j = str;
            return this;
        }

        public a a(long j) {
            this.m = j;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.a = this.a;
            bVar.i = this.i;
            bVar.c = this.c;
            bVar.d = this.d;
            bVar.j = this.j;
            bVar.g = this.g;
            bVar.l = this.l;
            bVar.f = this.f;
            bVar.h = this.h;
            bVar.b = this.b;
            bVar.k = this.k;
            bVar.e = this.e;
            bVar.m = this.m;
            return bVar;
        }
    }

    public String toString() {
        return a().toString();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AppIconSetting.DEFAULT_LARGE_ICON, this.c);
            jSONObject.put("cid", this.a);
            jSONObject.put("sid", this.b);
            jSONObject.put(ReportManager.e, this.d);
            jSONObject.put(IRequestConst.PN, this.e);
            jSONObject.put("spm", this.f);
            jSONObject.put(SocialConstants.PARAM_ACT, this.g);
            jSONObject.put("appid", this.h);
            jSONObject.put("st", this.i);
            jSONObject.put("mp", this.j);
            jSONObject.put(com.alipay.sdk.m.l.b.k, this.k);
            jSONObject.put(IWaStat.KEY_CHECK_COMPRESS, this.l);
            jSONObject.put(ReportManager.f, this.m);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
