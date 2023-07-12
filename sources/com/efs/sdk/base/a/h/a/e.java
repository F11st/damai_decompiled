package com.efs.sdk.base.a.h.a;

import androidx.annotation.NonNull;
import com.efs.sdk.base.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.w63;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class e<T> implements Runnable {
    private List<b<T>> a = new ArrayList(5);
    private c<T> b;

    public e(@NonNull c<T> cVar) {
        this.b = cVar;
    }

    public final T a() {
        T t = null;
        try {
            Iterator<b<T>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            t = this.b.a();
            for (b<T> bVar : this.a) {
                bVar.a(this.b, t);
            }
            for (b<T> bVar2 : this.a) {
                bVar2.result(t);
            }
        } catch (Throwable th) {
            w63.b(Constants.TAG, "efs.util.concurrent", th);
            Iterator<b<T>> it2 = this.a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
        return t;
    }

    public final void a(@NonNull List<b<T>> list) {
        this.a.addAll(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
