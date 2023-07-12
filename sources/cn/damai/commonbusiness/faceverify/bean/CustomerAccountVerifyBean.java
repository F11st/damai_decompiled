package cn.damai.commonbusiness.faceverify.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CustomerAccountVerifyBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CustomerAccountVerifyBean> CREATOR = new Parcelable.Creator<CustomerAccountVerifyBean>() { // from class: cn.damai.commonbusiness.faceverify.bean.CustomerAccountVerifyBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomerAccountVerifyBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1460279217") ? (CustomerAccountVerifyBean) ipChange.ipc$dispatch("1460279217", new Object[]{this, parcel}) : new CustomerAccountVerifyBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomerAccountVerifyBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1396120528") ? (CustomerAccountVerifyBean[]) ipChange.ipc$dispatch("-1396120528", new Object[]{this, Integer.valueOf(i)}) : new CustomerAccountVerifyBean[i];
        }
    };
    private boolean could;

    public CustomerAccountVerifyBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495614772")) {
            return ((Integer) ipChange.ipc$dispatch("495614772", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isCould() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2136553041") ? ((Boolean) ipChange.ipc$dispatch("2136553041", new Object[]{this})).booleanValue() : this.could;
    }

    public void setCould(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94107603")) {
            ipChange.ipc$dispatch("-94107603", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.could = z;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921587223")) {
            ipChange.ipc$dispatch("1921587223", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeByte(this.could ? (byte) 1 : (byte) 0);
        }
    }

    protected CustomerAccountVerifyBean(Parcel parcel) {
        this.could = parcel.readByte() != 0;
    }
}
