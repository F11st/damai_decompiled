package cn.damai.issue.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CommentGradeTagBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentGradeTagBean> CREATOR = new Parcelable.Creator<CommentGradeTagBean>() { // from class: cn.damai.issue.net.CommentGradeTagBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentGradeTagBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1052418411") ? (CommentGradeTagBean) ipChange.ipc$dispatch("1052418411", new Object[]{this, parcel}) : new CommentGradeTagBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentGradeTagBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-162278000") ? (CommentGradeTagBean[]) ipChange.ipc$dispatch("-162278000", new Object[]{this, Integer.valueOf(i)}) : new CommentGradeTagBean[i];
        }
    };
    private String desc;
    private long type;
    private String value;

    public CommentGradeTagBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348034894")) {
            return ((Integer) ipChange.ipc$dispatch("-348034894", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1557548351") ? (String) ipChange.ipc$dispatch("-1557548351", new Object[]{this}) : this.desc;
    }

    public long getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1641276822") ? ((Long) ipChange.ipc$dispatch("-1641276822", new Object[]{this})).longValue() : this.type;
    }

    public String getValue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-242448265") ? (String) ipChange.ipc$dispatch("-242448265", new Object[]{this}) : this.value;
    }

    public void setDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1332115395")) {
            ipChange.ipc$dispatch("-1332115395", new Object[]{this, str});
        } else {
            this.desc = str;
        }
    }

    public void setType(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "571477018")) {
            ipChange.ipc$dispatch("571477018", new Object[]{this, Long.valueOf(j)});
        } else {
            this.type = j;
        }
    }

    public void setValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-729561377")) {
            ipChange.ipc$dispatch("-729561377", new Object[]{this, str});
        } else {
            this.value = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-709421479")) {
            ipChange.ipc$dispatch("-709421479", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.type);
        parcel.writeString(this.desc);
        parcel.writeString(this.value);
    }

    protected CommentGradeTagBean(Parcel parcel) {
        this.type = parcel.readLong();
        this.desc = parcel.readString();
        this.value = parcel.readString();
    }
}
