package com.youku.live.widgets.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.WidgetInstance;
import com.youku.live.widgets.dom.CSSLayout;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class RenderContainer extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    public WeakReference<WidgetInstance> mSDKInstance;

    public RenderContainer(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735187162")) {
            ipChange.ipc$dispatch("-735187162", new Object[]{this, view, Integer.valueOf(i), layoutParams});
            return;
        }
        if (view instanceof CSSLayout) {
            ((CSSLayout) view).supportAscendingDispatchTouchEvent(true);
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        WidgetInstance widgetInstance;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1040039944")) {
            ipChange.ipc$dispatch("-1040039944", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        WeakReference<WidgetInstance> weakReference = this.mSDKInstance;
        if (weakReference == null || (widgetInstance = weakReference.get()) == null) {
            return;
        }
        widgetInstance.setSize(i, i2);
    }

    public RenderContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RenderContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
