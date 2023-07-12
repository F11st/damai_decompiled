package cn.damai.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class MemberAuthDetail implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String mainTip;
    public List<MemberProtocol> protocol;
    public String rightImgUrl;
    public List<String> subInfos;

    public static MemberAuthDetail mock() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421172796")) {
            return (MemberAuthDetail) ipChange.ipc$dispatch("-1421172796", new Object[0]);
        }
        MemberAuthDetail memberAuthDetail = new MemberAuthDetail();
        memberAuthDetail.mainTip = "大麦会员升级为影演会员，会员专享11项权益，需要你共享如下信息AA：";
        ArrayList arrayList = new ArrayList();
        memberAuthDetail.subInfos = arrayList;
        arrayList.add("1 使用影演会员积分兑换权益AA");
        arrayList.add("2 使用影演会员积分兑换权益AA");
        arrayList.add("3 使用影演会员积分兑换权益AA");
        ArrayList arrayList2 = new ArrayList();
        memberAuthDetail.protocol = arrayList2;
        MemberProtocol memberProtocol = new MemberProtocol();
        memberProtocol.protocolTitle = "同意A";
        memberProtocol.protocolName = "《大麦会员服务协议A》";
        memberProtocol.protocolUrl = "https://www.baidu.com/";
        arrayList2.add(memberProtocol);
        return memberAuthDetail;
    }

    public MemberProtocol firstProtocol() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1283080763")) {
            return (MemberProtocol) ipChange.ipc$dispatch("-1283080763", new Object[]{this});
        }
        List<MemberProtocol> list = this.protocol;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.protocol.get(0);
    }
}
