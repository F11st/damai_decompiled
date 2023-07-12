package cn.damai.commonbusiness.wannasee.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public enum PageType {
    SHOW("全部演出", 0, "7", -1),
    VALID_SHOW("可购票", 1, "7", 2),
    SCRIPT(ErrControlViewInfo.TYPE_SCRIPT, 2, "25", -1),
    RECORD("现场记录", 3, Constants.VIA_ACT_TYPE_NINETEEN, -1),
    COMPILATION("合辑", 4, "13", -1);
    
    public final String requestType;
    public final int subType;
    public final int tabIndex;
    public final String tabName;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PageType.values().length];
            a = iArr;
            try {
                iArr[PageType.SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PageType.VALID_SHOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PageType.RECORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PageType.SCRIPT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[PageType.COMPILATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    PageType(String str, int i, String str2, int i2) {
        this.tabName = str;
        this.tabIndex = i;
        this.requestType = str2;
        this.subType = i2;
    }

    public List getListByType(WannaBean wannaBean) {
        RecommendProjects recommendProjects;
        if (wannaBean != null) {
            int i = a.a[ordinal()];
            if (i != 1 && i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return new ArrayList();
                        }
                        return wannaBean.rankings;
                    }
                    return wannaBean.scriptInfos;
                }
                return wannaBean.cards;
            }
            List<ProjectItemBean> list = wannaBean.items;
            ArrayList arrayList = new ArrayList();
            if (!cb2.d(list)) {
                arrayList.addAll(list);
            }
            try {
                if (z20.K() && (recommendProjects = wannaBean.recommendProjects) != null && recommendProjects.isValid()) {
                    int i2 = recommendProjects.index;
                    if (i2 >= 0 && i2 <= arrayList.size()) {
                        arrayList.add(i2, recommendProjects);
                    } else {
                        arrayList.add(recommendProjects);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }
        return null;
    }

    public String getPageEmptyMsg() {
        int i = a.a[ordinal()];
        return (i == 1 || i == 2) ? "你还没有想看的演出哦（-.-）" : i != 3 ? i != 4 ? i != 5 ? "你还没有想看的内容哦（-.-）" : "你还没有想看的合辑哦（-.-）" : "你还没有想玩的剧本哦（-.-）" : "你还没有想看的现场记录哦（-.-）";
    }

    public String getTabName(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.tabName;
        }
        return this.tabName + " " + str;
    }

    public boolean isProject() {
        return this == SHOW;
    }
}
