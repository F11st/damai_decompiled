package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.address.bean.DmPickupAddressBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailBean> CREATOR = new Parcelable.Creator<OrderDetailBean>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "416542795") ? (OrderDetailBean) ipChange.ipc$dispatch("416542795", new Object[]{this, parcel}) : new OrderDetailBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-792037170") ? (OrderDetailBean[]) ipChange.ipc$dispatch("-792037170", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailBean[i];
        }
    };
    public String aliPayTradeNo;
    public List<OrderDetailAmountDetail> amountDetailList;
    public String announcementImgUrl;
    public String announcementTargetUrl;
    public String applyInvoiceToast;
    public List<OrderDetailAudienceInfo> audiences;
    public String bargainOnTimeStr;
    public OrderDetailButtonBean buttonList;
    public OrderDetailAddressBean consigneeAddress;
    public String createTimeStr;
    public long currentTime;
    public OrderDetailDeliveryInfo deliveryMethodInfo;
    public String dialogTips;
    public DmPickupAddressBean dmPickupAddress;
    public List<OrderDetailFaq> faqItems;
    public String id;
    public OrderDetailInvoiceInfo invoice;
    public boolean isSupportInvoice;
    public OrderDetailMecItemInfo mecItemInfo;
    public String modifyAddressToast;
    public String orderCode;
    public OrderDetailShareBean orderShareDTO;
    public int orderSource;
    public long overdueTime;
    public String payTimeStr;
    public String payWayName;
    public List<OrderDetailPayInfo> paymentInfoList;
    public String paymentInfoTips;
    public OrderDetailPricesInfo pricesInfo;
    public PurchaseNotice purchaseNotice;
    public int quantity;
    public String realNameViewing;
    public String reservedDesc;
    public ArrayList<OrderDetailTicketService> ruleContexts;
    public ServiceOrderInfo serviceOrderInfo;
    public String shipmentsTimeStr;
    public OrderDetailStatusBean statusInfo;
    public String statusMessage;

    public OrderDetailBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816154733")) {
            return ((Integer) ipChange.ipc$dispatch("-1816154733", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isHouNiaoOrder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1791687656") ? ((Boolean) ipChange.ipc$dispatch("1791687656", new Object[]{this})).booleanValue() : this.orderSource == 3;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1828636369")) {
            ipChange.ipc$dispatch("1828636369", new Object[]{this, parcel});
            return;
        }
        this.statusInfo = (OrderDetailStatusBean) parcel.readParcelable(OrderDetailStatusBean.class.getClassLoader());
        this.faqItems = parcel.createTypedArrayList(OrderDetailFaq.CREATOR);
        this.realNameViewing = parcel.readString();
        this.serviceOrderInfo = (ServiceOrderInfo) parcel.readSerializable();
        this.overdueTime = parcel.readLong();
        this.statusMessage = parcel.readString();
        this.consigneeAddress = (OrderDetailAddressBean) parcel.readParcelable(OrderDetailAddressBean.class.getClassLoader());
        this.mecItemInfo = (OrderDetailMecItemInfo) parcel.readParcelable(OrderDetailMecItemInfo.class.getClassLoader());
        this.quantity = parcel.readInt();
        this.pricesInfo = (OrderDetailPricesInfo) parcel.readParcelable(OrderDetailPricesInfo.class.getClassLoader());
        this.amountDetailList = parcel.createTypedArrayList(OrderDetailAmountDetail.CREATOR);
        this.id = parcel.readString();
        this.createTimeStr = parcel.readString();
        this.currentTime = parcel.readLong();
        this.payTimeStr = parcel.readString();
        this.shipmentsTimeStr = parcel.readString();
        this.bargainOnTimeStr = parcel.readString();
        this.aliPayTradeNo = parcel.readString();
        this.deliveryMethodInfo = (OrderDetailDeliveryInfo) parcel.readParcelable(OrderDetailDeliveryInfo.class.getClassLoader());
        this.orderCode = parcel.readString();
        this.audiences = parcel.createTypedArrayList(OrderDetailAudienceInfo.CREATOR);
        this.isSupportInvoice = parcel.readByte() != 0;
        this.invoice = (OrderDetailInvoiceInfo) parcel.readParcelable(OrderDetailInvoiceInfo.class.getClassLoader());
        this.payWayName = parcel.readString();
        this.dialogTips = parcel.readString();
        this.orderShareDTO = (OrderDetailShareBean) parcel.readParcelable(OrderDetailShareBean.class.getClassLoader());
        this.paymentInfoList = parcel.createTypedArrayList(OrderDetailPayInfo.CREATOR);
        this.buttonList = (OrderDetailButtonBean) parcel.readParcelable(OrderDetailButtonBean.class.getClassLoader());
        this.dmPickupAddress = (DmPickupAddressBean) parcel.readSerializable();
        this.modifyAddressToast = parcel.readString();
        this.applyInvoiceToast = parcel.readString();
        this.paymentInfoTips = parcel.readString();
        this.orderSource = parcel.readInt();
        this.purchaseNotice = (PurchaseNotice) parcel.readParcelable(PurchaseNotice.class.getClassLoader());
        this.ruleContexts = parcel.createTypedArrayList(OrderDetailTicketService.CREATOR);
        this.reservedDesc = parcel.readString();
        this.announcementImgUrl = parcel.readString();
        this.announcementTargetUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46067816")) {
            ipChange.ipc$dispatch("-46067816", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.statusInfo, i);
        parcel.writeTypedList(this.faqItems);
        parcel.writeString(this.realNameViewing);
        parcel.writeSerializable(this.serviceOrderInfo);
        parcel.writeLong(this.overdueTime);
        parcel.writeString(this.statusMessage);
        parcel.writeParcelable(this.consigneeAddress, i);
        parcel.writeParcelable(this.mecItemInfo, i);
        parcel.writeInt(this.quantity);
        parcel.writeParcelable(this.pricesInfo, i);
        parcel.writeTypedList(this.amountDetailList);
        parcel.writeString(this.id);
        parcel.writeString(this.createTimeStr);
        parcel.writeLong(this.currentTime);
        parcel.writeString(this.payTimeStr);
        parcel.writeString(this.shipmentsTimeStr);
        parcel.writeString(this.bargainOnTimeStr);
        parcel.writeString(this.aliPayTradeNo);
        parcel.writeParcelable(this.deliveryMethodInfo, i);
        parcel.writeString(this.orderCode);
        parcel.writeTypedList(this.audiences);
        parcel.writeByte(this.isSupportInvoice ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.invoice, i);
        parcel.writeString(this.payWayName);
        parcel.writeString(this.dialogTips);
        parcel.writeParcelable(this.orderShareDTO, i);
        parcel.writeTypedList(this.paymentInfoList);
        parcel.writeParcelable(this.buttonList, i);
        parcel.writeSerializable(this.dmPickupAddress);
        parcel.writeString(this.modifyAddressToast);
        parcel.writeString(this.applyInvoiceToast);
        parcel.writeString(this.paymentInfoTips);
        parcel.writeInt(this.orderSource);
        parcel.writeParcelable(this.purchaseNotice, i);
        parcel.writeTypedList(this.ruleContexts);
        parcel.writeString(this.reservedDesc);
        parcel.writeString(this.announcementImgUrl);
        parcel.writeString(this.announcementTargetUrl);
    }

    protected OrderDetailBean(Parcel parcel) {
        this.statusInfo = (OrderDetailStatusBean) parcel.readParcelable(OrderDetailStatusBean.class.getClassLoader());
        this.faqItems = parcel.createTypedArrayList(OrderDetailFaq.CREATOR);
        this.realNameViewing = parcel.readString();
        this.serviceOrderInfo = (ServiceOrderInfo) parcel.readSerializable();
        this.overdueTime = parcel.readLong();
        this.statusMessage = parcel.readString();
        this.consigneeAddress = (OrderDetailAddressBean) parcel.readParcelable(OrderDetailAddressBean.class.getClassLoader());
        this.mecItemInfo = (OrderDetailMecItemInfo) parcel.readParcelable(OrderDetailMecItemInfo.class.getClassLoader());
        this.quantity = parcel.readInt();
        this.pricesInfo = (OrderDetailPricesInfo) parcel.readParcelable(OrderDetailPricesInfo.class.getClassLoader());
        this.amountDetailList = parcel.createTypedArrayList(OrderDetailAmountDetail.CREATOR);
        this.id = parcel.readString();
        this.createTimeStr = parcel.readString();
        this.currentTime = parcel.readLong();
        this.payTimeStr = parcel.readString();
        this.shipmentsTimeStr = parcel.readString();
        this.bargainOnTimeStr = parcel.readString();
        this.aliPayTradeNo = parcel.readString();
        this.deliveryMethodInfo = (OrderDetailDeliveryInfo) parcel.readParcelable(OrderDetailDeliveryInfo.class.getClassLoader());
        this.orderCode = parcel.readString();
        this.audiences = parcel.createTypedArrayList(OrderDetailAudienceInfo.CREATOR);
        this.isSupportInvoice = parcel.readByte() != 0;
        this.invoice = (OrderDetailInvoiceInfo) parcel.readParcelable(OrderDetailInvoiceInfo.class.getClassLoader());
        this.payWayName = parcel.readString();
        this.dialogTips = parcel.readString();
        this.orderShareDTO = (OrderDetailShareBean) parcel.readParcelable(OrderDetailShareBean.class.getClassLoader());
        this.paymentInfoList = parcel.createTypedArrayList(OrderDetailPayInfo.CREATOR);
        this.buttonList = (OrderDetailButtonBean) parcel.readParcelable(OrderDetailButtonBean.class.getClassLoader());
        this.dmPickupAddress = (DmPickupAddressBean) parcel.readSerializable();
        this.modifyAddressToast = parcel.readString();
        this.applyInvoiceToast = parcel.readString();
        this.paymentInfoTips = parcel.readString();
        this.orderSource = parcel.readInt();
        this.purchaseNotice = (PurchaseNotice) parcel.readParcelable(PurchaseNotice.class.getClassLoader());
        this.ruleContexts = parcel.createTypedArrayList(OrderDetailTicketService.CREATOR);
        this.reservedDesc = parcel.readString();
        this.announcementImgUrl = parcel.readString();
        this.announcementTargetUrl = parcel.readString();
    }
}
