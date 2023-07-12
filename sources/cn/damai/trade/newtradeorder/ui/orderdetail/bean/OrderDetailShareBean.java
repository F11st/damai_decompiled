package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailShareBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailShareBean> CREATOR = new Parcelable.Creator<OrderDetailShareBean>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailShareBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailShareBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "149997989") ? (OrderDetailShareBean) ipChange.ipc$dispatch("149997989", new Object[]{this, parcel}) : new OrderDetailShareBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailShareBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-861898256") ? (OrderDetailShareBean[]) ipChange.ipc$dispatch("-861898256", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailShareBean[i];
        }
    };
    public String cityAndTime;
    public String projectId;
    public String projectImage;
    public String projectName;
    public String showShare;

    public OrderDetailShareBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "364329914")) {
            return ((Integer) ipChange.ipc$dispatch("364329914", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isShowShare() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-28136502") ? ((Boolean) ipChange.ipc$dispatch("-28136502", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.showShare) && this.showShare.equals("true");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1513049007")) {
            ipChange.ipc$dispatch("-1513049007", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.showShare);
        }
    }

    protected OrderDetailShareBean(Parcel parcel) {
        this.showShare = parcel.readString();
    }
}
