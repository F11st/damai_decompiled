package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class QueryThemeResultBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<QueryThemeResultBean> CREATOR = new Parcelable.Creator<QueryThemeResultBean>() { // from class: cn.damai.comment.bean.QueryThemeResultBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QueryThemeResultBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-582527477") ? (QueryThemeResultBean) ipChange.ipc$dispatch("-582527477", new Object[]{this, parcel}) : new QueryThemeResultBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QueryThemeResultBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1077753302") ? (QueryThemeResultBean[]) ipChange.ipc$dispatch("-1077753302", new Object[]{this, Integer.valueOf(i)}) : new QueryThemeResultBean[i];
        }
    };
    List<String> IconTitle;
    List<QueryThemeCliqueInfoBean> cliqueInfos;
    Long themeId;
    String themeName;

    public QueryThemeResultBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2081224763")) {
            return ((Integer) ipChange.ipc$dispatch("-2081224763", new Object[]{this})).intValue();
        }
        return 0;
    }

    public List<QueryThemeCliqueInfoBean> getCliqueInfos() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-313994338") ? (List) ipChange.ipc$dispatch("-313994338", new Object[]{this}) : this.cliqueInfos;
    }

    public List<String> getIconTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-389256743") ? (List) ipChange.ipc$dispatch("-389256743", new Object[]{this}) : this.IconTitle;
    }

    public Long getThemeId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-276948276") ? (Long) ipChange.ipc$dispatch("-276948276", new Object[]{this}) : this.themeId;
    }

    public String getThemeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1838895559") ? (String) ipChange.ipc$dispatch("1838895559", new Object[]{this}) : this.themeName;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925423327")) {
            ipChange.ipc$dispatch("925423327", new Object[]{this, parcel});
            return;
        }
        this.themeId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.themeName = parcel.readString();
        this.cliqueInfos = parcel.createTypedArrayList(QueryThemeCliqueInfoBean.CREATOR);
        this.IconTitle = parcel.createStringArrayList();
    }

    public void setCliqueInfos(List<QueryThemeCliqueInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091419270")) {
            ipChange.ipc$dispatch("2091419270", new Object[]{this, list});
        } else {
            this.cliqueInfos = list;
        }
    }

    public void setIconTitle(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "107236011")) {
            ipChange.ipc$dispatch("107236011", new Object[]{this, list});
        } else {
            this.IconTitle = list;
        }
    }

    public void setThemeId(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506789004")) {
            ipChange.ipc$dispatch("-506789004", new Object[]{this, l});
        } else {
            this.themeId = l;
        }
    }

    public void setThemeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794017393")) {
            ipChange.ipc$dispatch("-794017393", new Object[]{this, str});
        } else {
            this.themeName = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-949280858")) {
            ipChange.ipc$dispatch("-949280858", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeValue(this.themeId);
        parcel.writeString(this.themeName);
        parcel.writeTypedList(this.cliqueInfos);
        parcel.writeStringList(this.IconTitle);
    }

    protected QueryThemeResultBean(Parcel parcel) {
        this.themeId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.themeName = parcel.readString();
        this.cliqueInfos = parcel.createTypedArrayList(QueryThemeCliqueInfoBean.CREATOR);
        this.IconTitle = parcel.createStringArrayList();
    }
}
