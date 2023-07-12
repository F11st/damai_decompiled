package cn.damai.setting.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SetPrivacyPermissionBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<SetPrivacyPermissionBean> CREATOR = new Parcelable.Creator<SetPrivacyPermissionBean>() { // from class: cn.damai.setting.bean.SetPrivacyPermissionBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SetPrivacyPermissionBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1567276555") ? (SetPrivacyPermissionBean) ipChange.ipc$dispatch("1567276555", new Object[]{this, parcel}) : new SetPrivacyPermissionBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SetPrivacyPermissionBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1940162406") ? (SetPrivacyPermissionBean[]) ipChange.ipc$dispatch("-1940162406", new Object[]{this, Integer.valueOf(i)}) : new SetPrivacyPermissionBean[i];
        }
    };
    public ArrayList<PrivacyPermissionItemBean> setupPermissionList;

    public SetPrivacyPermissionBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777179059")) {
            return ((Integer) ipChange.ipc$dispatch("-777179059", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "226742103")) {
            ipChange.ipc$dispatch("226742103", new Object[]{this, parcel});
        } else {
            this.setupPermissionList = parcel.createTypedArrayList(PrivacyPermissionItemBean.CREATOR);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647962082")) {
            ipChange.ipc$dispatch("-1647962082", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeTypedList(this.setupPermissionList);
        }
    }

    protected SetPrivacyPermissionBean(Parcel parcel) {
        this.setupPermissionList = parcel.createTypedArrayList(PrivacyPermissionItemBean.CREATOR);
    }
}
