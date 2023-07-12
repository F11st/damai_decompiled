package com.taobao.monitor.procedure;

import androidx.annotation.NonNull;
import com.taobao.monitor.procedure.IPage;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.taobao.monitor.procedure.b */
/* loaded from: classes11.dex */
public class C6810b implements IPage {
    private static final C6813c a = new C6813c();
    private static final C6811a b = new C6811a();
    private static final C6814d c = new C6814d();
    private static final C6812b d = new C6812b();

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.procedure.b$a */
    /* loaded from: classes11.dex */
    public static class C6811a implements IPage.PageBeginStandard {
        @Override // com.taobao.monitor.procedure.IPage.PageBeginStandard
        public void onPageClickTime(long j) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageBeginStandard
        public void onPageNavStartTime(long j) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.procedure.b$b */
    /* loaded from: classes11.dex */
    public static class C6812b implements IPage.PageDataSetter {
        @Override // com.taobao.monitor.procedure.IPage.PageDataSetter
        public void addProperty(String str, Object obj) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageDataSetter
        public void onEvent(String str, Object obj) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageDataSetter
        public void onStage(String str, long j) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.procedure.b$c */
    /* loaded from: classes11.dex */
    public static class C6813c implements IPage.PageLifecycleCallback {
        @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
        public void onPageAppear() {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
        public void onPageCreate(String str, String str2, Map<String, Object> map) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
        public void onPageDestroy() {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
        public void onPageDisappear() {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.procedure.b$d */
    /* loaded from: classes11.dex */
    public static class C6814d implements IPage.PageRenderStandard {
        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageInteractive(long j) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageLoadError(int i) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageRenderPercent(float f, long j) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageRenderStart(long j) {
        }

        @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
        public void onPageVisible(long j) {
        }
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageBeginStandard getPageBeginStandard() {
        return b;
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageDataSetter getPageDataSetter() {
        return d;
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageLifecycleCallback getPageLifecycleCallback() {
        return a;
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageRenderStandard getPageRenderStandard() {
        return c;
    }
}
