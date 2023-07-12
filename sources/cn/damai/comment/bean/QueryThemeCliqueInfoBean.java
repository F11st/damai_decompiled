package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class QueryThemeCliqueInfoBean implements Parcelable, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<QueryThemeCliqueInfoBean> CREATOR = new Parcelable.Creator<QueryThemeCliqueInfoBean>() { // from class: cn.damai.comment.bean.QueryThemeCliqueInfoBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QueryThemeCliqueInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1186160949") ? (QueryThemeCliqueInfoBean) ipChange.ipc$dispatch("-1186160949", new Object[]{this, parcel}) : new QueryThemeCliqueInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QueryThemeCliqueInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-183744634") ? (QueryThemeCliqueInfoBean[]) ipChange.ipc$dispatch("-183744634", new Object[]{this, Integer.valueOf(i)}) : new QueryThemeCliqueInfoBean[i];
        }
    };
    long id;
    String name;

    public QueryThemeCliqueInfoBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216686441")) {
            return ((Integer) ipChange.ipc$dispatch("-1216686441", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1333767670") ? ((Boolean) ipChange.ipc$dispatch("-1333767670", new Object[]{this, obj})).booleanValue() : (obj instanceof QueryThemeCliqueInfoBean) && this.id == ((QueryThemeCliqueInfoBean) obj).id;
    }

    public long getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1603537180") ? ((Long) ipChange.ipc$dispatch("-1603537180", new Object[]{this})).longValue() : this.id;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1942608224") ? (String) ipChange.ipc$dispatch("-1942608224", new Object[]{this}) : this.name;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1176651341")) {
            ipChange.ipc$dispatch("1176651341", new Object[]{this, parcel});
            return;
        }
        this.id = parcel.readLong();
        this.name = parcel.readString();
    }

    public void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615368672")) {
            ipChange.ipc$dispatch("1615368672", new Object[]{this, Long.valueOf(j)});
        } else {
            this.id = j;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384069570")) {
            ipChange.ipc$dispatch("-384069570", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698052844")) {
            ipChange.ipc$dispatch("-698052844", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
    }

    protected QueryThemeCliqueInfoBean(Parcel parcel) {
        this.id = parcel.readLong();
        this.name = parcel.readString();
    }
}
