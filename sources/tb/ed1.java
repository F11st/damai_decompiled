package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.util.ToastUtil;
import cn.damai.member.R$string;
import cn.damai.ticklet.view.TickletAnimWindow;
import cn.damai.ticklet.view.TickletVenueMapChooseView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ed1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: tb.ed1$a */
    /* loaded from: classes7.dex */
    public class C9099a implements TickletAnimWindow.ICustomDialogEventListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ TickletAnimWindow e;

        C9099a(Context context, String str, String str2, String str3, TickletAnimWindow tickletAnimWindow) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = tickletAnimWindow;
        }

        @Override // cn.damai.ticklet.view.TickletAnimWindow.ICustomDialogEventListener
        public void dialogItemEvent(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "517053392")) {
                ipChange.ipc$dispatch("517053392", new Object[]{this, view});
            } else if (view.getTag() != null) {
                ed1.this.b(this.a, (String) view.getTag(), this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "579806896")) {
            ipChange.ipc$dispatch("579806896", new Object[]{this, context, str, str2, str3, str4});
            return;
        }
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            if (!wh2.j(str2) && !wh2.j(str3)) {
                if (str.startsWith("com.baidu.BaiduMap")) {
                    try {
                        double[] c = c(Double.parseDouble(str2), Double.parseDouble(str3));
                        if (c != null) {
                            str2 = String.valueOf(c[0]);
                            str3 = String.valueOf(c[1]);
                        }
                        intent = Intent.getIntent("intent://map/marker?location=" + str2 + "," + str3 + "&title=到达位置&content=" + str4 + "&src=cn.damai|DamaiApp#Intent;scheme=bdapp;package=" + str + ";end");
                    } catch (URISyntaxException e) {
                        cb1.b(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, e.getMessage());
                    }
                } else if (str.startsWith("com.autonavi.minimap")) {
                    String[] strArr = {str2, str3};
                    intent.setData(Uri.parse("androidamap://navi?sourceApplication=DamaiApp&poiname=" + str4 + "&lat=" + strArr[0] + "&lon=" + strArr[1] + "&dev=0&style=0"));
                }
            } else if (str.startsWith("com.baidu.BaiduMap")) {
                intent.setClassName("com.baidu.BaiduMap", "com.baidu.baidumaps.WelcomeScreen");
            } else if (str.startsWith("com.autonavi.minimap")) {
                intent.setClassName("com.autonavi.minimap", "com.autonavi.map.activity.SplashActivity");
            }
        }
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    private double[] c(double d, double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2012033677")) {
            return (double[]) ipChange.ipc$dispatch("2012033677", new Object[]{this, Double.valueOf(d), Double.valueOf(d2)});
        }
        double sqrt = Math.sqrt((d * d) + (d2 * d2)) + (Math.sin(d2 * 52.35987755982988d) * 2.0E-5d);
        double atan2 = Math.atan2(d2, d) + (Math.cos(d * 52.35987755982988d) * 3.0E-6d);
        return new double[]{(Math.cos(atan2) * sqrt) + 0.0065d, (sqrt * Math.sin(atan2)) + 0.006d};
    }

    private static List<ResolveInfo> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105168879")) {
            return (List) ipChange.ipc$dispatch("2105168879", new Object[0]);
        }
        new HashMap();
        List<ResolveInfo> queryIntentActivities = mu0.a().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:38.899533,-77.036476")), 32);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            Iterator<ResolveInfo> it = queryIntentActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo next = it.next();
                if (next.activityInfo.packageName.contains("com.autonavi.minimap")) {
                    arrayList.add(next);
                    break;
                } else if (next.activityInfo.packageName.contains("com.baidu.BaiduMap")) {
                    arrayList2.add(next);
                }
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        if (arrayList2.size() > 0) {
            return arrayList2;
        }
        return null;
    }

    public void e(Context context, View view, Activity activity, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1211036088")) {
            ipChange.ipc$dispatch("-1211036088", new Object[]{this, context, view, activity, str, str2, str3});
            return;
        }
        new ArrayList();
        List<ResolveInfo> d = d();
        if (d == null) {
            ToastUtil.i(context.getString(R$string.ticklet_nomapapp_tips));
        } else if (d.isEmpty()) {
        } else {
            TickletVenueMapChooseView tickletVenueMapChooseView = new TickletVenueMapChooseView(context);
            TickletAnimWindow tickletAnimWindow = new TickletAnimWindow(context, view, tickletVenueMapChooseView, activity);
            tickletVenueMapChooseView.initData(d, new C9099a(context, str, str2, str3, tickletAnimWindow));
            tickletAnimWindow.show();
        }
    }
}
