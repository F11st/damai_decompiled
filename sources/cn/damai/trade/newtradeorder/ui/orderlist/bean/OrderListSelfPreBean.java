package cn.damai.trade.newtradeorder.ui.orderlist.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderListSelfPreBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderListSelfPreBean> CREATOR = new Parcelable.Creator<OrderListSelfPreBean>() { // from class: cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListSelfPreBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderListSelfPreBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "66842741") ? (OrderListSelfPreBean) ipChange.ipc$dispatch("66842741", new Object[]{this, parcel}) : new OrderListSelfPreBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderListSelfPreBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2012523280") ? (OrderListSelfPreBean[]) ipChange.ipc$dispatch("-2012523280", new Object[]{this, Integer.valueOf(i)}) : new OrderListSelfPreBean[i];
        }
    };
    public String chooseSeatDesc;
    public long startChooseTime;
    public String waitNum;

    public OrderListSelfPreBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462730254")) {
            return ((Integer) ipChange.ipc$dispatch("-1462730254", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1804969241")) {
            ipChange.ipc$dispatch("1804969241", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.chooseSeatDesc);
        parcel.writeLong(this.startChooseTime);
        parcel.writeString(this.waitNum);
    }

    protected OrderListSelfPreBean(Parcel parcel) {
        this.chooseSeatDesc = parcel.readString();
        this.startChooseTime = parcel.readLong();
        this.waitNum = parcel.readString();
    }
}
