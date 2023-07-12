package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AddAddressResultBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddAddressResultBean> CREATOR = new Parcelable.Creator<AddAddressResultBean>() { // from class: cn.damai.commonbusiness.address.bean.AddAddressResultBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddAddressResultBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1016946893") ? (AddAddressResultBean) ipChange.ipc$dispatch("1016946893", new Object[]{this, parcel}) : new AddAddressResultBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddAddressResultBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1380884848") ? (AddAddressResultBean[]) ipChange.ipc$dispatch("1380884848", new Object[]{this, Integer.valueOf(i)}) : new AddAddressResultBean[i];
        }
    };
    private AddressBean address;
    private String success;

    public AddAddressResultBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144797338")) {
            return ((Integer) ipChange.ipc$dispatch("-2144797338", new Object[]{this})).intValue();
        }
        return 0;
    }

    public AddressBean getAddress() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "202698658") ? (AddressBean) ipChange.ipc$dispatch("202698658", new Object[]{this}) : this.address;
    }

    public String getSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-347641323") ? (String) ipChange.ipc$dispatch("-347641323", new Object[]{this}) : this.success;
    }

    public void setAddress(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1542374452")) {
            ipChange.ipc$dispatch("-1542374452", new Object[]{this, addressBean});
        } else {
            this.address = addressBean;
        }
    }

    public void setSuccess(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "491767297")) {
            ipChange.ipc$dispatch("491767297", new Object[]{this, str});
        } else {
            this.success = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492975653")) {
            ipChange.ipc$dispatch("1492975653", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.success);
        parcel.writeParcelable(this.address, i);
    }

    protected AddAddressResultBean(Parcel parcel) {
        this.success = parcel.readString();
        this.address = (AddressBean) parcel.readParcelable(AddressBean.class.getClassLoader());
    }
}
