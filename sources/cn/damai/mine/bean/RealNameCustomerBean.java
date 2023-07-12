package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class RealNameCustomerBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameCustomerBean> CREATOR = new Parcelable.Creator<RealNameCustomerBean>() { // from class: cn.damai.mine.bean.RealNameCustomerBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealNameCustomerBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1234443495") ? (RealNameCustomerBean) ipChange.ipc$dispatch("-1234443495", new Object[]{this, parcel}) : new RealNameCustomerBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealNameCustomerBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1380215504") ? (RealNameCustomerBean[]) ipChange.ipc$dispatch("-1380215504", new Object[]{this, Integer.valueOf(i)}) : new RealNameCustomerBean[i];
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

    public RealNameCustomerBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1358338144")) {
            return ((Integer) ipChange.ipc$dispatch("1358338144", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getCreateSource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1304431637") ? (String) ipChange.ipc$dispatch("1304431637", new Object[]{this}) : this.createSource;
    }

    public String getIdentityHash() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "334851658") ? (String) ipChange.ipc$dispatch("334851658", new Object[]{this}) : this.identityHash;
    }

    public String getIdentityNo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-81441859") ? (String) ipChange.ipc$dispatch("-81441859", new Object[]{this}) : this.identityNo;
    }

    public String getIdentityType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "525495926") ? (String) ipChange.ipc$dispatch("525495926", new Object[]{this}) : this.identityType;
    }

    public String getIdentityTypeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-465826783") ? (String) ipChange.ipc$dispatch("-465826783", new Object[]{this}) : this.identityTypeName;
    }

    public String getIsUserVerified() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1952255461") ? (String) ipChange.ipc$dispatch("-1952255461", new Object[]{this}) : this.isUserVerified;
    }

    public String getMaskedIdentityNo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1423191832") ? (String) ipChange.ipc$dispatch("-1423191832", new Object[]{this}) : this.maskedIdentityNo;
    }

    public String getMaskedName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1072918316") ? (String) ipChange.ipc$dispatch("-1072918316", new Object[]{this}) : this.maskedName;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2082213737") ? (String) ipChange.ipc$dispatch("2082213737", new Object[]{this}) : this.name;
    }

    public String getVerifyStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1700300887") ? (String) ipChange.ipc$dispatch("-1700300887", new Object[]{this}) : this.verifyStatus;
    }

    public void setCreateSource(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114411159")) {
            ipChange.ipc$dispatch("-2114411159", new Object[]{this, str});
        } else {
            this.createSource = str;
        }
    }

    public void setIdentityHash(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2106619436")) {
            ipChange.ipc$dispatch("-2106619436", new Object[]{this, str});
        } else {
            this.identityHash = str;
        }
    }

    public void setIdentityNo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339613759")) {
            ipChange.ipc$dispatch("-339613759", new Object[]{this, str});
        } else {
            this.identityNo = str;
        }
    }

    public void setIdentityType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491614424")) {
            ipChange.ipc$dispatch("-491614424", new Object[]{this, str});
        } else {
            this.identityType = str;
        }
    }

    public void setIdentityTypeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567444189")) {
            ipChange.ipc$dispatch("1567444189", new Object[]{this, str});
        } else {
            this.identityTypeName = str;
        }
    }

    public void setIsUserVerified(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "492516131")) {
            ipChange.ipc$dispatch("492516131", new Object[]{this, str});
        } else {
            this.isUserVerified = str;
        }
    }

    public void setMaskedIdentityNo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953898742")) {
            ipChange.ipc$dispatch("1953898742", new Object[]{this, str});
        } else {
            this.maskedIdentityNo = str;
        }
    }

    public void setMaskedName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010612854")) {
            ipChange.ipc$dispatch("-1010612854", new Object[]{this, str});
        } else {
            this.maskedName = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168640363")) {
            ipChange.ipc$dispatch("-168640363", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setVerifyStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771838891")) {
            ipChange.ipc$dispatch("-771838891", new Object[]{this, str});
        } else {
            this.verifyStatus = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1414363243")) {
            ipChange.ipc$dispatch("1414363243", new Object[]{this, parcel, Integer.valueOf(i)});
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

    protected RealNameCustomerBean(Parcel parcel) {
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
