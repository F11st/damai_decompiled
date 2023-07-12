package cn.damai.commonbusiness.seatbiz.projectdetail.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ProjectDetailsTicketTag implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_IDENTITY_CARD = "1";
    private String description;
    private String name;
    private String type;

    public String getDescription() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2045193692") ? (String) ipChange.ipc$dispatch("2045193692", new Object[]{this}) : this.description;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1103292513") ? (String) ipChange.ipc$dispatch("1103292513", new Object[]{this}) : this.name;
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1308373104") ? (String) ipChange.ipc$dispatch("-1308373104", new Object[]{this}) : this.type;
    }

    public void setDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971511066")) {
            ipChange.ipc$dispatch("971511066", new Object[]{this, str});
        } else {
            this.description = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-450427235")) {
            ipChange.ipc$dispatch("-450427235", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097349966")) {
            ipChange.ipc$dispatch("2097349966", new Object[]{this, str});
        } else {
            this.type = str;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1646773566")) {
            return (String) ipChange.ipc$dispatch("-1646773566", new Object[]{this});
        }
        return "ProjectDetailsTicketTag{description='" + this.description + "', name='" + this.name + "', type='" + this.type + "'}";
    }
}
