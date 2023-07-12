package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k23;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MessageItem implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageItem> CREATOR = new Parcelable.Creator<MessageItem>() { // from class: cn.damai.message.bean.MessageItem.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageItem createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "235641351") ? (MessageItem) ipChange.ipc$dispatch("235641351", new Object[]{this, parcel}) : new MessageItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageItem[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1152986544") ? (MessageItem[]) ipChange.ipc$dispatch("-1152986544", new Object[]{this, Integer.valueOf(i)}) : new MessageItem[i];
        }
    };
    private int actionType;
    public String actionUrl;
    private String actionValue;
    private String buType;
    private boolean delete;
    private String expireTime;
    private String extJson;
    private String gmtCreate;
    private String gmtCreateText;
    private String gmtModified;
    private String havanaId;
    private String imageUrl;
    private String messageId;
    private String motion;
    private String msgBody;
    private int msgType;
    private PerformFilmVipDO performFilmVipDO;
    private boolean read;
    private String receive;
    private int receiveType;
    private String tags;
    private String title;
    private int vTag;

    public MessageItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2046005417")) {
            return ((Integer) ipChange.ipc$dispatch("2046005417", new Object[]{this})).intValue();
        }
        return 0;
    }

    public int getActionType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-669378948") ? ((Integer) ipChange.ipc$dispatch("-669378948", new Object[]{this})).intValue() : this.actionType;
    }

    public String getActionValue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1712899530") ? (String) ipChange.ipc$dispatch("1712899530", new Object[]{this}) : this.actionValue;
    }

    public String getBuType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-44386732") ? (String) ipChange.ipc$dispatch("-44386732", new Object[]{this}) : this.buType;
    }

    public String getExpireTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-267685581") ? (String) ipChange.ipc$dispatch("-267685581", new Object[]{this}) : this.expireTime;
    }

    public String getExtJson() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1736498536") ? (String) ipChange.ipc$dispatch("-1736498536", new Object[]{this}) : this.extJson;
    }

    public String getGmtCreate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-442624167") ? (String) ipChange.ipc$dispatch("-442624167", new Object[]{this}) : this.gmtCreate;
    }

    public String getGmtCreateText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1853337894") ? (String) ipChange.ipc$dispatch("1853337894", new Object[]{this}) : this.gmtCreateText;
    }

    public String getGmtModified() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-385469402") ? (String) ipChange.ipc$dispatch("-385469402", new Object[]{this}) : this.gmtModified;
    }

    public String getHavanaId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-184352199") ? (String) ipChange.ipc$dispatch("-184352199", new Object[]{this}) : this.havanaId;
    }

    public String getImageUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "566241723") ? (String) ipChange.ipc$dispatch("566241723", new Object[]{this}) : this.imageUrl;
    }

    public String getMemberFlag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "11478221")) {
            return (String) ipChange.ipc$dispatch("11478221", new Object[]{this});
        }
        PerformFilmVipDO performFilmVipDO = this.performFilmVipDO;
        if (performFilmVipDO != null) {
            return performFilmVipDO.memberFlag;
        }
        return k23.h();
    }

    public String getMessageId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "719901681") ? (String) ipChange.ipc$dispatch("719901681", new Object[]{this}) : this.messageId;
    }

    public String getMotion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1065178787") ? (String) ipChange.ipc$dispatch("-1065178787", new Object[]{this}) : this.motion;
    }

    public String getMsgBody() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1565903794") ? (String) ipChange.ipc$dispatch("1565903794", new Object[]{this}) : this.msgBody;
    }

    public int getMsgType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-733757943") ? ((Integer) ipChange.ipc$dispatch("-733757943", new Object[]{this})).intValue() : this.msgType;
    }

    public PerformFilmVipDO getPerformFilmVipDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2000952345") ? (PerformFilmVipDO) ipChange.ipc$dispatch("2000952345", new Object[]{this}) : this.performFilmVipDO;
    }

    public String getReceive() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2117582382") ? (String) ipChange.ipc$dispatch("-2117582382", new Object[]{this}) : this.receive;
    }

    public int getReceiveType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1790243431") ? ((Integer) ipChange.ipc$dispatch("1790243431", new Object[]{this})).intValue() : this.receiveType;
    }

    public String getTags() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-311880384") ? (String) ipChange.ipc$dispatch("-311880384", new Object[]{this}) : this.tags;
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "481787335") ? (String) ipChange.ipc$dispatch("481787335", new Object[]{this}) : this.title;
    }

    public int getvTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-51910552") ? ((Integer) ipChange.ipc$dispatch("-51910552", new Object[]{this})).intValue() : this.vTag;
    }

    public boolean isDelete() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1884669002") ? ((Boolean) ipChange.ipc$dispatch("1884669002", new Object[]{this})).booleanValue() : this.delete;
    }

    public boolean isPerformFilmVip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084791677")) {
            return ((Boolean) ipChange.ipc$dispatch("2084791677", new Object[]{this})).booleanValue();
        }
        PerformFilmVipDO performFilmVipDO = this.performFilmVipDO;
        return performFilmVipDO != null && k23.d(performFilmVipDO.memberFlag);
    }

    public boolean isRead() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "108383103") ? ((Boolean) ipChange.ipc$dispatch("108383103", new Object[]{this})).booleanValue() : this.read;
    }

    public void setActionType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-216033882")) {
            ipChange.ipc$dispatch("-216033882", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.actionType = i;
        }
    }

    public void setActionValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739673364")) {
            ipChange.ipc$dispatch("-739673364", new Object[]{this, str});
        } else {
            this.actionValue = str;
        }
    }

    public void setBuType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523886602")) {
            ipChange.ipc$dispatch("1523886602", new Object[]{this, str});
        } else {
            this.buType = str;
        }
    }

    public void setDelete(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779709678")) {
            ipChange.ipc$dispatch("-779709678", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.delete = z;
        }
    }

    public void setExpireTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1818201845")) {
            ipChange.ipc$dispatch("-1818201845", new Object[]{this, str});
        } else {
            this.expireTime = str;
        }
    }

    public void setExtJson(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "386866654")) {
            ipChange.ipc$dispatch("386866654", new Object[]{this, str});
        } else {
            this.extJson = str;
        }
    }

    public void setGmtCreate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493315133")) {
            ipChange.ipc$dispatch("1493315133", new Object[]{this, str});
        } else {
            this.gmtCreate = str;
        }
    }

    public void setGmtCreateText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249763824")) {
            ipChange.ipc$dispatch("-249763824", new Object[]{this, str});
        } else {
            this.gmtCreateText = str;
        }
    }

    public void setGmtModified(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364600816")) {
            ipChange.ipc$dispatch("-1364600816", new Object[]{this, str});
        } else {
            this.gmtModified = str;
        }
    }

    public void setHavanaId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1302278715")) {
            ipChange.ipc$dispatch("-1302278715", new Object[]{this, str});
        } else {
            this.havanaId = str;
        }
    }

    public void setImageUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "491296387")) {
            ipChange.ipc$dispatch("491296387", new Object[]{this, str});
        } else {
            this.imageUrl = str;
        }
    }

    public void setMessageId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1123089243")) {
            ipChange.ipc$dispatch("-1123089243", new Object[]{this, str});
        } else {
            this.messageId = str;
        }
    }

    public void setMotion(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55896031")) {
            ipChange.ipc$dispatch("-55896031", new Object[]{this, str});
        } else {
            this.motion = str;
        }
    }

    public void setMsgBody(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317876220")) {
            ipChange.ipc$dispatch("-317876220", new Object[]{this, str});
        } else {
            this.msgBody = str;
        }
    }

    public void setMsgType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251601185")) {
            ipChange.ipc$dispatch("1251601185", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.msgType = i;
        }
    }

    public void setPerformFilmVipDO(PerformFilmVipDO performFilmVipDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2141226845")) {
            ipChange.ipc$dispatch("-2141226845", new Object[]{this, performFilmVipDO});
        } else {
            this.performFilmVipDO = performFilmVipDO;
        }
    }

    public void setRead(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2109500547")) {
            ipChange.ipc$dispatch("-2109500547", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.read = z;
        }
    }

    public void setReceive(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458169316")) {
            ipChange.ipc$dispatch("1458169316", new Object[]{this, str});
        } else {
            this.receive = str;
        }
    }

    public void setReceiveType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "583035011")) {
            ipChange.ipc$dispatch("583035011", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.receiveType = i;
        }
    }

    public void setTags(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371114082")) {
            ipChange.ipc$dispatch("-1371114082", new Object[]{this, str});
        } else {
            this.tags = str;
        }
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246905743")) {
            ipChange.ipc$dispatch("246905743", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    public void setvTag(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697777094")) {
            ipChange.ipc$dispatch("-1697777094", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.vTag = i;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "595131202")) {
            ipChange.ipc$dispatch("595131202", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.messageId);
        parcel.writeString(this.title);
        parcel.writeString(this.msgBody);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.buType);
        parcel.writeInt(this.msgType);
        parcel.writeInt(this.actionType);
        parcel.writeString(this.actionValue);
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.expireTime);
        parcel.writeString(this.extJson);
        parcel.writeInt(this.receiveType);
        parcel.writeString(this.receive);
        parcel.writeByte(this.read ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.delete ? (byte) 1 : (byte) 0);
        parcel.writeString(this.tags);
        parcel.writeString(this.gmtCreate);
        parcel.writeString(this.gmtModified);
        parcel.writeString(this.gmtCreateText);
        parcel.writeString(this.motion);
        parcel.writeInt(this.vTag);
        parcel.writeSerializable(this.performFilmVipDO);
    }

    protected MessageItem(Parcel parcel) {
        this.messageId = parcel.readString();
        this.title = parcel.readString();
        this.msgBody = parcel.readString();
        this.imageUrl = parcel.readString();
        this.buType = parcel.readString();
        this.msgType = parcel.readInt();
        this.actionType = parcel.readInt();
        this.actionValue = parcel.readString();
        this.actionUrl = parcel.readString();
        this.expireTime = parcel.readString();
        this.extJson = parcel.readString();
        this.receiveType = parcel.readInt();
        this.receive = parcel.readString();
        this.read = parcel.readByte() != 0;
        this.delete = parcel.readByte() != 0;
        this.tags = parcel.readString();
        this.gmtCreate = parcel.readString();
        this.gmtModified = parcel.readString();
        this.gmtCreateText = parcel.readString();
        this.motion = parcel.readString();
        this.vTag = parcel.readInt();
        this.performFilmVipDO = (PerformFilmVipDO) parcel.readSerializable();
    }
}
