package cn.damai.discover.main.bean;

import android.text.TextUtils;
import cn.damai.comment.bean.HotDiscussBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.ih2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ThemeInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bannerPic;
    public String bannerUrl;
    public String contentCount;
    public String ipvuv;
    public List<ProjectItemBean> projectInfo;
    public ThemeShare share;
    public String showCommentButton;
    public String themeDesc;
    public String themeName;
    public HotDiscussBean topComment;
    public VoteInfoBean vote;

    public String getIpUvEtc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1682073942") ? (String) ipChange.ipc$dispatch("1682073942", new Object[]{this}) : ih2.a(this.contentCount, this.ipvuv);
    }

    public boolean isNeedShowCommentBtn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1475079414") ? ((Boolean) ipChange.ipc$dispatch("-1475079414", new Object[]{this})).booleanValue() : TextUtils.equals("2", this.showCommentButton);
    }
}
