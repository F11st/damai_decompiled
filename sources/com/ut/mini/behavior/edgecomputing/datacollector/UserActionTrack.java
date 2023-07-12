package com.ut.mini.behavior.edgecomputing.datacollector;

import android.text.TextUtils;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.behavior.UTEventId;
import com.ut.mini.behavior.edgecomputing.node.BaseNode;
import com.ut.mini.behavior.edgecomputing.node.Edge;
import com.ut.mini.behavior.edgecomputing.node.PVNode;
import com.ut.mini.behavior.edgecomputing.node.SceneNode;
import com.ut.mini.behavior.edgecomputing.node.ScrollNode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class UserActionTrack {
    private static final String TAG = "UserActionTrack";
    private static Map<String, PVNode> mAppearPVNodeMap = Collections.synchronizedMap(new HashMap());
    private static Map<String, SceneNode> mAppearSceneNodeMap = Collections.synchronizedMap(new HashMap());
    private static ScrollNode mAppearScrollNode;
    private static PVNode mLastAppearPvNode;
    private static PVNode mLastPvNode;

    UserActionTrack() {
    }

    public static synchronized void commitBeginScroll(final Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            if (map == null) {
                return;
            }
            final String str = "" + System.currentTimeMillis();
            UTDataStoreHelper.postRunnable(new Runnable() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.1
                @Override // java.lang.Runnable
                public void run() {
                    UserActionTrack.commitEnterScrollNode(str, map);
                }
            });
        }
    }

    private static synchronized long commitEdge(BaseNode baseNode, BaseNode baseNode2, boolean z) {
        synchronized (UserActionTrack.class) {
            if (baseNode == null || baseNode2 == null) {
                return -1L;
            }
            Edge edge = new Edge();
            edge.left_node_id = baseNode.id;
            edge.left_table = baseNode.getTableName();
            edge.left_event_id = baseNode.event_id;
            edge.left_event_name = baseNode.page;
            edge.left_scene = baseNode.scene;
            edge.right_node_id = baseNode2.id;
            edge.right_table = baseNode2.getTableName();
            edge.right_event_id = baseNode2.event_id;
            if (z) {
                edge.right_event_name = baseNode2.page;
            } else {
                try {
                    Map<String, String> map = baseNode2.bizMap;
                    if (map != null) {
                        edge.right_event_name = map.get(LogField.ARG1.toString());
                    }
                } catch (Exception unused) {
                }
            }
            edge.right_scene = baseNode2.scene;
            edge.create_time = baseNode2.updateTime;
            return edge.save();
        }
    }

    private static synchronized void commitEdgeInPv(BaseNode baseNode) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitEdgeInPv seqId", Long.valueOf(commitEdge(mLastAppearPvNode, baseNode, false)));
        }
    }

    private static synchronized void commitEdgeInScroll(BaseNode baseNode) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitEdgeInScroll seqId", Long.valueOf(commitEdge(mAppearScrollNode, baseNode, false)));
        }
    }

    public static synchronized void commitEndScroll(final Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            if (map == null) {
                return;
            }
            final String str = "" + System.currentTimeMillis();
            UTDataStoreHelper.postRunnable(new Runnable() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.2
                @Override // java.lang.Runnable
                public void run() {
                    UserActionTrack.commitEndScrollNode(str, map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void commitEndScrollNode(String str, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            if (mAppearScrollNode != null && map != null) {
                String str2 = map.get(LogField.PAGE.toString());
                if (str2 != null && str2.equals(mAppearScrollNode.page)) {
                    mAppearScrollNode.updateBizMap(map);
                    ScrollNode scrollNode = mAppearScrollNode;
                    scrollNode.updateTime = str;
                    Logger.f(TAG, "update count", Long.valueOf(scrollNode.update()));
                    mAppearScrollNode = null;
                }
            }
        }
    }

    public static synchronized void commitEnter(Object obj, final String str) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitEnter context", obj, "pageName", str);
            if (obj == null) {
                return;
            }
            final String str2 = "" + obj.hashCode();
            final String str3 = "" + System.currentTimeMillis();
            UTDataStoreHelper.postRunnable(new Runnable() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.5
                @Override // java.lang.Runnable
                public void run() {
                    Logger.f(UserActionTrack.TAG, "commitEnter contextHashCode", str2);
                    UserActionTrack.commitEnterNode(str2, str, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void commitEnterNode(String str, String str2, String str3) {
        String str4;
        synchronized (UserActionTrack.class) {
            if (yh2.f(str2)) {
                str4 = str;
            } else {
                str4 = str + JSMethod.NOT_SET + str2.hashCode();
            }
            PVNode pVNode = new PVNode();
            pVNode.cold_start_id = GlobalData.cold_start_id;
            pVNode.session_id = GlobalData.session_id;
            pVNode.pv_key = str4;
            pVNode.event_id = "2001";
            pVNode.createTime = str3;
            pVNode.user_id = GlobalData.getUserid();
            pVNode.page = str2;
            pVNode.scene = str2;
            long save = pVNode.save();
            Logger.f(TAG, "commitEnterNode seqId", Long.valueOf(save));
            if (save <= 0) {
                return;
            }
            pVNode.id = save;
            mLastAppearPvNode = pVNode;
            mAppearPVNodeMap.put(str, pVNode);
        }
    }

    public static synchronized void commitEnterScene(final String str, final Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitSceneEnter scene", str, "properties", map);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            final String str2 = "" + System.currentTimeMillis();
            UTDataStoreHelper.postRunnable(new Runnable() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.3
                @Override // java.lang.Runnable
                public void run() {
                    UserActionTrack.commitEnterSceneNode(str, map, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void commitEnterSceneNode(String str, Map<String, String> map, String str2) {
        synchronized (UserActionTrack.class) {
            if (yh2.f(str)) {
                return;
            }
            SceneNode sceneNode = new SceneNode();
            sceneNode.cold_start_id = GlobalData.cold_start_id;
            sceneNode.session_id = GlobalData.session_id;
            sceneNode.event_id = "2701";
            sceneNode.createTime = str2;
            sceneNode.user_id = GlobalData.getUserid();
            sceneNode.page = str;
            sceneNode.scene = str;
            sceneNode.updateBizMap(map);
            long save = sceneNode.save();
            Logger.f(TAG, "commitEnterSceneNode seqId", Long.valueOf(save));
            if (save <= 0) {
                return;
            }
            sceneNode.id = save;
            mAppearSceneNodeMap.put(str, sceneNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void commitEnterScrollNode(String str, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            ScrollNode scrollNode = new ScrollNode();
            scrollNode.cold_start_id = GlobalData.cold_start_id;
            scrollNode.session_id = GlobalData.session_id;
            scrollNode.event_id = "" + UTEventId.SCROLL.getEventId();
            scrollNode.createTime = str;
            scrollNode.user_id = GlobalData.getUserid();
            scrollNode.page = map.get(LogField.PAGE.toString());
            scrollNode.updateBizMap(map);
            long save = scrollNode.save();
            Logger.f(TAG, "commitEnterScrollNode seqId", Long.valueOf(save), "tyoe", scrollNode.getTableName());
            if (save <= 0) {
                return;
            }
            scrollNode.id = save;
            commitEdgeInPv(scrollNode);
            mAppearScrollNode = scrollNode;
        }
    }

    public static synchronized void commitLeave(Object obj, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitLeave context", obj, "logMap", map);
            commitLeave(obj, map, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void commitLeaveNode(String str, String str2, Map<String, String> map, boolean z) {
        String str3;
        synchronized (UserActionTrack.class) {
            PVNode pVNode = mAppearPVNodeMap.get(str);
            if (pVNode == null) {
                return;
            }
            pVNode.updateBizMap(map);
            if (z) {
                String str4 = map.get(LogField.PAGE.toString());
                pVNode.page = str4;
                if (!yh2.f(str4)) {
                    str3 = str + JSMethod.NOT_SET + pVNode.page.hashCode();
                } else {
                    str3 = str + JSMethod.NOT_SET;
                }
                pVNode.pv_key = str3;
                pVNode.updateTime = str2;
                pVNode.scene = pVNode.page;
                pVNode.from_scene = map.get(LogField.ARG1.toString());
            }
            Logger.f(TAG, "update count", Long.valueOf(pVNode.update()));
            if (z) {
                mAppearPVNodeMap.remove(str);
                commitPvEdge(pVNode);
                mLastPvNode = pVNode;
            }
        }
    }

    public static synchronized void commitLeaveScene(String str, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitLeaveScene scene", str, "logMap", map);
            commitLeaveScene(str, map, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void commitLeaveSceneNode(String str, String str2, Map<String, String> map, boolean z) {
        synchronized (UserActionTrack.class) {
            SceneNode sceneNode = mAppearSceneNodeMap.get(str);
            if (sceneNode == null) {
                return;
            }
            sceneNode.updateBizMap(map);
            if (z) {
                sceneNode.updateTime = str2;
            }
            Logger.f(TAG, "update count", Long.valueOf(sceneNode.update()));
            if (z) {
                mAppearSceneNodeMap.remove(str);
            }
        }
    }

    public static synchronized void commitLog(final Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            if (map == null) {
                return;
            }
            final String str = "" + System.currentTimeMillis();
            UTDataStoreHelper.postRunnable(new Runnable() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.8
                @Override // java.lang.Runnable
                public void run() {
                    UserActionTrack.commitNode(str, map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8 A[Catch: all -> 0x00c6, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0017, B:10:0x001f, B:12:0x002f, B:17:0x0038, B:19:0x0042, B:28:0x0069, B:33:0x00b8, B:35:0x00bc, B:37:0x00c1, B:21:0x004a, B:23:0x0052, B:26:0x005b, B:27:0x0062), top: B:43:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void commitNode(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            java.lang.Class<com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack> r0 = com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.class
            monitor-enter(r0)
            com.alibaba.analytics.core.model.LogField r1 = com.alibaba.analytics.core.model.LogField.EVENTID     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r1 = r10.get(r1)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> Lc6
            boolean r2 = tb.yh2.f(r1)     // Catch: java.lang.Throwable -> Lc6
            if (r2 == 0) goto L17
            monitor-exit(r0)
            return
        L17:
            java.lang.String r2 = "2001"
            boolean r2 = r2.equals(r1)     // Catch: java.lang.Throwable -> Lc6
            if (r2 == 0) goto L38
            java.lang.String r1 = "1"
            java.lang.String r2 = "_ish5"
            java.lang.Object r2 = r10.get(r2)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Lc6
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> Lc6
            if (r1 == 0) goto L36
            java.lang.String r1 = "2001"
            commitPvNodeWindVane(r1, r9, r10)     // Catch: java.lang.Throwable -> Lc6
            monitor-exit(r0)
            return
        L36:
            monitor-exit(r0)
            return
        L38:
            java.lang.String r2 = "2101"
            boolean r2 = r2.equals(r1)     // Catch: java.lang.Throwable -> Lc6
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L4a
            com.ut.mini.behavior.edgecomputing.node.TapNode r2 = new com.ut.mini.behavior.edgecomputing.node.TapNode     // Catch: java.lang.Throwable -> Lc6
            r2.<init>()     // Catch: java.lang.Throwable -> Lc6
            r5 = 1
        L48:
            r6 = 0
            goto L69
        L4a:
            java.lang.String r2 = "2201"
            boolean r2 = r2.equals(r1)     // Catch: java.lang.Throwable -> Lc6
            if (r2 != 0) goto L62
            java.lang.String r2 = "2202"
            boolean r2 = r2.equals(r1)     // Catch: java.lang.Throwable -> Lc6
            if (r2 == 0) goto L5b
            goto L62
        L5b:
            com.ut.mini.behavior.edgecomputing.node.OtherNode r2 = new com.ut.mini.behavior.edgecomputing.node.OtherNode     // Catch: java.lang.Throwable -> Lc6
            r2.<init>()     // Catch: java.lang.Throwable -> Lc6
            r5 = 0
            goto L48
        L62:
            com.ut.mini.behavior.edgecomputing.node.ExposeNode r2 = new com.ut.mini.behavior.edgecomputing.node.ExposeNode     // Catch: java.lang.Throwable -> Lc6
            r2.<init>()     // Catch: java.lang.Throwable -> Lc6
            r5 = 1
            r6 = 1
        L69:
            java.lang.String r7 = com.ut.mini.behavior.edgecomputing.datacollector.GlobalData.cold_start_id     // Catch: java.lang.Throwable -> Lc6
            r2.cold_start_id = r7     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r7 = com.ut.mini.behavior.edgecomputing.datacollector.GlobalData.session_id     // Catch: java.lang.Throwable -> Lc6
            r2.session_id = r7     // Catch: java.lang.Throwable -> Lc6
            r2.event_id = r1     // Catch: java.lang.Throwable -> Lc6
            r2.createTime = r9     // Catch: java.lang.Throwable -> Lc6
            r2.updateTime = r9     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r9 = com.ut.mini.behavior.edgecomputing.datacollector.GlobalData.getUserid()     // Catch: java.lang.Throwable -> Lc6
            r2.user_id = r9     // Catch: java.lang.Throwable -> Lc6
            com.alibaba.analytics.core.model.LogField r9 = com.alibaba.analytics.core.model.LogField.PAGE     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r9 = r10.get(r9)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> Lc6
            r2.page = r9     // Catch: java.lang.Throwable -> Lc6
            r2.updateBizMap(r10)     // Catch: java.lang.Throwable -> Lc6
            long r9 = r2.save()     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r1 = "UserActionTrack"
            r7 = 4
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r8 = "commitNode seqId"
            r7[r3] = r8     // Catch: java.lang.Throwable -> Lc6
            java.lang.Long r3 = java.lang.Long.valueOf(r9)     // Catch: java.lang.Throwable -> Lc6
            r7[r4] = r3     // Catch: java.lang.Throwable -> Lc6
            r3 = 2
            java.lang.String r4 = "tyoe"
            r7[r3] = r4     // Catch: java.lang.Throwable -> Lc6
            r3 = 3
            java.lang.String r4 = r2.getTableName()     // Catch: java.lang.Throwable -> Lc6
            r7[r3] = r4     // Catch: java.lang.Throwable -> Lc6
            com.alibaba.analytics.utils.Logger.f(r1, r7)     // Catch: java.lang.Throwable -> Lc6
            r3 = 0
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 > 0) goto Lb8
            monitor-exit(r0)
            return
        Lb8:
            r2.id = r9     // Catch: java.lang.Throwable -> Lc6
            if (r5 == 0) goto Lbf
            commitEdgeInPv(r2)     // Catch: java.lang.Throwable -> Lc6
        Lbf:
            if (r6 == 0) goto Lc4
            commitEdgeInScroll(r2)     // Catch: java.lang.Throwable -> Lc6
        Lc4:
            monitor-exit(r0)
            return
        Lc6:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.commitNode(java.lang.String, java.util.Map):void");
    }

    private static synchronized void commitPvEdge(PVNode pVNode) {
        synchronized (UserActionTrack.class) {
            commitPvEdgeInPv(pVNode);
            commitPvEdgeInScene(pVNode);
        }
    }

    private static synchronized void commitPvEdgeInPv(PVNode pVNode) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitPvEdgeInPv seqId", Long.valueOf(commitEdge(mLastPvNode, pVNode, true)));
        }
    }

    private static synchronized void commitPvEdgeInScene(PVNode pVNode) {
        synchronized (UserActionTrack.class) {
            Map<String, SceneNode> map = mAppearSceneNodeMap;
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, SceneNode> entry : map.entrySet()) {
                    Logger.f(TAG, "commitPvEdgeInScene seqId", Long.valueOf(commitEdge(entry.getValue(), pVNode, true)));
                }
            }
        }
    }

    private static synchronized void commitPvNodeWindVane(String str, String str2, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitPvNodeWindVane");
            PVNode pVNode = new PVNode();
            pVNode.cold_start_id = GlobalData.cold_start_id;
            pVNode.session_id = GlobalData.session_id;
            pVNode.event_id = str;
            pVNode.createTime = str2;
            pVNode.updateTime = str2;
            pVNode.user_id = GlobalData.getUserid();
            pVNode.page = map.get(LogField.PAGE.toString());
            pVNode.updateBizMap(map);
            pVNode.save();
        }
    }

    public static synchronized void commitUpdateProperties(Object obj, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitUpdateProperties context", obj, "logMap", map);
            commitLeave(obj, map, false);
        }
    }

    public static synchronized void commitUpdateSceneProperties(String str, Map<String, String> map) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "commitUpdateSceneProperties scene", str, "logMap", map);
            commitLeaveScene(str, map, false);
        }
    }

    public static synchronized void updatePvName(Object obj, final String str) {
        synchronized (UserActionTrack.class) {
            Logger.f(TAG, "updatePvName context", obj, "pageName", str);
            if (obj != null && !yh2.f(str)) {
                final String str2 = "" + obj.hashCode();
                UTDataStoreHelper.postRunnable(new Runnable() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.7
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.f(UserActionTrack.TAG, "updatePvName contextHashCode", str2);
                        UserActionTrack.updatePvNodeName(str2, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void updatePvNodeName(String str, String str2) {
        String str3;
        synchronized (UserActionTrack.class) {
            if (yh2.f(str2)) {
                str3 = str;
            } else {
                str3 = str + JSMethod.NOT_SET + str2.hashCode();
            }
            PVNode pVNode = mAppearPVNodeMap.get(str);
            if (pVNode == null) {
                return;
            }
            pVNode.pv_key = str3;
            pVNode.page = str2;
            pVNode.scene = str2;
            Logger.f(TAG, "updatePvNodeName count", Long.valueOf(pVNode.updatePageName()));
        }
    }

    private static synchronized void commitLeave(Object obj, final Map<String, String> map, final boolean z) {
        synchronized (UserActionTrack.class) {
            if (obj == null || map == null) {
                return;
            }
            final String str = "" + obj.hashCode();
            final String str2 = "" + System.currentTimeMillis();
            UTDataStoreHelper.postRunnable(new Runnable() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.6
                @Override // java.lang.Runnable
                public void run() {
                    UserActionTrack.commitLeaveNode(str, str2, map, z);
                }
            });
        }
    }

    private static synchronized void commitLeaveScene(final String str, final Map<String, String> map, final boolean z) {
        synchronized (UserActionTrack.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            final String str2 = "" + System.currentTimeMillis();
            UTDataStoreHelper.postRunnable(new Runnable() { // from class: com.ut.mini.behavior.edgecomputing.datacollector.UserActionTrack.4
                @Override // java.lang.Runnable
                public void run() {
                    UserActionTrack.commitLeaveSceneNode(str, str2, map, z);
                }
            });
        }
    }
}
