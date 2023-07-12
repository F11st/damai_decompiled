package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentSyncCircleBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentSyncCircleBean> CREATOR = new Parcelable.Creator<CommentSyncCircleBean>() { // from class: cn.damai.comment.bean.CommentSyncCircleBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentSyncCircleBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-696490249") ? (CommentSyncCircleBean) ipChange.ipc$dispatch("-696490249", new Object[]{this, parcel}) : new CommentSyncCircleBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentSyncCircleBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "986048656") ? (CommentSyncCircleBean[]) ipChange.ipc$dispatch("986048656", new Object[]{this, Integer.valueOf(i)}) : new CommentSyncCircleBean[i];
        }
    };
    private String circleId;
    private String circleName;
    private String circleTargetId;
    private String circleTargetType;

    public CommentSyncCircleBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "18815345")) {
            return ((Integer) ipChange.ipc$dispatch("18815345", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getCircleId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1303483642") ? (String) ipChange.ipc$dispatch("1303483642", new Object[]{this}) : this.circleId;
    }

    public String getCircleName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1411787414") ? (String) ipChange.ipc$dispatch("-1411787414", new Object[]{this}) : this.circleName;
    }

    public String getCircleTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1694449899") ? (String) ipChange.ipc$dispatch("1694449899", new Object[]{this}) : this.circleTargetId;
    }

    public String getCircleTargetType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1767034806") ? (String) ipChange.ipc$dispatch("-1767034806", new Object[]{this}) : this.circleTargetType;
    }

    public void setCircleId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1870959396")) {
            ipChange.ipc$dispatch("1870959396", new Object[]{this, str});
        } else {
            this.circleId = str;
        }
    }

    public void setCircleName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369346996")) {
            ipChange.ipc$dispatch("1369346996", new Object[]{this, str});
        } else {
            this.circleName = str;
        }
    }

    public void setCircleTargetId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1871232595")) {
            ipChange.ipc$dispatch("1871232595", new Object[]{this, str});
        } else {
            this.circleTargetId = str;
        }
    }

    public void setCircleTargetType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115298860")) {
            ipChange.ipc$dispatch("-115298860", new Object[]{this, str});
        } else {
            this.circleTargetType = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1983440006")) {
            ipChange.ipc$dispatch("-1983440006", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.circleId);
        parcel.writeString(this.circleName);
        parcel.writeString(this.circleTargetId);
        parcel.writeString(this.circleTargetType);
    }

    protected CommentSyncCircleBean(Parcel parcel) {
        this.circleId = parcel.readString();
        this.circleName = parcel.readString();
        this.circleTargetId = parcel.readString();
        this.circleTargetType = parcel.readString();
    }
}
