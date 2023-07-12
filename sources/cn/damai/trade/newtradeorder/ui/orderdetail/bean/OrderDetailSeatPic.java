package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailSeatPic implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailSeatPic> CREATOR = new Parcelable.Creator<OrderDetailSeatPic>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSeatPic.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatPic createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-354377543") ? (OrderDetailSeatPic) ipChange.ipc$dispatch("-354377543", new Object[]{this, parcel}) : new OrderDetailSeatPic(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatPic[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "715933232") ? (OrderDetailSeatPic[]) ipChange.ipc$dispatch("715933232", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailSeatPic[i];
        }
    };
    public String fontColor;
    public String text;
    public String url;

    public OrderDetailSeatPic() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "169117008")) {
            return ((Integer) ipChange.ipc$dispatch("169117008", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "503908731")) {
            ipChange.ipc$dispatch("503908731", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.text);
        parcel.writeString(this.fontColor);
        parcel.writeString(this.url);
    }

    protected OrderDetailSeatPic(Parcel parcel) {
        this.text = parcel.readString();
        this.fontColor = parcel.readString();
        this.url = parcel.readString();
    }
}
