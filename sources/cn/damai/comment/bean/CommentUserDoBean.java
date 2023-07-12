package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k23;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentUserDoBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentUserDoBean> CREATOR = new Parcelable.Creator<CommentUserDoBean>() { // from class: cn.damai.comment.bean.CommentUserDoBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentUserDoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-655517535") ? (CommentUserDoBean) ipChange.ipc$dispatch("-655517535", new Object[]{this, parcel}) : new CommentUserDoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommentUserDoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "115906992") ? (CommentUserDoBean[]) ipChange.ipc$dispatch("115906992", new Object[]{this, Integer.valueOf(i)}) : new CommentUserDoBean[i];
        }
    };
    private String havanaIdStr;
    private String headerImage;
    private String nickname;
    private PerformFilmVipDO performFilmVipDO;
    private String userTag;
    private int userTypeCode;
    private String userTypeText;
    private boolean vip;
    private int vipLevel;
    private String vipLevelIcon;
    private String vtag;

    public CommentUserDoBean() {
    }

    private String getHavanaIdStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-333256997") ? (String) ipChange.ipc$dispatch("-333256997", new Object[]{this}) : this.havanaIdStr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "740211612")) {
            return ((Integer) ipChange.ipc$dispatch("740211612", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getDamaiUserId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1325891130") ? (String) ipChange.ipc$dispatch("1325891130", new Object[]{this}) : getHavanaIdStr();
    }

    public String getHeaderImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-343584534") ? (String) ipChange.ipc$dispatch("-343584534", new Object[]{this}) : this.headerImage;
    }

    public String getMemberFlag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1447996032")) {
            return (String) ipChange.ipc$dispatch("1447996032", new Object[]{this});
        }
        PerformFilmVipDO performFilmVipDO = this.performFilmVipDO;
        if (performFilmVipDO != null) {
            return performFilmVipDO.memberFlag;
        }
        return k23.h();
    }

    public String getNickname() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "297145736") ? (String) ipChange.ipc$dispatch("297145736", new Object[]{this}) : this.nickname;
    }

    public PerformFilmVipDO getPerformFilmVipDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1109909172") ? (PerformFilmVipDO) ipChange.ipc$dispatch("-1109909172", new Object[]{this}) : this.performFilmVipDO;
    }

    public String getUserTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1576104939") ? (String) ipChange.ipc$dispatch("1576104939", new Object[]{this}) : this.userTag;
    }

    public int getUserTypeCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-964105657") ? ((Integer) ipChange.ipc$dispatch("-964105657", new Object[]{this})).intValue() : this.userTypeCode;
    }

    public String getUserTypeText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1372845068") ? (String) ipChange.ipc$dispatch("1372845068", new Object[]{this}) : this.userTypeText;
    }

    public int getVipLevel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "254426738") ? ((Integer) ipChange.ipc$dispatch("254426738", new Object[]{this})).intValue() : this.vipLevel;
    }

    public String getVipLevelIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1520960282") ? (String) ipChange.ipc$dispatch("1520960282", new Object[]{this}) : this.vipLevelIcon;
    }

    public String getvTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "824306878") ? (String) ipChange.ipc$dispatch("824306878", new Object[]{this}) : this.vtag;
    }

    public boolean isPerformFilmVip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "778997872")) {
            return ((Boolean) ipChange.ipc$dispatch("778997872", new Object[]{this})).booleanValue();
        }
        PerformFilmVipDO performFilmVipDO = this.performFilmVipDO;
        return performFilmVipDO != null && k23.d(performFilmVipDO.memberFlag);
    }

    public boolean isVip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "76913741") ? ((Boolean) ipChange.ipc$dispatch("76913741", new Object[]{this})).booleanValue() : this.vip;
    }

    public void setHavanaIdStr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "253983739")) {
            ipChange.ipc$dispatch("253983739", new Object[]{this, str});
        } else {
            this.havanaIdStr = str;
        }
    }

    public void setHeaderImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66169908")) {
            ipChange.ipc$dispatch("-66169908", new Object[]{this, str});
        } else {
            this.headerImage = str;
        }
    }

    public void setNickname(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739255382")) {
            ipChange.ipc$dispatch("739255382", new Object[]{this, str});
        } else {
            this.nickname = str;
        }
    }

    public void setPerformFilmVipDO(PerformFilmVipDO performFilmVipDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206313936")) {
            ipChange.ipc$dispatch("206313936", new Object[]{this, performFilmVipDO});
        } else {
            this.performFilmVipDO = performFilmVipDO;
        }
    }

    public void setUserTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640725")) {
            ipChange.ipc$dispatch("-1640725", new Object[]{this, str});
        } else {
            this.userTag = str;
        }
    }

    public void setUserTypeCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1366202309")) {
            ipChange.ipc$dispatch("-1366202309", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.userTypeCode = i;
        }
    }

    public void setUserTypeText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6405202")) {
            ipChange.ipc$dispatch("6405202", new Object[]{this, str});
        } else {
            this.userTypeText = str;
        }
    }

    public void setVip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-602852511")) {
            ipChange.ipc$dispatch("-602852511", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.vip = z;
        }
    }

    public void setVipLevel(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "208076656")) {
            ipChange.ipc$dispatch("208076656", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.vipLevel = i;
        }
    }

    public void setVipLevelIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "303009540")) {
            ipChange.ipc$dispatch("303009540", new Object[]{this, str});
        } else {
            this.vipLevelIcon = str;
        }
    }

    public void setvTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-509047328")) {
            ipChange.ipc$dispatch("-509047328", new Object[]{this, str});
        } else {
            this.vtag = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "843101359")) {
            ipChange.ipc$dispatch("843101359", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.nickname);
        parcel.writeString(this.headerImage);
        parcel.writeString(this.vtag);
        parcel.writeString(this.userTag);
        parcel.writeByte(this.vip ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.vipLevel);
        parcel.writeInt(this.userTypeCode);
        parcel.writeString(this.userTypeText);
        parcel.writeString(this.vipLevelIcon);
        parcel.writeString(this.havanaIdStr);
        parcel.writeSerializable(this.performFilmVipDO);
    }

    protected CommentUserDoBean(Parcel parcel) {
        this.nickname = parcel.readString();
        this.headerImage = parcel.readString();
        this.vtag = parcel.readString();
        this.userTag = parcel.readString();
        this.vip = parcel.readByte() != 0;
        this.vipLevel = parcel.readInt();
        this.userTypeCode = parcel.readInt();
        this.userTypeText = parcel.readString();
        this.havanaIdStr = parcel.readString();
        this.vipLevelIcon = parcel.readString();
        this.performFilmVipDO = (PerformFilmVipDO) parcel.readSerializable();
    }
}
