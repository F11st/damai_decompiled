package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailPricesInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailPricesInfo> CREATOR = new Parcelable.Creator<OrderDetailPricesInfo>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPricesInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailPricesInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2095454795") ? (OrderDetailPricesInfo) ipChange.ipc$dispatch("2095454795", new Object[]{this, parcel}) : new OrderDetailPricesInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailPricesInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "982975678") ? (OrderDetailPricesInfo[]) ipChange.ipc$dispatch("982975678", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailPricesInfo[i];
        }
    };
    public String displayAmount;
    public String displayAmountDesc;
    public String itemAmount;

    public OrderDetailPricesInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746196731")) {
            return ((Integer) ipChange.ipc$dispatch("746196731", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-776426704")) {
            ipChange.ipc$dispatch("-776426704", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.itemAmount);
        parcel.writeString(this.displayAmountDesc);
        parcel.writeString(this.displayAmount);
    }

    protected OrderDetailPricesInfo(Parcel parcel) {
        this.itemAmount = parcel.readString();
        this.displayAmountDesc = parcel.readString();
        this.displayAmount = parcel.readString();
    }
}
