package cn.damai.mine.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.wannasee.bean.WannaBean;
import com.tencent.connect.common.Constants;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public enum PageType {
    RECORD("", 1, Constants.VIA_ACT_TYPE_NINETEEN),
    COMPILATION("", 2, "13");
    
    public final String requestType;
    public final int tabIndex;
    public final String tabName;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.bean.PageType$a */
    /* loaded from: classes15.dex */
    static /* synthetic */ class C1431a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PageType.values().length];
            a = iArr;
            try {
                iArr[PageType.RECORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PageType.COMPILATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    PageType(String str, int i, String str2) {
        this.tabName = str;
        this.tabIndex = i;
        this.requestType = str2;
    }

    public List getListByType(WannaBean wannaBean) {
        if (wannaBean != null) {
            int i = C1431a.a[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return wannaBean.items;
                }
                return wannaBean.rankings;
            }
            return wannaBean.cards;
        }
        return null;
    }

    public String getPageEmptyMsg() {
        return C1431a.a[ordinal()] != 1 ? "你还没有想看的合辑哦（-.-）" : "你还没有想看的现场记录哦（-.-）";
    }

    public String getTabName(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.tabName;
        }
        return this.tabName + " " + str;
    }

    public boolean isProject() {
        return true;
    }
}
