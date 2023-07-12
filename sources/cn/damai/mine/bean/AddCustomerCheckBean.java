package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AddCustomerCheckBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddCustomerCheckBean> CREATOR = new Parcelable.Creator<AddCustomerCheckBean>() { // from class: cn.damai.mine.bean.AddCustomerCheckBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddCustomerCheckBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "340054357") ? (AddCustomerCheckBean) ipChange.ipc$dispatch("340054357", new Object[]{this, parcel}) : new AddCustomerCheckBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddCustomerCheckBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1145363728") ? (AddCustomerCheckBean[]) ipChange.ipc$dispatch("-1145363728", new Object[]{this, Integer.valueOf(i)}) : new AddCustomerCheckBean[i];
        }
    };
    private String addCustomerFailToSmsLimit;
    private String failedCount;
    private String lockState;
    private String remainCount;
    private String showPhone;
    private String touchLimit;

    public AddCustomerCheckBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632592450")) {
            return ((Integer) ipChange.ipc$dispatch("1632592450", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getAddCustomerFailToSmsLimit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-781652432") ? (String) ipChange.ipc$dispatch("-781652432", new Object[]{this}) : this.addCustomerFailToSmsLimit;
    }

    public String getFailedCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "717890440") ? (String) ipChange.ipc$dispatch("717890440", new Object[]{this}) : this.failedCount;
    }

    public String getLockState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "122541980") ? (String) ipChange.ipc$dispatch("122541980", new Object[]{this}) : this.lockState;
    }

    public String getRemainCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1819015225") ? (String) ipChange.ipc$dispatch("1819015225", new Object[]{this}) : this.remainCount;
    }

    public String getShowPhone() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-474809753") ? (String) ipChange.ipc$dispatch("-474809753", new Object[]{this}) : this.showPhone;
    }

    public String getTouchLimit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1592288708") ? (String) ipChange.ipc$dispatch("-1592288708", new Object[]{this}) : this.touchLimit;
    }

    public void setAddCustomerFailToSmsLimit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-85419450")) {
            ipChange.ipc$dispatch("-85419450", new Object[]{this, str});
        } else {
            this.addCustomerFailToSmsLimit = str;
        }
    }

    public void setFailedCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1520184082")) {
            ipChange.ipc$dispatch("-1520184082", new Object[]{this, str});
        } else {
            this.failedCount = str;
        }
    }

    public void setLockState(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1833596506")) {
            ipChange.ipc$dispatch("1833596506", new Object[]{this, str});
        } else {
            this.lockState = str;
        }
    }

    public void setRemainCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1745054115")) {
            ipChange.ipc$dispatch("-1745054115", new Object[]{this, str});
        } else {
            this.remainCount = str;
        }
    }

    public void setShowPhone(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495561967")) {
            ipChange.ipc$dispatch("495561967", new Object[]{this, str});
        } else {
            this.showPhone = str;
        }
    }

    public void setTouchLimit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "68774178")) {
            ipChange.ipc$dispatch("68774178", new Object[]{this, str});
        } else {
            this.touchLimit = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306802377")) {
            ipChange.ipc$dispatch("306802377", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.addCustomerFailToSmsLimit);
        parcel.writeString(this.failedCount);
        parcel.writeString(this.lockState);
        parcel.writeString(this.remainCount);
        parcel.writeString(this.showPhone);
        parcel.writeString(this.touchLimit);
    }

    protected AddCustomerCheckBean(Parcel parcel) {
        this.addCustomerFailToSmsLimit = parcel.readString();
        this.failedCount = parcel.readString();
        this.lockState = parcel.readString();
        this.remainCount = parcel.readString();
        this.showPhone = parcel.readString();
        this.touchLimit = parcel.readString();
    }
}
