package com.youku.upsplayer.util;

import android.util.Log;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayStageTracker {
    static final String TAG = "playtimetrack" + PlayStageTracker.class.getSimpleName();
    static volatile boolean mRegistered = false;
    static final String module = "vpm";
    static final String monitorPoint = "playStageStat";

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class Stage {
        private String mName;
        private long mStartTime;

        public Stage() {
            register();
        }

        static void register() {
            if (PlayStageTracker.mRegistered) {
                return;
            }
            PlayStageTracker.mRegistered = true;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.add(TLogEventConst.PARAM_UPLOAD_STAGE);
            linkedHashSet.add("section");
            linkedHashSet.add("cost");
            UtHelperProxy.getInstance().register(PlayStageTracker.module, PlayStageTracker.monitorPoint, linkedHashSet, new LinkedHashSet());
        }

        public void beginSection(String str) {
            this.mName = str;
            this.mStartTime = System.currentTimeMillis();
        }

        void commit() {
            Log.d(PlayStageTracker.TAG, String.format("stage=%s, section=%s, cost=%dms", getClass().getSimpleName(), this.mName, Long.valueOf(System.currentTimeMillis() - this.mStartTime)));
            HashMap hashMap = new HashMap();
            hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, getClass().getSimpleName());
            hashMap.put("section", this.mName);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("cost", Double.valueOf(System.currentTimeMillis() - this.mStartTime));
            UtHelperProxy.getInstance().commit(PlayStageTracker.module, PlayStageTracker.monitorPoint, hashMap, hashMap2);
        }

        public void endSection() {
            commit();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class UpsRequest extends Stage {
        UpsRequest() {
        }
    }

    public static Stage upsRequest() {
        return new UpsRequest();
    }
}
