package cn.damai.trade.newtradeorder.ui.projectdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectDetailCommentConfigureBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectDetailCommentConfigureBean> CREATOR = new Parcelable.Creator<ProjectDetailCommentConfigureBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.bean.ProjectDetailCommentConfigureBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectDetailCommentConfigureBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2062337237") ? (ProjectDetailCommentConfigureBean) ipChange.ipc$dispatch("-2062337237", new Object[]{this, parcel}) : new ProjectDetailCommentConfigureBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectDetailCommentConfigureBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-60126528") ? (ProjectDetailCommentConfigureBean[]) ipChange.ipc$dispatch("-60126528", new Object[]{this, Integer.valueOf(i)}) : new ProjectDetailCommentConfigureBean[i];
        }
    };
    private boolean isShowModule;
    private boolean isVTagUser;

    public ProjectDetailCommentConfigureBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973782554")) {
            return ((Integer) ipChange.ipc$dispatch("973782554", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isShowModule() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1913893213") ? ((Boolean) ipChange.ipc$dispatch("1913893213", new Object[]{this})).booleanValue() : this.isShowModule;
    }

    public boolean isVTagUser() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1276678519") ? ((Boolean) ipChange.ipc$dispatch("1276678519", new Object[]{this})).booleanValue() : this.isVTagUser;
    }

    public void setShowModule(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1213174815")) {
            ipChange.ipc$dispatch("-1213174815", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isShowModule = z;
        }
    }

    public void setVTagUser(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661294457")) {
            ipChange.ipc$dispatch("-1661294457", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isVTagUser = z;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "493239793")) {
            ipChange.ipc$dispatch("493239793", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeByte(this.isShowModule ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVTagUser ? (byte) 1 : (byte) 0);
    }

    protected ProjectDetailCommentConfigureBean(Parcel parcel) {
        this.isShowModule = parcel.readByte() != 0;
        this.isVTagUser = parcel.readByte() != 0;
    }
}
