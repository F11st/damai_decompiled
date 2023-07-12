package com.alibaba.android.bindingx.core.internal;

import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.internal.AnimationFrame;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
abstract class PhysicsAnimationDriver implements AnimationFrame.Callback {
    private AnimationFrame a;
    protected OnAnimationUpdateListener b;
    protected OnAnimationEndListener c;
    protected double d;
    protected double e;
    protected boolean f;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    interface OnAnimationEndListener {
        void onAnimationEnd(@NonNull PhysicsAnimationDriver physicsAnimationDriver, double d, double d2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    interface OnAnimationUpdateListener {
        void onAnimationUpdate(@NonNull PhysicsAnimationDriver physicsAnimationDriver, double d, double d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        AnimationFrame animationFrame = this.a;
        if (animationFrame != null) {
            animationFrame.a();
        }
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double c() {
        return this.e;
    }

    boolean d() {
        return this.f;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback
    public void doFrame() {
        f(AnimationUtils.currentAnimationTimeMillis());
        OnAnimationUpdateListener onAnimationUpdateListener = this.b;
        if (onAnimationUpdateListener != null) {
            onAnimationUpdateListener.onAnimationUpdate(this, this.d, this.e);
        }
        if (d()) {
            OnAnimationEndListener onAnimationEndListener = this.c;
            if (onAnimationEndListener != null) {
                onAnimationEndListener.onAnimationEnd(this, this.d, this.e);
            }
            AnimationFrame animationFrame = this.a;
            if (animationFrame != null) {
                animationFrame.a();
            }
        }
    }

    abstract void e(@NonNull Map<String, Object> map);

    abstract void f(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(OnAnimationEndListener onAnimationEndListener) {
        this.c = onAnimationEndListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(OnAnimationUpdateListener onAnimationUpdateListener) {
        this.b = onAnimationUpdateListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(@NonNull Map<String, Object> map) {
        e(map);
        if (this.a == null) {
            this.a = AnimationFrame.b();
        }
        this.a.c(this);
    }
}
