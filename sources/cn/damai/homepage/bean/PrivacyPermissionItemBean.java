package cn.damai.homepage.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class PrivacyPermissionItemBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PrivacyPermissionItemBean> CREATOR = new Parcelable.Creator<PrivacyPermissionItemBean>() { // from class: cn.damai.homepage.bean.PrivacyPermissionItemBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivacyPermissionItemBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "504874731") ? (PrivacyPermissionItemBean) ipChange.ipc$dispatch("504874731", new Object[]{this, parcel}) : new PrivacyPermissionItemBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivacyPermissionItemBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "958371756") ? (PrivacyPermissionItemBean[]) ipChange.ipc$dispatch("958371756", new Object[]{this, Integer.valueOf(i)}) : new PrivacyPermissionItemBean[i];
        }
    };
    public Integer permissionType;
    public Integer value;

    public PrivacyPermissionItemBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344556196")) {
            return ((Integer) ipChange.ipc$dispatch("1344556196", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "775687136")) {
            ipChange.ipc$dispatch("775687136", new Object[]{this, parcel});
            return;
        }
        this.permissionType = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.value = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099017049")) {
            ipChange.ipc$dispatch("-1099017049", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeValue(this.permissionType);
        parcel.writeValue(this.value);
    }

    protected PrivacyPermissionItemBean(Parcel parcel) {
        this.permissionType = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.value = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
