package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7672hn;
import com.xiaomi.push.hj;
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
    /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a */
    /* loaded from: classes11.dex */
    public static class C7555a {
        private static volatile C7555a a;

        /* renamed from: a  reason: collision with other field name */
        private Context f27a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f29a;

        /* renamed from: a  reason: collision with other field name */
        private String f30a;

        /* renamed from: a  reason: collision with other field name */
        private C7556a f28a = new C7556a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<C7672hn> f31a = new ArrayList<>();

        /* compiled from: Taobao */
        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a */
        /* loaded from: classes11.dex */
        public class C7556a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f34a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f35a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<C7672hn> f33a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f32a = new RunnableC7559ab(this);

            public C7556a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f34a == null) {
                    this.f34a = this.f35a.scheduleAtFixedRate(this.f32a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                C7672hn remove = this.f33a.remove(0);
                for (ii iiVar : bz.a(Arrays.asList(remove), C7555a.this.f27a.getPackageName(), C7564b.m629a(C7555a.this.f27a).m630a(), 30720)) {
                    AbstractC7535b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ao.a(C7555a.this.f27a).a((ao) iiVar, hj.Notification, true, (hw) null);
                }
            }

            public void a(C7672hn c7672hn) {
                this.f35a.execute(new aa(this, c7672hn));
            }
        }

        public static C7555a a() {
            if (a == null) {
                synchronized (C7555a.class) {
                    if (a == null) {
                        a = new C7555a();
                    }
                }
            }
            return a;
        }

        private void a(C7672hn c7672hn) {
            synchronized (this.f31a) {
                if (!this.f31a.contains(c7672hn)) {
                    this.f31a.add(c7672hn);
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
            return C7564b.m629a(context).m630a() == null && !a(this.f27a);
        }

        private boolean b(C7672hn c7672hn) {
            if (bz.a(c7672hn, false)) {
                return false;
            }
            if (!this.f29a.booleanValue()) {
                this.f28a.a(c7672hn);
                return true;
            }
            AbstractC7535b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + c7672hn.d());
            ao.a(this.f27a).a(c7672hn);
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m601a(Context context) {
            if (context == null) {
                AbstractC7535b.m586a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f27a = context;
            this.f29a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                AbstractC7535b.m586a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
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
        public synchronized boolean m603a(com.xiaomi.push.C7672hn r6) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiTinyDataClient.C7555a.m603a(com.xiaomi.push.hn):boolean");
        }

        public void b(String str) {
            AbstractC7535b.c("MiTinyDataClient.processPendingList(" + str + jn1.BRACKET_END_STR);
            ArrayList arrayList = new ArrayList();
            synchronized (this.f31a) {
                arrayList.addAll(this.f31a);
                this.f31a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m603a((C7672hn) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            AbstractC7535b.m586a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        C7555a.a().m601a(context);
        if (TextUtils.isEmpty(str)) {
            AbstractC7535b.m586a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            C7555a.a().a(str);
        }
    }

    public static boolean upload(Context context, C7672hn c7672hn) {
        AbstractC7535b.c("MiTinyDataClient.upload " + c7672hn.d());
        if (!C7555a.a().m602a()) {
            C7555a.a().m601a(context);
        }
        return C7555a.a().m603a(c7672hn);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        C7672hn c7672hn = new C7672hn();
        c7672hn.d(str);
        c7672hn.c(str2);
        c7672hn.a(j);
        c7672hn.b(str3);
        c7672hn.a(true);
        c7672hn.a("push_sdk_channel");
        return upload(context, c7672hn);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        C7672hn c7672hn = new C7672hn();
        c7672hn.d(str);
        c7672hn.c(str2);
        c7672hn.a(j);
        c7672hn.b(str3);
        return C7555a.a().m603a(c7672hn);
    }
}
