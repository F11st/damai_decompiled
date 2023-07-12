package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TicketTable implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String REAL_NAMR = "3";
    private static final long serialVersionUID = 1;
    public String acceptVoucherType;
    public String fullSeatInfo;
    public String performId;
    public String tranferRecordId;

    public Object clone() throws CloneNotSupportedException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951484015")) {
            return ipChange.ipc$dispatch("-951484015", new Object[]{this});
        }
        try {
            return (TicketTable) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
