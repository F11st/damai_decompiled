package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CertificationInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CertificationInfoBean> CREATOR = new Parcelable.Creator<CertificationInfoBean>() { // from class: cn.damai.commonbusiness.model.CertificationInfoBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CertificationInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2003572047") ? (CertificationInfoBean) ipChange.ipc$dispatch("-2003572047", new Object[]{this, parcel}) : new CertificationInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CertificationInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2031890352") ? (CertificationInfoBean[]) ipChange.ipc$dispatch("2031890352", new Object[]{this, Integer.valueOf(i)}) : new CertificationInfoBean[i];
        }
    };
    private String accountVerifyCode;
    private String accountVerifyMsg;
    private int cardType;
    private String faceVerifyFailedType;
    private String maskIdCard;
    private String maskName;
    private String realNameAdvertImg;
    private boolean verification;

    public CertificationInfoBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1156604844")) {
            return ((Integer) ipChange.ipc$dispatch("-1156604844", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getAccountVerifyCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1582731465") ? (String) ipChange.ipc$dispatch("-1582731465", new Object[]{this}) : this.accountVerifyCode;
    }

    public String getAccountVerifyMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "112560877") ? (String) ipChange.ipc$dispatch("112560877", new Object[]{this}) : this.accountVerifyMsg;
    }

    public int getCardType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-868581673") ? ((Integer) ipChange.ipc$dispatch("-868581673", new Object[]{this})).intValue() : this.cardType;
    }

    public String getFaceVerifyFailedType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1571898559") ? (String) ipChange.ipc$dispatch("1571898559", new Object[]{this}) : this.faceVerifyFailedType;
    }

    public String getMaskIdCard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-839709079") ? (String) ipChange.ipc$dispatch("-839709079", new Object[]{this}) : this.maskIdCard;
    }

    public String getMaskName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1366463767") ? (String) ipChange.ipc$dispatch("-1366463767", new Object[]{this}) : this.maskName;
    }

    public String getRealNameAdvertImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "281593770") ? (String) ipChange.ipc$dispatch("281593770", new Object[]{this}) : this.realNameAdvertImg;
    }

    public boolean isVerification() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "935338821") ? ((Boolean) ipChange.ipc$dispatch("935338821", new Object[]{this})).booleanValue() : this.verification;
    }

    public void setAccountVerifyCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-809040353")) {
            ipChange.ipc$dispatch("-809040353", new Object[]{this, str});
        } else {
            this.accountVerifyCode = str;
        }
    }

    public void setAccountVerifyMsg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1977374831")) {
            ipChange.ipc$dispatch("-1977374831", new Object[]{this, str});
        } else {
            this.accountVerifyMsg = str;
        }
    }

    public void setCardType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-245445717")) {
            ipChange.ipc$dispatch("-245445717", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.cardType = i;
        }
    }

    public void setFaceVerifyFailedType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541904383")) {
            ipChange.ipc$dispatch("541904383", new Object[]{this, str});
        } else {
            this.faceVerifyFailedType = str;
        }
    }

    public void setMaskIdCard(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1923906197")) {
            ipChange.ipc$dispatch("1923906197", new Object[]{this, str});
        } else {
            this.maskIdCard = str;
        }
    }

    public void setMaskName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706968341")) {
            ipChange.ipc$dispatch("706968341", new Object[]{this, str});
        } else {
            this.maskName = str;
        }
    }

    public void setRealNameAdvertImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1150467084")) {
            ipChange.ipc$dispatch("1150467084", new Object[]{this, str});
        } else {
            this.realNameAdvertImg = str;
        }
    }

    public void setVerification(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045056723")) {
            ipChange.ipc$dispatch("-2045056723", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.verification = z;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1342593783")) {
            ipChange.ipc$dispatch("1342593783", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.cardType);
        parcel.writeString(this.maskIdCard);
        parcel.writeString(this.maskName);
        parcel.writeString(this.realNameAdvertImg);
        parcel.writeByte(this.verification ? (byte) 1 : (byte) 0);
    }

    protected CertificationInfoBean(Parcel parcel) {
        this.cardType = parcel.readInt();
        this.maskIdCard = parcel.readString();
        this.maskName = parcel.readString();
        this.realNameAdvertImg = parcel.readString();
        this.verification = parcel.readByte() != 0;
    }
}
