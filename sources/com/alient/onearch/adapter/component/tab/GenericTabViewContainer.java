package com.alient.onearch.adapter.component.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/alient/onearch/adapter/component/tab/GenericTabViewContainer;", "Landroid/widget/FrameLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "Ltb/wt2;", "onMeasure", "current", "resetHeight", "Landroid/view/View;", "view", "position", "setObjectForPosition", "fixedHeight", "I", "Ljava/util/HashMap;", "childrenViews", "Ljava/util/HashMap;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class GenericTabViewContainer extends FrameLayout {
    @NotNull
    private final HashMap<Integer, View> childrenViews;
    private int current;
    private int fixedHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericTabViewContainer(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.childrenViews = new LinkedHashMap();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.childrenViews.isEmpty()) {
            super.onMeasure(i, i2);
            return;
        }
        int size = this.childrenViews.size();
        int i3 = this.current;
        if (size > i3) {
            View view = this.childrenViews.get(Integer.valueOf(i3));
            if (view != null) {
                view.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            }
            if (view != null) {
                this.fixedHeight = view.getMeasuredHeight();
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.fixedHeight, 1073741824));
    }

    public final void resetHeight(int i) {
        try {
            if (this.fixedHeight == 0) {
                return;
            }
            this.current = i;
            if (this.childrenViews.size() > i) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams == null) {
                    setLayoutParams(new ViewGroup.LayoutParams(-1, this.fixedHeight));
                } else {
                    int i2 = this.fixedHeight;
                    if (i2 != layoutParams.height) {
                        layoutParams.height = i2;
                        setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw new RuntimeException(e);
            }
        }
    }

    public final void setObjectForPosition(@NotNull View view, int i) {
        b41.i(view, "view");
        this.childrenViews.put(Integer.valueOf(i), view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericTabViewContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.childrenViews = new LinkedHashMap();
    }
}
