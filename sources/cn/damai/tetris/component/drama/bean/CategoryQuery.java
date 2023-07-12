package cn.damai.tetris.component.drama.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class CategoryQuery implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public int dateType;
    public String endDate;
    public String groupId;
    public int index;
    public int sortType;
    public String startDate;

    public CategoryQuery(int i, String str, int i2, String str2, String str3, int i3) {
        this.sortType = i;
        this.groupId = str;
        this.dateType = i2;
        this.startDate = str2;
        this.endDate = str3;
        this.index = i3;
    }

    public static CategoryQuery defaultQuery() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "999886039") ? (CategoryQuery) ipChange.ipc$dispatch("999886039", new Object[0]) : new CategoryQuery(0, null, 0, null, null, 0);
    }
}
