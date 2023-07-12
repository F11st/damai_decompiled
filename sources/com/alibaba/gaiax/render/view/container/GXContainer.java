package com.alibaba.gaiax.render.view.container;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cs0;
import tb.os0;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u001eJ\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u001f"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/GXContainer;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/alibaba/gaiax/render/view/GXIContainer;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRootView;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/wt2;", "onBindData", "Ltb/os0;", "gxContext", "setTemplateContext", "getTemplateContext", "", BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerRadius", "", "borderColor", "", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public class GXContainer extends RecyclerView implements GXIContainer, GXIRootView, GXIRoundCorner, GXIViewBindData {
    @Nullable
    private os0 gxTemplateContext;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ float b;

        a(float f) {
            this.b = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            b41.i(view, "view");
            b41.i(outline, com.taobao.android.launcher.common.Constants.PARAMETER_OUTLINE);
            if (GXContainer.this.getAlpha() >= 0.0f) {
                outline.setAlpha(GXContainer.this.getAlpha());
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXContainer(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRootView
    @Nullable
    public os0 getTemplateContext() {
        return this.gxTemplateContext;
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onResetData() {
        GXIViewBindData.a.a(this);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int i, float f, @NotNull float[] fArr) {
        b41.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (Build.VERSION.SDK_INT < 23 || fArr.length != 8) {
            return;
        }
        if (getForeground() == null) {
            cs0 cs0Var = new cs0();
            cs0Var.setShape(0);
            cs0Var.setCornerRadii(fArr);
            cs0Var.setStroke((int) f, i);
            setForeground(cs0Var);
        } else if (getForeground() instanceof GradientDrawable) {
            Drawable foreground = getForeground();
            Objects.requireNonNull(foreground, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) foreground;
            gradientDrawable.setStroke((int) f, i);
            gradientDrawable.setCornerRadii(fArr);
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(@NotNull float[] fArr) {
        b41.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
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
                            setOutlineProvider(new a(f));
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
    public GXContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
