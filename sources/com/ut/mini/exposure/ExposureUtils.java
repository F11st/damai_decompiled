package com.ut.mini.exposure;

import android.text.TextUtils;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExposureUtils {
    static final String UT_EXPOSURE_SPM_A = "x-spm-a";
    static final String UT_EXPOSURE_SPM_B = "x-spm-b";
    static final String UT_EXPOSURE_SPM_C = "x-spm-c";
    static final String UT_EXPOSURE_SPM_D = "x-spm-d";
    protected static final String UT_EXPROSURE_ARGS = "UT_EXPROSURE_ARGS";
    protected static final String UT_EXPROSURE_BLOCK = "UT_EXPROSURE_BLOCK";
    protected static final String UT_EXPROSURE_VIEWID = "UT_EXPROSURE_VIEWID";
    public static final int ut_exposure_data_spm = -17006;
    public static final int ut_exposure_root_spm = -17005;
    public static final int ut_exprosure_common_info_tag = -17003;
    public static final int ut_exprosure_ignore_tag = -17004;
    public static final int ut_exprosure_tag = -17001;
    public static final int ut_exprosure_tag_for_weex = -17002;
    private static final int ut_exprosure_viewgroup_tag = -17007;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void clearExposureForWeex(View view) {
        if (view == null) {
            ExpLogger.w(null, "error,view is null");
        } else {
            view.setTag(ut_exprosure_tag_for_weex, null);
        }
    }

    public static void clearIgnoreTagForExposureView(View view) {
        if (view != null) {
            view.setTag(ut_exprosure_ignore_tag, null);
        }
    }

    public static void clearViewGroupTagForExposureView(View view) {
        if (view != null) {
            view.setTag(ut_exprosure_viewgroup_tag, null);
        }
    }

    public static boolean isExposureView(View view) {
        return (view == null || view.getTag(ut_exprosure_tag) == null) ? false : true;
    }

    public static boolean isExposureViewForWeex(View view) {
        return (view == null || view.getTag(ut_exprosure_tag_for_weex) == null) ? false : true;
    }

    public static boolean isIngoneExposureView(View view) {
        return (view == null || view.getTag(ut_exprosure_ignore_tag) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isViewGroupExposureView(View view) {
        return (view == null || view.getTag(ut_exprosure_viewgroup_tag) == null) ? false : true;
    }

    public static void setExposure(View view, String str, String str2, Map<String, String> map) {
        if (view == null) {
            ExpLogger.w(null, "error,view is null");
        } else if (TextUtils.isEmpty(str)) {
            ExpLogger.w(null, "error,block is empty");
        } else if (TextUtils.isEmpty(str2)) {
            ExpLogger.w(null, "error,viewId is empty");
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(UT_EXPROSURE_BLOCK, str);
            hashMap.put(UT_EXPROSURE_VIEWID, str2);
            if (map != null) {
                hashMap.put(UT_EXPROSURE_ARGS, map);
            }
            view.setTag(ut_exprosure_tag, hashMap);
        }
    }

    public static void setExposureForWeex(View view) {
        if (view == null) {
            ExpLogger.w(null, "error,view is null");
        } else {
            view.setTag(ut_exprosure_tag_for_weex, "auto");
        }
    }

    public static void setExposureSpmAB(View view, String str, String str2) {
        if (view == null) {
            ExpLogger.w(null, "error,view is null");
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(UT_EXPOSURE_SPM_A, str);
            hashMap.put(UT_EXPOSURE_SPM_B, str2);
            view.setTag(ut_exposure_root_spm, hashMap);
        } else {
            ExpLogger.w(null, "spmA or spmB is empty");
        }
    }

    public static void setExposureSpmCD(View view, String str, String str2) {
        if (view == null) {
            ExpLogger.w(null, "error,view is null");
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(UT_EXPOSURE_SPM_C, str);
            hashMap.put(UT_EXPOSURE_SPM_D, str2);
            view.setTag(ut_exposure_data_spm, hashMap);
        } else {
            ExpLogger.w(null, "spmC or spmD is empty");
        }
    }

    public static void setIgnoreTagForExposureView(View view) {
        if (view != null) {
            view.setTag(ut_exprosure_ignore_tag, "user");
        }
    }

    public static void setViewGroupTagForExposureView(View view) {
        if (view != null) {
            view.setTag(ut_exprosure_viewgroup_tag, "1");
        }
    }
}
