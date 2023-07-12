package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DefaultAddressBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DefaultAddressBean> CREATOR = new Parcelable.Creator<DefaultAddressBean>() { // from class: cn.damai.mine.bean.DefaultAddressBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultAddressBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1992633727") ? (DefaultAddressBean) ipChange.ipc$dispatch("-1992633727", new Object[]{this, parcel}) : new DefaultAddressBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultAddressBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1189415376") ? (DefaultAddressBean[]) ipChange.ipc$dispatch("-1189415376", new Object[]{this, Integer.valueOf(i)}) : new DefaultAddressBean[i];
        }
    };
    private String success;

    public DefaultAddressBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092639756")) {
            return ((Integer) ipChange.ipc$dispatch("1092639756", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-237336657") ? (String) ipChange.ipc$dispatch("-237336657", new Object[]{this}) : this.success;
    }

    public void setSuccess(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-383755353")) {
            ipChange.ipc$dispatch("-383755353", new Object[]{this, str});
        } else {
            this.success = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-863632833")) {
            ipChange.ipc$dispatch("-863632833", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.success);
        }
    }

    protected DefaultAddressBean(Parcel parcel) {
        this.success = parcel.readString();
    }
}
