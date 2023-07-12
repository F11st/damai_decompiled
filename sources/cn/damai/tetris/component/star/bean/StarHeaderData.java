package cn.damai.tetris.component.star.bean;

import cn.damai.musicfestival.bean.ShareInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class StarHeaderData implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int TYPE_CLUB = 3;
    public static int TYPE_COMMON = 1;
    public static int TYPE_TAB = 2;
    public String backgroundPic;
    public String backgroundPicGif;
    public String bigHeadPic;
    public long fansNum;
    public String headPic;
    public String name;
    public long projectShowNum;
    public ShareInfo shareInfo;
    public List<String> tagList;
    public int targetType;
    public String id = "";
    public int followStatus = 0;
    public boolean vaccount = true;

    public String getTags() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1200073038")) {
            return (String) ipChange.ipc$dispatch("-1200073038", new Object[]{this});
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
