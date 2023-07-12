package cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TicketCalcBean implements Serializable {
    private static final long serialVersionUID = 7073655333302952187L;
    public List<TicketMainUiModel> calculateModuleVOS;
    public String realTotalAmt;
    public String realTotalAmtText;
    public String reduceTotalAmt;
    public String reduceTotalAmtDesc;
    public List<TicketCombineInfo> ticketModuleDetailVOS;
    public List<ShortTag> usedPromotionList;
}
