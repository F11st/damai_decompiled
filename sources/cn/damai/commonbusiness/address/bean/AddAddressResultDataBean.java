package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class AddAddressResultDataBean extends BaseOutDo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddAddressResultDataBean> CREATOR = new Parcelable.Creator<AddAddressResultDataBean>() { // from class: cn.damai.commonbusiness.address.bean.AddAddressResultDataBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddAddressResultDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-858874311") ? (AddAddressResultDataBean) ipChange.ipc$dispatch("-858874311", new Object[]{this, parcel}) : new AddAddressResultDataBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddAddressResultDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "208704688") ? (AddAddressResultDataBean[]) ipChange.ipc$dispatch("208704688", new Object[]{this, Integer.valueOf(i)}) : new AddAddressResultDataBean[i];
        }
    };
    private AddAddressResultBean data;

    public AddAddressResultDataBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848182992")) {
            return ((Integer) ipChange.ipc$dispatch("-848182992", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void setData(AddAddressResultBean addAddressResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1858338314")) {
            ipChange.ipc$dispatch("1858338314", new Object[]{this, addAddressResultBean});
        } else {
            this.data = addAddressResultBean;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2131691931")) {
            ipChange.ipc$dispatch("2131691931", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeParcelable(this.data, i);
        }
    }

    protected AddAddressResultDataBean(Parcel parcel) {
        this.data = (AddAddressResultBean) parcel.readParcelable(AddAddressResultBean.class.getClassLoader());
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public AddAddressResultBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "361254398") ? (AddAddressResultBean) ipChange.ipc$dispatch("361254398", new Object[]{this}) : this.data;
    }
}
