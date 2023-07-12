package com.alibaba.wireless.security.aopsdk.h;

import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.l.C4231b;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.internal.interfaces.IWaStat;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alibaba.wireless.security.aopsdk.h.b */
/* loaded from: classes.dex */
public class ReportData {
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
    /* renamed from: com.alibaba.wireless.security.aopsdk.h.b$a */
    /* loaded from: classes.dex */
    public static final class C3984a {
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

        public C3984a a(int i) {
            this.a = i;
            return this;
        }

        public C3984a b(String str) {
            this.c = str;
            return this;
        }

        public C3984a c(int i) {
            this.b = i;
            return this;
        }

        public C3984a d(String str) {
            this.k = str;
            return this;
        }

        public C3984a e(String str) {
            this.e = str;
            return this;
        }

        public C3984a f(String str) {
            this.f = str;
            return this;
        }

        public C3984a g(String str) {
            this.i = str;
            return this;
        }

        public C3984a h(String str) {
            this.g = str;
            return this;
        }

        public C3984a i(String str) {
            this.h = str;
            return this;
        }

        public C3984a a(String str) {
            this.l = str;
            return this;
        }

        public C3984a b(int i) {
            this.d = i;
            return this;
        }

        public C3984a c(String str) {
            this.j = str;
            return this;
        }

        public C3984a a(long j) {
            this.m = j;
            return this;
        }

        public ReportData a() {
            ReportData reportData = new ReportData();
            reportData.a = this.a;
            reportData.i = this.i;
            reportData.c = this.c;
            reportData.d = this.d;
            reportData.j = this.j;
            reportData.g = this.g;
            reportData.l = this.l;
            reportData.f = this.f;
            reportData.h = this.h;
            reportData.b = this.b;
            reportData.k = this.k;
            reportData.e = this.e;
            reportData.m = this.m;
            return reportData;
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
            jSONObject.put(C4231b.k, this.k);
            jSONObject.put(IWaStat.KEY_CHECK_COMPRESS, this.l);
            jSONObject.put(ReportManager.f, this.m);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
