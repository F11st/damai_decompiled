package cn.damai.discover.main.ui.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class RankUserBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String count;
    public String countDisplay;
    public String havanaIdStr;
    public String headPic;
    public boolean isCurrentLoginUser;
    public String nickName;
    public int rankingNo;

    public int getMaskDrawableRid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678917479")) {
            return ((Integer) ipChange.ipc$dispatch("-678917479", new Object[]{this})).intValue();
        }
        int i = this.rankingNo;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return R$drawable.icon_rank_user_default;
                }
                return R$drawable.icon_rank_user_3;
            }
            return R$drawable.icon_rank_user_2;
        }
        return R$drawable.icon_rank_user_1;
    }

    public String getRankNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1713605647")) {
            return (String) ipChange.ipc$dispatch("-1713605647", new Object[]{this});
        }
        if (this.rankingNo > 999) {
            return "999+";
        }
        return this.rankingNo + "";
    }

    public boolean isValidUser() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "641501982") ? ((Boolean) ipChange.ipc$dispatch("641501982", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.havanaIdStr);
    }
}
