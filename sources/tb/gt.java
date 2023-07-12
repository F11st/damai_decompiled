package tb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gt {
    @NonNull
    private List<AnimatorSet> a;
    @Nullable
    private AnimatorSet b;
    private boolean c;
    private boolean d;
    private int e = -1;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            gt.this.b();
        }
    }

    public gt(@NonNull List<AnimatorSet> list) {
        this.a = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!this.d && this.e < this.a.size() - 1) {
            List<AnimatorSet> list = this.a;
            int i = this.e + 1;
            this.e = i;
            AnimatorSet animatorSet = list.get(i);
            this.b = animatorSet;
            if (animatorSet != null) {
                animatorSet.start();
            }
        }
    }

    public void c() {
        if (this.c) {
            return;
        }
        this.c = true;
        for (AnimatorSet animatorSet : this.a) {
            animatorSet.addListener(new a());
        }
        b();
    }

    public void d() {
        AnimatorSet animatorSet;
        this.d = true;
        if (this.c && (animatorSet = this.b) != null) {
            animatorSet.end();
        }
    }
}
