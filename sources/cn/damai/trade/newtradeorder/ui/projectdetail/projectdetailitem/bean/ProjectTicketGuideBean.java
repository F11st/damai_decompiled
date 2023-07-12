package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectTicketGuideBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectTicketGuideBean> CREATOR = new Parcelable.Creator<ProjectTicketGuideBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTicketGuideBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectTicketGuideBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "487271749") ? (ProjectTicketGuideBean) ipChange.ipc$dispatch("487271749", new Object[]{this, parcel}) : new ProjectTicketGuideBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectTicketGuideBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1677172208") ? (ProjectTicketGuideBean[]) ipChange.ipc$dispatch("1677172208", new Object[]{this, Integer.valueOf(i)}) : new ProjectTicketGuideBean[i];
        }
    };
    public String headerImageUrl;
    public String purchaseGuideUrl;
    public String tpgBottomText;
    public ProjectTickGuideNoticeListBean tpgNotice;
    public ProjectTickGuidePreListBean tpgPreparation;

    public ProjectTicketGuideBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "14202378")) {
            return ((Integer) ipChange.ipc$dispatch("14202378", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "875111425")) {
            ipChange.ipc$dispatch("875111425", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.headerImageUrl);
        parcel.writeParcelable(this.tpgPreparation, i);
        parcel.writeParcelable(this.tpgNotice, i);
        parcel.writeString(this.tpgBottomText);
        parcel.writeString(this.purchaseGuideUrl);
    }

    protected ProjectTicketGuideBean(Parcel parcel) {
        this.headerImageUrl = parcel.readString();
        this.tpgPreparation = (ProjectTickGuidePreListBean) parcel.readParcelable(ProjectTickGuidePreBean.class.getClassLoader());
        this.tpgNotice = (ProjectTickGuideNoticeListBean) parcel.readParcelable(ProjectTickGuideNoticeListBean.class.getClassLoader());
        this.tpgBottomText = parcel.readString();
        this.purchaseGuideUrl = parcel.readString();
    }
}
