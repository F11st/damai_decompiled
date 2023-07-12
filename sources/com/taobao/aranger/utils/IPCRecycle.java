package com.taobao.aranger.utils;

import android.net.Uri;
import android.os.IBinder;
import com.taobao.aranger.exception.IPCException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import tb.a11;
import tb.qh;
import tb.z01;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IPCRecycle {
    private static final String c = "IPCRecycle";
    private static volatile IPCRecycle d;
    private final ReferenceQueue<Object> a = new ReferenceQueue<>();
    private final ConcurrentHashMap<PhantomReference<Object>, String> b = new ConcurrentHashMap<>();

    private IPCRecycle() {
    }

    public static IPCRecycle b() {
        if (d == null) {
            synchronized (IPCRecycle.class) {
                if (d == null) {
                    d = new IPCRecycle();
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Object obj) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            while (true) {
                PhantomReference phantomReference = (PhantomReference) this.a.poll();
                if (phantomReference == null) {
                    break;
                }
                String remove = this.b.remove(phantomReference);
                if (remove != null) {
                    arrayList.add(remove);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        try {
            if (obj instanceof IBinder) {
                qh.a((IBinder) obj).b(arrayList);
            } else if (obj instanceof Uri) {
                qh.b((Uri) obj).e(arrayList);
            }
        } catch (IPCException e) {
            z01.c(c, "[recycle][recycleClient]", e, new Object[0]);
        }
    }

    public void d(final Object obj, Object obj2, String str) {
        this.b.put(new PhantomReference<>(obj2, this.a), str);
        a11.b(false, false, new Runnable() { // from class: com.taobao.aranger.utils.IPCRecycle.1
            @Override // java.lang.Runnable
            public void run() {
                IPCRecycle.this.c(obj);
            }
        });
    }
}
