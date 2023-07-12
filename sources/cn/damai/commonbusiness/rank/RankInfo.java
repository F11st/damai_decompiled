package cn.damai.commonbusiness.rank;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class RankInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RankInfo> CREATOR = new a();
    private String id;
    private String name;
    private String order;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<RankInfo> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RankInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-201600357") ? (RankInfo) ipChange.ipc$dispatch("-201600357", new Object[]{this, parcel}) : new RankInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RankInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-595194992") ? (RankInfo[]) ipChange.ipc$dispatch("-595194992", new Object[]{this, Integer.valueOf(i)}) : new RankInfo[i];
        }
    }

    public RankInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1721148703")) {
            return ((Integer) ipChange.ipc$dispatch("1721148703", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1323989960") ? (String) ipChange.ipc$dispatch("-1323989960", new Object[]{this}) : this.id;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-973148888") ? (String) ipChange.ipc$dispatch("-973148888", new Object[]{this}) : this.name;
    }

    public String getOrder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1471915001") ? (String) ipChange.ipc$dispatch("-1471915001", new Object[]{this}) : this.order;
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747336358")) {
            ipChange.ipc$dispatch("747336358", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-395601226")) {
            ipChange.ipc$dispatch("-395601226", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setOrder(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-188324529")) {
            ipChange.ipc$dispatch("-188324529", new Object[]{this, str});
        } else {
            this.order = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306615412")) {
            ipChange.ipc$dispatch("-1306615412", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.order);
    }

    protected RankInfo(Parcel parcel) {
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.order = parcel.readString();
    }
}
