package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailAudienceInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailAudienceInfo> CREATOR = new Parcelable.Creator<OrderDetailAudienceInfo>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAudienceInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailAudienceInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "150260619") ? (OrderDetailAudienceInfo) ipChange.ipc$dispatch("150260619", new Object[]{this, parcel}) : new OrderDetailAudienceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailAudienceInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "605128330") ? (OrderDetailAudienceInfo[]) ipChange.ipc$dispatch("605128330", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailAudienceInfo[i];
        }
    };
    public String hashIdentityNumber;
    public String identifier;
    public String name;
    public String typeName;

    public OrderDetailAudienceInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2029799733")) {
            return ((Integer) ipChange.ipc$dispatch("2029799733", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874783286")) {
            ipChange.ipc$dispatch("1874783286", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.hashIdentityNumber);
        parcel.writeString(this.identifier);
        parcel.writeString(this.name);
        parcel.writeString(this.typeName);
    }

    protected OrderDetailAudienceInfo(Parcel parcel) {
        this.hashIdentityNumber = parcel.readString();
        this.identifier = parcel.readString();
        this.name = parcel.readString();
        this.typeName = parcel.readString();
    }
}
