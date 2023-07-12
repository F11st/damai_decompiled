package cn.damai.commonbusiness.seatbiz.orderlist.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class OrderFirstPayChooseSeatButton implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderFirstPayChooseSeatButton> CREATOR = new Parcelable.Creator<OrderFirstPayChooseSeatButton>() { // from class: cn.damai.commonbusiness.seatbiz.orderlist.bean.OrderFirstPayChooseSeatButton.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderFirstPayChooseSeatButton createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1575009931") ? (OrderFirstPayChooseSeatButton) ipChange.ipc$dispatch("1575009931", new Object[]{this, parcel}) : new OrderFirstPayChooseSeatButton(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderFirstPayChooseSeatButton[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2058713750") ? (OrderFirstPayChooseSeatButton[]) ipChange.ipc$dispatch("-2058713750", new Object[]{this, Integer.valueOf(i)}) : new OrderFirstPayChooseSeatButton[i];
        }
    };
    public String name;
    public int type;

    public OrderFirstPayChooseSeatButton() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1475567995")) {
            return ((Integer) ipChange.ipc$dispatch("-1475567995", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "542761190")) {
            ipChange.ipc$dispatch("542761190", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeString(this.name);
    }

    protected OrderFirstPayChooseSeatButton(Parcel parcel) {
        this.type = parcel.readInt();
        this.name = parcel.readString();
    }
}
