package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.tencent.connect.common.Constants;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.mtop.intf.Mtop;
import org.apache.commons.lang3.time.DateUtils;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bg {
    private static bg a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f916a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private List<a> f915a = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface a {
        void a();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f917a;

        /* renamed from: a  reason: collision with other field name */
        Messenger f919a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f921a;

        /* renamed from: a  reason: collision with other field name */
        public j f924a;

        /* renamed from: a  reason: collision with other field name */
        public String f925a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f927a;

        /* renamed from: b  reason: collision with other field name */
        public String f928b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        c f923a = c.unbind;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private List<a> f926a = new ArrayList();
        c b = null;

        /* renamed from: b  reason: collision with other field name */
        private boolean f929b = false;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.c f920a = new XMPushService.c(this);

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f918a = null;

        /* renamed from: a  reason: collision with other field name */
        final C0360b f922a = new C0360b();

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.xiaomi.push.service.bg$b$b  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0360b extends XMPushService.j {

            /* renamed from: a  reason: collision with other field name */
            String f930a;
            int b;

            /* renamed from: b  reason: collision with other field name */
            String f931b;
            int c;

            public C0360b() {
                super(0);
            }

            public XMPushService.j a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f931b = str2;
                this.f930a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public String mo1157a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo878a() {
                if (b.this.a(this.b, this.c, this.f931b)) {
                    b.this.a(this.b, this.c, this.f930a, this.f931b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public class c implements IBinder.DeathRecipient {
            final Messenger a;

            /* renamed from: a  reason: collision with other field name */
            final b f932a;

            c(b bVar, Messenger messenger) {
                this.f932a = bVar;
                this.a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f932a.g);
                b.this.f921a.a(new bi(this, 0), 0L);
                if ("9".equals(this.f932a.g) && "com.xiaomi.xmsf".equals(b.this.f921a.getPackageName())) {
                    b.this.f921a.a(new bj(this, 0), DateUtils.MILLIS_PER_MINUTE);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f921a = xMPushService;
            a(new bh(this));
        }

        public static String a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            c cVar = this.f923a;
            this.b = cVar;
            if (i == 2) {
                this.f924a.a(this.f917a, this, i2);
            } else if (i == 3) {
                this.f924a.a(this.f917a, this, str2, str);
            } else if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.a++;
                } else if (z) {
                    this.a = 0;
                    if (this.f919a != null) {
                        try {
                            this.f919a.send(Message.obtain(null, 16, this.f921a.f834a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f924a.a(this.f921a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            boolean z;
            StringBuilder sb;
            String str2;
            c cVar = this.b;
            if (cVar == null || !(z = this.f929b)) {
                return true;
            }
            if (cVar == this.f923a) {
                sb = new StringBuilder();
                str2 = " status recovered, don't notify client:";
            } else if (this.f919a != null && z) {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.g);
                return true;
            } else {
                sb = new StringBuilder();
                str2 = "peer died, ignore notify ";
            }
            sb.append(str2);
            sb.append(this.g);
            com.xiaomi.channel.commonutils.logger.b.b(sb.toString());
            return false;
        }

        private boolean b(int i, int i2, String str) {
            if (i == 1) {
                return (this.f923a == c.binded || !this.f921a.m1155c() || i2 == 21 || (i2 == 7 && "wait".equals(str))) ? false : true;
            } else if (i != 2) {
                if (i != 3) {
                    return false;
                }
                return !"wait".equals(str);
            } else {
                return this.f921a.m1155c();
            }
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.a + 1) * 15)) * 1000;
        }

        public String a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : StandOutWindow.ACTION_CLOSE : Mtop.Id.OPEN;
        }

        /* renamed from: a  reason: collision with other method in class */
        void m1201a() {
            try {
                Messenger messenger = this.f919a;
                if (messenger != null && this.f918a != null) {
                    messenger.getBinder().unlinkToDeath(this.f918a, 0);
                }
            } catch (Exception unused) {
            }
            this.b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            m1201a();
            try {
                if (messenger != null) {
                    this.f919a = messenger;
                    this.f929b = true;
                    this.f918a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f918a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f919a = null;
                this.f929b = false;
            }
        }

        public void a(a aVar) {
            synchronized (this.f926a) {
                this.f926a.add(aVar);
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            boolean z;
            synchronized (this.f926a) {
                for (a aVar : this.f926a) {
                    aVar.a(this.f923a, cVar, i2);
                }
            }
            c cVar2 = this.f923a;
            int i3 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m586a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), bk.a(i2), str, str2, this.g));
                this.f923a = cVar;
            }
            if (this.f924a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                if (this.b != null && (z = this.f929b)) {
                    i3 = (this.f919a == null || !z) ? Constants.REQUEST_API : 1000;
                }
                this.f921a.b(this.f922a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f921a.a(this.f922a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            synchronized (this.f926a) {
                this.f926a.remove(aVar);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    private bg() {
    }

    public static synchronized bg a() {
        bg bgVar;
        synchronized (bg.class) {
            if (a == null) {
                a = new bg();
            }
            bgVar = a;
        }
        return bgVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(m80.DINAMIC_PREFIX_AT);
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m1193a() {
        return this.f916a.size();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> hashMap = this.f916a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(a(str2));
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m1194a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> hashMap : this.f916a.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m1195a(String str) {
        if (this.f916a.containsKey(str)) {
            return ((HashMap) this.f916a.get(str).clone()).values();
        }
        return new ArrayList();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m1196a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> hashMap : this.f916a.values()) {
            for (b bVar : hashMap.values()) {
                if (str.equals(bVar.f925a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m1197a() {
        Iterator<b> it = m1194a().iterator();
        while (it.hasNext()) {
            it.next().m1201a();
        }
        this.f916a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> hashMap : this.f916a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(Context context, int i) {
        for (HashMap<String, b> hashMap : this.f916a.values()) {
            for (b bVar : hashMap.values()) {
                bVar.a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    public synchronized void a(a aVar) {
        this.f915a.add(aVar);
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> hashMap = this.f916a.get(bVar.g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f916a.put(bVar.g, hashMap);
        }
        hashMap.put(a(bVar.f928b), bVar);
        com.xiaomi.channel.commonutils.logger.b.m586a("add active client. " + bVar.f925a);
        for (a aVar : this.f915a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m1198a(String str) {
        HashMap<String, b> hashMap = this.f916a.get(str);
        if (hashMap != null) {
            for (b bVar : hashMap.values()) {
                bVar.m1201a();
            }
            hashMap.clear();
            this.f916a.remove(str);
        }
        for (a aVar : this.f915a) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m1199a(String str, String str2) {
        HashMap<String, b> hashMap = this.f916a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(a(str2));
            if (bVar != null) {
                bVar.m1201a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f916a.remove(str);
            }
        }
        for (a aVar : this.f915a) {
            aVar.a();
        }
    }

    public synchronized void b() {
        this.f915a.clear();
    }
}
