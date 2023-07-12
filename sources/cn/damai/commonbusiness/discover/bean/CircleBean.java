package cn.damai.commonbusiness.discover.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CircleBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String content;
    public List<CirclePic> contents;
    public String dynamicEffect;
    public boolean hasActivity;
    public String headImage;
    public String id;
    public List<String> joinHeadPics;
    public String joinTotal;
    public String name;
    public String type;

    public boolean isCircle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-805045503") ? ((Boolean) ipChange.ipc$dispatch("-805045503", new Object[]{this})).booleanValue() : TextUtils.equals("2", this.type);
    }

    public boolean isTheme() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "87436216") ? ((Boolean) ipChange.ipc$dispatch("87436216", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.type);
    }
}
