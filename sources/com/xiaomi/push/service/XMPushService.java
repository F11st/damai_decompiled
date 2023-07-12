package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.al;
import com.xiaomi.push.cv;
import com.xiaomi.push.dd;
import com.xiaomi.push.df;
import com.xiaomi.push.ed;
import com.xiaomi.push.eo;
import com.xiaomi.push.eu;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fl;
import com.xiaomi.push.fs;
import com.xiaomi.push.fw;
import com.xiaomi.push.fx;
import com.xiaomi.push.fz;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.gh;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.hb;
import com.xiaomi.push.hd;
import com.xiaomi.push.hg;
import com.xiaomi.push.hj;
import com.xiaomi.push.ho;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.it;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.p;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.jn1;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class XMPushService extends Service implements fz {
    private static boolean b;

    /* renamed from: a  reason: collision with other field name */
    private ContentObserver f833a;

    /* renamed from: a  reason: collision with other field name */
    private fs f835a;

    /* renamed from: a  reason: collision with other field name */
    private fw f836a;

    /* renamed from: a  reason: collision with other field name */
    private fx f837a;

    /* renamed from: a  reason: collision with other field name */
    private a f839a;

    /* renamed from: a  reason: collision with other field name */
    private f f840a;

    /* renamed from: a  reason: collision with other field name */
    private k f841a;

    /* renamed from: a  reason: collision with other field name */
    private r f842a;

    /* renamed from: a  reason: collision with other field name */
    private t f843a;

    /* renamed from: a  reason: collision with other field name */
    private bq f845a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.j f846a;

    /* renamed from: a  reason: collision with other field name */
    private String f849a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f852a = false;
    private int a = 0;

    /* renamed from: b  reason: collision with other field name */
    private int f853b = 0;

    /* renamed from: a  reason: collision with other field name */
    private long f832a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected Class f848a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    private be f844a = null;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.p f847a = null;

    /* renamed from: a  reason: collision with other field name */
    Messenger f834a = null;

    /* renamed from: a  reason: collision with other field name */
    private Collection<ar> f851a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<n> f850a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private gb f838a = new ci(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with other field name */
        private final Object f854a;

        private a() {
            this.f854a = new Object();
        }

        /* synthetic */ a(XMPushService xMPushService, ci ciVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f854a) {
                try {
                    this.f854a.notifyAll();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m586a("[Alarm] notify lock. " + e);
                }
            }
        }

        private void a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f854a) {
                try {
                    this.f854a.wait(j);
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.m586a("[Alarm] interrupt from waiting state. " + e);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!bk.p.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.m586a("[Alarm] cancel the old ping timer");
                eu.a();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(3000L);
                    com.xiaomi.channel.commonutils.logger.b.m586a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b extends j {

        /* renamed from: a  reason: collision with other field name */
        bg.b f855a;

        public b(bg.b bVar) {
            super(9);
            this.f855a = null;
            this.f855a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "bind the client. " + this.f855a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            String str;
            try {
                if (!XMPushService.this.m1155c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                bg a = bg.a();
                bg.b bVar = this.f855a;
                bg.b a2 = a.a(bVar.g, bVar.f928b);
                if (a2 == null) {
                    str = "ignore bind because the channel " + this.f855a.g + " is removed ";
                } else if (a2.f923a == bg.c.unbind) {
                    a2.a(bg.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.f836a.a(a2);
                    fj.a(XMPushService.this, a2);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + a2.f923a;
                }
                com.xiaomi.channel.commonutils.logger.b.m586a(str);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e);
                XMPushService.this.a(10, e);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class c extends j {
        private final bg.b a;

        public c(bg.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "bind time out. chid=" + this.a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            this.a.a(bg.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return TextUtils.equals(((c) obj).a.g, this.a.g);
            }
            return false;
        }

        public int hashCode() {
            return this.a.g.hashCode();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class d extends j {
        private fl a;

        public d(fl flVar) {
            super(8);
            this.a = null;
            this.a = flVar;
        }

        public fl a() {
            return this.a;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public String mo1157a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            ao aoVar = this.a.f364a;
            if (aoVar != null) {
                aoVar.c = System.currentTimeMillis();
            }
            XMPushService.this.f844a.a(this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class e extends j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            if (XMPushService.this.m1150a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m586a("should not connect. quit the job.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m586a("network changed, " + com.xiaomi.push.m.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class g extends j {

        /* renamed from: a  reason: collision with other field name */
        public Exception f857a;
        public int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f857a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.a(this.b, this.f857a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class h extends j {
        h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class i extends j {
        private Intent a;

        public i(Intent intent) {
            super(15);
            this.a = null;
            this.a = intent;
        }

        public Intent a() {
            return this.a;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "Handle intent action = " + this.a.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.d(this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class j extends p.b {
        public j(int i) {
            super(i);
        }

        /* renamed from: a */
        public abstract String mo1157a();

        /* renamed from: a */
        public abstract void mo878a();

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i != 4 && i != 8) {
                com.xiaomi.channel.commonutils.logger.b.m587a(com.xiaomi.channel.commonutils.logger.a.a, mo1157a());
            }
            mo878a();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class k extends BroadcastReceiver {
        k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m586a("[HB] hold short heartbeat, " + com.xiaomi.push.m.a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class l extends j {
        public l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.f847a.m1227a();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class m extends j {
        private gn a;

        public m(gn gnVar) {
            super(8);
            this.a = null;
            this.a = gnVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.f844a.a(this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface n {
        /* renamed from: a */
        void mo951a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class o extends j {

        /* renamed from: a  reason: collision with other field name */
        boolean f860a;

        public o(boolean z) {
            super(4);
            this.f860a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            if (XMPushService.this.m1155c()) {
                try {
                    if (!this.f860a) {
                        fj.a();
                    }
                    XMPushService.this.f836a.b(this.f860a);
                } catch (gh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class p extends j {

        /* renamed from: a  reason: collision with other field name */
        bg.b f861a;

        public p(bg.b bVar) {
            super(4);
            this.f861a = null;
            this.f861a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "rebind the client. " + this.f861a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            try {
                this.f861a.a(bg.c.unbind, 1, 16, (String) null, (String) null);
                fw fwVar = XMPushService.this.f836a;
                bg.b bVar = this.f861a;
                fwVar.a(bVar.g, bVar.f928b);
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(new b(this.f861a), 300L);
            } catch (gh e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class q extends j {
        q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m1150a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class r extends BroadcastReceiver {
        r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class s extends j {

        /* renamed from: a  reason: collision with other field name */
        bg.b f862a;

        /* renamed from: a  reason: collision with other field name */
        String f863a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        String f864b;

        public s(bg.b bVar, int i, String str, String str2) {
            super(9);
            this.f862a = null;
            this.f862a = bVar;
            this.b = i;
            this.f863a = str;
            this.f864b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo1157a() {
            return "unbind the channel. " + this.f862a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo878a() {
            if (this.f862a.f923a != bg.c.unbind && XMPushService.this.f836a != null) {
                try {
                    fw fwVar = XMPushService.this.f836a;
                    bg.b bVar = this.f862a;
                    fwVar.a(bVar.g, bVar.f928b);
                } catch (gh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f862a.a(bg.c.unbind, this.b, 0, this.f864b, this.f863a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class t extends BroadcastReceiver {
        t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f852a) {
                XMPushService.this.f852a = true;
            }
            com.xiaomi.channel.commonutils.logger.b.m586a("[HB] wifi changed, " + com.xiaomi.push.m.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    private gn a(gn gnVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        bg a2 = bg.a();
        List<String> m1196a = a2.m1196a(str);
        if (m1196a.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            gnVar.o(str);
            str = gnVar.k();
            if (TextUtils.isEmpty(str)) {
                str = m1196a.get(0);
                gnVar.l(str);
            }
            bg.b a3 = a2.a(str, gnVar.m());
            if (!m1155c()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (a3 != null && a3.f923a == bg.c.binded) {
                if (TextUtils.equals(str2, a3.i)) {
                    return gnVar;
                }
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                com.xiaomi.channel.commonutils.logger.b.m586a(sb.toString());
                return null;
            } else {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            }
        }
        sb.append(str3);
        sb.append(str);
        com.xiaomi.channel.commonutils.logger.b.m586a(sb.toString());
        return null;
    }

    private bg.b a(String str, Intent intent) {
        bg.b a2 = bg.a().a(str, intent.getStringExtra(bk.q));
        if (a2 == null) {
            a2 = new bg.b(this);
        }
        a2.g = intent.getStringExtra(bk.t);
        a2.f928b = intent.getStringExtra(bk.q);
        a2.c = intent.getStringExtra(bk.v);
        a2.f925a = intent.getStringExtra(bk.B);
        a2.e = intent.getStringExtra(bk.z);
        a2.f = intent.getStringExtra(bk.A);
        a2.f927a = intent.getBooleanExtra(bk.y, false);
        a2.h = intent.getStringExtra(bk.x);
        a2.i = intent.getStringExtra(bk.F);
        a2.d = intent.getStringExtra(bk.w);
        a2.f924a = this.f846a;
        a2.a((Messenger) intent.getParcelableExtra(bk.J));
        a2.f917a = getApplicationContext();
        bg.a().a(a2);
        return a2;
    }

    private String a() {
        String m1116a = com.xiaomi.push.m.m1116a("ro.miui.region");
        return TextUtils.isEmpty(m1116a) ? com.xiaomi.push.m.m1116a("ro.product.locale.region") : m1116a;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        com.xiaomi.push.service.o.a(getApplicationContext()).m1223a(extras.getString("digest"));
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ii iiVar = new ii();
        try {
            it.a(iiVar, byteArrayExtra);
            com.xiaomi.push.al.a(getApplicationContext()).a((al.a) new com.xiaomi.push.service.b(iiVar, new WeakReference(this), booleanExtra), i2);
        } catch (iz unused) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
        }
    }

    private void a(com.xiaomi.push.service.a aVar) {
        String str;
        String str2;
        if (aVar == null || !TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.a())) {
            str = "no need to check country code";
        } else {
            String a2 = "com.xiaomi.xmsf".equals(getPackageName()) ? a() : com.xiaomi.push.m.b();
            if (!TextUtils.isEmpty(a2)) {
                String name = com.xiaomi.push.m.a(a2).name();
                if (TextUtils.equals(name, aVar.a())) {
                    aVar.b(a2);
                    str2 = "update country code";
                } else {
                    str2 = "not update country code, because not equals " + name;
                }
                com.xiaomi.channel.commonutils.logger.b.m586a(str2);
                return;
            }
            str = "check no country code";
        }
        com.xiaomi.channel.commonutils.logger.b.b(str);
    }

    private static void a(String str) {
        String str2;
        String str3;
        if (com.xiaomi.push.q.China.name().equals(str)) {
            cv.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            cv.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            cv.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            cv.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            cv.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            str2 = "resolver.msg.xiaomi.net";
            cv.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            str3 = "111.202.1.252:443";
        } else {
            cv.a("app.chat.global.xiaomi.net", "app.chat.global.xiaomi.net");
            str2 = "resolver.msg.global.xiaomi.net";
            cv.a("resolver.msg.global.xiaomi.net", "161.117.97.14:443");
            str3 = "161.117.180.178:443";
        }
        cv.a(str2, str3);
    }

    private void a(String str, int i2) {
        Collection<bg.b> m1195a = bg.a().m1195a(str);
        if (m1195a != null) {
            for (bg.b bVar : m1195a) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        bg.a().m1198a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            com.xiaomi.push.ar.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (com.xiaomi.push.bj.c(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m586a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m1139a(String str, Intent intent) {
        bg.b a2 = bg.a().a(str, intent.getStringExtra(bk.q));
        boolean z = false;
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(bk.F);
        String stringExtra2 = intent.getStringExtra(bk.x);
        if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
            com.xiaomi.channel.commonutils.logger.b.m586a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m586a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.bo.a(stringExtra2));
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m1140a() {
        String[] split;
        String a2 = ba.a(getApplicationContext()).a(ho.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23) {
                    if (iArr[0] != iArr[1]) {
                        return iArr;
                    }
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    private String b() {
        String b2;
        com.xiaomi.push.ar.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str = null;
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            bn a2 = bn.a(this);
            String str2 = null;
            while (true) {
                if (!TextUtils.isEmpty(str2) && a2.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = a();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i2++;
            }
            b2 = a();
        } else {
            b2 = com.xiaomi.push.m.b();
        }
        if (!TextUtils.isEmpty(b2)) {
            com.xiaomi.push.service.a.a(getApplicationContext()).b(b2);
            str = com.xiaomi.push.m.a(b2).name();
        }
        com.xiaomi.channel.commonutils.logger.b.m586a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " , count = " + i2);
        return str;
    }

    private void b(Intent intent) {
        long j2;
        String str;
        fl flVar;
        String stringExtra = intent.getStringExtra(bk.B);
        String stringExtra2 = intent.getStringExtra(bk.F);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        bg a2 = bg.a();
        if (bundleExtra != null) {
            gm gmVar = (gm) a(new gm(bundleExtra), stringExtra, stringExtra2);
            if (gmVar == null) {
                return;
            }
            flVar = fl.a(gmVar, a2.a(gmVar.k(), gmVar.m()).h);
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(bk.q));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(bk.r);
                String stringExtra4 = intent.getStringExtra(bk.s);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                bg.b a3 = a2.a(stringExtra5, String.valueOf(j2));
                if (a3 != null) {
                    fl flVar2 = new fl();
                    if ("10".equals(stringExtra5)) {
                        flVar2.b(Integer.parseInt("10"));
                        flVar2.f364a.f893a = intent.getBooleanExtra("screen_on", true);
                        flVar2.f364a.f895b = intent.getBooleanExtra("wifi", true);
                        str = stringExtra3;
                        flVar2.f364a.f892a = intent.getLongExtra("rx_msg", -1L);
                        flVar2.f364a.f894b = intent.getLongExtra("enqueue", -1L);
                        flVar2.f364a.b = intent.getIntExtra(GiftNumBean.KEY_NUM, -1);
                        flVar2.f364a.c = intent.getLongExtra("run", -1L);
                    } else {
                        str = stringExtra3;
                    }
                    try {
                        flVar2.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    flVar2.a("SECMSG", (String) null);
                    flVar2.a(j2, TextUtils.isEmpty(str) ? "xiaomi.com" : str, stringExtra4);
                    flVar2.a(intent.getStringExtra("ext_pkt_id"));
                    flVar2.a(byteArrayExtra, a3.h);
                    com.xiaomi.channel.commonutils.logger.b.m586a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    flVar = flVar2;
                }
            }
            flVar = null;
        }
        if (flVar != null) {
            c(new bt(this, flVar));
        }
    }

    private void b(boolean z) {
        this.f832a = SystemClock.elapsedRealtime();
        if (m1155c()) {
            if (com.xiaomi.push.bj.b(this)) {
                c(new o(z));
                return;
            }
            c(new g(17, null));
        }
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str;
        com.xiaomi.push.service.a a2 = com.xiaomi.push.service.a.a(getApplicationContext());
        String a3 = a2.a();
        com.xiaomi.channel.commonutils.logger.b.m586a("region of cache is " + a3);
        if (TextUtils.isEmpty(a3)) {
            a3 = b();
        } else {
            a(a2);
        }
        if (TextUtils.isEmpty(a3)) {
            this.f849a = com.xiaomi.push.q.China.name();
        } else {
            this.f849a = a3;
            a2.a(a3);
            if (com.xiaomi.push.q.Global.name().equals(this.f849a)) {
                str = "app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.q.Europe.name().equals(this.f849a)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.q.Russia.name().equals(this.f849a)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.q.India.name().equals(this.f849a)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            fx.a(str);
        }
        if (com.xiaomi.push.q.China.name().equals(this.f849a)) {
            fx.a("cn.app.chat.xiaomi.net");
        }
        a(this.f849a);
        if (m1145h()) {
            cs csVar = new cs(this, 11);
            a(csVar);
            u.a(new ct(this, csVar));
        }
        try {
            if (com.xiaomi.push.v.m1247a()) {
                this.f846a.a(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(bk.B);
        String stringExtra2 = intent.getStringExtra(bk.F);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        gm[] gmVarArr = new gm[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            gmVarArr[i2] = new gm((Bundle) parcelableArrayExtra[i2]);
            gmVarArr[i2] = (gm) a(gmVarArr[i2], stringExtra, stringExtra2);
            if (gmVarArr[i2] == null) {
                return;
            }
        }
        bg a2 = bg.a();
        fl[] flVarArr = new fl[length];
        for (int i3 = 0; i3 < length; i3++) {
            gm gmVar = gmVarArr[i3];
            flVarArr[i3] = fl.a(gmVar, a2.a(gmVar.k(), gmVar.m()).h);
        }
        c(new com.xiaomi.push.service.c(this, flVarArr));
    }

    private void c(j jVar) {
        this.f847a.a(jVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.v.m1247a()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (ar arVar : (ar[]) this.f851a.toArray(new ar[0])) {
                    arVar.mo1213a();
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) getSystemService("connectivity"));
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            networkInfo = null;
        }
        com.xiaomi.push.service.o.a(getApplicationContext()).a(networkInfo);
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append(jn1.ARRAY_START_STR + "type: " + networkInfo.getTypeName() + jn1.ARRAY_START_STR + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            com.xiaomi.channel.commonutils.logger.b.m586a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m586a("network changed, no active network");
        }
        if (fh.a() != null) {
            fh.a().m880a();
        }
        hb.m949a((Context) this);
        this.f835a.d();
        if (com.xiaomi.push.bj.b(this)) {
            if (m1155c() && m1143f()) {
                b(false);
            }
            if (!m1155c() && !m1156d()) {
                this.f847a.a(1);
                a(new e());
            }
            df.a(this).a();
        } else {
            a(new g(2, null));
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:376:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(android.content.Intent r12) {
        /*
            Method dump skipped, instructions count: 2306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.d(android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!m1150a()) {
            eu.a();
        } else if (eu.m872a()) {
        } else {
            eu.a(true);
        }
    }

    private void e(Intent intent) {
        int i2;
        try {
            ed.a(getApplicationContext()).a(new bm());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra == null) {
                return;
            }
            ii iiVar = new ii();
            it.a(iiVar, byteArrayExtra);
            String b2 = iiVar.b();
            Map<String, String> m1038a = iiVar.m1038a();
            if (m1038a != null) {
                String str = m1038a.get("extra_help_aw_info");
                String str2 = m1038a.get("extra_aw_app_online_cmd");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    i2 = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(str)) {
                    return;
                }
                ed.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
            }
        } catch (iz e2) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e2.getMessage());
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m1142e() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String str;
        fw fwVar = this.f836a;
        if (fwVar == null || !fwVar.m914b()) {
            fw fwVar2 = this.f836a;
            if (fwVar2 == null || !fwVar2.m915c()) {
                this.f837a.b(com.xiaomi.push.bj.m693a((Context) this));
                g();
                if (this.f836a == null) {
                    bg.a().a(this);
                    c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m1143f() {
        if (SystemClock.elapsedRealtime() - this.f832a < 30000) {
            return false;
        }
        return com.xiaomi.push.bj.d(this);
    }

    private void g() {
        try {
            this.f835a.a(this.f838a, new cl(this));
            this.f835a.e();
            this.f836a = this.f835a;
        } catch (gh e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f835a.b(3, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g  reason: collision with other method in class */
    public boolean m1144g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m1145h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !v.a(this).m1243b(getPackageName());
    }

    private void i() {
        synchronized (this.f850a) {
            this.f850a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m1146i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.j.m1095b((Context) this) && !com.xiaomi.push.j.m1093a(getApplicationContext());
    }

    private boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.a;
        int i3 = this.f853b;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ba.a(this).a(ho.ForegroundServiceSwitch.a(), false);
    }

    /* renamed from: a  reason: collision with other method in class */
    public fw m1147a() {
        return this.f836a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.xiaomi.push.service.j m1148a() {
        return new com.xiaomi.push.service.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m1149a() {
        if (SystemClock.elapsedRealtime() - this.f832a >= gc.a() && com.xiaomi.push.bj.d(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.f847a.a(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(AVFSCacheConstants.COMMA_SEP);
        fw fwVar = this.f836a;
        sb.append(fwVar == null ? null : Integer.valueOf(fwVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m586a(sb.toString());
        fw fwVar2 = this.f836a;
        if (fwVar2 != null) {
            fwVar2.b(i2, exc);
            this.f836a = null;
        }
        a(7);
        a(4);
        bg.a().a(this, i2);
    }

    public void a(fl flVar) {
        fw fwVar = this.f836a;
        if (fwVar == null) {
            throw new gh("try send msg while connection is null.");
        }
        fwVar.b(flVar);
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        fh.a().a(fwVar);
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i2, Exception exc) {
        fh.a().a(fwVar, i2, exc);
        if (m1146i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, Exception exc) {
        fh.a().a(fwVar, exc);
        c(false);
        if (m1146i()) {
            return;
        }
        a(false);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(j jVar, long j2) {
        try {
            this.f847a.a(jVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m586a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(n nVar) {
        synchronized (this.f850a) {
            this.f850a.add(nVar);
        }
    }

    public void a(bg.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m586a("schedule rebind job in " + (a2 / 1000));
            a(new b(bVar), a2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        bg.b a2 = bg.a().a(str, str2);
        if (a2 != null) {
            a(new s(a2, i2, str4, str3));
        }
        bg.a().m1199a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, byte[] bArr, boolean z) {
        Collection<bg.b> m1195a = bg.a().m1195a("5");
        if (m1195a.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (m1195a.iterator().next().f923a == bg.c.binded) {
            a(new cj(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        x.b(str, bArr);
    }

    public void a(boolean z) {
        this.f845a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m586a("register request without payload");
            return;
        }
        Cif cif = new Cif();
        try {
            it.a(cif, bArr);
            if (cif.f617a == hj.Registration) {
                ij ijVar = new ij();
                try {
                    it.a(ijVar, cif.m1028a());
                    a(new w(this, cif.b(), ijVar.b(), ijVar.c(), bArr));
                    eo.a(getApplicationContext()).a(cif.b(), "E100003", ijVar.a(), 6002, null);
                } catch (iz e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m586a("register request with invalid payload");
            }
        } catch (iz e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(fl[] flVarArr) {
        fw fwVar = this.f836a;
        if (fwVar == null) {
            throw new gh("try send msg while connection is null.");
        }
        fwVar.a(flVarArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1150a() {
        boolean b2 = com.xiaomi.push.bj.b(this);
        boolean z = bg.a().m1193a() > 0;
        boolean z2 = !m1154b();
        boolean m1145h = m1145h();
        boolean z3 = !m1144g();
        boolean z4 = b2 && z && z2 && m1145h && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(b2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m1145h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1151a(int i2) {
        return this.f847a.m1229a(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public com.xiaomi.push.service.j m1152b() {
        return this.f846a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public void m1153b() {
        com.xiaomi.push.service.o.a(getApplicationContext()).m1226d();
        Iterator it = new ArrayList(this.f850a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).mo951a();
        }
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        fh.a().b(fwVar);
        c(true);
        this.f845a.m1205a();
        if (!eu.m872a() && !m1146i()) {
            com.xiaomi.channel.commonutils.logger.b.m586a("reconnection successful, reactivate alarm.");
            eu.a(true);
        }
        Iterator<bg.b> it = bg.a().m1194a().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (this.f852a || !com.xiaomi.push.m.m1119a(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.al.a(getApplicationContext()).a(new cm(this));
    }

    public void b(j jVar) {
        this.f847a.a(jVar.a, jVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1154b() {
        try {
            Class<?> a2 = com.xiaomi.push.v.a(this, "miui.os.Build");
            Field field = a2.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = a2.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = a2.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1155c() {
        fw fwVar = this.f836a;
        return fwVar != null && fwVar.m915c();
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m1156d() {
        fw fwVar = this.f836a;
        return fwVar != null && fwVar.m914b();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f834a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.push.v.a((Context) this);
        com.xiaomi.push.service.t m1238a = u.m1238a((Context) this);
        if (m1238a != null) {
            com.xiaomi.push.ae.a(m1238a.a);
        }
        if (com.xiaomi.push.m.m1119a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f839a = new a(this, null);
            registerReceiver(this.f839a, new IntentFilter(bk.p), null, handler);
            b = true;
            handler.post(new cn(this));
        }
        this.f834a = new Messenger(new co(this));
        bl.a(this);
        cp cpVar = new cp(this, null, 5222, "xiaomi.com", null);
        this.f837a = cpVar;
        cpVar.a(true);
        this.f835a = new fs(this, this.f837a);
        this.f846a = m1148a();
        eu.a(this);
        this.f835a.a(this);
        this.f844a = new be(this);
        this.f845a = new bq(this);
        new com.xiaomi.push.service.k().a();
        fh.m881a().a(this);
        this.f847a = new com.xiaomi.push.service.p("Connection Controller Thread");
        bg a2 = bg.a();
        a2.b();
        a2.a(new cq(this));
        if (k()) {
            h();
        }
        hg.a(this).a(new com.xiaomi.push.service.r(this), "UPLOADER_PUSH_CHANNEL");
        a(new hd(this));
        a(new cg(this));
        if (com.xiaomi.push.m.m1119a((Context) this)) {
            a(new bf());
        }
        a(new h());
        this.f851a.add(bx.a(this));
        if (m1145h()) {
            this.f840a = new f();
            registerReceiver(this.f840a, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        }
        if (com.xiaomi.push.m.m1119a(getApplicationContext())) {
            this.f843a = new t();
            registerReceiver(this.f843a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null);
            k kVar = new k();
            this.f841a = kVar;
            registerReceiver(kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null);
        }
        com.xiaomi.push.service.o.a(getApplicationContext()).m1222a();
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f833a = new cr(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f833a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] m1140a = m1140a();
            if (m1140a != null) {
                this.f842a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f842a, intentFilter);
                this.a = m1140a[0];
                this.f853b = m1140a[1];
                com.xiaomi.channel.commonutils.logger.b.m586a("falldown initialized: " + this.a + "," + this.f853b);
            }
        }
        String str = "";
        if (m1238a != null) {
            try {
                if (!TextUtils.isEmpty(m1238a.f996a) && (split = m1238a.f996a.split(m80.DINAMIC_PREFIX_AT)) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        dd.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.h.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        f fVar = this.f840a;
        if (fVar != null) {
            a(fVar);
            this.f840a = null;
        }
        t tVar = this.f843a;
        if (tVar != null) {
            a(tVar);
            this.f843a = null;
        }
        k kVar = this.f841a;
        if (kVar != null) {
            a(kVar);
            this.f841a = null;
        }
        r rVar = this.f842a;
        if (rVar != null) {
            a(rVar);
            this.f842a = null;
        }
        a aVar = this.f839a;
        if (aVar != null) {
            a(aVar);
            this.f839a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f833a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f833a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f851a.clear();
        this.f847a.m1230b();
        a(new ck(this, 2));
        a(new l());
        bg.a().b();
        bg.a().a(this, 15);
        bg.a().m1197a();
        this.f835a.b(this);
        bv.a().m1211a();
        eu.a();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m586a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.m586a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(bk.t), intent.getStringExtra(bk.B), intent.getStringExtra("mipush_app_package")));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f847a.m1228a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    bg.a().a(this, 14);
                    stopSelf();
                } else {
                    iVar = new i(intent);
                    a(iVar);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                if ("10".equals(intent.getStringExtra("ext_chid"))) {
                    intent.putExtra("rx_msg", System.currentTimeMillis());
                    intent.putExtra("screen_on", com.xiaomi.push.w.a(getApplicationContext()));
                    intent.putExtra("wifi", com.xiaomi.push.bj.e(getApplicationContext()));
                }
                iVar = new i(intent);
                a(iVar);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return 1;
    }
}
