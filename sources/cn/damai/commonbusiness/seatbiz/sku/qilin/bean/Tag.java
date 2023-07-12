package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Tag implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String subTagDesc;
    public String tag;
    public String tagDesc;
    public int tagOrientation = 1;

    public Tag(String str, String str2) {
        this.tag = str;
        this.tagDesc = str2;
    }

    public boolean isPositive() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "562421763") ? ((Boolean) ipChange.ipc$dispatch("562421763", new Object[]{this})).booleanValue() : this.tagOrientation == 1;
    }

    public Tag() {
    }
}
