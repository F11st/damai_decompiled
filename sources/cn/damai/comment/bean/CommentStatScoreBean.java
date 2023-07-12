package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentStatScoreBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentStatScoreBean> CREATOR = new Parcelable.Creator<CommentStatScoreBean>() { // from class: cn.damai.comment.bean.CommentStatScoreBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentStatScoreBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "815477611") ? (CommentStatScoreBean) ipChange.ipc$dispatch("815477611", new Object[]{this, parcel}) : new CommentStatScoreBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentStatScoreBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-751815768") ? (CommentStatScoreBean[]) ipChange.ipc$dispatch("-751815768", new Object[]{this, Integer.valueOf(i)}) : new CommentStatScoreBean[i];
        }
    };
    private String scoreDesc;
    private String scoreRatio;
    private String statScore;

    public CommentStatScoreBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-773183450")) {
            return ((Integer) ipChange.ipc$dispatch("-773183450", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getScoreDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-554886699") ? (String) ipChange.ipc$dispatch("-554886699", new Object[]{this}) : this.scoreDesc;
    }

    public String getScoreRatio() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1632210563") ? (String) ipChange.ipc$dispatch("-1632210563", new Object[]{this}) : this.scoreRatio;
    }

    public String getStatScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1870226096") ? (String) ipChange.ipc$dispatch("1870226096", new Object[]{this}) : this.statScore;
    }

    public void setScoreDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1986823359")) {
            ipChange.ipc$dispatch("-1986823359", new Object[]{this, str});
        } else {
            this.scoreDesc = str;
        }
    }

    public void setScoreRatio(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168803327")) {
            ipChange.ipc$dispatch("-1168803327", new Object[]{this, str});
        } else {
            this.scoreRatio = str;
        }
    }

    public void setStatScore(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "177229254")) {
            ipChange.ipc$dispatch("177229254", new Object[]{this, str});
        } else {
            this.statScore = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35738267")) {
            ipChange.ipc$dispatch("-35738267", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.scoreRatio);
        parcel.writeString(this.scoreDesc);
        parcel.writeString(this.statScore);
    }

    protected CommentStatScoreBean(Parcel parcel) {
        this.scoreRatio = parcel.readString();
        this.scoreDesc = parcel.readString();
        this.statScore = parcel.readString();
    }
}
