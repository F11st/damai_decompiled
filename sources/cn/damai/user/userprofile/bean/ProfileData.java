package cn.damai.user.userprofile.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.user.userprofile.cuser.bean.CUser;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ProfileData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProfileData> CREATOR = new Parcelable.Creator<ProfileData>() { // from class: cn.damai.user.userprofile.bean.ProfileData.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProfileData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2056751477") ? (ProfileData) ipChange.ipc$dispatch("-2056751477", new Object[]{this, parcel}) : new ProfileData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProfileData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "148912146") ? (ProfileData[]) ipChange.ipc$dispatch("148912146", new Object[]{this, Integer.valueOf(i)}) : new ProfileData[i];
        }
    };
    public CUser c;
    public boolean mySelf;

    protected ProfileData(Parcel parcel) {
        this.mySelf = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-555970991")) {
            return ((Integer) ipChange.ipc$dispatch("-555970991", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472594586")) {
            ipChange.ipc$dispatch("1472594586", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeByte(this.mySelf ? (byte) 1 : (byte) 0);
        }
    }
}
