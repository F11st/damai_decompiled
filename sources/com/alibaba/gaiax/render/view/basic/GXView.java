package com.alibaba.gaiax.render.view.basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.AbsoluteLayout;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.utils.GXAccessibilityUtils;
import com.alibaba.gaiax.render.view.GXIRelease;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cs0;
import tb.dq0;
import tb.gq0;
import tb.os0;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0011\b\u0016\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103B\u001b\b\u0016\u0012\u0006\u00101\u001a\u000200\u0012\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b2\u00106B#\b\u0016\u0012\u0006\u00101\u001a\u000200\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\u0006\u00107\u001a\u00020\u0011¢\u0006\u0004\b2\u00108J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001a\u001a\u00020\bH\u0014J\b\u0010\u001b\u001a\u00020\bH\u0014J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010 \u001a\u00020\bH\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00069"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXView;", "Landroid/widget/AbsoluteLayout;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRootView;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "Lcom/alibaba/gaiax/render/view/GXIRelease;", "Ltb/os0;", "gxContext", "Ltb/wt2;", "setTemplateContext", "getTemplateContext", "Lcom/alibaba/fastjson/JSONObject;", "data", "onBindData", "", BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerRadius", "", "borderColor", "", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "gxTemplateContext", "Ltb/dq0;", "gxBackdropFilter", "setBackdropFilter", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/graphics/Canvas;", "canvas", "draw", "dispatchDraw", "release", "[F", "getRadius$GaiaX", "()[F", "setRadius$GaiaX", "([F)V", "Ltb/dq0;", "getGxBackdropFilter", "()Ltb/dq0;", "setGxBackdropFilter", "(Ltb/dq0;)V", "Ltb/os0;", "getGxTemplateContext", "()Ltb/os0;", "setGxTemplateContext", "(Ltb/os0;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public class GXView extends AbsoluteLayout implements GXIRelease, GXIRootView, GXIRoundCorner, GXIViewBindData {
    @Nullable
    private dq0 gxBackdropFilter;
    @Nullable
    private gq0 gxBlurHelper;
    @Nullable
    private os0 gxTemplateContext;
    @Nullable
    private dq0 lastBackdropFilter;
    @Nullable
    private float[] radius;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.basic.GXView$a */
    /* loaded from: classes6.dex */
    public static final class C3367a extends ViewOutlineProvider {
        final /* synthetic */ float b;

        C3367a(float f) {
            this.b = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            b41.i(view, "view");
            b41.i(outline, com.taobao.android.launcher.common.Constants.PARAMETER_OUTLINE);
            if (GXView.this.getAlpha() >= 0.0f) {
                outline.setAlpha(GXView.this.getAlpha());
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXView(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull final Canvas canvas) {
        gq0 gq0Var;
        b41.i(canvas, "canvas");
        if (this.gxBackdropFilter != null) {
            if (Build.VERSION.SDK_INT < 17 || (gq0Var = this.gxBlurHelper) == null) {
                return;
            }
            gq0Var.g(canvas, new Function0<wt2>() { // from class: com.alibaba.gaiax.render.view.basic.GXView$dispatchDraw$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    super/*android.widget.AbsoluteLayout*/.dispatchDraw(canvas);
                }
            });
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(@NotNull final Canvas canvas) {
        gq0 gq0Var;
        b41.i(canvas, "canvas");
        if (this.gxBackdropFilter != null) {
            if (Build.VERSION.SDK_INT < 17 || (gq0Var = this.gxBlurHelper) == null) {
                return;
            }
            gq0Var.h(canvas, new Function0<wt2>() { // from class: com.alibaba.gaiax.render.view.basic.GXView$draw$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    super/*android.widget.AbsoluteLayout*/.draw(canvas);
                }
            });
            return;
        }
        super.draw(canvas);
    }

    @Nullable
    public final dq0 getGxBackdropFilter() {
        return this.gxBackdropFilter;
    }

    @Nullable
    public final os0 getGxTemplateContext() {
        return this.gxTemplateContext;
    }

    @Nullable
    public final float[] getRadius$GaiaX() {
        return this.radius;
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    @Nullable
    public os0 getTemplateContext() {
        return this.gxTemplateContext;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        gq0 gq0Var;
        super.onAttachedToWindow();
        if (this.gxBackdropFilter == null || Build.VERSION.SDK_INT < 17 || (gq0Var = this.gxBlurHelper) == null) {
            return;
        }
        gq0Var.o();
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
        GXAccessibilityUtils.INSTANCE.c(this, jSONObject);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        gq0 gq0Var;
        if (this.gxBackdropFilter != null && Build.VERSION.SDK_INT >= 17 && (gq0Var = this.gxBlurHelper) != null) {
            gq0Var.p();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onResetData() {
        GXIViewBindData.C3361a.a(this);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRelease
    public void release() {
        if (Build.VERSION.SDK_INT >= 17) {
            gq0 gq0Var = this.gxBlurHelper;
            if (gq0Var != null) {
                gq0Var.n();
            }
            this.gxBlurHelper = null;
        }
        this.gxTemplateContext = null;
    }

    public final void setBackdropFilter(@NotNull os0 os0Var, @Nullable dq0 dq0Var) {
        b41.i(os0Var, "gxTemplateContext");
        this.gxTemplateContext = os0Var;
        if (!b41.d(dq0Var, this.lastBackdropFilter)) {
            if (dq0Var instanceof dq0.C9054a) {
                if (Build.VERSION.SDK_INT >= 17) {
                    if (this.gxBlurHelper == null) {
                        this.gxBlurHelper = new gq0(this);
                    }
                    gq0 gq0Var = this.gxBlurHelper;
                    if (gq0Var != null) {
                        gq0Var.t(25.0f);
                    }
                    gq0 gq0Var2 = this.gxBlurHelper;
                    if (gq0Var2 != null) {
                        gq0Var2.w(12);
                    }
                }
                this.gxBackdropFilter = dq0Var;
            } else if (dq0Var instanceof dq0.C9056c) {
                if (Build.VERSION.SDK_INT >= 17) {
                    gq0 gq0Var3 = this.gxBlurHelper;
                    if (gq0Var3 != null) {
                        gq0Var3.n();
                    }
                    this.gxBlurHelper = null;
                }
                setBackground(null);
                this.gxBackdropFilter = null;
            }
        }
        this.lastBackdropFilter = dq0Var;
    }

    public final void setGxBackdropFilter(@Nullable dq0 dq0Var) {
        this.gxBackdropFilter = dq0Var;
    }

    public final void setGxTemplateContext(@Nullable os0 os0Var) {
        this.gxTemplateContext = os0Var;
    }

    public final void setRadius$GaiaX(@Nullable float[] fArr) {
        this.radius = fArr;
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int i, float f, @NotNull float[] fArr) {
        b41.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (getBackground() == null) {
            cs0 cs0Var = new cs0();
            cs0Var.setShape(0);
            cs0Var.setCornerRadii(fArr);
            cs0Var.setStroke((int) f, i);
            setBackground(cs0Var);
        } else if (getBackground() instanceof GradientDrawable) {
            Drawable background = getBackground();
            Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            gradientDrawable.setStroke((int) f, i);
            gradientDrawable.setCornerRadii(fArr);
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(@NotNull float[] fArr) {
        b41.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        this.radius = fArr;
        if (fArr.length == 8) {
            float f = fArr[0];
            float f2 = fArr[2];
            float f3 = fArr[4];
            float f4 = fArr[6];
            if (Build.VERSION.SDK_INT >= 21) {
                if (f == f2) {
                    if (f2 == f3) {
                        if ((f3 == f4) && f > 0.0f) {
                            setClipToOutline(true);
                            setOutlineProvider(new C3367a(f));
                            return;
                        }
                    }
                }
                setClipToOutline(false);
                setOutlineProvider(null);
            }
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    public void setTemplateContext(@Nullable os0 os0Var) {
        this.gxTemplateContext = os0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
