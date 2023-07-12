package com.youku.live.dago.widgetlib.interactive.gift.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftNumBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_NAME = "name";
    public static final String KEY_NUM = "num";
    public static final int MAX_TYPE = 3;
    public static final int TYPE_0 = 0;
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public String name;
    public int num;
    public int type;

    public GiftNumBean() {
        this.type = 0;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466382753")) {
            return (String) ipChange.ipc$dispatch("-1466382753", new Object[]{this});
        }
        return "GiftNumBean{num=" + this.num + ", name='" + this.name + "', type=" + this.type + '}';
    }

    public GiftNumBean(String str, int i, int i2) {
        this.type = 0;
        this.name = str;
        this.num = i;
        this.type = i2;
    }
}
