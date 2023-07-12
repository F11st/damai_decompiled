package com.taobao.monitor.procedure;

import androidx.annotation.NonNull;
import com.taobao.monitor.procedure.C6810b;
import com.taobao.monitor.procedure.IPage;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.taobao.monitor.procedure.c */
/* loaded from: classes11.dex */
public class C6815c implements IPage {
    private final List<IPage> a;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.procedure.c$a */
    /* loaded from: classes11.dex */
    class C6816a implements IPage.PageRenderStandard {
        C6816a() {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageInteractive(long j) {
            for (IPage iPage : C6815c.this.a) {
                iPage.getPageRenderStandard().onPageInteractive(j);
            }
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageLoadError(int i) {
            for (IPage iPage : C6815c.this.a) {
                iPage.getPageRenderStandard().onPageLoadError(i);
            }
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageRenderPercent(float f, long j) {
            for (IPage iPage : C6815c.this.a) {
                iPage.getPageRenderStandard().onPageRenderPercent(f, j);
            }
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageRenderStart(long j) {
            for (IPage iPage : C6815c.this.a) {
                iPage.getPageRenderStandard().onPageRenderStart(j);
            }
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageVisible(long j) {
            for (IPage iPage : C6815c.this.a) {
                iPage.getPageRenderStandard().onPageVisible(j);
            }
            onPageInteractive(j);
        }
    }

    public C6815c(@NonNull List<IPage> list) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.addAll(list);
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageBeginStandard getPageBeginStandard() {
        return new C6810b.C6811a();
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageDataSetter getPageDataSetter() {
        return new C6810b.C6812b();
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageLifecycleCallback getPageLifecycleCallback() {
        return new C6810b.C6813c();
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageRenderStandard getPageRenderStandard() {
        return new C6816a();
    }
}
