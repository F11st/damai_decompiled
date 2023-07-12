package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class PhoneAllowableResult implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PhoneAllowableResult> CREATOR = new Parcelable.Creator<PhoneAllowableResult>() { // from class: cn.damai.commonbusiness.address.bean.PhoneAllowableResult.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneAllowableResult createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-15702935") ? (PhoneAllowableResult) ipChange.ipc$dispatch("-15702935", new Object[]{this, parcel}) : new PhoneAllowableResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneAllowableResult[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1224485712") ? (PhoneAllowableResult[]) ipChange.ipc$dispatch("-1224485712", new Object[]{this, Integer.valueOf(i)}) : new PhoneAllowableResult[i];
        }
    };
    public ArrayList<PhoneAllowableBean> result;

    public PhoneAllowableResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147432664")) {
            return ((Integer) ipChange.ipc$dispatch("2147432664", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744492275")) {
            ipChange.ipc$dispatch("1744492275", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeList(this.result);
        }
    }

    protected PhoneAllowableResult(Parcel parcel) {
        ArrayList<PhoneAllowableBean> arrayList = new ArrayList<>();
        this.result = arrayList;
        parcel.readList(arrayList, PhoneAllowableBean.class.getClassLoader());
    }
}
