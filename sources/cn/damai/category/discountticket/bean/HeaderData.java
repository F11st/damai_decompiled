package cn.damai.category.discountticket.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HeaderData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<HeaderData> CREATOR = new Parcelable.Creator<HeaderData>() { // from class: cn.damai.category.discountticket.bean.HeaderData.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeaderData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1221380981") ? (HeaderData) ipChange.ipc$dispatch("-1221380981", new Object[]{this, parcel}) : new HeaderData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeaderData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-929969062") ? (HeaderData[]) ipChange.ipc$dispatch("-929969062", new Object[]{this, Integer.valueOf(i)}) : new HeaderData[i];
        }
    };
    public String bgPic;
    public String h5Url;
    public String sharePic;
    public String subtitle;
    public String tempTitle;
    public String title;

    public HeaderData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997288499")) {
            return ((Integer) ipChange.ipc$dispatch("-997288499", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isSupportShare() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-954217559") ? ((Boolean) ipChange.ipc$dispatch("-954217559", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.h5Url) || TextUtils.isEmpty(this.title) || TextUtils.isEmpty(this.sharePic)) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144574818")) {
            ipChange.ipc$dispatch("-2144574818", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.bgPic);
        parcel.writeString(this.h5Url);
        parcel.writeString(this.sharePic);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.title);
        parcel.writeString(this.tempTitle);
    }

    protected HeaderData(Parcel parcel) {
        this.bgPic = parcel.readString();
        this.h5Url = parcel.readString();
        this.sharePic = parcel.readString();
        this.subtitle = parcel.readString();
        this.title = parcel.readString();
        this.tempTitle = parcel.readString();
    }
}
