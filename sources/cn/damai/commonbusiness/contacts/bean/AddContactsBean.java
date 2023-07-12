package cn.damai.commonbusiness.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AddContactsBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddContactsBean> CREATOR = new Parcelable.Creator<AddContactsBean>() { // from class: cn.damai.commonbusiness.contacts.bean.AddContactsBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddContactsBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "407226259") ? (AddContactsBean) ipChange.ipc$dispatch("407226259", new Object[]{this, parcel}) : new AddContactsBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddContactsBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "719392272") ? (AddContactsBean[]) ipChange.ipc$dispatch("719392272", new Object[]{this, Integer.valueOf(i)}) : new AddContactsBean[i];
        }
    };
    private String addCustomerFailToSmsLimit;
    private String displayIdentityNo;
    private String displayName;
    private String failedCount;
    private String identityHash;
    private String identityType;
    private String identityTypeName;
    private String lockState;
    private String maskedIdentityNo;
    private String maskedName;
    private String remainCount;
    private String touchLimit;

    public AddContactsBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3506211")) {
            return ((Integer) ipChange.ipc$dispatch("3506211", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getAddCustomerFailToSmsLimit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1266075631") ? (String) ipChange.ipc$dispatch("1266075631", new Object[]{this}) : this.addCustomerFailToSmsLimit;
    }

    public String getDisplayIdentityNo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "442230070") ? (String) ipChange.ipc$dispatch("442230070", new Object[]{this}) : this.displayIdentityNo;
    }

    public String getDisplayName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "146634658") ? (String) ipChange.ipc$dispatch("146634658", new Object[]{this}) : this.displayName;
    }

    public String getFailedCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-361076857") ? (String) ipChange.ipc$dispatch("-361076857", new Object[]{this}) : this.failedCount;
    }

    public String getIdentityHash() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1072328717") ? (String) ipChange.ipc$dispatch("1072328717", new Object[]{this}) : this.identityHash;
    }

    public String getIdentityType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1262972985") ? (String) ipChange.ipc$dispatch("1262972985", new Object[]{this}) : this.identityType;
    }

    public String getIdentityTypeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "646214756") ? (String) ipChange.ipc$dispatch("646214756", new Object[]{this}) : this.identityTypeName;
    }

    public String getLockState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-236122277") ? (String) ipChange.ipc$dispatch("-236122277", new Object[]{this}) : this.lockState;
    }

    public String getMaskedIdentityNo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-311150293") ? (String) ipChange.ipc$dispatch("-311150293", new Object[]{this}) : this.maskedIdentityNo;
    }

    public String getMaskedName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1506617175") ? (String) ipChange.ipc$dispatch("1506617175", new Object[]{this}) : this.maskedName;
    }

    public String getRemainCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "740047928") ? (String) ipChange.ipc$dispatch("740047928", new Object[]{this}) : this.remainCount;
    }

    public String getTouchLimit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "174021213") ? (String) ipChange.ipc$dispatch("174021213", new Object[]{this}) : this.touchLimit;
    }

    public void setAddCustomerFailToSmsLimit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030358937")) {
            ipChange.ipc$dispatch("-1030358937", new Object[]{this, str});
        } else {
            this.addCustomerFailToSmsLimit = str;
        }
    }

    public void setDisplayIdentityNo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1835225088")) {
            ipChange.ipc$dispatch("1835225088", new Object[]{this, str});
        } else {
            this.displayIdentityNo = str;
        }
    }

    public void setDisplayName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2049244140")) {
            ipChange.ipc$dispatch("-2049244140", new Object[]{this, str});
        } else {
            this.displayName = str;
        }
    }

    public void setFailedCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-608431921")) {
            ipChange.ipc$dispatch("-608431921", new Object[]{this, str});
        } else {
            this.failedCount = str;
        }
    }

    public void setIdentityHash(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719667087")) {
            ipChange.ipc$dispatch("-719667087", new Object[]{this, str});
        } else {
            this.identityHash = str;
        }
    }

    public void setIdentityType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "895337925")) {
            ipChange.ipc$dispatch("895337925", new Object[]{this, str});
        } else {
            this.identityType = str;
        }
    }

    public void setIdentityTypeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1680993530")) {
            ipChange.ipc$dispatch("1680993530", new Object[]{this, str});
        } else {
            this.identityTypeName = str;
        }
    }

    public void setLockState(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-695060869")) {
            ipChange.ipc$dispatch("-695060869", new Object[]{this, str});
        } else {
            this.lockState = str;
        }
    }

    public void setMaskedIdentityNo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2067448083")) {
            ipChange.ipc$dispatch("2067448083", new Object[]{this, str});
        } else {
            this.maskedIdentityNo = str;
        }
    }

    public void setMaskedName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1645576039")) {
            ipChange.ipc$dispatch("1645576039", new Object[]{this, str});
        } else {
            this.maskedName = str;
        }
    }

    public void setRemainCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-833301954")) {
            ipChange.ipc$dispatch("-833301954", new Object[]{this, str});
        } else {
            this.remainCount = str;
        }
    }

    public void setTouchLimit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010193119")) {
            ipChange.ipc$dispatch("-1010193119", new Object[]{this, str});
        } else {
            this.touchLimit = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493651704")) {
            ipChange.ipc$dispatch("-1493651704", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.addCustomerFailToSmsLimit);
        parcel.writeString(this.failedCount);
        parcel.writeString(this.identityHash);
        parcel.writeString(this.identityType);
        parcel.writeString(this.identityTypeName);
        parcel.writeString(this.lockState);
        parcel.writeString(this.maskedIdentityNo);
        parcel.writeString(this.maskedName);
        parcel.writeString(this.remainCount);
        parcel.writeString(this.touchLimit);
        parcel.writeString(this.displayName);
        parcel.writeString(this.displayIdentityNo);
    }

    protected AddContactsBean(Parcel parcel) {
        this.addCustomerFailToSmsLimit = parcel.readString();
        this.failedCount = parcel.readString();
        this.identityHash = parcel.readString();
        this.identityType = parcel.readString();
        this.identityTypeName = parcel.readString();
        this.lockState = parcel.readString();
        this.maskedIdentityNo = parcel.readString();
        this.maskedName = parcel.readString();
        this.remainCount = parcel.readString();
        this.touchLimit = parcel.readString();
        this.displayName = parcel.readString();
        this.displayIdentityNo = parcel.readString();
    }
}
