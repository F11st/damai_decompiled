package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TicketSouvenirDetail implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public EmptyDataVO emptyDataVO;
    public Long serverTimestamp;
    public TicketSouvenirInfo souvenirVO;
    public UserPerformSouvenirVO userPerformSouvenirVO;

    public TicketDeatilResult makeDetailResult4SouvenirPopLayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "560854595")) {
            return (TicketDeatilResult) ipChange.ipc$dispatch("560854595", new Object[]{this});
        }
        TicketDeatilResult ticketDeatilResult = new TicketDeatilResult();
        PerformTable performTable = new PerformTable();
        performTable.setTicketQuantity(this.userPerformSouvenirVO.ticketQuantity);
        performTable.setUserProjectVO(this.userPerformSouvenirVO.userProjectVO);
        performTable.setPerformId(this.userPerformSouvenirVO.performId);
        performTable.setProductSystemId(this.userPerformSouvenirVO.productSystemId);
        performTable.setTenantId(this.userPerformSouvenirVO.tenantId);
        performTable.setUserTicketVOList(this.userPerformSouvenirVO.userTicketVOList);
        ticketDeatilResult.setUserPerformVO(performTable);
        ticketDeatilResult.serverTimestamp = this.serverTimestamp;
        return ticketDeatilResult;
    }
}
