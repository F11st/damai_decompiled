package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.bb2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cardType;
    public String count;
    public String followDesc;
    public int index;
    public String rankId;
    public String shortDesc;
    public String shortName;
    public int type;
    public List<String> verticalPicList;

    public String getPic() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "820954432")) {
            return (String) ipChange.ipc$dispatch("820954432", new Object[]{this});
        }
        if (bb2.d(this.verticalPicList)) {
            return null;
        }
        return this.verticalPicList.get(0);
    }
}
