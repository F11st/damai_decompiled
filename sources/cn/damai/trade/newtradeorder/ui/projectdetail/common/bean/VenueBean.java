package cn.damai.trade.newtradeorder.ui.projectdetail.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class VenueBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<VenueBean> CREATOR = new Parcelable.Creator<VenueBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VenueBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "873364133") ? (VenueBean) ipChange.ipc$dispatch("873364133", new Object[]{this, parcel}) : new VenueBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VenueBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-977415184") ? (VenueBean[]) ipChange.ipc$dispatch("-977415184", new Object[]{this, Integer.valueOf(i)}) : new VenueBean[i];
        }
    };
    private String distance;
    private double lat;
    private double lng;
    public String region;
    public String showCountText;
    private String venueAddr;
    private String venueCityName;
    private String venueId;
    private String venueName;

    public VenueBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1073109286")) {
            return ((Integer) ipChange.ipc$dispatch("-1073109286", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getDistance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "866708941") ? (String) ipChange.ipc$dispatch("866708941", new Object[]{this}) : this.distance;
    }

    public double getLat() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1022335567") ? ((Double) ipChange.ipc$dispatch("-1022335567", new Object[]{this})).doubleValue() : this.lat;
    }

    public double getLng() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1010717077") ? ((Double) ipChange.ipc$dispatch("-1010717077", new Object[]{this})).doubleValue() : this.lng;
    }

    public String getRegion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "495112844") ? (String) ipChange.ipc$dispatch("495112844", new Object[]{this}) : this.region;
    }

    public String getVenueAddr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-619515426") ? (String) ipChange.ipc$dispatch("-619515426", new Object[]{this}) : this.venueAddr;
    }

    public String getVenueCityName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1227142397") ? (String) ipChange.ipc$dispatch("-1227142397", new Object[]{this}) : this.venueCityName;
    }

    public String getVenueId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-407344504") ? (String) ipChange.ipc$dispatch("-407344504", new Object[]{this}) : this.venueId;
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-545161352") ? (String) ipChange.ipc$dispatch("-545161352", new Object[]{this}) : this.venueName;
    }

    public boolean notMainLandProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1371489490") ? ((Boolean) ipChange.ipc$dispatch("-1371489490", new Object[]{this})).booleanValue() : "2".equals(this.region) || "3".equals(this.region);
    }

    public void setDistance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215845553")) {
            ipChange.ipc$dispatch("1215845553", new Object[]{this, str});
        } else {
            this.distance = str;
        }
    }

    public void setLat(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309198927")) {
            ipChange.ipc$dispatch("309198927", new Object[]{this, Double.valueOf(d)});
        } else {
            this.lat = d;
        }
    }

    public void setLng(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669372117")) {
            ipChange.ipc$dispatch("669372117", new Object[]{this, Double.valueOf(d)});
        } else {
            this.lng = d;
        }
    }

    public void setRegion(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068504274")) {
            ipChange.ipc$dispatch("1068504274", new Object[]{this, str});
        } else {
            this.region = str;
        }
    }

    public void setVenueAddr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304653400")) {
            ipChange.ipc$dispatch("304653400", new Object[]{this, str});
        } else {
            this.venueAddr = str;
        }
    }

    public void setVenueCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1255372333")) {
            ipChange.ipc$dispatch("-1255372333", new Object[]{this, str});
        } else {
            this.venueCityName = str;
        }
    }

    public void setVenueId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1359031314")) {
            ipChange.ipc$dispatch("-1359031314", new Object[]{this, str});
        } else {
            this.venueId = str;
        }
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685337602")) {
            ipChange.ipc$dispatch("-1685337602", new Object[]{this, str});
        } else {
            this.venueName = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897445169")) {
            ipChange.ipc$dispatch("897445169", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.distance);
        parcel.writeString(this.venueCityName);
        parcel.writeString(this.venueId);
        parcel.writeString(this.venueName);
        parcel.writeDouble(this.lng);
        parcel.writeDouble(this.lat);
        parcel.writeString(this.venueAddr);
        parcel.writeString(this.showCountText);
        parcel.writeString(this.region);
    }

    protected VenueBean(Parcel parcel) {
        this.distance = parcel.readString();
        this.venueCityName = parcel.readString();
        this.venueId = parcel.readString();
        this.venueName = parcel.readString();
        this.lng = parcel.readDouble();
        this.lat = parcel.readDouble();
        this.venueAddr = parcel.readString();
        this.showCountText = parcel.readString();
        this.region = parcel.readString();
    }
}
