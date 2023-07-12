package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CustomerBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CustomerBean> CREATOR = new Parcelable.Creator<CustomerBean>() { // from class: cn.damai.mine.bean.CustomerBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomerBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1051393131") ? (CustomerBean) ipChange.ipc$dispatch("1051393131", new Object[]{this, parcel}) : new CustomerBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomerBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2062434896") ? (CustomerBean[]) ipChange.ipc$dispatch("2062434896", new Object[]{this, Integer.valueOf(i)}) : new CustomerBean[i];
        }
    };
    private String createSource;
    private String identityHash;
    private String identityNo;
    private String identityType;
    private String identityTypeName;
    private String isUserVerified;
    private String maskedIdentityNo;
    private String maskedName;
    private String name;
    private String verifyStatus;

    public CustomerBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "496629559")) {
            return ((Integer) ipChange.ipc$dispatch("496629559", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getCreateSource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1836000020") ? (String) ipChange.ipc$dispatch("-1836000020", new Object[]{this}) : this.createSource;
    }

    public String getIdentityHash() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1489387297") ? (String) ipChange.ipc$dispatch("1489387297", new Object[]{this}) : this.identityHash;
    }

    public String getIdentityNo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1993500244") ? (String) ipChange.ipc$dispatch("1993500244", new Object[]{this}) : this.identityNo;
    }

    public String getIdentityType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1680031565") ? (String) ipChange.ipc$dispatch("1680031565", new Object[]{this}) : this.identityType;
    }

    public String getIdentityTypeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1074095752") ? (String) ipChange.ipc$dispatch("-1074095752", new Object[]{this}) : this.identityTypeName;
    }

    public String getIsUserVerified() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-545068750") ? (String) ipChange.ipc$dispatch("-545068750", new Object[]{this}) : this.isUserVerified;
    }

    public String getMaskedIdentityNo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2031460801") ? (String) ipChange.ipc$dispatch("-2031460801", new Object[]{this}) : this.maskedIdentityNo;
    }

    public String getMaskedName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1002023787") ? (String) ipChange.ipc$dispatch("1002023787", new Object[]{this}) : this.maskedName;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1678072000") ? (String) ipChange.ipc$dispatch("-1678072000", new Object[]{this}) : this.name;
    }

    public String getVerifyStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-545765248") ? (String) ipChange.ipc$dispatch("-545765248", new Object[]{this}) : this.verifyStatus;
    }

    public void setCreateSource(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683544718")) {
            ipChange.ipc$dispatch("-683544718", new Object[]{this, str});
        } else {
            this.createSource = str;
        }
    }

    public void setIdentityHash(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-675752995")) {
            ipChange.ipc$dispatch("-675752995", new Object[]{this, str});
        } else {
            this.identityHash = str;
        }
    }

    public void setIdentityNo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-440918006")) {
            ipChange.ipc$dispatch("-440918006", new Object[]{this, str});
        } else {
            this.identityNo = str;
        }
    }

    public void setIdentityType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939252017")) {
            ipChange.ipc$dispatch("939252017", new Object[]{this, str});
        } else {
            this.identityType = str;
        }
    }

    public void setIdentityTypeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109024666")) {
            ipChange.ipc$dispatch("-109024666", new Object[]{this, str});
        } else {
            this.identityTypeName = str;
        }
    }

    public void setIsUserVerified(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165631212")) {
            ipChange.ipc$dispatch("1165631212", new Object[]{this, str});
        } else {
            this.isUserVerified = str;
        }
    }

    public void setMaskedIdentityNo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "277429887")) {
            ipChange.ipc$dispatch("277429887", new Object[]{this, str});
        } else {
            this.maskedIdentityNo = str;
        }
    }

    public void setMaskedName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111917101")) {
            ipChange.ipc$dispatch("-1111917101", new Object[]{this, str});
        } else {
            this.maskedName = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-773381218")) {
            ipChange.ipc$dispatch("-773381218", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setVerifyStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "659027550")) {
            ipChange.ipc$dispatch("659027550", new Object[]{this, str});
        } else {
            this.verifyStatus = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1449737612")) {
            ipChange.ipc$dispatch("-1449737612", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.createSource);
        parcel.writeString(this.identityHash);
        parcel.writeString(this.identityNo);
        parcel.writeString(this.identityType);
        parcel.writeString(this.identityTypeName);
        parcel.writeString(this.isUserVerified);
        parcel.writeString(this.maskedIdentityNo);
        parcel.writeString(this.maskedName);
        parcel.writeString(this.name);
        parcel.writeString(this.verifyStatus);
    }

    protected CustomerBean(Parcel parcel) {
        this.createSource = parcel.readString();
        this.identityHash = parcel.readString();
        this.identityNo = parcel.readString();
        this.identityType = parcel.readString();
        this.identityTypeName = parcel.readString();
        this.isUserVerified = parcel.readString();
        this.maskedIdentityNo = parcel.readString();
        this.maskedName = parcel.readString();
        this.name = parcel.readString();
        this.verifyStatus = parcel.readString();
    }
}
