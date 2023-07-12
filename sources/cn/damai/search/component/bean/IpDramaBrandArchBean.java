package cn.damai.search.component.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.tetris.component.ip.bean.VideoAlbum;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class IpDramaBrandArchBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRAND = "brand";
    public static final String DRAMA = "drama";
    public static final String MUSIC_FESTIVAL = "music_festival";
    private static final long serialVersionUID = 1;
    public ArrayList<BaccountInfo> artistList;
    public String backgroundPic;
    public ArrayList<VideoAlbum> contentList;
    public String damaiId;
    public String fansCount;
    public String headPic;
    public List<String> moreInfo;
    public String name;
    public String performanceCount;
    public String schema;
    public String score;
    public String subType;
    public String tourInfos;
    public String type;
    public String vaccount;

    public String getIpBrandType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1169119257") ? (String) ipChange.ipc$dispatch("1169119257", new Object[]{this}) : "11".equals(this.type) ? "brand" : "音乐节".equals(this.subType) ? "music_festival" : "drama";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0088, code lost:
        if (r0.equals("体育") == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getTagImageResourceRid() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.search.component.bean.IpDramaBrandArchBean.$ipChange
            java.lang.String r1 = "-775144106"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1b
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r5
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        L1b:
            java.lang.String r0 = r5.type
            java.lang.String r1 = "11"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 == 0) goto L28
            int r0 = cn.damai.commonbusiness.R$drawable.icon_ip_brand
            return r0
        L28:
            java.lang.String r0 = r5.subType
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = -1
            if (r0 == 0) goto L32
            return r1
        L32:
            java.lang.String r0 = r5.subType
            r0.hashCode()
            int r2 = r0.hashCode()
            switch(r2) {
                case 662463: goto L82;
                case 665857: goto L77;
                case 676275: goto L6c;
                case 768019: goto L61;
                case 888013: goto L56;
                case 1225917: goto L4b;
                case 38036837: goto L40;
                default: goto L3e;
            }
        L3e:
            r3 = -1
            goto L8b
        L40:
            java.lang.String r2 = "音乐节"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L49
            goto L3e
        L49:
            r3 = 6
            goto L8b
        L4b:
            java.lang.String r2 = "音乐"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L54
            goto L3e
        L54:
            r3 = 5
            goto L8b
        L56:
            java.lang.String r2 = "活动"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L5f
            goto L3e
        L5f:
            r3 = 4
            goto L8b
        L61:
            java.lang.String r2 = "展览"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L6a
            goto L3e
        L6a:
            r3 = 3
            goto L8b
        L6c:
            java.lang.String r2 = "剧场"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L75
            goto L3e
        L75:
            r3 = 2
            goto L8b
        L77:
            java.lang.String r2 = "休闲"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L80
            goto L3e
        L80:
            r3 = 1
            goto L8b
        L82:
            java.lang.String r2 = "体育"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L8b
            goto L3e
        L8b:
            switch(r3) {
                case 0: goto La1;
                case 1: goto L9e;
                case 2: goto L9b;
                case 3: goto L98;
                case 4: goto L95;
                case 5: goto L92;
                case 6: goto L8f;
                default: goto L8e;
            }
        L8e:
            return r1
        L8f:
            int r0 = cn.damai.commonbusiness.R$drawable.music_festival_icon
            return r0
        L92:
            int r0 = cn.damai.commonbusiness.R$drawable.icon_ip_music
            return r0
        L95:
            int r0 = cn.damai.commonbusiness.R$drawable.icon_ip_activity
            return r0
        L98:
            int r0 = cn.damai.commonbusiness.R$drawable.icon_ip_exhibition
            return r0
        L9b:
            int r0 = cn.damai.commonbusiness.R$drawable.icon_ip_drama_venue
            return r0
        L9e:
            int r0 = cn.damai.commonbusiness.R$drawable.icon_ip_leisure
            return r0
        La1:
            int r0 = cn.damai.commonbusiness.R$drawable.icon_ip_sport
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.search.component.bean.IpDramaBrandArchBean.getTagImageResourceRid():int");
    }

    public boolean isShowVTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "755589796") ? ((Boolean) ipChange.ipc$dispatch("755589796", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.vaccount) || "0".equals(this.vaccount)) ? false : true;
    }
}
