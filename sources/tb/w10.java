package tb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.taobao.android.dinamicx.timer.DXTimerListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class w10 {
    private boolean a = true;
    private HandlerC9841a b = new HandlerC9841a(this);
    private List<v10> c;
    private long d;

    /* compiled from: Taobao */
    /* renamed from: tb.w10$a */
    /* loaded from: classes11.dex */
    public static class HandlerC9841a extends Handler {
        private WeakReference<w10> a;
        private long b;

        HandlerC9841a(w10 w10Var) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(w10Var);
        }

        public void a(long j) {
            this.b = j;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            w10 w10Var = this.a.get();
            if (w10Var == null || w10Var.a) {
                return;
            }
            w10Var.e();
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.b) % w10Var.d;
            sendMessageDelayed(obtainMessage(1), w10Var.d - elapsedRealtime);
        }
    }

    public w10(long j) {
        this.d = j;
    }

    public final void c() {
        this.a = true;
        this.b.removeMessages(1);
    }

    public final void d() {
        List<v10> list = this.c;
        if (list != null) {
            list.clear();
        }
        c();
    }

    public final void e() {
        List<v10> list = this.c;
        if (list != null && list.size() != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (v10 v10Var : this.c) {
                int i = (int) ((elapsedRealtime - v10Var.c) / v10Var.b);
                if (i >= v10Var.d + 1) {
                    v10Var.a.onTimerCallback();
                    v10Var.d = i;
                }
            }
            return;
        }
        c();
    }

    public void f(DXTimerListener dXTimerListener, long j) {
        if (dXTimerListener == null || j <= 0) {
            return;
        }
        if (this.c == null) {
            this.c = new CopyOnWriteArrayList();
        }
        for (v10 v10Var : this.c) {
            if (v10Var.a == dXTimerListener) {
                return;
            }
        }
        v10 v10Var2 = new v10();
        v10Var2.a = dXTimerListener;
        long j2 = this.d;
        if (j <= j2) {
            j = j2;
        }
        v10Var2.b = j;
        v10Var2.c = SystemClock.elapsedRealtime();
        this.c.add(v10Var2);
        g();
    }

    public final void g() {
        if (this.a) {
            this.a = false;
            this.b.a(SystemClock.elapsedRealtime());
            HandlerC9841a handlerC9841a = this.b;
            handlerC9841a.sendMessage(handlerC9841a.obtainMessage(1));
        }
    }

    public void h(DXTimerListener dXTimerListener) {
        if (dXTimerListener == null) {
            return;
        }
        List<v10> list = this.c;
        if (list == null) {
            c();
            return;
        }
        Iterator<v10> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            v10 next = it.next();
            if (next.a == dXTimerListener) {
                this.c.remove(next);
                break;
            }
        }
        if (this.c.size() == 0) {
            c();
        }
    }
}
