package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ba {
    public static String a = "";
    public static boolean b = false;
    public static String d = "";
    private static volatile ba k;
    public be f;
    bg g;
    private Context i;
    private a l;
    private bj m;
    private bp n;
    private boolean j = true;
    List<az> c = new Vector();
    private ExecutorService o = null;
    private ExecutorService p = null;
    private ExecutorService q = null;
    b e = null;
    bd h = null;
    private boolean r = true;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void a(az azVar);

        void b(az azVar);

        void c(az azVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof az) {
                    az azVar = (az) obj;
                    bx.a("OfflineMapHandler handleMessage CitObj  name: " + azVar.getCity() + " complete: " + azVar.getcompleteCode() + " status: " + azVar.getState());
                    if (ba.this.l != null) {
                        ba.this.l.a(azVar);
                    }
                } else {
                    bx.a("Do not callback by CityObject! ");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private ba(Context context) {
        this.i = context;
    }

    public static void f() {
        k = null;
        b = true;
    }

    private void h() {
        try {
            bk a2 = this.n.a("000001");
            if (a2 != null) {
                this.n.c("000001");
                a2.c("100000");
                this.n.a(a2);
            }
        } catch (Throwable th) {
            hd.c(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    private void i() {
        String c;
        if ("".equals(eq.c(this.i))) {
            return;
        }
        File file = new File(eq.c(this.i) + "offlinemapv4.png");
        if (!file.exists()) {
            c = bx.a(this.i, "offlinemapv4.png");
        } else {
            c = bx.c(file);
        }
        if (c != null) {
            try {
                h(c);
            } catch (JSONException e) {
                if (file.exists()) {
                    file.delete();
                }
                hd.c(e, "MapDownloadManager", "paseJson io");
                e.printStackTrace();
            }
        }
    }

    private void j() {
        Iterator<bk> it = this.n.a().iterator();
        while (it.hasNext()) {
            bk next = it.next();
            if (next != null && next.d() != null && next.f().length() >= 1) {
                int i = next.l;
                if (i != 4 && i != 7 && i >= 0) {
                    next.l = 3;
                }
                az i2 = i(next.d());
                if (i2 != null) {
                    String e = next.e();
                    if (e != null && a(d, e)) {
                        i2.a(7);
                    } else {
                        i2.a(next.l);
                        i2.setCompleteCode(next.h());
                    }
                    if (next.e().length() > 0) {
                        i2.setVersion(next.e());
                    }
                    List<String> b2 = this.n.b(next.f());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : b2) {
                        stringBuffer.append(str);
                        stringBuffer.append(";");
                    }
                    i2.a(stringBuffer.toString());
                    be beVar = this.f;
                    if (beVar != null) {
                        beVar.a(i2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() throws AMapException {
        if (!eq.d(this.i)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    public void g() {
        synchronized (this) {
            this.l = null;
        }
    }

    protected void b() throws AMapException {
        if (this.f == null) {
            return;
        }
        bh bhVar = new bh(this.i, "");
        bhVar.a(this.i);
        List<OfflineMapProvince> c = bhVar.c();
        if (this.c != null) {
            this.f.a(c);
        }
        List<az> list = this.c;
        if (list != null) {
            synchronized (list) {
                Iterator<OfflineMapProvince> it = this.f.a().iterator();
                while (it.hasNext()) {
                    Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                    while (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        for (az azVar : this.c) {
                            if (next.getPinyin().equals(azVar.getPinyin())) {
                                String version = azVar.getVersion();
                                if (azVar.getState() == 4 && d.length() > 0 && a(d, version)) {
                                    azVar.j();
                                    azVar.setUrl(next.getUrl());
                                    azVar.t();
                                } else {
                                    azVar.setCity(next.getCity());
                                    azVar.setUrl(next.getUrl());
                                    azVar.t();
                                    azVar.setAdcode(next.getAdcode());
                                    azVar.setVersion(next.getVersion());
                                    azVar.setSize(next.getSize());
                                    azVar.setCode(next.getCode());
                                    azVar.setJianpin(next.getJianpin());
                                    azVar.setPinyin(next.getPinyin());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void c(String str) {
        az i = i(str);
        if (i == null) {
            a aVar = this.l;
            if (aVar != null) {
                try {
                    aVar.c(i);
                    return;
                } catch (Throwable th) {
                    hd.c(th, "OfflineDownloadManager", "remove");
                    return;
                }
            }
            return;
        }
        d(i);
        a(i, true);
    }

    public void d() {
        synchronized (this.c) {
            Iterator<az> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                az next = it.next();
                if (next.c().equals(next.c)) {
                    next.g();
                    break;
                }
            }
        }
    }

    public void e() {
        ExecutorService executorService = this.o;
        if (executorService != null && !executorService.isShutdown()) {
            this.o.shutdownNow();
        }
        ExecutorService executorService2 = this.q;
        if (executorService2 != null && !executorService2.isShutdown()) {
            this.q.shutdownNow();
        }
        bd bdVar = this.h;
        if (bdVar != null) {
            if (bdVar.isAlive()) {
                this.h.interrupt();
            }
            this.h = null;
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            this.e = null;
        }
        bj bjVar = this.m;
        if (bjVar != null) {
            bjVar.b();
        }
        be beVar = this.f;
        if (beVar != null) {
            beVar.g();
        }
        f();
        this.j = true;
        g();
    }

    private void f(final az azVar) throws AMapException {
        k();
        if (azVar != null) {
            if (this.q == null) {
                this.q = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ed("AMapOfflineDownload"), new ThreadPoolExecutor.AbortPolicy());
            }
            try {
                this.q.execute(new Runnable() { // from class: com.amap.api.mapcore.util.ba.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (ba.this.j) {
                                ba.this.k();
                                bb c = new bc(ba.this.i, ba.d).c();
                                if (c != null) {
                                    ba.this.j = false;
                                    if (c.a()) {
                                        ba.this.b();
                                    }
                                }
                            }
                            azVar.setVersion(ba.d);
                            azVar.f();
                        } catch (AMapException e) {
                            e.printStackTrace();
                        } catch (Throwable th) {
                            hd.c(th, "OfflineDownloadManager", "startDownloadRunnable");
                        }
                    }
                });
                return;
            } catch (Throwable th) {
                hd.c(th, "startDownload", "downloadExcecRunnable");
                return;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public static void g(String str) {
        a = str;
    }

    public static ba a(Context context) {
        if (k == null) {
            synchronized (ba.class) {
                if (k == null && !b) {
                    k = new ba(context.getApplicationContext());
                }
            }
        }
        return k;
    }

    private void h(String str) throws JSONException {
        be beVar;
        List<OfflineMapProvince> a2 = bx.a(str, this.i.getApplicationContext());
        if (a2 == null || a2.size() == 0 || (beVar = this.f) == null) {
            return;
        }
        beVar.a(a2);
    }

    public void d(String str) throws AMapException {
        az i = i(str);
        if (str != null && str.length() >= 1 && i != null) {
            f(i);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public void c(az azVar) {
        be beVar = this.f;
        if (beVar != null) {
            beVar.a(azVar);
        }
        b bVar = this.e;
        if (bVar != null) {
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.obj = azVar;
            this.e.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[Catch: all -> 0x0038, TryCatch #0 {, blocks: (B:9:0x000e, B:10:0x0014, B:12:0x001a, B:14:0x002a, B:16:0x0034, B:18:0x0036), top: B:24:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.amap.api.mapcore.util.az i(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L3b
            int r1 = r6.length()
            r2 = 1
            if (r1 >= r2) goto Lb
            goto L3b
        Lb:
            java.util.List<com.amap.api.mapcore.util.az> r1 = r5.c
            monitor-enter(r1)
            java.util.List<com.amap.api.mapcore.util.az> r2 = r5.c     // Catch: java.lang.Throwable -> L38
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L38
        L14:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L38
            if (r3 == 0) goto L36
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L38
            com.amap.api.mapcore.util.az r3 = (com.amap.api.mapcore.util.az) r3     // Catch: java.lang.Throwable -> L38
            java.lang.String r4 = r3.getCity()     // Catch: java.lang.Throwable -> L38
            boolean r4 = r6.equals(r4)     // Catch: java.lang.Throwable -> L38
            if (r4 != 0) goto L34
            java.lang.String r4 = r3.getPinyin()     // Catch: java.lang.Throwable -> L38
            boolean r4 = r6.equals(r4)     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L14
        L34:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L38
            return r3
        L36:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L38
            return r0
        L38:
            r6 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L38
            throw r6
        L3b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ba.i(java.lang.String):com.amap.api.mapcore.util.az");
    }

    public void d(az azVar) {
        bj bjVar = this.m;
        if (bjVar != null) {
            bjVar.a(azVar);
        }
    }

    public String f(String str) {
        az i;
        return (str == null || (i = i(str)) == null) ? "" : i.getAdcode();
    }

    public void a() {
        this.n = bp.a(this.i.getApplicationContext());
        h();
        b bVar = new b(this.i.getMainLooper());
        this.e = bVar;
        this.f = new be(this.i, bVar);
        this.m = bj.a(1);
        g(eq.c(this.i));
        try {
            i();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.c) {
            Iterator<OfflineMapProvince> it = this.f.a().iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity next = it2.next();
                    if (next != null) {
                        this.c.add(new az(this.i, next));
                    }
                }
            }
        }
        bd bdVar = new bd(this.i);
        this.h = bdVar;
        bdVar.start();
    }

    public void c() {
        synchronized (this.c) {
            for (az azVar : this.c) {
                if (azVar.c().equals(azVar.c) || azVar.c().equals(azVar.b)) {
                    d(azVar);
                    azVar.g();
                }
            }
        }
    }

    public void e(String str) throws AMapException {
        az j = j(str);
        if (j != null) {
            f(j);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    private az j(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        synchronized (this.c) {
            for (az azVar : this.c) {
                if (str.equals(azVar.getCode())) {
                    return azVar;
                }
            }
            return null;
        }
    }

    public void e(az azVar) {
        bj bjVar = this.m;
        if (bjVar != null) {
            bjVar.b(azVar);
        }
    }

    public boolean b(String str) {
        return i(str) != null;
    }

    public void a(ArrayList<bk> arrayList) {
        j();
        a aVar = this.l;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Throwable th) {
                hd.c(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public void b(az azVar) {
        try {
            bj bjVar = this.m;
            if (bjVar != null) {
                bjVar.a(azVar, this.i, null);
            }
        } catch (gb e) {
            e.printStackTrace();
        }
    }

    public void a(final String str) {
        try {
            if (str == null) {
                a aVar = this.l;
                if (aVar != null) {
                    aVar.b(null);
                    return;
                }
                return;
            }
            if (this.o == null) {
                this.o = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ed("AMapOfflineCheckUpdate"), new ThreadPoolExecutor.AbortPolicy());
            }
            this.o.execute(new Runnable() { // from class: com.amap.api.mapcore.util.ba.1
                @Override // java.lang.Runnable
                public void run() {
                    az i = ba.this.i(str);
                    if (i != null) {
                        try {
                            if (!i.c().equals(i.c) && !i.c().equals(i.e)) {
                                String pinyin = i.getPinyin();
                                if (pinyin.length() > 0) {
                                    String d2 = ba.this.n.d(pinyin);
                                    if (d2 == null) {
                                        d2 = i.getVersion();
                                    }
                                    if (ba.d.length() > 0 && d2 != null && ba.this.a(ba.d, d2)) {
                                        i.j();
                                    }
                                }
                            }
                            if (ba.this.l != null) {
                                synchronized (ba.this) {
                                    try {
                                        ba.this.l.b(i);
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            if (ba.this.l != null) {
                                synchronized (ba.this) {
                                    try {
                                        ba.this.l.b(i);
                                        return;
                                    }
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            if (ba.this.l != null) {
                                synchronized (ba.this) {
                                    try {
                                        ba.this.l.b(i);
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                    ba.this.k();
                    bb c = new bc(ba.this.i, ba.d).c();
                    if (ba.this.l != null) {
                        if (c == null) {
                            if (ba.this.l != null) {
                                synchronized (ba.this) {
                                    try {
                                        ba.this.l.b(i);
                                    }
                                }
                                return;
                            }
                            return;
                        } else if (c.a()) {
                            ba.this.b();
                        }
                    }
                    if (ba.this.l != null) {
                        synchronized (ba.this) {
                            try {
                                ba.this.l.b(i);
                            }
                        }
                    }
                }
            });
        } catch (Throwable th) {
            hd.c(th, "OfflineDownloadManager", "checkUpdate");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            try {
                if (str.charAt(i) > str2.charAt(i)) {
                    return true;
                }
                if (str.charAt(i) < str2.charAt(i)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void a(az azVar) {
        a(azVar, false);
    }

    private void a(final az azVar, final boolean z) {
        if (this.g == null) {
            this.g = new bg(this.i);
        }
        if (this.p == null) {
            this.p = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ed("AMapOfflineRemove"), new ThreadPoolExecutor.AbortPolicy());
        }
        try {
            this.p.execute(new Runnable() { // from class: com.amap.api.mapcore.util.ba.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (azVar.c().equals(azVar.a)) {
                            if (ba.this.l != null) {
                                ba.this.l.c(azVar);
                                return;
                            }
                            return;
                        }
                        if (azVar.getState() != 7 && azVar.getState() != -1) {
                            ba.this.g.a(azVar);
                            if (ba.this.l != null) {
                                ba.this.l.c(azVar);
                                return;
                            }
                            return;
                        }
                        ba.this.g.a(azVar);
                        if (!z || ba.this.l == null) {
                            return;
                        }
                        ba.this.l.c(azVar);
                    } catch (Throwable th) {
                        hd.c(th, "requestDelete", "removeExcecRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            hd.c(th, "requestDelete", "removeExcecRunnable");
        }
    }

    public void a(a aVar) {
        this.l = aVar;
    }
}
