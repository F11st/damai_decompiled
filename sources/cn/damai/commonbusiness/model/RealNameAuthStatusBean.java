package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class RealNameAuthStatusBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameAuthStatusBean> CREATOR = new Parcelable.Creator<RealNameAuthStatusBean>() { // from class: cn.damai.commonbusiness.model.RealNameAuthStatusBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealNameAuthStatusBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "521912459") ? (RealNameAuthStatusBean) ipChange.ipc$dispatch("521912459", new Object[]{this, parcel}) : new RealNameAuthStatusBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealNameAuthStatusBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-572787222") ? (RealNameAuthStatusBean[]) ipChange.ipc$dispatch("-572787222", new Object[]{this, Integer.valueOf(i)}) : new RealNameAuthStatusBean[i];
        }
    };
    private int accountVerifyCode;
    private String accountVerifyMsg;
    private int faceVerifyCode;
    private boolean faceVerifyEnable;
    private String faceVerifyFailedMsg;
    private String faceVerifyFailedType;
    private String faceVerifyMsg;
    private String idCard;
    private String maskIdCard;
    private String maskName;
    private String mobile;
    private String name;
    private boolean verification;

    public RealNameAuthStatusBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1567925819")) {
            return ((Integer) ipChange.ipc$dispatch("-1567925819", new Object[]{this})).intValue();
        }
        return 0;
    }

    public int getAccountVerifyCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-474929811") ? ((Integer) ipChange.ipc$dispatch("-474929811", new Object[]{this})).intValue() : this.accountVerifyCode;
    }

    public String getAccountVerifyMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-545970722") ? (String) ipChange.ipc$dispatch("-545970722", new Object[]{this}) : this.accountVerifyMsg;
    }

    public int getFaceVerifyCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1309324211") ? ((Integer) ipChange.ipc$dispatch("-1309324211", new Object[]{this})).intValue() : this.faceVerifyCode;
    }

    public String getFaceVerifyFailedMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-759652799") ? (String) ipChange.ipc$dispatch("-759652799", new Object[]{this}) : this.faceVerifyFailedMsg;
    }

    public String getFaceVerifyFailedType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1180172080") ? (String) ipChange.ipc$dispatch("1180172080", new Object[]{this}) : this.faceVerifyFailedType;
    }

    public String getFaceVerifyMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1901038782") ? (String) ipChange.ipc$dispatch("1901038782", new Object[]{this}) : this.faceVerifyMsg;
    }

    public String getIdCard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "66886158") ? (String) ipChange.ipc$dispatch("66886158", new Object[]{this}) : this.idCard;
    }

    public String getMaskIdCard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "695857690") ? (String) ipChange.ipc$dispatch("695857690", new Object[]{this}) : this.maskIdCard;
    }

    public String getMaskName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "959153882") ? (String) ipChange.ipc$dispatch("959153882", new Object[]{this}) : this.maskName;
    }

    public String getMobile() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1957225061") ? (String) ipChange.ipc$dispatch("1957225061", new Object[]{this}) : this.mobile;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "274701262") ? (String) ipChange.ipc$dispatch("274701262", new Object[]{this}) : this.name;
    }

    public boolean isFaceVerifyEnable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "465006584") ? ((Boolean) ipChange.ipc$dispatch("465006584", new Object[]{this})).booleanValue() : this.faceVerifyEnable;
    }

    public boolean isVerification() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2059499274") ? ((Boolean) ipChange.ipc$dispatch("-2059499274", new Object[]{this})).booleanValue() : this.verification;
    }

    public void setAccountVerifyCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652993853")) {
            ipChange.ipc$dispatch("1652993853", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.accountVerifyCode = i;
        }
    }

    public void setAccountVerifyMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-917017920")) {
            ipChange.ipc$dispatch("-917017920", new Object[]{this, str});
        } else {
            this.accountVerifyMsg = str;
        }
    }

    public void setFaceVerifyCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "601895925")) {
            ipChange.ipc$dispatch("601895925", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.faceVerifyCode = i;
        }
    }

    public void setFaceVerifyEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1607532068")) {
            ipChange.ipc$dispatch("-1607532068", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.faceVerifyEnable = z;
        }
    }

    public void setFaceVerifyFailedMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-399710891")) {
            ipChange.ipc$dispatch("-399710891", new Object[]{this, str});
        } else {
            this.faceVerifyFailedMsg = str;
        }
    }

    public void setFaceVerifyFailedType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1283285422")) {
            ipChange.ipc$dispatch("1283285422", new Object[]{this, str});
        } else {
            this.faceVerifyFailedType = str;
        }
    }

    public void setFaceVerifyMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1228963704")) {
            ipChange.ipc$dispatch("1228963704", new Object[]{this, str});
        } else {
            this.faceVerifyMsg = str;
        }
    }

    public void setIdCard(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678378896")) {
            ipChange.ipc$dispatch("678378896", new Object[]{this, str});
        } else {
            this.idCard = str;
        }
    }

    public void setMaskIdCard(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2013131516")) {
            ipChange.ipc$dispatch("-2013131516", new Object[]{this, str});
        } else {
            this.maskIdCard = str;
        }
    }

    public void setMaskName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213328572")) {
            ipChange.ipc$dispatch("-213328572", new Object[]{this, str});
        } else {
            this.maskName = str;
        }
    }

    public void setMobile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850657255")) {
            ipChange.ipc$dispatch("-850657255", new Object[]{this, str});
        } else {
            this.mobile = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-366952240")) {
            ipChange.ipc$dispatch("-366952240", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setVerification(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1838589598")) {
            ipChange.ipc$dispatch("1838589598", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.verification = z;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715539366")) {
            ipChange.ipc$dispatch("1715539366", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.accountVerifyCode);
        parcel.writeString(this.accountVerifyMsg);
        parcel.writeInt(this.faceVerifyCode);
        parcel.writeByte(this.faceVerifyEnable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.faceVerifyMsg);
        parcel.writeString(this.idCard);
        parcel.writeString(this.maskIdCard);
        parcel.writeString(this.maskName);
        parcel.writeString(this.faceVerifyFailedMsg);
        parcel.writeString(this.faceVerifyFailedType);
        parcel.writeString(this.mobile);
        parcel.writeString(this.name);
        parcel.writeByte(this.verification ? (byte) 1 : (byte) 0);
    }

    protected RealNameAuthStatusBean(Parcel parcel) {
        this.accountVerifyCode = parcel.readInt();
        this.accountVerifyMsg = parcel.readString();
        this.faceVerifyCode = parcel.readInt();
        this.faceVerifyEnable = parcel.readByte() != 0;
        this.faceVerifyMsg = parcel.readString();
        this.idCard = parcel.readString();
        this.maskIdCard = parcel.readString();
        this.maskName = parcel.readString();
        this.faceVerifyFailedMsg = parcel.readString();
        this.faceVerifyFailedType = parcel.readString();
        this.mobile = parcel.readString();
        this.name = parcel.readString();
        this.verification = parcel.readByte() != 0;
    }
}
