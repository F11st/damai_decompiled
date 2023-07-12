package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AliMeTokenInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AliMeTokenInfo> CREATOR = new Parcelable.Creator<AliMeTokenInfo>() { // from class: cn.damai.commonbusiness.model.AliMeTokenInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AliMeTokenInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1705545653") ? (AliMeTokenInfo) ipChange.ipc$dispatch("-1705545653", new Object[]{this, parcel}) : new AliMeTokenInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AliMeTokenInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "170467118") ? (AliMeTokenInfo[]) ipChange.ipc$dispatch("170467118", new Object[]{this, Integer.valueOf(i)}) : new AliMeTokenInfo[i];
        }
    };
    private String result;

    public AliMeTokenInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2123686621")) {
            return ((Integer) ipChange.ipc$dispatch("-2123686621", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1001010238") ? (String) ipChange.ipc$dispatch("1001010238", new Object[]{this}) : this.result;
    }

    public void setResult(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428545696")) {
            ipChange.ipc$dispatch("-428545696", new Object[]{this, str});
        } else {
            this.result = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911508472")) {
            ipChange.ipc$dispatch("-1911508472", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.result);
        }
    }

    protected AliMeTokenInfo(Parcel parcel) {
        this.result = parcel.readString();
    }
}
