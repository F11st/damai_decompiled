package cn.damai.user.userprofile.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class IdolSelectRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int pageIndex = 1;
    public int pageSize = 30;
    public String targetId;
    public String targetType;
    public static List<String> tabs = new ArrayList();
    public static List<String> tabIds = new ArrayList();

    static {
        tabs.add("我的");
        tabs.add("明星");
        tabs.add(ErrControlViewInfo.TYPE_VENUE);
        tabs.add("品牌");
        tabs.add("剧目");
        tabs.add("类目");
        tabIds.add("1");
        tabIds.add("2");
        tabIds.add("3");
        tabIds.add("4");
        tabIds.add("5");
        tabIds.add("9");
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1210507684") ? (String) ipChange.ipc$dispatch("1210507684", new Object[]{this}) : "mtop.damai.wireless.follow.circlelist.query";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203028727")) {
            return ((Boolean) ipChange.ipc$dispatch("-203028727", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-622186171")) {
            return ((Boolean) ipChange.ipc$dispatch("-622186171", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-916722889") ? (String) ipChange.ipc$dispatch("-916722889", new Object[]{this}) : "1.0";
    }
}
