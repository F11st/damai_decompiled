package cn.damai.user.userprofile.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class CombData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CombData> CREATOR = new Parcelable.Creator<CombData>() { // from class: cn.damai.user.userprofile.bean.CombData.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CombData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-124538653") ? (CombData) ipChange.ipc$dispatch("-124538653", new Object[]{this, parcel}) : new CombData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CombData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "401955024") ? (CombData[]) ipChange.ipc$dispatch("401955024", new Object[]{this, Integer.valueOf(i)}) : new CombData[i];
        }
    };
    public ProfileData data;

    protected CombData(Parcel parcel) {
        this.data = (ProfileData) parcel.readParcelable(ProfileData.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1959938309")) {
            return ((Integer) ipChange.ipc$dispatch("-1959938309", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "197788464")) {
            ipChange.ipc$dispatch("197788464", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeParcelable(this.data, i);
        }
    }
}
