package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectStaticEnterpriseInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectStaticEnterpriseInfo> CREATOR = new Parcelable.Creator<ProjectStaticEnterpriseInfo>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticEnterpriseInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectStaticEnterpriseInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1958124811") ? (ProjectStaticEnterpriseInfo) ipChange.ipc$dispatch("1958124811", new Object[]{this, parcel}) : new ProjectStaticEnterpriseInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectStaticEnterpriseInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1264497074") ? (ProjectStaticEnterpriseInfo[]) ipChange.ipc$dispatch("1264497074", new Object[]{this, Integer.valueOf(i)}) : new ProjectStaticEnterpriseInfo[i];
        }
    };
    public String cpName;
    public String entAddress;
    public String entType;
    public String legalPerson;
    public String opFrom;
    public String opTo;
    public String regCapStr;
    public String socialCreditCode;

    public ProjectStaticEnterpriseInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653629919")) {
            return ((Integer) ipChange.ipc$dispatch("-653629919", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "140934147")) {
            ipChange.ipc$dispatch("140934147", new Object[]{this, parcel});
            return;
        }
        this.cpName = parcel.readString();
        this.socialCreditCode = parcel.readString();
        this.legalPerson = parcel.readString();
        this.regCapStr = parcel.readString();
        this.opFrom = parcel.readString();
        this.opTo = parcel.readString();
        this.entType = parcel.readString();
        this.entAddress = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733770038")) {
            ipChange.ipc$dispatch("-1733770038", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.cpName);
        parcel.writeString(this.socialCreditCode);
        parcel.writeString(this.legalPerson);
        parcel.writeString(this.regCapStr);
        parcel.writeString(this.opFrom);
        parcel.writeString(this.opTo);
        parcel.writeString(this.entType);
        parcel.writeString(this.entAddress);
    }

    protected ProjectStaticEnterpriseInfo(Parcel parcel) {
        this.cpName = parcel.readString();
        this.socialCreditCode = parcel.readString();
        this.legalPerson = parcel.readString();
        this.regCapStr = parcel.readString();
        this.opFrom = parcel.readString();
        this.opTo = parcel.readString();
        this.entType = parcel.readString();
        this.entAddress = parcel.readString();
    }
}
