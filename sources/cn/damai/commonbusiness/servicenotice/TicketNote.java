package cn.damai.commonbusiness.servicenotice;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TicketNote implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<TicketNote> CREATOR = new a();
    public String content;
    public String imgUrl;
    public String title;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<TicketNote> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TicketNote createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "501620715") ? (TicketNote) ipChange.ipc$dispatch("501620715", new Object[]{this, parcel}) : new TicketNote(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TicketNote[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1137435996") ? (TicketNote[]) ipChange.ipc$dispatch("1137435996", new Object[]{this, Integer.valueOf(i)}) : new TicketNote[i];
        }
    }

    public TicketNote() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "742674892")) {
            return ((Integer) ipChange.ipc$dispatch("742674892", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1051158683") ? (String) ipChange.ipc$dispatch("-1051158683", new Object[]{this}) : this.content;
    }

    public String getImgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1736425142") ? (String) ipChange.ipc$dispatch("1736425142", new Object[]{this}) : this.imgUrl;
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-927312892") ? (String) ipChange.ipc$dispatch("-927312892", new Object[]{this}) : this.title;
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157565617")) {
            ipChange.ipc$dispatch("157565617", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public void setImgUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "894479848")) {
            ipChange.ipc$dispatch("894479848", new Object[]{this, str});
        } else {
            this.imgUrl = str;
        }
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-485528334")) {
            ipChange.ipc$dispatch("-485528334", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "915686527")) {
            ipChange.ipc$dispatch("915686527", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.imgUrl);
    }

    protected TicketNote(Parcel parcel) {
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.imgUrl = parcel.readString();
    }
}
