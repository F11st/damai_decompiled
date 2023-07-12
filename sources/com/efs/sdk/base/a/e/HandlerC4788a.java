package com.efs.sdk.base.a.e;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.C4770a;
import com.efs.sdk.base.a.b.C4780g;
import com.efs.sdk.base.a.b.InterfaceC4779f;
import com.efs.sdk.base.a.d.C4786a;
import com.efs.sdk.base.a.e.C4794f;
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
/* renamed from: com.efs.sdk.base.a.e.a */
/* loaded from: classes10.dex */
public final class HandlerC4788a extends Handler {
    public int a;
    public InterfaceC4792c b;
    private InterfaceC4792c c;
    private List<String> d;
    private AtomicInteger e;
    private InterfaceC4779f f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.efs.sdk.base.a.e.a$a */
    /* loaded from: classes10.dex */
    public static class C4789a {
        private static final HandlerC4788a a = new HandlerC4788a((byte) 0);
    }

    private HandlerC4788a() {
        super(r33.a.getLooper());
        this.a = 5;
        this.d = new ArrayList();
        this.e = new AtomicInteger(0);
        this.b = new m33();
        this.c = new x63();
        this.f = new C4780g();
    }

    /* synthetic */ HandlerC4788a(byte b) {
        this();
    }

    public static HandlerC4788a a() {
        return C4789a.a;
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
        C4794f c4794f;
        v43 v43Var;
        C4770a c4770a;
        List<File> list;
        n73 n73Var;
        super.handleMessage(message);
        c4794f = C4794f.C4795a.a;
        if (c4794f.b()) {
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
                    sendEmptyMessageDelayed(0, C4786a.a().l);
                    w63.a("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    return;
                }
                return;
            }
            v43Var = v43.C9807a.a;
            String a = v43Var.a();
            if ("denied".equalsIgnoreCase(a) || "disconnected".equalsIgnoreCase(a)) {
                w63.a("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(a)));
                sendEmptyMessageDelayed(0, C4786a.a().m);
                return;
            }
            List<j43> emptyList = Collections.emptyList();
            try {
                c4770a = C4770a.C4772b.a;
                int i2 = this.a;
                InterfaceC4779f interfaceC4779f = this.f;
                c4770a.b();
                c4770a.b();
                File g = q33.g(C4786a.a().c, C4786a.a().a);
                if (g.exists()) {
                    List<File> k = z43.k(g);
                    if (c4770a.b) {
                        n73Var = n73.C9462a.a;
                        int size = k.size();
                        if (n73Var.b != null && C4786a.a().d) {
                            o43 o43Var = new o43("efs_core", "log_lag", n73Var.a.c);
                            o43Var.a("cnt", Integer.valueOf(size));
                            n73Var.b.b(o43Var);
                        }
                        c4770a.b = false;
                    }
                    Collections.sort(k, c4770a.d);
                    ArrayList arrayList = new ArrayList(i2);
                    for (int size2 = k.size() - 1; size2 >= 0 && arrayList.size() < i2; size2--) {
                        File file = k.get(size2);
                        if (file.exists() && (interfaceC4779f == null || !interfaceC4779f.a(file))) {
                            arrayList.add(file);
                        }
                    }
                    list = arrayList;
                } else {
                    list = Collections.emptyList();
                }
                ArrayList arrayList2 = new ArrayList(i2);
                for (File file2 : list) {
                    j43 a2 = c4770a.a(file2);
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
                if (Constants.LOG_TYPE_WA.equals(j43Var.a.a) || HandlerC4790b.b().e(j43Var.a.a, j43Var.a())) {
                    InterfaceC4792c interfaceC4792c = this.b;
                    if (Constants.LOG_TYPE_WA.equals(j43Var.a.a)) {
                        interfaceC4792c = this.c;
                    }
                    String uuid = UUID.randomUUID().toString();
                    this.d.add(uuid);
                    if (x53.a(new RunnableC4793e(j43Var, interfaceC4792c, uuid)) == null) {
                        b(uuid, -1);
                    }
                }
            }
            if (this.d.size() <= 0) {
                sendEmptyMessageDelayed(0, C4786a.a().m);
            }
        }
    }
}
