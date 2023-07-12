package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentContentLabelBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COMMON_TYPE_ALL = 0;
    public static final int COMMON_TYPE_COMMENT = 99;
    public static final Parcelable.Creator<CommentContentLabelBean> CREATOR = new Parcelable.Creator<CommentContentLabelBean>() { // from class: cn.damai.comment.bean.CommentContentLabelBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentContentLabelBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1826355095") ? (CommentContentLabelBean) ipChange.ipc$dispatch("1826355095", new Object[]{this, parcel}) : new CommentContentLabelBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentContentLabelBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "140732112") ? (CommentContentLabelBean[]) ipChange.ipc$dispatch("140732112", new Object[]{this, Integer.valueOf(i)}) : new CommentContentLabelBean[i];
        }
    };
    private long count;
    private String labelId;
    private String labelName;
    private String labelType;
    private int pos;
    private String status;

    public CommentContentLabelBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189309343")) {
            return ((Integer) ipChange.ipc$dispatch("-1189309343", new Object[]{this})).intValue();
        }
        return 0;
    }

    public long getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "831243662") ? ((Long) ipChange.ipc$dispatch("831243662", new Object[]{this})).longValue() : this.count;
    }

    public String getLabelId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1151092070") ? (String) ipChange.ipc$dispatch("1151092070", new Object[]{this}) : this.labelId;
    }

    public String getLabelName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1831200042") ? (String) ipChange.ipc$dispatch("-1831200042", new Object[]{this}) : this.labelName;
    }

    public String getLabelType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "52101637") ? (String) ipChange.ipc$dispatch("52101637", new Object[]{this}) : this.labelType;
    }

    public int getPos() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "743864104") ? ((Integer) ipChange.ipc$dispatch("743864104", new Object[]{this})).intValue() : this.pos;
    }

    public String getStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "353435985") ? (String) ipChange.ipc$dispatch("353435985", new Object[]{this}) : this.status;
    }

    public boolean isStatusChoose() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1711434052") ? ((Boolean) ipChange.ipc$dispatch("1711434052", new Object[]{this})).booleanValue() : "1".equals(getStatus());
    }

    public void setCount(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1547773150")) {
            ipChange.ipc$dispatch("1547773150", new Object[]{this, Long.valueOf(j)});
        } else {
            this.count = j;
        }
    }

    public void setLabelId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-292137776")) {
            ipChange.ipc$dispatch("-292137776", new Object[]{this, str});
        } else {
            this.labelId = str;
        }
    }

    public void setLabelName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397135968")) {
            ipChange.ipc$dispatch("1397135968", new Object[]{this, str});
        } else {
            this.labelName = str;
        }
    }

    public void setLabelType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350054127")) {
            ipChange.ipc$dispatch("-350054127", new Object[]{this, str});
        } else {
            this.labelType = str;
        }
    }

    public void setPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-773181470")) {
            ipChange.ipc$dispatch("-773181470", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pos = i;
        }
    }

    public void setStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971488941")) {
            ipChange.ipc$dispatch("971488941", new Object[]{this, str});
        } else {
            this.status = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101654902")) {
            ipChange.ipc$dispatch("-101654902", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.labelName);
        parcel.writeString(this.labelType);
        parcel.writeString(this.status);
        parcel.writeInt(this.pos);
    }

    protected CommentContentLabelBean(Parcel parcel) {
        this.labelName = parcel.readString();
        this.labelType = parcel.readString();
        this.status = parcel.readString();
        this.pos = parcel.readInt();
    }
}
