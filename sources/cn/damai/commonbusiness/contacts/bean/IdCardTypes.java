package cn.damai.commonbusiness.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class IdCardTypes implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<IdCardTypes> CREATOR = new Parcelable.Creator<IdCardTypes>() { // from class: cn.damai.commonbusiness.contacts.bean.IdCardTypes.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IdCardTypes createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1031485951") ? (IdCardTypes) ipChange.ipc$dispatch("1031485951", new Object[]{this, parcel}) : new IdCardTypes(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IdCardTypes[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2051419440") ? (IdCardTypes[]) ipChange.ipc$dispatch("-2051419440", new Object[]{this, Integer.valueOf(i)}) : new IdCardTypes[i];
        }
    };
    public int id;
    public String name;

    public IdCardTypes() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1603419949")) {
            return ((Integer) ipChange.ipc$dispatch("1603419949", new Object[]{this})).intValue();
        }
        return 0;
    }

    public int getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-65007603") ? ((Integer) ipChange.ipc$dispatch("-65007603", new Object[]{this})).intValue() : this.id;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-629237450") ? (String) ipChange.ipc$dispatch("-629237450", new Object[]{this}) : this.name;
    }

    public void setId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2065144373")) {
            ipChange.ipc$dispatch("2065144373", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.id = i;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1675718760")) {
            ipChange.ipc$dispatch("1675718760", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259742402")) {
            ipChange.ipc$dispatch("-259742402", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
    }

    public IdCardTypes(int i, String str) {
        this.id = i;
        this.name = str;
    }

    protected IdCardTypes(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
    }
}
