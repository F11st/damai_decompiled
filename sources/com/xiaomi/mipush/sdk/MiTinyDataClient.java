package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.push.hj;
import com.xiaomi.push.hn;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.bz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        private static volatile a a;

        /* renamed from: a  reason: collision with other field name */
        private Context f27a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f29a;

        /* renamed from: a  reason: collision with other field name */
        private String f30a;

        /* renamed from: a  reason: collision with other field name */
        private C0358a f28a = new C0358a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hn> f31a = new ArrayList<>();

        /* compiled from: Taobao */
        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0358a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f34a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f35a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hn> f33a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f32a = new ab(this);

            public C0358a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f34a == null) {
                    this.f34a = this.f35a.scheduleAtFixedRate(this.f32a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hn remove = this.f33a.remove(0);
                for (ii iiVar : bz.a(Arrays.asList(remove), a.this.f27a.getPackageName(), b.m629a(a.this.f27a).m630a(), 30720)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ao.a(a.this.f27a).a((ao) iiVar, hj.Notification, true, (hw) null);
                }
            }

            public void a(hn hnVar) {
                this.f35a.execute(new aa(this, hnVar));
            }
        }

        public static a a() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }

        private void a(hn hnVar) {
            synchronized (this.f31a) {
                if (!this.f31a.contains(hnVar)) {
                    this.f31a.add(hnVar);
                    if (this.f31a.size() > 100) {
                        this.f31a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (ao.a(context).m622a()) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                    if (packageInfo == null) {
                        return false;
                    }
                    return packageInfo.versionCode >= 108;
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }

        private boolean b(Context context) {
            return b.m629a(context).m630a() == null && !a(this.f27a);
        }

        private boolean b(hn hnVar) {
            if (bz.a(hnVar, false)) {
                return false;
            }
            if (!this.f29a.booleanValue()) {
                this.f28a.a(hnVar);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hnVar.d());
            ao.a(this.f27a).a(hnVar);
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m601a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m586a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f27a = context;
            this.f29a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m586a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.f30a = str;
            b(MiTinyDataClient.PENDING_REASON_CHANNEL);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m602a() {
            return this.f27a != null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a3, code lost:
            r0 = "MiTinyDataClient Pending " + r6.b() + " reason is " + com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_CHANNEL;
         */
        /* renamed from: a  reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized boolean m603a(com.xiaomi.push.hn r6) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiTinyDataClient.a.m603a(com.xiaomi.push.hn):boolean");
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + jn1.BRACKET_END_STR);
            ArrayList arrayList = new ArrayList();
            synchronized (this.f31a) {
                arrayList.addAll(this.f31a);
                this.f31a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m603a((hn) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m601a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m586a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hn hnVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hnVar.d());
        if (!a.a().m602a()) {
            a.a().m601a(context);
        }
        return a.a().m603a(hnVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        hn hnVar = new hn();
        hnVar.d(str);
        hnVar.c(str2);
        hnVar.a(j);
        hnVar.b(str3);
        hnVar.a(true);
        hnVar.a("push_sdk_channel");
        return upload(context, hnVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        hn hnVar = new hn();
        hnVar.d(str);
        hnVar.c(str2);
        hnVar.a(j);
        hnVar.b(str3);
        return a.a().m603a(hnVar);
    }
}
