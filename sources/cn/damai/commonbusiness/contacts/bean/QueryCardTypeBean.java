package cn.damai.commonbusiness.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class QueryCardTypeBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<QueryCardTypeBean> CREATOR = new Parcelable.Creator<QueryCardTypeBean>() { // from class: cn.damai.commonbusiness.contacts.bean.QueryCardTypeBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QueryCardTypeBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1010364137") ? (QueryCardTypeBean) ipChange.ipc$dispatch("-1010364137", new Object[]{this, parcel}) : new QueryCardTypeBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QueryCardTypeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1226554384") ? (QueryCardTypeBean[]) ipChange.ipc$dispatch("1226554384", new Object[]{this, Integer.valueOf(i)}) : new QueryCardTypeBean[i];
        }
    };
    List<CustomerType> customerTypeList;
    String tipInfo;

    public QueryCardTypeBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1223318559")) {
            return ((Integer) ipChange.ipc$dispatch("-1223318559", new Object[]{this})).intValue();
        }
        return 0;
    }

    public List<CustomerType> getCustomerTypeList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1568719292") ? (List) ipChange.ipc$dispatch("1568719292", new Object[]{this}) : this.customerTypeList;
    }

    public String getTipInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "577641888") ? (String) ipChange.ipc$dispatch("577641888", new Object[]{this}) : this.tipInfo;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771328445")) {
            ipChange.ipc$dispatch("-771328445", new Object[]{this, parcel});
            return;
        }
        this.tipInfo = parcel.readString();
        this.customerTypeList = parcel.createTypedArrayList(CustomerType.CREATOR);
    }

    public void setCustomerTypeList(List<CustomerType> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1120869488")) {
            ipChange.ipc$dispatch("-1120869488", new Object[]{this, list});
        } else {
            this.customerTypeList = list;
        }
    }

    public void setTipInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-889224234")) {
            ipChange.ipc$dispatch("-889224234", new Object[]{this, str});
        } else {
            this.tipInfo = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1648934666")) {
            ipChange.ipc$dispatch("1648934666", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.tipInfo);
        parcel.writeTypedList(this.customerTypeList);
    }

    protected QueryCardTypeBean(Parcel parcel) {
        this.tipInfo = parcel.readString();
        this.customerTypeList = parcel.createTypedArrayList(CustomerType.CREATOR);
    }
}
