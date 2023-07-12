package tb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation;

/* compiled from: Taobao */
/* renamed from: tb.u */
/* loaded from: classes8.dex */
public class C9749u implements IAKGestureAnimation {
    private int a;
    private int b;
    @Nullable
    private Animator c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.u$a */
    /* loaded from: classes8.dex */
    public class C9750a extends AnimatorListenerAdapter {
        final /* synthetic */ ObjectAnimator a;
        final /* synthetic */ Runnable b;

        C9750a(ObjectAnimator objectAnimator, Runnable runnable) {
            this.a = objectAnimator;
            this.b = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (C9749u.this.c == this.a) {
                C9749u.this.c();
            }
            this.b.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.c = null;
    }

    private void d(@NonNull View view, float f, float f2, @NonNull Runnable runnable) {
        cancelAnimator();
        float translationY = view.getTranslationY();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", translationY, f2);
        ofFloat.setDuration(Math.min(300L, Math.max(50L, (Math.abs(translationY - f2) / Math.min(8000.0f, Math.max(200.0f, f))) * 1000.0f)));
        ofFloat.addListener(new C9750a(ofFloat, runnable));
        ofFloat.setInterpolator(new LinearInterpolator());
        this.c = ofFloat;
        ofFloat.start();
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public void cancelAnimator() {
        if (this.c != null && isAnimating()) {
            this.c.cancel();
        }
        c();
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public void close(@NonNull View view, float f, @NonNull Runnable runnable) {
        d(view, f, this.a, runnable);
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public void collapse(@NonNull View view, float f, @NonNull Runnable runnable) {
        d(view, f, 0.0f, runnable);
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public void expand(@NonNull View view, float f, @NonNull Runnable runnable) {
        d(view, f, this.a - this.b, runnable);
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public boolean isAnimating() {
        Animator animator = this.c;
        return animator != null && animator.isStarted();
    }

    @Override // com.taobao.android.abilitykit.ability.pop.render.util.IAKGestureAnimation
    public void updateLimitSize(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
