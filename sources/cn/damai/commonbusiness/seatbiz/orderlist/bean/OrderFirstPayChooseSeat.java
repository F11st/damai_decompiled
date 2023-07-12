package cn.damai.commonbusiness.seatbiz.orderlist.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.OrderDetailPriceInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class OrderFirstPayChooseSeat implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderFirstPayChooseSeat> CREATOR = new Parcelable.Creator<OrderFirstPayChooseSeat>() { // from class: cn.damai.commonbusiness.seatbiz.orderlist.bean.OrderFirstPayChooseSeat.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderFirstPayChooseSeat createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1511609163") ? (OrderFirstPayChooseSeat) ipChange.ipc$dispatch("1511609163", new Object[]{this, parcel}) : new OrderFirstPayChooseSeat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderFirstPayChooseSeat[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1610182322") ? (OrderFirstPayChooseSeat[]) ipChange.ipc$dispatch("-1610182322", new Object[]{this, Integer.valueOf(i)}) : new OrderFirstPayChooseSeat[i];
        }
    };
    public List<OrderFirstPayChooseSeatButton> button;
    public String chooseSeatDesc;
    public int chooseSeatMode;
    public long chooseSeatTime;
    public String countDownDescPrefix;
    public String countDownDescSuffix;
    public String orderId;
    public long performId;
    public String performName;
    public List<OrderDetailPriceInfo> priceInfoList;
    public String reservedDesc;
    public String rowNo;
    public String rowNoDesc;
    public String rowNoImgUrl;
    public String rowNoLocationDesc;
    public long showCityId;

    public OrderFirstPayChooseSeat() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "249739699")) {
            return ((Integer) ipChange.ipc$dispatch("249739699", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "894683000")) {
            ipChange.ipc$dispatch("894683000", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.chooseSeatMode);
        parcel.writeString(this.chooseSeatDesc);
        parcel.writeLong(this.chooseSeatTime);
        parcel.writeString(this.reservedDesc);
        parcel.writeString(this.rowNo);
        parcel.writeString(this.rowNoDesc);
        parcel.writeString(this.rowNoLocationDesc);
        parcel.writeString(this.rowNoImgUrl);
        parcel.writeTypedList(this.button);
        parcel.writeTypedList(this.priceInfoList);
        parcel.writeLong(this.showCityId);
        parcel.writeLong(this.performId);
        parcel.writeString(this.performName);
        parcel.writeString(this.orderId);
        parcel.writeString(this.countDownDescPrefix);
        parcel.writeString(this.countDownDescSuffix);
    }

    protected OrderFirstPayChooseSeat(Parcel parcel) {
        this.chooseSeatMode = parcel.readInt();
        this.chooseSeatDesc = parcel.readString();
        this.chooseSeatTime = parcel.readLong();
        this.reservedDesc = parcel.readString();
        this.rowNo = parcel.readString();
        this.rowNoDesc = parcel.readString();
        this.rowNoLocationDesc = parcel.readString();
        this.rowNoImgUrl = parcel.readString();
        this.button = parcel.createTypedArrayList(OrderFirstPayChooseSeatButton.CREATOR);
        this.priceInfoList = parcel.createTypedArrayList(OrderDetailPriceInfo.CREATOR);
        this.showCityId = parcel.readLong();
        this.performId = parcel.readLong();
        this.performName = parcel.readString();
        this.orderId = parcel.readString();
        this.countDownDescPrefix = parcel.readString();
        this.countDownDescSuffix = parcel.readString();
    }
}
