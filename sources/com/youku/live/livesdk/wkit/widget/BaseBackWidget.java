package com.youku.live.livesdk.wkit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.utils.ViewUtils;
import com.youku.live.widgets.impl.BaseWidget;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BaseBackWidget extends BaseWidget {
    private static transient /* synthetic */ IpChange $ipChange;
    private BaseBackLayout frameLayout;

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-28795229")) {
            return (View) ipChange.ipc$dispatch("-28795229", new Object[]{this, context});
        }
        BaseBackLayout baseBackLayout = new BaseBackLayout(context);
        this.frameLayout = baseBackLayout;
        baseBackLayout.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.livesdk.wkit.widget.BaseBackWidget.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "73431362")) {
                    ipChange2.ipc$dispatch("73431362", new Object[]{this, view});
                } else {
                    ViewUtils.getActivity(view.getContext()).finish();
                }
            }
        });
        return this.frameLayout;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private static class BaseBackLayout extends FrameLayout {
        public BaseBackLayout(@NonNull Context context) {
            super(context);
            init();
        }

        private void init() {
        }

        public BaseBackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            init();
        }

        public BaseBackLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            init();
        }
    }
}
