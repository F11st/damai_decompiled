package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.clientreport.data.C7537a;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.al;
import com.xiaomi.push.bp;
import com.xiaomi.push.bq;
import com.xiaomi.push.br;
import com.xiaomi.push.bs;
import com.xiaomi.push.bt;
import com.xiaomi.push.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.clientreport.manager.a */
/* loaded from: classes11.dex */
public class C7539a {
    private static final int a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile C7539a f9a;

    /* renamed from: a  reason: collision with other field name */
    private Context f10a;

    /* renamed from: a  reason: collision with other field name */
    private Config f11a;

    /* renamed from: a  reason: collision with other field name */
    private IEventProcessor f12a;

    /* renamed from: a  reason: collision with other field name */
    private IPerfProcessor f13a;

    /* renamed from: a  reason: collision with other field name */
    private String f14a;

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f16a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, C7537a>> f15a = new HashMap<>();
    private HashMap<String, ArrayList<C7537a>> b = new HashMap<>();

    static {
        a = C7688m.m1118a() ? 30 : 10;
    }

    private C7539a(Context context) {
        this.f10a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        HashMap<String, ArrayList<C7537a>> hashMap = this.b;
        if (hashMap != null) {
            int i = 0;
            for (String str : hashMap.keySet()) {
                ArrayList<C7537a> arrayList = this.b.get(str);
                i += arrayList != null ? arrayList.size() : 0;
            }
            return i;
        }
        return 0;
    }

    public static C7539a a(Context context) {
        if (f9a == null) {
            synchronized (C7539a.class) {
                if (f9a == null) {
                    f9a = new C7539a(context);
                }
            }
        }
        return f9a;
    }

    private void a(al.AbstractRunnableC7597a abstractRunnableC7597a, int i) {
        al.a(this.f10a).b(abstractRunnableC7597a, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, C7537a>> hashMap = this.f15a;
        int i = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap<String, C7537a> hashMap2 = this.f15a.get(str);
                if (hashMap2 != null) {
                    for (String str2 : hashMap2.keySet()) {
                        C7537a c7537a = hashMap2.get(str2);
                        if (c7537a instanceof PerfClientReport) {
                            i = (int) (i + ((PerfClientReport) c7537a).perfCounts);
                        }
                    }
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f12a;
        if (iEventProcessor != null) {
            iEventProcessor.mo594a(eventClientReport);
            if (a() < 10) {
                a(new C7542d(this), a);
                return;
            }
            d();
            al.a(this.f10a).m665a("100888");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f13a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo594a(perfClientReport);
            if (b() < 10) {
                a(new C7544f(this), a);
                return;
            }
            e();
            al.a(this.f10a).m665a("100889");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f12a.b();
        } catch (Exception e) {
            AbstractC7535b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f13a.b();
        } catch (Exception e) {
            AbstractC7535b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f10a).m591a().isEventUploadSwitchOpen()) {
            bq bqVar = new bq(this.f10a);
            int eventUploadFrequency = (int) a(this.f10a).m591a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bw.a(this.f10a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                al.a(this.f10a).a(new RunnableC7546h(this, bqVar), 10);
            }
            synchronized (C7539a.class) {
                if (!al.a(this.f10a).a((al.AbstractRunnableC7597a) bqVar, eventUploadFrequency)) {
                    al.a(this.f10a).m665a("100886");
                    al.a(this.f10a).a((al.AbstractRunnableC7597a) bqVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        if (a(this.f10a).m591a().isPerfUploadSwitchOpen()) {
            br brVar = new br(this.f10a);
            int perfUploadFrequency = (int) a(this.f10a).m591a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bw.a(this.f10a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                al.a(this.f10a).a(new RunnableC7547i(this, brVar), 15);
            }
            synchronized (C7539a.class) {
                if (!al.a(this.f10a).a((al.AbstractRunnableC7597a) brVar, perfUploadFrequency)) {
                    al.a(this.f10a).m665a("100887");
                    al.a(this.f10a).a((al.AbstractRunnableC7597a) brVar, perfUploadFrequency);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Config m591a() {
        if (this.f11a == null) {
            this.f11a = Config.defaultConfig(this.f10a);
        }
        return this.f11a;
    }

    public EventClientReport a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = bp.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f10a.getPackageName());
        eventClientReport.setSdkVersion(this.f14a);
        return eventClientReport;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m592a() {
        a(this.f10a).f();
        a(this.f10a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f11a = config;
        this.f12a = iEventProcessor;
        this.f13a = iPerfProcessor;
        iEventProcessor.setEventMap(this.b);
        this.f13a.setPerfMap(this.f15a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m591a().isEventUploadSwitchOpen()) {
            this.f16a.execute(new RunnableC7540b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m591a().isPerfUploadSwitchOpen()) {
            this.f16a.execute(new RunnableC7541c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f14a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f11a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f11a.isPerfUploadSwitchOpen() && j == this.f11a.getEventUploadFrequency() && j2 == this.f11a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f11a.getEventUploadFrequency();
            long perfUploadFrequency = this.f11a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bt.a(this.f10a)).setEventEncrypted(this.f11a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f10a);
            this.f11a = build;
            if (!build.isEventUploadSwitchOpen()) {
                al.a(this.f10a).m665a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                AbstractC7535b.c(this.f10a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f11a.isPerfUploadSwitchOpen()) {
                al.a(this.f10a).m665a("100887");
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                AbstractC7535b.c(this.f10a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m593b() {
        if (m591a().isEventUploadSwitchOpen()) {
            bs bsVar = new bs();
            bsVar.a(this.f10a);
            bsVar.a(this.f12a);
            this.f16a.execute(bsVar);
        }
    }

    public void c() {
        if (m591a().isPerfUploadSwitchOpen()) {
            bs bsVar = new bs();
            bsVar.a(this.f13a);
            bsVar.a(this.f10a);
            this.f16a.execute(bsVar);
        }
    }
}
