package com.taobao.weex.devtools.adapter;

import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.open.core.util.ParamsConstants;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.weex.RenderContainer;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.ITracingAdapter;
import com.taobao.weex.common.WXPerformance;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.debug.WXDebugBridge;
import com.taobao.weex.devtools.toolbox.PerformanceActivity;
import com.taobao.weex.devtools.trace.DomTracker;
import com.taobao.weex.devtools.trace.HealthReport;
import com.taobao.weex.utils.WXLogUtils;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.m80;
import tb.wz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXTracingAdapter implements ITracingAdapter {
    private volatile SparseArray<wz2.C9890a> traceEvents = new SparseArray<>();

    public WXTracingAdapter() {
        WXSDKManager.v().Q(new WXSDKManager.InstanceLifeCycleCallbacks() { // from class: com.taobao.weex.devtools.adapter.WXTracingAdapter.1
            @Override // com.taobao.weex.WXSDKManager.InstanceLifeCycleCallbacks
            public void onInstanceCreated(String str) {
            }

            @Override // com.taobao.weex.WXSDKManager.InstanceLifeCycleCallbacks
            public void onInstanceDestroyed(String str) {
                if (WXTracingAdapter.this.traceEvents != null) {
                    WXLogUtils.d("WXTracingAdapter", "Destroy trace events with instance id " + str);
                    WXTracingAdapter.this.traceEvents.remove(Integer.parseInt(str));
                }
            }
        });
    }

    private void collectNativeTracingData(wz2.C9890a c9890a, JSONArray jSONArray) {
        if (c9890a.m != null) {
            for (int i = 0; i < c9890a.m.size(); i++) {
                wz2.C9890a valueAt = c9890a.m.valueAt(i);
                if (!valueAt.p) {
                    "domBatch".equals(valueAt.a);
                    JSONObject parseToJSONObject = parseToJSONObject(valueAt);
                    if ("JSThread".equals(valueAt.b)) {
                        try {
                            parseToJSONObject.put("duration", valueAt.o);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    jSONArray.put(parseToJSONObject);
                    collectNativeTracingData(valueAt, jSONArray);
                }
            }
        }
    }

    private void enableMonitor(final String str) {
        final WXSDKInstance y = WXSDKManager.v().y(str);
        if (y != null) {
            TextView textView = new TextView(y.getUIContext());
            textView.setText("Weex MNT:" + str);
            textView.setBackgroundColor(Color.parseColor("#AA1E90FF"));
            textView.setTextColor(-1);
            textView.setPadding(10, 10, 10, 10);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            textView.setLayoutParams(layoutParams);
            ((RenderContainer) y.getContainerView()).addView(textView);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.taobao.weex.devtools.adapter.WXTracingAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PerformanceActivity.start(y.getUIContext(), Integer.parseInt(str));
                }
            });
        }
    }

    private JSONObject parseToJSONObject(wz2.C9890a c9890a) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("parentId", c9890a.k);
            jSONObject.put("ref", c9890a.g);
            jSONObject.put("parentRef", c9890a.h);
            jSONObject.put(PushClientConstants.TAG_CLASS_NAME, c9890a.j);
            jSONObject.put("ts", c9890a.e);
            jSONObject.put(ParamsConstants.Key.PARAM_TRACE_ID, c9890a.d);
            jSONObject.put("iid", c9890a.f);
            jSONObject.put("duration", c9890a.l);
            jSONObject.put("fName", c9890a.a);
            jSONObject.put("ph", c9890a.c);
            jSONObject.put("name", c9890a.i);
            jSONObject.put("tName", c9890a.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSummaryInfo(String str) {
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y != null) {
            WXPerformance wXPerformance = y.getWXPerformance();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("platform", "Android");
                jSONObject.put("JSTemplateSize", wXPerformance.JSTemplateSize);
                jSONObject.put("screenRenderTime", wXPerformance.screenRenderTime);
                jSONObject.put(ImageStatistics.KEY_TOTAL_TIME, wXPerformance.totalTime);
                jSONObject.put("networkTime", wXPerformance.networkTime);
                HealthReport traverse = new DomTracker(y).traverse();
                if (traverse != null) {
                    jSONObject.put("maxDeepViewLayer", traverse.maxLayer);
                    jSONObject.put("componentCount", traverse.componentCount);
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("summaryInfo", jSONObject);
                jSONObject2.put("method", "WxDebug.sendSummaryInfo");
                jSONObject2.put("params", jSONObject3);
                LogUtil.d("SummaryInfo", jSONObject.toString());
                WXDebugBridge.getInstance().sendToRemote(jSONObject2.toString());
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        WXLogUtils.e("WXTracing", "Instance " + str + " not found");
    }

    private void sendTracingData(final String str) {
        if (!WXDebugBridge.getInstance().isSessionActive()) {
            WXLogUtils.w("WXTracingAdapter", "Debug session not active");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        collectNativeTracingData(this.traceEvents.get(Integer.parseInt(str)), jSONArray);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONArray);
            jSONObject.put("method", "WxDebug.sendTracingData");
            jSONObject.put("params", jSONObject2);
            WXDebugBridge.getInstance().sendToRemote(jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WXDebugBridge.getInstance().post(new Runnable() { // from class: com.taobao.weex.devtools.adapter.WXTracingAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                WXTracingAdapter.this.sendSummaryInfo(String.valueOf(str));
            }
        });
        WXLogUtils.d("WXTracingAdapter", "Send tracing data with instance id " + str);
    }

    @Override // com.taobao.weex.adapter.ITracingAdapter
    public void disable() {
    }

    @Override // com.taobao.weex.adapter.ITracingAdapter
    public void enable() {
    }

    public wz2.C9890a getTraceEventByInstanceId(int i) {
        return this.traceEvents.get(i);
    }

    @Override // com.taobao.weex.adapter.ITracingAdapter
    public void submitTracingEvent(wz2.C9890a c9890a) {
        int parseInt = Integer.parseInt(c9890a.f);
        if (parseInt == -1) {
            WXLogUtils.e("Wrong instance id: " + parseInt);
        }
        wz2.C9890a c9890a2 = this.traceEvents.get(parseInt);
        if (c9890a2 == null) {
            c9890a2 = new wz2.C9890a();
            c9890a2.d = parseInt;
            c9890a2.e = c9890a.e;
            c9890a2.m = new SparseArray<>();
            c9890a2.q = new HashMap();
            this.traceEvents.append(parseInt, c9890a2);
        }
        if ("renderFinish".equals(c9890a.a)) {
            c9890a2.l = c9890a.l;
            SparseArray<wz2.C9890a> sparseArray = c9890a2.m;
            if (sparseArray != null) {
                c9890a.l = 0.0d;
                sparseArray.append(c9890a.d, c9890a);
                sendTracingData(c9890a.f);
                return;
            }
            return;
        }
        int i = c9890a.k;
        if (i == -1) {
            if (c9890a2.m == null) {
                c9890a2.m = new SparseArray<>();
            }
            if (!"B".equals(c9890a.c) && !"X".equals(c9890a.c)) {
                if (ExifInterface.LONGITUDE_EAST.equals(c9890a.c)) {
                    wz2.C9890a c9890a3 = c9890a2.m.get(c9890a.d);
                    if (c9890a3 == null) {
                        WXLogUtils.w("WXTracingAdapter", "begin event not found: " + c9890a.a + m80.DINAMIC_PREFIX_AT + c9890a.d);
                        return;
                    }
                    c9890a3.l = c9890a.e - c9890a3.e;
                    c9890a3.c = "X";
                    return;
                }
                return;
            }
            c9890a2.m.append(c9890a.d, c9890a);
            return;
        }
        wz2.C9890a c9890a4 = c9890a2.m.get(i);
        if (c9890a4 != null) {
            if (c9890a4.m == null) {
                c9890a4.m = new SparseArray<>();
            }
            c9890a4.m.append(c9890a.d, c9890a);
        }
    }
}
