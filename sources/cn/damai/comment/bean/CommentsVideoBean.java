package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentsVideoBean implements Parcelable, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentsVideoBean> CREATOR = new Parcelable.Creator<CommentsVideoBean>() { // from class: cn.damai.comment.bean.CommentsVideoBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentsVideoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "705481661") ? (CommentsVideoBean) ipChange.ipc$dispatch("705481661", new Object[]{this, parcel}) : new CommentsVideoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentsVideoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1687307632") ? (CommentsVideoBean[]) ipChange.ipc$dispatch("1687307632", new Object[]{this, Integer.valueOf(i)}) : new CommentsVideoBean[i];
        }
    };
    private String coverUrl;
    private String fileId;
    private String height;
    private String sourceLabel;
    public String status;
    private String url;
    private String videoId;
    private String videoTime;
    private String width;

    public CommentsVideoBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1901221106")) {
            return ((Integer) ipChange.ipc$dispatch("-1901221106", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getCoverUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "270025412") ? (String) ipChange.ipc$dispatch("270025412", new Object[]{this}) : this.coverUrl;
    }

    public String getFileId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "140873475") ? (String) ipChange.ipc$dispatch("140873475", new Object[]{this}) : this.fileId;
    }

    public String getHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1351190413") ? (String) ipChange.ipc$dispatch("-1351190413", new Object[]{this}) : this.height;
    }

    public String getSourceLabel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "367170691") ? (String) ipChange.ipc$dispatch("367170691", new Object[]{this}) : this.sourceLabel;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1185161817") ? (String) ipChange.ipc$dispatch("1185161817", new Object[]{this}) : this.url;
    }

    public String getVideoId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1533487392") ? (String) ipChange.ipc$dispatch("-1533487392", new Object[]{this}) : this.videoId;
    }

    public String getVideoTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "529422610") ? (String) ipChange.ipc$dispatch("529422610", new Object[]{this}) : this.videoTime;
    }

    public String getWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-752595600") ? (String) ipChange.ipc$dispatch("-752595600", new Object[]{this}) : this.width;
    }

    public boolean isVideoStatusUnReview() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1592463322") ? ((Boolean) ipChange.ipc$dispatch("1592463322", new Object[]{this})).booleanValue() : TextUtils.equals("0", this.status);
    }

    public void setCoverUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101474662")) {
            ipChange.ipc$dispatch("-101474662", new Object[]{this, str});
        } else {
            this.coverUrl = str;
        }
    }

    public void setFileId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322981573")) {
            ipChange.ipc$dispatch("-1322981573", new Object[]{this, str});
        } else {
            this.fileId = str;
        }
    }

    public void setHeight(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332321845")) {
            ipChange.ipc$dispatch("-332321845", new Object[]{this, str});
        } else {
            this.height = str;
        }
    }

    public void setSourceLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "492405587")) {
            ipChange.ipc$dispatch("492405587", new Object[]{this, str});
        } else {
            this.sourceLabel = str;
        }
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496141251")) {
            ipChange.ipc$dispatch("-496141251", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }

    public void setVideoId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909722474")) {
            ipChange.ipc$dispatch("-1909722474", new Object[]{this, str});
        } else {
            this.videoId = str;
        }
    }

    public void setVideoTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561994148")) {
            ipChange.ipc$dispatch("1561994148", new Object[]{this, str});
        } else {
            this.videoTime = str;
        }
    }

    public void setWidth(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "635740422")) {
            ipChange.ipc$dispatch("635740422", new Object[]{this, str});
        } else {
            this.width = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948197245")) {
            ipChange.ipc$dispatch("948197245", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.fileId);
        parcel.writeString(this.height);
        parcel.writeString(this.width);
        parcel.writeString(this.videoId);
        parcel.writeString(this.sourceLabel);
        parcel.writeString(this.url);
        parcel.writeString(this.videoTime);
    }

    protected CommentsVideoBean(Parcel parcel) {
        this.coverUrl = parcel.readString();
        this.fileId = parcel.readString();
        this.height = parcel.readString();
        this.width = parcel.readString();
        this.videoId = parcel.readString();
        this.sourceLabel = parcel.readString();
        this.url = parcel.readString();
        this.videoTime = parcel.readString();
    }
}
