package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageStageDispatcher extends AbsDispatcher<IImageStageListener> {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface IImageStageListener {
        void onImageStage(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.trace.ImageStageDispatcher$a */
    /* loaded from: classes11.dex */
    class C6795a implements AbsDispatcher.ListenerCaller<IImageStageListener> {
        final /* synthetic */ int a;

        C6795a(ImageStageDispatcher imageStageDispatcher, int i) {
            this.a = i;
        }

        @Override // com.taobao.monitor.impl.trace.AbsDispatcher.ListenerCaller
        /* renamed from: a */
        public void callListener(IImageStageListener iImageStageListener) {
            iImageStageListener.onImageStage(this.a);
        }
    }

    public void f(int i) {
        c(new C6795a(this, i));
    }
}
