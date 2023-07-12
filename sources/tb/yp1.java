package tb;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.PageLeaveDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yp1 implements ApplicationBackgroundChangedDispatcher.BackgroundChangedListener, CustomPageLifecycleDispatcher.CustomPageLifecycle, WindowEventDispatcher.OnEventListener {
    private final List<pp1> a = new ArrayList();
    private PageLeaveDispatcher b;

    public yp1() {
        IDispatcher b = ca0.b(b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
        if (b instanceof ApplicationBackgroundChangedDispatcher) {
            ((ApplicationBackgroundChangedDispatcher) b).addListener(this);
        }
        IDispatcher b2 = ca0.b(b0.WINDOW_EVENT_DISPATCHER);
        if (b2 instanceof WindowEventDispatcher) {
            ((WindowEventDispatcher) b2).addListener(this);
        }
        IDispatcher b3 = ca0.b(b0.PAGE_LEAVE_DISPATCHER);
        if (b3 instanceof PageLeaveDispatcher) {
            this.b = (PageLeaveDispatcher) b3;
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher.BackgroundChangedListener
    public void onChanged(int i, long j) {
        if (i == 1) {
            for (pp1 pp1Var : this.a) {
                this.b.f(pp1Var, -3);
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j) {
        for (pp1 pp1Var : this.a) {
            if (!sy2.a(activity, pp1Var.o())) {
                return;
            }
            if (sy2.a(activity, pp1Var.o())) {
                int action = keyEvent.getAction();
                int keyCode = keyEvent.getKeyCode();
                if (action == 0 && keyCode == 4) {
                    this.b.f(pp1Var, -4);
                }
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageAppear(pp1 pp1Var) {
        if (this.a.contains(pp1Var)) {
            return;
        }
        this.a.add(pp1Var);
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageCreate(pp1 pp1Var, Map<String, Object> map) {
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDestroy(pp1 pp1Var) {
        this.a.remove(pp1Var);
        if (ca0.c(this.b)) {
            return;
        }
        this.b.f(pp1Var, -4);
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDisappear(pp1 pp1Var) {
        if (pp1Var.u() || ca0.c(this.b)) {
            return;
        }
        this.b.f(pp1Var, -5);
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j) {
    }
}
