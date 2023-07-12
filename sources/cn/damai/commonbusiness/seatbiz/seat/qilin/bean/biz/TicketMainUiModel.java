package cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TicketMainUiModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_PROMOTION_COUPON = "4";
    public static final String TYPE_PROMOTION_SHOP = "3";
    public static final String TYPE_PROMOTION_SINGLE = "2";
    public static final String TYPE_SERVICE_FEE = "5";
    public static final String TYPE_TICKET_PRICE = "1";
    public String iconJumpURL;
    public List<TicketSubUiModel> moduleDetailVOList;
    public String moduleIconURL;
    public String moduleTitle;
    public String moduleTotalAmt;
    public String moduleTotalAmtText;
    public String moduleType;

    public boolean isTicketPriceModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1824806902") ? ((Boolean) ipChange.ipc$dispatch("1824806902", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.moduleType);
    }
}
