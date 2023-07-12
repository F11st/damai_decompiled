package com.alibaba.poplayer.factory.view.base;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.R$drawable;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.InternalTriggerController;
import com.alibaba.poplayer.trigger.view.TrackingService;
import com.alibaba.poplayer.trigger.view.ViewConfigItem;
import com.alibaba.poplayer.trigger.view.ViewEvent;
import com.alibaba.poplayer.trigger.view.d;
import com.alibaba.poplayer.utils.ConsoleLogger$Level;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.dt1;
import tb.et1;
import tb.fw2;
import tb.t01;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class PopLayerBaseView<InnerView, Request extends PopRequest> extends PenetrateFrame {
    protected ImageView mBtnClose;
    protected OnEventListener mEventListener;
    protected InnerView mInnerView;
    protected List<TrackingService.i> mLaunchedTasks;
    protected Request mPopRequest;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnEventListener {
        void onPopLayerViewDisplayed();

        void onPopLayerViewRemoved();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PopLayer.getReference().removeRequest(PopLayerBaseView.this.mPopRequest);
        }
    }

    public PopLayerBaseView(Context context) {
        super(context);
    }

    public final void cancelAllTasks() {
        if (this.mLaunchedTasks == null) {
            return;
        }
        managerSelectTask("", TrackingService.TASK_OPER_REMOVE_ALL_LAUNCHED);
        this.mLaunchedTasks.clear();
    }

    public void close() {
        PopLayer.getReference().removeRequest(getPopRequest());
        dt1.b("PopLayerWVPlugin.jsClose.success", new Object[0]);
    }

    public final void consoleLog(String str, ConsoleLogger$Level consoleLogger$Level) {
        dt1.b(String.format("%s.%s.%s", "Console", Character.valueOf(consoleLogger$Level.sign), str), new Object[0]);
    }

    @Override // com.alibaba.poplayer.factory.view.base.PenetrateFrame
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    public void destroyView() {
        cancelAllTasks();
        PopLayer reference = PopLayer.getReference();
        if (reference != null) {
            reference.internalNotifyDismissedIfPopLayerView(this);
        }
        OnEventListener onEventListener = this.mEventListener;
        if (onEventListener != null) {
            synchronized (onEventListener) {
                this.mEventListener.onPopLayerViewRemoved();
            }
        }
    }

    public void displayMe() {
        setVisibility(0);
        onReceiveEvent("PopLayer.Displayed", null);
        PopLayer reference = PopLayer.getReference();
        if (reference != null) {
            reference.internalNotifyDisplayedIfPopLayerView(this);
        }
        OnEventListener onEventListener = this.mEventListener;
        if (onEventListener != null) {
            synchronized (onEventListener) {
                this.mEventListener.onPopLayerViewDisplayed();
            }
        }
        dt1.b("PopLayerView.displayMe.success", new Object[0]);
    }

    public final void fireEventToMasterIfExist(String str, String str2) {
        View g;
        dt1.b("PopLayerBaseView.fireEventToMasterIfExist.{eventName:%s,params:%s}", str2, str2);
        if (getPopRequest() != null && (g = getPopRequest().g()) != null && (g instanceof PopLayerBaseView)) {
            try {
                String attachInfo = getAttachInfo("groupId");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("groupId", attachInfo);
                jSONObject.put("eventName", str);
                jSONObject.put("params", str2);
                ((PopLayerBaseView) g).onReceiveEvent(PopLayer.ACTION_NOTIFY_TRACKS_NAME, jSONObject.toString());
                return;
            } catch (Throwable th) {
                dt1.c("PopLayerBaseView.fireEventToMasterIfExist.err.", th);
                return;
            }
        }
        dt1.b("PopLayerBaseView.fireEventToMasterIfExist.Cann't find out masterView.", new Object[0]);
    }

    public final void fireEventToTracks(String str, String str2, String str3) {
        dt1.b("PopLayerBaseView.fireEventToTracks:{eventName:%s,params:%s},", str2, str3);
        Iterator<PopRequest> it = d.M().K(this, str, InternalTriggerController.b((Activity) getContext())).iterator();
        while (it.hasNext()) {
            PopRequest next = it.next();
            if (next.i() == PopRequest.Status.SHOWING) {
                View e = next.e();
                if (e != null && (e instanceof PopLayerBaseView)) {
                    ((PopLayerBaseView) e).onReceiveEvent(str2, str3);
                }
            } else {
                dt1.b("Drop useless event for request:{%s}", next.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getAttachInfo(String str) {
        return d.M().I(getPopRequest(), str);
    }

    public SpannableStringBuilder getInfo() {
        return new SpannableStringBuilder("simpleInfo");
    }

    public Request getPopRequest() {
        return this.mPopRequest;
    }

    public void increaseReadTimes(String str) {
        et1.d(str);
    }

    public abstract void init(Context context, Request request) throws JSONException;

    public final void launchSelectTask(ViewEvent viewEvent, ViewConfigItem viewConfigItem, String str, String str2) {
        if (this.mLaunchedTasks == null) {
            this.mLaunchedTasks = new ArrayList();
        }
        if (getContext() == null) {
            dt1.b("PopLayerBaseView.launchSelectTask error. context is empty.", new Object[0]);
            return;
        }
        TrackingService.i E = d.M().E((Activity) getContext(), viewEvent, viewConfigItem, this, str, str2);
        if (E != null) {
            this.mLaunchedTasks.add(E);
        }
    }

    public final void managerSelectTask(String str, String str2) {
        dt1.b("PopLayerBaseView.managerSelectTask: taskHandle:{%s},operation:{%s}.", str, str2);
        d.M().N((Activity) getContext(), this, str, str2, null, null);
    }

    public void navToUrl(String str) {
        PopLayer reference = PopLayer.getReference();
        if (reference == null) {
            dt1.a("PopLayerWVPlugin.jsNavToUrl.return.nullPopLayer");
        } else {
            reference.getFaceAdapter().navToUrl(getContext(), str);
        }
    }

    public void onActivityPaused() {
    }

    public void onActivityResumed() {
    }

    @Override // com.alibaba.poplayer.factory.view.base.PenetrateFrame, android.view.ViewGroup
    public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onReceiveEvent(String str, String str2) {
        dt1.b("PopLayerBaseView.onReceiveEvent:{eventName:%s,params:%s},You should overwrite this method to hold event.", str, str2);
    }

    public void onViewAdded(Context context) {
        dt1.b("PopLayerBaseView.onViewAdded.", new Object[0]);
        onReceiveEvent("PopLayer.onViewAdded", null);
    }

    public void onViewRemoved(Context context) {
        dt1.b("PopLayerBaseView.onViewRemoved.", new Object[0]);
        onReceiveEvent("PopLayer.onViewRemoved", null);
    }

    public void selectAndOperate(JSONObject jSONObject) throws JSONException {
        ViewEvent viewEvent;
        JSONArray optJSONArray = jSONObject.optJSONArray("mainParams");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        int i = 0;
        while (i < length) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            String optString = jSONObject2.optString("selector", "");
            String optString2 = jSONObject2.optString("groupId", "");
            String optString3 = jSONObject2.optString("taskHandle", optString);
            boolean optBoolean = jSONObject2.optBoolean("selectFromCache", true);
            boolean optBoolean2 = jSONObject2.optBoolean("continuousSelect", true);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("operation");
            String optString4 = jSONObject3.optString("name", TrackingService.OPER_TRACK);
            JSONArray jSONArray = optJSONArray;
            ViewEvent viewEvent2 = new ViewEvent(3, optString, "", InternalTriggerController.b((Activity) getContext()), 3);
            ViewConfigItem viewConfigItem = new ViewConfigItem();
            viewConfigItem.viewuri = optString;
            viewConfigItem.continuousSelect = optBoolean2;
            viewConfigItem.operationName = optString4;
            viewConfigItem.selectFromCache = optBoolean;
            Request request = this.mPopRequest;
            if (request == null || !(request instanceof t01) || ((t01) request).r() == null) {
                viewConfigItem.uuid = "trackMode" + SystemClock.currentThreadTimeMillis();
            } else {
                viewConfigItem.uuid = "trackMode" + ((t01) this.mPopRequest).r().uuid + optString3;
            }
            BaseConfigItem.a aVar = new BaseConfigItem.a();
            viewConfigItem.pageInfo = aVar;
            aVar.a = jSONObject2.optString("uri", null);
            viewConfigItem.pageInfo.c = jSONObject2.optString("paramContains", null);
            JSONObject optJSONObject = jSONObject3.optJSONObject("params");
            int i2 = length;
            int i3 = i;
            viewConfigItem.modalThreshold = jSONObject2.optDouble("modalThreshold", 0.8d);
            if (optJSONObject != null) {
                viewConfigItem.params = optJSONObject.toString();
                viewConfigItem.modalThreshold = optJSONObject.optDouble("modalThreshold", 0.8d);
            }
            if (TrackingService.OPER_TRACK.equals(optString4)) {
                viewConfigItem.type = viewConfigItem.params != null ? jSONObject3.optJSONObject("params").optString("type") : "badType";
                viewEvent = viewEvent2;
            } else {
                if (TrackingService.OPER_MIRROR.equals(optString4)) {
                    if (jSONObject3.optBoolean("realTime", false)) {
                        viewConfigItem.params = viewConfigItem.params != null ? viewConfigItem.params + "realTime" : "realTime";
                    }
                }
                viewEvent = viewEvent2;
            }
            launchSelectTask(viewEvent, viewConfigItem, optString3, optString2);
            i = i3 + 1;
            length = i2;
            optJSONArray = jSONArray;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("taskParams");
        int length2 = optJSONArray2 == null ? 0 : optJSONArray2.length();
        for (int i4 = 0; i4 < length2; i4++) {
            JSONObject jSONObject4 = optJSONArray2.getJSONObject(i4);
            managerSelectTask(jSONObject4.getString("taskHandle"), jSONObject4.getString(PopLayer.ACTION_TRACK_INFO_KEY_OPERATION_NAME));
        }
    }

    public void setEventListener(OnEventListener onEventListener) {
        this.mEventListener = onEventListener;
    }

    public void setPopRequest(Request request) {
        this.mPopRequest = request;
    }

    @Override // com.alibaba.poplayer.factory.view.base.PenetrateFrame
    public /* bridge */ /* synthetic */ void setUseCacheMark(boolean z) {
        super.setUseCacheMark(z);
    }

    public void showCloseButton(boolean z) {
        if (!z && this.mBtnClose == null) {
            dt1.b("Not use closeButton.", Boolean.valueOf(z));
            return;
        }
        int i = z ? 0 : 8;
        if (this.mBtnClose == null) {
            ImageView imageView = new ImageView(getContext());
            this.mBtnClose = imageView;
            imageView.setBackgroundResource(R$drawable.poplayer_close_btn);
            this.mBtnClose.setOnClickListener(new a());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(80, 80);
            layoutParams.rightMargin = fw2.a(getContext(), 20);
            layoutParams.topMargin = fw2.a(getContext(), 20);
            layoutParams.gravity = 53;
            addView(this.mBtnClose, layoutParams);
        }
        this.mBtnClose.setVisibility(i);
        dt1.b("PopLayerWebView.showCloseButton.show{%s}", Boolean.valueOf(z));
    }
}
