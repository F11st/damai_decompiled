package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailSeatBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailSeatBean> CREATOR = new Parcelable.Creator<OrderDetailSeatBean>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSeatBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1892554987") ? (OrderDetailSeatBean) ipChange.ipc$dispatch("1892554987", new Object[]{this, parcel}) : new OrderDetailSeatBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1134184708") ? (OrderDetailSeatBean[]) ipChange.ipc$dispatch("1134184708", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailSeatBean[i];
        }
    };
    public String area;
    public String combineTicketId;
    public String price;
    public String seatNo;
    public String seatPrice;
    public String seatTypeDesc;

    public OrderDetailSeatBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-376904328")) {
            return ((Integer) ipChange.ipc$dispatch("-376904328", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "11271763")) {
            ipChange.ipc$dispatch("11271763", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.area);
        parcel.writeString(this.seatPrice);
        parcel.writeString(this.price);
        parcel.writeString(this.seatNo);
        parcel.writeString(this.combineTicketId);
        parcel.writeString(this.seatTypeDesc);
    }

    protected OrderDetailSeatBean(Parcel parcel) {
        this.area = parcel.readString();
        this.seatPrice = parcel.readString();
        this.price = parcel.readString();
        this.seatNo = parcel.readString();
        this.combineTicketId = parcel.readString();
        this.seatTypeDesc = parcel.readString();
    }
}
