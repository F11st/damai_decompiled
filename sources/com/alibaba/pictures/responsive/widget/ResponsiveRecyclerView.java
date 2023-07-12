package com.alibaba.pictures.responsive.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.responsive.size.OnResponsiveListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.e32;
import tb.k50;
import tb.y22;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011B\u001d\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/alibaba/pictures/responsive/widget/ResponsiveRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "widthSpec", "heightSpec", "Ltb/wt2;", "onMeasure", "Lcom/alibaba/pictures/responsive/size/OnResponsiveListener;", "onResponsiveListener", "setOnResponsiveListener", "Lcom/alibaba/pictures/responsive/size/OnResponsiveListener;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class ResponsiveRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnResponsiveListener onResponsiveListener;
    @Nullable
    private y22 responsiveSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveRecyclerView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsiveRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        OnResponsiveListener onResponsiveListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-573293587")) {
            ipChange.ipc$dispatch("-573293587", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int defaultSize = ViewGroup.getDefaultSize(0, i);
        int defaultSize2 = ViewGroup.getDefaultSize(0, i2);
        if (defaultSize != getMeasuredWidth() && (onResponsiveListener = this.onResponsiveListener) != null) {
            if (this.responsiveSize == null) {
                this.responsiveSize = new y22();
            }
            y22 y22Var = this.responsiveSize;
            if (y22Var != null) {
                y22Var.h(defaultSize);
                y22Var.g(defaultSize2);
                y22Var.f(e32.e(getContext()));
                y22Var.e(e32.d(getContext()));
                onResponsiveListener.onResponsive(y22Var);
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setOnResponsiveListener(@Nullable OnResponsiveListener onResponsiveListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-465554805")) {
            ipChange.ipc$dispatch("-465554805", new Object[]{this, onResponsiveListener});
        } else {
            this.onResponsiveListener = onResponsiveListener;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ResponsiveRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ ResponsiveRecyclerView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
