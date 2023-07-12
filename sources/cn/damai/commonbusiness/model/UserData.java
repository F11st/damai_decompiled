package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class UserData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<UserData> CREATOR = new Parcelable.Creator<UserData>() { // from class: cn.damai.commonbusiness.model.UserData.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "105739467") ? (UserData) ipChange.ipc$dispatch("105739467", new Object[]{this, parcel}) : new UserData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-499140378") ? (UserData[]) ipChange.ipc$dispatch("-499140378", new Object[]{this, Integer.valueOf(i)}) : new UserData[i];
        }
    };
    private CertificationInfoBean certificationBaseInfo;
    private UserMemberInfo memberInfo;
    private UserBaseInfoBean userBaseInfo;

    protected UserData(Parcel parcel) {
        this.certificationBaseInfo = (CertificationInfoBean) parcel.readParcelable(CertificationInfoBean.class.getClassLoader());
        this.userBaseInfo = (UserBaseInfoBean) parcel.readParcelable(UserBaseInfoBean.class.getClassLoader());
        this.memberInfo = (UserMemberInfo) parcel.readParcelable(UserMemberInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885770087")) {
            return ((Integer) ipChange.ipc$dispatch("1885770087", new Object[]{this})).intValue();
        }
        return 0;
    }

    public CertificationInfoBean getCertificationBaseInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1109887614") ? (CertificationInfoBean) ipChange.ipc$dispatch("1109887614", new Object[]{this}) : this.certificationBaseInfo;
    }

    public UserMemberInfo getMemberInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1019838896") ? (UserMemberInfo) ipChange.ipc$dispatch("1019838896", new Object[]{this}) : this.memberInfo;
    }

    public UserBaseInfoBean getUserBaseInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1954670827") ? (UserBaseInfoBean) ipChange.ipc$dispatch("1954670827", new Object[]{this}) : this.userBaseInfo;
    }

    public void setCertificationBaseInfo(CertificationInfoBean certificationInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62514454")) {
            ipChange.ipc$dispatch("62514454", new Object[]{this, certificationInfoBean});
        } else {
            this.certificationBaseInfo = certificationInfoBean;
        }
    }

    public void setMemberInfo(UserMemberInfo userMemberInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958177452")) {
            ipChange.ipc$dispatch("-958177452", new Object[]{this, userMemberInfo});
        } else {
            this.memberInfo = userMemberInfo;
        }
    }

    public void setUserBaseInfo(UserBaseInfoBean userBaseInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1690440565")) {
            ipChange.ipc$dispatch("-1690440565", new Object[]{this, userBaseInfoBean});
        } else {
            this.userBaseInfo = userBaseInfoBean;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1705758276")) {
            ipChange.ipc$dispatch("1705758276", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.certificationBaseInfo, i);
        parcel.writeParcelable(this.userBaseInfo, i);
        parcel.writeParcelable(this.memberInfo, i);
    }

    public UserData() {
    }
}
