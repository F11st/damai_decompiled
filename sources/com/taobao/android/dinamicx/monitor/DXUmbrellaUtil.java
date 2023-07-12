package com.taobao.android.dinamicx.monitor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.thread.DXMonitorRunnable;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.b20;
import tb.ft;
import tb.nz;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXUmbrellaUtil {
    private static ft a;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.monitor.DXUmbrellaUtil$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    static class AnonymousClass1 extends DXMonitorRunnable {
        final /* synthetic */ String val$bizType;
        final /* synthetic */ DXTemplateItem val$dxTemplateItem;
        final /* synthetic */ Map val$extraParam;
        final /* synthetic */ String val$featureType;
        final /* synthetic */ String val$serviceId;

        AnonymousClass1(String str, String str2, String str3, DXTemplateItem dXTemplateItem, Map map) {
            this.val$featureType = str;
            this.val$serviceId = str2;
            this.val$bizType = str3;
            this.val$dxTemplateItem = dXTemplateItem;
            this.val$extraParam = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String g = DXUmbrellaUtil.g(this.val$featureType);
                DXUmbrellaUtil.b();
                DXUmbrellaUtil.l(this.val$bizType, g, this.val$serviceId, this.val$dxTemplateItem, this.val$extraParam);
                ft unused = DXUmbrellaUtil.a;
                throw null;
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.monitor.DXUmbrellaUtil$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    static class AnonymousClass2 extends DXMonitorRunnable {
        final /* synthetic */ C6368e val$error;
        final /* synthetic */ boolean val$isSimplePipeline;

        AnonymousClass2(C6368e c6368e, boolean z) {
            this.val$error = c6368e;
            this.val$isSimplePipeline = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<C6368e.C6369a> list;
            try {
                C6368e c6368e = this.val$error;
                if (c6368e != null && (list = c6368e.c) != null && !list.isEmpty()) {
                    int size = this.val$error.c.size();
                    int i = size - 1;
                    for (int i2 = 0; i2 < size; i2++) {
                        C6368e.C6369a c6369a = this.val$error.c.get(i2);
                        if (c6369a != null) {
                            if (this.val$isSimplePipeline) {
                                c6369a.c = "SimplePipeline" + c6369a.c;
                            }
                            if (i2 == i) {
                                C6368e c6368e2 = this.val$error;
                                DXUmbrellaUtil.n(c6368e2.a, c6368e2.b, c6369a);
                                C6368e c6368e3 = this.val$error;
                                DXUmbrellaUtil.j(c6368e3.a, c6368e3.b, c6369a);
                                return;
                            }
                            C6368e c6368e4 = this.val$error;
                            DXUmbrellaUtil.n(c6368e4.a, c6368e4.b, c6369a);
                        }
                    }
                }
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    static /* synthetic */ String b() {
        return m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(String str) {
        return str + "_umbrella2";
    }

    private static Map<String, Object> h(DXTemplateItem dXTemplateItem, C6368e.C6369a c6369a) {
        HashMap hashMap = new HashMap();
        if (dXTemplateItem != null) {
            hashMap.put(b20.a, dXTemplateItem.name);
            hashMap.put(b20.b, Long.valueOf(dXTemplateItem.version));
            hashMap.put(b20.c, dXTemplateItem.templateUrl);
        }
        if (c6369a != null) {
            hashMap.put(b20.d, c6369a.b);
        }
        return hashMap;
    }

    public static void i(C6368e c6368e, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(String str, DXTemplateItem dXTemplateItem, C6368e.C6369a c6369a) {
        if (c6369a == null) {
            return;
        }
        String g = g(c6369a.c);
        m();
        Map<String, String> l = l(str, g, c6369a.b, dXTemplateItem, c6369a.f);
        String str2 = "" + c6369a.d;
        String str3 = c6369a.e;
        if (l != null) {
            l.put("errorMsg", str3);
            l.put("errorCode", str2);
        }
        throw null;
    }

    public static void k(int i, @NonNull String str, String str2, @NonNull String str3, DXTemplateItem dXTemplateItem, Map<String, String> map, double d) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> l(String str, String str2, @NonNull String str3, DXTemplateItem dXTemplateItem, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("bizName", nz.TAG);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("sceneName", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("serviceId", str3);
        } else {
            hashMap.put("serviceId", "DX_Default_Service_Id");
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("featureType", str2);
        }
        hashMap.put("version", m());
        hashMap.put("samplingRate", "1.0");
        if (dXTemplateItem != null) {
            if (!TextUtils.isEmpty(dXTemplateItem.name)) {
                hashMap.put("templateName", dXTemplateItem.name);
            }
            hashMap.put("templateVersion", dXTemplateItem.version + "");
            if (!TextUtils.isEmpty(dXTemplateItem.templateUrl)) {
                hashMap.put("templateUrl", dXTemplateItem.templateUrl);
            }
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return hashMap;
    }

    private static String m() {
        return LiveFullInfo.VER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(String str, DXTemplateItem dXTemplateItem, C6368e.C6369a c6369a) {
        if (c6369a == null) {
            return;
        }
        String g = g(c6369a.c);
        String str2 = "" + c6369a.d;
        String str3 = c6369a.e;
        h(dXTemplateItem, c6369a);
        HashMap hashMap = new HashMap();
        Map<String, String> l = l(str, g, c6369a.b, dXTemplateItem, c6369a.f);
        if (l != null) {
            l.put("errorMsg", str3);
            l.put("errorCode", str2);
        }
        hashMap.put("args", l);
        throw null;
    }
}
