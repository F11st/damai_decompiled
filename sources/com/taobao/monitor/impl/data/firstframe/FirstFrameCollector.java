package com.taobao.monitor.impl.data.firstframe;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import tb.ho2;
import tb.pp1;

/* compiled from: Taobao */
@RequiresApi(api = 16)
/* loaded from: classes11.dex */
public class FirstFrameCollector implements ViewTreeObserver.OnDrawListener {
    private WeakReference<pp1> a;
    private boolean b = false;

    public FirstFrameCollector(pp1 pp1Var) {
        this.a = new WeakReference<>(pp1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewTreeObserver c() {
        pp1 pp1Var;
        View o;
        WeakReference<pp1> weakReference = this.a;
        if (weakReference == null || (pp1Var = weakReference.get()) == null || (o = pp1Var.o()) == null) {
            return null;
        }
        return o.getViewTreeObserver();
    }

    public void d() {
        ViewTreeObserver c = c();
        if (c != null) {
            this.b = false;
            c.addOnDrawListener(this);
        }
    }

    public void e() {
        this.b = true;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taobao.monitor.impl.data.firstframe.FirstFrameCollector.1
            @Override // java.lang.Runnable
            public void run() {
                ViewTreeObserver c = FirstFrameCollector.this.c();
                if (c != null) {
                    c.removeOnDrawListener(FirstFrameCollector.this);
                }
                FirstFrameCollector.this.a = null;
            }
        });
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        if (this.b) {
            return;
        }
        long a = ho2.a();
        e();
        pp1 pp1Var = this.a.get();
        if (pp1Var == null) {
            return;
        }
        pp1Var.y(a);
    }
}
