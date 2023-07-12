package com.alibaba.pictures.bricks.channel.bean;

import android.text.TextUtils;
import cn.damai.projectfiltercopy.bean.CalendarStyle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class StyleFilter implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public final String calendarStyle;
    public final String isTopRoundCorner;
    public final String title;

    public StyleFilter(String str, String str2, String str3) {
        this.calendarStyle = str;
        this.title = str2;
        this.isTopRoundCorner = str3;
    }

    public CalendarStyle calendarStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237938687")) {
            return (CalendarStyle) ipChange.ipc$dispatch("-237938687", new Object[]{this});
        }
        if ("line".equalsIgnoreCase(this.calendarStyle)) {
            return CalendarStyle.LINE;
        }
        return CalendarStyle.BTN;
    }

    public boolean isTopRoundCorner() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "238442331") ? ((Boolean) ipChange.ipc$dispatch("238442331", new Object[]{this})).booleanValue() : TextUtils.equals("true", this.isTopRoundCorner);
    }
}
