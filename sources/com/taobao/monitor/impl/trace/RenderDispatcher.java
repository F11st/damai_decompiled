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
    /* renamed from: com.taobao.monitor.impl.trace.RenderDispatcher$a */
    /* loaded from: classes11.dex */
    class C6798a implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ long b;

        C6798a(RenderDispatcher renderDispatcher, pp1 pp1Var, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.RenderDispatcher$b */
    /* loaded from: classes11.dex */
    class C6799b implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ float b;
        final /* synthetic */ long c;

        C6799b(RenderDispatcher renderDispatcher, pp1 pp1Var, float f, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.RenderDispatcher$c */
    /* loaded from: classes11.dex */
    class C6800c implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ long b;

        C6800c(RenderDispatcher renderDispatcher, pp1 pp1Var, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.RenderDispatcher$d */
    /* loaded from: classes11.dex */
    class C6801d implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ long b;

        C6801d(RenderDispatcher renderDispatcher, pp1 pp1Var, long j) {
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
    /* renamed from: com.taobao.monitor.impl.trace.RenderDispatcher$e */
    /* loaded from: classes11.dex */
    class C6802e implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ pp1 a;
        final /* synthetic */ int b;

        C6802e(RenderDispatcher renderDispatcher, pp1 pp1Var, int i) {
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
        c(new C6801d(this, pp1Var, j));
    }

    @UnsafeMethod
    public void g(pp1 pp1Var, int i) {
        c(new C6802e(this, pp1Var, i));
    }

    @UnsafeMethod
    public void h(pp1 pp1Var, float f, long j) {
        c(new C6799b(this, pp1Var, f, j));
    }

    @UnsafeMethod
    public void i(pp1 pp1Var, long j) {
        c(new C6798a(this, pp1Var, j));
    }

    @UnsafeMethod
    public void j(pp1 pp1Var, long j) {
        c(new C6800c(this, pp1Var, j));
    }
}
