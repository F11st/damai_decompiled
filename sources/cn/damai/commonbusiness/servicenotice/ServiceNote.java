package cn.damai.commonbusiness.servicenotice;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ServiceNote implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ServiceNote> CREATOR = new C0869a();
    public String imgUrl;
    public String isSupport;
    public String tagDesc;
    public String tagDescWithStyle;
    public String tagName;
    public String tagType;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.servicenotice.ServiceNote$a */
    /* loaded from: classes.dex */
    public class C0869a implements Parcelable.Creator<ServiceNote> {
        private static transient /* synthetic */ IpChange $ipChange;

        C0869a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ServiceNote createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-827170037") ? (ServiceNote) ipChange.ipc$dispatch("-827170037", new Object[]{this, parcel}) : new ServiceNote(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ServiceNote[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-197567216") ? (ServiceNote[]) ipChange.ipc$dispatch("-197567216", new Object[]{this, Integer.valueOf(i)}) : new ServiceNote[i];
        }
    }

    public ServiceNote() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-159760409")) {
            return ((Integer) ipChange.ipc$dispatch("-159760409", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getImgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "96667409") ? (String) ipChange.ipc$dispatch("96667409", new Object[]{this}) : this.imgUrl;
    }

    public String getIsSupport() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1043955126") ? (String) ipChange.ipc$dispatch("1043955126", new Object[]{this}) : this.isSupport;
    }

    public String getTagDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1932173764") ? (String) ipChange.ipc$dispatch("-1932173764", new Object[]{this}) : this.tagDesc;
    }

    public String getTagName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "774773046") ? (String) ipChange.ipc$dispatch("774773046", new Object[]{this}) : this.tagName;
    }

    public String getTagType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1636892571") ? (String) ipChange.ipc$dispatch("-1636892571", new Object[]{this}) : this.tagType;
    }

    public boolean isSupport() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "398125296") ? ((Boolean) ipChange.ipc$dispatch("398125296", new Object[]{this})).booleanValue() : TextUtils.equals("true", this.isSupport);
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213769469")) {
            ipChange.ipc$dispatch("1213769469", new Object[]{this, parcel});
            return;
        }
        this.isSupport = parcel.readString();
        this.tagName = parcel.readString();
        this.tagDesc = parcel.readString();
        this.tagDescWithStyle = parcel.readString();
        this.tagType = parcel.readString();
        this.imgUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-660934716")) {
            ipChange.ipc$dispatch("-660934716", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.isSupport);
        parcel.writeString(this.tagName);
        parcel.writeString(this.tagDesc);
        parcel.writeString(this.tagDescWithStyle);
        parcel.writeString(this.tagType);
        parcel.writeString(this.imgUrl);
    }

    protected ServiceNote(Parcel parcel) {
        this.isSupport = parcel.readString();
        this.tagName = parcel.readString();
        this.tagDesc = parcel.readString();
        this.tagDescWithStyle = parcel.readString();
        this.tagType = parcel.readString();
        this.imgUrl = parcel.readString();
    }
}
