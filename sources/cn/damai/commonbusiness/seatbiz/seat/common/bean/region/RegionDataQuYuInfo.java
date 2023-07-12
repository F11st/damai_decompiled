package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionDataQuYuInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RegionDataQuYuInfo> CREATOR = new Parcelable.Creator<RegionDataQuYuInfo>() { // from class: cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataQuYuInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegionDataQuYuInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1555980235") ? (RegionDataQuYuInfo) ipChange.ipc$dispatch("1555980235", new Object[]{this, parcel}) : new RegionDataQuYuInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegionDataQuYuInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "387538006") ? (RegionDataQuYuInfo[]) ipChange.ipc$dispatch("387538006", new Object[]{this, Integer.valueOf(i)}) : new RegionDataQuYuInfo[i];
        }
    };
    public String c;
    public long i;
    public String j;
    public String n;
    public String pis;
    public String rainbow;
    public int s;
    public String vid;
    public long zh;

    public RegionDataQuYuInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290342929")) {
            return ((Integer) ipChange.ipc$dispatch("-290342929", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70154052")) {
            ipChange.ipc$dispatch("-70154052", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.c);
        parcel.writeString(this.n);
        parcel.writeLong(i);
        parcel.writeInt(this.s);
        parcel.writeString(this.pis);
        parcel.writeString(this.j);
        parcel.writeLong(this.zh);
    }

    protected RegionDataQuYuInfo(Parcel parcel) {
        this.c = parcel.readString();
        this.n = parcel.readString();
        this.i = parcel.readLong();
        this.s = parcel.readInt();
        this.pis = parcel.readString();
        this.j = parcel.readString();
        this.zh = parcel.readLong();
    }
}
