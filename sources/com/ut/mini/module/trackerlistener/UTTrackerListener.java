package com.ut.mini.module.trackerlistener;

import com.ut.mini.UTEvent;
import com.ut.mini.UTTracker;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class UTTrackerListener {
    public void addExposureViewToCommit(String str, String str2, String str3, String str4, Map<String, String> map) {
    }

    public void beginEvent(UTEvent uTEvent) {
    }

    public void beginScene(String str, Map<String, String> map) {
    }

    public void endEvent(UTEvent uTEvent) {
    }

    public void endScene(String str, Map<String, String> map) {
    }

    public int[] getAttentionEventIdsForSendEvent() {
        return null;
    }

    public void pageAppear(UTTracker uTTracker, Object obj, String str, boolean z) {
    }

    public void pageDisAppear(UTTracker uTTracker, Object obj) {
    }

    public void pageDisAppearEnd(UTTracker uTTracker, Object obj, Map<String, String> map) {
    }

    public void send(UTTracker uTTracker, Map<String, String> map) {
    }

    public void sendEvent(Map<String, String> map) {
    }

    public void sessionTimeout() {
    }

    public abstract String trackerListenerName();

    public void updateEvent(UTEvent uTEvent) {
    }

    public void updateEventPageName(UTEvent uTEvent) {
    }

    public void updateNextPageProperties(UTTracker uTTracker, Map<String, String> map) {
    }

    public void updateNextPageUtparam(String str) {
    }

    public void updatePageName(UTTracker uTTracker, Object obj, String str) {
    }

    public void updatePageProperties(UTTracker uTTracker, Object obj, Map<String, String> map) {
    }

    public void updatePagePropertiesEnd(UTTracker uTTracker, Object obj) {
    }

    public void updatePageUtparam(Object obj, String str) {
    }

    public void updateScene(String str, Map<String, String> map) {
    }

    public void viewBecomeVisible(String str, String str2, String str3) {
    }
}
