package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String content;
    public String id;
    public String schema;
    public String title;

    public String getSchema() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696435026")) {
            return (String) ipChange.ipc$dispatch("-1696435026", new Object[]{this});
        }
        return this.schema + this.id;
    }
}
