package tb;

import android.os.Build;
import com.taobao.monitor.impl.data.firstframe.FirstFrameCollector;
import com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.procedure.IPage;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class lq implements IPage.PageLifecycleCallback {
    private final pp1 a;
    private CustomPageLifecycleDispatcher b;

    public lq(pp1 pp1Var) {
        this.a = pp1Var;
        IDispatcher a = C8934b0.a(C8934b0.CUSTOM_PAGE_LIFECYCLE_DISPATCHER);
        if (a instanceof CustomPageLifecycleDispatcher) {
            this.b = (CustomPageLifecycleDispatcher) a;
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageAppear() {
        if (jd0.D && Build.VERSION.SDK_INT >= 16) {
            new FirstFrameCollector(this.a).d();
        }
        if (ca0.c(this.b)) {
            return;
        }
        this.b.f(this.a);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageCreate(String str, String str2, Map<String, Object> map) {
        lu0.q.b(this.a.h());
        if (ca0.c(this.b)) {
            return;
        }
        this.a.J(str);
        this.a.M(str2);
        this.b.g(this.a, map);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageDestroy() {
        if (ca0.c(this.b)) {
            return;
        }
        this.b.h(this.a);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageDisappear() {
        if (ca0.c(this.b)) {
            return;
        }
        this.b.i(this.a);
    }
}
