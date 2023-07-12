package cn.damai.ultron.secondpage.phonecode.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DmPhoneCodeBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DmPhoneCodeBean> CREATOR = new Parcelable.Creator<DmPhoneCodeBean>() { // from class: cn.damai.ultron.secondpage.phonecode.bean.DmPhoneCodeBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DmPhoneCodeBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1808460803") ? (DmPhoneCodeBean) ipChange.ipc$dispatch("-1808460803", new Object[]{this, parcel}) : new DmPhoneCodeBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DmPhoneCodeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1048169872") ? (DmPhoneCodeBean[]) ipChange.ipc$dispatch("-1048169872", new Object[]{this, Integer.valueOf(i)}) : new DmPhoneCodeBean[i];
        }
    };
    public String area;
    public String code;

    public DmPhoneCodeBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "49282254")) {
            return ((Integer) ipChange.ipc$dispatch("49282254", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "645381565")) {
            ipChange.ipc$dispatch("645381565", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.area);
        parcel.writeString(this.code);
    }

    protected DmPhoneCodeBean(Parcel parcel) {
        this.area = parcel.readString();
        this.code = parcel.readString();
    }
}
