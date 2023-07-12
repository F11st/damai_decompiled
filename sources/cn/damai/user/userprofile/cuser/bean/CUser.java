package cn.damai.user.userprofile.cuser.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class CUser {
    private static transient /* synthetic */ IpChange $ipChange;
    public String birthday;
    public String city;
    private List<CommonFavObject> commonArtist;
    private List<CommonFavObject> commonProject;
    public String county;
    private DynamicsList dynamicsList;
    private List<String> fansImg;
    private String fansNum;
    private int favoriteFlag;
    private FocusList focusList;
    private List<String> followImg;
    private String followNum;
    public String headBgImg;
    private String headImg;
    private String sex;
    public String summary;
    private String userId;
    public String userNick;
    public boolean vaccount;

    public String getAddress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1163416735")) {
            return (String) ipChange.ipc$dispatch("1163416735", new Object[]{this});
        }
        if (!wh2.j(this.county) && !wh2.j(this.city)) {
            return this.county + " / " + this.city;
        } else if (wh2.j(this.county)) {
            return !wh2.j(this.city) ? this.city : "";
        } else {
            return this.county;
        }
    }

    public String getBirthday() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "521750248") ? (String) ipChange.ipc$dispatch("521750248", new Object[]{this}) : this.birthday;
    }

    public List<CommonFavObject> getCommonArtist() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1809523172") ? (List) ipChange.ipc$dispatch("1809523172", new Object[]{this}) : this.commonArtist;
    }

    public List<CommonFavObject> getCommonProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "591901248") ? (List) ipChange.ipc$dispatch("591901248", new Object[]{this}) : this.commonProject;
    }

    public DynamicsList getDynamicsList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "242988638") ? (DynamicsList) ipChange.ipc$dispatch("242988638", new Object[]{this}) : this.dynamicsList;
    }

    public List<String> getFansImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1061829685") ? (List) ipChange.ipc$dispatch("1061829685", new Object[]{this}) : this.fansImg;
    }

    public String getFansNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1689833647") ? (String) ipChange.ipc$dispatch("-1689833647", new Object[]{this}) : this.fansNum;
    }

    public int getFavoriteFlag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1162400800") ? ((Integer) ipChange.ipc$dispatch("1162400800", new Object[]{this})).intValue() : this.favoriteFlag;
    }

    public FocusList getFocusList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2142657108") ? (FocusList) ipChange.ipc$dispatch("2142657108", new Object[]{this}) : this.focusList;
    }

    public List<String> getFollowImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "903393508") ? (List) ipChange.ipc$dispatch("903393508", new Object[]{this}) : this.followImg;
    }

    public String getFollowNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "671822912") ? (String) ipChange.ipc$dispatch("671822912", new Object[]{this}) : this.followNum;
    }

    public String getHeadImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1475886866") ? (String) ipChange.ipc$dispatch("-1475886866", new Object[]{this}) : this.headImg;
    }

    public String getSex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-297322479") ? (String) ipChange.ipc$dispatch("-297322479", new Object[]{this}) : this.sex;
    }

    public String getUserId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "871275569") ? (String) ipChange.ipc$dispatch("871275569", new Object[]{this}) : this.userId;
    }

    public void setBirthday(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-887939338")) {
            ipChange.ipc$dispatch("-887939338", new Object[]{this, str});
        } else {
            this.birthday = str;
        }
    }

    public void setCommonArtist(List<CommonFavObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-943693208")) {
            ipChange.ipc$dispatch("-943693208", new Object[]{this, list});
        } else {
            this.commonArtist = list;
        }
    }

    public void setCommonProject(List<CommonFavObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225335004")) {
            ipChange.ipc$dispatch("-225335004", new Object[]{this, list});
        } else {
            this.commonProject = list;
        }
    }

    public void setDynamicsList(DynamicsList dynamicsList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023193068")) {
            ipChange.ipc$dispatch("-1023193068", new Object[]{this, dynamicsList});
        } else {
            this.dynamicsList = dynamicsList;
        }
    }

    public void setFansImg(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953896143")) {
            ipChange.ipc$dispatch("1953896143", new Object[]{this, list});
        } else {
            this.fansImg = list;
        }
    }

    public void setFansNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1833478213")) {
            ipChange.ipc$dispatch("1833478213", new Object[]{this, str});
        } else {
            this.fansNum = str;
        }
    }

    public void setFavoriteFlag(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "130988418")) {
            ipChange.ipc$dispatch("130988418", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.favoriteFlag = i;
        }
    }

    public void setFocusList(FocusList focusList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036321128")) {
            ipChange.ipc$dispatch("2036321128", new Object[]{this, focusList});
        } else {
            this.focusList = focusList;
        }
    }

    public void setFollowImg(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524688128")) {
            ipChange.ipc$dispatch("1524688128", new Object[]{this, list});
        } else {
            this.followImg = list;
        }
    }

    public void setFollowNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1681436214")) {
            ipChange.ipc$dispatch("1681436214", new Object[]{this, str});
        } else {
            this.followNum = str;
        }
    }

    public void setHeadImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124106168")) {
            ipChange.ipc$dispatch("-124106168", new Object[]{this, str});
        } else {
            this.headImg = str;
        }
    }

    public void setSex(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791485829")) {
            ipChange.ipc$dispatch("791485829", new Object[]{this, str});
        } else {
            this.sex = str;
        }
    }

    public void setUserId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155353139")) {
            ipChange.ipc$dispatch("-155353139", new Object[]{this, str});
        } else {
            this.userId = str;
        }
    }
}
