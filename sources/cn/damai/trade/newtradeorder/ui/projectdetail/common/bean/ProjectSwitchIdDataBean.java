package cn.damai.trade.newtradeorder.ui.projectdetail.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectSwitchIdDataBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectSwitchIdResultBean data;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class ProjectSwitchIdResultBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ProjectSwitchIdResultBean> CREATOR = new Parcelable.Creator<ProjectSwitchIdResultBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ProjectSwitchIdDataBean.ProjectSwitchIdResultBean.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ProjectSwitchIdResultBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "839013565") ? (ProjectSwitchIdResultBean) ipChange.ipc$dispatch("839013565", new Object[]{this, parcel}) : new ProjectSwitchIdResultBean(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ProjectSwitchIdResultBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-177965200") ? (ProjectSwitchIdResultBean[]) ipChange.ipc$dispatch("-177965200", new Object[]{this, Integer.valueOf(i)}) : new ProjectSwitchIdResultBean[i];
            }
        };
        public String result;

        public ProjectSwitchIdResultBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1073121358")) {
                return ((Integer) ipChange.ipc$dispatch("1073121358", new Object[]{this})).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1424597565")) {
                ipChange.ipc$dispatch("1424597565", new Object[]{this, parcel, Integer.valueOf(i)});
            } else {
                parcel.writeString(this.result);
            }
        }

        protected ProjectSwitchIdResultBean(Parcel parcel) {
            this.result = parcel.readString();
        }
    }

    public void setData(ProjectSwitchIdResultBean projectSwitchIdResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162587471")) {
            ipChange.ipc$dispatch("162587471", new Object[]{this, projectSwitchIdResultBean});
        } else {
            this.data = projectSwitchIdResultBean;
        }
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public ProjectSwitchIdResultBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-575669623") ? (ProjectSwitchIdResultBean) ipChange.ipc$dispatch("-575669623", new Object[]{this}) : this.data;
    }
}
