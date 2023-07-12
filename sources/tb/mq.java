package tb;

import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.procedure.IPage;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mq implements IPage.PageRenderStandard {
    private final pp1 a;
    private RenderDispatcher b;

    public mq(pp1 pp1Var) {
        this.a = pp1Var;
        IDispatcher a = C8934b0.a(C8934b0.PAGE_RENDER_DISPATCHER);
        if (a instanceof RenderDispatcher) {
            this.b = (RenderDispatcher) a;
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageInteractive(long j) {
        if (ca0.c(this.b)) {
            return;
        }
        this.b.f(this.a, j);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageLoadError(int i) {
        if (ca0.c(this.b)) {
            return;
        }
        this.b.g(this.a, i);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageRenderPercent(float f, long j) {
        if (ca0.c(this.b)) {
            return;
        }
        this.b.h(this.a, f, j);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageRenderStart(long j) {
        if (ca0.c(this.b)) {
            return;
        }
        this.b.i(this.a, j);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageVisible(long j) {
        if (ca0.c(this.b)) {
            return;
        }
        this.b.j(this.a, j);
    }
}
