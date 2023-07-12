package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.orange.OConstant;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.C7074f;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C7117f;
import com.tencent.open.utils.C7119g;
import com.tencent.open.utils.C7123k;
import com.tencent.open.utils.C7124l;
import com.tencent.open.utils.C7126m;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.b.b */
/* loaded from: classes11.dex */
public class C7081b {
    private static C7081b a;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private List<Serializable> i = Collections.synchronizedList(new ArrayList());
    private List<Serializable> j = Collections.synchronizedList(new ArrayList());
    private Executor k = C7124l.b();
    private boolean l;

    private C7081b() {
    }

    private void c() {
        while (!this.j.isEmpty()) {
            C7082c c7082c = (C7082c) this.j.remove(0);
            c7082c.a.put("appid", this.b);
            c7082c.a.put("app_name", this.c);
            c7082c.a.put("app_ver", this.e);
            c7082c.a.put(Constants.PARAM_PKG_NAME, this.f);
            c7082c.a.put("qq_install", this.g);
            c7082c.a.put(Constants.PARAM_QQ_VER, this.h);
            c7082c.a.put("openid", this.d);
            HashMap<String, String> hashMap = c7082c.a;
            hashMap.put("time_appid_openid", c7082c.a.get("time") + JSMethod.NOT_SET + this.b + JSMethod.NOT_SET + this.d);
            StringBuilder sb = new StringBuilder();
            sb.append("fixDirtyData--------------------------");
            sb.append(c7082c);
            SLog.i("AttaReporter", sb.toString());
            this.i.add(c7082c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (!this.l) {
            List<Serializable> b = C7086g.b("report_atta");
            this.l = b.isEmpty();
            this.i.addAll(b);
            Iterator<Serializable> it = b.iterator();
            while (it.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread from db = " + it.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.i.isEmpty()) {
            C7082c c7082c = (C7082c) this.i.remove(0);
            if (!b(c7082c)) {
                arrayList.add(c7082c);
            }
        }
        if (!arrayList.isEmpty()) {
            SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((C7082c) ((Serializable) it2.next())));
            }
            C7086g.a("report_atta", arrayList);
            this.l = false;
        } else if (this.l) {
        } else {
            SLog.i("AttaReporter", "attaReportAtSubThread clear db");
            C7086g.a("report_atta");
            this.l = true;
        }
    }

    public static synchronized C7081b a() {
        C7081b c7081b;
        synchronized (C7081b.class) {
            if (a == null) {
                a = new C7081b();
            }
            c7081b = a;
        }
        return c7081b;
    }

    private C7082c b(String str, String str2, Object obj, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "09400051119");
        hashMap.put("token", "9389887874");
        hashMap.put("time_appid_openid", currentTimeMillis + JSMethod.NOT_SET + this.b + JSMethod.NOT_SET + this.d);
        hashMap.put("time", String.valueOf(currentTimeMillis));
        hashMap.put("openid", this.d);
        hashMap.put("appid", this.b);
        hashMap.put("app_name", this.c);
        hashMap.put("app_ver", this.e);
        hashMap.put(Constants.PARAM_PKG_NAME, this.f);
        hashMap.put("os", "AND");
        hashMap.put(OConstant.CANDIDATE_OSVER, Build.VERSION.getRELEASE());
        hashMap.put("sdk_ver", Constants.SDK_VERSION);
        hashMap.put(Constants.PARAM_MODEL_NAME, C7117f.a().c(C7119g.a()));
        hashMap.put("interface_name", str);
        hashMap.put("interface_data", str2);
        hashMap.put("interface_result", obj == null ? "" : obj.toString());
        hashMap.put("qq_install", this.g);
        hashMap.put(Constants.PARAM_QQ_VER, this.h);
        if (map != null && !map.isEmpty()) {
            Object obj2 = map.get("reserve1");
            hashMap.put("reserve1", obj2 == null ? "" : obj2.toString());
            Object obj3 = map.get("reserve2");
            hashMap.put("reserve2", obj3 == null ? "" : obj3.toString());
            Object obj4 = map.get("reserve3");
            hashMap.put("reserve3", obj4 == null ? "" : obj4.toString());
            Object obj5 = map.get("reserve4");
            hashMap.put("reserve4", obj5 != null ? obj5.toString() : "");
        }
        return new C7082c(hashMap);
    }

    public void a(String str, Context context) {
        SLog.i("AttaReporter", UCCore.LEGACY_EVENT_INIT);
        this.b = str;
        this.c = C7123k.a(context);
        this.e = C7126m.d(context, C7119g.b());
        this.f = C7119g.b();
        this.g = C7123k.b(context) ? "1" : "0";
        this.h = C7126m.c(context, "com.tencent.mobileqq");
        c();
        C7086g.a();
    }

    public void a(String str) {
        SLog.i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.d = str;
    }

    public void a(String str, String str2) {
        a(str, str2, null);
    }

    public void a(String str, String str2, Map<String, Object> map) {
        a(str, str2, "", map);
    }

    public void a(String str, Object obj) {
        a(str, "", obj, null);
    }

    public void a(String str, String str2, Object obj, Map<String, Object> map) {
        C7082c b = b(str, str2, obj, map);
        if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && C7119g.a() != null) {
            a(b);
            return;
        }
        SLog.i("AttaReporter", "attaReport cancel appid=" + this.b + ", mAppName=" + this.c + ", context=" + C7119g.a() + AVFSCacheConstants.COMMA_SEP + b);
        this.j.add(b);
    }

    private void a(final C7082c c7082c) {
        this.k.execute(new Runnable() { // from class: com.tencent.open.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                C7081b.this.i.add(c7082c);
                if (C7126m.b(C7119g.a())) {
                    try {
                        C7081b.this.d();
                        return;
                    } catch (Exception e) {
                        SLog.e("AttaReporter", "Exception", e);
                        return;
                    }
                }
                SLog.i("AttaReporter", "attaReport net disconnect, " + c7082c);
            }
        });
    }

    private boolean b(C7082c c7082c) {
        int i = 0;
        do {
            i++;
            try {
                SLog.i("AttaReporter", "doAttaReportItem post " + c7082c);
                return C7074f.a().b("https://h.trace.qq.com/kv", c7082c.a).d() == 200;
            } catch (Exception e) {
                SLog.i("AttaReporter", "Exception", e);
                if (i >= 2) {
                    return false;
                }
            }
        } while (i >= 2);
        return false;
    }

    public static String b() {
        return a().b;
    }
}
