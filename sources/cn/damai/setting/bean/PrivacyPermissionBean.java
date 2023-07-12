package cn.damai.setting.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PrivacyPermissionBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PrivacyPermissionBean> CREATOR = new Parcelable.Creator<PrivacyPermissionBean>() { // from class: cn.damai.setting.bean.PrivacyPermissionBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivacyPermissionBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "860116031") ? (PrivacyPermissionBean) ipChange.ipc$dispatch("860116031", new Object[]{this, parcel}) : new PrivacyPermissionBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivacyPermissionBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1899652336") ? (PrivacyPermissionBean[]) ipChange.ipc$dispatch("-1899652336", new Object[]{this, Integer.valueOf(i)}) : new PrivacyPermissionBean[i];
        }
    };
    public ArrayList<PrivacyPermissionItemBean> queryPermissionList;

    public PrivacyPermissionBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954060237")) {
            return ((Integer) ipChange.ipc$dispatch("1954060237", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184264745")) {
            ipChange.ipc$dispatch("-184264745", new Object[]{this, parcel});
        } else {
            this.queryPermissionList = parcel.createTypedArrayList(PrivacyPermissionItemBean.CREATOR);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2058968930")) {
            ipChange.ipc$dispatch("-2058968930", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeTypedList(this.queryPermissionList);
        }
    }

    protected PrivacyPermissionBean(Parcel parcel) {
        this.queryPermissionList = parcel.createTypedArrayList(PrivacyPermissionItemBean.CREATOR);
    }
}
