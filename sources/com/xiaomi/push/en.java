package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class en {
    private static a a;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, ht> f303a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface a {
        void uploader(Context context, hn hnVar);
    }

    public static int a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof hj) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof ht) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof ey) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static Config a(Context context) {
        boolean a2 = com.xiaomi.push.service.ba.a(context).a(ho.PerfUploadSwitch.a(), false);
        boolean a3 = com.xiaomi.push.service.ba.a(context).a(ho.EventUploadNewSwitch.a(), false);
        int a4 = com.xiaomi.push.service.ba.a(context).a(ho.PerfUploadFrequency.a(), 86400);
        return Config.getBuilder().setEventUploadSwitchOpen(a3).setEventUploadFrequency(com.xiaomi.push.service.ba.a(context).a(ho.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(a2).setPerfUploadFrequency(a4).build(context);
    }

    public static EventClientReport a(Context context, String str, String str2, int i, long j, String str3) {
        EventClientReport a2 = a(str);
        a2.eventId = str2;
        a2.eventType = i;
        a2.eventTime = j;
        a2.eventContent = str3;
        return a2;
    }

    public static EventClientReport a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    public static PerfClientReport a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static PerfClientReport a(Context context, int i, long j, long j2) {
        PerfClientReport a2 = a();
        a2.code = i;
        a2.perfCounts = j;
        a2.perfLatencies = j2;
        return a2;
    }

    public static hn a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hn hnVar = new hn();
        hnVar.d("category_client_report_data");
        hnVar.a("push_sdk_channel");
        hnVar.a(1L);
        hnVar.b(str);
        hnVar.a(true);
        hnVar.b(System.currentTimeMillis());
        hnVar.g(context.getPackageName());
        hnVar.e("com.xiaomi.xmsf");
        hnVar.f(com.xiaomi.push.service.bz.a());
        hnVar.c("quality_support");
        return hnVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ht m857a(String str) {
        ht[] values;
        if (f303a == null) {
            synchronized (ht.class) {
                if (f303a == null) {
                    f303a = new HashMap();
                    for (ht htVar : ht.values()) {
                        f303a.put(htVar.f497a.toLowerCase(), htVar);
                    }
                }
            }
        }
        ht htVar2 = f303a.get(str.toLowerCase());
        return htVar2 != null ? htVar2 : ht.Invalid;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m858a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m859a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new el(context), new em(context));
    }

    private static void a(Context context, hn hnVar) {
        if (m860a(context.getApplicationContext())) {
            com.xiaomi.push.service.ca.a(context.getApplicationContext(), hnVar);
            return;
        }
        a aVar = a;
        if (aVar != null) {
            aVar.uploader(context, hnVar);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            for (String str : list) {
                hn a2 = a(context, str);
                if (!com.xiaomi.push.service.bz.a(a2, false)) {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
        }
    }

    public static void a(a aVar) {
        a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m860a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }
}
