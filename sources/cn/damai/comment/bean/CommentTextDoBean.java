package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentTextDoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentTextDoBean> CREATOR = new Parcelable.Creator<CommentTextDoBean>() { // from class: cn.damai.comment.bean.CommentTextDoBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentTextDoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "69072349") ? (CommentTextDoBean) ipChange.ipc$dispatch("69072349", new Object[]{this, parcel}) : new CommentTextDoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentTextDoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1025927312") ? (CommentTextDoBean[]) ipChange.ipc$dispatch("-1025927312", new Object[]{this, Integer.valueOf(i)}) : new CommentTextDoBean[i];
        }
    };
    private String id;
    private String type;
    private String value;

    public CommentTextDoBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559673858")) {
            return ((Integer) ipChange.ipc$dispatch("-559673858", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-939357737") ? (String) ipChange.ipc$dispatch("-939357737", new Object[]{this}) : this.id;
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1174531638") ? (String) ipChange.ipc$dispatch("1174531638", new Object[]{this}) : this.type;
    }

    public String getValue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2011096917") ? (String) ipChange.ipc$dispatch("-2011096917", new Object[]{this}) : this.value;
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213966617")) {
            ipChange.ipc$dispatch("-213966617", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757985640")) {
            ipChange.ipc$dispatch("1757985640", new Object[]{this, str});
        } else {
            this.type = str;
        }
    }

    public void setValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "276905259")) {
            ipChange.ipc$dispatch("276905259", new Object[]{this, str});
        } else {
            this.value = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883045005")) {
            ipChange.ipc$dispatch("883045005", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.id);
        parcel.writeString(this.type);
        parcel.writeString(this.value);
    }

    protected CommentTextDoBean(Parcel parcel) {
        this.id = parcel.readString();
        this.type = parcel.readString();
        this.value = parcel.readString();
    }
}
