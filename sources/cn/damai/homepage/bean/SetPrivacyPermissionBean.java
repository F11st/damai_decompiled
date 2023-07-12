package cn.damai.homepage.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class SetPrivacyPermissionBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<SetPrivacyPermissionBean> CREATOR = new Parcelable.Creator<SetPrivacyPermissionBean>() { // from class: cn.damai.homepage.bean.SetPrivacyPermissionBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SetPrivacyPermissionBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1672401913") ? (SetPrivacyPermissionBean) ipChange.ipc$dispatch("-1672401913", new Object[]{this, parcel}) : new SetPrivacyPermissionBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SetPrivacyPermissionBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1457849840") ? (SetPrivacyPermissionBean[]) ipChange.ipc$dispatch("-1457849840", new Object[]{this, Integer.valueOf(i)}) : new SetPrivacyPermissionBean[i];
        }
    };
    public ArrayList<PrivacyPermissionItemBean> setupPermissionList;

    public SetPrivacyPermissionBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "628982121")) {
            return ((Integer) ipChange.ipc$dispatch("628982121", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2083805627")) {
            ipChange.ipc$dispatch("2083805627", new Object[]{this, parcel});
        } else {
            this.setupPermissionList = parcel.createTypedArrayList(PrivacyPermissionItemBean.CREATOR);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209101442")) {
            ipChange.ipc$dispatch("209101442", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeTypedList(this.setupPermissionList);
        }
    }

    protected SetPrivacyPermissionBean(Parcel parcel) {
        this.setupPermissionList = parcel.createTypedArrayList(PrivacyPermissionItemBean.CREATOR);
    }
}
