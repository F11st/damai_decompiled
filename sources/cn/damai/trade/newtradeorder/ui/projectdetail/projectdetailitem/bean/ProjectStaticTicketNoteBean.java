package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectStaticTicketNoteBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectStaticTicketNoteBean> CREATOR = new Parcelable.Creator<ProjectStaticTicketNoteBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticTicketNoteBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectStaticTicketNoteBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1289941397") ? (ProjectStaticTicketNoteBean) ipChange.ipc$dispatch("-1289941397", new Object[]{this, parcel}) : new ProjectStaticTicketNoteBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectStaticTicketNoteBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1371878068") ? (ProjectStaticTicketNoteBean[]) ipChange.ipc$dispatch("1371878068", new Object[]{this, Integer.valueOf(i)}) : new ProjectStaticTicketNoteBean[i];
        }
    };
    private String content;
    private String title;

    public ProjectStaticTicketNoteBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617604320")) {
            return ((Integer) ipChange.ipc$dispatch("-617604320", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "581923217") ? (String) ipChange.ipc$dispatch("581923217", new Object[]{this}) : this.content;
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2078684880") ? (String) ipChange.ipc$dispatch("-2078684880", new Object[]{this}) : this.title;
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756503035")) {
            ipChange.ipc$dispatch("-756503035", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1818321594")) {
            ipChange.ipc$dispatch("-1818321594", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-445526613")) {
            ipChange.ipc$dispatch("-445526613", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeString(this.content);
    }

    protected ProjectStaticTicketNoteBean(Parcel parcel) {
        this.title = parcel.readString();
        this.content = parcel.readString();
    }
}
