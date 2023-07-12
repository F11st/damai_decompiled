package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailProgressBtn implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailProgressBtn> CREATOR = new Parcelable.Creator<OrderDetailProgressBtn>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailProgressBtn.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailProgressBtn createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "323922661") ? (OrderDetailProgressBtn) ipChange.ipc$dispatch("323922661", new Object[]{this, parcel}) : new OrderDetailProgressBtn(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailProgressBtn[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2041656304") ? (OrderDetailProgressBtn[]) ipChange.ipc$dispatch("2041656304", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailProgressBtn[i];
        }
    };
    public String buttonName;
    public int buttonType;
    public String toast;
    public String url;

    public OrderDetailProgressBtn() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1779128186")) {
            return ((Integer) ipChange.ipc$dispatch("1779128186", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-734031727")) {
            ipChange.ipc$dispatch("-734031727", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.buttonName);
        parcel.writeInt(this.buttonType);
        parcel.writeString(this.url);
        parcel.writeString(this.toast);
    }

    protected OrderDetailProgressBtn(Parcel parcel) {
        this.buttonName = parcel.readString();
        this.buttonType = parcel.readInt();
        this.url = parcel.readString();
        this.toast = parcel.readString();
    }
}
