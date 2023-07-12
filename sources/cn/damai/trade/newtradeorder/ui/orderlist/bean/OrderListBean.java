package cn.damai.trade.newtradeorder.ui.orderlist.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.seatbiz.orderlist.bean.OrderFirstPayChooseSeat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderListBean> CREATOR = new Parcelable.Creator<OrderListBean>() { // from class: cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-208745909") ? (OrderListBean) ipChange.ipc$dispatch("-208745909", new Object[]{this, parcel}) : new OrderListBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1446788338") ? (OrderListBean[]) ipChange.ipc$dispatch("-1446788338", new Object[]{this, Integer.valueOf(i)}) : new OrderListBean[i];
        }
    };
    public String amountDesc;
    public String changePlayTimeReason;
    public String detailUrl;
    public OrderFirstPayChooseSeat firstPayChooseSeat;
    public int index;
    public String orderCreateTime;
    public String orderFeatureDesc;
    public long orderId;
    public String orderStatus;
    public int orderType;
    public String playTime;
    public String projectCity;
    public String projectId;
    public String projectName;
    public String projectPicUrl;
    public long quantity;
    public OrderListSelfPreBean selfPre;
    public int showRefundDetailBtn;
    public String showStatus;
    public String totalAmount;
    public String venueName;

    public OrderListBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177381325")) {
            return ((Integer) ipChange.ipc$dispatch("-177381325", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isHNOrder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "10863947") ? ((Boolean) ipChange.ipc$dispatch("10863947", new Object[]{this})).booleanValue() : this.orderType == 3;
    }

    public boolean orderClose() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-897571361")) {
            return ((Boolean) ipChange.ipc$dispatch("-897571361", new Object[]{this})).booleanValue();
        }
        String str = this.showStatus;
        if (str == null) {
            return false;
        }
        return str.equals("5");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-711266056")) {
            ipChange.ipc$dispatch("-711266056", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.orderId);
        parcel.writeString(this.orderCreateTime);
        parcel.writeString(this.totalAmount);
        parcel.writeString(this.amountDesc);
        parcel.writeLong(this.quantity);
        parcel.writeString(this.orderStatus);
        parcel.writeString(this.projectCity);
        parcel.writeString(this.projectId);
        parcel.writeString(this.projectName);
        parcel.writeString(this.projectPicUrl);
        parcel.writeString(this.playTime);
        parcel.writeString(this.venueName);
        parcel.writeString(this.changePlayTimeReason);
        parcel.writeInt(this.showRefundDetailBtn);
        parcel.writeInt(this.orderType);
        parcel.writeString(this.detailUrl);
        parcel.writeParcelable(this.selfPre, i);
        parcel.writeParcelable(this.firstPayChooseSeat, i);
        parcel.writeString(this.orderFeatureDesc);
        parcel.writeString(this.showStatus);
    }

    protected OrderListBean(Parcel parcel) {
        this.orderId = parcel.readLong();
        this.orderCreateTime = parcel.readString();
        this.totalAmount = parcel.readString();
        this.amountDesc = parcel.readString();
        this.quantity = parcel.readLong();
        this.orderStatus = parcel.readString();
        this.projectCity = parcel.readString();
        this.projectId = parcel.readString();
        this.projectName = parcel.readString();
        this.projectPicUrl = parcel.readString();
        this.playTime = parcel.readString();
        this.venueName = parcel.readString();
        this.changePlayTimeReason = parcel.readString();
        this.showRefundDetailBtn = parcel.readInt();
        this.orderType = parcel.readInt();
        this.detailUrl = parcel.readString();
        this.selfPre = (OrderListSelfPreBean) parcel.readParcelable(OrderListSelfPreBean.class.getClassLoader());
        this.firstPayChooseSeat = (OrderFirstPayChooseSeat) parcel.readParcelable(OrderFirstPayChooseSeat.class.getClassLoader());
        this.orderFeatureDesc = parcel.readString();
        this.showStatus = parcel.readString();
    }
}
