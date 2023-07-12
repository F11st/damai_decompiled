package com.alibaba.aliweex.adapter.adapter;

import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.aliweex.C3004a;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.module.WXPerformanceModule;
import com.taobao.monitor.performance.IWXApmAdapter;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.performance.IWXApmMonitorAdapter;
import com.taobao.weex.performance.WXInstanceApm;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.C8890a0;
import tb.gn1;
import tb.k4;
import tb.oz2;
import tb.xz2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXAPMAdapter implements IWXApmMonitorAdapter {
    private static int f = -2;
    private static boolean g = true;
    public static boolean h;
    public String a;
    private IWXApmAdapter b;
    private TextView c;
    private Map<String, Double> d = new ConcurrentHashMap();
    private String e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.adapter.WXAPMAdapter$a */
    /* loaded from: classes15.dex */
    public class C3008a {
        String a;
        long b;
        long c;
        long d;

        private C3008a(WXAPMAdapter wXAPMAdapter) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject b() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("stageName", this.a);
            jSONObject.put("beginTime", this.c);
            jSONObject.put("endTime", this.d);
            jSONObject.put("cost", this.b);
            return jSONObject;
        }
    }

    private C3008a d(String str, String str2, String str3) {
        WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(this.a);
        if (wXSDKInstance == null) {
            return null;
        }
        C3008a c3008a = new C3008a();
        c3008a.a = str;
        Long l = wXSDKInstance.getApmForInstance().d.get(str3);
        Long l2 = wXSDKInstance.getApmForInstance().d.get(str2);
        c3008a.c = l2 == null ? -1L : l2.longValue();
        long longValue = l != null ? l.longValue() : -1L;
        c3008a.d = longValue;
        c3008a.b = longValue - c3008a.c;
        return c3008a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        if (WXSDKManager.v().i().get(this.a) == null) {
            return "";
        }
        C3008a d = d("downLoad", WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_START, WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_END);
        C3008a d2 = d("interactive", WXInstanceApm.KEY_PAGE_STAGES_RENDER_ORGIGIN, WXInstanceApm.KEY_PAGE_STAGES_INTERACTION);
        C3008a d3 = d(WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE, WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END, WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE);
        StringBuilder sb = new StringBuilder();
        sb.append("dowlnLoad:");
        sb.append(d == null ? "" : Long.valueOf(d.b));
        sb.append("\n evalJsBundle:");
        sb.append(d3 == null ? "" : Long.valueOf(d3.b));
        sb.append("\n interaction:");
        sb.append(d2 != null ? Long.valueOf(d2.b) : "");
        return sb.toString();
    }

    private void f() {
        IConfigAdapter c = C3004a.l().c();
        if (c != null && Boolean.valueOf(c.getConfig(oz2.WXAPM_CONFIG_GROUP, "collectDeviceLevel", "true")).booleanValue()) {
            if (f == -2) {
                if (g) {
                    try {
                        k4.C9333e f2 = k4.d().f();
                        f = f2 == null ? -1 : f2.a;
                    } catch (Throwable unused) {
                        g = false;
                        f = -1;
                    }
                } else {
                    f = -1;
                }
            }
            addProperty("wxDeviceLevel", Integer.valueOf(f + 1));
        }
    }

    private void g() {
        WXSDKInstance wXSDKInstance;
        if (h && (wXSDKInstance = WXSDKManager.v().i().get(this.a)) != null) {
            final View containerView = wXSDKInstance.getContainerView();
            if (containerView instanceof FrameLayout) {
                containerView.post(new Runnable() { // from class: com.alibaba.aliweex.adapter.adapter.WXAPMAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FrameLayout frameLayout = (FrameLayout) containerView;
                        if (WXAPMAdapter.this.c == null) {
                            WXAPMAdapter.this.c = new TextView(frameLayout.getContext());
                            WXAPMAdapter.this.c.setClickable(false);
                            WXAPMAdapter.this.c.setFocusable(false);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 21;
                            WXAPMAdapter.this.c.setLayoutParams(layoutParams);
                            frameLayout.addView(WXAPMAdapter.this.c);
                        }
                        WXAPMAdapter.this.c.setText(WXAPMAdapter.this.e());
                        WXAPMAdapter.this.c.setTextSize(10.0f);
                        if (frameLayout.getChildAt(frameLayout.getChildCount() - 1) != WXAPMAdapter.this.c) {
                            ViewParent parent = WXAPMAdapter.this.c.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(WXAPMAdapter.this.c);
                            }
                            frameLayout.addView(WXAPMAdapter.this.c);
                        }
                    }
                });
            }
        }
    }

    private void h() {
        try {
            BufferedWriter bufferedWriter = null;
            File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
            if (externalStorageDirectory != null) {
                File absoluteFile = externalStorageDirectory.getAbsoluteFile();
                externalStorageDirectory = new File(absoluteFile, WXEnvironment.getApplication().getPackageName() + "/APM_ONLINE");
            }
            if (externalStorageDirectory == null || !externalStorageDirectory.exists()) {
                externalStorageDirectory.createNewFile();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", gn1.TYPE_OPEN_URL_WEEX);
            jSONObject.put("url", this.e);
            jSONObject.put("pageName", this.e);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("stages", jSONArray);
            C3008a d = d("downLoad", WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_START, WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_END);
            if (d != null) {
                jSONArray.put(d.b());
            }
            C3008a d2 = d("prePareBundle", WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_START, WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
            if (d2 != null) {
                jSONArray.put(d2.b());
            }
            C3008a d3 = d("evalJsBundle", WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END, WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE);
            if (d3 != null) {
                jSONArray.put(d3.b());
            }
            C3008a d4 = d("interactive", WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE, WXInstanceApm.KEY_PAGE_STAGES_INTERACTION);
            if (d4 != null && d4.b > 0) {
                jSONArray.put(d4.b());
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("extra", jSONObject2);
            C3008a d5 = d("mtopRequest", WXPerformanceModule.KEY_STAGE_JS_ASYNC_DATA_START, WXPerformanceModule.KEY_STAGE_JS_ASYNC_DATA_END);
            if (d5 != null) {
                jSONObject2.put("mtopRequest", d5.b());
            }
            try {
                jSONObject2.put(WXInstanceApm.KEY_PAGE_STATS_LAYOUT_TIME, this.d.get(WXInstanceApm.KEY_PAGE_STATS_LAYOUT_TIME));
                jSONObject2.put(WXInstanceApm.KEY_PAGE_STATS_VIEW_CREATE_COST, this.d.get(WXInstanceApm.KEY_PAGE_STATS_VIEW_CREATE_COST));
                jSONObject2.put(WXInstanceApm.KEY_PAGE_STATS_COMPONENT_CREATE_COST, this.d.get(WXInstanceApm.KEY_PAGE_STATS_COMPONENT_CREATE_COST));
                jSONObject2.put(WXInstanceApm.KEY_PAGE_STATS_EXECUTE_JS_CALLBACK_COST, this.d.get(WXInstanceApm.KEY_PAGE_STATS_EXECUTE_JS_CALLBACK_COST));
                try {
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(externalStorageDirectory, true)));
                        try {
                            bufferedWriter2.write(jSONObject.toString());
                            bufferedWriter2.write(10);
                            bufferedWriter2.close();
                        } catch (Exception e) {
                            e = e;
                            bufferedWriter = bufferedWriter2;
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void addProperty(String str, Object obj) {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.addProperty(str, obj);
        if (h && WXInstanceApm.KEY_PAGE_PROPERTIES_BIZ_ID.equals(str)) {
            this.e = obj.toString();
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void addStats(String str, double d) {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.addStatistic(str, d);
        if (h) {
            this.d.put(str, Double.valueOf(d));
            if (WXInstanceApm.KEY_PAGE_STATS_LAYOUT_TIME.equals(str)) {
                h();
            }
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onAppear() {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.onStart();
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onDisappear() {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.onStop();
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onEnd() {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.onEnd();
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onEvent(String str, Object obj) {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter == null) {
            return;
        }
        iWXApmAdapter.onEvent(str, obj);
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onStage(String str, long j) {
        IWXApmAdapter iWXApmAdapter = this.b;
        if (iWXApmAdapter != null) {
            iWXApmAdapter.onStage(str, j);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("weexInstanceId", TextUtils.isEmpty(this.a) ? "nullId" : this.a);
        if (!TextUtils.isEmpty(this.e)) {
            hashMap.put("mPageName", this.e);
        }
        C3004a.l().s(str, hashMap);
        if (h) {
            g();
        }
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onStart(String str) {
        this.a = str;
        IWXApmAdapter createApmAdapter = C8890a0.a().createApmAdapter();
        this.b = createApmAdapter;
        if (createApmAdapter == null) {
            return;
        }
        createApmAdapter.onStart(str);
        f();
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onSubProcedureEvent(String str, String str2) {
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void onSubProcedureStage(String str, String str2) {
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public String parseReportUrl(String str) {
        String b = xz2.b(str, false);
        return TextUtils.isEmpty(b) ? "emptyParseUrl" : b;
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void setSubProcedureProperties(String str, String str2, Object obj) {
    }

    @Override // com.taobao.weex.performance.IWXApmMonitorAdapter
    public void setSubProcedureStats(String str, String str2, double d) {
    }
}
