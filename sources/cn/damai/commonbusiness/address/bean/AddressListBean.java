package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AddressListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddressListBean> CREATOR = new Parcelable.Creator<AddressListBean>() { // from class: cn.damai.commonbusiness.address.bean.AddressListBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddressListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "309824811") ? (AddressListBean) ipChange.ipc$dispatch("309824811", new Object[]{this, parcel}) : new AddressListBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddressListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1661244000") ? (AddressListBean[]) ipChange.ipc$dispatch("1661244000", new Object[]{this, Integer.valueOf(i)}) : new AddressListBean[i];
        }
    };
    private String ableAdd;
    private String districtMsg;
    private List<AddressBean> list;
    private String msg;

    public AddressListBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643382858")) {
            return ((Integer) ipChange.ipc$dispatch("643382858", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getAbleAdd() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "801246613") ? (String) ipChange.ipc$dispatch("801246613", new Object[]{this}) : this.ableAdd;
    }

    public String getDistrictMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1029911999") ? (String) ipChange.ipc$dispatch("-1029911999", new Object[]{this}) : this.districtMsg;
    }

    public List<AddressBean> getList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-627437299") ? (List) ipChange.ipc$dispatch("-627437299", new Object[]{this}) : this.list;
    }

    public String getMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1679808687") ? (String) ipChange.ipc$dispatch("1679808687", new Object[]{this}) : this.msg;
    }

    public void setAbleAdd(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1747554945")) {
            ipChange.ipc$dispatch("1747554945", new Object[]{this, str});
        } else {
            this.ableAdd = str;
        }
    }

    public void setDistrictMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132515157")) {
            ipChange.ipc$dispatch("132515157", new Object[]{this, str});
        } else {
            this.districtMsg = str;
        }
    }

    public void setList(List<AddressBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1771179103")) {
            ipChange.ipc$dispatch("1771179103", new Object[]{this, list});
        } else {
            this.list = list;
        }
    }

    public void setMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953009831")) {
            ipChange.ipc$dispatch("1953009831", new Object[]{this, str});
        } else {
            this.msg = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1665278913")) {
            ipChange.ipc$dispatch("1665278913", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.ableAdd);
        parcel.writeTypedList(this.list);
        parcel.writeString(this.msg);
        parcel.writeString(this.districtMsg);
    }

    protected AddressListBean(Parcel parcel) {
        this.ableAdd = parcel.readString();
        this.list = parcel.createTypedArrayList(AddressBean.CREATOR);
        this.msg = parcel.readString();
        this.districtMsg = parcel.readString();
    }
}
