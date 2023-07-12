package cn.damai.commonbusiness.imagebrowse.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class PicInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PicInfo> CREATOR = new Parcelable.Creator<PicInfo>() { // from class: cn.damai.commonbusiness.imagebrowse.bean.PicInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PicInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "137493963") ? (PicInfo) ipChange.ipc$dispatch("137493963", new Object[]{this, parcel}) : new PicInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PicInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1003722838") ? (PicInfo[]) ipChange.ipc$dispatch("1003722838", new Object[]{this, Integer.valueOf(i)}) : new PicInfo[i];
        }
    };
    private String picDesc;
    private String picTitle;
    private String picUrl;

    public PicInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1564450511")) {
            return ((Integer) ipChange.ipc$dispatch("1564450511", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getPicDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-177455036") ? (String) ipChange.ipc$dispatch("-177455036", new Object[]{this}) : this.picDesc;
    }

    public String getPicTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1444987579") ? (String) ipChange.ipc$dispatch("1444987579", new Object[]{this}) : this.picTitle;
    }

    public String getPicUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1867954770") ? (String) ipChange.ipc$dispatch("1867954770", new Object[]{this}) : this.picUrl;
    }

    public void setPicDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472574898")) {
            ipChange.ipc$dispatch("1472574898", new Object[]{this, str});
        } else {
            this.picDesc = str;
        }
    }

    public void setPicTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962614147")) {
            ipChange.ipc$dispatch("1962614147", new Object[]{this, str});
        } else {
            this.picTitle = str;
        }
    }

    public void setPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676931020")) {
            ipChange.ipc$dispatch("676931020", new Object[]{this, str});
        } else {
            this.picUrl = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-374194724")) {
            ipChange.ipc$dispatch("-374194724", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.picUrl);
        parcel.writeString(this.picTitle);
        parcel.writeString(this.picDesc);
    }

    protected PicInfo(Parcel parcel) {
        this.picUrl = parcel.readString();
        this.picTitle = parcel.readString();
        this.picDesc = parcel.readString();
    }
}
