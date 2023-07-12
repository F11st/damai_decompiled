package com.efs.sdk.base.a.e;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.a;
import com.efs.sdk.base.a.b.g;
import com.efs.sdk.base.a.e.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import tb.j43;
import tb.m33;
import tb.n73;
import tb.o43;
import tb.q33;
import tb.r33;
import tb.v43;
import tb.w63;
import tb.x53;
import tb.x63;
import tb.z43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class a extends Handler {
    public int a;
    public c b;
    private c c;
    private List<String> d;
    private AtomicInteger e;
    private com.efs.sdk.base.a.b.f f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.efs.sdk.base.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0222a {
        private static final a a = new a((byte) 0);
    }

    private a() {
        super(r33.a.getLooper());
        this.a = 5;
        this.d = new ArrayList();
        this.e = new AtomicInteger(0);
        this.b = new m33();
        this.c = new x63();
        this.f = new g();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C0222a.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Object obj, int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = obj;
        obtain.arg1 = i;
        sendMessage(obtain);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        f fVar;
        v43 v43Var;
        com.efs.sdk.base.a.b.a aVar;
        List<File> list;
        n73 n73Var;
        super.handleMessage(message);
        fVar = f.a.a;
        if (fVar.b()) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                Object obj = message.obj;
                if (obj != null) {
                    this.d.remove(obj.toString());
                }
                int incrementAndGet = message.arg1 != 0 ? this.e.incrementAndGet() : 0;
                if (this.d.isEmpty()) {
                    if (incrementAndGet < 5) {
                        sendEmptyMessage(0);
                        return;
                    }
                    this.e.set(0);
                    sendEmptyMessageDelayed(0, com.efs.sdk.base.a.d.a.a().l);
                    w63.a("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    return;
                }
                return;
            }
            v43Var = v43.a.a;
            String a = v43Var.a();
            if ("denied".equalsIgnoreCase(a) || "disconnected".equalsIgnoreCase(a)) {
                w63.a("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(a)));
                sendEmptyMessageDelayed(0, com.efs.sdk.base.a.d.a.a().m);
                return;
            }
            List<j43> emptyList = Collections.emptyList();
            try {
                aVar = a.b.a;
                int i2 = this.a;
                com.efs.sdk.base.a.b.f fVar2 = this.f;
                aVar.b();
                aVar.b();
                File g = q33.g(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a);
                if (g.exists()) {
                    List<File> k = z43.k(g);
                    if (aVar.b) {
                        n73Var = n73.a.a;
                        int size = k.size();
                        if (n73Var.b != null && com.efs.sdk.base.a.d.a.a().d) {
                            o43 o43Var = new o43("efs_core", "log_lag", n73Var.a.c);
                            o43Var.a("cnt", Integer.valueOf(size));
                            n73Var.b.b(o43Var);
                        }
                        aVar.b = false;
                    }
                    Collections.sort(k, aVar.d);
                    ArrayList arrayList = new ArrayList(i2);
                    for (int size2 = k.size() - 1; size2 >= 0 && arrayList.size() < i2; size2--) {
                        File file = k.get(size2);
                        if (file.exists() && (fVar2 == null || !fVar2.a(file))) {
                            arrayList.add(file);
                        }
                    }
                    list = arrayList;
                } else {
                    list = Collections.emptyList();
                }
                ArrayList arrayList2 = new ArrayList(i2);
                for (File file2 : list) {
                    j43 a2 = aVar.a(file2);
                    if (a2 == null) {
                        w63.b("efs.cache", "file upload error, name is " + file2.getName(), null);
                    } else {
                        arrayList2.add(a2);
                    }
                }
                emptyList = arrayList2;
            } catch (Throwable unused) {
            }
            for (j43 j43Var : emptyList) {
                if (Constants.LOG_TYPE_WA.equals(j43Var.a.a) || b.b().e(j43Var.a.a, j43Var.a())) {
                    c cVar = this.b;
                    if (Constants.LOG_TYPE_WA.equals(j43Var.a.a)) {
                        cVar = this.c;
                    }
                    String uuid = UUID.randomUUID().toString();
                    this.d.add(uuid);
                    if (x53.a(new e(j43Var, cVar, uuid)) == null) {
                        b(uuid, -1);
                    }
                }
            }
            if (this.d.size() <= 0) {
                sendEmptyMessageDelayed(0, com.efs.sdk.base.a.d.a.a().m);
            }
        }
    }
}
