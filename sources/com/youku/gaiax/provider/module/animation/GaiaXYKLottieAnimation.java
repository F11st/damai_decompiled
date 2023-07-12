package com.youku.gaiax.provider.module.animation;

import android.animation.Animator;
import android.view.View;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.C2861b;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.mr0;
import tb.os0;
import tb.qr0;
import tb.tq0;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J8\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J8\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¨\u0006\u0019"}, d2 = {"Lcom/youku/gaiax/provider/module/animation/GaiaXYKLottieAnimation;", "Ltb/mr0;", "", "value", "localAppendJson", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "Ltb/wt2;", "localInitLottieLocalResourceDir", "Ltb/os0;", "gxTemplateContext", "Ltb/qr0;", "gxNode", "Lcom/alibaba/fastjson/JSONObject;", "gxAnimationExpression", "gxAnimationValue", "localUri", "", "loopCount", "localPlay", "remoteUri", "remotePlay", "playAnimation", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXYKLottieAnimation extends mr0 {
    private final String localAppendJson(String str) {
        boolean p;
        if (str != null) {
            p = C8604o.p(str, ".json", false, 2, null);
            return !p ? b41.r(str, ".json") : str;
        }
        return str;
    }

    private final void localInitLottieLocalResourceDir(String str, LottieAnimationView lottieAnimationView) {
        int Z;
        Z = StringsKt__StringsKt.Z(str, "/", 0, false, 6, null);
        if (Z > 0) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(0, Z);
            b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (substring.length() > 0) {
                lottieAnimationView.setImageAssetsFolder(b41.r(substring, "/images/"));
            }
        }
    }

    private final void localPlay(final os0 os0Var, final qr0 qr0Var, JSONObject jSONObject, final JSONObject jSONObject2, String str, int i) {
        View j = qr0Var.j();
        final LottieAnimationView lottieAnimationView = j instanceof LottieAnimationView ? (LottieAnimationView) j : null;
        if ((lottieAnimationView != null && lottieAnimationView.isAnimating()) || qr0Var.s() || lottieAnimationView == null) {
            return;
        }
        localInitLottieLocalResourceDir(str, lottieAnimationView);
        lottieAnimationView.removeAllAnimatorListeners();
        lottieAnimationView.removeAllUpdateListeners();
        lottieAnimationView.removeAllLottieOnCompositionLoadedListener();
        lottieAnimationView.setAnimation(localAppendJson(str));
        lottieAnimationView.setRepeatCount(i);
        lottieAnimationView.addAnimatorListener(new tq0() { // from class: com.youku.gaiax.provider.module.animation.GaiaXYKLottieAnimation$localPlay$1
            @Override // tb.tq0, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animator) {
                GXTemplateEngine.GXIEventListener c;
                qr0.this.N(false);
                lottieAnimationView.removeAllAnimatorListeners();
                lottieAnimationView.removeAllUpdateListeners();
                lottieAnimationView.removeAllLottieOnCompositionLoadedListener();
                lottieAnimationView.setProgress(1.0f);
                GXTemplateEngine.C3346h p = os0Var.p();
                if (p == null || (c = p.c()) == null) {
                    return;
                }
                GXTemplateEngine.C3338b c3338b = new GXTemplateEngine.C3338b();
                qr0 qr0Var2 = qr0.this;
                LottieAnimationView lottieAnimationView2 = lottieAnimationView;
                JSONObject jSONObject3 = jSONObject2;
                c3338b.h(GXTemplateEngine.C3338b.STATE_END);
                c3338b.g(qr0Var2.g());
                c3338b.i(lottieAnimationView2);
                c3338b.e(jSONObject3);
                wt2 wt2Var = wt2.INSTANCE;
                c.onAnimationEvent(c3338b);
            }

            @Override // tb.tq0, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator animator) {
                GXTemplateEngine.GXIEventListener c;
                GXTemplateEngine.C3346h p = os0Var.p();
                if (p == null || (c = p.c()) == null) {
                    return;
                }
                GXTemplateEngine.C3338b c3338b = new GXTemplateEngine.C3338b();
                qr0 qr0Var2 = qr0.this;
                LottieAnimationView lottieAnimationView2 = lottieAnimationView;
                JSONObject jSONObject3 = jSONObject2;
                c3338b.h(GXTemplateEngine.C3338b.STATE_START);
                c3338b.g(qr0Var2.g());
                c3338b.i(lottieAnimationView2);
                c3338b.e(jSONObject3);
                wt2 wt2Var = wt2.INSTANCE;
                c.onAnimationEvent(c3338b);
            }
        });
        lottieAnimationView.setClickable(false);
        lottieAnimationView.playAnimation();
    }

    private final void remotePlay(final os0 os0Var, final qr0 qr0Var, final JSONObject jSONObject, final JSONObject jSONObject2, String str, final int i) {
        View j = qr0Var.j();
        final LottieAnimationView lottieAnimationView = j instanceof LottieAnimationView ? (LottieAnimationView) j : null;
        boolean z = false;
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            z = true;
        }
        if (z || qr0Var.s() || lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.removeAllAnimatorListeners();
        lottieAnimationView.removeAllUpdateListeners();
        lottieAnimationView.removeAllLottieOnCompositionLoadedListener();
        qr0Var.N(true);
        final LottieTask<C2821a> s = C2861b.s(lottieAnimationView.getContext(), str);
        s.f(new LottieListener<C2821a>() { // from class: com.youku.gaiax.provider.module.animation.GaiaXYKLottieAnimation$remotePlay$1
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(@Nullable C2821a c2821a) {
                s.k(this);
                qr0Var.N(c2821a != null);
                if (c2821a == null) {
                    return;
                }
                final LottieAnimationView lottieAnimationView2 = lottieAnimationView;
                int i2 = i;
                final qr0 qr0Var2 = qr0Var;
                final os0 os0Var2 = os0Var;
                final JSONObject jSONObject3 = jSONObject2;
                final JSONObject jSONObject4 = jSONObject;
                lottieAnimationView2.setComposition(c2821a);
                lottieAnimationView2.setRepeatCount(i2);
                lottieAnimationView2.addAnimatorListener(new tq0() { // from class: com.youku.gaiax.provider.module.animation.GaiaXYKLottieAnimation$remotePlay$1$onResult$1$1
                    @Override // tb.tq0, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(@Nullable Animator animator) {
                        GXTemplateEngine.GXIEventListener c;
                        qr0.this.N(false);
                        lottieAnimationView2.removeAllAnimatorListeners();
                        lottieAnimationView2.removeAllUpdateListeners();
                        lottieAnimationView2.removeAllLottieOnCompositionLoadedListener();
                        lottieAnimationView2.setProgress(1.0f);
                        GXTemplateEngine.C3346h p = os0Var2.p();
                        if (p == null || (c = p.c()) == null) {
                            return;
                        }
                        GXTemplateEngine.C3338b c3338b = new GXTemplateEngine.C3338b();
                        qr0 qr0Var3 = qr0.this;
                        LottieAnimationView lottieAnimationView3 = lottieAnimationView2;
                        JSONObject jSONObject5 = jSONObject3;
                        JSONObject jSONObject6 = jSONObject4;
                        c3338b.h(GXTemplateEngine.C3338b.STATE_END);
                        c3338b.g(qr0Var3.g());
                        c3338b.i(lottieAnimationView3);
                        c3338b.e(jSONObject5);
                        c3338b.f(jSONObject6);
                        wt2 wt2Var = wt2.INSTANCE;
                        c.onAnimationEvent(c3338b);
                    }

                    @Override // tb.tq0, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(@Nullable Animator animator) {
                        GXTemplateEngine.GXIEventListener c;
                        qr0.this.N(true);
                        GXTemplateEngine.C3346h p = os0Var2.p();
                        if (p == null || (c = p.c()) == null) {
                            return;
                        }
                        GXTemplateEngine.C3338b c3338b = new GXTemplateEngine.C3338b();
                        qr0 qr0Var3 = qr0.this;
                        LottieAnimationView lottieAnimationView3 = lottieAnimationView2;
                        JSONObject jSONObject5 = jSONObject3;
                        JSONObject jSONObject6 = jSONObject4;
                        c3338b.h(GXTemplateEngine.C3338b.STATE_START);
                        c3338b.g(qr0Var3.g());
                        c3338b.i(lottieAnimationView3);
                        c3338b.e(jSONObject5);
                        c3338b.f(jSONObject6);
                        wt2 wt2Var = wt2.INSTANCE;
                        c.onAnimationEvent(c3338b);
                    }
                });
                lottieAnimationView2.setClickable(false);
                lottieAnimationView2.playAnimation();
            }
        });
    }

    @Override // tb.mr0
    public void playAnimation(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONObject jSONObject, @NotNull JSONObject jSONObject2) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(jSONObject, "gxAnimationExpression");
        b41.i(jSONObject2, "gxAnimationValue");
        String gxRemoteUri = getGxRemoteUri();
        if (gxRemoteUri == null) {
            String gxLocalUri = getGxLocalUri();
            if (gxLocalUri == null) {
                return;
            }
            localPlay(os0Var, qr0Var, jSONObject, jSONObject2, gxLocalUri, getLoopCount());
            return;
        }
        remotePlay(os0Var, qr0Var, jSONObject, jSONObject2, gxRemoteUri, getLoopCount());
    }
}
