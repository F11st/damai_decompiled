package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentRepertoireInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentRepertoireInfoBean> CREATOR = new Parcelable.Creator<CommentRepertoireInfoBean>() { // from class: cn.damai.comment.bean.CommentRepertoireInfoBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentRepertoireInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1452219517") ? (CommentRepertoireInfoBean) ipChange.ipc$dispatch("-1452219517", new Object[]{this, parcel}) : new CommentRepertoireInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentRepertoireInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "146176464") ? (CommentRepertoireInfoBean[]) ipChange.ipc$dispatch("146176464", new Object[]{this, Integer.valueOf(i)}) : new CommentRepertoireInfoBean[i];
        }
    };
    private String artsDesc;
    private String repertoireId;
    private String repertoireName;
    private String repertoirePic;

    public CommentRepertoireInfoBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1870452821")) {
            return ((Integer) ipChange.ipc$dispatch("-1870452821", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getArtsDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "690516042") ? (String) ipChange.ipc$dispatch("690516042", new Object[]{this}) : this.artsDesc;
    }

    public String getRepertoireId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "935919963") ? (String) ipChange.ipc$dispatch("935919963", new Object[]{this}) : this.repertoireId;
    }

    public String getRepertoireName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1841802635") ? (String) ipChange.ipc$dispatch("1841802635", new Object[]{this}) : this.repertoireName;
    }

    public String getRepertoirePic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1238246656") ? (String) ipChange.ipc$dispatch("-1238246656", new Object[]{this}) : this.repertoirePic;
    }

    public void setArtsDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48832980")) {
            ipChange.ipc$dispatch("48832980", new Object[]{this, str});
        } else {
            this.artsDesc = str;
        }
    }

    public void setRepertoireId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653371165")) {
            ipChange.ipc$dispatch("-653371165", new Object[]{this, str});
        } else {
            this.repertoireId = str;
        }
    }

    public void setRepertoireName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2144200115")) {
            ipChange.ipc$dispatch("2144200115", new Object[]{this, str});
        } else {
            this.repertoireName = str;
        }
    }

    public void setRepertoirePic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599604362")) {
            ipChange.ipc$dispatch("-1599604362", new Object[]{this, str});
        } else {
            this.repertoirePic = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1303508864")) {
            ipChange.ipc$dispatch("-1303508864", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.repertoireId);
        parcel.writeString(this.repertoireName);
        parcel.writeString(this.repertoirePic);
        parcel.writeString(this.artsDesc);
    }

    protected CommentRepertoireInfoBean(Parcel parcel) {
        this.repertoireId = parcel.readString();
        this.repertoireName = parcel.readString();
        this.repertoirePic = parcel.readString();
        this.artsDesc = parcel.readString();
    }
}
