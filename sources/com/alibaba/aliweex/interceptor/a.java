package com.alibaba.aliweex.interceptor;

import android.content.Context;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Collections;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class a implements IWeexAnalyzerInspector {
    private static a b;
    @Nullable
    private Object a;

    private a() {
        try {
            this.a = Class.forName("com.taobao.weex.analyzer.core.NetworkEventSender").getDeclaredConstructor(Context.class).newInstance(WXEnvironment.getApplication());
        } catch (Exception e) {
            WXLogUtils.d("NetworkInspectorImpl", e.getMessage());
        }
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private void b(String str, String str2, String str3, String str4, Map<String, String> map) {
        Object obj = this.a;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("sendMessage", String.class, String.class, String.class, String.class, Map.class).invoke(this.a, str, str2, str3, str4, map);
        } catch (Exception e) {
            WXLogUtils.e("NetworkInspectorImpl", e.getMessage());
        }
    }

    @Override // com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector
    public boolean isEnabled() {
        return WXEnvironment.isApkDebugable() && this.a != null;
    }

    @Override // com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector
    public void onRequest(String str, IWeexAnalyzerInspector.a aVar) {
        String str2 = aVar.a;
        String str3 = aVar.b;
        Map<String, String> map = aVar.c;
        b("request", str2, str3, map == null ? null : map.toString(), Collections.singletonMap("bizType", str));
    }

    @Override // com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector
    public void onResponse(String str, IWeexAnalyzerInspector.b bVar) {
        String str2;
        String str3 = bVar.d;
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.b);
        if (bVar.c != null) {
            str2 = "|" + bVar.c.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        b("response", str3, sb.toString(), bVar.a, Collections.singletonMap("bizType", str));
    }
}
