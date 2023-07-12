package com.youku.live.dago.widgetlib.ailproom.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.view.flowview.ViewFlowLayout;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ConfigurationChangedRelativeLayout extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewFlowLayout.ConfigurationListener mConfigurationListener;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface ConfigurationListener {
        void onConfigurationChanged(Configuration configuration);
    }

    public ConfigurationChangedRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2007983929")) {
            ipChange.ipc$dispatch("2007983929", new Object[]{this, configuration});
            return;
        }
        ViewFlowLayout.ConfigurationListener configurationListener = this.mConfigurationListener;
        if (configurationListener != null) {
            configurationListener.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    public void setConfigurationListener(ViewFlowLayout.ConfigurationListener configurationListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925225409")) {
            ipChange.ipc$dispatch("1925225409", new Object[]{this, configurationListener});
        } else {
            this.mConfigurationListener = configurationListener;
        }
    }

    public ConfigurationChangedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ConfigurationChangedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
