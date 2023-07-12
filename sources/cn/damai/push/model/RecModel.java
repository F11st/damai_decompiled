package cn.damai.push.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class RecModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String bizType;
    private String data;
    private String dataId;
    private String expiryTime;
    private String extMap;
    private String sendTime;

    public String getBizType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1840332631") ? (String) ipChange.ipc$dispatch("-1840332631", new Object[]{this}) : this.bizType;
    }

    public String getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1175723428") ? (String) ipChange.ipc$dispatch("1175723428", new Object[]{this}) : this.data;
    }

    public String getDataId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "283289887") ? (String) ipChange.ipc$dispatch("283289887", new Object[]{this}) : this.dataId;
    }

    public String getExpiryTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-471455142") ? (String) ipChange.ipc$dispatch("-471455142", new Object[]{this}) : this.expiryTime;
    }

    public String getExtMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1525149493") ? (String) ipChange.ipc$dispatch("1525149493", new Object[]{this}) : this.extMap;
    }

    public String getSendTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "598293871") ? (String) ipChange.ipc$dispatch("598293871", new Object[]{this}) : this.sendTime;
    }

    public void setBizType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462977005")) {
            ipChange.ipc$dispatch("1462977005", new Object[]{this, str});
        } else {
            this.bizType = str;
        }
    }

    public void setData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794931130")) {
            ipChange.ipc$dispatch("1794931130", new Object[]{this, str});
        } else {
            this.data = str;
        }
    }

    public void setDataId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203040097")) {
            ipChange.ipc$dispatch("-1203040097", new Object[]{this, str});
        } else {
            this.dataId = str;
        }
    }

    public void setExpiryTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454876356")) {
            ipChange.ipc$dispatch("454876356", new Object[]{this, str});
        } else {
            this.expiryTime = str;
        }
    }

    public void setExtMap(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360097975")) {
            ipChange.ipc$dispatch("-1360097975", new Object[]{this, str});
        } else {
            this.extMap = str;
        }
    }

    public void setSendTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1484912975")) {
            ipChange.ipc$dispatch("1484912975", new Object[]{this, str});
        } else {
            this.sendTime = str;
        }
    }
}
