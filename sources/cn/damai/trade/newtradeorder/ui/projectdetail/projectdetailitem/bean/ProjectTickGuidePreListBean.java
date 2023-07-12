package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectTickGuidePreListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectTickGuidePreListBean> CREATOR = new Parcelable.Creator<ProjectTickGuidePreListBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuidePreListBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectTickGuidePreListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "495675435") ? (ProjectTickGuidePreListBean) ipChange.ipc$dispatch("495675435", new Object[]{this, parcel}) : new ProjectTickGuidePreListBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectTickGuidePreListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1196568312") ? (ProjectTickGuidePreListBean[]) ipChange.ipc$dispatch("-1196568312", new Object[]{this, Integer.valueOf(i)}) : new ProjectTickGuidePreListBean[i];
        }
    };
    public String title;
    public List<ProjectTickGuidePreBean> tpgPreparationList;

    public ProjectTickGuidePreListBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-944565514")) {
            return ((Integer) ipChange.ipc$dispatch("-944565514", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615772821")) {
            ipChange.ipc$dispatch("1615772821", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeTypedList(this.tpgPreparationList);
    }

    protected ProjectTickGuidePreListBean(Parcel parcel) {
        this.title = parcel.readString();
        this.tpgPreparationList = parcel.createTypedArrayList(ProjectTickGuidePreBean.CREATOR);
    }
}
