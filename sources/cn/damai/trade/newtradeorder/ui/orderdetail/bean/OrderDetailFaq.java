package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailFaq implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailFaq> CREATOR = new Parcelable.Creator<OrderDetailFaq>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailFaq.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailFaq createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2068981271") ? (OrderDetailFaq) ipChange.ipc$dispatch("2068981271", new Object[]{this, parcel}) : new OrderDetailFaq(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailFaq[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "577084688") ? (OrderDetailFaq[]) ipChange.ipc$dispatch("577084688", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailFaq[i];
        }
    };
    public String question;

    public OrderDetailFaq() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1726854753")) {
            return ((Integer) ipChange.ipc$dispatch("1726854753", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-397935478")) {
            ipChange.ipc$dispatch("-397935478", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.question);
        }
    }

    protected OrderDetailFaq(Parcel parcel) {
        this.question = parcel.readString();
    }
}
