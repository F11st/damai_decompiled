package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ExRelatedInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public int type;
    public String value;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1298873244") ? ((Boolean) ipChange.ipc$dispatch("1298873244", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.value);
    }
}
