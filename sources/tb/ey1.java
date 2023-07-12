package tb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.qrcode.QrCodeResultActivity;
import cn.damai.commonbusiness.update.UpdateUtil;
import cn.damai.h5container.H5MainActivity;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.seat.ui.SVGDisplayActivity;
import com.ali.user.mobile.login.model.LoginConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.constants.LoginUrlConstants;
import com.taobao.login4android.scan.QrScanActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ey1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(String str, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766809756")) {
            ipChange.ipc$dispatch("-1766809756", new Object[]{str, activity});
        } else if (!TextUtils.isEmpty(str) && !str.startsWith("damai://V1/skuPage") && !str.startsWith("damai://V1/OrderCheckPage")) {
            b(str);
            if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
                if (str.startsWith("svg://damai.cn/check")) {
                    int indexOf = str.indexOf("=");
                    if (indexOf > 0 && indexOf < str.length() - 1) {
                        String substring = str.substring(indexOf + 1);
                        if (!substring.contains("http")) {
                            substring = "http://" + substring;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString(SVGDisplayActivity.REQUEST_SVG_URL, substring);
                        DMNav.from(activity).withExtras(bundle).toUri(NavUri.b("svg_display"));
                    }
                } else if (str.startsWith(tr2.SCHEME)) {
                    DMNav.from(activity).toUri(URLDecoder.decode(str));
                } else if (str.startsWith("gaiax://gaiax/preview")) {
                    try {
                        String replaceAll = str.replaceAll("gaiax://gaiax/preview", "");
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("url", replaceAll);
                        DMNav.from(activity).withExtras(bundle2).toUri("youku://gaiax/preview" + replaceAll);
                    } catch (Exception e) {
                        cb1.c("gaiax_preview", e.getStackTrace().toString());
                    }
                } else if (qx0.c(str)) {
                    qx0.d(str);
                } else {
                    activity.startActivity(new Intent(activity, QrCodeResultActivity.class));
                }
            } else {
                str = str.trim();
                if (str.contains("m.damai.cn/proj.aspx?id=")) {
                    long j = 0;
                    try {
                        j = Long.parseLong(str.substring(str.indexOf("id=") + 3, str.length()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong(IssueConstants.ProjectID, j);
                    DMNav.from(activity).withExtras(bundle3).toUri(NavUri.b(pl.PROJECT_DETAIL_PAGE));
                } else if (str.contains("m.damai.cn/activityproject.aspx?id=")) {
                    String substring2 = str.substring(str.indexOf("id=") + 3, str.length());
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("activityid", substring2);
                    DMNav.from(activity).withExtras(bundle4).toUri(NavUri.b("topic_main"));
                } else if (LoginUrlConstants.isCommonScanUrl(str)) {
                    Intent intent = new Intent(activity, QrScanActivity.class);
                    intent.putExtra(LoginConstant.SCAN_KEY, str);
                    activity.startActivity(intent);
                } else if (str.contains("mapi.damai.cn/Page/ScanCodeLogin/Confirm.aspx")) {
                    cb1.c("a", "____________ url:" + str);
                    Intent intent2 = new Intent(activity, H5MainActivity.class);
                    intent2.putExtra("url", str);
                    intent2.putExtra("from", gh1.MODULE_BANNER);
                    activity.startActivityForResult(intent2, 10);
                } else if (!c(str).contains("ossgw.alicdn.com/rapid-oss-bucket") && !c(str).contains("m.taobao.com/homepage/preview.htm")) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putString("from", gh1.MODULE_BANNER);
                    bundle5.putBoolean("fromQr", true);
                    DMNav.from(activity).withExtras(bundle5).toUri(str);
                } else {
                    od0.a(activity, str);
                }
            }
            if ((str.contains("mtl3.alibaba-inc.com") || str.contains("mtl4.alibaba-inc.com") || str.contains("mtl.alibaba-inc.com")) && str.contains("dynamicdeploy")) {
                UpdateUtil.j(str);
            }
            activity.finish();
        } else {
            Log.d("DMNav", "qrcodemanager v1 interrupt ");
            ToastUtil.i("页面跳转非法，请通过正常路径打开哦");
            activity.finish();
        }
    }

    public static void b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938712073")) {
            ipChange.ipc$dispatch("-938712073", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter("utm");
                if (TextUtils.isEmpty(queryParameter)) {
                    return;
                }
                C0529c.e().H("utm", queryParameter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-772990299")) {
            return (String) ipChange.ipc$dispatch("-772990299", new Object[]{str});
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
