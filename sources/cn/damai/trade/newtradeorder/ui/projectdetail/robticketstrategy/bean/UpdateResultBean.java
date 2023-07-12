package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class UpdateResultBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<UpdateResultBean> CREATOR = new Parcelable.Creator<UpdateResultBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.bean.UpdateResultBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateResultBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1537474855") ? (UpdateResultBean) ipChange.ipc$dispatch("-1537474855", new Object[]{this, parcel}) : new UpdateResultBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateResultBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1331617968") ? (UpdateResultBean[]) ipChange.ipc$dispatch("1331617968", new Object[]{this, Integer.valueOf(i)}) : new UpdateResultBean[i];
        }
    };
    public String hasUpdate;

    public UpdateResultBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672034400")) {
            return ((Integer) ipChange.ipc$dispatch("1672034400", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382805909")) {
            ipChange.ipc$dispatch("-382805909", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.hasUpdate);
        }
    }

    protected UpdateResultBean(Parcel parcel) {
        this.hasUpdate = parcel.readString();
    }
}
