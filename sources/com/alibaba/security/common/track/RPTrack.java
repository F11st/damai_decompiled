package com.alibaba.security.common.track;

import android.content.Context;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.TrackLog;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class RPTrack {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class LastExitTrackParams implements Serializable {
        private String url;

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class TrackStrategy implements Serializable {
        private int mTrackCacheSize;

        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        public static class Builder implements Serializable {
            private int mTrackCacheSize;

            public TrackStrategy build() {
                return new TrackStrategy(this.mTrackCacheSize);
            }

            public Builder setTrackCacheSize(int i) {
                this.mTrackCacheSize = i;
                return this;
            }
        }

        TrackStrategy(int i) {
            this.mTrackCacheSize = i;
        }

        public int getTrackCacheSize() {
            return this.mTrackCacheSize;
        }
    }

    private static void a(Context context, TrackStrategy trackStrategy) {
        a.C0165a.a.a(context, trackStrategy);
    }

    private static void b() {
        a.C0165a.a.a(false);
    }

    private static LastExitTrackMsg c() {
        return a.C0165a.a.a;
    }

    private static void a(Context context) {
        a.C0165a.a.a(context, (TrackStrategy) null);
    }

    public static void a() {
        a aVar = a.C0165a.a;
        aVar.a(true);
        aVar.e.sendEmptyMessageDelayed(2, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    private static void a(TrackLog trackLog) {
        a.C0165a.a.a(trackLog);
    }

    private static void a(com.alibaba.security.common.track.b.a aVar) {
        a.C0165a.a.d = aVar;
    }

    private static void a(LastExitTrackMsg lastExitTrackMsg) {
        a.C0165a.a.a = lastExitTrackMsg;
    }
}
