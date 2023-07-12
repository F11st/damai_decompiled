package com.youku.live.livesdk.wkit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.dom.CSSLayout;
import com.youku.live.widgets.impl.BaseWidget;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BaseStackWidget extends BaseWidget {
    private static transient /* synthetic */ IpChange $ipChange;
    private BaseStackLayout frameLayout;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class BaseStackLayout extends CSSLayout {
        public BaseStackLayout(@NonNull Context context) {
            super(context);
        }

        public BaseStackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public BaseStackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078121666")) {
            return (View) ipChange.ipc$dispatch("2078121666", new Object[]{this, context});
        }
        BaseStackLayout baseStackLayout = new BaseStackLayout(context);
        this.frameLayout = baseStackLayout;
        return baseStackLayout;
    }
}
