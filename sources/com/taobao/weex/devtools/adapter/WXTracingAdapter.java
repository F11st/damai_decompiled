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
    private volatile SparseArray<wz2.a> traceEvents = new SparseArray<>();

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

    private void collectNativeTracingData(wz2.a aVar, JSONArray jSONArray) {
        if (aVar.m != null) {
            for (int i = 0; i < aVar.m.size(); i++) {
                wz2.a valueAt = aVar.m.valueAt(i);
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

    private JSONObject parseToJSONObject(wz2.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("parentId", aVar.k);
            jSONObject.put("ref", aVar.g);
            jSONObject.put("parentRef", aVar.h);
            jSONObject.put(PushClientConstants.TAG_CLASS_NAME, aVar.j);
            jSONObject.put("ts", aVar.e);
            jSONObject.put(ParamsConstants.Key.PARAM_TRACE_ID, aVar.d);
            jSONObject.put("iid", aVar.f);
            jSONObject.put("duration", aVar.l);
            jSONObject.put("fName", aVar.a);
            jSONObject.put("ph", aVar.c);
            jSONObject.put("name", aVar.i);
            jSONObject.put("tName", aVar.b);
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

    public wz2.a getTraceEventByInstanceId(int i) {
        return this.traceEvents.get(i);
    }

    @Override // com.taobao.weex.adapter.ITracingAdapter
    public void submitTracingEvent(wz2.a aVar) {
        int parseInt = Integer.parseInt(aVar.f);
        if (parseInt == -1) {
            WXLogUtils.e("Wrong instance id: " + parseInt);
        }
        wz2.a aVar2 = this.traceEvents.get(parseInt);
        if (aVar2 == null) {
            aVar2 = new wz2.a();
            aVar2.d = parseInt;
            aVar2.e = aVar.e;
            aVar2.m = new SparseArray<>();
            aVar2.q = new HashMap();
            this.traceEvents.append(parseInt, aVar2);
        }
        if ("renderFinish".equals(aVar.a)) {
            aVar2.l = aVar.l;
            SparseArray<wz2.a> sparseArray = aVar2.m;
            if (sparseArray != null) {
                aVar.l = 0.0d;
                sparseArray.append(aVar.d, aVar);
                sendTracingData(aVar.f);
                return;
            }
            return;
        }
        int i = aVar.k;
        if (i == -1) {
            if (aVar2.m == null) {
                aVar2.m = new SparseArray<>();
            }
            if (!"B".equals(aVar.c) && !"X".equals(aVar.c)) {
                if (ExifInterface.LONGITUDE_EAST.equals(aVar.c)) {
                    wz2.a aVar3 = aVar2.m.get(aVar.d);
                    if (aVar3 == null) {
                        WXLogUtils.w("WXTracingAdapter", "begin event not found: " + aVar.a + m80.DINAMIC_PREFIX_AT + aVar.d);
                        return;
                    }
                    aVar3.l = aVar.e - aVar3.e;
                    aVar3.c = "X";
                    return;
                }
                return;
            }
            aVar2.m.append(aVar.d, aVar);
            return;
        }
        wz2.a aVar4 = aVar2.m.get(i);
        if (aVar4 != null) {
            if (aVar4.m == null) {
                aVar4.m = new SparseArray<>();
            }
            aVar4.m.append(aVar.d, aVar);
        }
    }
}
