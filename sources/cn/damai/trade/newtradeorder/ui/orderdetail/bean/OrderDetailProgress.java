package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.OrderDetailPriceInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailProgress implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailProgress> CREATOR = new Parcelable.Creator<OrderDetailProgress>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailProgress.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailProgress createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1371528213") ? (OrderDetailProgress) ipChange.ipc$dispatch("-1371528213", new Object[]{this, parcel}) : new OrderDetailProgress(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailProgress[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1024474284") ? (OrderDetailProgress[]) ipChange.ipc$dispatch("-1024474284", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailProgress[i];
        }
    };
    public List<OrderDetailProgressBtn> buttonList;
    public long chooseSeatTime;
    public String chooseSeatTips;
    public String countDownDescPrefix;
    public String countDownDescSuffix;
    public String performId;
    public String performName;
    public List<OrderDetailPriceInfo> priceInfoList;
    public int progressType;
    public String rowNo;
    public String rowNoDesc;
    public String showCityId;
    public String url;

    public OrderDetailProgress() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961172912")) {
            return ((Integer) ipChange.ipc$dispatch("-961172912", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean supportJumpPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013339520")) {
            return ((Boolean) ipChange.ipc$dispatch("1013339520", new Object[]{this})).booleanValue();
        }
        int i = this.progressType;
        return i == 1 || i == 2;
    }

    public boolean supportJumpProgressPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2015983763") ? ((Boolean) ipChange.ipc$dispatch("2015983763", new Object[]{this})).booleanValue() : this.progressType == 1;
    }

    public boolean supportJumpWebPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-835298848") ? ((Boolean) ipChange.ipc$dispatch("-835298848", new Object[]{this})).booleanValue() : this.progressType == 2 && !TextUtils.isEmpty(this.url);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "758547579")) {
            ipChange.ipc$dispatch("758547579", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.countDownDescPrefix);
        parcel.writeString(this.countDownDescSuffix);
        parcel.writeString(this.chooseSeatTips);
        parcel.writeString(this.rowNo);
        parcel.writeString(this.rowNoDesc);
        parcel.writeLong(this.chooseSeatTime);
        parcel.writeTypedList(this.buttonList);
        parcel.writeInt(this.progressType);
        parcel.writeString(this.url);
        parcel.writeString(this.showCityId);
        parcel.writeString(this.performId);
        parcel.writeString(this.performName);
        parcel.writeTypedList(this.priceInfoList);
    }

    protected OrderDetailProgress(Parcel parcel) {
        this.countDownDescPrefix = parcel.readString();
        this.countDownDescSuffix = parcel.readString();
        this.chooseSeatTips = parcel.readString();
        this.rowNo = parcel.readString();
        this.rowNoDesc = parcel.readString();
        this.chooseSeatTime = parcel.readLong();
        this.buttonList = parcel.createTypedArrayList(OrderDetailProgressBtn.CREATOR);
        this.progressType = parcel.readInt();
        this.url = parcel.readString();
        this.showCityId = parcel.readString();
        this.performId = parcel.readString();
        this.performName = parcel.readString();
        this.priceInfoList = parcel.createTypedArrayList(OrderDetailPriceInfo.CREATOR);
    }
}
