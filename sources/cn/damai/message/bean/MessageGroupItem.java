package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MessageGroupItem implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageGroupItem> CREATOR = new Parcelable.Creator<MessageGroupItem>() { // from class: cn.damai.message.bean.MessageGroupItem.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageGroupItem createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "659782251") ? (MessageGroupItem) ipChange.ipc$dispatch("659782251", new Object[]{this, parcel}) : new MessageGroupItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageGroupItem[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "559582752") ? (MessageGroupItem[]) ipChange.ipc$dispatch("559582752", new Object[]{this, Integer.valueOf(i)}) : new MessageGroupItem[i];
        }
    };
    private int buType;
    private String gmtCreate;
    private String groupIcon;
    private long groupId;
    private String msgBody;
    private String msgTypeName;
    private String unBadgeReadCount;

    public MessageGroupItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356254570")) {
            return ((Integer) ipChange.ipc$dispatch("1356254570", new Object[]{this})).intValue();
        }
        return 0;
    }

    public int getBuType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-625968610") ? ((Integer) ipChange.ipc$dispatch("-625968610", new Object[]{this})).intValue() : this.buType;
    }

    public String getGmtCreate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-619619272") ? (String) ipChange.ipc$dispatch("-619619272", new Object[]{this}) : this.gmtCreate;
    }

    public String getGroupIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1717674522") ? (String) ipChange.ipc$dispatch("-1717674522", new Object[]{this}) : this.groupIcon;
    }

    public long getGroupId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1548210804") ? ((Long) ipChange.ipc$dispatch("-1548210804", new Object[]{this})).longValue() : this.groupId;
    }

    public String getMsgBody() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-633160623") ? (String) ipChange.ipc$dispatch("-633160623", new Object[]{this}) : this.msgBody;
    }

    public String getMsgTypeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-560791020") ? (String) ipChange.ipc$dispatch("-560791020", new Object[]{this}) : this.msgTypeName;
    }

    public int getUnBadgeReadCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "269802908")) {
            return ((Integer) ipChange.ipc$dispatch("269802908", new Object[]{this})).intValue();
        }
        if (TextUtils.isEmpty(this.unBadgeReadCount)) {
            return 0;
        }
        return Integer.parseInt(this.unBadgeReadCount);
    }

    public void setBuType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1450996668")) {
            ipChange.ipc$dispatch("-1450996668", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.buType = i;
        }
    }

    public void setGmtCreate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "301434174")) {
            ipChange.ipc$dispatch("301434174", new Object[]{this, str});
        } else {
            this.gmtCreate = str;
        }
    }

    public void setGroupIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "621459792")) {
            ipChange.ipc$dispatch("621459792", new Object[]{this, str});
        } else {
            this.groupIcon = str;
        }
    }

    public void setGroupId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773367200")) {
            ipChange.ipc$dispatch("1773367200", new Object[]{this, Long.valueOf(j)});
        } else {
            this.groupId = j;
        }
    }

    public void setMsgBody(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "230603589")) {
            ipChange.ipc$dispatch("230603589", new Object[]{this, str});
        } else {
            this.msgBody = str;
        }
    }

    public void setMsgTypeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790363618")) {
            ipChange.ipc$dispatch("1790363618", new Object[]{this, str});
        } else {
            this.msgTypeName = str;
        }
    }

    public void setUnBadgeReadCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656316839")) {
            ipChange.ipc$dispatch("656316839", new Object[]{this, str});
        } else {
            this.unBadgeReadCount = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235882335")) {
            ipChange.ipc$dispatch("-235882335", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.groupId);
        parcel.writeString(this.msgTypeName);
        parcel.writeString(this.msgBody);
        parcel.writeString(this.groupIcon);
        parcel.writeString(this.gmtCreate);
        parcel.writeString(this.unBadgeReadCount);
        parcel.writeInt(this.buType);
    }

    protected MessageGroupItem(Parcel parcel) {
        this.groupId = parcel.readLong();
        this.msgTypeName = parcel.readString();
        this.msgBody = parcel.readString();
        this.groupIcon = parcel.readString();
        this.gmtCreate = parcel.readString();
        this.unBadgeReadCount = parcel.readString();
        this.buType = parcel.readInt();
    }
}
