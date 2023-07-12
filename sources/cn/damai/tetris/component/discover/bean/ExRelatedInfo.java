package cn.damai.tetris.component.discover.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ExRelatedInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public int type;
    public String value;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "763073215") ? ((Boolean) ipChange.ipc$dispatch("763073215", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.value);
    }
}
