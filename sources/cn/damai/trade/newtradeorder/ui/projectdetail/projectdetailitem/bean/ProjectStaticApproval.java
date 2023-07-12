package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectStaticApproval implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectStaticApproval> CREATOR = new Parcelable.Creator<ProjectStaticApproval>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticApproval.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectStaticApproval createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1764295691") ? (ProjectStaticApproval) ipChange.ipc$dispatch("1764295691", new Object[]{this, parcel}) : new ProjectStaticApproval(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectStaticApproval[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "488969162") ? (ProjectStaticApproval[]) ipChange.ipc$dispatch("488969162", new Object[]{this, Integer.valueOf(i)}) : new ProjectStaticApproval[i];
        }
    };
    public List<String> approvalAuthorizationUrlList;
    public List<String> approvalUrlList;
    public ProjectStaticEnterpriseInfo enterpriseInfo;

    public ProjectStaticApproval() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "766992885")) {
            return ((Integer) ipChange.ipc$dispatch("766992885", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-222420305")) {
            ipChange.ipc$dispatch("-222420305", new Object[]{this, parcel});
            return;
        }
        this.approvalUrlList = parcel.createStringArrayList();
        this.approvalAuthorizationUrlList = parcel.createStringArrayList();
        this.enterpriseInfo = (ProjectStaticEnterpriseInfo) parcel.readParcelable(ProjectStaticEnterpriseInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097124490")) {
            ipChange.ipc$dispatch("-2097124490", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeStringList(this.approvalUrlList);
        parcel.writeStringList(this.approvalAuthorizationUrlList);
        parcel.writeParcelable(this.enterpriseInfo, i);
    }

    protected ProjectStaticApproval(Parcel parcel) {
        this.approvalUrlList = parcel.createStringArrayList();
        this.approvalAuthorizationUrlList = parcel.createStringArrayList();
        this.enterpriseInfo = (ProjectStaticEnterpriseInfo) parcel.readParcelable(ProjectStaticEnterpriseInfo.class.getClassLoader());
    }
}
