package cn.damai.user.userprofile.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UserData implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int TYPE_CLUB = 3;
    public static int TYPE_COMMON = 1;
    public static int TYPE_TAB = 2;
    public String artistBgImg;
    public String artistGifImg;
    public long bid;
    public String birthday;
    public String bname;
    public String city;
    public String commonInfo;
    public long fansNum;
    public int favoriteFlag;
    public long focusNum;
    public String havanaIdStr;
    public String headBgImg;
    public String headImg;
    public int isTabArtist;
    public double lat;
    public double lng;
    public boolean makeComment;
    public boolean mySelf;
    public String nickname;
    public String nicknameStatus;
    public int projectCount;
    public int sex;
    public String summary;
    public List<String> tagList;
    public String talkId;
    public String talkInfo;
    public List<String> talkUserImg;
    public int type;
    public String userId;
    public int userTypeCode = 0;
    public String userTypeIcon;
    public boolean vaccount;
    public boolean vip;
    public String vipLevelIcon;

    public String getTags() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1123462180")) {
            return (String) ipChange.ipc$dispatch("-1123462180", new Object[]{this});
        }
        String str = "";
        List<String> list = this.tagList;
        if (list != null && list.size() > 0) {
            Iterator<String> it = this.tagList.iterator();
            while (it.hasNext()) {
                str = str + it.next();
                if (i < this.tagList.size() - 1) {
                    str = str + " | ";
                    i++;
                }
            }
        }
        return str;
    }
}
