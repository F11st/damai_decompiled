package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TicketPerformTransferAcceptResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public ArrayList<TicketPerformTransferData> result;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class TicketPerformTransferData implements Serializable {
        private static final long serialVersionUID = 1;
        public Long beginTime;
        public String color;
        public Tips headTitleTips;
        public String isNeedLiveBind;
        public String mobile;
        public String performId;
        public String performName;
        public String productSystemId;
        public String projectName;
        public Tips recvProtocolTips;
        public String serverTimestamp;
        public ArrayList<TicketTable> ticketInfoVOs;
        public int ticketNum;
        public String timeTitle;
        public Tips tips;
        public String venueName;
    }

    public ArrayList<TicketPerformTransferData> getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-83542782") ? (ArrayList) ipChange.ipc$dispatch("-83542782", new Object[]{this}) : this.result;
    }

    public void setResult(ArrayList<TicketPerformTransferData> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1960457614")) {
            ipChange.ipc$dispatch("1960457614", new Object[]{this, arrayList});
        } else {
            this.result = arrayList;
        }
    }
}
