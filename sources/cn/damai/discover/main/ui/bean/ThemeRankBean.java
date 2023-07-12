package cn.damai.discover.main.ui.bean;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ThemeRankBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bannerPic;
    public String bannerUrl;
    public int cliquePrize;
    public long countDown;
    public String descUrl;
    public String name;
    public List<RankUserBean> rankList;
    public List<RankUserBean> ranks;
    public int type;

    @NonNull
    public List<RankUserBean> getRankList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472518200")) {
            return (List) ipChange.ipc$dispatch("-472518200", new Object[]{this});
        }
        if (cb2.d(this.rankList)) {
            if (cb2.d(this.ranks)) {
                return new ArrayList();
            }
            return this.ranks;
        }
        return this.rankList;
    }
}
