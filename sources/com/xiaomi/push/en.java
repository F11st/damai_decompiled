package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
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
    private static InterfaceC7647a a;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, ht> f303a;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.en$a */
    /* loaded from: classes11.dex */
    public interface InterfaceC7647a {
        void uploader(Context context, C7672hn c7672hn);
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

    public static C7672hn a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C7672hn c7672hn = new C7672hn();
        c7672hn.d("category_client_report_data");
        c7672hn.a("push_sdk_channel");
        c7672hn.a(1L);
        c7672hn.b(str);
        c7672hn.a(true);
        c7672hn.b(System.currentTimeMillis());
        c7672hn.g(context.getPackageName());
        c7672hn.e("com.xiaomi.xmsf");
        c7672hn.f(com.xiaomi.push.service.bz.a());
        c7672hn.c("quality_support");
        return c7672hn;
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

    private static void a(Context context, C7672hn c7672hn) {
        if (m860a(context.getApplicationContext())) {
            com.xiaomi.push.service.ca.a(context.getApplicationContext(), c7672hn);
            return;
        }
        InterfaceC7647a interfaceC7647a = a;
        if (interfaceC7647a != null) {
            interfaceC7647a.uploader(context, c7672hn);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            for (String str : list) {
                C7672hn a2 = a(context, str);
                if (!com.xiaomi.push.service.bz.a(a2, false)) {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            AbstractC7535b.d(th.getMessage());
        }
    }

    public static void a(InterfaceC7647a interfaceC7647a) {
        a = interfaceC7647a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m860a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }
}
