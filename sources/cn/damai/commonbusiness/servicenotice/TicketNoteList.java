package cn.damai.commonbusiness.servicenotice;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TicketNoteList implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<TicketNoteList> CREATOR = new C0871a();
    private String noteTitle;
    private List<TicketNote> ticketNoteList;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.servicenotice.TicketNoteList$a */
    /* loaded from: classes.dex */
    public class C0871a implements Parcelable.Creator<TicketNoteList> {
        private static transient /* synthetic */ IpChange $ipChange;

        C0871a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TicketNoteList createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "370734379") ? (TicketNoteList) ipChange.ipc$dispatch("370734379", new Object[]{this, parcel}) : new TicketNoteList(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TicketNoteList[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1732070368") ? (TicketNoteList[]) ipChange.ipc$dispatch("1732070368", new Object[]{this, Integer.valueOf(i)}) : new TicketNoteList[i];
        }
    }

    public TicketNoteList() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-547024502")) {
            return ((Integer) ipChange.ipc$dispatch("-547024502", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getNoteTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "169272500") ? (String) ipChange.ipc$dispatch("169272500", new Object[]{this}) : this.noteTitle;
    }

    public List<TicketNote> getTicketNoteList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1216338229") ? (List) ipChange.ipc$dispatch("-1216338229", new Object[]{this}) : this.ticketNoteList;
    }

    public void setNoteTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012724670")) {
            ipChange.ipc$dispatch("-1012724670", new Object[]{this, str});
        } else {
            this.noteTitle = str;
        }
    }

    public void setTicketNoteList(List<TicketNote> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043318943")) {
            ipChange.ipc$dispatch("-2043318943", new Object[]{this, list});
        } else {
            this.ticketNoteList = list;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479250303")) {
            ipChange.ipc$dispatch("-479250303", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.noteTitle);
        parcel.writeTypedList(this.ticketNoteList);
    }

    protected TicketNoteList(Parcel parcel) {
        this.noteTitle = parcel.readString();
        this.ticketNoteList = parcel.createTypedArrayList(TicketNote.CREATOR);
    }
}
