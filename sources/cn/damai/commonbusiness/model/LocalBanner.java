package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class LocalBanner implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<LocalBanner> CREATOR = new Parcelable.Creator<LocalBanner>() { // from class: cn.damai.commonbusiness.model.LocalBanner.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalBanner createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "341058291") ? (LocalBanner) ipChange.ipc$dispatch("341058291", new Object[]{this, parcel}) : new LocalBanner(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalBanner[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2105071216") ? (LocalBanner[]) ipChange.ipc$dispatch("-2105071216", new Object[]{this, Integer.valueOf(i)}) : new LocalBanner[i];
        }
    };
    public int drawableId;
    public String img;
    public String name;
    public int rnType;
    public String rnValue;
    public int type;
    public String value;

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "133496691")) {
            return ((Integer) ipChange.ipc$dispatch("133496691", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31308216")) {
            ipChange.ipc$dispatch("31308216", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.name);
        parcel.writeString(this.img);
        parcel.writeInt(this.type);
        parcel.writeString(this.value);
        parcel.writeInt(this.rnType);
        parcel.writeString(this.rnValue);
    }

    public LocalBanner() {
    }

    private LocalBanner(Parcel parcel) {
        this.name = parcel.readString();
        this.img = parcel.readString();
        this.type = parcel.readInt();
        this.value = parcel.readString();
        this.rnType = parcel.readInt();
        this.rnValue = parcel.readString();
    }
}
