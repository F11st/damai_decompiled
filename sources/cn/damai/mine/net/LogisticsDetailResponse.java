package cn.damai.mine.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class LogisticsDetailResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String iconUrl;
    private long orderId;
    private String status;
    private List<TransitStepInfosBean> transitStepInfos;
    private String waybillId;
    private String waybillName;
    private String waybillPhone;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class TransitStepInfosBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        private String action;
        private String trackInfo;
        private String trackTime;

        public String getAction() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-232777601") ? (String) ipChange.ipc$dispatch("-232777601", new Object[]{this}) : this.action;
        }

        public String getTrackInfo() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1609244582") ? (String) ipChange.ipc$dispatch("1609244582", new Object[]{this}) : this.trackInfo;
        }

        public String getTrackTime() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-256718779") ? (String) ipChange.ipc$dispatch("-256718779", new Object[]{this}) : this.trackTime;
        }

        public void setAction(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-21263041")) {
                ipChange.ipc$dispatch("-21263041", new Object[]{this, str});
            } else {
                this.action = str;
            }
        }

        public void setTrackInfo(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "676736912")) {
                ipChange.ipc$dispatch("676736912", new Object[]{this, str});
            } else {
                this.trackInfo = str;
            }
        }

        public void setTrackTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1333552431")) {
                ipChange.ipc$dispatch("-1333552431", new Object[]{this, str});
            } else {
                this.trackTime = str;
            }
        }
    }

    public String getIconUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "880487825") ? (String) ipChange.ipc$dispatch("880487825", new Object[]{this}) : this.iconUrl;
    }

    public long getOrderId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "340159280") ? ((Long) ipChange.ipc$dispatch("340159280", new Object[]{this})).longValue() : this.orderId;
    }

    public String getStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "180183597") ? (String) ipChange.ipc$dispatch("180183597", new Object[]{this}) : this.status;
    }

    public List<TransitStepInfosBean> getTransitStepInfos() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2085832616") ? (List) ipChange.ipc$dispatch("2085832616", new Object[]{this}) : this.transitStepInfos;
    }

    public String getWaybillId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-180793588") ? (String) ipChange.ipc$dispatch("-180793588", new Object[]{this}) : this.waybillId;
    }

    public String getWaybillName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1873063172") ? (String) ipChange.ipc$dispatch("-1873063172", new Object[]{this}) : this.waybillName;
    }

    public String getWaybillPhone() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "480646867") ? (String) ipChange.ipc$dispatch("480646867", new Object[]{this}) : this.waybillPhone;
    }

    public void setIconUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-90934779")) {
            ipChange.ipc$dispatch("-90934779", new Object[]{this, str});
        } else {
            this.iconUrl = str;
        }
    }

    public void setOrderId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183297660")) {
            ipChange.ipc$dispatch("183297660", new Object[]{this, Long.valueOf(j)});
        } else {
            this.orderId = j;
        }
    }

    public void setStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-104367791")) {
            ipChange.ipc$dispatch("-104367791", new Object[]{this, str});
        } else {
            this.status = str;
        }
    }

    public void setTransitStepInfos(List<TransitStepInfosBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2024741668")) {
            ipChange.ipc$dispatch("2024741668", new Object[]{this, list});
        } else {
            this.transitStepInfos = list;
        }
    }

    public void setWaybillId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020128490")) {
            ipChange.ipc$dispatch("1020128490", new Object[]{this, str});
        } else {
            this.waybillId = str;
        }
    }

    public void setWaybillName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235367430")) {
            ipChange.ipc$dispatch("-235367430", new Object[]{this, str});
        } else {
            this.waybillName = str;
        }
    }

    public void setWaybillPhone(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881935253")) {
            ipChange.ipc$dispatch("-1881935253", new Object[]{this, str});
        } else {
            this.waybillPhone = str;
        }
    }
}
