package cn.damai.commonbusiness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class UserBaseInfoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<UserBaseInfoBean> CREATOR = new Parcelable.Creator<UserBaseInfoBean>() { // from class: cn.damai.commonbusiness.model.UserBaseInfoBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserBaseInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1708673323") ? (UserBaseInfoBean) ipChange.ipc$dispatch("1708673323", new Object[]{this, parcel}) : new UserBaseInfoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserBaseInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1026280548") ? (UserBaseInfoBean[]) ipChange.ipc$dispatch("-1026280548", new Object[]{this, Integer.valueOf(i)}) : new UserBaseInfoBean[i];
        }
    };
    private String birthday;
    private String headImg;
    private boolean isVip;
    private String maskEmail;
    private String maskMobile;
    private String mobile;
    private String nationPrefix;
    private String nickname;
    private int sex;
    private int userId;
    private String userIntro;
    private String vipLevel;
    private String vipLevelIcon;
    private String vtag;

    protected UserBaseInfoBean(Parcel parcel) {
        this.headImg = parcel.readString();
        this.maskMobile = parcel.readString();
        this.mobile = parcel.readString();
        this.nationPrefix = parcel.readString();
        this.nickname = parcel.readString();
        this.userId = parcel.readInt();
        this.vtag = parcel.readString();
        this.maskEmail = parcel.readString();
        this.isVip = parcel.readByte() != 0;
        this.vipLevel = parcel.readString();
        this.vipLevelIcon = parcel.readString();
        this.sex = parcel.readInt();
        this.birthday = parcel.readString();
        this.userIntro = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533819244")) {
            return ((Integer) ipChange.ipc$dispatch("1533819244", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getBirthday() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1778288665") ? (String) ipChange.ipc$dispatch("-1778288665", new Object[]{this}) : this.birthday;
    }

    public String getHeadImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-857345009") ? (String) ipChange.ipc$dispatch("-857345009", new Object[]{this}) : this.headImg;
    }

    public String getMaskEmail() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1306750564") ? (String) ipChange.ipc$dispatch("-1306750564", new Object[]{this}) : this.maskEmail;
    }

    public String getMaskMobile() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "179775960") ? (String) ipChange.ipc$dispatch("179775960", new Object[]{this}) : this.maskMobile;
    }

    public String getMobile() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-294675124") ? (String) ipChange.ipc$dispatch("-294675124", new Object[]{this}) : this.mobile;
    }

    public String getNationPrefix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-388066141") ? (String) ipChange.ipc$dispatch("-388066141", new Object[]{this}) : this.nationPrefix;
    }

    public String getNickname() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2049268568") ? (String) ipChange.ipc$dispatch("2049268568", new Object[]{this}) : this.nickname;
    }

    public int getSex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "988267169") ? ((Integer) ipChange.ipc$dispatch("988267169", new Object[]{this})).intValue() : this.sex;
    }

    public int getUserId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1242270115") ? ((Integer) ipChange.ipc$dispatch("1242270115", new Object[]{this})).intValue() : this.userId;
    }

    public String getUserIntro() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1153443949") ? (String) ipChange.ipc$dispatch("1153443949", new Object[]{this}) : this.userIntro;
    }

    public String getVipLevel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1960962513") ? (String) ipChange.ipc$dispatch("1960962513", new Object[]{this}) : this.vipLevel;
    }

    public String getVipLevelIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-882908950") ? (String) ipChange.ipc$dispatch("-882908950", new Object[]{this}) : this.vipLevelIcon;
    }

    public String getVtag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1799218894") ? (String) ipChange.ipc$dispatch("1799218894", new Object[]{this}) : this.vtag;
    }

    public boolean isVip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1798528899") ? ((Boolean) ipChange.ipc$dispatch("-1798528899", new Object[]{this})).booleanValue() : this.isVip;
    }

    public void setBirthday(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825298391")) {
            ipChange.ipc$dispatch("825298391", new Object[]{this, str});
        } else {
            this.birthday = str;
        }
    }

    public void setHeadImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1870822215")) {
            ipChange.ipc$dispatch("1870822215", new Object[]{this, str});
        } else {
            this.headImg = str;
        }
    }

    public void setMaskEmail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "475200602")) {
            ipChange.ipc$dispatch("475200602", new Object[]{this, str});
        } else {
            this.maskEmail = str;
        }
    }

    public void setMaskMobile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-831795962")) {
            ipChange.ipc$dispatch("-831795962", new Object[]{this, str});
        } else {
            this.maskMobile = str;
        }
    }

    public void setMobile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1940086254")) {
            ipChange.ipc$dispatch("-1940086254", new Object[]{this, str});
        } else {
            this.mobile = str;
        }
    }

    public void setNationPrefix(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1252732571")) {
            ipChange.ipc$dispatch("1252732571", new Object[]{this, str});
        } else {
            this.nationPrefix = str;
        }
    }

    public void setNickname(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779511674")) {
            ipChange.ipc$dispatch("-779511674", new Object[]{this, str});
        } else {
            this.nickname = str;
        }
    }

    public void setSex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786621047")) {
            ipChange.ipc$dispatch("-1786621047", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.sex = i;
        }
    }

    public void setUserId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629828959")) {
            ipChange.ipc$dispatch("629828959", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.userId = i;
        }
    }

    public void setUserIntro(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-568180823")) {
            ipChange.ipc$dispatch("-568180823", new Object[]{this, str});
        } else {
            this.userIntro = str;
        }
    }

    public void setVip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "983034769")) {
            ipChange.ipc$dispatch("983034769", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isVip = z;
        }
    }

    public void setVipLevel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777967917")) {
            ipChange.ipc$dispatch("777967917", new Object[]{this, str});
        } else {
            this.vipLevel = str;
        }
    }

    public void setVipLevelIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1202492620")) {
            ipChange.ipc$dispatch("-1202492620", new Object[]{this, str});
        } else {
            this.vipLevelIcon = str;
        }
    }

    public void setVtag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351545904")) {
            ipChange.ipc$dispatch("-351545904", new Object[]{this, str});
        } else {
            this.vtag = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662400801")) {
            ipChange.ipc$dispatch("-662400801", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.headImg);
        parcel.writeString(this.maskMobile);
        parcel.writeString(this.mobile);
        parcel.writeString(this.nationPrefix);
        parcel.writeString(this.nickname);
        parcel.writeInt(this.userId);
        parcel.writeString(this.vtag);
        parcel.writeString(this.maskEmail);
        parcel.writeByte(this.isVip ? (byte) 1 : (byte) 0);
        parcel.writeString(this.vipLevel);
        parcel.writeString(this.vipLevelIcon);
        parcel.writeInt(this.sex);
        parcel.writeString(this.birthday);
        parcel.writeString(this.userIntro);
    }

    public UserBaseInfoBean() {
    }
}
