package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentProjectInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentProjectInfoBean> CREATOR = new Parcelable.Creator<CommentProjectInfoBean>() { // from class: cn.damai.comment.bean.CommentProjectInfoBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentProjectInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1891166773") ? (CommentProjectInfoBean) ipChange.ipc$dispatch("-1891166773", new Object[]{this, parcel}) : new CommentProjectInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentProjectInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1060991850") ? (CommentProjectInfoBean[]) ipChange.ipc$dispatch("-1060991850", new Object[]{this, Integer.valueOf(i)}) : new CommentProjectInfoBean[i];
        }
    };
    private String cityId;
    private String cityName;
    private String projectId;
    private String projectName;
    private String projectPoster;
    private String showTime;
    public String simpleName;
    private String subTitle;
    private String venueId;
    private String venueName;
    public String viewStatus;
    public boolean wantSee;

    protected CommentProjectInfoBean(Parcel parcel) {
        this.cityId = parcel.readString();
        this.cityName = parcel.readString();
        this.projectId = parcel.readString();
        this.projectName = parcel.readString();
        this.subTitle = parcel.readString();
        this.projectPoster = parcel.readString();
        this.showTime = parcel.readString();
        this.venueId = parcel.readString();
        this.venueName = parcel.readString();
        this.viewStatus = parcel.readString();
        this.wantSee = parcel.readByte() != 0;
        this.simpleName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1728987793")) {
            return ((Integer) ipChange.ipc$dispatch("-1728987793", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "860050131") ? (String) ipChange.ipc$dispatch("860050131", new Object[]{this}) : this.cityId;
    }

    public String getCityName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1945338115") ? (String) ipChange.ipc$dispatch("1945338115", new Object[]{this}) : this.cityName;
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-484185475") ? (String) ipChange.ipc$dispatch("-484185475", new Object[]{this}) : this.projectId;
    }

    public String getProjectName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1374890451") ? (String) ipChange.ipc$dispatch("-1374890451", new Object[]{this}) : this.projectName;
    }

    public String getProjectPoster() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1138059823") ? (String) ipChange.ipc$dispatch("1138059823", new Object[]{this}) : this.projectPoster;
    }

    @NonNull
    public String getShortOptName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-888663249")) {
            return (String) ipChange.ipc$dispatch("-888663249", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.simpleName)) {
            return TextUtils.isEmpty(this.projectName) ? "" : this.projectName;
        }
        return this.simpleName;
    }

    public String getShowTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1873399767") ? (String) ipChange.ipc$dispatch("1873399767", new Object[]{this}) : this.showTime;
    }

    public String getSubTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2082439835") ? (String) ipChange.ipc$dispatch("-2082439835", new Object[]{this}) : this.subTitle;
    }

    public String getVenueId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1402219309") ? (String) ipChange.ipc$dispatch("-1402219309", new Object[]{this}) : this.venueId;
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1157858051") ? (String) ipChange.ipc$dispatch("1157858051", new Object[]{this}) : this.venueName;
    }

    public boolean isXiaJia() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1495350793") ? ((Boolean) ipChange.ipc$dispatch("1495350793", new Object[]{this})).booleanValue() : TextUtils.equals("0", this.viewStatus);
    }

    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503341717")) {
            ipChange.ipc$dispatch("-503341717", new Object[]{this, str});
        } else {
            this.cityId = str;
        }
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293611579")) {
            ipChange.ipc$dispatch("293611579", new Object[]{this, str});
        } else {
            this.cityName = str;
        }
    }

    public void setProjectId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204914585")) {
            ipChange.ipc$dispatch("204914585", new Object[]{this, str});
        } else {
            this.projectId = str;
        }
    }

    public void setProjectName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1971882263")) {
            ipChange.ipc$dispatch("-1971882263", new Object[]{this, str});
        } else {
            this.projectName = str;
        }
    }

    public void setProjectPoster(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-948547545")) {
            ipChange.ipc$dispatch("-948547545", new Object[]{this, str});
        } else {
            this.projectPoster = str;
        }
    }

    public void setShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1936477209")) {
            ipChange.ipc$dispatch("-1936477209", new Object[]{this, str});
        } else {
            this.showTime = str;
        }
    }

    public void setSubTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-13453287")) {
            ipChange.ipc$dispatch("-13453287", new Object[]{this, str});
        } else {
            this.subTitle = str;
        }
    }

    public void setVenueId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2135379197")) {
            ipChange.ipc$dispatch("-2135379197", new Object[]{this, str});
        } else {
            this.venueId = str;
        }
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431343661")) {
            ipChange.ipc$dispatch("-431343661", new Object[]{this, str});
        } else {
            this.venueName = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005400892")) {
            ipChange.ipc$dispatch("1005400892", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.cityId);
        parcel.writeString(this.cityName);
        parcel.writeString(this.projectId);
        parcel.writeString(this.projectName);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.projectPoster);
        parcel.writeString(this.showTime);
        parcel.writeString(this.venueId);
        parcel.writeString(this.venueName);
        parcel.writeString(this.viewStatus);
        parcel.writeByte(this.wantSee ? (byte) 1 : (byte) 0);
        parcel.writeString(this.simpleName);
    }

    public CommentProjectInfoBean() {
    }
}
