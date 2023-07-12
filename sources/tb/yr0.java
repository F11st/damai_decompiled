package tb;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.aliweex.adapter.module.audio.IWXAudio;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.animation.GXIPropAnimation;
import com.alibaba.gaiax.template.animation.GXPropAnimationSet;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class yr0 implements GXIPropAnimation {
    @NotNull
    public static final C9998a Companion = new C9998a(null);
    @Nullable
    private static ArgbEvaluator h;
    @NotNull
    private final GXPropAnimationSet.GXPropName a;
    @NotNull
    private final GXPropAnimationSet.AbstractC3408b b;
    private int c;
    @NotNull
    private GXPropAnimationSet.GXPropInterpolator d;
    private int e;
    @NotNull
    private GXPropAnimationSet.GXPropLoopMode f;
    private long g;

    /* compiled from: Taobao */
    /* renamed from: tb.yr0$a */
    /* loaded from: classes6.dex */
    public static final class C9998a {
        private C9998a() {
        }

        public /* synthetic */ C9998a(k50 k50Var) {
            this();
        }

        @Nullable
        public final yr0 a(@NotNull JSONObject jSONObject) {
            b41.i(jSONObject, "data");
            GXPropAnimationSet.GXPropName a = GXPropAnimationSet.GXPropName.Companion.a(jSONObject.getString("propName"));
            GXPropAnimationSet.AbstractC3408b a2 = GXPropAnimationSet.AbstractC3408b.Companion.a(jSONObject);
            if (a == null || a2 == null) {
                return null;
            }
            yr0 yr0Var = new yr0(a, a2);
            String string = jSONObject.getString("duration");
            if (string != null) {
                yr0Var.d(Integer.parseInt(string));
            }
            String string2 = jSONObject.getString("interpolator");
            if (string2 != null) {
                yr0Var.e(GXPropAnimationSet.GXPropInterpolator.Companion.a(string2));
            }
            String string3 = jSONObject.getString(GXPropAnimationSet.GXPropLoopMode.KEY_LOOP_MODE);
            if (string3 != null) {
                yr0Var.g(GXPropAnimationSet.GXPropLoopMode.Companion.a(string3));
            }
            if (jSONObject.containsKey(IWXAudio.KEY_LOOP) && jSONObject.getBooleanValue(IWXAudio.KEY_LOOP)) {
                yr0Var.f(Integer.MAX_VALUE);
            } else if (jSONObject.containsKey("loopCount")) {
                if (yr0Var.a() == GXPropAnimationSet.GXPropLoopMode.REVERSE) {
                    yr0Var.f(Math.max(1, (jSONObject.getIntValue("loopCount") * 2) - 1));
                } else {
                    yr0Var.f(Math.max(0, jSONObject.getIntValue("loopCount") - 1));
                }
            }
            if (jSONObject.containsKey("delay")) {
                yr0Var.c(jSONObject.getLongValue("delay"));
            }
            return yr0Var;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yr0$b */
    /* loaded from: classes6.dex */
    static final class C9999b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View b;

        C9999b(View view) {
            this.b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                GXPropAnimationSet.GXPropName b = yr0.this.b();
                View view = this.b;
                Object animatedValue = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                b.setValue(view, ((Float) animatedValue).floatValue());
            } else if (valueAnimator.getAnimatedValue() instanceof Integer) {
                GXPropAnimationSet.GXPropName b2 = yr0.this.b();
                View view2 = this.b;
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Int");
                b2.setColorValue(view2, ((Integer) animatedValue2).intValue());
            }
        }
    }

    public yr0(@NotNull GXPropAnimationSet.GXPropName gXPropName, @NotNull GXPropAnimationSet.AbstractC3408b abstractC3408b) {
        b41.i(gXPropName, "name");
        b41.i(abstractC3408b, "value");
        this.a = gXPropName;
        this.b = abstractC3408b;
        this.c = 300;
        this.d = GXPropAnimationSet.GXPropInterpolator.STANDARD;
        this.f = GXPropAnimationSet.GXPropLoopMode.RESET;
    }

    @NotNull
    public final GXPropAnimationSet.GXPropLoopMode a() {
        return this.f;
    }

    @NotNull
    public final GXPropAnimationSet.GXPropName b() {
        return this.a;
    }

    public final void c(long j) {
        this.g = j;
    }

    @Override // com.alibaba.gaiax.template.animation.GXIPropAnimation
    @NotNull
    public Animator createAnimator(@NotNull View view) {
        b41.i(view, "targetView");
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setRepeatCount(this.e);
        valueAnimator.setRepeatMode(this.f == GXPropAnimationSet.GXPropLoopMode.RESET ? 1 : 2);
        valueAnimator.setDuration(this.c);
        valueAnimator.setInterpolator(this.d.value());
        GXPropAnimationSet.AbstractC3408b abstractC3408b = this.b;
        if (abstractC3408b instanceof GXPropAnimationSet.AbstractC3408b.C3413c) {
            valueAnimator.setFloatValues(((GXPropAnimationSet.AbstractC3408b.C3413c) abstractC3408b).a(), ((GXPropAnimationSet.AbstractC3408b.C3413c) this.b).b());
        } else if (abstractC3408b instanceof GXPropAnimationSet.AbstractC3408b.C3411b) {
            if (h == null) {
                h = new ArgbEvaluator();
            }
            valueAnimator.setEvaluator(h);
            valueAnimator.setIntValues(mq0.d(((GXPropAnimationSet.AbstractC3408b.C3411b) this.b).a(), null, 1, null), mq0.d(((GXPropAnimationSet.AbstractC3408b.C3411b) this.b).b(), null, 1, null));
        }
        valueAnimator.addUpdateListener(new C9999b(view));
        valueAnimator.setStartDelay(this.g);
        return valueAnimator;
    }

    public final void d(int i) {
        this.c = i;
    }

    public final void e(@NotNull GXPropAnimationSet.GXPropInterpolator gXPropInterpolator) {
        b41.i(gXPropInterpolator, "<set-?>");
        this.d = gXPropInterpolator;
    }

    public final void f(int i) {
        this.e = i;
    }

    public final void g(@NotNull GXPropAnimationSet.GXPropLoopMode gXPropLoopMode) {
        b41.i(gXPropLoopMode, "<set-?>");
        this.f = gXPropLoopMode;
    }
}
