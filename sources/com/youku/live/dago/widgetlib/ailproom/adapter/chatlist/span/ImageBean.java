package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ImageBean extends ItemBaseBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public Integer alignment;
    public float height;
    public String src;
    public float width;

    public ImageBean setAlignment(Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190287362")) {
            return (ImageBean) ipChange.ipc$dispatch("1190287362", new Object[]{this, num});
        }
        this.alignment = num;
        return this;
    }

    public ImageBean setHeight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400530961")) {
            return (ImageBean) ipChange.ipc$dispatch("400530961", new Object[]{this, Float.valueOf(f)});
        }
        this.height = f;
        return this;
    }

    public ImageBean setSrc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576309912")) {
            return (ImageBean) ipChange.ipc$dispatch("-1576309912", new Object[]{this, str});
        }
        this.src = str;
        return this;
    }

    public ImageBean setWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587203798")) {
            return (ImageBean) ipChange.ipc$dispatch("587203798", new Object[]{this, Float.valueOf(f)});
        }
        this.width = f;
        return this;
    }
}
