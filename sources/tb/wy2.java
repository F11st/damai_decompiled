package tb;

import com.taobao.monitor.impl.data.visible.VisibleCalculator;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.PageLeaveDispatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wy2 implements ApplicationBackgroundChangedDispatcher.BackgroundChangedListener, CustomPageLifecycleDispatcher.CustomPageLifecycle, PageLeaveDispatcher.PageLeaveListener {
    private final Map<pp1, Boolean> a = new HashMap();
    private final Map<pp1, Boolean> b = new HashMap();
    private final Map<pp1, Boolean> c = new HashMap();
    private final Map<pp1, VisibleCalculator> d = new HashMap();

    public wy2() {
        IDispatcher b = ca0.b(C8934b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
        if (b instanceof ApplicationBackgroundChangedDispatcher) {
            ((ApplicationBackgroundChangedDispatcher) b).addListener(this);
        }
        IDispatcher b2 = ca0.b(C8934b0.PAGE_LEAVE_DISPATCHER);
        if (b2 instanceof PageLeaveDispatcher) {
            ((PageLeaveDispatcher) b2).addListener(this);
        }
    }

    private boolean a(pp1 pp1Var) {
        Boolean bool = Boolean.TRUE;
        return (bool.equals(this.a.get(pp1Var)) && bool.equals(this.b.get(pp1Var)) && bool.equals(this.c.get(pp1Var))) ? false : true;
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher.BackgroundChangedListener
    public void onChanged(int i, long j) {
        if (i == 0) {
            this.b.clear();
            this.c.clear();
            ArrayList<pp1> arrayList = new ArrayList(this.d.keySet());
            this.d.clear();
            for (pp1 pp1Var : arrayList) {
                this.d.put(pp1Var, new VisibleCalculator(pp1Var));
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.PageLeaveDispatcher.PageLeaveListener
    public void onLeave(pp1 pp1Var, int i) {
        VisibleCalculator visibleCalculator;
        if (pp1Var == null || (visibleCalculator = this.d.get(pp1Var)) == null) {
            return;
        }
        if (i == -5) {
            visibleCalculator.errorNotify(-5);
        } else if (i == -4) {
            visibleCalculator.errorNotify(-4);
        } else if (i != -3) {
        } else {
            visibleCalculator.errorNotify(-3);
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageAppear(pp1 pp1Var) {
        this.b.put(pp1Var, Boolean.TRUE);
        VisibleCalculator visibleCalculator = this.d.get(pp1Var);
        if (visibleCalculator != null) {
            visibleCalculator.startPageCalculateExecutor(pp1Var.o());
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageCreate(pp1 pp1Var, Map<String, Object> map) {
        this.a.put(pp1Var, Boolean.TRUE);
        if (this.d.containsKey(pp1Var)) {
            return;
        }
        this.d.put(pp1Var, new VisibleCalculator(pp1Var));
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDestroy(pp1 pp1Var) {
        VisibleCalculator visibleCalculator = this.d.get(pp1Var);
        if (visibleCalculator != null) {
            if (a(pp1Var)) {
                visibleCalculator.errorNotify(-6);
            }
            visibleCalculator.stopPageCalculateExecutor();
        }
        this.a.remove(pp1Var);
        this.b.remove(pp1Var);
        this.c.remove(pp1Var);
        this.d.remove(pp1Var);
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDisappear(pp1 pp1Var) {
        this.c.put(pp1Var, Boolean.TRUE);
        VisibleCalculator visibleCalculator = this.d.get(pp1Var);
        if (visibleCalculator != null) {
            visibleCalculator.stopPageCalculateExecutor();
        }
    }
}
