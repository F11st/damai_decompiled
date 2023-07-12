package com.alibaba.gaiax.render.view.basic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.utils.GXAccessibilityUtils;
import com.alibaba.gaiax.render.view.GXIRelease;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bs0;
import tb.k50;
import tb.os0;
import tb.pq0;
import tb.pr0;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001IB\u0011\b\u0016\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BB\u001b\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bA\u0010EB#\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\u0006\u0010F\u001a\u00020\u0006¢\u0006\u0004\bA\u0010GJ\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\"\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0012\u0010\u001f\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J(\u0010$\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0014J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016J\u0012\u0010,\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010-\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010*H\u0014J\u0010\u00100\u001a\u00020\u00122\u0006\u0010/\u001a\u00020.H\u0016J&\u00100\u001a\u00020\u00122\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u0002012\u0006\u00105\u001a\u000201J \u00108\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u0002012\u0006\u0010/\u001a\u00020.H\u0016J6\u00108\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u0002012\u0006\u00105\u001a\u000201J\b\u00109\u001a\u00020\u0012H\u0016R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006J"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/alibaba/gaiax/render/view/basic/GXIImageView;", "Lcom/alibaba/gaiax/render/view/GXIRelease;", "Landroid/widget/ImageView;", "imageView", "", "resId", "Landroid/graphics/drawable/Drawable;", "getDrawableByResId", "", "uri", "getResIdByUri", "", "isNetUri", "isLocalUri", "getLocalUri", "drawable", "Ltb/wt2;", "updateMatrix", "Lcom/alibaba/fastjson/JSONObject;", "data", "onBindData", "onResetData", "bindUri", "bindDefault", Constants.Name.PLACEHOLDER, "bindNetUri", "resUri", "bindRes", "getRes", "bindDesc", NotifyType.LIGHTS, "t", UploadQueueMgr.MSGTYPE_REALTIME, "b", "setFrame", "Ltb/os0;", "gxTemplateContext", "Ltb/pq0;", "gxCss", "setImageStyle", "Landroid/graphics/Canvas;", "canvas", "draw", "onDraw", "", BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerRadius", "", "topLeft", "topRight", "bottomLeft", "bottomRight", "borderColor", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "release", "Ltb/os0;", "getGxTemplateContext", "()Ltb/os0;", "setGxTemplateContext", "(Ltb/os0;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public class GXImageView extends AppCompatImageView implements GXIRelease, GXIImageView {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String LOCAL_PREFIX = "local:";
    @NotNull
    public static final String NET_HTTPS_PREFIX = "https:";
    @NotNull
    public static final String NET_HTTP_PREFIX = "http:";
    @Nullable
    private bs0 delegate;
    @Nullable
    private os0 gxTemplateContext;
    @Nullable
    private pr0 mode;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXImageView(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    private final Drawable getDrawableByResId(ImageView imageView, int i) {
        Resources.Theme theme = imageView.getContext().getTheme();
        b41.h(theme, "imageView.context.theme");
        return ResourcesCompat.getDrawable(imageView.getResources(), i, theme);
    }

    private final String getLocalUri(String str) {
        String z;
        z = o.z(str, "local:", "", false, 4, null);
        return z;
    }

    private final int getResIdByUri(ImageView imageView, String str) {
        Integer valueOf;
        boolean z;
        try {
            valueOf = Integer.valueOf(imageView.getResources().getIdentifier(str, "drawable", imageView.getContext().getPackageName()));
            z = true;
            if (!(valueOf.intValue() != 0)) {
                valueOf = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (valueOf == null) {
            Integer valueOf2 = Integer.valueOf(imageView.getResources().getIdentifier(str, "mipmap", imageView.getContext().getPackageName()));
            if (valueOf2.intValue() == 0) {
                z = false;
            }
            Integer num = z ? valueOf2 : null;
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
        return valueOf.intValue();
    }

    private final boolean isLocalUri(String str) {
        boolean F;
        F = o.F(str, "local:", false, 2, null);
        return F;
    }

    private final boolean isNetUri(String str) {
        boolean F;
        boolean F2;
        F = o.F(str, "http:", false, 2, null);
        if (!F) {
            F2 = o.F(str, "https:", false, 2, null);
            if (!F2) {
                return false;
            }
        }
        return true;
    }

    private final void updateMatrix(ImageView imageView, Drawable drawable) {
        if (drawable == null || imageView.getScaleType() != ImageView.ScaleType.MATRIX) {
            return;
        }
        int paddingLeft = (imageView.getLayoutParams().width - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        int paddingTop = (imageView.getLayoutParams().height - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return;
        }
        pr0 pr0Var = this.mode;
        imageView.setImageMatrix(pr0Var == null ? null : pr0Var.j(paddingLeft, paddingTop, intrinsicWidth, intrinsicHeight));
    }

    public void bindDefault() {
        setImageDrawable(null);
    }

    public void bindDesc(@Nullable JSONObject jSONObject) {
        GXAccessibilityUtils.INSTANCE.a(this, jSONObject);
    }

    public void bindNetUri(@NotNull JSONObject jSONObject, @NotNull String str, @Nullable String str2) {
        b41.i(jSONObject, "data");
        b41.i(str, "uri");
    }

    public void bindRes(@NotNull String str) {
        b41.i(str, "resUri");
        try {
            setImageDrawable(getDrawableByResId(this, getResIdByUri(this, str)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bindUri(@Nullable JSONObject jSONObject) {
        String string;
        CharSequence M0;
        String str = "";
        if (jSONObject != null && (string = jSONObject.getString("value")) != null) {
            M0 = StringsKt__StringsKt.M0(string);
            String obj = M0.toString();
            if (obj != null) {
                str = obj;
            }
        }
        if (isNetUri(str)) {
            if (jSONObject == null) {
                return;
            }
            bindNetUri(jSONObject, str, jSONObject.getString(Constants.Name.PLACEHOLDER));
        } else if (isLocalUri(str)) {
            bindRes(getLocalUri(str));
        } else {
            bindDefault();
        }
    }

    @Override // android.view.View
    public void draw(@Nullable final Canvas canvas) {
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        bs0 bs0Var = this.delegate;
        boolean z = false;
        if (bs0Var != null && bs0Var.d(canvas, measuredWidth, measuredHeight)) {
            z = true;
        }
        if (z) {
            bs0 bs0Var2 = this.delegate;
            if (bs0Var2 == null) {
                return;
            }
            bs0Var2.a(canvas, measuredWidth, measuredHeight, new Function0<wt2>() { // from class: com.alibaba.gaiax.render.view.basic.GXImageView$draw$1
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
                    super/*android.widget.ImageView*/.draw(canvas);
                }
            });
            return;
        }
        super.draw(canvas);
    }

    @Nullable
    public final os0 getGxTemplateContext() {
        return this.gxTemplateContext;
    }

    public int getRes(@NotNull String str) {
        b41.i(str, "resUri");
        try {
            return getResIdByUri(this, str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView, com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
        bindUri(jSONObject);
        bindDesc(jSONObject);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        bs0 bs0Var;
        super.onDraw(canvas);
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        bs0 bs0Var2 = this.delegate;
        boolean z = false;
        if (bs0Var2 != null && bs0Var2.d(canvas, measuredWidth, measuredHeight)) {
            z = true;
        }
        if (!z || (bs0Var = this.delegate) == null) {
            return;
        }
        bs0Var.e(canvas, measuredWidth, measuredHeight);
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onResetData() {
        setImageDrawable(null);
    }

    @Override // com.alibaba.gaiax.render.view.GXIRelease
    public void release() {
        this.gxTemplateContext = null;
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        updateMatrix(this, getDrawable());
        return super.setFrame(i, i2, i3, i4);
    }

    public final void setGxTemplateContext(@Nullable os0 os0Var) {
        this.gxTemplateContext = os0Var;
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView
    public void setImageStyle(@NotNull os0 os0Var, @NotNull pq0 pq0Var) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(pq0Var, "gxCss");
        pr0 M = pq0Var.b().M();
        if (M != null) {
            this.mode = M;
            setScaleType(M.p());
        } else {
            setScaleType(ImageView.ScaleType.FIT_XY);
        }
        this.gxTemplateContext = os0Var;
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView, com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int i, float f, @NotNull float[] fArr) {
        b41.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (this.delegate == null) {
            this.delegate = new bs0();
        }
        bs0 bs0Var = this.delegate;
        if (bs0Var == null) {
            return;
        }
        bs0Var.g(i, f, fArr);
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView, com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(@NotNull float[] fArr) {
        b41.i(fArr, BQCCameraParam.FOCUS_AREA_RADIUS);
        if (this.delegate == null) {
            this.delegate = new bs0();
        }
        bs0 bs0Var = this.delegate;
        if (bs0Var == null) {
            return;
        }
        bs0Var.i(fArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public final void setRoundCornerBorder(int i, float f, float f2, float f3, float f4, float f5) {
        if (this.delegate == null) {
            this.delegate = new bs0();
        }
        bs0 bs0Var = this.delegate;
        if (bs0Var == null) {
            return;
        }
        bs0Var.f(i, f, f2, f3, f4, f5);
    }

    public final void setRoundCornerRadius(float f, float f2, float f3, float f4) {
        if (this.delegate == null) {
            this.delegate = new bs0();
        }
        bs0 bs0Var = this.delegate;
        if (bs0Var == null) {
            return;
        }
        bs0Var.h(f, f2, f3, f4);
    }
}
