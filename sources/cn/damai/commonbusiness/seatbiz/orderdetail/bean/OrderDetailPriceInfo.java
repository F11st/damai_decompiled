package cn.damai.commonbusiness.seatbiz.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class OrderDetailPriceInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailPriceInfo> CREATOR = new Parcelable.Creator<OrderDetailPriceInfo>() { // from class: cn.damai.commonbusiness.seatbiz.orderdetail.bean.OrderDetailPriceInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailPriceInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "323641417") ? (OrderDetailPriceInfo) ipChange.ipc$dispatch("323641417", new Object[]{this, parcel}) : new OrderDetailPriceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailPriceInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1673506224") ? (OrderDetailPriceInfo[]) ipChange.ipc$dispatch("1673506224", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailPriceInfo[i];
        }
    };
    public String buyQuantity;
    public String priceId;
    public String projectId;

    public OrderDetailPriceInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "682670504")) {
            return ((Integer) ipChange.ipc$dispatch("682670504", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1090449373")) {
            ipChange.ipc$dispatch("-1090449373", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.priceId);
        parcel.writeString(this.buyQuantity);
        parcel.writeString(this.projectId);
    }

    protected OrderDetailPriceInfo(Parcel parcel) {
        this.priceId = parcel.readString();
        this.buyQuantity = parcel.readString();
        this.projectId = parcel.readString();
    }
}
