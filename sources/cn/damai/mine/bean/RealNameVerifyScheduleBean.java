package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class RealNameVerifyScheduleBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameVerifyScheduleBean> CREATOR = new Parcelable.Creator<RealNameVerifyScheduleBean>() { // from class: cn.damai.mine.bean.RealNameVerifyScheduleBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealNameVerifyScheduleBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1029676491") ? (RealNameVerifyScheduleBean) ipChange.ipc$dispatch("-1029676491", new Object[]{this, parcel}) : new RealNameVerifyScheduleBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealNameVerifyScheduleBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1291867920") ? (RealNameVerifyScheduleBean[]) ipChange.ipc$dispatch("-1291867920", new Object[]{this, Integer.valueOf(i)}) : new RealNameVerifyScheduleBean[i];
        }
    };
    private String expectFinishTimeMsg;

    public RealNameVerifyScheduleBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1489325042")) {
            return ((Integer) ipChange.ipc$dispatch("1489325042", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getExpectFinishTimeMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-318844786") ? (String) ipChange.ipc$dispatch("-318844786", new Object[]{this}) : this.expectFinishTimeMsg;
    }

    public void setExpectFinishTimeMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380435624")) {
            ipChange.ipc$dispatch("380435624", new Object[]{this, str});
        } else {
            this.expectFinishTimeMsg = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1049500441")) {
            ipChange.ipc$dispatch("1049500441", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.expectFinishTimeMsg);
        }
    }

    protected RealNameVerifyScheduleBean(Parcel parcel) {
        this.expectFinishTimeMsg = parcel.readString();
    }
}
