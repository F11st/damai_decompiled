package com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import tb.f81;
import tb.lc1;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    private final KeyframesWrapper<K> c;
    @Nullable
    protected lc1<A> e;
    final List<AnimationListener> a = new ArrayList(1);
    private boolean b = false;
    protected float d = 0.0f;
    @Nullable
    private A f = null;
    private float g = -1.0f;
    private float h = -1.0f;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface AnimationListener {
        void onValueChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface KeyframesWrapper<T> {
        u71<T> getCurrentKeyframe();

        @FloatRange(from = 0.0d, to = 1.0d)
        float getEndProgress();

        @FloatRange(from = 0.0d, to = 1.0d)
        float getStartDelayProgress();

        boolean isCachedValueEnabled(float f);

        boolean isEmpty();

        boolean isValueChanged(float f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$b */
    /* loaded from: classes9.dex */
    public static final class C2844b<T> implements KeyframesWrapper<T> {
        private C2844b() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public u71<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$c */
    /* loaded from: classes9.dex */
    public static final class C2845c<T> implements KeyframesWrapper<T> {
        private final List<? extends u71<T>> a;
        private u71<T> c = null;
        private float d = -1.0f;
        @NonNull
        private u71<T> b = a(0.0f);

        C2845c(List<? extends u71<T>> list) {
            this.a = list;
        }

        private u71<T> a(float f) {
            List<? extends u71<T>> list = this.a;
            u71<T> u71Var = list.get(list.size() - 1);
            if (f >= u71Var.e()) {
                return u71Var;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                u71<T> u71Var2 = this.a.get(size);
                if (this.b != u71Var2 && u71Var2.a(f)) {
                    return u71Var2;
                }
            }
            return this.a.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        @NonNull
        public u71<T> getCurrentKeyframe() {
            return this.b;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            List<? extends u71<T>> list = this.a;
            return list.get(list.size() - 1).b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.a.get(0).e();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            u71<T> u71Var = this.c;
            u71<T> u71Var2 = this.b;
            if (u71Var == u71Var2 && this.d == f) {
                return true;
            }
            this.c = u71Var2;
            this.d = f;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f) {
            if (this.b.a(f)) {
                return !this.b.h();
            }
            this.b = a(f);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$d */
    /* loaded from: classes9.dex */
    public static final class C2846d<T> implements KeyframesWrapper<T> {
        @NonNull
        private final u71<T> a;
        private float b = -1.0f;

        C2846d(List<? extends u71<T>> list) {
            this.a = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public u71<T> getCurrentKeyframe() {
            return this.a;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getEndProgress() {
            return this.a.b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public float getStartDelayProgress() {
            return this.a.e();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isCachedValueEnabled(float f) {
            if (this.b == f) {
                return true;
            }
            this.b = f;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isEmpty() {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public boolean isValueChanged(float f) {
            return !this.a.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseKeyframeAnimation(List<? extends u71<K>> list) {
        this.c = o(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float g() {
        if (this.g == -1.0f) {
            this.g = this.c.getStartDelayProgress();
        }
        return this.g;
    }

    private static <T> KeyframesWrapper<T> o(List<? extends u71<T>> list) {
        if (list.isEmpty()) {
            return new C2844b();
        }
        if (list.size() == 1) {
            return new C2846d(list);
        }
        return new C2845c(list);
    }

    public void a(AnimationListener animationListener) {
        this.a.add(animationListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u71<K> b() {
        f81.a("BaseKeyframeAnimation#getCurrentKeyframe");
        u71<K> currentKeyframe = this.c.getCurrentKeyframe();
        f81.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return currentKeyframe;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    float c() {
        if (this.h == -1.0f) {
            this.h = this.c.getEndProgress();
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float d() {
        u71<K> b = b();
        if (b.h()) {
            return 0.0f;
        }
        return b.d.getInterpolation(e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        if (this.b) {
            return 0.0f;
        }
        u71<K> b = b();
        if (b.h()) {
            return 0.0f;
        }
        return (this.d - b.e()) / (b.b() - b.e());
    }

    public float f() {
        return this.d;
    }

    public A h() {
        A i;
        float e = e();
        if (this.e == null && this.c.isCachedValueEnabled(e)) {
            return this.f;
        }
        u71<K> b = b();
        Interpolator interpolator = b.e;
        if (interpolator != null && b.f != null) {
            i = j(b, e, interpolator.getInterpolation(e), b.f.getInterpolation(e));
        } else {
            i = i(b, d());
        }
        this.f = i;
        return i;
    }

    abstract A i(u71<K> u71Var, float f);

    protected A j(u71<K> u71Var, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).onValueChanged();
        }
    }

    public void l() {
        this.b = true;
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.c.isEmpty()) {
            return;
        }
        if (f < g()) {
            f = g();
        } else if (f > c()) {
            f = c();
        }
        if (f == this.d) {
            return;
        }
        this.d = f;
        if (this.c.isValueChanged(f)) {
            k();
        }
    }

    public void n(@Nullable lc1<A> lc1Var) {
        lc1<A> lc1Var2 = this.e;
        if (lc1Var2 != null) {
            lc1Var2.c(null);
        }
        this.e = lc1Var;
        if (lc1Var != null) {
            lc1Var.c(this);
        }
    }
}
