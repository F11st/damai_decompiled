package cn.damai.commonbusiness.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AddContactsData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddContactsData> CREATOR = new Parcelable.Creator<AddContactsData>() { // from class: cn.damai.commonbusiness.contacts.bean.AddContactsData.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddContactsData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "313476639") ? (AddContactsData) ipChange.ipc$dispatch("313476639", new Object[]{this, parcel}) : new AddContactsData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddContactsData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1153883312") ? (AddContactsData[]) ipChange.ipc$dispatch("-1153883312", new Object[]{this, Integer.valueOf(i)}) : new AddContactsData[i];
        }
    };
    AddContactsBean data;

    public AddContactsData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490748771")) {
            return ((Integer) ipChange.ipc$dispatch("-490748771", new Object[]{this})).intValue();
        }
        return 0;
    }

    public AddContactsBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "171467220") ? (AddContactsBean) ipChange.ipc$dispatch("171467220", new Object[]{this}) : this.data;
    }

    public void setData(AddContactsBean addContactsBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342102118")) {
            ipChange.ipc$dispatch("-342102118", new Object[]{this, addContactsBean});
        } else {
            this.data = addContactsBean;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1464118734")) {
            ipChange.ipc$dispatch("1464118734", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeParcelable(this.data, i);
        }
    }

    protected AddContactsData(Parcel parcel) {
        this.data = (AddContactsBean) parcel.readParcelable(AddContactsBean.class.getClassLoader());
    }
}
