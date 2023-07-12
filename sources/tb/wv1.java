package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.rank.RankSquareCMSActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class wv1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Bundle a(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2111617351")) {
            return (Bundle) ipChange.ipc$dispatch("2111617351", new Object[]{Long.valueOf(j), str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Boolean.valueOf(z)});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", str2);
        bundle.putString("message", Html.fromHtml(str5 + "<br/>" + str3).toString());
        bundle.putString("imageurl", str6);
        bundle.putString("producturl", str + j + "&from=appshare");
        bundle.putString("fromWhere", str9);
        bundle.putString("sinaSharePath", str8);
        bundle.putString(RankSquareCMSActivity.PRESET_CITY_NAME, str4);
        bundle.putString("showDate", str3);
        bundle.putString("venueName", str5);
        bundle.putLong("projectId", j);
        bundle.putString("shareType", str10);
        bundle.putString("price", str7);
        bundle.putBoolean("showGenerateImage", z);
        if (GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL.equals(str9)) {
            bundle.putString("shareImageStyle", "projectImage");
        }
        bundle.putString("projectName", str2);
        bundle.putString("projectImage", str6);
        return bundle;
    }

    public static String b(String str, Bitmap bitmap, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533914552")) {
            return (String) ipChange.ipc$dispatch("1533914552", new Object[]{str, bitmap, context});
        }
        try {
            return ir1.i(mr1.STORAGE) ? j11.d(str, bitmap, context) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean c(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1120011540") ? ((Boolean) ipChange.ipc$dispatch("1120011540", new Object[]{str})).booleanValue() : wh2.n(str) >= 100000000;
    }
}
