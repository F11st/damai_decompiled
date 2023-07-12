package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class RealNameCustomerListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameCustomerListBean> CREATOR = new Parcelable.Creator<RealNameCustomerListBean>() { // from class: cn.damai.mine.bean.RealNameCustomerListBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealNameCustomerListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "873551645") ? (RealNameCustomerListBean) ipChange.ipc$dispatch("873551645", new Object[]{this, parcel}) : new RealNameCustomerListBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealNameCustomerListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1977492848") ? (RealNameCustomerListBean[]) ipChange.ipc$dispatch("1977492848", new Object[]{this, Integer.valueOf(i)}) : new RealNameCustomerListBean[i];
        }
    };
    private ArrayList<RealNameCustomerBean> result;

    public RealNameCustomerListBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1749219554")) {
            return ((Integer) ipChange.ipc$dispatch("-1749219554", new Object[]{this})).intValue();
        }
        return 0;
    }

    public ArrayList<RealNameCustomerBean> getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2002027167") ? (ArrayList) ipChange.ipc$dispatch("-2002027167", new Object[]{this}) : this.result;
    }

    public void setResult(ArrayList<RealNameCustomerBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677983473")) {
            ipChange.ipc$dispatch("-1677983473", new Object[]{this, arrayList});
        } else {
            this.result = arrayList;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169595757")) {
            ipChange.ipc$dispatch("1169595757", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeTypedList(this.result);
        }
    }

    protected RealNameCustomerListBean(Parcel parcel) {
        this.result = parcel.createTypedArrayList(RealNameCustomerBean.CREATOR);
    }
}
