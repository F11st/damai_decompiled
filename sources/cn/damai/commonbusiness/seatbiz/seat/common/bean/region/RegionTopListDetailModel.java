package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionTopListDetailModel implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RegionTopListDetailModel> CREATOR = new Parcelable.Creator<RegionTopListDetailModel>() { // from class: cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionTopListDetailModel.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegionTopListDetailModel createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "755419627") ? (RegionTopListDetailModel) ipChange.ipc$dispatch("755419627", new Object[]{this, parcel}) : new RegionTopListDetailModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegionTopListDetailModel[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-173897988") ? (RegionTopListDetailModel[]) ipChange.ipc$dispatch("-173897988", new Object[]{this, Integer.valueOf(i)}) : new RegionTopListDetailModel[i];
        }
    };
    private long id;
    private String pref;
    private String q;

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928342788")) {
            return ((Integer) ipChange.ipc$dispatch("-928342788", new Object[]{this})).intValue();
        }
        return 0;
    }

    public long getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "968375711") ? ((Long) ipChange.ipc$dispatch("968375711", new Object[]{this})).longValue() : this.id;
    }

    public String getPref() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "687416221") ? (String) ipChange.ipc$dispatch("687416221", new Object[]{this}) : this.pref;
    }

    public String getQ() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-882411795") ? (String) ipChange.ipc$dispatch("-882411795", new Object[]{this}) : this.q;
    }

    public void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259710331")) {
            ipChange.ipc$dispatch("-259710331", new Object[]{this, Long.valueOf(j)});
        } else {
            this.id = j;
        }
    }

    public void setPref(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-457690399")) {
            ipChange.ipc$dispatch("-457690399", new Object[]{this, str});
        } else {
            this.pref = str;
        }
    }

    public void setQ(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022411561")) {
            ipChange.ipc$dispatch("2022411561", new Object[]{this, str});
        } else {
            this.q = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880296113")) {
            ipChange.ipc$dispatch("-880296113", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.pref);
        parcel.writeString(this.q);
    }

    public RegionTopListDetailModel() {
    }

    private RegionTopListDetailModel(Parcel parcel) {
        this.pref = parcel.readString();
        this.q = parcel.readString();
    }
}
