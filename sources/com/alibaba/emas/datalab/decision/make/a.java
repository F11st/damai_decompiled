package com.alibaba.emas.datalab.decision.make;

import android.util.Log;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.emas.datalab.DatalabListener;
import com.alibaba.emas.datalab.stage.Stage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.youku.live.livesdk.monitor.performance.YoukuLivePerformanceConstants;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tb.j30;
import tb.l30;
import tb.m30;
import tb.p30;
import tb.q23;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class a {
    private Map<DatalabBizType, j30> a = null;
    public Boolean b = Boolean.FALSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.emas.datalab.decision.make.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class C0139a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DatalabBizType.values().length];
            a = iArr;
            try {
                iArr[DatalabBizType.zcache.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DatalabBizType.update.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void a(DatalabBizType datalabBizType, j30 j30Var) {
        if (this.a == null) {
            this.a = new ConcurrentHashMap();
        }
        this.a.put(datalabBizType, j30Var);
    }

    private void c(p30 p30Var) throws Exception {
        if (com.alibaba.emas.datalab.a.b().a == null) {
            Log.w("Datalab.dmService", "not listener map");
            return;
        }
        int i = C0139a.a[p30Var.b.ordinal()];
        if (i != 1) {
            if (i != 2) {
                Log.w("Datalab.dmService", "not support this type");
                return;
            }
            return;
        }
        String str = p30Var.c;
        String str2 = p30Var.d;
        if (str == null || str2 == null) {
            return;
        }
        q23 d = d(p30Var);
        if (d != null) {
            a(p30Var.b, d);
        }
        if (d == null || d.b == null) {
            return;
        }
        Log.w("Datalab.dmService", "call back listener " + p30Var.b.toString());
        b(p30Var.b, d);
    }

    private q23 d(p30 p30Var) throws Exception {
        String str = p30Var.c;
        String str2 = p30Var.d;
        String str3 = p30Var.a;
        q23 q23Var = new q23();
        q23Var.a = str3;
        if (str.equals("app.start")) {
            try {
                JSONArray parseArray = JSON.parseArray(str2);
                for (int i = 0; i < parseArray.size(); i++) {
                    q23Var.a(parseArray.getString(i));
                }
            } catch (Exception e) {
                Log.w("Datalab.dmService", str2 + " parse json array failure ", e);
            }
        } else if (!str.equals("app.pageView")) {
            Log.w("Datalab.dmService", "not support this event " + str);
        }
        return q23Var;
    }

    public void b(DatalabBizType datalabBizType, j30 j30Var) {
        DatalabListener datalabListener = com.alibaba.emas.datalab.a.b().a.get(datalabBizType);
        if (datalabListener != null) {
            m30 m30Var = new m30();
            m30Var.b = datalabBizType;
            Stage stage = Stage.DOWNLOAD;
            m30Var.a = "datalab";
            if (datalabBizType.equals(DatalabBizType.zcache)) {
                Set<String> set = ((q23) j30Var).b;
                m30Var.c = set;
                if (set != null && set.size() > 0) {
                    datalabListener.execute(stage, m30Var);
                    l30.c().a(j30Var.a, datalabBizType, m30Var.c);
                    return;
                }
                Log.w("Datalab.dmService", "download list is null");
                return;
            } else if (datalabBizType.equals(DatalabBizType.update)) {
                return;
            } else {
                Log.w("Datalab.dmService", "not support this type");
                return;
            }
        }
        Log.w("Datalab.dmService", "listener is null " + datalabBizType.toString());
    }

    public void e(p30 p30Var) throws Exception {
        String str = p30Var.a;
        if (str == null || p30Var.b == null) {
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1480388560:
                if (str.equals(YoukuLivePerformanceConstants.MONITOR_POINT)) {
                    c = 0;
                    break;
                }
                break;
            case -1008851410:
                if (str.equals("orange")) {
                    c = 1;
                    break;
                }
                break;
            case -899647263:
                if (str.equals("slider")) {
                    c = 2;
                    break;
                }
                break;
            case 99212:
                if (str.equals("dai")) {
                    c = 3;
                    break;
                }
                break;
            case 2988050:
                if (str.equals("accs")) {
                    c = 4;
                    break;
                }
                break;
            case 94921639:
                if (str.equals("crash")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
            case 5:
                return;
            case 1:
                c(p30Var);
                return;
            case 3:
                c(p30Var);
                return;
            default:
                Log.w("Datalab.dmService", "not support this source");
                return;
        }
    }
}
