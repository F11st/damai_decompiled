package cn.damai.trade.newtradeorder.ui.projectdetail.venuemap;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class Venue implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<Venue> CREATOR = new C2439a();
    public String address;
    public String cityId;
    public String cityName;
    public double lat;
    public double lng;
    public long venueId;
    public String venueName;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.venuemap.Venue$a */
    /* loaded from: classes16.dex */
    public class C2439a implements Parcelable.Creator<Venue> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2439a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Venue createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1057925493") ? (Venue) ipChange.ipc$dispatch("-1057925493", new Object[]{this, parcel}) : new Venue(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Venue[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-340284502") ? (Venue[]) ipChange.ipc$dispatch("-340284502", new Object[]{this, Integer.valueOf(i)}) : new Venue[i];
        }
    }

    public Venue() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272977819")) {
            return ((Integer) ipChange.ipc$dispatch("-272977819", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437635846")) {
            ipChange.ipc$dispatch("437635846", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.venueId);
        parcel.writeString(this.venueName);
        parcel.writeString(this.address);
        parcel.writeString(this.cityId);
        parcel.writeString(this.cityName);
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
    }

    protected Venue(Parcel parcel) {
        this.venueId = parcel.readLong();
        this.venueName = parcel.readString();
        this.address = parcel.readString();
        this.cityId = parcel.readString();
        this.cityName = parcel.readString();
        this.lat = parcel.readDouble();
        this.lng = parcel.readDouble();
    }
}
