package com.youku.live.widgets.widgets.weex;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.youku.live.widgets.protocol.IEngineInstance;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WeexWidgetView extends FrameLayout implements IWXRenderListener, WXSDKInstance.OnInstanceVisibleListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String WX_PAGE_APPEAR = "DAGOPageAppear";
    public static final String WX_PAGE_DISAPPEAR = "DAGOPageDisappear";
    public static final String WX_PAGE_FOREGROUND = "DAGOPageForeground";
    public static final String WX_PAGE_KEY = "state";
    public static final String WX_PAGE_STATE_CHANGED = "DAGOPageStateChanged";
    private final String ORIENTATION_LANDSCAPE_LEFT;
    private final String ORIENTATION_LANDSCAPE_RIGHT;
    private final String ORIENTATION_PORTRAIT;
    private final String ORIENTATION_PORTRAIT_UPSIDE_DOWN;
    private String currentAngleORIENTATION;
    private int currentScreenStyle;
    private IEngineInstance mEngineInstance;
    private boolean mInBackground;
    private boolean mLastDisappear;
    private boolean mRenderSuccess;
    private IWXRenderListener mWXRenderListener;
    private WeexInstance mWeexInstance;

    public WeexWidgetView(@NonNull Context context) {
        super(context);
        this.mInBackground = false;
        this.mLastDisappear = false;
        this.ORIENTATION_LANDSCAPE_RIGHT = "landscapeRight";
        this.ORIENTATION_LANDSCAPE_LEFT = "landscapeLeft";
        this.ORIENTATION_PORTRAIT = "portrait";
        this.ORIENTATION_PORTRAIT_UPSIDE_DOWN = "portraitUpsideDown";
        this.currentAngleORIENTATION = "portrait";
        this.currentScreenStyle = 1;
    }

    private void fireGlobalEventImpl(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57449168")) {
            ipChange.ipc$dispatch("-57449168", new Object[]{this, str, map});
            return;
        }
        WeexInstance weexInstance = getWeexInstance();
        if (weexInstance != null) {
            weexInstance.fireGlobalEventCallback(str, map);
        }
    }

    private WeexInstance getWeexInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463823280")) {
            return (WeexInstance) ipChange.ipc$dispatch("-1463823280", new Object[]{this});
        }
        if (this.mWeexInstance == null) {
            synchronized (this) {
                if (this.mWeexInstance == null) {
                    this.mWeexInstance = new WeexInstance();
                }
            }
            setInstanceConfig();
        }
        return this.mWeexInstance;
    }

    private void setInstanceConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1633346413")) {
            ipChange.ipc$dispatch("-1633346413", new Object[]{this});
            return;
        }
        WeexInstance weexInstance = this.mWeexInstance;
        if (weexInstance != null) {
            weexInstance.init(getContext());
            weexInstance.registerRenderListener(this);
            weexInstance.addOnInstanceVisibleListener(this);
            IEngineInstance iEngineInstance = this.mEngineInstance;
            if (iEngineInstance != null) {
                weexInstance.bindEngineInstance(iEngineInstance);
            }
        }
    }

    public void bindEngineInstance(IEngineInstance iEngineInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674519743")) {
            ipChange.ipc$dispatch("1674519743", new Object[]{this, iEngineInstance});
            return;
        }
        this.mEngineInstance = iEngineInstance;
        getWeexInstance().bindEngineInstance(iEngineInstance);
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980619022")) {
            ipChange.ipc$dispatch("-1980619022", new Object[]{this});
            return;
        }
        this.mLastDisappear = true;
        WeexInstance weexInstance = this.mWeexInstance;
        if (weexInstance != null) {
            weexInstance.destroy();
            this.mWeexInstance.removeOnInstanceVisibleListener(this);
            this.mWeexInstance = null;
        }
        removeAllViews();
    }

    public WXSDKInstance getWXSDKInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1104071356") ? (WXSDKInstance) ipChange.ipc$dispatch("-1104071356", new Object[]{this}) : getWeexInstance();
    }

    @Override // com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener
    public void onAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1614055478")) {
            ipChange.ipc$dispatch("-1614055478", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap(16);
        if (this.mInBackground) {
            hashMap.put("state", "DAGOPageForeground");
        } else {
            hashMap.put("state", "DAGOPageAppear");
        }
        this.mInBackground = false;
        fireGlobalEventImpl("DAGOPageStateChanged", hashMap);
    }

    @Override // com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener
    public void onDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654762664")) {
            ipChange.ipc$dispatch("654762664", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap(16);
        if (!this.mLastDisappear) {
            hashMap.put("state", "DAGOPageForeground");
            this.mInBackground = true;
        } else {
            hashMap.put("state", "DAGOPageDisappear");
        }
        fireGlobalEventImpl("DAGOPageStateChanged", hashMap);
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onException(WXSDKInstance wXSDKInstance, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "47475718")) {
            ipChange.ipc$dispatch("47475718", new Object[]{this, wXSDKInstance, str, str2});
            return;
        }
        this.mRenderSuccess = true;
        IWXRenderListener iWXRenderListener = this.mWXRenderListener;
        if (iWXRenderListener != null) {
            iWXRenderListener.onException(wXSDKInstance, str, str2);
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRefreshSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1943439319")) {
            ipChange.ipc$dispatch("1943439319", new Object[]{this, wXSDKInstance, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mRenderSuccess = true;
        IWXRenderListener iWXRenderListener = this.mWXRenderListener;
        if (iWXRenderListener != null) {
            iWXRenderListener.onRefreshSuccess(wXSDKInstance, i, i2);
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRenderSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989932784")) {
            ipChange.ipc$dispatch("-1989932784", new Object[]{this, wXSDKInstance, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mRenderSuccess = true;
        IWXRenderListener iWXRenderListener = this.mWXRenderListener;
        if (iWXRenderListener != null) {
            iWXRenderListener.onRenderSuccess(wXSDKInstance, i, i2);
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onViewCreated(WXSDKInstance wXSDKInstance, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898904980")) {
            ipChange.ipc$dispatch("-1898904980", new Object[]{this, wXSDKInstance, view});
            return;
        }
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        IWXRenderListener iWXRenderListener = this.mWXRenderListener;
        if (iWXRenderListener != null) {
            iWXRenderListener.onViewCreated(wXSDKInstance, view);
        }
    }

    public void render(String str, Map<String, Object> map, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2015049469")) {
            ipChange.ipc$dispatch("2015049469", new Object[]{this, str, map, str2});
        } else if (this.mRenderSuccess) {
            getWeexInstance().refreshInstance(map);
        } else {
            getWeexInstance().renderByUrl(str, str, map, str2, WXRenderStrategy.APPEND_ASYNC);
        }
    }

    public void setRenderListener(IWXRenderListener iWXRenderListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040164344")) {
            ipChange.ipc$dispatch("-2040164344", new Object[]{this, iWXRenderListener});
        } else {
            this.mWXRenderListener = iWXRenderListener;
        }
    }

    public void setScreenType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-187145121")) {
            ipChange.ipc$dispatch("-187145121", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.currentAngleORIENTATION == null) {
            this.currentAngleORIENTATION = i == 1 ? "portrait" : "landscapeLeft";
        }
        HashMap hashMap = new HashMap();
        if (i == 1) {
            if (!this.currentAngleORIENTATION.equals("portrait") && !this.currentAngleORIENTATION.equals("portraitUpsideDown")) {
                this.currentAngleORIENTATION = "portrait";
                hashMap.put("orientation", "portrait");
            } else {
                hashMap.put("orientation", this.currentAngleORIENTATION);
            }
        } else if (!this.currentAngleORIENTATION.equals("landscapeRight") && !this.currentAngleORIENTATION.equals("landscapeLeft")) {
            this.currentAngleORIENTATION = "landscapeLeft";
            hashMap.put("orientation", "landscapeLeft");
        } else {
            hashMap.put("orientation", this.currentAngleORIENTATION);
        }
        fireGlobalEventImpl("DAGOOrientationChange", hashMap);
    }

    public WeexWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInBackground = false;
        this.mLastDisappear = false;
        this.ORIENTATION_LANDSCAPE_RIGHT = "landscapeRight";
        this.ORIENTATION_LANDSCAPE_LEFT = "landscapeLeft";
        this.ORIENTATION_PORTRAIT = "portrait";
        this.ORIENTATION_PORTRAIT_UPSIDE_DOWN = "portraitUpsideDown";
        this.currentAngleORIENTATION = "portrait";
        this.currentScreenStyle = 1;
    }

    public WeexWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInBackground = false;
        this.mLastDisappear = false;
        this.ORIENTATION_LANDSCAPE_RIGHT = "landscapeRight";
        this.ORIENTATION_LANDSCAPE_LEFT = "landscapeLeft";
        this.ORIENTATION_PORTRAIT = "portrait";
        this.ORIENTATION_PORTRAIT_UPSIDE_DOWN = "portraitUpsideDown";
        this.currentAngleORIENTATION = "portrait";
        this.currentScreenStyle = 1;
    }
}
