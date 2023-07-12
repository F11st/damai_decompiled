package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectNotice implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectNotice> CREATOR = new Parcelable.Creator<ProjectNotice>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectNotice.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectNotice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-271181653") ? (ProjectNotice) ipChange.ipc$dispatch("-271181653", new Object[]{this, parcel}) : new ProjectNotice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectNotice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "483229692") ? (ProjectNotice[]) ipChange.ipc$dispatch("483229692", new Object[]{this, Integer.valueOf(i)}) : new ProjectNotice[i];
        }
    };
    public String content;
    public String imageUrl;
    public String name;

    public ProjectNotice() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-156795972")) {
            return ((Integer) ipChange.ipc$dispatch("-156795972", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "931213230") ? ((Boolean) ipChange.ipc$dispatch("931213230", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.content);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997443441")) {
            ipChange.ipc$dispatch("-997443441", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.name);
        parcel.writeString(this.content);
        parcel.writeString(this.imageUrl);
    }

    protected ProjectNotice(Parcel parcel) {
        this.name = parcel.readString();
        this.content = parcel.readString();
        this.imageUrl = parcel.readString();
    }
}
