package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailButtonBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailButtonBean> CREATOR = new Parcelable.Creator<OrderDetailButtonBean>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailButtonBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailButtonBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1526200587") ? (OrderDetailButtonBean) ipChange.ipc$dispatch("1526200587", new Object[]{this, parcel}) : new OrderDetailButtonBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailButtonBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "166680938") ? (OrderDetailButtonBean[]) ipChange.ipc$dispatch("166680938", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailButtonBean[i];
        }
    };
    public boolean canResell;
    public boolean cancelButton;
    public boolean checkCanApplyRefund;
    public boolean elTicketButton;
    public boolean goPayButton;
    public boolean logisticsButton;
    public boolean refundButton;
    public String refundButtonDesc;
    public String refundButtonLink;
    public String refundGuidBubble;
    public boolean remindDeliveryButton;
    public String remindDeliveryToast;
    public String resellAgreementUrl;
    public String resellDetailUrl;

    public OrderDetailButtonBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "520228197")) {
            return ((Integer) ipChange.ipc$dispatch("520228197", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2133586426")) {
            ipChange.ipc$dispatch("-2133586426", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeByte(this.canResell ? (byte) 1 : (byte) 0);
        parcel.writeString(this.resellDetailUrl);
        parcel.writeString(this.resellAgreementUrl);
        parcel.writeByte(this.cancelButton ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.goPayButton ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.logisticsButton ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.elTicketButton ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.remindDeliveryButton ? (byte) 1 : (byte) 0);
        parcel.writeString(this.remindDeliveryToast);
        parcel.writeByte(this.refundButton ? (byte) 1 : (byte) 0);
        parcel.writeString(this.refundButtonLink);
        parcel.writeString(this.refundGuidBubble);
        parcel.writeString(this.refundButtonDesc);
        parcel.writeByte(this.checkCanApplyRefund ? (byte) 1 : (byte) 0);
    }

    protected OrderDetailButtonBean(Parcel parcel) {
        this.canResell = parcel.readByte() != 0;
        this.resellDetailUrl = parcel.readString();
        this.resellAgreementUrl = parcel.readString();
        this.cancelButton = parcel.readByte() != 0;
        this.goPayButton = parcel.readByte() != 0;
        this.logisticsButton = parcel.readByte() != 0;
        this.elTicketButton = parcel.readByte() != 0;
        this.remindDeliveryButton = parcel.readByte() != 0;
        this.remindDeliveryToast = parcel.readString();
        this.refundButton = parcel.readByte() != 0;
        this.refundButtonLink = parcel.readString();
        this.refundGuidBubble = parcel.readString();
        this.refundButtonDesc = parcel.readString();
        this.checkCanApplyRefund = parcel.readByte() != 0;
    }
}
