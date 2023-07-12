package com.youku.live.dago.widgetlib.interactive.gift.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class KeyBoardBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MAX_TYPE = 3;
    public static final int TYPE_0 = 0;
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public String name;
    public int type;

    public KeyBoardBean(String str, int i) {
        this.name = str;
        this.type = i;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-829004822")) {
            return (String) ipChange.ipc$dispatch("-829004822", new Object[]{this});
        }
        return "KeyBoardBean{, name='" + this.name + "', type=" + this.type + '}';
    }
}
