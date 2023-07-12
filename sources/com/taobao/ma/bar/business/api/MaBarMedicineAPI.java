package com.taobao.ma.bar.business.api;

import com.taobao.ma.analyze.helper.MaAnalyzeHelper;
import com.taobao.ma.bar.business.helper.MaBarBusinessHelper;
import com.taobao.ma.bar.common.constants.MaBarConstants;
import com.taobao.ma.common.usertrack.UTLogger;
import com.taobao.ma.core.Ma;
import com.taobao.ma.util.StringUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaBarMedicineAPI {
    public static String getMedicinePageUrl(String str) {
        if (StringUtils.isEmpty(str) || !MaAnalyzeHelper.isMedicineCode(str)) {
            return null;
        }
        String str2 = Ma.getMaConfig().isDebug ? MaBarConstants.BARCODE_SHOPPING_URL_WAP : MaBarConstants.BARCODE_SHOPPING_URL_OL;
        Map synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        synchronizedMap.putAll(Ma.getUtMap());
        synchronizedMap.put("barcode", str);
        synchronizedMap.put("type", "2");
        UTLogger.userTrack("barcode", str);
        return MaBarBusinessHelper.buildUrl(str2, synchronizedMap);
    }
}
