package com.alibaba.aliweex.interceptor.mtop;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.interceptor.C3093a;
import com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.tao.remotebusiness.RemoteBusiness;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import tb.a31;
import tb.b31;
import tb.kp2;
import tb.sj1;
import tb.x12;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MtopTracker {
    private static boolean g = true;
    private sj1 a;
    private IWeexAnalyzerInspector b;
    private final int c = kp2.a();
    @Nullable
    private String d;
    private String e;
    private x12 f;

    private MtopTracker() {
        if (WXEnvironment.isApkDebugable()) {
            this.a = sj1.d();
            this.b = C3093a.a();
            WXLogUtils.d("MtopTracker", "Create new instance " + toString());
        }
    }

    private boolean i() {
        sj1 sj1Var;
        return g && WXEnvironment.isApkDebugable() && (sj1Var = this.a) != null && sj1Var.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j() {
        if (this.d == null) {
            this.d = String.valueOf(this.c);
        }
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str) {
        if (i()) {
            this.a.f(j(), "application/json", null, new ByteArrayInputStream(str.getBytes()), false);
            this.a.k(j());
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MtopResponse l(MtopResponse mtopResponse, b31 b31Var) {
        if (i() && mtopResponse != null && mtopResponse.getBytedata() != null) {
            this.a.f(j(), b31Var.d(), b31Var.b(), new ByteArrayInputStream(mtopResponse.getBytedata()), false);
            this.a.k(j());
        }
        return mtopResponse;
    }

    public static MtopTracker m() {
        return new MtopTracker();
    }

    public void n(String str, final String str2) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (i()) {
            this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.mtop.MtopTracker.3
                @Override // java.lang.Runnable
                public void run() {
                    WXLogUtils.d("MtopTracker", "onFailed -> " + str2);
                    MtopTracker.this.a.e(MtopTracker.this.j(), str2);
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                this.b.onResponse("mtop", new IWeexAnalyzerInspector.C3092b(str, str2, 200, null));
            } catch (Exception e) {
                WXLogUtils.e("MtopTracker", e.getMessage());
            }
        }
    }

    public void o(final String str) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (i()) {
            this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.mtop.MtopTracker.5
                @Override // java.lang.Runnable
                public void run() {
                    b31 b31Var = new b31();
                    b31Var.h(MtopTracker.this.j());
                    JSONObject parseObject = JSON.parseObject(str);
                    b31Var.a("Content-Type", "application/json");
                    for (String str2 : parseObject.keySet()) {
                        if (!"data".equals(str2)) {
                            b31Var.a(str2, parseObject.getString(str2));
                        }
                    }
                    b31Var.i(parseObject.getString("api"));
                    b31Var.m(parseObject.getIntValue("code"));
                    b31Var.l(parseObject.getString("ret"));
                    b31Var.k(!"0".equals(parseObject.getString("isFromCache")));
                    MtopTracker.this.a.i(b31Var);
                    MtopTracker.this.k(JSON.parseObject(str).getString("data"));
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                JSONObject parseObject = JSON.parseObject(str);
                this.b.onResponse("mtop", new IWeexAnalyzerInspector.C3092b(parseObject.getString("api"), str, parseObject.getIntValue("code"), null));
            } catch (Exception e) {
                WXLogUtils.e("MtopTracker", e.getMessage());
            }
        }
    }

    public void p(final MtopResponse mtopResponse) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (i()) {
            this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.mtop.MtopTracker.2
                @Override // java.lang.Runnable
                public void run() {
                    WXLogUtils.d("MtopTracker", "onResponse -> " + mtopResponse.getApi());
                    if (MtopTracker.this.f.c()) {
                        MtopTracker.this.f.d();
                    }
                    b31 b31Var = new b31();
                    b31Var.h(MtopTracker.this.j());
                    b31Var.i(MtopTracker.this.e);
                    b31Var.m(mtopResponse.getResponseCode());
                    b31Var.l(mtopResponse.getRetCode());
                    b31Var.k(mtopResponse.getSource() != MtopResponse.ResponseSource.NETWORK_REQUEST);
                    Map<String, List<String>> headerFields = mtopResponse.getHeaderFields();
                    if (headerFields == null) {
                        return;
                    }
                    for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                        if (entry.getValue() != null) {
                            for (String str : entry.getValue()) {
                                b31Var.a(entry.getKey(), str);
                            }
                        } else {
                            b31Var.a(entry.getKey(), null);
                        }
                    }
                    if (b31Var.e("Content-Type") == null) {
                        b31Var.a("Content-Type", "application/json");
                    }
                    MtopTracker.this.a.i(b31Var);
                    MtopTracker.this.l(mtopResponse, b31Var);
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                this.b.onResponse("mtop", new IWeexAnalyzerInspector.C3092b(mtopResponse.getApi(), new String(mtopResponse.getBytedata()), mtopResponse.getResponseCode(), mtopResponse.getHeaderFields()));
            } catch (Exception e) {
                WXLogUtils.e("MtopTracker", e.getMessage());
            }
        }
    }

    public void q(final JSONObject jSONObject) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (i()) {
            this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.mtop.MtopTracker.4

                /* compiled from: Taobao */
                /* renamed from: com.alibaba.aliweex.interceptor.mtop.MtopTracker$4$a */
                /* loaded from: classes5.dex */
                class C3094a extends a31 {
                    C3094a(AnonymousClass4 anonymousClass4) {
                    }

                    @Override // tb.z21
                    public String d() {
                        String e = e("Content-Type");
                        return e == null ? "application/json" : e;
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3094a c3094a = new C3094a(this);
                    c3094a.h(MtopTracker.this.j());
                    for (String str : jSONObject.keySet()) {
                        Object obj = jSONObject.get(str);
                        if (!"param".equals(str)) {
                            c3094a.a(str, String.valueOf(obj));
                        } else {
                            Object obj2 = jSONObject.get("param");
                            if (obj2 != null && (obj2 instanceof JSONObject)) {
                                JSONObject jSONObject2 = (JSONObject) obj2;
                                for (String str2 : jSONObject2.keySet()) {
                                    c3094a.a(str2, String.valueOf(jSONObject2.get(str2)));
                                }
                            }
                        }
                    }
                    c3094a.a("Content-Type", "application/json");
                    c3094a.i(jSONObject.getString("api"));
                    c3094a.l("WindVane");
                    c3094a.m(TextUtils.isEmpty(jSONObject.getString("type")) ? "GET" : jSONObject.getString("type").toUpperCase());
                    MtopTracker.this.a.h(c3094a);
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                String upperCase = TextUtils.isEmpty(jSONObject.getString("type")) ? "GET" : jSONObject.getString("type").toUpperCase();
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                String string = jSONObject.getString("api");
                IWeexAnalyzerInspector iWeexAnalyzerInspector2 = this.b;
                if (jSONObject2 == null || jSONObject2.isEmpty()) {
                    jSONObject2 = null;
                }
                iWeexAnalyzerInspector2.onRequest("mtop", new IWeexAnalyzerInspector.C3091a(string, upperCase, jSONObject2));
            } catch (Exception e) {
                WXLogUtils.e("MtopTracker", e.getMessage());
            }
        }
    }

    public void r(@NonNull final RemoteBusiness remoteBusiness) {
        IWeexAnalyzerInspector iWeexAnalyzerInspector;
        if (i()) {
            this.a.c(new Runnable() { // from class: com.alibaba.aliweex.interceptor.mtop.MtopTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    WXLogUtils.d("MtopTracker", "preRequest -> " + remoteBusiness.request.getApiName());
                    MtopTracker mtopTracker = MtopTracker.this;
                    mtopTracker.f = new x12(mtopTracker.a, MtopTracker.this.j());
                    a31 a31Var = new a31();
                    MtopRequest mtopRequest = remoteBusiness.request;
                    a31Var.a("api-name", mtopRequest.getApiName());
                    a31Var.a("api-version", mtopRequest.getVersion());
                    a31Var.a("api-key", mtopRequest.getKey());
                    a31Var.a("need-ecode", mtopRequest.isNeedEcode() + "");
                    a31Var.a("need-session", mtopRequest.isNeedSession() + "");
                    a31Var.a("legal-request", mtopRequest.isLegalRequest() + "");
                    for (Map.Entry<String, String> entry : mtopRequest.dataParams.entrySet()) {
                        a31Var.a(entry.getKey(), entry.getValue());
                    }
                    for (Map.Entry<String, String> entry2 : remoteBusiness.mtopProp.getRequestHeaders().entrySet()) {
                        a31Var.a(entry2.getKey(), entry2.getValue());
                    }
                    if (a31Var.e("Content-Type") == null) {
                        a31Var.a("Content-Type", "application/json");
                    }
                    a31Var.h(MtopTracker.this.j());
                    a31Var.l("MTOP");
                    a31Var.i(remoteBusiness.request.getApiName() + ":" + remoteBusiness.request.getVersion());
                    byte[] bytes = remoteBusiness.request.getData().getBytes();
                    if (bytes != null) {
                        try {
                            OutputStream a = MtopTracker.this.f.a(a31Var.b());
                            a.write(bytes);
                            a.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        a31Var.k(MtopTracker.this.f.b());
                    }
                    a31Var.m(remoteBusiness.mtopProp.getMethod().getMethod());
                    MtopTracker.this.a.h(a31Var);
                    MtopTracker.this.e = (String) a31Var.f().get("url");
                    MtopTracker.this.a.b(MtopTracker.this.j(), a31Var.c(), 0);
                }
            });
        }
        if (WXEnvironment.isApkDebugable() && g && (iWeexAnalyzerInspector = this.b) != null && iWeexAnalyzerInspector.isEnabled()) {
            try {
                this.b.onRequest("mtop", new IWeexAnalyzerInspector.C3091a(remoteBusiness.request.getApiName(), remoteBusiness.mtopProp.getMethod().getMethod(), remoteBusiness.mtopProp.getRequestHeaders()));
            } catch (Exception e) {
                WXLogUtils.e("MtopTracker", e.getMessage());
            }
        }
    }
}
