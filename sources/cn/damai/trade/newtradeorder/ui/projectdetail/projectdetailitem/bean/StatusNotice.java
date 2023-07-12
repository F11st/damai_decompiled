package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class StatusNotice implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<StatusNotice> CREATOR = new Parcelable.Creator<StatusNotice>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.StatusNotice.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatusNotice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1648184961") ? (StatusNotice) ipChange.ipc$dispatch("-1648184961", new Object[]{this, parcel}) : new StatusNotice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatusNotice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1020219088") ? (StatusNotice[]) ipChange.ipc$dispatch("1020219088", new Object[]{this, Integer.valueOf(i)}) : new StatusNotice[i];
        }
    };
    private String hasPopup;
    public String imageUrl;
    private String notice;
    private String popupContent;
    private String popupTitle;
    private String prefixText;

    protected StatusNotice(Parcel parcel) {
        this.prefixText = parcel.readString();
        this.notice = parcel.readString();
        this.hasPopup = parcel.readString();
        this.popupTitle = parcel.readString();
        this.popupContent = parcel.readString();
        this.imageUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4937581")) {
            return ((Integer) ipChange.ipc$dispatch("4937581", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getHasPopup() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-494744675") ? (String) ipChange.ipc$dispatch("-494744675", new Object[]{this}) : this.hasPopup;
    }

    public String getNotice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1448624829") ? (String) ipChange.ipc$dispatch("-1448624829", new Object[]{this}) : this.notice;
    }

    public String getPopupContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1418415080") ? (String) ipChange.ipc$dispatch("-1418415080", new Object[]{this}) : this.popupContent;
    }

    public String getPopupTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1619788151") ? (String) ipChange.ipc$dispatch("1619788151", new Object[]{this}) : this.popupTitle;
    }

    public String getPrefixText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1211342902") ? (String) ipChange.ipc$dispatch("-1211342902", new Object[]{this}) : this.prefixText;
    }

    public boolean isHasPopup() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-977195737") ? ((Boolean) ipChange.ipc$dispatch("-977195737", new Object[]{this})).booleanValue() : TextUtils.equals("true", this.hasPopup);
    }

    public void setHasPopup(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1960456417")) {
            ipChange.ipc$dispatch("1960456417", new Object[]{this, str});
        } else {
            this.hasPopup = str;
        }
    }

    public void setNotice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942178555")) {
            ipChange.ipc$dispatch("942178555", new Object[]{this, str});
        } else {
            this.notice = str;
        }
    }

    public void setPopupContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-623313466")) {
            ipChange.ipc$dispatch("-623313466", new Object[]{this, str});
        } else {
            this.popupContent = str;
        }
    }

    public void setPopupTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858908999")) {
            ipChange.ipc$dispatch("858908999", new Object[]{this, str});
        } else {
            this.popupTitle = str;
        }
    }

    public void setPrefixText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006807724")) {
            ipChange.ipc$dispatch("-1006807724", new Object[]{this, str});
        } else {
            this.prefixText = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969810178")) {
            ipChange.ipc$dispatch("-1969810178", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.prefixText);
        parcel.writeString(this.notice);
        parcel.writeString(this.hasPopup);
        parcel.writeString(this.popupTitle);
        parcel.writeString(this.popupContent);
        parcel.writeString(this.imageUrl);
    }

    public StatusNotice() {
    }
}
