package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectDetailItemResultDataBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectDetailItemResultDataBean> CREATOR = new Parcelable.Creator<ProjectDetailItemResultDataBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailItemResultDataBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectDetailItemResultDataBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-922970165") ? (ProjectDetailItemResultDataBean) ipChange.ipc$dispatch("-922970165", new Object[]{this, parcel}) : new ProjectDetailItemResultDataBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectDetailItemResultDataBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1865424886") ? (ProjectDetailItemResultDataBean[]) ipChange.ipc$dispatch("1865424886", new Object[]{this, Integer.valueOf(i)}) : new ProjectDetailItemResultDataBean[i];
        }
    };
    private String errorMsg;
    private String result;

    public ProjectDetailItemResultDataBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339954495")) {
            return ((Integer) ipChange.ipc$dispatch("1339954495", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getErrorMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "387778326") ? (String) ipChange.ipc$dispatch("387778326", new Object[]{this}) : this.errorMsg;
    }

    public String getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-104154790") ? (String) ipChange.ipc$dispatch("-104154790", new Object[]{this}) : this.result;
    }

    public void setErrorMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746101624")) {
            ipChange.ipc$dispatch("-746101624", new Object[]{this, str});
        } else {
            this.errorMsg = str;
        }
    }

    public void setResult(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328923196")) {
            ipChange.ipc$dispatch("-328923196", new Object[]{this, str});
        } else {
            this.result = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "81884524")) {
            ipChange.ipc$dispatch("81884524", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.result);
        parcel.writeString(this.errorMsg);
    }

    protected ProjectDetailItemResultDataBean(Parcel parcel) {
        this.result = parcel.readString();
        this.errorMsg = parcel.readString();
    }
}
