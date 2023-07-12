package cn.damai.tetris.component.brand.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ActivityInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String activityId;
    public String couponId;
    public String picUrl;
    public String targetId;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1599976216") ? ((Boolean) ipChange.ipc$dispatch("1599976216", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.couponId);
    }
}
