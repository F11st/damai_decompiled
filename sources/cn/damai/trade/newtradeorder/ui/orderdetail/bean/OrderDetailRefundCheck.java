package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailRefundCheck implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailRefundCheck> CREATOR = new Parcelable.Creator<OrderDetailRefundCheck>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailRefundCheck.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailRefundCheck createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2091286115") ? (OrderDetailRefundCheck) ipChange.ipc$dispatch("2091286115", new Object[]{this, parcel}) : new OrderDetailRefundCheck(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailRefundCheck[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2092020528") ? (OrderDetailRefundCheck[]) ipChange.ipc$dispatch("-2092020528", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailRefundCheck[i];
        }
    };
    public String canApply;
    public String failReason;

    public OrderDetailRefundCheck() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690300869")) {
            return ((Integer) ipChange.ipc$dispatch("-690300869", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isCanApply() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-345434711") ? ((Boolean) ipChange.ipc$dispatch("-345434711", new Object[]{this})).booleanValue() : TextUtils.isEmpty(this.canApply) || !this.canApply.equals("false");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497317392")) {
            ipChange.ipc$dispatch("-497317392", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.canApply);
        parcel.writeString(this.failReason);
    }

    protected OrderDetailRefundCheck(Parcel parcel) {
        this.canApply = parcel.readString();
        this.failReason = parcel.readString();
    }
}
