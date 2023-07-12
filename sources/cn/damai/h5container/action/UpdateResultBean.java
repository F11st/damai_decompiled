package cn.damai.h5container.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class UpdateResultBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<UpdateResultBean> CREATOR = new Parcelable.Creator<UpdateResultBean>() { // from class: cn.damai.h5container.action.UpdateResultBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateResultBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1441201259") ? (UpdateResultBean) ipChange.ipc$dispatch("1441201259", new Object[]{this, parcel}) : new UpdateResultBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateResultBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1564951492") ? (UpdateResultBean[]) ipChange.ipc$dispatch("-1564951492", new Object[]{this, Integer.valueOf(i)}) : new UpdateResultBean[i];
        }
    };
    public String hasUpdate;

    public UpdateResultBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-6557732")) {
            return ((Integer) ipChange.ipc$dispatch("-6557732", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-288716689")) {
            ipChange.ipc$dispatch("-288716689", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.hasUpdate);
        }
    }

    protected UpdateResultBean(Parcel parcel) {
        this.hasUpdate = parcel.readString();
    }
}
