package com.amap.api.mapcore.util;

import android.content.Context;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class df extends fu<String, a> {
    private String h;
    private boolean i;
    private String j;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
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
    public a b(String str) throws ft {
        return null;
    }

    public void d(String str) {
        this.h = str;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getIPV6URL() {
        return eq.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.dp, com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", gc.f(this.f));
        if (!this.i) {
            hashtable.put("output", "bin");
        } else {
            hashtable.put(ALBiometricsKeys.KEY_SDK_TYPE, this.j);
        }
        hashtable.put("styleid", this.h);
        String a2 = gf.a();
        String a3 = gf.a(this.f, a2, gn.c(hashtable));
        hashtable.put("ts", a2);
        hashtable.put("scode", a3);
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.fu, com.amap.api.mapcore.util.ii
    public Map<String, String> getRequestHead() {
        gm e = eq.e();
        String b = e != null ? e.b() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(IRequestConst.USER_AGENT, m.c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", b, "3dmap"));
        hashtable.put("x-INFO", gf.a(this.f));
        hashtable.put("key", gc.f(this.f));
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
    public a b(byte[] bArr) throws ft {
        a aVar = new a();
        aVar.a = bArr;
        if (this.i && bArr != null) {
            if (bArr.length == 0) {
                aVar.a = null;
            } else if (bArr.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains("errcode")) {
                        aVar.a = null;
                    }
                } catch (Exception e) {
                    hd.c(e, "CustomStyleRequest", "loadData");
                }
            }
        }
        return aVar;
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
