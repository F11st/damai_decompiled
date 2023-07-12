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
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.channel.commonutils.logger.C7534a;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.C7596ae;
import com.xiaomi.push.C7601ar;
import com.xiaomi.push.C7662gc;
import com.xiaomi.push.C7667h;
import com.xiaomi.push.C7680j;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.C7786v;
import com.xiaomi.push.C7787w;
import com.xiaomi.push.Cif;
import com.xiaomi.push.EnumC7693q;
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
import com.xiaomi.push.service.C7766p;
import com.xiaomi.push.service.bg;
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
    private C7698a f839a;

    /* renamed from: a  reason: collision with other field name */
    private C7703f f840a;

    /* renamed from: a  reason: collision with other field name */
    private C7708k f841a;

    /* renamed from: a  reason: collision with other field name */
    private C7715r f842a;

    /* renamed from: a  reason: collision with other field name */
    private C7717t f843a;

    /* renamed from: a  reason: collision with other field name */
    private bq f845a;

    /* renamed from: a  reason: collision with other field name */
    private C7759j f846a;

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
    private C7766p f847a = null;

    /* renamed from: a  reason: collision with other field name */
    Messenger f834a = null;

    /* renamed from: a  reason: collision with other field name */
    private Collection<InterfaceC7727ar> f851a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<InterfaceC7711n> f850a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private gb f838a = new ci(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$a */
    /* loaded from: classes11.dex */
    public class C7698a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with other field name */
        private final Object f854a;

        private C7698a() {
            this.f854a = new Object();
        }

        /* synthetic */ C7698a(XMPushService xMPushService, ci ciVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                AbstractC7535b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f854a) {
                try {
                    this.f854a.notifyAll();
                } catch (Exception e) {
                    AbstractC7535b.m586a("[Alarm] notify lock. " + e);
                }
            }
        }

        private void a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                AbstractC7535b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f854a) {
                try {
                    this.f854a.wait(j);
                } catch (InterruptedException e) {
                    AbstractC7535b.m586a("[Alarm] interrupt from waiting state. " + e);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            AbstractC7535b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!bk.p.equals(intent.getAction())) {
                AbstractC7535b.m586a("[Alarm] cancel the old ping timer");
                eu.a();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                AbstractC7535b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(3000L);
                    AbstractC7535b.m586a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$b */
    /* loaded from: classes11.dex */
    public class C7699b extends AbstractC7707j {

        /* renamed from: a  reason: collision with other field name */
        bg.C7737b f855a;

        public C7699b(bg.C7737b c7737b) {
            super(9);
            this.f855a = null;
            this.f855a = c7737b;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "bind the client. " + this.f855a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            String str;
            try {
                if (!XMPushService.this.m1155c()) {
                    AbstractC7535b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                bg a = bg.a();
                bg.C7737b c7737b = this.f855a;
                bg.C7737b a2 = a.a(c7737b.g, c7737b.f928b);
                if (a2 == null) {
                    str = "ignore bind because the channel " + this.f855a.g + " is removed ";
                } else if (a2.f923a == bg.EnumC7741c.unbind) {
                    a2.a(bg.EnumC7741c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.f836a.a(a2);
                    fj.a(XMPushService.this, a2);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + a2.f923a;
                }
                AbstractC7535b.m586a(str);
            } catch (Exception e) {
                AbstractC7535b.d("Meet error when trying to bind. " + e);
                XMPushService.this.a(10, e);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$c */
    /* loaded from: classes11.dex */
    public static class C7700c extends AbstractC7707j {
        private final bg.C7737b a;

        public C7700c(bg.C7737b c7737b) {
            super(12);
            this.a = c7737b;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "bind time out. chid=" + this.a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            this.a.a(bg.EnumC7741c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C7700c) {
                return TextUtils.equals(((C7700c) obj).a.g, this.a.g);
            }
            return false;
        }

        public int hashCode() {
            return this.a.g.hashCode();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$d */
    /* loaded from: classes11.dex */
    class C7701d extends AbstractC7707j {
        private fl a;

        public C7701d(fl flVar) {
            super(8);
            this.a = null;
            this.a = flVar;
        }

        public fl a() {
            return this.a;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a  reason: collision with other method in class */
        public String mo1157a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
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
    /* renamed from: com.xiaomi.push.service.XMPushService$e */
    /* loaded from: classes11.dex */
    public class C7702e extends AbstractC7707j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C7702e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            if (XMPushService.this.m1150a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            AbstractC7535b.m586a("should not connect. quit the job.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$f */
    /* loaded from: classes11.dex */
    public class C7703f extends BroadcastReceiver {
        C7703f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC7535b.m586a("network changed, " + C7688m.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$g */
    /* loaded from: classes11.dex */
    public class C7704g extends AbstractC7707j {

        /* renamed from: a  reason: collision with other field name */
        public Exception f857a;
        public int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C7704g(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f857a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.a(this.b, this.f857a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$h */
    /* loaded from: classes11.dex */
    class C7705h extends AbstractC7707j {
        C7705h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$i */
    /* loaded from: classes11.dex */
    public class C7706i extends AbstractC7707j {
        private Intent a;

        public C7706i(Intent intent) {
            super(15);
            this.a = null;
            this.a = intent;
        }

        public Intent a() {
            return this.a;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "Handle intent action = " + this.a.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.d(this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$j */
    /* loaded from: classes11.dex */
    public static abstract class AbstractC7707j extends C7766p.AbstractRunnableC7768b {
        public AbstractC7707j(int i) {
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
                AbstractC7535b.m587a(C7534a.a, mo1157a());
            }
            mo878a();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$k */
    /* loaded from: classes11.dex */
    class C7708k extends BroadcastReceiver {
        C7708k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC7535b.m586a("[HB] hold short heartbeat, " + C7688m.a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$l */
    /* loaded from: classes11.dex */
    class C7709l extends AbstractC7707j {
        public C7709l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.f847a.m1227a();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$m */
    /* loaded from: classes11.dex */
    class C7710m extends AbstractC7707j {
        private gn a;

        public C7710m(gn gnVar) {
            super(8);
            this.a = null;
            this.a = gnVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            XMPushService.this.f844a.a(this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$n */
    /* loaded from: classes11.dex */
    public interface InterfaceC7711n {
        /* renamed from: a */
        void mo951a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$o */
    /* loaded from: classes11.dex */
    public class C7712o extends AbstractC7707j {

        /* renamed from: a  reason: collision with other field name */
        boolean f860a;

        public C7712o(boolean z) {
            super(4);
            this.f860a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            if (XMPushService.this.m1155c()) {
                try {
                    if (!this.f860a) {
                        fj.a();
                    }
                    XMPushService.this.f836a.b(this.f860a);
                } catch (gh e) {
                    AbstractC7535b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$p */
    /* loaded from: classes11.dex */
    public class C7713p extends AbstractC7707j {

        /* renamed from: a  reason: collision with other field name */
        bg.C7737b f861a;

        public C7713p(bg.C7737b c7737b) {
            super(4);
            this.f861a = null;
            this.f861a = c7737b;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "rebind the client. " + this.f861a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            try {
                this.f861a.a(bg.EnumC7741c.unbind, 1, 16, (String) null, (String) null);
                fw fwVar = XMPushService.this.f836a;
                bg.C7737b c7737b = this.f861a;
                fwVar.a(c7737b.g, c7737b.f928b);
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(new C7699b(this.f861a), 300L);
            } catch (gh e) {
                AbstractC7535b.a(e);
                XMPushService.this.a(10, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$q */
    /* loaded from: classes11.dex */
    public class C7714q extends AbstractC7707j {
        C7714q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
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
    /* renamed from: com.xiaomi.push.service.XMPushService$r */
    /* loaded from: classes11.dex */
    class C7715r extends BroadcastReceiver {
        C7715r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$s */
    /* loaded from: classes11.dex */
    public class C7716s extends AbstractC7707j {

        /* renamed from: a  reason: collision with other field name */
        bg.C7737b f862a;

        /* renamed from: a  reason: collision with other field name */
        String f863a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        String f864b;

        public C7716s(bg.C7737b c7737b, int i, String str, String str2) {
            super(9);
            this.f862a = null;
            this.f862a = c7737b;
            this.b = i;
            this.f863a = str;
            this.f864b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public String mo1157a() {
            return "unbind the channel. " + this.f862a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
        /* renamed from: a */
        public void mo878a() {
            if (this.f862a.f923a != bg.EnumC7741c.unbind && XMPushService.this.f836a != null) {
                try {
                    fw fwVar = XMPushService.this.f836a;
                    bg.C7737b c7737b = this.f862a;
                    fwVar.a(c7737b.g, c7737b.f928b);
                } catch (gh e) {
                    AbstractC7535b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f862a.a(bg.EnumC7741c.unbind, this.b, 0, this.f864b, this.f863a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.XMPushService$t */
    /* loaded from: classes11.dex */
    class C7717t extends BroadcastReceiver {
        C7717t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f852a) {
                XMPushService.this.f852a = true;
            }
            AbstractC7535b.m586a("[HB] wifi changed, " + C7688m.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    private gn a(gn gnVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        bg a = bg.a();
        List<String> m1196a = a.m1196a(str);
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
            bg.C7737b a2 = a.a(str, gnVar.m());
            if (!m1155c()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (a2 != null && a2.f923a == bg.EnumC7741c.binded) {
                if (TextUtils.equals(str2, a2.i)) {
                    return gnVar;
                }
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                AbstractC7535b.m586a(sb.toString());
                return null;
            } else {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            }
        }
        sb.append(str3);
        sb.append(str);
        AbstractC7535b.m586a(sb.toString());
        return null;
    }

    private bg.C7737b a(String str, Intent intent) {
        bg.C7737b a = bg.a().a(str, intent.getStringExtra(bk.q));
        if (a == null) {
            a = new bg.C7737b(this);
        }
        a.g = intent.getStringExtra(bk.t);
        a.f928b = intent.getStringExtra(bk.q);
        a.c = intent.getStringExtra(bk.v);
        a.f925a = intent.getStringExtra(bk.B);
        a.e = intent.getStringExtra(bk.z);
        a.f = intent.getStringExtra(bk.A);
        a.f927a = intent.getBooleanExtra(bk.y, false);
        a.h = intent.getStringExtra(bk.x);
        a.i = intent.getStringExtra(bk.F);
        a.d = intent.getStringExtra(bk.w);
        a.f924a = this.f846a;
        a.a((Messenger) intent.getParcelableExtra(bk.J));
        a.f917a = getApplicationContext();
        bg.a().a(a);
        return a;
    }

    private String a() {
        String m1116a = C7688m.m1116a("ro.miui.region");
        return TextUtils.isEmpty(m1116a) ? C7688m.m1116a("ro.product.locale.region") : m1116a;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e) {
                AbstractC7535b.a(e);
            }
        }
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        C7764o.a(getApplicationContext()).m1223a(extras.getString("digest"));
    }

    private void a(Intent intent, int i) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ii iiVar = new ii();
        try {
            it.a(iiVar, byteArrayExtra);
            com.xiaomi.push.al.a(getApplicationContext()).a((al.AbstractRunnableC7597a) new C7733b(iiVar, new WeakReference(this), booleanExtra), i);
        } catch (iz unused) {
            AbstractC7535b.d("aw_ping : send help app ping  error");
        }
    }

    private void a(C7718a c7718a) {
        String str;
        String str2;
        if (c7718a == null || !TextUtils.isEmpty(c7718a.b()) || TextUtils.isEmpty(c7718a.a())) {
            str = "no need to check country code";
        } else {
            String a = "com.xiaomi.xmsf".equals(getPackageName()) ? a() : C7688m.b();
            if (!TextUtils.isEmpty(a)) {
                String name = C7688m.a(a).name();
                if (TextUtils.equals(name, c7718a.a())) {
                    c7718a.b(a);
                    str2 = "update country code";
                } else {
                    str2 = "not update country code, because not equals " + name;
                }
                AbstractC7535b.m586a(str2);
                return;
            }
            str = "check no country code";
        }
        AbstractC7535b.b(str);
    }

    private static void a(String str) {
        String str2;
        String str3;
        if (EnumC7693q.China.name().equals(str)) {
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

    private void a(String str, int i) {
        Collection<bg.C7737b> m1195a = bg.a().m1195a(str);
        if (m1195a != null) {
            for (bg.C7737b c7737b : m1195a) {
                if (c7737b != null) {
                    a(new C7716s(c7737b, i, null, null));
                }
            }
        }
        bg.a().m1198a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            C7601ar.a();
            for (int i = 100; i > 0; i--) {
                if (com.xiaomi.push.bj.c(context)) {
                    AbstractC7535b.m586a("network connectivity ok.");
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
        bg.C7737b a = bg.a().a(str, intent.getStringExtra(bk.q));
        boolean z = false;
        if (a == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(bk.F);
        String stringExtra2 = intent.getStringExtra(bk.x);
        if (!TextUtils.isEmpty(a.i) && !TextUtils.equals(stringExtra, a.i)) {
            AbstractC7535b.m586a("session changed. old session=" + a.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a.h)) {
            return z;
        }
        AbstractC7535b.m586a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.bo.a(stringExtra2));
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m1140a() {
        String[] split;
        String a = ba.a(getApplicationContext()).a(ho.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(a) && (split = a.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23) {
                    if (iArr[0] != iArr[1]) {
                        return iArr;
                    }
                }
            } catch (NumberFormatException e) {
                AbstractC7535b.d("parse falldown time range failure: " + e);
            }
        }
        return null;
    }

    private String b() {
        String b2;
        C7601ar.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str = null;
        int i = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            bn a = bn.a(this);
            String str2 = null;
            while (true) {
                if (!TextUtils.isEmpty(str2) && a.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = a();
                }
                try {
                    synchronized (obj) {
                        if (i < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i++;
            }
            b2 = a();
        } else {
            b2 = C7688m.b();
        }
        if (!TextUtils.isEmpty(b2)) {
            C7718a.a(getApplicationContext()).b(b2);
            str = C7688m.a(b2).name();
        }
        AbstractC7535b.m586a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " , count = " + i);
        return str;
    }

    private void b(Intent intent) {
        long j;
        String str;
        fl flVar;
        String stringExtra = intent.getStringExtra(bk.B);
        String stringExtra2 = intent.getStringExtra(bk.F);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        bg a = bg.a();
        if (bundleExtra != null) {
            gm gmVar = (gm) a(new gm(bundleExtra), stringExtra, stringExtra2);
            if (gmVar == null) {
                return;
            }
            flVar = fl.a(gmVar, a.a(gmVar.k(), gmVar.m()).h);
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j = Long.parseLong(intent.getStringExtra(bk.q));
                } catch (NumberFormatException unused) {
                    j = 0;
                }
                String stringExtra3 = intent.getStringExtra(bk.r);
                String stringExtra4 = intent.getStringExtra(bk.s);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                bg.C7737b a2 = a.a(stringExtra5, String.valueOf(j));
                if (a2 != null) {
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
                    flVar2.a(j, TextUtils.isEmpty(str) ? "xiaomi.com" : str, stringExtra4);
                    flVar2.a(intent.getStringExtra("ext_pkt_id"));
                    flVar2.a(byteArrayExtra, a2.h);
                    AbstractC7535b.m586a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
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
                c(new C7712o(z));
                return;
            }
            c(new C7704g(17, null));
        }
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str;
        C7718a a = C7718a.a(getApplicationContext());
        String a2 = a.a();
        AbstractC7535b.m586a("region of cache is " + a2);
        if (TextUtils.isEmpty(a2)) {
            a2 = b();
        } else {
            a(a);
        }
        if (TextUtils.isEmpty(a2)) {
            this.f849a = EnumC7693q.China.name();
        } else {
            this.f849a = a2;
            a.a(a2);
            if (EnumC7693q.Global.name().equals(this.f849a)) {
                str = "app.chat.global.xiaomi.net";
            } else if (EnumC7693q.Europe.name().equals(this.f849a)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (EnumC7693q.Russia.name().equals(this.f849a)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (EnumC7693q.India.name().equals(this.f849a)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            fx.a(str);
        }
        if (EnumC7693q.China.name().equals(this.f849a)) {
            fx.a("cn.app.chat.xiaomi.net");
        }
        a(this.f849a);
        if (m1145h()) {
            cs csVar = new cs(this, 11);
            a(csVar);
            C7777u.a(new ct(this, csVar));
        }
        try {
            if (C7786v.m1247a()) {
                this.f846a.a(this);
            }
        } catch (Exception e) {
            AbstractC7535b.a(e);
        }
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(bk.B);
        String stringExtra2 = intent.getStringExtra(bk.F);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        gm[] gmVarArr = new gm[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i = 0; i < parcelableArrayExtra.length; i++) {
            gmVarArr[i] = new gm((Bundle) parcelableArrayExtra[i]);
            gmVarArr[i] = (gm) a(gmVarArr[i], stringExtra, stringExtra2);
            if (gmVarArr[i] == null) {
                return;
            }
        }
        bg a = bg.a();
        fl[] flVarArr = new fl[length];
        for (int i2 = 0; i2 < length; i2++) {
            gm gmVar = gmVarArr[i2];
            flVarArr[i2] = fl.a(gmVar, a.a(gmVar.k(), gmVar.m()).h);
        }
        c(new C7747c(this, flVarArr));
    }

    private void c(AbstractC7707j abstractC7707j) {
        this.f847a.a(abstractC7707j);
    }

    private void c(boolean z) {
        try {
            if (C7786v.m1247a()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (InterfaceC7727ar interfaceC7727ar : (InterfaceC7727ar[]) this.f851a.toArray(new InterfaceC7727ar[0])) {
                    interfaceC7727ar.mo1213a();
                }
            }
        } catch (Exception e) {
            AbstractC7535b.a(e);
        }
    }

    private void d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) getSystemService("connectivity"));
        } catch (Exception e) {
            AbstractC7535b.a(e);
            networkInfo = null;
        }
        C7764o.a(getApplicationContext()).a(networkInfo);
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append(jn1.ARRAY_START_STR + "type: " + networkInfo.getTypeName() + jn1.ARRAY_START_STR + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            AbstractC7535b.m586a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            AbstractC7535b.m586a("network changed, no active network");
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
                a(new C7702e());
            }
            df.a(this).a();
        } else {
            a(new C7704g(2, null));
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
        int i;
        try {
            ed.a(getApplicationContext()).a(new C7744bm());
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
                    i = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(str)) {
                    return;
                }
                ed.a(getApplicationContext()).a(this, str, i, stringExtra, b2);
            }
        } catch (iz e) {
            AbstractC7535b.d("aw_logic: translate fail. " + e.getMessage());
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
        AbstractC7535b.d(str);
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
        } catch (gh e) {
            AbstractC7535b.a("fail to create Slim connection", e);
            this.f835a.b(3, e);
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
        return "com.xiaomi.xmsf".equals(getPackageName()) || !C7779v.a(this).m1243b(getPackageName());
    }

    private void i() {
        synchronized (this.f850a) {
            this.f850a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m1146i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !C7680j.m1095b((Context) this) && !C7680j.m1093a(getApplicationContext());
    }

    private boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i = this.a;
        int i2 = this.f853b;
        if (i > i2) {
            if (intValue >= i || intValue < i2) {
                return true;
            }
        } else if (i < i2 && intValue >= i && intValue < i2) {
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
    public C7759j m1148a() {
        return new C7759j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m1149a() {
        if (SystemClock.elapsedRealtime() - this.f832a >= C7662gc.a() && com.xiaomi.push.bj.d(this)) {
            b(true);
        }
    }

    public void a(int i) {
        this.f847a.a(i);
    }

    public void a(int i, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(AVFSCacheConstants.COMMA_SEP);
        fw fwVar = this.f836a;
        sb.append(fwVar == null ? null : Integer.valueOf(fwVar.hashCode()));
        AbstractC7535b.m586a(sb.toString());
        fw fwVar2 = this.f836a;
        if (fwVar2 != null) {
            fwVar2.b(i, exc);
            this.f836a = null;
        }
        a(7);
        a(4);
        bg.a().a(this, i);
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
        AbstractC7535b.c("begin to connect...");
        fh.a().a(fwVar);
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i, Exception exc) {
        fh.a().a(fwVar, i, exc);
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

    public void a(AbstractC7707j abstractC7707j) {
        a(abstractC7707j, 0L);
    }

    public void a(AbstractC7707j abstractC7707j, long j) {
        try {
            this.f847a.a(abstractC7707j, j);
        } catch (IllegalStateException e) {
            AbstractC7535b.m586a("can't execute job err = " + e.getMessage());
        }
    }

    public void a(InterfaceC7711n interfaceC7711n) {
        synchronized (this.f850a) {
            this.f850a.add(interfaceC7711n);
        }
    }

    public void a(bg.C7737b c7737b) {
        if (c7737b != null) {
            long a = c7737b.a();
            AbstractC7535b.m586a("schedule rebind job in " + (a / 1000));
            a(new C7699b(c7737b), a);
        }
    }

    public void a(String str, String str2, int i, String str3, String str4) {
        bg.C7737b a = bg.a().a(str, str2);
        if (a != null) {
            a(new C7716s(a, i, str4, str3));
        }
        bg.a().m1199a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, byte[] bArr, boolean z) {
        Collection<bg.C7737b> m1195a = bg.a().m1195a("5");
        if (m1195a.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (m1195a.iterator().next().f923a == bg.EnumC7741c.binded) {
            a(new cj(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        C7781x.b(str, bArr);
    }

    public void a(boolean z) {
        this.f845a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            C7781x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            AbstractC7535b.m586a("register request without payload");
            return;
        }
        Cif cif = new Cif();
        try {
            it.a(cif, bArr);
            if (cif.f617a == hj.Registration) {
                ij ijVar = new ij();
                try {
                    it.a(ijVar, cif.m1028a());
                    a(new C7780w(this, cif.b(), ijVar.b(), ijVar.c(), bArr));
                    eo.a(getApplicationContext()).a(cif.b(), "E100003", ijVar.a(), 6002, null);
                } catch (iz e) {
                    AbstractC7535b.d("app register error. " + e);
                    C7781x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                C7781x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                AbstractC7535b.m586a("register request with invalid payload");
            }
        } catch (iz e2) {
            AbstractC7535b.d("app register fail. " + e2);
            C7781x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
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
            AbstractC7535b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(b2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m1145h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1151a(int i) {
        return this.f847a.m1229a(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public C7759j m1152b() {
        return this.f846a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public void m1153b() {
        C7764o.a(getApplicationContext()).m1226d();
        Iterator it = new ArrayList(this.f850a).iterator();
        while (it.hasNext()) {
            ((InterfaceC7711n) it.next()).mo951a();
        }
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        fh.a().b(fwVar);
        c(true);
        this.f845a.m1205a();
        if (!eu.m872a() && !m1146i()) {
            AbstractC7535b.m586a("reconnection successful, reactivate alarm.");
            eu.a(true);
        }
        Iterator<bg.C7737b> it = bg.a().m1194a().iterator();
        while (it.hasNext()) {
            a(new C7699b(it.next()));
        }
        if (this.f852a || !C7688m.m1119a(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.al.a(getApplicationContext()).a(new cm(this));
    }

    public void b(AbstractC7707j abstractC7707j) {
        this.f847a.a(abstractC7707j.a, abstractC7707j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1154b() {
        try {
            Class<?> a = C7786v.a(this, "miui.os.Build");
            Field field = a.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = a.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = a.getField("IS_CT_CUSTOMIZATION_TEST");
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
        AbstractC7535b.a(getApplicationContext());
        C7786v.a((Context) this);
        C7776t m1238a = C7777u.m1238a((Context) this);
        if (m1238a != null) {
            C7596ae.a(m1238a.a);
        }
        if (C7688m.m1119a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f839a = new C7698a(this, null);
            registerReceiver(this.f839a, new IntentFilter(bk.p), null, handler);
            b = true;
            handler.post(new RunnableC7749cn(this));
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
        new C7760k().a();
        fh.m881a().a(this);
        this.f847a = new C7766p("Connection Controller Thread");
        bg a = bg.a();
        a.b();
        a.a(new cq(this));
        if (k()) {
            h();
        }
        hg.a(this).a(new C7773r(this), "UPLOADER_PUSH_CHANNEL");
        a(new hd(this));
        a(new cg(this));
        if (C7688m.m1119a((Context) this)) {
            a(new bf());
        }
        a(new C7705h());
        this.f851a.add(bx.a(this));
        if (m1145h()) {
            this.f840a = new C7703f();
            registerReceiver(this.f840a, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        }
        if (C7688m.m1119a(getApplicationContext())) {
            this.f843a = new C7717t();
            registerReceiver(this.f843a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null);
            C7708k c7708k = new C7708k();
            this.f841a = c7708k;
            registerReceiver(c7708k, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null);
        }
        C7764o.a(getApplicationContext()).m1222a();
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f833a = new cr(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f833a);
                } catch (Throwable th) {
                    AbstractC7535b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] m1140a = m1140a();
            if (m1140a != null) {
                this.f842a = new C7715r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f842a, intentFilter);
                this.a = m1140a[0];
                this.f853b = m1140a[1];
                AbstractC7535b.m586a("falldown initialized: " + this.a + "," + this.f853b);
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
        AbstractC7535b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + C7667h.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        C7703f c7703f = this.f840a;
        if (c7703f != null) {
            a(c7703f);
            this.f840a = null;
        }
        C7717t c7717t = this.f843a;
        if (c7717t != null) {
            a(c7717t);
            this.f843a = null;
        }
        C7708k c7708k = this.f841a;
        if (c7708k != null) {
            a(c7708k);
            this.f841a = null;
        }
        C7715r c7715r = this.f842a;
        if (c7715r != null) {
            a(c7715r);
            this.f842a = null;
        }
        C7698a c7698a = this.f839a;
        if (c7698a != null) {
            a(c7698a);
            this.f839a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f833a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f833a);
            } catch (Throwable th) {
                AbstractC7535b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f851a.clear();
        this.f847a.m1230b();
        a(new ck(this, 2));
        a(new C7709l());
        bg.a().b();
        bg.a().a(this, 15);
        bg.a().m1197a();
        this.f835a.b(this);
        bv.a().m1211a();
        eu.a();
        i();
        super.onDestroy();
        AbstractC7535b.m586a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        C7706i c7706i;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            AbstractC7535b.d("onStart() with intent NULL");
        } else {
            AbstractC7535b.m586a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(bk.t), intent.getStringExtra(bk.B), intent.getStringExtra("mipush_app_package")));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f847a.m1228a()) {
                    AbstractC7535b.d("ERROR, the job controller is blocked.");
                    bg.a().a(this, 14);
                    stopSelf();
                } else {
                    c7706i = new C7706i(intent);
                    a(c7706i);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                if ("10".equals(intent.getStringExtra("ext_chid"))) {
                    intent.putExtra("rx_msg", System.currentTimeMillis());
                    intent.putExtra("screen_on", C7787w.a(getApplicationContext()));
                    intent.putExtra("wifi", com.xiaomi.push.bj.e(getApplicationContext()));
                }
                c7706i = new C7706i(intent);
                a(c7706i);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            AbstractC7535b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return 1;
    }
}
