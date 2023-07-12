package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DivisionListDataBean extends BaseOutDo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DivisionListDataBean> CREATOR = new Parcelable.Creator<DivisionListDataBean>() { // from class: cn.damai.commonbusiness.address.bean.DivisionListDataBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DivisionListDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1608517443") ? (DivisionListDataBean) ipChange.ipc$dispatch("1608517443", new Object[]{this, parcel}) : new DivisionListDataBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DivisionListDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1992343184") ? (DivisionListDataBean[]) ipChange.ipc$dispatch("1992343184", new Object[]{this, Integer.valueOf(i)}) : new DivisionListDataBean[i];
        }
    };
    private DivisionListBean data;

    public DivisionListDataBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377515445")) {
            return ((Integer) ipChange.ipc$dispatch("-1377515445", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void setData(DivisionListBean divisionListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428665258")) {
            ipChange.ipc$dispatch("428665258", new Object[]{this, divisionListBean});
        } else {
            this.data = divisionListBean;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343032864")) {
            ipChange.ipc$dispatch("-343032864", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeParcelable(this.data, i);
        }
    }

    protected DivisionListDataBean(Parcel parcel) {
        this.data = (DivisionListBean) parcel.readParcelable(DivisionListBean.class.getClassLoader());
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public DivisionListBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2029389896") ? (DivisionListBean) ipChange.ipc$dispatch("2029389896", new Object[]{this}) : this.data;
    }
}
