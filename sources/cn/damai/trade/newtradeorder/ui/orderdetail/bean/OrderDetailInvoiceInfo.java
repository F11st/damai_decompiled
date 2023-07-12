package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailInvoiceInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailInvoiceInfo> CREATOR = new Parcelable.Creator<OrderDetailInvoiceInfo>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailInvoiceInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailInvoiceInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1514340301") ? (OrderDetailInvoiceInfo) ipChange.ipc$dispatch("1514340301", new Object[]{this, parcel}) : new OrderDetailInvoiceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailInvoiceInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1750044272") ? (OrderDetailInvoiceInfo[]) ipChange.ipc$dispatch("1750044272", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailInvoiceInfo[i];
        }
    };
    public String invoiceDesc;
    public String invoiceFetchName;
    public int invoiceFetchType;
    public int invoiceType;

    public OrderDetailInvoiceInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452433146")) {
            return ((Integer) ipChange.ipc$dispatch("-452433146", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718781573")) {
            ipChange.ipc$dispatch("1718781573", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.invoiceFetchName);
        parcel.writeInt(this.invoiceFetchType);
        parcel.writeString(this.invoiceDesc);
        parcel.writeInt(this.invoiceType);
    }

    protected OrderDetailInvoiceInfo(Parcel parcel) {
        this.invoiceFetchName = parcel.readString();
        this.invoiceFetchType = parcel.readInt();
        this.invoiceDesc = parcel.readString();
        this.invoiceType = parcel.readInt();
    }
}
