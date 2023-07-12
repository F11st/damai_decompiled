package com.youku.playerservice.axp.p2p;

import android.content.Context;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.phone.freeflow.YKFreeFlowResult;
import com.youku.phone.freeflow.YoukuFreeFlowApi;
import com.youku.phone.freeflow.model.CarrierType;
import com.youku.playerservice.axp.utils.NetworkUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FreeFlowUtil {
    public static final String FREEFLOWCALLER_DOWNLOAD = "download";
    public static final String FREEFLOWCALLER_FEED = "feed";
    public static final String FREEFLOWCALLER_LIVE = "live";
    public static final String FREEFLOWCALLER_ONDEMAND = "onDemand";
    public static final String FREEFLOWCALLER_P2P = "p2p";
    public static final String FREEFLOWCALLER_SHORTVIDEO = "shortVideo";
    public static boolean isShow4GToast;

    /* compiled from: Taobao */
    /* renamed from: com.youku.playerservice.axp.p2p.FreeFlowUtil$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$phone$freeflow$model$CarrierType;

        static {
            int[] iArr = new int[CarrierType.values().length];
            $SwitchMap$com$youku$phone$freeflow$model$CarrierType = iArr;
            try {
                iArr[CarrierType.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$phone$freeflow$model$CarrierType[CarrierType.UNICOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$phone$freeflow$model$CarrierType[CarrierType.TELECOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static String getFreeFlowType(Context context, String str) {
        YKFreeFlowResult freeFlowResult;
        try {
            if (!NetworkUtil.isConnectedWifi(context) && FeatureManager.getInstance().hasFreeFlow() && (freeFlowResult = YoukuFreeFlowApi.getFreeFlowResult(str)) != null && freeFlowResult.isFreeFlow()) {
                int i = AnonymousClass1.$SwitchMap$com$youku$phone$freeflow$model$CarrierType[freeFlowResult.getCarrierType().ordinal()];
                return i != 1 ? i != 2 ? i != 3 ? "0" : "3" : "2" : "1";
            }
        } catch (Throwable unused) {
        }
        return "0";
    }

    public static boolean isFreeFlow(Context context, String str) {
        if (FeatureManager.getInstance().hasFreeFlow()) {
            return YoukuFreeFlowApi.getFreeFlowResult(str).isFreeFlow();
        }
        return false;
    }
}
