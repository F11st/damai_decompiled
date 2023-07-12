package com.ut.mini.behavior;

import com.alibaba.analytics.utils.Logger;
import com.uc.webview.export.extension.UCCore;
import com.ut.mini.UTEvent;
import com.ut.mini.UTEventTracker;
import com.ut.mini.UTTracker;
import com.ut.mini.behavior.config.UTBehaviorConfigMgr;
import com.ut.mini.behavior.module.ModulesMgr;
import com.ut.mini.module.plugin.UTPlugin;
import com.ut.mini.module.plugin.UTPluginMgr;
import com.ut.mini.module.trackerlistener.UTTrackerListener;
import com.ut.mini.module.trackerlistener.UTTrackerListenerMgr;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTBehavior {
    private static final String UT_MODULE = "UTModule";
    private static final String UT_TRIGGER = "UTTrigger";
    private static boolean bInit;

    public static synchronized void init() {
        synchronized (UTBehavior.class) {
            if (bInit) {
                return;
            }
            bInit = true;
            Logger.f("UTBehavior", UCCore.LEGACY_EVENT_INIT);
            UTBehaviorConfigMgr.initConfig();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ModulesMgr.UT_TAG);
            final int[] iArr = {-1};
            UTPluginMgr.getInstance().registerPlugin(new UTPlugin() { // from class: com.ut.mini.behavior.UTBehavior.1
                @Override // com.ut.mini.module.plugin.UTPlugin
                public int[] getAttentionEventIds() {
                    return iArr;
                }

                @Override // com.ut.mini.module.plugin.UTPlugin
                public String getPluginName() {
                    return UTBehavior.UT_MODULE;
                }

                @Override // com.ut.mini.module.plugin.UTPlugin
                public Map<String, String> onEventDispatch(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
                    try {
                        return ModulesMgr.getInstance().makeTag(map);
                    } catch (Exception unused) {
                        return null;
                    }
                }
            }, false, arrayList, null);
            UTPluginMgr.getInstance().registerPlugin(new UTPlugin() { // from class: com.ut.mini.behavior.UTBehavior.2
                @Override // com.ut.mini.module.plugin.UTPlugin
                public int[] getAttentionEventIds() {
                    return iArr;
                }

                @Override // com.ut.mini.module.plugin.UTPlugin
                public String getPluginName() {
                    return UTBehavior.UT_TRIGGER;
                }

                @Override // com.ut.mini.module.plugin.UTPlugin
                public Map<String, String> onEventDispatch(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
                    try {
                        UTTrigger.getInstance().triggerEventAsync(map);
                        return null;
                    } catch (Exception unused) {
                        return null;
                    }
                }
            }, false, null, null);
            UTTrackerListenerMgr.getInstance().registerListener(new UTTrackerListener() { // from class: com.ut.mini.behavior.UTBehavior.3
                @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
                public void beginEvent(UTEvent uTEvent) {
                    if (uTEvent != null) {
                        UTTrigger.getInstance().triggerEventAsync(uTEvent);
                    }
                }

                @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
                public void endEvent(UTEvent uTEvent) {
                    if (uTEvent == null || uTEvent.getToLog() || !uTEvent.getToTrigger()) {
                        return;
                    }
                    UTTrigger.getInstance().triggerEventAsync(uTEvent);
                }

                @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
                public void pageAppear(UTTracker uTTracker, Object obj, String str, boolean z) {
                    UTEvent eventByKey = UTEventTracker.getInstance().getEventByKey(UTEventTracker.getInstance().getKeyForObject(obj));
                    eventByKey.setEventId(2001);
                    eventByKey.setContext(obj);
                    eventByKey.setPageName(str);
                    UTEventTracker.getInstance().beginEvent(eventByKey);
                }

                @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
                public void pageDisAppear(UTTracker uTTracker, Object obj) {
                    UTEvent eventByKey = UTEventTracker.getInstance().getEventByKey(UTEventTracker.getInstance().getKeyForObject(obj));
                    eventByKey.setToLog(false);
                    eventByKey.setToTrigger(false);
                    UTEventTracker.getInstance().endEvent(eventByKey);
                }

                @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
                public String trackerListenerName() {
                    return UTBehavior.UT_TRIGGER;
                }

                @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
                public void updateEvent(UTEvent uTEvent) {
                    if (uTEvent != null) {
                        UTTrigger.getInstance().triggerEventAsync(uTEvent);
                    }
                }

                @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
                public void updateEventPageName(UTEvent uTEvent) {
                    if (uTEvent != null) {
                        UTTrigger.getInstance().triggerEventAsync(uTEvent);
                    }
                }

                @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
                public void updatePageName(UTTracker uTTracker, Object obj, String str) {
                    UTEvent eventByKey = UTEventTracker.getInstance().getEventByKey(UTEventTracker.getInstance().getKeyForObject(obj));
                    eventByKey.setPageName(str);
                    UTEventTracker.getInstance().updateEventPageName(eventByKey);
                }

                @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
                public void updatePageProperties(UTTracker uTTracker, Object obj, Map<String, String> map) {
                    UTEvent eventByKey = UTEventTracker.getInstance().getEventByKey(UTEventTracker.getInstance().getKeyForObject(obj));
                    eventByKey.updateProperties(map);
                    UTEventTracker.getInstance().updateEvent(eventByKey);
                }
            });
        }
    }
}
