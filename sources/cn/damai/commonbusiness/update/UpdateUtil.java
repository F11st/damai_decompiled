package cn.damai.commonbusiness.update;

import android.content.Context;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.R$drawable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.local.C6922a;
import com.taobao.update.framework.UpdateRuntime;
import com.taobao.updatecenter.hotpatch.HotPatchManager;
import java.lang.reflect.Field;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import tb.C9444mm;
import tb.fy1;
import tb.l6;
import tb.mu0;
import tb.r6;
import tb.rr2;
import tb.vq1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class UpdateUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918462999")) {
            ipChange.ipc$dispatch("1918462999", new Object[]{str});
        } else {
            UpdateDataSource.getInstance().addUpdateInfo(str);
        }
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687698540")) {
            ipChange.ipc$dispatch("-687698540", new Object[0]);
            return;
        }
        l6 l6Var = new l6();
        try {
            Field declaredField = DMUpdateManager.g().h().getClass().getDeclaredField("updateLifeCycles");
            declaredField.setAccessible(true);
            ((List) declaredField.get(DMUpdateManager.g().h())).add(l6Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UpdateRuntime.execute(new Runnable() { // from class: cn.damai.commonbusiness.update.UpdateUtil.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "216621517")) {
                    ipChange2.ipc$dispatch("216621517", new Object[]{this});
                } else {
                    UpdateDataSource.getInstance().startUpdate(false, true);
                }
            }
        });
    }

    public static void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1864040782")) {
            ipChange.ipc$dispatch("-1864040782", new Object[0]);
            return;
        }
        l6 l6Var = new l6();
        try {
            Field declaredField = DMUpdateManager.g().h().getClass().getDeclaredField("updateLifeCycles");
            declaredField.setAccessible(true);
            ((List) declaredField.get(DMUpdateManager.g().h())).add(l6Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UpdateRuntime.execute(new Runnable() { // from class: cn.damai.commonbusiness.update.UpdateUtil.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "20108012")) {
                    ipChange2.ipc$dispatch("20108012", new Object[]{this});
                } else {
                    UpdateDataSource.getInstance().startUpdate(true, true);
                }
            }
        });
    }

    public static void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "551755123")) {
            ipChange.ipc$dispatch("551755123", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1620406252")) {
            return (String) ipChange.ipc$dispatch("-1620406252", new Object[]{str});
        }
        JSONObject parseObject = JSON.parseObject(str);
        String string = parseObject.getJSONObject("dynamicdeploy") != null ? parseObject.getJSONObject("dynamicdeploy").getString("url") : null;
        if (string == null) {
            return null;
        }
        try {
            HttpResponse execute = new DefaultHttpClient().execute(new HttpGet(string));
            if (execute.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(execute.getEntity(), "utf-8").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void h(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119608653")) {
            ipChange.ipc$dispatch("-2119608653", new Object[]{context});
            return;
        }
        C6922a.getInstance(context).clearCache();
        UpdateRuntime.execute(new Runnable() { // from class: cn.damai.commonbusiness.update.UpdateUtil.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-176405493")) {
                    ipChange2.ipc$dispatch("-176405493", new Object[]{this});
                } else {
                    UpdateUtil.i();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832573740")) {
            ipChange.ipc$dispatch("832573740", new Object[0]);
            return;
        }
        C9444mm c9444mm = new C9444mm(mu0.a());
        c9444mm.ttid = AppConfig.p();
        c9444mm.group = AppConfig.j();
        c9444mm.appName = AppConfig.j();
        c9444mm.isOutApk = false;
        c9444mm.appName = "大麦";
        c9444mm.logoResourceId = R$drawable.logo;
        c9444mm.popDialogBeforeInstall = true;
        c9444mm.threadExecutorImpl = new r6();
        c9444mm.uiConfirmClass = rr2.class;
        DMUpdateManager.g().i(c9444mm, false);
    }

    public static void j(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234335278")) {
            ipChange.ipc$dispatch("1234335278", new Object[]{str});
        } else {
            new Thread(new Runnable() { // from class: cn.damai.commonbusiness.update.UpdateUtil.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-372918998")) {
                        ipChange2.ipc$dispatch("-372918998", new Object[]{this});
                        return;
                    }
                    try {
                        String str2 = str;
                        if (str2 == null) {
                            return;
                        }
                        if (str2.contains("apatch.json")) {
                            String g = UpdateUtil.g(str);
                            if (g == null) {
                                return;
                            }
                            JSONObject jSONObject = (JSONObject) JSON.parse(g);
                            if (jSONObject.containsKey("data")) {
                                HotPatchManager.getInstance().dealPatchInfo(vq1.a(jSONObject.getJSONObject("data").getJSONObject("hotpatch")), fy1.HOME_SCAN_PAGE, new String[0]);
                                return;
                            }
                            return;
                        }
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject(str);
                        if (jSONObject2.has("dynamicdeploy")) {
                            org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject("dynamicdeploy");
                            if (jSONObject3.has("url")) {
                                UpdateUtil.c(jSONObject3.getString("url"));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
