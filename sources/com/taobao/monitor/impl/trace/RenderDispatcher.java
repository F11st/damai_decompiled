package com.taobao.monitor.impl.trace;

import com.taobao.monitor.annotation.UnsafeMethod;
import com.taobao.monitor.impl.trace.AbsDispatcher;
import tb.pp1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RenderDispatcher extends AbsDispatcher<PageRenderStandard> {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface PageRenderStandard {
        void onPageInteractive(pp1 pp1Var, long j);

        void onPageLoadError(pp1 pp1Var, int i);

        void onPageRenderPercent(pp1 pp1Var, float f, long j);

        void onPageRenderStart(pp1 pp1Var, long j);

        void onPageVisible(pp1 pp1Var, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ long b;

        a(RenderDispatcher renderDispatcher, pp1 pp1Var, long j) {
            this.a = pp1Var;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(PageRenderStandard pageRenderStandard) {
            pageRenderStandard.onPageRenderStart(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class b implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ float b;
        final /* synthetic */ long c;

        b(RenderDispatcher renderDispatcher, pp1 pp1Var, float f, long j) {
            this.a = pp1Var;
            this.b = f;
            this.c = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(PageRenderStandard pageRenderStandard) {
            pageRenderStandard.onPageRenderPercent(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class c implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ long b;

        c(RenderDispatcher renderDispatcher, pp1 pp1Var, long j) {
            this.a = pp1Var;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(PageRenderStandard pageRenderStandard) {
            pageRenderStandard.onPageVisible(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class d implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ long b;

        d(RenderDispatcher renderDispatcher, pp1 pp1Var, long j) {
            this.a = pp1Var;
            this.b = j;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(PageRenderStandard pageRenderStandard) {
            pageRenderStandard.onPageInteractive(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class e implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ int b;

        e(RenderDispatcher renderDispatcher, pp1 pp1Var, int i) {
            this.a = pp1Var;
            this.b = i;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(PageRenderStandard pageRenderStandard) {
            pageRenderStandard.onPageLoadError(this.a, this.b);
        }
    }

    @UnsafeMethod
    public void f(pp1 pp1Var, long j) {
        c(new d(this, pp1Var, j));
    }

    @UnsafeMethod
    public void g(pp1 pp1Var, int i) {
        c(new e(this, pp1Var, i));
    }

    @UnsafeMethod
    public void h(pp1 pp1Var, float f, long j) {
        c(new b(this, pp1Var, f, j));
    }

    @UnsafeMethod
    public void i(pp1 pp1Var, long j) {
        c(new a(this, pp1Var, j));
    }

    @UnsafeMethod
    public void j(pp1 pp1Var, long j) {
        c(new c(this, pp1Var, j));
    }
}
