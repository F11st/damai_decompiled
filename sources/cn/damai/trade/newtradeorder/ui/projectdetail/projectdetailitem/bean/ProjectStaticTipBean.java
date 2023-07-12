package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectStaticTipBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectStaticTipBean> CREATOR = new Parcelable.Creator<ProjectStaticTipBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticTipBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectStaticTipBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1561471435") ? (ProjectStaticTipBean) ipChange.ipc$dispatch("1561471435", new Object[]{this, parcel}) : new ProjectStaticTipBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectStaticTipBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "17446928") ? (ProjectStaticTipBean[]) ipChange.ipc$dispatch("17446928", new Object[]{this, Integer.valueOf(i)}) : new ProjectStaticTipBean[i];
        }
    };
    private String description;
    private String name;

    public ProjectStaticTipBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525935993")) {
            return ((Integer) ipChange.ipc$dispatch("-1525935993", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getDescription() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1121051341") ? (String) ipChange.ipc$dispatch("1121051341", new Object[]{this}) : this.description;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1784254320") ? (String) ipChange.ipc$dispatch("-1784254320", new Object[]{this}) : this.name;
    }

    public void setDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907098039")) {
            ipChange.ipc$dispatch("-1907098039", new Object[]{this, str});
        } else {
            this.description = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "229934158")) {
            ipChange.ipc$dispatch("229934158", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1628468004")) {
            ipChange.ipc$dispatch("1628468004", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.name);
        parcel.writeString(this.description);
    }

    protected ProjectStaticTipBean(Parcel parcel) {
        this.name = parcel.readString();
        this.description = parcel.readString();
    }
}
