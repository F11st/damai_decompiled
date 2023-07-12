package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailPayInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailPayInfo> CREATOR = new Parcelable.Creator<OrderDetailPayInfo>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailPayInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1852482135") ? (OrderDetailPayInfo) ipChange.ipc$dispatch("1852482135", new Object[]{this, parcel}) : new OrderDetailPayInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailPayInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "489429392") ? (OrderDetailPayInfo[]) ipChange.ipc$dispatch("489429392", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailPayInfo[i];
        }
    };
    public String iconUrl;
    public boolean isSelected;
    public int mDemoIndex;
    public String payCode;
    public String payName;
    public String payTips;
    public int payTypeId;
    public String paymentInfoExt;
    public boolean selected;

    public OrderDetailPayInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554639679")) {
            return ((Integer) ipChange.ipc$dispatch("-554639679", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "141317987")) {
            ipChange.ipc$dispatch("141317987", new Object[]{this, parcel});
            return;
        }
        this.payCode = parcel.readString();
        this.payName = parcel.readString();
        this.payTypeId = parcel.readInt();
        this.iconUrl = parcel.readString();
        this.payTips = parcel.readString();
        this.paymentInfoExt = parcel.readString();
        this.isSelected = parcel.readByte() != 0;
        this.selected = parcel.readByte() != 0;
        this.mDemoIndex = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733386198")) {
            ipChange.ipc$dispatch("-1733386198", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.payCode);
        parcel.writeString(this.payName);
        parcel.writeInt(this.payTypeId);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.payTips);
        parcel.writeString(this.paymentInfoExt);
        parcel.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.selected ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mDemoIndex);
    }

    protected OrderDetailPayInfo(Parcel parcel) {
        this.payCode = parcel.readString();
        this.payName = parcel.readString();
        this.payTypeId = parcel.readInt();
        this.iconUrl = parcel.readString();
        this.payTips = parcel.readString();
        this.paymentInfoExt = parcel.readString();
        this.isSelected = parcel.readByte() != 0;
        this.selected = parcel.readByte() != 0;
        this.mDemoIndex = parcel.readInt();
    }
}
