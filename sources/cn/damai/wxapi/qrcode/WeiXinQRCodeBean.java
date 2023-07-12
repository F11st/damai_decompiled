package cn.damai.wxapi.qrcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class WeiXinQRCodeBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<WeiXinQRCodeBean> CREATOR = new Parcelable.Creator<WeiXinQRCodeBean>() { // from class: cn.damai.wxapi.qrcode.WeiXinQRCodeBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeiXinQRCodeBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-353309877") ? (WeiXinQRCodeBean) ipChange.ipc$dispatch("-353309877", new Object[]{this, parcel}) : new WeiXinQRCodeBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeiXinQRCodeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "999416782") ? (WeiXinQRCodeBean[]) ipChange.ipc$dispatch("999416782", new Object[]{this, Integer.valueOf(i)}) : new WeiXinQRCodeBean[i];
        }
    };
    private String qrcodeURL;

    public WeiXinQRCodeBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632007795")) {
            return ((Integer) ipChange.ipc$dispatch("1632007795", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getQrcodeURL() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1737850778") ? (String) ipChange.ipc$dispatch("-1737850778", new Object[]{this}) : this.qrcodeURL;
    }

    public void setQrcodeURL(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4004144")) {
            ipChange.ipc$dispatch("-4004144", new Object[]{this, str});
        } else {
            this.qrcodeURL = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "617161400")) {
            ipChange.ipc$dispatch("617161400", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeString(this.qrcodeURL);
        }
    }

    protected WeiXinQRCodeBean(Parcel parcel) {
        this.qrcodeURL = parcel.readString();
    }
}
