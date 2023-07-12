package cn.damai.trade.newtradeorder.ui.projectdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PrivilegeVerifyBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PrivilegeVerifyBean> CREATOR = new Parcelable.Creator<PrivilegeVerifyBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.bean.PrivilegeVerifyBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivilegeVerifyBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1465928885") ? (PrivilegeVerifyBean) ipChange.ipc$dispatch("-1465928885", new Object[]{this, parcel}) : new PrivilegeVerifyBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivilegeVerifyBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1996576590") ? (PrivilegeVerifyBean[]) ipChange.ipc$dispatch("1996576590", new Object[]{this, Integer.valueOf(i)}) : new PrivilegeVerifyBean[i];
        }
    };
    private String failedCode;
    private String failedMsg;
    private String successActivityId;
    private String verifiedSuccess;

    public PrivilegeVerifyBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2136520371")) {
            return ((Integer) ipChange.ipc$dispatch("2136520371", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getFailedCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1071998459") ? (String) ipChange.ipc$dispatch("1071998459", new Object[]{this}) : this.failedCode;
    }

    public String getFailedMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1048728663") ? (String) ipChange.ipc$dispatch("-1048728663", new Object[]{this}) : this.failedMsg;
    }

    public String getSuccessActivityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1110149614") ? (String) ipChange.ipc$dispatch("-1110149614", new Object[]{this}) : this.successActivityId;
    }

    public String getVerifiedSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "524591296") ? (String) ipChange.ipc$dispatch("524591296", new Object[]{this}) : this.verifiedSuccess;
    }

    public void setFailedCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1057297731")) {
            ipChange.ipc$dispatch("1057297731", new Object[]{this, str});
        } else {
            this.failedCode = str;
        }
    }

    public void setFailedMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-116055059")) {
            ipChange.ipc$dispatch("-116055059", new Object[]{this, str});
        } else {
            this.failedMsg = str;
        }
    }

    public void setSuccessActivityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "956095140")) {
            ipChange.ipc$dispatch("956095140", new Object[]{this, str});
        } else {
            this.successActivityId = str;
        }
    }

    public void setVerifiedSuccess(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-635725642")) {
            ipChange.ipc$dispatch("-635725642", new Object[]{this, str});
        } else {
            this.verifiedSuccess = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240951416")) {
            ipChange.ipc$dispatch("1240951416", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.verifiedSuccess);
        parcel.writeString(this.successActivityId);
        parcel.writeString(this.failedCode);
        parcel.writeString(this.failedMsg);
    }

    protected PrivilegeVerifyBean(Parcel parcel) {
        this.verifiedSuccess = parcel.readString();
        this.successActivityId = parcel.readString();
        this.failedCode = parcel.readString();
        this.failedMsg = parcel.readString();
    }
}
