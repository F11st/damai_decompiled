package com.taobao.uikit.feature.features;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import com.taobao.uikit.base.R;
import com.taobao.uikit.utils.UIKITLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FeatureFactory {
    public static final int PRIORITY_ABOVE_NORMAL = 750;
    public static final int PRIORITY_BELOW_NORMAL = 250;
    public static final int PRIORITY_HIGHEST = 1000;
    public static final int PRIORITY_LOWEST = 0;
    public static final int PRIORITY_NORMAL = 500;
    private static final HashMap<String, AttachInfo> featureMap;
    private static FeatureFactory mSelf;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class AttachInfo {
        int id;
        int priority;

        public AttachInfo(int i, int i2) {
            this.id = i;
            this.priority = i2;
        }
    }

    static {
        HashMap<String, AttachInfo> hashMap = new HashMap<>();
        featureMap = hashMap;
        mSelf = new FeatureFactory();
        hashMap.put("com.taobao.uikit.feature.features.ClickDrawableMaskFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_clickDrawableMaskFeature, PRIORITY_ABOVE_NORMAL));
        hashMap.put("com.taobao.uikit.feature.features.RatioFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_ratioFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.RoundRectFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_roundRectFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.RoundFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_roundFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.ClickViewMaskFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_clickViewMaskFeature, 250));
        hashMap.put("com.taobao.uikit.feature.features.BinaryPageFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_binaryPageFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.PinnedHeaderFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_pinnedHeaderFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.PullToRefreshFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_pullToRefreshFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.StickyScrollFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_stickyScrollFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.ParallaxScrollFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_parallaxScrollFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.BounceScrollFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_bounceScrollFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.PencilShapeFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_pencilShapeFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.AutoScaleFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_autoScaleFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.RotateFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_rotateFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.ImageSaveFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_imagesavefeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.CellAnimatorFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_cellAnimatorFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.RecyclerCellAnimatorFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_recyclerCellAnimatorFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.DragToRefreshFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_dragToRefreshFeature, 500));
        hashMap.put("com.taobao.uikit.feature.features.ImageShapeFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_imageShapeFeature, 500));
        hashMap.put("com.taobao.uikit.extend.feature.features.SmoothScrollFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_smoothScrollFeature, 500));
        hashMap.put("com.taobao.uikit.extend.feature.features.SmoothRecyclerScrollFeature", new AttachInfo(R.styleable.FeatureNameSpace_uik_smoothRecyclerScrollFeature, 500));
    }

    public static void addFeature(String str, int i, int i2) {
        HashMap<String, AttachInfo> hashMap = featureMap;
        if (hashMap.containsKey(str)) {
            return;
        }
        hashMap.put(str, new AttachInfo(i, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends View> ArrayList<AbsFeature<? super T>> creator(Context context, TypedArray typedArray) {
        ArrayList<AbsFeature<? super T>> arrayList = (ArrayList<AbsFeature<? super T>>) new ArrayList();
        for (Map.Entry<String, AttachInfo> entry : featureMap.entrySet()) {
            String key = entry.getKey();
            int i = entry.getValue().id;
            if (i >= 0 && typedArray.getBoolean(i, false)) {
                try {
                    arrayList.add(Class.forName(key).newInstance());
                } catch (ClassNotFoundException e) {
                    UIKITLog.e("Android UiKit", "can't find feature by id", new Object[0]);
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static int getFeaturePriority(String str) {
        HashMap<String, AttachInfo> hashMap = featureMap;
        if (hashMap.containsKey(str)) {
            return hashMap.get(str).priority;
        }
        return 0;
    }
}
