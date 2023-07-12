package com.alibaba.pictures.bricks.component.artist.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TextInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String NUM = "NUM";
    public static final String TEXT = "TEXT";
    public String value;
    public String valueType;

    public boolean isNumStyle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "10396012") ? ((Boolean) ipChange.ipc$dispatch("10396012", new Object[]{this})).booleanValue() : "NUM".equalsIgnoreCase(this.valueType);
    }
}
