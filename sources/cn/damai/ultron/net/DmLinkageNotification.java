package cn.damai.ultron.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import tb.np2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DmLinkageNotification {
    private static transient /* synthetic */ IpChange $ipChange;
    private np2 tradeEvent;
    private IDMComponent trigger;

    public DmLinkageNotification(IDMComponent iDMComponent, np2 np2Var) {
        this.trigger = iDMComponent;
        this.tradeEvent = np2Var;
    }

    public np2 getEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-444055235") ? (np2) ipChange.ipc$dispatch("-444055235", new Object[]{this}) : this.tradeEvent;
    }

    public IDMComponent getTrigger() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1067309196") ? (IDMComponent) ipChange.ipc$dispatch("-1067309196", new Object[]{this}) : this.trigger;
    }

    public void setTradeEventAndTrigger(np2 np2Var, IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-573479040")) {
            ipChange.ipc$dispatch("-573479040", new Object[]{this, np2Var, iDMComponent});
            return;
        }
        this.tradeEvent = np2Var;
        this.trigger = iDMComponent;
    }
}
