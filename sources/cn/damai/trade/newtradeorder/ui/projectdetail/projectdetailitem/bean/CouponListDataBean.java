package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class CouponListDataBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CouponListDataBean> CREATOR = new Parcelable.Creator<CouponListDataBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponListDataBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CouponListDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1215517655") ? (CouponListDataBean) ipChange.ipc$dispatch("1215517655", new Object[]{this, parcel}) : new CouponListDataBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CouponListDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1209109520") ? (CouponListDataBean[]) ipChange.ipc$dispatch("1209109520", new Object[]{this, Integer.valueOf(i)}) : new CouponListDataBean[i];
        }
    };
    private List<CouponActivityBean> couponActivities;

    public CouponListDataBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1614272895")) {
            return ((Integer) ipChange.ipc$dispatch("-1614272895", new Object[]{this})).intValue();
        }
        return 0;
    }

    public List<CouponActivityBean> getCouponActivities() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1660677415") ? (List) ipChange.ipc$dispatch("-1660677415", new Object[]{this}) : this.couponActivities;
    }

    public void setCouponActivities(List<CouponActivityBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847047699")) {
            ipChange.ipc$dispatch("1847047699", new Object[]{this, list});
        } else {
            this.couponActivities = list;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546137494")) {
            ipChange.ipc$dispatch("-1546137494", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeTypedList(this.couponActivities);
        }
    }

    protected CouponListDataBean(Parcel parcel) {
        this.couponActivities = parcel.createTypedArrayList(CouponActivityBean.CREATOR);
    }
}
