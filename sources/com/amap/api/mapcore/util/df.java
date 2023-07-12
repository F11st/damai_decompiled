package com.amap.api.mapcore.util;

import android.content.Context;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class df extends fu<String, C4513a> {
    private String h;
    private boolean i;
    private String j;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.df$a */
    /* loaded from: classes10.dex */
    public static class C4513a {
        public byte[] a;
        public int b = -1;
    }

    public df(Context context, String str) {
        super(context, str);
        this.i = false;
        this.j = null;
        this.g = "/map/styles";
    }

    @Override // com.amap.api.mapcore.util.fu
    protected String a() {
        return null;
    }

    public void a(String str) {
        this.j = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.fu
    /* renamed from: c */
    public C4513a b(String str) throws ft {
        return null;
    }

    public void d(String str) {
        this.h = str;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getIPV6URL() {
        return eq.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.AbstractC4517dp, com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", C4554gc.f(this.f));
        if (!this.i) {
            hashtable.put("output", "bin");
        } else {
            hashtable.put(ALBiometricsKeys.KEY_SDK_TYPE, this.j);
        }
        hashtable.put("styleid", this.h);
        String a = gf.a();
        String a2 = gf.a(this.f, a, gn.c(hashtable));
        hashtable.put("ts", a);
        hashtable.put("scode", a2);
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.fu, com.amap.api.mapcore.util.ii
    public Map<String, String> getRequestHead() {
        gm e = eq.e();
        String b = e != null ? e.b() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(IRequestConst.USER_AGENT, C4614m.c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", b, "3dmap"));
        hashtable.put("x-INFO", gf.a(this.f));
        hashtable.put("key", C4554gc.f(this.f));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        return "http://restapi.amap.com/v4" + this.g;
    }

    @Override // com.amap.api.mapcore.util.ii
    public boolean isSupportIPV6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.fu
    /* renamed from: a */
    public C4513a b(byte[] bArr) throws ft {
        C4513a c4513a = new C4513a();
        c4513a.a = bArr;
        if (this.i && bArr != null) {
            if (bArr.length == 0) {
                c4513a.a = null;
            } else if (bArr.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains("errcode")) {
                        c4513a.a = null;
                    }
                } catch (Exception e) {
                    hd.c(e, "CustomStyleRequest", "loadData");
                }
            }
        }
        return c4513a;
    }

    public df(Context context, String str, boolean z) {
        super(context, str);
        this.i = false;
        this.j = null;
        this.i = z;
        if (z) {
            this.g = "/sdk/map/styles";
            this.isPostFlag = false;
            return;
        }
        this.g = "/map/styles";
    }
}
