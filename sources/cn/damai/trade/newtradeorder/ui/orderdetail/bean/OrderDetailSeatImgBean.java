package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailSeatImgBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailSeatImgBean> CREATOR = new Parcelable.Creator<OrderDetailSeatImgBean>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailSeatImgBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatImgBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1015739993") ? (OrderDetailSeatImgBean) ipChange.ipc$dispatch("-1015739993", new Object[]{this, parcel}) : new OrderDetailSeatImgBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailSeatImgBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1678384912") ? (OrderDetailSeatImgBean[]) ipChange.ipc$dispatch("1678384912", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailSeatImgBean[i];
        }
    };
    public String hasNoneSeatImg;
    public String seatImg;

    public OrderDetailSeatImgBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436006297")) {
            return ((Integer) ipChange.ipc$dispatch("436006297", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isHasNoneSeatImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1948757273") ? ((Boolean) ipChange.ipc$dispatch("1948757273", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.hasNoneSeatImg) && this.hasNoneSeatImg.equals("true");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "748100690")) {
            ipChange.ipc$dispatch("748100690", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.hasNoneSeatImg);
        parcel.writeString(this.seatImg);
    }

    protected OrderDetailSeatImgBean(Parcel parcel) {
        this.hasNoneSeatImg = parcel.readString();
        this.seatImg = parcel.readString();
    }
}
