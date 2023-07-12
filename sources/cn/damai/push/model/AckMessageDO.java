package cn.damai.push.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AckMessageDO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String bizType;
    private String dataId;
    private String passthrough;
    private String processTime;
    private String resultCode;

    public String getBizType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "696666329") ? (String) ipChange.ipc$dispatch("696666329", new Object[]{this}) : this.bizType;
    }

    public String getDataId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "226581231") ? (String) ipChange.ipc$dispatch("226581231", new Object[]{this}) : this.dataId;
    }

    public String getPassthrough() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1716774528") ? (String) ipChange.ipc$dispatch("-1716774528", new Object[]{this}) : this.passthrough;
    }

    public String getProcessTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "578066888") ? (String) ipChange.ipc$dispatch("578066888", new Object[]{this}) : this.processTime;
    }

    public String getResultCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1268788276") ? (String) ipChange.ipc$dispatch("1268788276", new Object[]{this}) : this.resultCode;
    }

    public void setBizType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494433859")) {
            ipChange.ipc$dispatch("-1494433859", new Object[]{this, str});
        } else {
            this.bizType = str;
        }
    }

    public void setDataId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1333958863")) {
            ipChange.ipc$dispatch("1333958863", new Object[]{this, str});
        } else {
            this.dataId = str;
        }
    }

    public void setPassthrough(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "314613238")) {
            ipChange.ipc$dispatch("314613238", new Object[]{this, str});
        } else {
            this.passthrough = str;
        }
    }

    public void setProcessTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1559746898")) {
            ipChange.ipc$dispatch("-1559746898", new Object[]{this, str});
        } else {
            this.processTime = str;
        }
    }

    public void setResultCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1432152534")) {
            ipChange.ipc$dispatch("-1432152534", new Object[]{this, str});
        } else {
            this.resultCode = str;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059601870")) {
            return (String) ipChange.ipc$dispatch("1059601870", new Object[]{this});
        }
        return "{dataId='" + this.dataId + "', bizType='" + this.bizType + "', resultCode='" + this.resultCode + "', processTime='" + this.processTime + "'}";
    }
}
