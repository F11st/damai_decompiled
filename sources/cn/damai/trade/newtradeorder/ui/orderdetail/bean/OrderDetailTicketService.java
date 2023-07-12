package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailTicketService implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailTicketService> CREATOR = new Parcelable.Creator<OrderDetailTicketService>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailTicketService.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailTicketService createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-519634191") ? (OrderDetailTicketService) ipChange.ipc$dispatch("-519634191", new Object[]{this, parcel}) : new OrderDetailTicketService(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailTicketService[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1083940400") ? (OrderDetailTicketService[]) ipChange.ipc$dispatch("1083940400", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailTicketService[i];
        }
    };
    public String contexts;
    public String contextsWithStyle;
    public String imgUrl;
    public String ruleName;
    public OrderDetailTicketServiceTitle title;

    public OrderDetailTicketService() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644814316")) {
            return ((Integer) ipChange.ipc$dispatch("-1644814316", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505592944")) {
            ipChange.ipc$dispatch("1505592944", new Object[]{this, parcel});
            return;
        }
        this.contexts = parcel.readString();
        this.contextsWithStyle = parcel.readString();
        this.imgUrl = parcel.readString();
        this.ruleName = parcel.readString();
        this.title = (OrderDetailTicketServiceTitle) parcel.readParcelable(OrderDetailTicketServiceTitle.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369111241")) {
            ipChange.ipc$dispatch("-369111241", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.contexts);
        parcel.writeString(this.contextsWithStyle);
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.ruleName);
        parcel.writeParcelable(this.title, i);
    }

    protected OrderDetailTicketService(Parcel parcel) {
        this.contexts = parcel.readString();
        this.contextsWithStyle = parcel.readString();
        this.imgUrl = parcel.readString();
        this.ruleName = parcel.readString();
        this.title = (OrderDetailTicketServiceTitle) parcel.readParcelable(OrderDetailTicketServiceTitle.class.getClassLoader());
    }
}
