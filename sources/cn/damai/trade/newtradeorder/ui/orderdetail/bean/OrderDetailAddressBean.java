package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailAddressBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailAddressBean> CREATOR = new Parcelable.Creator<OrderDetailAddressBean>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAddressBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailAddressBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-985383493") ? (OrderDetailAddressBean) ipChange.ipc$dispatch("-985383493", new Object[]{this, parcel}) : new OrderDetailAddressBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailAddressBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-665643440") ? (OrderDetailAddressBean[]) ipChange.ipc$dispatch("-665643440", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailAddressBean[i];
        }
    };
    public String addressId;
    public String consigneeAddressTip;
    public String deliveryAmount;
    public String email;
    public String fullAddress;
    public String mobilePhone;
    public boolean modify;
    public String userName;

    public OrderDetailAddressBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-814585201")) {
            return ((Integer) ipChange.ipc$dispatch("-814585201", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832264021")) {
            ipChange.ipc$dispatch("1832264021", new Object[]{this, parcel});
            return;
        }
        this.addressId = parcel.readString();
        this.deliveryAmount = parcel.readString();
        this.fullAddress = parcel.readString();
        this.mobilePhone = parcel.readString();
        this.email = parcel.readString();
        this.modify = parcel.readByte() != 0;
        this.userName = parcel.readString();
        this.consigneeAddressTip = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42440164")) {
            ipChange.ipc$dispatch("-42440164", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.addressId);
        parcel.writeString(this.deliveryAmount);
        parcel.writeString(this.fullAddress);
        parcel.writeString(this.mobilePhone);
        parcel.writeString(this.email);
        parcel.writeByte(this.modify ? (byte) 1 : (byte) 0);
        parcel.writeString(this.userName);
        parcel.writeString(this.consigneeAddressTip);
    }

    protected OrderDetailAddressBean(Parcel parcel) {
        this.addressId = parcel.readString();
        this.deliveryAmount = parcel.readString();
        this.fullAddress = parcel.readString();
        this.mobilePhone = parcel.readString();
        this.email = parcel.readString();
        this.modify = parcel.readByte() != 0;
        this.userName = parcel.readString();
        this.consigneeAddressTip = parcel.readString();
    }
}
