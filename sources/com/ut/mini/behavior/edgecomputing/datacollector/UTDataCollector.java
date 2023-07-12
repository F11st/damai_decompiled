package com.ut.mini.behavior.edgecomputing.datacollector;

import android.content.Context;
import com.ut.mini.UTEvent;
import com.ut.mini.UTTracker;
import com.ut.mini.behavior.UTEventId;
import com.ut.mini.behavior.edgecomputing.adapter.AbstractDataCollectorAdapter;
import com.ut.mini.module.plugin.UTPlugin;
import com.ut.mini.module.plugin.UTPluginMgr;
import com.ut.mini.module.trackerlistener.UTTrackerListener;
import com.ut.mini.module.trackerlistener.UTTrackerListenerMgr;
import java.util.Map;
import tb.sj;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTDataCollector {
    private static final String TAG = "UTDataCollector";
    private static final String UT_DATA_COLLECTOR = "UTDataCollector";
    private static Context _context;
    private static boolean _initialized;
    private static UTDataCollector _instance;
    private static AbstractDataCollectorAdapter mDataCollectorAdapter;

    private UTDataCollector() {
    }

    public static synchronized UTDataCollector getInstance() {
        UTDataCollector uTDataCollector;
        synchronized (UTDataCollector.class) {
            if (_instance == null) {
                _instance = new UTDataCollector();
            }
            uTDataCollector = _instance;
        }
        return uTDataCollector;
    }

    public static synchronized void init(Context context, AbstractDataCollectorAdapter abstractDataCollectorAdapter) {
        synchronized (UTDataCollector.class) {
            if (!_initialized && context != null && abstractDataCollectorAdapter != null) {
                _context = context;
                mDataCollectorAdapter = abstractDataCollectorAdapter;
                initTables();
                init();
                GlobalData.cold_start_id = sj.c().e();
                GlobalData.session_id = "" + System.currentTimeMillis();
                _initialized = true;
            }
        }
    }

    private static void initTables() {
        UTDataStoreHelper.postRunnable(new Runnable() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UTDataCollector.1
            @Override // java.lang.Runnable
            public void run() {
                UTDataCollector.mDataCollectorAdapter.createTable("dc_ut_scene_node");
                UTDataCollector.mDataCollectorAdapter.createTable("dc_ut_pv_node");
                UTDataCollector.mDataCollectorAdapter.createTable("dc_ut_tap_node");
                UTDataCollector.mDataCollectorAdapter.createTable("dc_ut_expose_node");
                UTDataCollector.mDataCollectorAdapter.createTable("dc_ut_other_node");
                UTDataCollector.mDataCollectorAdapter.createTable("dc_ut_scroll_node");
                UTDataCollector.mDataCollectorAdapter.createTable("dc_ut_edge");
            }
        });
    }

    public Context getContext() {
        return _context;
    }

    public AbstractDataCollectorAdapter getDataCollectorAdapter() {
        return mDataCollectorAdapter;
    }

    private static void init() {
        final int[] iArr = {-1};
        UTPluginMgr.getInstance().registerPlugin(new UTPlugin() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UTDataCollector.2
            @Override // com.ut.mini.module.plugin.UTPlugin
            public int[] getAttentionEventIds() {
                return iArr;
            }

            @Override // com.ut.mini.module.plugin.UTPlugin
            public String getPluginName() {
                return "UTDataCollector";
            }

            @Override // com.ut.mini.module.plugin.UTPlugin
            public Map<String, String> onEventDispatch(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
                try {
                    UserActionTrack.commitLog(map);
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
        }, false, null, null);
        UTTrackerListenerMgr.getInstance().registerListener(new UTTrackerListener() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UTDataCollector.3
            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public void beginEvent(UTEvent uTEvent) {
                if (uTEvent != null && uTEvent.getEventId() == UTEventId.SCROLL.getEventId()) {
                    UserActionTrack.commitBeginScroll(uTEvent.getLogMap());
                }
            }

            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public void beginScene(String str, Map<String, String> map) {
                UserActionTrack.commitEnterScene(str, map);
            }

            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public void endEvent(UTEvent uTEvent) {
                if (uTEvent != null && uTEvent.getEventId() == UTEventId.SCROLL.getEventId()) {
                    UserActionTrack.commitEndScroll(uTEvent.getLogMap());
                }
            }

            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public void endScene(String str, Map<String, String> map) {
                UserActionTrack.commitLeaveScene(str, map);
            }

            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public void pageAppear(UTTracker uTTracker, Object obj, String str, boolean z) {
                UserActionTrack.commitEnter(obj, str);
            }

            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public void pageDisAppearEnd(UTTracker uTTracker, Object obj, Map<String, String> map) {
                UserActionTrack.commitLeave(obj, map);
            }

            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public void sessionTimeout() {
                GlobalData.session_id = "" + System.currentTimeMillis();
            }

            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public String trackerListenerName() {
                return "UTDataCollector";
            }

            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public void updatePageName(UTTracker uTTracker, Object obj, String str) {
                UserActionTrack.updatePvName(obj, str);
            }

            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public void updatePagePropertiesEnd(UTTracker uTTracker, Object obj) {
                UserActionTrack.commitUpdateProperties(obj, uTTracker.getPageProperties(obj));
            }

            @Override // com.ut.mini.module.trackerlistener.UTTrackerListener
            public void updateScene(String str, Map<String, String> map) {
                UserActionTrack.commitUpdateSceneProperties(str, map);
            }
        });
    }
}
