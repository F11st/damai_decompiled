package tb;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class fv2 {
    private View b;
    private Context c;
    private TextView a = null;
    private boolean d = true;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (fv2.this.a != null) {
                ViewParent parent = fv2.this.a.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(fv2.this.a);
                }
                fv2.this.a = null;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (fv2.this.a != null) {
                ViewParent parent = fv2.this.a.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(fv2.this.a);
                }
                fv2.this.a = null;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class b implements View.OnClickListener {
        final /* synthetic */ AnimatorSet a;
        final /* synthetic */ ObjectAnimator b;

        b(AnimatorSet animatorSet, ObjectAnimator objectAnimator) {
            this.a = animatorSet;
            this.b = objectAnimator;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (fv2.this.d) {
                this.a.cancel();
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(this.b);
                animatorSet.start();
                fv2.this.d = false;
            }
        }
    }

    public fv2(Context context, View view) {
        this.c = context;
        this.b = view;
    }

    @TargetApi(21)
    private void e(Drawable drawable, String str, int i) {
        TextView textView = new TextView(this.c);
        this.a = textView;
        textView.setTextColor(Color.parseColor("#666666"));
        this.a.setBackgroundColor(Color.parseColor("#ffe7b3"));
        this.a.setText(str);
        this.a.setGravity(16);
        ViewParent parent = this.a.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.a);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.a.setCompoundDrawables(drawable, null, null, null);
            int i2 = i / 10;
            this.a.setCompoundDrawablePadding(i2);
            this.a.setPadding(i2, 0, 0, 0);
        }
        try {
            this.a.setElevation(2.0f);
        } catch (Throwable unused) {
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, i);
        ViewParent parent2 = this.b.getParent();
        if (parent2 != null) {
            try {
                ((ViewGroup) parent2).addView(this.a, layoutParams);
            } catch (Exception unused2) {
                ViewParent parent3 = parent2.getParent();
                if (parent3 != null) {
                    ((ViewGroup) parent3).addView(this.a, layoutParams);
                }
            }
        }
    }

    public void f(Drawable drawable, String str, int i) {
        TextView textView = this.a;
        if (textView == null || (str != null && !str.equals(textView.getText()))) {
            e(drawable, str, i);
        }
        this.a.bringToFront();
        this.a.setTranslationY(0.0f);
        float f = -i;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "translationY", f, 0.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(1000L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a, "translationY", 0.0f, f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2).after(3000L);
        ofFloat2.addListener(new a());
        animatorSet.start();
        this.a.setOnClickListener(new b(animatorSet, ofFloat2));
    }
}
