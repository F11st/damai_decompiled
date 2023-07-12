package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentTargetDataBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentTargetDataBean> CREATOR = new Parcelable.Creator<CommentTargetDataBean>() { // from class: cn.damai.comment.bean.CommentTargetDataBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentTargetDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1111483351") ? (CommentTargetDataBean) ipChange.ipc$dispatch("1111483351", new Object[]{this, parcel}) : new CommentTargetDataBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentTargetDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "209305232") ? (CommentTargetDataBean[]) ipChange.ipc$dispatch("209305232", new Object[]{this, Integer.valueOf(i)}) : new CommentTargetDataBean[i];
        }
    };
    private String targetCityName;
    private String targetDataType;
    private String targetDesc;
    private String targetId;
    private String targetImg;
    private String targetName;
    private String targetPlace;
    private String targetShowTime;
    private String viewStatus;

    public CommentTargetDataBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386873599")) {
            return ((Integer) ipChange.ipc$dispatch("-386873599", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getTargetCityName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-155075898") ? (String) ipChange.ipc$dispatch("-155075898", new Object[]{this}) : this.targetCityName;
    }

    public String getTargetDataType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "683928372") ? (String) ipChange.ipc$dispatch("683928372", new Object[]{this}) : this.targetDataType;
    }

    public String getTargetDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1695838783") ? (String) ipChange.ipc$dispatch("-1695838783", new Object[]{this}) : this.targetDesc;
    }

    public String getTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1913825419") ? (String) ipChange.ipc$dispatch("1913825419", new Object[]{this}) : this.targetId;
    }

    public String getTargetImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "171747721") ? (String) ipChange.ipc$dispatch("171747721", new Object[]{this}) : this.targetImg;
    }

    public String getTargetName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1011108027") ? (String) ipChange.ipc$dispatch("1011108027", new Object[]{this}) : this.targetName;
    }

    public String getTargetPlace() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "124562957") ? (String) ipChange.ipc$dispatch("124562957", new Object[]{this}) : this.targetPlace;
    }

    public String getTargetShowTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-227014246") ? (String) ipChange.ipc$dispatch("-227014246", new Object[]{this}) : this.targetShowTime;
    }

    public String getViewStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-610282378") ? (String) ipChange.ipc$dispatch("-610282378", new Object[]{this}) : this.viewStatus;
    }

    public void setTargetCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370507736")) {
            ipChange.ipc$dispatch("370507736", new Object[]{this, str});
        } else {
            this.targetCityName = str;
        }
    }

    public void setTargetDataType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "609836330")) {
            ipChange.ipc$dispatch("609836330", new Object[]{this, str});
        } else {
            this.targetDataType = str;
        }
    }

    public void setTargetDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1153689149")) {
            ipChange.ipc$dispatch("1153689149", new Object[]{this, str});
        } else {
            this.targetDesc = str;
        }
    }

    public void setTargetId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683281997")) {
            ipChange.ipc$dispatch("-683281997", new Object[]{this, str});
        } else {
            this.targetId = str;
        }
    }

    public void setTargetImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-935992819")) {
            ipChange.ipc$dispatch("-935992819", new Object[]{this, str});
        } else {
            this.targetImg = str;
        }
    }

    public void setTargetName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-830305661")) {
            ipChange.ipc$dispatch("-830305661", new Object[]{this, str});
        } else {
            this.targetName = str;
        }
    }

    public void setTargetPlace(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561500425")) {
            ipChange.ipc$dispatch("1561500425", new Object[]{this, str});
        } else {
            this.targetPlace = str;
        }
    }

    public void setTargetShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859581052")) {
            ipChange.ipc$dispatch("-1859581052", new Object[]{this, str});
        } else {
            this.targetShowTime = str;
        }
    }

    public void setViewStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "446199336")) {
            ipChange.ipc$dispatch("446199336", new Object[]{this, str});
        } else {
            this.viewStatus = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173635050")) {
            ipChange.ipc$dispatch("1173635050", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.targetId);
        parcel.writeString(this.targetDataType);
        parcel.writeString(this.targetImg);
        parcel.writeString(this.targetName);
        parcel.writeString(this.targetCityName);
        parcel.writeString(this.targetShowTime);
        parcel.writeString(this.targetDesc);
        parcel.writeString(this.viewStatus);
        parcel.writeString(this.targetPlace);
    }

    protected CommentTargetDataBean(Parcel parcel) {
        this.targetId = parcel.readString();
        this.targetDataType = parcel.readString();
        this.targetImg = parcel.readString();
        this.targetName = parcel.readString();
        this.targetCityName = parcel.readString();
        this.targetShowTime = parcel.readString();
        this.targetDesc = parcel.readString();
        this.viewStatus = parcel.readString();
        this.targetPlace = parcel.readString();
    }
}
