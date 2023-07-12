package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.servicenotice.TicketNoteList;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class NoticeMatter implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<NoticeMatter> CREATOR = new Parcelable.Creator<NoticeMatter>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.NoticeMatter.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoticeMatter createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1855811295") ? (NoticeMatter) ipChange.ipc$dispatch("-1855811295", new Object[]{this, parcel}) : new NoticeMatter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoticeMatter[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1569711408") ? (NoticeMatter[]) ipChange.ipc$dispatch("1569711408", new Object[]{this, Integer.valueOf(i)}) : new NoticeMatter[i];
        }
    };
    private List<TicketNoteList> noticeList;
    private String title;

    public NoticeMatter() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1746752388")) {
            return ((Integer) ipChange.ipc$dispatch("-1746752388", new Object[]{this})).intValue();
        }
        return 0;
    }

    public List<TicketNoteList> getNoticeList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1926835337") ? (List) ipChange.ipc$dispatch("-1926835337", new Object[]{this}) : this.noticeList;
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1394540372") ? (String) ipChange.ipc$dispatch("1394540372", new Object[]{this}) : this.title;
    }

    public void setNoticeList(List<TicketNoteList> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420865589")) {
            ipChange.ipc$dispatch("1420865589", new Object[]{this, list});
        } else {
            this.noticeList = list;
        }
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522521182")) {
            ipChange.ipc$dispatch("-1522521182", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "679518159")) {
            ipChange.ipc$dispatch("679518159", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeTypedList(this.noticeList);
    }

    protected NoticeMatter(Parcel parcel) {
        this.title = parcel.readString();
        this.noticeList = parcel.createTypedArrayList(TicketNoteList.CREATOR);
    }
}
