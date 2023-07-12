package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectBookingRegisterData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectBookingRegisterData> CREATOR = new Parcelable.Creator<ProjectBookingRegisterData>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ProjectBookingRegisterData.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectBookingRegisterData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1728918763") ? (ProjectBookingRegisterData) ipChange.ipc$dispatch("1728918763", new Object[]{this, parcel}) : new ProjectBookingRegisterData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectBookingRegisterData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "864157444") ? (ProjectBookingRegisterData[]) ipChange.ipc$dispatch("864157444", new Object[]{this, Integer.valueOf(i)}) : new ProjectBookingRegisterData[i];
        }
    };
    private DynamicExtData dynamicExtData;
    private ItemData item;
    private StaticData staticData;

    public ProjectBookingRegisterData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2069105032")) {
            return ((Integer) ipChange.ipc$dispatch("-2069105032", new Object[]{this})).intValue();
        }
        return 0;
    }

    public DynamicExtData getDynamicExtData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1765890131") ? (DynamicExtData) ipChange.ipc$dispatch("1765890131", new Object[]{this}) : this.dynamicExtData;
    }

    public ItemData getItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1611335255") ? (ItemData) ipChange.ipc$dispatch("-1611335255", new Object[]{this}) : this.item;
    }

    public StaticData getStaticData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "474047827") ? (StaticData) ipChange.ipc$dispatch("474047827", new Object[]{this}) : this.staticData;
    }

    public void setDynamicExtData(DynamicExtData dynamicExtData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605892973")) {
            ipChange.ipc$dispatch("1605892973", new Object[]{this, dynamicExtData});
        } else {
            this.dynamicExtData = dynamicExtData;
        }
    }

    public void setItem(ItemData itemData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-664076843")) {
            ipChange.ipc$dispatch("-664076843", new Object[]{this, itemData});
        } else {
            this.item = itemData;
        }
    }

    public void setStaticData(StaticData staticData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1293288363")) {
            ipChange.ipc$dispatch("-1293288363", new Object[]{this, staticData});
        } else {
            this.staticData = staticData;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609370963")) {
            ipChange.ipc$dispatch("1609370963", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.staticData, i);
        parcel.writeParcelable(this.dynamicExtData, i);
        parcel.writeParcelable(this.item, i);
    }

    protected ProjectBookingRegisterData(Parcel parcel) {
        this.staticData = (StaticData) parcel.readParcelable(StaticData.class.getClassLoader());
        this.dynamicExtData = (DynamicExtData) parcel.readParcelable(DynamicExtData.class.getClassLoader());
        this.item = (ItemData) parcel.readParcelable(ItemData.class.getClassLoader());
    }
}
