package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class DynamicExtData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DynamicExtData> CREATOR = new Parcelable.Creator<DynamicExtData>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.DynamicExtData.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicExtData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "792289995") ? (DynamicExtData) ipChange.ipc$dispatch("792289995", new Object[]{this, parcel}) : new DynamicExtData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicExtData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "50419782") ? (DynamicExtData[]) ipChange.ipc$dispatch("50419782", new Object[]{this, Integer.valueOf(i)}) : new DynamicExtData[i];
        }
    };
    private String subFlag;

    public DynamicExtData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1719027543")) {
            return ((Integer) ipChange.ipc$dispatch("1719027543", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getSubFlag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-743816499") ? (String) ipChange.ipc$dispatch("-743816499", new Object[]{this}) : this.subFlag;
    }

    public void setSubFlag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1095238729")) {
            ipChange.ipc$dispatch("1095238729", new Object[]{this, str});
        } else {
            this.subFlag = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585058732")) {
            ipChange.ipc$dispatch("-585058732", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.subFlag);
        }
    }

    protected DynamicExtData(Parcel parcel) {
        this.subFlag = parcel.readString();
    }
}
