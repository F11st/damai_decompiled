package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectTickGuidePreBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectTickGuidePreBean> CREATOR = new Parcelable.Creator<ProjectTickGuidePreBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuidePreBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectTickGuidePreBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1130205717") ? (ProjectTickGuidePreBean) ipChange.ipc$dispatch("-1130205717", new Object[]{this, parcel}) : new ProjectTickGuidePreBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectTickGuidePreBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "171775364") ? (ProjectTickGuidePreBean[]) ipChange.ipc$dispatch("171775364", new Object[]{this, Integer.valueOf(i)}) : new ProjectTickGuidePreBean[i];
        }
    };
    public String calendarRemindTitle;
    public String desc;
    public String name;
    public ArrayList<String> preFillCheckList;
    public String projectId;
    public long sellStartTime;
    public String title;
    public boolean visEmail;

    public ProjectTickGuidePreBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-860073928")) {
            return ((Integer) ipChange.ipc$dispatch("-860073928", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591962515")) {
            ipChange.ipc$dispatch("1591962515", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeStringList(this.preFillCheckList);
    }

    protected ProjectTickGuidePreBean(Parcel parcel) {
        this.name = parcel.readString();
        this.title = parcel.readString();
        this.desc = parcel.readString();
        this.preFillCheckList = parcel.createStringArrayList();
    }
}
