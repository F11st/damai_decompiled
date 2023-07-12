package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailSkuInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailSkuInfo> CREATOR = new Parcelable.Creator<OrderDetailSkuInfo>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSkuInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailSkuInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1309458323") ? (OrderDetailSkuInfo) ipChange.ipc$dispatch("-1309458323", new Object[]{this, parcel}) : new OrderDetailSkuInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailSkuInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-288089488") ? (OrderDetailSkuInfo[]) ipChange.ipc$dispatch("-288089488", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailSkuInfo[i];
        }
    };
    public String seatTypeDesc;
    public String skuInfo;
    public String totalPrice;

    public OrderDetailSkuInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-574188810")) {
            return ((Integer) ipChange.ipc$dispatch("-574188810", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012188011")) {
            ipChange.ipc$dispatch("-1012188011", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.seatTypeDesc);
        parcel.writeString(this.skuInfo);
        parcel.writeString(this.totalPrice);
    }

    protected OrderDetailSkuInfo(Parcel parcel) {
        this.seatTypeDesc = parcel.readString();
        this.skuInfo = parcel.readString();
        this.totalPrice = parcel.readString();
    }
}
