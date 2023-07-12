package com.alibaba.android.bindingx.core.internal;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
abstract class AnimationFrame {

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    interface Callback {
        void doFrame();
    }

    /* compiled from: Taobao */
    @TargetApi(16)
    /* loaded from: classes5.dex */
    private static class ChoreographerAnimationFrameImpl extends AnimationFrame implements Choreographer.FrameCallback {
        private Choreographer a;
        private Callback b;
        private boolean c;

        @TargetApi(16)
        ChoreographerAnimationFrameImpl() {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.alibaba.android.bindingx.core.internal.AnimationFrame.ChoreographerAnimationFrameImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChoreographerAnimationFrameImpl.this.a = Choreographer.getInstance();
                        countDownLatch.countDown();
                    }
                });
                try {
                    if (countDownLatch.await(500L, TimeUnit.MILLISECONDS)) {
                        return;
                    }
                    this.a = Choreographer.getInstance();
                    return;
                } catch (InterruptedException unused) {
                    return;
                }
            }
            this.a = Choreographer.getInstance();
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void a() {
            Choreographer choreographer = this.a;
            if (choreographer != null) {
                choreographer.removeFrameCallback(this);
            }
            this.c = false;
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void c(@NonNull Callback callback) {
            this.b = callback;
            this.c = true;
            Choreographer choreographer = this.a;
            if (choreographer != null) {
                choreographer.postFrameCallback(this);
            }
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void d() {
            a();
            this.a = null;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            Callback callback = this.b;
            if (callback != null) {
                callback.doFrame();
            }
            Choreographer choreographer = this.a;
            if (choreographer == null || !this.c) {
                return;
            }
            choreographer.postFrameCallback(this);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static class a extends AnimationFrame implements Handler.Callback {
        private Handler a = new Handler(Looper.getMainLooper(), this);
        private Callback b;
        private boolean c;

        a() {
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void a() {
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.c = false;
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void c(@NonNull Callback callback) {
            this.b = callback;
            this.c = true;
            Handler handler = this.a;
            if (handler != null) {
                handler.sendEmptyMessage(100);
            }
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void d() {
            a();
            this.a = null;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 100 || this.a == null) {
                return false;
            }
            Callback callback = this.b;
            if (callback != null) {
                callback.doFrame();
            }
            if (this.c) {
                this.a.sendEmptyMessageDelayed(100, 16L);
                return true;
            }
            return true;
        }
    }

    AnimationFrame() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimationFrame b() {
        if (Build.VERSION.SDK_INT >= 16) {
            return new ChoreographerAnimationFrameImpl();
        }
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(@NonNull Callback callback);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();
}
