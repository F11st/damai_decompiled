package com.youku.vpm;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class OnPlayerTrackListener {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class Result {
        private Map<String, String> mDimensions;
        private Map<String, Double> mMeasures;

        public Result(Map<String, String> map, Map<String, Double> map2) {
            this.mDimensions = map;
            this.mMeasures = map2;
        }

        public String getDimension(String str) {
            Map<String, String> map = this.mDimensions;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }

        public Map<String, String> getDimensions() {
            return this.mDimensions;
        }

        public Double getMeasure(String str) {
            Map<String, Double> map = this.mMeasures;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }

        public Map<String, Double> getMeasures() {
            return this.mMeasures;
        }
    }

    public void onMonitorPoint(ITrack iTrack, String str, Result result) {
    }

    public void onNewTrack(ITrack iTrack) {
    }
}
