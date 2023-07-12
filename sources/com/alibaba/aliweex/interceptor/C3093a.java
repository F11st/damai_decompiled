package com.alibaba.aliweex.interceptor;

import android.content.Context;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Collections;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.aliweex.interceptor.a */
/* loaded from: classes5.dex */
public class C3093a implements IWeexAnalyzerInspector {
    private static C3093a b;
    @Nullable
    private Object a;

    private C3093a() {
        try {
            this.a = Class.forName("com.taobao.weex.analyzer.core.NetworkEventSender").getDeclaredConstructor(Context.class).newInstance(WXEnvironment.getApplication());
        } catch (Exception e) {
            WXLogUtils.d("NetworkInspectorImpl", e.getMessage());
        }
    }

    public static C3093a a() {
        if (b == null) {
            synchronized (C3093a.class) {
                if (b == null) {
                    b = new C3093a();
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
    public void onRequest(String str, IWeexAnalyzerInspector.C3091a c3091a) {
        String str2 = c3091a.a;
        String str3 = c3091a.b;
        Map<String, String> map = c3091a.c;
        b("request", str2, str3, map == null ? null : map.toString(), Collections.singletonMap("bizType", str));
    }

    @Override // com.alibaba.aliweex.interceptor.IWeexAnalyzerInspector
    public void onResponse(String str, IWeexAnalyzerInspector.C3092b c3092b) {
        String str2;
        String str3 = c3092b.d;
        StringBuilder sb = new StringBuilder();
        sb.append(c3092b.b);
        if (c3092b.c != null) {
            str2 = "|" + c3092b.c.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        b("response", str3, sb.toString(), c3092b.a, Collections.singletonMap("bizType", str));
    }
}
