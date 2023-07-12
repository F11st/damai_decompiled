package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ItemData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ItemData> CREATOR = new Parcelable.Creator<ItemData>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ItemData.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ItemData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1921897173") ? (ItemData) ipChange.ipc$dispatch("-1921897173", new Object[]{this, parcel}) : new ItemData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ItemData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "628657380") ? (ItemData[]) ipChange.ipc$dispatch("628657380", new Object[]{this, Integer.valueOf(i)}) : new ItemData[i];
        }
    };
    private String buyBtnStatus;
    private String buyBtnText;

    public ItemData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "508149960")) {
            return ((Integer) ipChange.ipc$dispatch("508149960", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getBuyBtnStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-889985202") ? (String) ipChange.ipc$dispatch("-889985202", new Object[]{this}) : this.buyBtnStatus;
    }

    public String getBuyBtnText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1900158647") ? (String) ipChange.ipc$dispatch("-1900158647", new Object[]{this}) : this.buyBtnText;
    }

    public void setBuyBtnStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421856432")) {
            ipChange.ipc$dispatch("-1421856432", new Object[]{this, str});
        } else {
            this.buyBtnStatus = str;
        }
    }

    public void setBuyBtnText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885259339")) {
            ipChange.ipc$dispatch("-885259339", new Object[]{this, str});
        } else {
            this.buyBtnText = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "502476035")) {
            ipChange.ipc$dispatch("502476035", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.buyBtnText);
        parcel.writeString(this.buyBtnStatus);
    }

    protected ItemData(Parcel parcel) {
        this.buyBtnText = parcel.readString();
        this.buyBtnStatus = parcel.readString();
    }
}
