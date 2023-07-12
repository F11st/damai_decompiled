package com.youku.resource.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.resource.R;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ColorConfigureManager {
    private static final String TAG = "ColorConfigureManager";
    private static Context context;
    private static final ColorConfigureManager ourInstance = new ColorConfigureManager();
    private HashMap<String, Integer> colorMap = new HashMap<>(100);
    private HashMap<Integer, String> tokenMap = new HashMap<>(100);

    private ColorConfigureManager() {
        updateColorPalette();
    }

    public static ColorConfigureManager getInstance() {
        HashMap<String, Integer> hashMap;
        ColorConfigureManager colorConfigureManager = ourInstance;
        if (colorConfigureManager != null && (hashMap = colorConfigureManager.colorMap) != null && hashMap.size() == 0) {
            colorConfigureManager.updateColorPalette();
        }
        return colorConfigureManager;
    }

    private void updateColorPalette() {
        Log.d(TAG, "updateColorPalette begin");
        if (context == null) {
            context = AppInfoProviderProxy.getApplication();
        }
        Context context2 = context;
        if (context2 == null) {
            return;
        }
        Resources resources = context2.getResources();
        HashMap<String, Integer> hashMap = this.colorMap;
        int i = R.color.cd_1;
        hashMap.put(StaticColorDefine.CD_1, Integer.valueOf(resources.getColor(i)));
        this.tokenMap.put(Integer.valueOf(i), StaticColorDefine.CD_1);
        HashMap<String, Integer> hashMap2 = this.colorMap;
        int i2 = R.color.cg_1;
        hashMap2.put(StaticColorDefine.CG_1, Integer.valueOf(resources.getColor(i2)));
        HashMap<String, Integer> hashMap3 = this.colorMap;
        int i3 = R.color.cg_2;
        hashMap3.put(StaticColorDefine.CG_2, Integer.valueOf(resources.getColor(i3)));
        HashMap<String, Integer> hashMap4 = this.colorMap;
        int i4 = R.color.cg_3;
        hashMap4.put(StaticColorDefine.CG_3, Integer.valueOf(resources.getColor(i4)));
        HashMap<String, Integer> hashMap5 = this.colorMap;
        int i5 = R.color.cg_4;
        hashMap5.put(StaticColorDefine.CG_4, Integer.valueOf(resources.getColor(i5)));
        HashMap<String, Integer> hashMap6 = this.colorMap;
        int i6 = R.color.cg_5;
        hashMap6.put(StaticColorDefine.CG_5, Integer.valueOf(resources.getColor(i6)));
        HashMap<String, Integer> hashMap7 = this.colorMap;
        int i7 = R.color.cg_6;
        hashMap7.put(StaticColorDefine.CG_6, Integer.valueOf(resources.getColor(i7)));
        HashMap<String, Integer> hashMap8 = this.colorMap;
        int i8 = R.color.cg_7;
        hashMap8.put(StaticColorDefine.CG_7, Integer.valueOf(resources.getColor(i8)));
        HashMap<String, Integer> hashMap9 = this.colorMap;
        int i9 = R.color.cg_8;
        hashMap9.put(StaticColorDefine.CG_8, Integer.valueOf(resources.getColor(i9)));
        HashMap<String, Integer> hashMap10 = this.colorMap;
        int i10 = R.color.cg_9;
        hashMap10.put(StaticColorDefine.CG_9, Integer.valueOf(resources.getColor(i10)));
        HashMap<String, Integer> hashMap11 = this.colorMap;
        int i11 = R.color.cg_10;
        hashMap11.put(StaticColorDefine.CG_10, Integer.valueOf(resources.getColor(i11)));
        HashMap<String, Integer> hashMap12 = this.colorMap;
        int i12 = R.color.cg_11;
        hashMap12.put(StaticColorDefine.CG_11, Integer.valueOf(resources.getColor(i12)));
        HashMap<String, Integer> hashMap13 = this.colorMap;
        int i13 = R.color.cg_12;
        hashMap13.put(StaticColorDefine.CG_12, Integer.valueOf(resources.getColor(i13)));
        HashMap<String, Integer> hashMap14 = this.colorMap;
        int i14 = R.color.cg_13;
        hashMap14.put(StaticColorDefine.CG_13, Integer.valueOf(resources.getColor(i14)));
        HashMap<String, Integer> hashMap15 = this.colorMap;
        int i15 = R.color.cg_14;
        hashMap15.put(StaticColorDefine.CG_14, Integer.valueOf(resources.getColor(i15)));
        HashMap<String, Integer> hashMap16 = this.colorMap;
        int i16 = R.color.cg_15;
        hashMap16.put(StaticColorDefine.CG_15, Integer.valueOf(resources.getColor(i16)));
        HashMap<String, Integer> hashMap17 = this.colorMap;
        int i17 = R.color.cg_16;
        hashMap17.put(StaticColorDefine.CG_16, Integer.valueOf(resources.getColor(i17)));
        HashMap<String, Integer> hashMap18 = this.colorMap;
        int i18 = R.color.cg_17;
        hashMap18.put(StaticColorDefine.CG_17, Integer.valueOf(resources.getColor(i18)));
        HashMap<String, Integer> hashMap19 = this.colorMap;
        int i19 = R.color.cg_18;
        hashMap19.put(StaticColorDefine.CG_18, Integer.valueOf(resources.getColor(i19)));
        HashMap<String, Integer> hashMap20 = this.colorMap;
        int i20 = R.color.cg_19;
        hashMap20.put(StaticColorDefine.CG_19, Integer.valueOf(resources.getColor(i20)));
        this.tokenMap.put(Integer.valueOf(i2), StaticColorDefine.CG_1);
        this.tokenMap.put(Integer.valueOf(i3), StaticColorDefine.CG_2);
        this.tokenMap.put(Integer.valueOf(i4), StaticColorDefine.CG_3);
        this.tokenMap.put(Integer.valueOf(i5), StaticColorDefine.CG_4);
        this.tokenMap.put(Integer.valueOf(i6), StaticColorDefine.CG_5);
        this.tokenMap.put(Integer.valueOf(i7), StaticColorDefine.CG_6);
        this.tokenMap.put(Integer.valueOf(i8), StaticColorDefine.CG_7);
        this.tokenMap.put(Integer.valueOf(i9), StaticColorDefine.CG_8);
        this.tokenMap.put(Integer.valueOf(i10), StaticColorDefine.CG_9);
        this.tokenMap.put(Integer.valueOf(i11), StaticColorDefine.CG_10);
        this.tokenMap.put(Integer.valueOf(i12), StaticColorDefine.CG_11);
        this.tokenMap.put(Integer.valueOf(i13), StaticColorDefine.CG_12);
        this.tokenMap.put(Integer.valueOf(i14), StaticColorDefine.CG_13);
        this.tokenMap.put(Integer.valueOf(i15), StaticColorDefine.CG_14);
        this.tokenMap.put(Integer.valueOf(i16), StaticColorDefine.CG_15);
        this.tokenMap.put(Integer.valueOf(i17), StaticColorDefine.CG_16);
        this.tokenMap.put(Integer.valueOf(i18), StaticColorDefine.CG_17);
        this.tokenMap.put(Integer.valueOf(i19), StaticColorDefine.CG_18);
        this.tokenMap.put(Integer.valueOf(i20), StaticColorDefine.CG_19);
        HashMap<String, Integer> hashMap21 = this.colorMap;
        int i21 = R.color.cp_1;
        hashMap21.put(StaticColorDefine.CP_1, Integer.valueOf(resources.getColor(i21)));
        HashMap<String, Integer> hashMap22 = this.colorMap;
        int i22 = R.color.cp_2;
        hashMap22.put(StaticColorDefine.CP_2, Integer.valueOf(resources.getColor(i22)));
        HashMap<String, Integer> hashMap23 = this.colorMap;
        int i23 = R.color.cp_3;
        hashMap23.put(StaticColorDefine.CP_3, Integer.valueOf(resources.getColor(i23)));
        HashMap<String, Integer> hashMap24 = this.colorMap;
        int i24 = R.color.cp_4;
        hashMap24.put(StaticColorDefine.CP_4, Integer.valueOf(resources.getColor(i24)));
        HashMap<String, Integer> hashMap25 = this.colorMap;
        int i25 = R.color.cp_5;
        hashMap25.put(StaticColorDefine.CP_5, Integer.valueOf(resources.getColor(i25)));
        this.tokenMap.put(Integer.valueOf(i21), StaticColorDefine.CP_1);
        this.tokenMap.put(Integer.valueOf(i22), StaticColorDefine.CP_2);
        this.tokenMap.put(Integer.valueOf(i23), StaticColorDefine.CP_3);
        this.tokenMap.put(Integer.valueOf(i24), StaticColorDefine.CP_4);
        this.tokenMap.put(Integer.valueOf(i25), StaticColorDefine.CP_5);
        HashMap<String, Integer> hashMap26 = this.colorMap;
        int i26 = R.color.cw_1;
        hashMap26.put(StaticColorDefine.CW_1, Integer.valueOf(resources.getColor(i26)));
        this.tokenMap.put(Integer.valueOf(i26), StaticColorDefine.CW_1);
        HashMap<String, Integer> hashMap27 = this.colorMap;
        int i27 = R.color.cb_1;
        hashMap27.put(StaticColorDefine.CB_1, Integer.valueOf(resources.getColor(i27)));
        HashMap<String, Integer> hashMap28 = this.colorMap;
        int i28 = R.color.cb_2;
        hashMap28.put(StaticColorDefine.CB_2, Integer.valueOf(resources.getColor(i28)));
        HashMap<String, Integer> hashMap29 = this.colorMap;
        int i29 = R.color.cb_3;
        hashMap29.put(StaticColorDefine.CB_3, Integer.valueOf(resources.getColor(i29)));
        HashMap<String, Integer> hashMap30 = this.colorMap;
        int i30 = R.color.cb_4;
        hashMap30.put(StaticColorDefine.CB_4, Integer.valueOf(resources.getColor(i30)));
        HashMap<String, Integer> hashMap31 = this.colorMap;
        int i31 = R.color.cb_5;
        hashMap31.put(StaticColorDefine.CB_5, Integer.valueOf(resources.getColor(i31)));
        HashMap<String, Integer> hashMap32 = this.colorMap;
        int i32 = R.color.cb_6;
        hashMap32.put(StaticColorDefine.CB_6, Integer.valueOf(resources.getColor(i32)));
        HashMap<String, Integer> hashMap33 = this.colorMap;
        int i33 = R.color.cb_7;
        hashMap33.put(StaticColorDefine.CB_7, Integer.valueOf(resources.getColor(i33)));
        HashMap<String, Integer> hashMap34 = this.colorMap;
        int i34 = R.color.cb_8;
        hashMap34.put(StaticColorDefine.CB_8, Integer.valueOf(resources.getColor(i34)));
        HashMap<String, Integer> hashMap35 = this.colorMap;
        int i35 = R.color.cb_9;
        hashMap35.put(StaticColorDefine.CB_9, Integer.valueOf(resources.getColor(i35)));
        HashMap<String, Integer> hashMap36 = this.colorMap;
        int i36 = R.color.cb_10;
        hashMap36.put(StaticColorDefine.CB_10, Integer.valueOf(resources.getColor(i36)));
        HashMap<String, Integer> hashMap37 = this.colorMap;
        int i37 = R.color.cb_11;
        hashMap37.put(StaticColorDefine.CB_11, Integer.valueOf(resources.getColor(i37)));
        HashMap<String, Integer> hashMap38 = this.colorMap;
        int i38 = R.color.cb_12;
        hashMap38.put(StaticColorDefine.CB_12, Integer.valueOf(resources.getColor(i38)));
        this.tokenMap.put(Integer.valueOf(i27), StaticColorDefine.CB_1);
        this.tokenMap.put(Integer.valueOf(i28), StaticColorDefine.CB_2);
        this.tokenMap.put(Integer.valueOf(i29), StaticColorDefine.CB_3);
        this.tokenMap.put(Integer.valueOf(i30), StaticColorDefine.CB_4);
        this.tokenMap.put(Integer.valueOf(i31), StaticColorDefine.CB_5);
        this.tokenMap.put(Integer.valueOf(i32), StaticColorDefine.CB_6);
        this.tokenMap.put(Integer.valueOf(i33), StaticColorDefine.CB_7);
        this.tokenMap.put(Integer.valueOf(i34), StaticColorDefine.CB_8);
        this.tokenMap.put(Integer.valueOf(i35), StaticColorDefine.CB_9);
        this.tokenMap.put(Integer.valueOf(i36), StaticColorDefine.CB_10);
        this.tokenMap.put(Integer.valueOf(i37), StaticColorDefine.CB_11);
        this.tokenMap.put(Integer.valueOf(i38), StaticColorDefine.CB_12);
        HashMap<String, Integer> hashMap39 = this.colorMap;
        int i39 = R.color.cr_1;
        hashMap39.put(StaticColorDefine.CR_1, Integer.valueOf(resources.getColor(i39)));
        HashMap<String, Integer> hashMap40 = this.colorMap;
        int i40 = R.color.cr_2;
        hashMap40.put(StaticColorDefine.CR_2, Integer.valueOf(resources.getColor(i40)));
        HashMap<String, Integer> hashMap41 = this.colorMap;
        int i41 = R.color.cr_3;
        hashMap41.put(StaticColorDefine.CR_3, Integer.valueOf(resources.getColor(i41)));
        this.tokenMap.put(Integer.valueOf(i39), StaticColorDefine.CR_1);
        this.tokenMap.put(Integer.valueOf(i40), StaticColorDefine.CR_2);
        this.tokenMap.put(Integer.valueOf(i41), StaticColorDefine.CR_3);
        HashMap<String, Integer> hashMap42 = this.colorMap;
        int i42 = R.color.cv_1;
        hashMap42.put(StaticColorDefine.CV_1, Integer.valueOf(resources.getColor(i42)));
        HashMap<String, Integer> hashMap43 = this.colorMap;
        int i43 = R.color.cv_2;
        hashMap43.put(StaticColorDefine.CV_2, Integer.valueOf(resources.getColor(i43)));
        HashMap<String, Integer> hashMap44 = this.colorMap;
        int i44 = R.color.cv_3;
        hashMap44.put(StaticColorDefine.CV_3, Integer.valueOf(resources.getColor(i44)));
        HashMap<String, Integer> hashMap45 = this.colorMap;
        int i45 = R.color.cv_4;
        hashMap45.put(StaticColorDefine.CV_4, Integer.valueOf(resources.getColor(i45)));
        HashMap<String, Integer> hashMap46 = this.colorMap;
        int i46 = R.color.cv_5;
        hashMap46.put(StaticColorDefine.CV_5, Integer.valueOf(resources.getColor(i46)));
        this.tokenMap.put(Integer.valueOf(i42), StaticColorDefine.CV_1);
        this.tokenMap.put(Integer.valueOf(i43), StaticColorDefine.CV_2);
        this.tokenMap.put(Integer.valueOf(i44), StaticColorDefine.CV_3);
        this.tokenMap.put(Integer.valueOf(i45), StaticColorDefine.CV_4);
        this.tokenMap.put(Integer.valueOf(i46), StaticColorDefine.CV_5);
        HashMap<String, Integer> hashMap47 = this.colorMap;
        int i47 = R.color.cy_1;
        hashMap47.put(StaticColorDefine.CY_1, Integer.valueOf(resources.getColor(i47)));
        HashMap<String, Integer> hashMap48 = this.colorMap;
        int i48 = R.color.cy_2;
        hashMap48.put(StaticColorDefine.CY_2, Integer.valueOf(resources.getColor(i48)));
        HashMap<String, Integer> hashMap49 = this.colorMap;
        int i49 = R.color.cy_3;
        hashMap49.put(StaticColorDefine.CY_3, Integer.valueOf(resources.getColor(i49)));
        HashMap<String, Integer> hashMap50 = this.colorMap;
        int i50 = R.color.cy_4;
        hashMap50.put(StaticColorDefine.CY_4, Integer.valueOf(resources.getColor(i50)));
        this.tokenMap.put(Integer.valueOf(i47), StaticColorDefine.CY_1);
        this.tokenMap.put(Integer.valueOf(i48), StaticColorDefine.CY_2);
        this.tokenMap.put(Integer.valueOf(i49), StaticColorDefine.CY_3);
        this.tokenMap.put(Integer.valueOf(i50), StaticColorDefine.CY_4);
        HashMap<String, Integer> hashMap51 = this.colorMap;
        int i51 = R.color.co_1;
        hashMap51.put(StaticColorDefine.CO_1, Integer.valueOf(resources.getColor(i51)));
        HashMap<String, Integer> hashMap52 = this.colorMap;
        int i52 = R.color.co_2;
        hashMap52.put(StaticColorDefine.CO_2, Integer.valueOf(resources.getColor(i52)));
        HashMap<String, Integer> hashMap53 = this.colorMap;
        int i53 = R.color.co_3;
        hashMap53.put(StaticColorDefine.CO_3, Integer.valueOf(resources.getColor(i53)));
        HashMap<String, Integer> hashMap54 = this.colorMap;
        int i54 = R.color.co_4;
        hashMap54.put(StaticColorDefine.CO_4, Integer.valueOf(resources.getColor(i54)));
        HashMap<String, Integer> hashMap55 = this.colorMap;
        int i55 = R.color.co_5;
        hashMap55.put(StaticColorDefine.CO_5, Integer.valueOf(resources.getColor(i55)));
        HashMap<String, Integer> hashMap56 = this.colorMap;
        int i56 = R.color.co_6;
        hashMap56.put(StaticColorDefine.CO_6, Integer.valueOf(resources.getColor(i56)));
        HashMap<String, Integer> hashMap57 = this.colorMap;
        int i57 = R.color.co_7;
        hashMap57.put(StaticColorDefine.CO_7, Integer.valueOf(resources.getColor(i57)));
        HashMap<String, Integer> hashMap58 = this.colorMap;
        int i58 = R.color.co_8;
        hashMap58.put(StaticColorDefine.CO_8, Integer.valueOf(resources.getColor(i58)));
        HashMap<String, Integer> hashMap59 = this.colorMap;
        int i59 = R.color.co_9;
        hashMap59.put(StaticColorDefine.CO_9, Integer.valueOf(resources.getColor(i59)));
        HashMap<String, Integer> hashMap60 = this.colorMap;
        int i60 = R.color.co_10;
        hashMap60.put(StaticColorDefine.CO_10, Integer.valueOf(resources.getColor(i60)));
        HashMap<String, Integer> hashMap61 = this.colorMap;
        int i61 = R.color.co_11;
        hashMap61.put(StaticColorDefine.CO_11, Integer.valueOf(resources.getColor(i61)));
        HashMap<String, Integer> hashMap62 = this.colorMap;
        int i62 = R.color.co_12;
        hashMap62.put(StaticColorDefine.CO_12, Integer.valueOf(resources.getColor(i62)));
        this.tokenMap.put(Integer.valueOf(i51), StaticColorDefine.CO_1);
        this.tokenMap.put(Integer.valueOf(i52), StaticColorDefine.CO_2);
        this.tokenMap.put(Integer.valueOf(i53), StaticColorDefine.CO_3);
        this.tokenMap.put(Integer.valueOf(i54), StaticColorDefine.CO_4);
        this.tokenMap.put(Integer.valueOf(i55), StaticColorDefine.CO_5);
        this.tokenMap.put(Integer.valueOf(i56), StaticColorDefine.CO_6);
        this.tokenMap.put(Integer.valueOf(i57), StaticColorDefine.CO_7);
        this.tokenMap.put(Integer.valueOf(i58), StaticColorDefine.CO_8);
        this.tokenMap.put(Integer.valueOf(i59), StaticColorDefine.CO_9);
        this.tokenMap.put(Integer.valueOf(i60), StaticColorDefine.CO_10);
        this.tokenMap.put(Integer.valueOf(i61), StaticColorDefine.CO_11);
        this.tokenMap.put(Integer.valueOf(i62), StaticColorDefine.CO_12);
        HashMap<String, Integer> hashMap63 = this.colorMap;
        int i63 = R.color.ykn_primary_background;
        hashMap63.put(DynamicColorDefine.YKN_PRIMARY_BACKGROUND, Integer.valueOf(resources.getColor(i63)));
        HashMap<String, Integer> hashMap64 = this.colorMap;
        int i64 = R.color.ykn_secondary_background;
        hashMap64.put(DynamicColorDefine.YKN_SECONDARY_BACKGROUND, Integer.valueOf(resources.getColor(i64)));
        HashMap<String, Integer> hashMap65 = this.colorMap;
        int i65 = R.color.ykn_tertiary_background;
        hashMap65.put(DynamicColorDefine.YKN_TERTIARY_BACKGROUND, Integer.valueOf(resources.getColor(i65)));
        HashMap<String, Integer> hashMap66 = this.colorMap;
        int i66 = R.color.ykn_quaternary_background;
        hashMap66.put(DynamicColorDefine.YKN_QUATERNARY_BACKGROUND, Integer.valueOf(resources.getColor(i66)));
        HashMap<String, Integer> hashMap67 = this.colorMap;
        int i67 = R.color.ykn_elevated_primary_background;
        hashMap67.put(DynamicColorDefine.YKN_ELEVATED_PRIMARY_BACKGROUND, Integer.valueOf(resources.getColor(i67)));
        HashMap<String, Integer> hashMap68 = this.colorMap;
        int i68 = R.color.ykn_elevated_secondary_background;
        hashMap68.put(DynamicColorDefine.YKN_ELEVATED_SECONDARY_BACKGROUND, Integer.valueOf(resources.getColor(i68)));
        HashMap<String, Integer> hashMap69 = this.colorMap;
        int i69 = R.color.ykn_elevated_tertiary_background;
        hashMap69.put(DynamicColorDefine.YKN_ELEVATED_TERTIARY_BACKGROUND, Integer.valueOf(resources.getColor(i69)));
        HashMap<String, Integer> hashMap70 = this.colorMap;
        int i70 = R.color.ykn_kid_primary_background;
        hashMap70.put(DynamicColorDefine.YKN_KID_PRIMARY_BACKGROUND, Integer.valueOf(resources.getColor(i70)));
        this.tokenMap.put(Integer.valueOf(i63), DynamicColorDefine.YKN_PRIMARY_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i64), DynamicColorDefine.YKN_SECONDARY_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i65), DynamicColorDefine.YKN_TERTIARY_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i66), DynamicColorDefine.YKN_QUATERNARY_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i67), DynamicColorDefine.YKN_ELEVATED_PRIMARY_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i68), DynamicColorDefine.YKN_ELEVATED_SECONDARY_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i69), DynamicColorDefine.YKN_ELEVATED_TERTIARY_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i70), DynamicColorDefine.YKN_KID_PRIMARY_BACKGROUND);
        HashMap<String, Integer> hashMap71 = this.colorMap;
        int i71 = R.color.ykn_primary_info;
        hashMap71.put(DynamicColorDefine.YKN_PRIMARY_INFO, Integer.valueOf(resources.getColor(i71)));
        HashMap<String, Integer> hashMap72 = this.colorMap;
        int i72 = R.color.ykn_secondary_info;
        hashMap72.put(DynamicColorDefine.YKN_SECONDARY_INFO, Integer.valueOf(resources.getColor(i72)));
        HashMap<String, Integer> hashMap73 = this.colorMap;
        int i73 = R.color.ykn_tertiary_info;
        hashMap73.put(DynamicColorDefine.YKN_TERTIARY_INFO, Integer.valueOf(resources.getColor(i73)));
        HashMap<String, Integer> hashMap74 = this.colorMap;
        int i74 = R.color.ykn_quaternary_info;
        hashMap74.put(DynamicColorDefine.YKN_QUATERNARY_INFO, Integer.valueOf(resources.getColor(i74)));
        HashMap<String, Integer> hashMap75 = this.colorMap;
        int i75 = R.color.ykn_primary_like_info;
        hashMap75.put(DynamicColorDefine.YKN_PRIMARY_LIKE_INFO, Integer.valueOf(resources.getColor(i75)));
        HashMap<String, Integer> hashMap76 = this.colorMap;
        int i76 = R.color.ykn_study_primary_info;
        hashMap76.put(DynamicColorDefine.YKN_STUDY_PRIMARY_INFO, Integer.valueOf(resources.getColor(i76)));
        HashMap<String, Integer> hashMap77 = this.colorMap;
        int i77 = R.color.ykn_study_secondary_info;
        hashMap77.put(DynamicColorDefine.YKN_STUDY_SECONDARY_INFO, Integer.valueOf(resources.getColor(i77)));
        HashMap<String, Integer> hashMap78 = this.colorMap;
        int i78 = R.color.ykn_personal_center_vipcards;
        hashMap78.put(DynamicColorDefine.YKN_PERSONAL_CENTER_VIPCARDS, Integer.valueOf(resources.getColor(i78)));
        this.tokenMap.put(Integer.valueOf(i71), DynamicColorDefine.YKN_PRIMARY_INFO);
        this.tokenMap.put(Integer.valueOf(i72), DynamicColorDefine.YKN_SECONDARY_INFO);
        this.tokenMap.put(Integer.valueOf(i73), DynamicColorDefine.YKN_TERTIARY_INFO);
        this.tokenMap.put(Integer.valueOf(i74), DynamicColorDefine.YKN_QUATERNARY_INFO);
        this.tokenMap.put(Integer.valueOf(i75), DynamicColorDefine.YKN_PRIMARY_LIKE_INFO);
        this.tokenMap.put(Integer.valueOf(i76), DynamicColorDefine.YKN_STUDY_PRIMARY_INFO);
        this.tokenMap.put(Integer.valueOf(i77), DynamicColorDefine.YKN_STUDY_SECONDARY_INFO);
        this.tokenMap.put(Integer.valueOf(i78), DynamicColorDefine.YKN_PERSONAL_CENTER_VIPCARDS);
        HashMap<String, Integer> hashMap79 = this.colorMap;
        int i79 = R.color.ykn_navy_blue;
        hashMap79.put(DynamicColorDefine.YKN_NAVY_BLUE, Integer.valueOf(resources.getColor(i79)));
        HashMap<String, Integer> hashMap80 = this.colorMap;
        int i80 = R.color.ykn_figure_info;
        hashMap80.put("ykn_figureInfo", Integer.valueOf(resources.getColor(i80)));
        HashMap<String, Integer> hashMap81 = this.colorMap;
        int i81 = R.color.ykn_primary_grouped_background;
        hashMap81.put(DynamicColorDefine.YKN_PRIMARY_GROUPED_BACKGROUND, Integer.valueOf(resources.getColor(i81)));
        HashMap<String, Integer> hashMap82 = this.colorMap;
        int i82 = R.color.ykn_secondary_grouped_background;
        hashMap82.put(DynamicColorDefine.YKN_SECONDARY_GROUPED_BACKGROUND, Integer.valueOf(resources.getColor(i82)));
        HashMap<String, Integer> hashMap83 = this.colorMap;
        int i83 = R.color.ykn_tertiary_grouped_background;
        hashMap83.put(DynamicColorDefine.YKN_TERTIARY_GROUPED_BACKGROUND, Integer.valueOf(resources.getColor(i83)));
        HashMap<String, Integer> hashMap84 = this.colorMap;
        int i84 = R.color.ykn_elevated_primary_grouped_background;
        hashMap84.put(DynamicColorDefine.YKN_ELEVATED_PRIMARY_GROUPED_BACKGROUND, Integer.valueOf(resources.getColor(i84)));
        HashMap<String, Integer> hashMap85 = this.colorMap;
        int i85 = R.color.ykn_elevated_secondary_grouped_background;
        hashMap85.put(DynamicColorDefine.YKN_ELEVATED_SECONDARY_GROUPED_BACKGROUND, Integer.valueOf(resources.getColor(i85)));
        this.tokenMap.put(Integer.valueOf(i79), DynamicColorDefine.YKN_NAVY_BLUE);
        this.tokenMap.put(Integer.valueOf(i80), "ykn_figureInfo");
        this.tokenMap.put(Integer.valueOf(i81), DynamicColorDefine.YKN_PRIMARY_GROUPED_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i82), DynamicColorDefine.YKN_SECONDARY_GROUPED_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i83), DynamicColorDefine.YKN_TERTIARY_GROUPED_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i84), DynamicColorDefine.YKN_ELEVATED_PRIMARY_GROUPED_BACKGROUND);
        this.tokenMap.put(Integer.valueOf(i85), DynamicColorDefine.YKN_ELEVATED_SECONDARY_GROUPED_BACKGROUND);
        HashMap<String, Integer> hashMap86 = this.colorMap;
        int i86 = R.color.ykn_primary_fill_color;
        hashMap86.put(DynamicColorDefine.YKN_PRIMARY_FILL_COLOR, Integer.valueOf(resources.getColor(i86)));
        HashMap<String, Integer> hashMap87 = this.colorMap;
        int i87 = R.color.ykn_secondary_fill_color;
        hashMap87.put(DynamicColorDefine.YKN_SECONDARY_FILL_COLOR, Integer.valueOf(resources.getColor(i87)));
        HashMap<String, Integer> hashMap88 = this.colorMap;
        int i88 = R.color.ykn_tertiary_fill_color;
        hashMap88.put(DynamicColorDefine.YKN_TERTIARY_FILL_COLOR, Integer.valueOf(resources.getColor(i88)));
        HashMap<String, Integer> hashMap89 = this.colorMap;
        int i89 = R.color.ykn_quaternary_fill_color;
        hashMap89.put(DynamicColorDefine.YKN_QUATERNARY_FILL_COLOR, Integer.valueOf(resources.getColor(i89)));
        HashMap<String, Integer> hashMap90 = this.colorMap;
        int i90 = R.color.ykn_black_navigation_bar;
        hashMap90.put(DynamicColorDefine.YKN_BLACK_NAVIGATION_BAR, Integer.valueOf(resources.getColor(i90)));
        HashMap<String, Integer> hashMap91 = this.colorMap;
        int i91 = R.color.ykn_white_navigation_bar;
        hashMap91.put(DynamicColorDefine.YKN_WHITE_NAVIGATION_BAR, Integer.valueOf(resources.getColor(i91)));
        HashMap<String, Integer> hashMap92 = this.colorMap;
        int i92 = R.color.ykn_violet;
        hashMap92.put(DynamicColorDefine.YKN_VIOLET, Integer.valueOf(resources.getColor(i92)));
        HashMap<String, Integer> hashMap93 = this.colorMap;
        int i93 = R.color.ykn_personal_center_vipcard;
        hashMap93.put(DynamicColorDefine.YKN_PERSONAL_CENTER_VIPCARD, Integer.valueOf(resources.getColor(i93)));
        HashMap<String, Integer> hashMap94 = this.colorMap;
        int i94 = R.color.ykn_elevated_icon_fill_color;
        hashMap94.put(DynamicColorDefine.YKN_ELEVATED_ICON_FILL_COLOR, Integer.valueOf(resources.getColor(i94)));
        HashMap<String, Integer> hashMap95 = this.colorMap;
        int i95 = R.color.ykn_header_screen;
        hashMap95.put(DynamicColorDefine.YKN_HEADER_SCREEN, Integer.valueOf(resources.getColor(i95)));
        this.colorMap.put("ykn_figureInfo", Integer.valueOf(resources.getColor(i80)));
        HashMap<String, Integer> hashMap96 = this.colorMap;
        int i96 = R.color.ykn_toptabHighlight;
        hashMap96.put(DynamicColorDefine.YKN_TOPTABHIGHLIGHT, Integer.valueOf(resources.getColor(i96)));
        this.tokenMap.put(Integer.valueOf(i92), DynamicColorDefine.YKN_VIOLET);
        this.tokenMap.put(Integer.valueOf(i93), DynamicColorDefine.YKN_PERSONAL_CENTER_VIPCARD);
        this.tokenMap.put(Integer.valueOf(i86), DynamicColorDefine.YKN_PRIMARY_FILL_COLOR);
        this.tokenMap.put(Integer.valueOf(i87), DynamicColorDefine.YKN_SECONDARY_FILL_COLOR);
        this.tokenMap.put(Integer.valueOf(i88), DynamicColorDefine.YKN_TERTIARY_FILL_COLOR);
        this.tokenMap.put(Integer.valueOf(i89), DynamicColorDefine.YKN_QUATERNARY_FILL_COLOR);
        this.tokenMap.put(Integer.valueOf(i90), DynamicColorDefine.YKN_BLACK_NAVIGATION_BAR);
        this.tokenMap.put(Integer.valueOf(i91), DynamicColorDefine.YKN_WHITE_NAVIGATION_BAR);
        this.tokenMap.put(Integer.valueOf(i94), DynamicColorDefine.YKN_ELEVATED_ICON_FILL_COLOR);
        this.tokenMap.put(Integer.valueOf(i95), DynamicColorDefine.YKN_HEADER_SCREEN);
        this.tokenMap.put(Integer.valueOf(i80), "ykn_figureInfo");
        this.tokenMap.put(Integer.valueOf(i96), DynamicColorDefine.YKN_TOPTABHIGHLIGHT);
        HashMap<String, Integer> hashMap97 = this.colorMap;
        int i97 = R.color.ykn_deep_blue_gradient_top_point;
        hashMap97.put(DynamicColorDefine.YKN_DEEP_BLUE_GRADIENT_TOP_POINT, Integer.valueOf(resources.getColor(i97)));
        HashMap<String, Integer> hashMap98 = this.colorMap;
        int i98 = R.color.ykn_deep_blue_gradient_middle_point;
        hashMap98.put(DynamicColorDefine.YKN_DEEP_BLUE_GRADIENT_MIDDLE_POINT, Integer.valueOf(resources.getColor(i98)));
        HashMap<String, Integer> hashMap99 = this.colorMap;
        int i99 = R.color.ykn_deep_blue_gradient_bottom_point;
        hashMap99.put(DynamicColorDefine.YKN_DEEP_BLUE_GRADIENT_BOTTOM_POINT, Integer.valueOf(resources.getColor(i99)));
        HashMap<String, Integer> hashMap100 = this.colorMap;
        int i100 = R.color.ykn_single_line_deep_blue_gradient_bottom_point;
        hashMap100.put(DynamicColorDefine.YKN_SINGLE_LINE_DEEP_BLUE_GRADIENT_BOTTOM_POINT, Integer.valueOf(resources.getColor(i100)));
        HashMap<String, Integer> hashMap101 = this.colorMap;
        int i101 = R.color.ykn_deep_black_gradient_top_point;
        hashMap101.put(DynamicColorDefine.YKN_DEEP_BLACK_GRADIENT_TOP_POINT, Integer.valueOf(resources.getColor(i101)));
        HashMap<String, Integer> hashMap102 = this.colorMap;
        int i102 = R.color.ykn_deep_black_gradient_middle_point;
        hashMap102.put(DynamicColorDefine.YKN_DEEP_BLACK_GRADIENT_MIDDLE_POINT, Integer.valueOf(resources.getColor(i102)));
        HashMap<String, Integer> hashMap103 = this.colorMap;
        int i103 = R.color.ykn_deep_black_gradient_bottom_point;
        hashMap103.put(DynamicColorDefine.YKN_DEEP_BLACK_GRADIENT_BOTTOM_POINT, Integer.valueOf(resources.getColor(i103)));
        this.tokenMap.put(Integer.valueOf(i97), DynamicColorDefine.YKN_DEEP_BLUE_GRADIENT_TOP_POINT);
        this.tokenMap.put(Integer.valueOf(i98), DynamicColorDefine.YKN_DEEP_BLUE_GRADIENT_MIDDLE_POINT);
        this.tokenMap.put(Integer.valueOf(i99), DynamicColorDefine.YKN_DEEP_BLUE_GRADIENT_BOTTOM_POINT);
        this.tokenMap.put(Integer.valueOf(i100), DynamicColorDefine.YKN_SINGLE_LINE_DEEP_BLUE_GRADIENT_BOTTOM_POINT);
        this.tokenMap.put(Integer.valueOf(i101), DynamicColorDefine.YKN_DEEP_BLACK_GRADIENT_TOP_POINT);
        this.tokenMap.put(Integer.valueOf(i102), DynamicColorDefine.YKN_DEEP_BLACK_GRADIENT_MIDDLE_POINT);
        this.tokenMap.put(Integer.valueOf(i103), DynamicColorDefine.YKN_DEEP_BLACK_GRADIENT_BOTTOM_POINT);
        HashMap<String, Integer> hashMap104 = this.colorMap;
        int i104 = R.color.ykn_header_downgrade_color;
        hashMap104.put(DynamicColorDefine.YKN_HEADER_DOWNGRADE_COLOR, Integer.valueOf(resources.getColor(i104)));
        HashMap<String, Integer> hashMap105 = this.colorMap;
        int i105 = R.color.ykn_blackshade;
        hashMap105.put(DynamicColorDefine.YKN_BLACKSHADE, Integer.valueOf(resources.getColor(i105)));
        HashMap<String, Integer> hashMap106 = this.colorMap;
        int i106 = R.color.ykn_separator;
        hashMap106.put(DynamicColorDefine.YKN_SEPARATOR, Integer.valueOf(resources.getColor(i106)));
        HashMap<String, Integer> hashMap107 = this.colorMap;
        int i107 = R.color.ykn_seconary_separator;
        hashMap107.put(DynamicColorDefine.YKN_SECONARY_SEPARATOR, Integer.valueOf(resources.getColor(i107)));
        this.colorMap.put(DynamicColorDefine.YKN_HIDE_ABLE_SEPARATOR, Integer.valueOf(resources.getColor(R.color.ykn_hide_able_separator)));
        HashMap<String, Integer> hashMap108 = this.colorMap;
        int i108 = R.color.ykn_belt;
        hashMap108.put(DynamicColorDefine.YKN_BELT, Integer.valueOf(resources.getColor(i108)));
        HashMap<String, Integer> hashMap109 = this.colorMap;
        int i109 = R.color.ykn_outline;
        hashMap109.put(DynamicColorDefine.YKN_OUTLINE, Integer.valueOf(resources.getColor(i109)));
        HashMap<String, Integer> hashMap110 = this.colorMap;
        int i110 = R.color.ykn_progress_bar_background_color;
        hashMap110.put(DynamicColorDefine.YKN_PROGESS_BAR_BACKGROUND_COLOR, Integer.valueOf(resources.getColor(i110)));
        HashMap<String, Integer> hashMap111 = this.colorMap;
        int i111 = R.color.ykn_disabled_accent_color;
        hashMap111.put(DynamicColorDefine.YKN_DISABLE_ACCENT_COLOR, Integer.valueOf(resources.getColor(i111)));
        this.tokenMap.put(Integer.valueOf(i104), DynamicColorDefine.YKN_HEADER_DOWNGRADE_COLOR);
        this.tokenMap.put(Integer.valueOf(i105), DynamicColorDefine.YKN_BLACKSHADE);
        this.tokenMap.put(Integer.valueOf(i106), DynamicColorDefine.YKN_SEPARATOR);
        this.tokenMap.put(Integer.valueOf(i107), DynamicColorDefine.YKN_SECONARY_SEPARATOR);
        this.tokenMap.put(Integer.valueOf(i108), DynamicColorDefine.YKN_BELT);
        this.tokenMap.put(Integer.valueOf(i109), DynamicColorDefine.YKN_OUTLINE);
        this.tokenMap.put(Integer.valueOf(i110), DynamicColorDefine.YKN_PROGESS_BAR_BACKGROUND_COLOR);
        this.tokenMap.put(Integer.valueOf(i111), DynamicColorDefine.YKN_DISABLE_ACCENT_COLOR);
        Log.d(TAG, "updateColorPalette end " + getColorMapLikeStringVaule());
    }

    public int getColorIntWithAlpha(String str, int i) {
        int intValue = this.colorMap.get(str).intValue();
        return i == 0 ? intValue : getColorIntWithAlpha(intValue, i);
    }

    public HashMap<String, Integer> getColorMap() {
        return this.colorMap;
    }

    public String getColorMapLikeStringVaule() {
        int intValue;
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Integer> entry : this.colorMap.entrySet()) {
            float intValue2 = (entry.getValue().intValue() >> 24) & 255;
            jSONObject.put(entry.getKey(), (Object) ("rgba(" + ((16711680 & intValue) >> 16) + "," + ((65280 & intValue) >> 8) + "," + (intValue & 255) + "," + (intValue2 == -1.0f ? 1.0f : intValue2 / 255.0f) + jn1.BRACKET_END_STR));
        }
        return jSONObject.toJSONString();
    }

    public String getColorStringWithAlpha(String str, int i) {
        int intValue = this.colorMap.get(str).intValue();
        if (i == 0) {
            return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + Integer.toHexString(intValue);
        }
        return getColorStringWithAlpha(intValue, i);
    }

    public String getTokenFromColorId(int i) {
        return this.tokenMap.get(Integer.valueOf(i));
    }

    public void onConfigureChanged() {
        updateColorPalette();
    }

    private int getColorIntWithAlpha(int i, int i2) {
        int i3 = 255 - ((i2 * 255) / 100);
        if (i2 != 100) {
            return i ^ (i3 << 24);
        }
        return 0;
    }

    public static ColorConfigureManager getInstance(Context context2) {
        HashMap<String, Integer> hashMap;
        context = context2;
        ColorConfigureManager colorConfigureManager = ourInstance;
        if (colorConfigureManager != null && (hashMap = colorConfigureManager.colorMap) != null && hashMap.size() == 0) {
            colorConfigureManager.updateColorPalette();
        }
        return colorConfigureManager;
    }

    private String getColorStringWithAlpha(int i, int i2) {
        if (i2 != 100) {
            return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + Integer.toHexString(getColorIntWithAlpha(i, i2));
        }
        return "#00FFFFFF";
    }
}
