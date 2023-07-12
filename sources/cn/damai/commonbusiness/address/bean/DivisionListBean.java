package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DivisionListBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DivisionListBean> CREATOR = new Parcelable.Creator<DivisionListBean>() { // from class: cn.damai.commonbusiness.address.bean.DivisionListBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DivisionListBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2088943191") ? (DivisionListBean) ipChange.ipc$dispatch("2088943191", new Object[]{this, parcel}) : new DivisionListBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DivisionListBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-117675056") ? (DivisionListBean[]) ipChange.ipc$dispatch("-117675056", new Object[]{this, Integer.valueOf(i)}) : new DivisionListBean[i];
        }
    };
    private String code;
    private List<DivisionBean> model;

    public DivisionListBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "895076865")) {
            return ((Integer) ipChange.ipc$dispatch("895076865", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "632929900") ? (String) ipChange.ipc$dispatch("632929900", new Object[]{this}) : this.code;
    }

    public List<DivisionBean> getModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "386151271") ? (List) ipChange.ipc$dispatch("386151271", new Object[]{this}) : this.model;
    }

    public void setCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146766350")) {
            ipChange.ipc$dispatch("-2146766350", new Object[]{this, str});
        } else {
            this.code = str;
        }
    }

    public void setModel(List<DivisionBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1409882333")) {
            ipChange.ipc$dispatch("1409882333", new Object[]{this, list});
        } else {
            this.model = list;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296641302")) {
            ipChange.ipc$dispatch("-296641302", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.code);
        parcel.writeTypedList(this.model);
    }

    protected DivisionListBean(Parcel parcel) {
        this.code = parcel.readString();
        this.model = parcel.createTypedArrayList(DivisionBean.CREATOR);
    }
}
