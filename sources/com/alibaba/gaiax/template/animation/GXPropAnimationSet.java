package com.alibaba.gaiax.template.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hs0;
import tb.k50;
import tb.mq0;
import tb.os0;
import tb.qr0;
import tb.tq0;
import tb.wt2;
import tb.yr0;
import tb.zp0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class GXPropAnimationSet implements GXIPropAnimation {
    @NotNull
    public static final C3407a Companion = new C3407a(null);
    @NotNull
    private GXPropOrderingType a = GXPropOrderingType.TOGETHER;
    @NotNull
    private final List<GXIPropAnimation> b = new ArrayList();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropInterpolator;", "", "Landroid/view/animation/Interpolator;", "value", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", GXPropInterpolator.KEY_LINEAR, GXPropInterpolator.KEY_ACCELERATE, GXPropInterpolator.KEY_DECELERATE, "STANDARD", GXPropInterpolator.KEY_ANTICIPATE, GXPropInterpolator.KEY_OVERSHOOT, GXPropInterpolator.KEY_SPRING, GXPropInterpolator.KEY_BOUNCE, GXPropInterpolator.KEY_COSINE, "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public enum GXPropInterpolator {
        LINEAR,
        ACCELERATE,
        DECELERATE,
        STANDARD,
        ANTICIPATE,
        OVERSHOOT,
        SPRING,
        BOUNCE,
        COSINE;
        
        @NotNull
        public static final C3401a Companion = new C3401a(null);
        @NotNull
        private static final String KEY_ACCELERATE = "ACCELERATE";
        @NotNull
        private static final String KEY_ANTICIPATE = "ANTICIPATE";
        @NotNull
        private static final String KEY_BOUNCE = "BOUNCE";
        @NotNull
        private static final String KEY_COSINE = "COSINE";
        @NotNull
        private static final String KEY_DECELERATE = "DECELERATE";
        @NotNull
        private static final String KEY_LINEAR = "LINEAR";
        @NotNull
        private static final String KEY_OVERSHOOT = "OVERSHOOT";
        @NotNull
        private static final String KEY_SPRING = "SPRING";
        @NotNull
        private static final String KEY_STANDARD = "STANDARD";

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$GXPropInterpolator$a */
        /* loaded from: classes6.dex */
        public static final class C3401a {
            private C3401a() {
            }

            public /* synthetic */ C3401a(k50 k50Var) {
                this();
            }

            @NotNull
            public final GXPropInterpolator a(@NotNull String str) {
                boolean q;
                boolean q2;
                boolean q3;
                boolean q4;
                boolean q5;
                boolean q6;
                boolean q7;
                boolean q8;
                boolean q9;
                b41.i(str, "value");
                q = C8604o.q(str, GXPropInterpolator.KEY_LINEAR, true);
                if (q) {
                    return GXPropInterpolator.LINEAR;
                }
                q2 = C8604o.q(str, GXPropInterpolator.KEY_ACCELERATE, true);
                if (q2) {
                    return GXPropInterpolator.ACCELERATE;
                }
                q3 = C8604o.q(str, GXPropInterpolator.KEY_DECELERATE, true);
                if (q3) {
                    return GXPropInterpolator.DECELERATE;
                }
                q4 = C8604o.q(str, "STANDARD", true);
                if (q4) {
                    return GXPropInterpolator.STANDARD;
                }
                q5 = C8604o.q(str, GXPropInterpolator.KEY_ANTICIPATE, true);
                if (q5) {
                    return GXPropInterpolator.ANTICIPATE;
                }
                q6 = C8604o.q(str, GXPropInterpolator.KEY_OVERSHOOT, true);
                if (q6) {
                    return GXPropInterpolator.OVERSHOOT;
                }
                q7 = C8604o.q(str, GXPropInterpolator.KEY_SPRING, true);
                if (q7) {
                    return GXPropInterpolator.SPRING;
                }
                q8 = C8604o.q(str, GXPropInterpolator.KEY_BOUNCE, true);
                if (q8) {
                    return GXPropInterpolator.BOUNCE;
                }
                q9 = C8604o.q(str, GXPropInterpolator.KEY_COSINE, true);
                return q9 ? GXPropInterpolator.COSINE : GXPropInterpolator.STANDARD;
            }
        }

        @NotNull
        public final Interpolator value() {
            return new LinearInterpolator();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropLoopMode;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "RESET", "REVERSE", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public enum GXPropLoopMode {
        RESET,
        REVERSE;
        
        @NotNull
        public static final C3402a Companion = new C3402a(null);
        @NotNull
        public static final String KEY_LOOP_MODE = "loopMode";

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$GXPropLoopMode$a */
        /* loaded from: classes6.dex */
        public static final class C3402a {
            private C3402a() {
            }

            public /* synthetic */ C3402a(k50 k50Var) {
                this();
            }

            @NotNull
            public final GXPropLoopMode a(@NotNull String str) {
                boolean q;
                boolean q2;
                b41.i(str, "data");
                q = C8604o.q(str, "RESET", true);
                if (q) {
                    return GXPropLoopMode.RESET;
                }
                q2 = C8604o.q(str, "REVERSE", true);
                return q2 ? GXPropLoopMode.REVERSE : GXPropLoopMode.RESET;
            }
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rH\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rj\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropName;", "", "Landroid/view/View;", "targetView", "", "value", "Ltb/wt2;", "setPositionX", "setPositionY", "setOpacity", "setScaleX", "setScaleY", "setRotation", "", "setRenderColor", "finalValue", "setValue", "color", "setColorValue", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "POSITION_X", "POSITION_Y", "OPACITY", "SCALE", "ROTATION", "RENDER_COLOR", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public enum GXPropName {
        POSITION_X,
        POSITION_Y,
        OPACITY,
        SCALE,
        ROTATION,
        RENDER_COLOR;
        
        @NotNull
        public static final C3403a Companion = new C3403a(null);
        @NotNull
        private static final String KEY_OPACITY = "opacity";
        @NotNull
        private static final String KEY_POSITION_X = "positionX";
        @NotNull
        private static final String KEY_POSITION_Y = "positionY";
        @NotNull
        private static final String KEY_RENDER_COLOR = "renderColor";
        @NotNull
        private static final String KEY_ROTATION = "rotation";
        @NotNull
        private static final String KEY_SCALE = "scale";

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$GXPropName$a */
        /* loaded from: classes6.dex */
        public static final class C3403a {
            private C3403a() {
            }

            public /* synthetic */ C3403a(k50 k50Var) {
                this();
            }

            @Nullable
            public final GXPropName a(@Nullable String str) {
                boolean q;
                boolean q2;
                boolean q3;
                boolean q4;
                boolean q5;
                boolean q6;
                q = C8604o.q(str, GXPropName.KEY_POSITION_X, true);
                if (q) {
                    return GXPropName.POSITION_X;
                }
                q2 = C8604o.q(str, GXPropName.KEY_POSITION_Y, true);
                if (q2) {
                    return GXPropName.POSITION_Y;
                }
                q3 = C8604o.q(str, "opacity", true);
                if (q3) {
                    return GXPropName.OPACITY;
                }
                q4 = C8604o.q(str, "scale", true);
                if (q4) {
                    return GXPropName.SCALE;
                }
                q5 = C8604o.q(str, "rotation", true);
                if (q5) {
                    return GXPropName.ROTATION;
                }
                q6 = C8604o.q(str, GXPropName.KEY_RENDER_COLOR, true);
                if (q6) {
                    return GXPropName.RENDER_COLOR;
                }
                return null;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$GXPropName$b */
        /* loaded from: classes6.dex */
        public /* synthetic */ class C3404b {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[GXPropName.values().length];
                iArr[GXPropName.POSITION_X.ordinal()] = 1;
                iArr[GXPropName.POSITION_Y.ordinal()] = 2;
                iArr[GXPropName.OPACITY.ordinal()] = 3;
                iArr[GXPropName.SCALE.ordinal()] = 4;
                iArr[GXPropName.ROTATION.ordinal()] = 5;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private final void setOpacity(View view, float f) {
            view.setAlpha(f);
        }

        private final void setPositionX(View view, float f) {
            view.setTranslationX(hs0.Companion.e(f));
        }

        private final void setPositionY(View view, float f) {
            view.setTranslationY(hs0.Companion.e(f));
        }

        private final void setRenderColor(View view, int i) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(i);
            } else {
                view.setBackgroundColor(i);
            }
        }

        private final void setRotation(View view, float f) {
            view.setRotation(f);
        }

        private final void setScaleX(View view, float f) {
            view.setScaleX(f);
        }

        private final void setScaleY(View view, float f) {
            view.setScaleY(f);
        }

        public final void setColorValue(@NotNull View view, int i) {
            b41.i(view, "targetView");
            setRenderColor(view, i);
        }

        public final void setValue(@NotNull View view, float f) {
            b41.i(view, "targetView");
            int i = C3404b.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                setPositionX(view, f);
            } else if (i == 2) {
                setPositionY(view, f);
            } else if (i == 3) {
                setOpacity(view, f);
            } else if (i == 4) {
                setScaleX(view, f);
                setScaleY(view, f);
            } else if (i != 5) {
            } else {
                setRotation(view, f);
            }
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropOrderingType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "TOGETHER", GXPropOrderingType.KEY_SEQUENTIALLY, "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public enum GXPropOrderingType {
        TOGETHER,
        SEQUENTIALLY;
        
        @NotNull
        public static final C3405a Companion = new C3405a(null);
        @NotNull
        public static final String KEY_ORDERING = "ordering";
        @NotNull
        private static final String KEY_SEQUENTIALLY = "SEQUENTIALLY";

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$GXPropOrderingType$a */
        /* loaded from: classes6.dex */
        public static final class C3405a {
            private C3405a() {
            }

            public /* synthetic */ C3405a(k50 k50Var) {
                this();
            }

            @NotNull
            public final GXPropOrderingType a(@NotNull String str) {
                boolean q;
                b41.i(str, "value");
                q = C8604o.q(str, GXPropOrderingType.KEY_SEQUENTIALLY, true);
                return q ? GXPropOrderingType.SEQUENTIALLY : GXPropOrderingType.TOGETHER;
            }
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValueType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "IntType", "FloatType", "ColorType", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes6.dex */
    public enum GXPropValueType {
        IntType,
        FloatType,
        ColorType;
        
        @NotNull
        public static final C3406a Companion = new C3406a(null);

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$GXPropValueType$a */
        /* loaded from: classes6.dex */
        public static final class C3406a {
            private C3406a() {
            }

            public /* synthetic */ C3406a(k50 k50Var) {
                this();
            }

            @Nullable
            public final GXPropValueType a(@NotNull String str) {
                b41.i(str, "value");
                int hashCode = str.hashCode();
                if (hashCode != -2111334474) {
                    if (hashCode != 1957563337) {
                        if (hashCode == 1980942653 && str.equals("colorType")) {
                            return GXPropValueType.ColorType;
                        }
                    } else if (str.equals("intType")) {
                        return GXPropValueType.IntType;
                    }
                } else if (str.equals("floatType")) {
                    return GXPropValueType.FloatType;
                }
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$a */
    /* loaded from: classes6.dex */
    public static final class C3407a {
        private C3407a() {
        }

        public /* synthetic */ C3407a(k50 k50Var) {
            this();
        }

        @Nullable
        public final GXPropAnimationSet a(@Nullable JSONObject jSONObject) {
            JSONArray jSONArray;
            if (jSONObject == null || (jSONArray = jSONObject.getJSONArray("animators")) == null || !(!jSONArray.isEmpty())) {
                return null;
            }
            GXPropAnimationSet gXPropAnimationSet = new GXPropAnimationSet();
            for (Object obj : jSONArray) {
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) obj;
                    if (jSONObject2.containsKey(zp0.KEY_PROP_ANIMATOR_SET)) {
                        GXPropAnimationSet a = GXPropAnimationSet.Companion.a(jSONObject2.getJSONObject(zp0.KEY_PROP_ANIMATOR_SET));
                        if (a != null) {
                            gXPropAnimationSet.a().add(a);
                        }
                    } else if (jSONObject2.containsKey("propAnimator")) {
                        yr0.C9998a c9998a = yr0.Companion;
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("propAnimator");
                        b41.h(jSONObject3, "it.getJSONObject(KEY_PROP_ANIMATOR)");
                        yr0 a2 = c9998a.a(jSONObject3);
                        if (a2 != null) {
                            gXPropAnimationSet.a().add(a2);
                        }
                    } else {
                        yr0 a3 = yr0.Companion.a(jSONObject2);
                        if (a3 != null) {
                            gXPropAnimationSet.a().add(a3);
                        }
                    }
                }
            }
            String string = jSONObject.getString(GXPropOrderingType.KEY_ORDERING);
            if (string != null) {
                gXPropAnimationSet.d(GXPropOrderingType.Companion.a(string));
            }
            return gXPropAnimationSet;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$b */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC3408b {
        @NotNull
        public static final C3409a Companion = new C3409a(null);

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$b$a */
        /* loaded from: classes6.dex */
        public static final class C3409a {

            /* compiled from: Taobao */
            /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$b$a$a */
            /* loaded from: classes6.dex */
            public /* synthetic */ class C3410a {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[GXPropValueType.values().length];
                    iArr[GXPropValueType.IntType.ordinal()] = 1;
                    iArr[GXPropValueType.FloatType.ordinal()] = 2;
                    iArr[GXPropValueType.ColorType.ordinal()] = 3;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            private C3409a() {
            }

            public /* synthetic */ C3409a(k50 k50Var) {
                this();
            }

            @Nullable
            public final AbstractC3408b a(@NotNull JSONObject jSONObject) {
                b41.i(jSONObject, "data");
                GXPropValueType.C3406a c3406a = GXPropValueType.Companion;
                String string = jSONObject.getString("valueType");
                if (string == null) {
                    string = "";
                }
                GXPropValueType a = c3406a.a(string);
                if (a == null) {
                    return null;
                }
                int i = C3410a.$EnumSwitchMapping$0[a.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return C3411b.Companion.a(jSONObject);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return C3413c.Companion.a(jSONObject);
                }
                return C3413c.Companion.a(jSONObject);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$b$b */
        /* loaded from: classes6.dex */
        public static final class C3411b extends AbstractC3408b {
            @NotNull
            public static final C3412a Companion = new C3412a(null);
            @NotNull
            private final mq0 a;
            @NotNull
            private final mq0 b;

            /* compiled from: Taobao */
            /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$b$b$a */
            /* loaded from: classes6.dex */
            public static final class C3412a {
                private C3412a() {
                }

                public /* synthetic */ C3412a(k50 k50Var) {
                    this();
                }

                @Nullable
                public final C3411b a(@NotNull JSONObject jSONObject) {
                    b41.i(jSONObject, "data");
                    String string = jSONObject.getString("valueFrom");
                    if (string == null) {
                        string = "";
                    }
                    String string2 = jSONObject.getString("valueTo");
                    String str = string2 != null ? string2 : "";
                    if (string.length() > 0) {
                        if (string.length() > 0) {
                            mq0.C9449a c9449a = mq0.Companion;
                            mq0 a = c9449a.a(string);
                            mq0 a2 = c9449a.a(str);
                            if (a == null || a2 == null) {
                                return null;
                            }
                            return new C3411b(a, a2);
                        }
                        return null;
                    }
                    return null;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C3411b(@NotNull mq0 mq0Var, @NotNull mq0 mq0Var2) {
                super(null);
                b41.i(mq0Var, "valueFrom");
                b41.i(mq0Var2, "valueTo");
                this.a = mq0Var;
                this.b = mq0Var2;
            }

            @NotNull
            public final mq0 a() {
                return this.a;
            }

            @NotNull
            public final mq0 b() {
                return this.b;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$b$c */
        /* loaded from: classes6.dex */
        public static final class C3413c extends AbstractC3408b {
            @NotNull
            public static final C3414a Companion = new C3414a(null);
            private final float a;
            private final float b;

            /* compiled from: Taobao */
            /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$b$c$a */
            /* loaded from: classes6.dex */
            public static final class C3414a {
                private C3414a() {
                }

                public /* synthetic */ C3414a(k50 k50Var) {
                    this();
                }

                @Nullable
                public final C3413c a(@NotNull JSONObject jSONObject) {
                    b41.i(jSONObject, "data");
                    String string = jSONObject.getString("valueFrom");
                    if (string == null) {
                        string = "";
                    }
                    String string2 = jSONObject.getString("valueTo");
                    String str = string2 != null ? string2 : "";
                    if (string.length() > 0) {
                        if (string.length() > 0) {
                            return new C3413c(Float.parseFloat(string), Float.parseFloat(str));
                        }
                        return null;
                    }
                    return null;
                }
            }

            public C3413c(float f, float f2) {
                super(null);
                this.a = f;
                this.b = f2;
            }

            public final float a() {
                return this.a;
            }

            public final float b() {
                return this.b;
            }
        }

        private AbstractC3408b() {
        }

        public /* synthetic */ AbstractC3408b(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$c */
    /* loaded from: classes6.dex */
    public /* synthetic */ class C3415c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GXPropOrderingType.values().length];
            iArr[GXPropOrderingType.TOGETHER.ordinal()] = 1;
            iArr[GXPropOrderingType.SEQUENTIALLY.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$d */
    /* loaded from: classes6.dex */
    public static final class C3416d extends tq0 {
        final /* synthetic */ os0 a;
        final /* synthetic */ qr0 b;
        final /* synthetic */ View c;

        C3416d(os0 os0Var, qr0 qr0Var, View view) {
            this.a = os0Var;
            this.b = qr0Var;
            this.c = view;
        }

        @Override // tb.tq0, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animator) {
            this.b.N(false);
        }

        @Override // tb.tq0, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animator) {
            GXTemplateEngine.GXIEventListener c;
            this.b.N(false);
            GXTemplateEngine.C3346h p = this.a.p();
            if (p == null || (c = p.c()) == null) {
                return;
            }
            GXTemplateEngine.C3338b c3338b = new GXTemplateEngine.C3338b();
            qr0 qr0Var = this.b;
            View view = this.c;
            c3338b.h(GXTemplateEngine.C3338b.STATE_END);
            c3338b.g(qr0Var.g());
            c3338b.i(view);
            wt2 wt2Var = wt2.INSTANCE;
            c.onAnimationEvent(c3338b);
        }

        @Override // tb.tq0, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animator) {
            GXTemplateEngine.GXIEventListener c;
            GXTemplateEngine.C3346h p = this.a.p();
            if (p == null || (c = p.c()) == null) {
                return;
            }
            GXTemplateEngine.C3338b c3338b = new GXTemplateEngine.C3338b();
            qr0 qr0Var = this.b;
            View view = this.c;
            c3338b.h(GXTemplateEngine.C3338b.STATE_START);
            c3338b.g(qr0Var.g());
            c3338b.i(view);
            wt2 wt2Var = wt2.INSTANCE;
            c.onAnimationEvent(c3338b);
        }
    }

    @NotNull
    public final List<GXIPropAnimation> a() {
        return this.b;
    }

    @NotNull
    public final GXPropOrderingType b() {
        return this.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
        if ((r0 != null && r0.isRunning()) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(@org.jetbrains.annotations.NotNull tb.os0 r4, @org.jetbrains.annotations.NotNull tb.qr0 r5, @org.jetbrains.annotations.NotNull android.view.View r6) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            tb.b41.i(r4, r0)
            java.lang.String r0 = "child"
            tb.b41.i(r5, r0)
            java.lang.String r0 = "targetView"
            tb.b41.i(r6, r0)
            android.animation.AnimatorSet r0 = r5.m()
            if (r0 != 0) goto L1e
            android.animation.Animator r0 = r3.createAnimator(r6)
            android.animation.AnimatorSet r0 = (android.animation.AnimatorSet) r0
            r5.X(r0)
        L1e:
            boolean r0 = r5.s()
            r1 = 0
            if (r0 != 0) goto L36
            android.animation.AnimatorSet r0 = r5.m()
            r2 = 1
            if (r0 != 0) goto L2e
        L2c:
            r2 = 0
            goto L34
        L2e:
            boolean r0 = r0.isRunning()
            if (r0 != r2) goto L2c
        L34:
            if (r2 == 0) goto L43
        L36:
            android.animation.AnimatorSet r0 = r5.m()
            if (r0 != 0) goto L3d
            goto L40
        L3d:
            r0.cancel()
        L40:
            r5.N(r1)
        L43:
            android.animation.AnimatorSet r0 = r5.m()
            if (r0 != 0) goto L4a
            goto L4d
        L4a:
            r0.removeAllListeners()
        L4d:
            android.animation.AnimatorSet r0 = r5.m()
            if (r0 != 0) goto L54
            goto L5c
        L54:
            com.alibaba.gaiax.template.animation.GXPropAnimationSet$d r1 = new com.alibaba.gaiax.template.animation.GXPropAnimationSet$d
            r1.<init>(r4, r5, r6)
            r0.addListener(r1)
        L5c:
            android.animation.AnimatorSet r4 = r5.m()
            if (r4 != 0) goto L63
            goto L66
        L63:
            r4.start()
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.gaiax.template.animation.GXPropAnimationSet.c(tb.os0, tb.qr0, android.view.View):void");
    }

    @Override // com.alibaba.gaiax.template.animation.GXIPropAnimation
    @NotNull
    public Animator createAnimator(@NotNull View view) {
        b41.i(view, "targetView");
        AnimatorSet animatorSet = new AnimatorSet();
        int i = C3415c.$EnumSwitchMapping$0[b().ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (GXIPropAnimation gXIPropAnimation : a()) {
                arrayList.add(gXIPropAnimation.createAnimator(view));
            }
            animatorSet.playTogether(arrayList);
        } else if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            for (GXIPropAnimation gXIPropAnimation2 : a()) {
                arrayList2.add(gXIPropAnimation2.createAnimator(view));
            }
            animatorSet.playSequentially(arrayList2);
        }
        return animatorSet;
    }

    public final void d(@NotNull GXPropOrderingType gXPropOrderingType) {
        b41.i(gXPropOrderingType, "<set-?>");
        this.a = gXPropOrderingType;
    }
}
