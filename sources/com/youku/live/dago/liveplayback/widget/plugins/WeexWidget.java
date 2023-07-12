package com.youku.live.dago.liveplayback.widget.plugins;

import android.view.View;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.Constants;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WeexWidget {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mArea;
    private String mKey;
    private LinearLayout.LayoutParams mLayoutParams;
    private String mTip;
    private View mView;

    public WeexWidget(Map<String, Object> map) {
        this.mView = (View) map.get("view");
        this.mKey = (String) map.get("key");
        this.mLayoutParams = (LinearLayout.LayoutParams) map.get(Constants.ACTION_PARAMS_LAYOUTPARAMS);
        ((Integer) map.get("p")).intValue();
        this.mArea = (String) map.get(Constants.ACTION_PARAMS_AREA);
        this.mTip = (String) map.get("tip");
    }

    public String getArea() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "189625344") ? (String) ipChange.ipc$dispatch("189625344", new Object[]{this}) : this.mArea;
    }

    public String getKey() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1029147522") ? (String) ipChange.ipc$dispatch("1029147522", new Object[]{this}) : this.mKey;
    }

    public LinearLayout.LayoutParams getLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-851607762") ? (LinearLayout.LayoutParams) ipChange.ipc$dispatch("-851607762", new Object[]{this}) : this.mLayoutParams;
    }

    public String getTip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2117322818") ? (String) ipChange.ipc$dispatch("-2117322818", new Object[]{this}) : this.mTip;
    }

    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1270785590") ? (View) ipChange.ipc$dispatch("-1270785590", new Object[]{this}) : this.mView;
    }
}
