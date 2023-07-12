package com.alibaba.pictures.responsive.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$B\u001d\b\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b#\u0010%J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006&"}, d2 = {"Lcom/alibaba/pictures/responsive/widget/ResponsiveConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "Ltb/wt2;", "onMeasure", "layoutRatio", "setLayoutRatio", "", "ratio", "setRatio", "Lcom/alibaba/pictures/responsive/size/OnResponsiveListener;", "onResponsiveListener", "setOnResponsiveListener", "Ltb/z22;", "responsiveSizeManager", "Ltb/z22;", "getResponsiveSizeManager", "()Ltb/z22;", "setResponsiveSizeManager", "(Ltb/z22;)V", Constants.Name.MARGIN, "getMargin", "()I", "setMargin", "(I)V", com.youku.arch.v3.data.Constants.H_GAP, "getHGap", "setHGap", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class ResponsiveConstraintLayout extends ConstraintLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private z22 responsiveSizeManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveConstraintLayout(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsiveConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        z22 z22Var = new z22(this);
        this.responsiveSizeManager = z22Var;
        z22Var.d(context, attributeSet);
    }

    public final int getHGap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-788596584") ? ((Integer) ipChange.ipc$dispatch("-788596584", new Object[]{this})).intValue() : this.responsiveSizeManager.b();
    }

    public final int getMargin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1996037304") ? ((Integer) ipChange.ipc$dispatch("1996037304", new Object[]{this})).intValue() : this.responsiveSizeManager.c();
    }

    @NotNull
    public final z22 getResponsiveSizeManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "166744090") ? (z22) ipChange.ipc$dispatch("166744090", new Object[]{this}) : this.responsiveSizeManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412167446")) {
            ipChange.ipc$dispatch("-412167446", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        y22 e = this.responsiveSizeManager.e(i, i2);
        if (e.d() > 0) {
            i = View.MeasureSpec.makeMeasureSpec(e.d(), 1073741824);
        }
        if (e.c() > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(e.c(), 1073741824);
        }
        if (getLayoutParams() == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
        super.onMeasure(i, i2);
    }

    public final void setHGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234759690")) {
            ipChange.ipc$dispatch("1234759690", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.f(i);
        requestLayout();
    }

    public final void setLayoutRatio(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-918450847")) {
            ipChange.ipc$dispatch("-918450847", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.g(i);
        requestLayout();
    }

    public final void setMargin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773191958")) {
            ipChange.ipc$dispatch("-1773191958", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.responsiveSizeManager.h(i);
        requestLayout();
    }

    public final void setOnResponsiveListener(@Nullable OnResponsiveListener onResponsiveListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "322280686")) {
            ipChange.ipc$dispatch("322280686", new Object[]{this, onResponsiveListener});
        } else {
            this.responsiveSizeManager.i(onResponsiveListener);
        }
    }

    public final void setRatio(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "909148898")) {
            ipChange.ipc$dispatch("909148898", new Object[]{this, str});
            return;
        }
        this.responsiveSizeManager.j(str);
        requestLayout();
    }

    public final void setResponsiveSizeManager(@NotNull z22 z22Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "284726894")) {
            ipChange.ipc$dispatch("284726894", new Object[]{this, z22Var});
            return;
        }
        b41.i(z22Var, "<set-?>");
        this.responsiveSizeManager = z22Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ ResponsiveConstraintLayout(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
