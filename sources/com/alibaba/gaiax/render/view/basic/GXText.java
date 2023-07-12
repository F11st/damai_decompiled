package com.alibaba.gaiax.render.view.basic;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.render.utils.GXAccessibilityUtils;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.GXViewExtKt;
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
import tb.hs0;
import tb.ls0;
import tb.lz1;
import tb.mq0;
import tb.pq0;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;B\u001b\b\u0016\u0012\u0006\u00109\u001a\u000208\u0012\b\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b:\u0010>B#\b\u0016\u0012\u0006\u00109\u001a\u000208\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\u0006\u0010?\u001a\u00020\u000e¢\u0006\u0004\b:\u0010@J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0002J\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\n2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\nJ\u0017\u0010#\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b&\u0010\u0011J\u0010\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020'H\u0016J \u0010,\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020!2\u0006\u0010(\u001a\u00020'H\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010.R\u0018\u00103\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010.R\u0018\u00106\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010.R\u0018\u00107\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00104¨\u0006A"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXText;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "Landroid/widget/TextView;", "textView", "", "content", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/wt2;", "bindDesc", "", "getContent", "", Constants.Name.TEXT_DECORATION, "setFontTextDecoration", "(Ljava/lang/Integer;)V", "Ltb/lz1;", "Ltb/hs0;", Constants.Name.PADDING, "setFontPadding", "Ltb/ls0;", "style", "setFontColor", "setFontTextLineHeight", "onBindData", "onResetData", "bindText", "Ltb/pq0;", "css", "setTextStyle", "reset", "", "fontSize", "setFontSize", "(Ljava/lang/Float;)V", "fontLiens", "setFontLines", "", BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerRadius", "borderColor", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "lastTextDecoration", "Ljava/lang/Integer;", "lastLeftPadding", "lastTopPadding", "lastRightPadding", "lastBottomPadding", "lastFontSize", "Ljava/lang/Float;", "lastFontColor", "lastFontLines", "lastLineHeight", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public class GXText extends AppCompatTextView implements GXIRoundCorner, GXIViewBindData {
    @Nullable
    private Integer lastBottomPadding;
    @Nullable
    private Integer lastFontColor;
    @Nullable
    private Integer lastFontLines;
    @Nullable
    private Float lastFontSize;
    @Nullable
    private Integer lastLeftPadding;
    @Nullable
    private Float lastLineHeight;
    @Nullable
    private Integer lastRightPadding;
    @Nullable
    private Integer lastTextDecoration;
    @Nullable
    private Integer lastTopPadding;

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
            if (GXText.this.getAlpha() >= 0.0f) {
                outline.setAlpha(GXText.this.getAlpha());
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXText(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    private final void bindDesc(TextView textView, CharSequence charSequence, JSONObject jSONObject) {
        GXAccessibilityUtils.INSTANCE.b(textView, jSONObject, charSequence);
    }

    private final CharSequence getContent(Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                return (CharSequence) obj;
            }
            if (obj instanceof JSONObject) {
                return getContent(((JSONObject) obj).get("value"));
            }
            if (obj instanceof CharSequence) {
                return (CharSequence) obj;
            }
            return obj.toString();
        }
        return "";
    }

    private final void setFontColor(ls0 ls0Var) {
        mq0 s = ls0Var.s();
        int c = s == null ? -16777216 : s.c(getContext());
        Integer num = this.lastFontColor;
        if (num != null && c == num.intValue()) {
            return;
        }
        setTextColor(c);
        this.lastFontColor = Integer.valueOf(c);
    }

    private final void setFontPadding(lz1<hs0> lz1Var) {
        hs0 c;
        hs0 d;
        hs0 b;
        Integer num;
        Integer num2;
        Integer num3;
        hs0 a2;
        int i = 0;
        int d2 = (lz1Var == null || (c = lz1Var.c()) == null) ? 0 : c.d();
        int d3 = (lz1Var == null || (d = lz1Var.d()) == null) ? 0 : d.d();
        int d4 = (lz1Var == null || (b = lz1Var.b()) == null) ? 0 : b.d();
        if (lz1Var != null && (a2 = lz1Var.a()) != null) {
            i = a2.d();
        }
        Integer num4 = this.lastLeftPadding;
        if (num4 != null && num4.intValue() == d2 && (num = this.lastTopPadding) != null && num.intValue() == d3 && (num2 = this.lastRightPadding) != null && num2.intValue() == d4 && (num3 = this.lastBottomPadding) != null && num3.intValue() == i) {
            return;
        }
        setPadding(d2, d3, d4, i);
        this.lastLeftPadding = Integer.valueOf(d2);
        this.lastTopPadding = Integer.valueOf(d3);
        this.lastRightPadding = Integer.valueOf(d4);
        this.lastBottomPadding = Integer.valueOf(i);
    }

    private final void setFontTextDecoration(Integer num) {
        if (num == null || b41.d(num, this.lastTextDecoration)) {
            return;
        }
        getPaint().setFlags(num.intValue());
        this.lastTextDecoration = num;
    }

    private final void setFontTextLineHeight(ls0 ls0Var) {
        hs0 w = ls0Var.w();
        Object obj = null;
        Float valueOf = w == null ? null : Float.valueOf(w.c());
        if (valueOf == null || b41.c(this.lastLineHeight, valueOf)) {
            return;
        }
        GXRegisterCenter.GXIExtensionDynamicProperty h = GXRegisterCenter.Companion.a().h();
        if (h != null) {
            GXRegisterCenter.GXIExtensionDynamicProperty.a aVar = new GXRegisterCenter.GXIExtensionDynamicProperty.a("line-height", valueOf);
            aVar.e(ls0Var);
            wt2 wt2Var = wt2.INSTANCE;
            obj = h.convert(aVar);
        }
        if (obj != null) {
            GXViewExtKt.x(this, ((Float) obj).floatValue());
        } else {
            GXViewExtKt.x(this, valueOf.floatValue());
        }
        this.lastLineHeight = valueOf;
    }

    public void bindText(@NotNull TextView textView, @NotNull CharSequence charSequence) {
        b41.i(textView, "textView");
        b41.i(charSequence, "content");
        textView.setText(charSequence);
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
        CharSequence content = getContent(jSONObject);
        bindText(this, content);
        bindDesc(this, content, jSONObject);
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onResetData() {
        setText("");
    }

    public final void reset() {
        this.lastLineHeight = null;
        this.lastFontLines = null;
        this.lastFontColor = null;
        this.lastFontSize = null;
        this.lastTextDecoration = null;
        this.lastLeftPadding = null;
        this.lastTopPadding = null;
        this.lastRightPadding = null;
        this.lastBottomPadding = null;
        setPadding(0, 0, 0, 0);
    }

    public final void setFontLines(@Nullable Integer num) {
        int intValue = num == null ? 1 : num.intValue();
        Integer num2 = this.lastFontLines;
        if (num2 != null && num2.intValue() == intValue) {
            return;
        }
        if (intValue == 0) {
            setMaxLines(Integer.MAX_VALUE);
        } else if (intValue != 1) {
            setMaxLines(intValue);
        } else {
            setSingleLine(true);
        }
        this.lastFontLines = Integer.valueOf(intValue);
    }

    public final void setFontSize(@Nullable Float f) {
        if (b41.c(this.lastFontSize, f) || f == null || f.floatValue() < 0.0f) {
            return;
        }
        setTextSize(0, f.floatValue());
        this.lastFontSize = f;
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

    public final void setTextStyle(@NotNull pq0 pq0Var) {
        b41.i(pq0Var, "css");
        ls0 b = pq0Var.b();
        setFontPadding(b.S());
        hs0 A = b.A();
        setFontSize(A == null ? null : Float.valueOf(A.c()));
        GXViewExtKt.h(this, b);
        setFontColor(b);
        GXViewExtKt.g(this, b.e());
        setFontLines(b.y());
        GXViewExtKt.j(this, b);
        GXViewExtKt.i(this, b);
        setFontTextLineHeight(b);
        setFontTextDecoration(b.E());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
