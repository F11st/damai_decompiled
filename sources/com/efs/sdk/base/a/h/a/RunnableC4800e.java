package com.efs.sdk.base.a.h.a;

import androidx.annotation.NonNull;
import com.efs.sdk.base.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.w63;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.h.a.e */
/* loaded from: classes10.dex */
public class RunnableC4800e<T> implements Runnable {
    private List<InterfaceC4798b<T>> a = new ArrayList(5);
    private InterfaceC4799c<T> b;

    public RunnableC4800e(@NonNull InterfaceC4799c<T> interfaceC4799c) {
        this.b = interfaceC4799c;
    }

    public final T a() {
        T t = null;
        try {
            Iterator<InterfaceC4798b<T>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            t = this.b.a();
            for (InterfaceC4798b<T> interfaceC4798b : this.a) {
                interfaceC4798b.a(this.b, t);
            }
            for (InterfaceC4798b<T> interfaceC4798b2 : this.a) {
                interfaceC4798b2.result(t);
            }
        } catch (Throwable th) {
            w63.b(Constants.TAG, "efs.util.concurrent", th);
            Iterator<InterfaceC4798b<T>> it2 = this.a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
        return t;
    }

    public final void a(@NonNull List<InterfaceC4798b<T>> list) {
        this.a.addAll(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
