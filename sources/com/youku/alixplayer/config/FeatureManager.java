package com.youku.alixplayer.config;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class FeatureManager {
    public static final String FEATURE_KEY_ABR = "abr";
    public static final String FEATURE_KEY_ALL = "all";
    public static final String FEATURE_KEY_FREE_FLOW = "freeFlow";
    public static final String FEATURE_KEY_IM_LOAD_SO = "im_load_so";
    public static final String FEATURE_KEY_OPR = "opr";
    public static final String FEATURE_KEY_PCDN = "pcdn";
    public static final String FEATURE_KEY_POST_PROCESS = "post_process";
    public static final String FEATURE_KEY_SUBTITLE = "subtitle";
    public static final String FEATURE_KEY_WATERMARK = "watermark";
    private static final FeatureManager instance = new FeatureManager();
    private List<String> mFeatures;

    private FeatureManager() {
        ArrayList arrayList = new ArrayList();
        this.mFeatures = arrayList;
        arrayList.clear();
        initDefaultFeatures();
        initFeatures("all");
    }

    public static FeatureManager getInstance() {
        return instance;
    }

    private void initDefaultFeatures() {
        addFeature(FEATURE_KEY_PCDN);
        addFeature(FEATURE_KEY_ABR);
        addFeature(FEATURE_KEY_SUBTITLE);
        addFeature(FEATURE_KEY_WATERMARK);
        addFeature(FEATURE_KEY_POST_PROCESS);
        addFeature(FEATURE_KEY_OPR);
        addFeature(FEATURE_KEY_IM_LOAD_SO);
        addFeature(FEATURE_KEY_FREE_FLOW);
    }

    private void initFeatures(String str) {
        String[] split;
        for (String str2 : str.split(",")) {
            if ("all".equals(str2)) {
                this.mFeatures.clear();
            } else {
                this.mFeatures.remove(str2);
            }
        }
    }

    private void initFeatures(List<String> list) {
        this.mFeatures.clear();
        this.mFeatures.addAll(list);
    }

    public void addFeature(String str) {
        if (this.mFeatures.contains(str)) {
            return;
        }
        this.mFeatures.add(str);
    }

    public boolean hasAbr() {
        return this.mFeatures.contains(FEATURE_KEY_ABR);
    }

    public boolean hasFeature(String str) {
        return this.mFeatures.contains(str);
    }

    public boolean hasFreeFlow() {
        return this.mFeatures.contains(FEATURE_KEY_FREE_FLOW);
    }

    public boolean hasIMLoadSo() {
        return this.mFeatures.contains(FEATURE_KEY_IM_LOAD_SO);
    }

    public boolean hasOpr() {
        return this.mFeatures.contains(FEATURE_KEY_OPR);
    }

    public boolean hasPCDN() {
        return this.mFeatures.contains(FEATURE_KEY_PCDN);
    }

    public boolean hasPostPro() {
        return this.mFeatures.contains(FEATURE_KEY_POST_PROCESS);
    }

    public boolean hasSubtitle() {
        return this.mFeatures.contains(FEATURE_KEY_SUBTITLE);
    }

    public boolean hasWaterMark() {
        return this.mFeatures.contains(FEATURE_KEY_WATERMARK);
    }

    public void removeFeature(String str) {
        if (this.mFeatures.contains(str)) {
            this.mFeatures.remove(str);
        }
    }
}
