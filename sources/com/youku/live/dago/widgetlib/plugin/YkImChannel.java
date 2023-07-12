package com.youku.live.dago.widgetlib.plugin;

import android.app.Activity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.utils.ViewUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.im.IImChannel;
import com.youku.live.dsl.im.RedPointCallBack;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.impl.BasePlugin;
import com.youku.live.widgets.protocol.IEngineInstance;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YkImChannel extends BasePlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DATA_CENTER_EVENT_KEY = "EVENT_PRIVATE_CHAT_RED_POINT";
    private static final String TAG = "YkImChannel";
    private IEngineInstance mEngineInstance;
    private IImChannel mImChannelImp;
    private RedPointCallBack mRedPointCallBack = new RedPointCallBack() { // from class: com.youku.live.dago.widgetlib.plugin.YkImChannel.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.live.dsl.im.RedPointCallBack
        public void onRedPointStateChanged(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1919559879")) {
                ipChange.ipc$dispatch("-1919559879", new Object[]{this, Boolean.valueOf(z)});
            } else if (YkImChannel.this.mEngineInstance != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("hasRedPoint", Boolean.valueOf(z));
                YkImChannel.this.mEngineInstance.putData(YkImChannel.DATA_CENTER_EVENT_KEY, hashMap);
            }
        }
    };

    @Override // com.youku.live.widgets.impl.BasePlugin
    public void bindEngineInstance(IEngineInstance iEngineInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969912402")) {
            ipChange.ipc$dispatch("-1969912402", new Object[]{this, iEngineInstance});
        } else {
            super.bindEngineInstance(iEngineInstance);
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-180908117")) {
            ipChange.ipc$dispatch("-180908117", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "YkImChannel didDisappear");
        IImChannel iImChannel = this.mImChannelImp;
        if (iImChannel == null) {
            return;
        }
        iImChannel.unRegisterListener();
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101020456")) {
            ipChange.ipc$dispatch("1101020456", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "YkImChannel willAppear");
        IEngineInstance engineInstance = getEngineInstance();
        this.mEngineInstance = engineInstance;
        if (engineInstance == null || (activity = ViewUtils.getActivity(engineInstance.getContext())) == null) {
            return;
        }
        IImChannel iImChannel = (IImChannel) Dsl.getService(IImChannel.class);
        this.mImChannelImp = iImChannel;
        if (iImChannel == null) {
            return;
        }
        iImChannel.registerListener(activity, this.mRedPointCallBack);
    }
}
