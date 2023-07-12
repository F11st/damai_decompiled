package cn.damai.onearch.errpage.bean;

import androidx.annotation.Nullable;
import cn.damai.onearch.errpage.ErrClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ErrControlViewInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_ALL = "结果";
    public static final String TYPE_ARTIST = "艺人";
    public static final String TYPE_BRAND_IP = "厂牌";
    public static final String TYPE_FEED = "资讯";
    public static final String TYPE_PROJECT = "演出";
    public static final String TYPE_SCRIPT = "剧本杀";
    public static final String TYPE_VENUE = "场馆";
    @Nullable
    public ErrClickListener clickListener;
    public String errorCode;
    public String errorMsg;
    public int errorType;
    public String extra;
    public boolean hideTitle;

    public ErrControlViewInfo(int i, String str, String str2, String str3, @Nullable ErrClickListener errClickListener) {
        this.hideTitle = true;
        this.errorType = i;
        this.errorCode = str;
        this.errorMsg = str2;
        this.extra = str3;
        this.hideTitle = true;
        this.clickListener = errClickListener;
    }

    public static ErrControlViewInfo errNetInfo(String str, String str2, String str3, ErrClickListener errClickListener) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1997004783") ? (ErrControlViewInfo) ipChange.ipc$dispatch("-1997004783", new Object[]{str, str2, str3, errClickListener}) : new ErrControlViewInfo(1, str, str2, str3, errClickListener);
    }

    public static ErrControlViewInfo errResultEmpty(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1289667643") ? (ErrControlViewInfo) ipChange.ipc$dispatch("-1289667643", new Object[]{str, str2}) : new ErrControlViewInfo(3, str, str2, null, null);
    }

    public static ErrControlViewInfo errResultEmptyOpt(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1132325638")) {
            return (ErrControlViewInfo) ipChange.ipc$dispatch("-1132325638", new Object[]{str, str2, str3});
        }
        return new ErrControlViewInfo(3, str, "抱歉，没有搜索到\"" + str2 + "\"的相关" + str3, null, null);
    }

    public static ErrControlViewInfo errSensitiveWord(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-325401387") ? (ErrControlViewInfo) ipChange.ipc$dispatch("-325401387", new Object[]{str, str2}) : new ErrControlViewInfo(3, str, str2, null, null);
    }

    public ErrControlViewInfo() {
        this.hideTitle = true;
    }
}
