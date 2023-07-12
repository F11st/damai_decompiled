package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentImageInfoBean implements Parcelable, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentImageInfoBean> CREATOR = new Parcelable.Creator<CommentImageInfoBean>() { // from class: cn.damai.comment.bean.CommentImageInfoBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentImageInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "650928779") ? (CommentImageInfoBean) ipChange.ipc$dispatch("650928779", new Object[]{this, parcel}) : new CommentImageInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentImageInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-288105518") ? (CommentImageInfoBean[]) ipChange.ipc$dispatch("-288105518", new Object[]{this, Integer.valueOf(i)}) : new CommentImageInfoBean[i];
        }
    };
    public int type;
    public String url;

    public CommentImageInfoBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1745100913")) {
            return ((Integer) ipChange.ipc$dispatch("1745100913", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "649131130")) {
            ipChange.ipc$dispatch("649131130", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeString(this.url);
    }

    protected CommentImageInfoBean(Parcel parcel) {
        this.type = parcel.readInt();
        this.url = parcel.readString();
    }
}
