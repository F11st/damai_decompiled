package cn.damai.homepage.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomePageGuideBarSearchKeywords {
    private static transient /* synthetic */ IpChange $ipChange;
    List<KeyWord> keywords;

    public List<KeyWord> getKeywords() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1069655850") ? (List) ipChange.ipc$dispatch("1069655850", new Object[]{this}) : this.keywords;
    }

    public void setKeywords(List<KeyWord> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689952286")) {
            ipChange.ipc$dispatch("-1689952286", new Object[]{this, list});
        } else {
            this.keywords = list;
        }
    }
}
