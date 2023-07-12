package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailTicketServiceTitle implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailTicketServiceTitle> CREATOR = new Parcelable.Creator<OrderDetailTicketServiceTitle>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailTicketServiceTitle.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailTicketServiceTitle createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-157482389") ? (OrderDetailTicketServiceTitle) ipChange.ipc$dispatch("-157482389", new Object[]{this, parcel}) : new OrderDetailTicketServiceTitle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailTicketServiceTitle[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "239205392") ? (OrderDetailTicketServiceTitle[]) ipChange.ipc$dispatch("239205392", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailTicketServiceTitle[i];
        }
    };
    public String fontColor;
    public String fontSize;
    public String icon;
    public String text;

    public OrderDetailTicketServiceTitle() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1443195534")) {
            return ((Integer) ipChange.ipc$dispatch("-1443195534", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1067122279")) {
            ipChange.ipc$dispatch("-1067122279", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.text);
        parcel.writeString(this.fontColor);
        parcel.writeString(this.fontSize);
        parcel.writeString(this.icon);
    }

    protected OrderDetailTicketServiceTitle(Parcel parcel) {
        this.text = parcel.readString();
        this.fontColor = parcel.readString();
        this.fontSize = parcel.readString();
        this.icon = parcel.readString();
    }
}
