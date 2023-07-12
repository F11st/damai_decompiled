package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CustomerListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CustomerListBean> CREATOR = new Parcelable.Creator<CustomerListBean>() { // from class: cn.damai.mine.bean.CustomerListBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomerListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "487714031") ? (CustomerListBean) ipChange.ipc$dispatch("487714031", new Object[]{this, parcel}) : new CustomerListBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CustomerListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "539335952") ? (CustomerListBean[]) ipChange.ipc$dispatch("539335952", new Object[]{this, Integer.valueOf(i)}) : new CustomerListBean[i];
        }
    };
    private List<CustomerBean> result;

    public CustomerListBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1823006091")) {
            return ((Integer) ipChange.ipc$dispatch("-1823006091", new Object[]{this})).intValue();
        }
        return 0;
    }

    public List<CustomerBean> getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1801456457") ? (List) ipChange.ipc$dispatch("-1801456457", new Object[]{this}) : this.result;
    }

    public void setResult(List<CustomerBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602214645")) {
            ipChange.ipc$dispatch("602214645", new Object[]{this, list});
        } else {
            this.result = list;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506873098")) {
            ipChange.ipc$dispatch("-506873098", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeTypedList(this.result);
        }
    }

    protected CustomerListBean(Parcel parcel) {
        this.result = parcel.createTypedArrayList(CustomerBean.CREATOR);
    }
}
