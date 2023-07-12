package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentGetRelationTargetBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentGetRelationTargetBean> CREATOR = new Parcelable.Creator<CommentGetRelationTargetBean>() { // from class: cn.damai.comment.bean.CommentGetRelationTargetBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentGetRelationTargetBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "399816267") ? (CommentGetRelationTargetBean) ipChange.ipc$dispatch("399816267", new Object[]{this, parcel}) : new CommentGetRelationTargetBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentGetRelationTargetBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1686461534") ? (CommentGetRelationTargetBean[]) ipChange.ipc$dispatch("1686461534", new Object[]{this, Integer.valueOf(i)}) : new CommentGetRelationTargetBean[i];
        }
    };
    public String resultStr;

    public CommentGetRelationTargetBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124901909")) {
            return ((Integer) ipChange.ipc$dispatch("-124901909", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-615587066") ? (String) ipChange.ipc$dispatch("-615587066", new Object[]{this}) : this.resultStr;
    }

    public void setResult(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996545432")) {
            ipChange.ipc$dispatch("996545432", new Object[]{this, str});
        } else {
            this.resultStr = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "39277120")) {
            ipChange.ipc$dispatch("39277120", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.resultStr);
        }
    }

    protected CommentGetRelationTargetBean(Parcel parcel) {
        this.resultStr = parcel.readString();
    }
}
