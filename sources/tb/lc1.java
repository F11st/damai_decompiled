package tb;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class lc1<T> {
    private final ic1<T> a;
    @Nullable
    protected T b;

    public lc1() {
        this.a = new ic1<>();
        this.b = null;
    }

    @Nullable
    public T a(ic1<T> ic1Var) {
        return this.b;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a(this.a.a(f, f2, t, t2, f3, f4, f5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
    }

    public lc1(@Nullable T t) {
        this.a = new ic1<>();
        this.b = null;
        this.b = t;
    }
}
