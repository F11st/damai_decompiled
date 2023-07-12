package cn.damai.setting.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SettingBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String value;

    public boolean isOpenCollect() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-157608768") ? ((Boolean) ipChange.ipc$dispatch("-157608768", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.value) && "1".equals(this.value);
    }
}
