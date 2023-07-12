package com.taobao.monitor.procedure;

import androidx.annotation.NonNull;
import com.taobao.monitor.procedure.IPage;
import com.taobao.monitor.procedure.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c implements IPage {
    private final List<IPage> a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements IPage.PageRenderStandard {
        a() {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageInteractive(long j) {
            for (IPage iPage : c.this.a) {
                iPage.getPageRenderStandard().onPageInteractive(j);
            }
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageLoadError(int i) {
            for (IPage iPage : c.this.a) {
                iPage.getPageRenderStandard().onPageLoadError(i);
            }
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageRenderPercent(float f, long j) {
            for (IPage iPage : c.this.a) {
                iPage.getPageRenderStandard().onPageRenderPercent(f, j);
            }
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageRenderStart(long j) {
            for (IPage iPage : c.this.a) {
                iPage.getPageRenderStandard().onPageRenderStart(j);
            }
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageVisible(long j) {
            for (IPage iPage : c.this.a) {
                iPage.getPageRenderStandard().onPageVisible(j);
            }
            onPageInteractive(j);
        }
    }

    public c(@NonNull List<IPage> list) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.addAll(list);
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageBeginStandard getPageBeginStandard() {
        return new b.a();
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageDataSetter getPageDataSetter() {
        return new b.C0314b();
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageLifecycleCallback getPageLifecycleCallback() {
        return new b.c();
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageRenderStandard getPageRenderStandard() {
        return new a();
    }
}
