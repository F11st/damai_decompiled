package com.alibaba.pictures.responsive.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.pictures.responsive.size.OnResponsiveListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.y22;
import tb.z22;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 B\u001d\b\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001f\u0010!J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/alibaba/pictures/responsive/widget/ResponsiveLinearLayout;", "Landroid/widget/LinearLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "Ltb/wt2;", "onMeasure", "layoutRatio", "setLayoutRatio", "", "ratio", "setRatio", "Lcom/alibaba/pictures/responsive/size/OnResponsiveListener;", "onResponsiveListener", "setOnResponsiveListener", Constants.Name.MARGIN, "setMargin", com.youku.arch.v3.data.Constants.H_GAP, "setHGap", "Ltb/z22;", "responsiveSizeManager", "Ltb/z22;", "getResponsiveSizeManager", "()Ltb/z22;", "setResponsiveSizeManager", "(Ltb/z22;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class ResponsiveLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private z22 responsiveSizeManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveLinearLayout(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsiveLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        z22 z22Var = new z22(this);
        this.responsiveSizeManager = z22Var;
        z22Var.d(context, attributeSet);
    }

    @NotNull
    public final z22 getResponsiveSizeManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "765308242") ? (z22) ipChange.ipc$dispatch("765308242", new Object[]{this}) : this.responsiveSizeManager;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615767586")) {
            ipChange.ipc$dispatch("1615767586", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        y22 e = this.responsiveSizeManager.e(i, i2);
        if (e.d() > 0) {
            i = View.MeasureSpec.makeMeasureSpec(e.d(), 1073741824);
        }
        if (e.c() > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(e.c(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final void setHGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110697426")) {
            ipChange.ipc$dispatch("1110697426", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.f(i);
        requestLayout();
    }

    public final void setLayoutRatio(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2000946841")) {
            ipChange.ipc$dispatch("2000946841", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.g(i);
        requestLayout();
    }

    public final void setMargin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737943374")) {
            ipChange.ipc$dispatch("-737943374", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.h(i);
        requestLayout();
    }

    public final void setOnResponsiveListener(@Nullable OnResponsiveListener onResponsiveListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766789450")) {
            ipChange.ipc$dispatch("-766789450", new Object[]{this, onResponsiveListener});
        } else {
            this.responsiveSizeManager.i(onResponsiveListener);
        }
    }

    public final void setRatio(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1191930198")) {
            ipChange.ipc$dispatch("-1191930198", new Object[]{this, str});
            return;
        }
        this.responsiveSizeManager.j(str);
        requestLayout();
    }

    public final void setResponsiveSizeManager(@NotNull z22 z22Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660346422")) {
            ipChange.ipc$dispatch("1660346422", new Object[]{this, z22Var});
            return;
        }
        b41.i(z22Var, "<set-?>");
        this.responsiveSizeManager = z22Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ ResponsiveLinearLayout(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
