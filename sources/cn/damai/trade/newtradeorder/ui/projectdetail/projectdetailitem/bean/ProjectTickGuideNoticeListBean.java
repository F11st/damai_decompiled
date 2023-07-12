package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectTickGuideNoticeListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectTickGuideNoticeListBean> CREATOR = new Parcelable.Creator<ProjectTickGuideNoticeListBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuideNoticeListBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectTickGuideNoticeListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1917560635") ? (ProjectTickGuideNoticeListBean) ipChange.ipc$dispatch("1917560635", new Object[]{this, parcel}) : new ProjectTickGuideNoticeListBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectTickGuideNoticeListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1193056048") ? (ProjectTickGuideNoticeListBean[]) ipChange.ipc$dispatch("-1193056048", new Object[]{this, Integer.valueOf(i)}) : new ProjectTickGuideNoticeListBean[i];
        }
    };
    public List<ProjectTickGuideNoticeBean> noticeModules;
    public String title;

    public ProjectTickGuideNoticeListBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464970289")) {
            return ((Integer) ipChange.ipc$dispatch("-1464970289", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1290021084")) {
            ipChange.ipc$dispatch("1290021084", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeTypedList(this.noticeModules);
    }

    protected ProjectTickGuideNoticeListBean(Parcel parcel) {
        this.title = parcel.readString();
        this.noticeModules = parcel.createTypedArrayList(ProjectTickGuideNoticeBean.CREATOR);
    }
}
