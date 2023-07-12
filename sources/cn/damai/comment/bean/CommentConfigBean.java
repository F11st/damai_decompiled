package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentConfigBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentConfigBean> CREATOR = new Parcelable.Creator<CommentConfigBean>() { // from class: cn.damai.comment.bean.CommentConfigBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentConfigBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1342269321") ? (CommentConfigBean) ipChange.ipc$dispatch("1342269321", new Object[]{this, parcel}) : new CommentConfigBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentConfigBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-56507344") ? (CommentConfigBean[]) ipChange.ipc$dispatch("-56507344", new Object[]{this, Integer.valueOf(i)}) : new CommentConfigBean[i];
        }
    };
    private String isEnabledPublish;

    public CommentConfigBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595406888")) {
            return ((Integer) ipChange.ipc$dispatch("1595406888", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getIsEnabledPublish() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1542671358") ? (String) ipChange.ipc$dispatch("1542671358", new Object[]{this}) : this.isEnabledPublish;
    }

    public void setIsEnabledPublish(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-593622880")) {
            ipChange.ipc$dispatch("-593622880", new Object[]{this, str});
        } else {
            this.isEnabledPublish = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83025827")) {
            ipChange.ipc$dispatch("83025827", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.isEnabledPublish);
        }
    }

    protected CommentConfigBean(Parcel parcel) {
        this.isEnabledPublish = parcel.readString();
    }
}
