package com.alimm.xadsdk.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.utils.Utils;
import com.alimm.xadsdk.info.GlobalInfoManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alimm.xadsdk.request.builder.PlayerAdRequestInfo;
import com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RequestUtils {
    private static final String TAG = "RequestUtils";

    public static void addVideoInfo(@NonNull PlayerAdRequestInfo playerAdRequestInfo, @NonNull Map<String, String> map) {
        map.put("v", playerAdRequestInfo.getVid());
        map.put(IRequestConst.ISVERT, playerAdRequestInfo.isVert() ? "1" : "0");
    }

    public static Map<String, String> getAdQueryParams(int i, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>(32);
        }
        map.put("site", GlobalInfoManager.getInstance().getPublisherId());
        map.put("p", String.valueOf(i));
        map.put("pid", GlobalInfoManager.getInstance().getPid());
        map.put("aid", GlobalInfoManager.getInstance().getAndroidId());
        map.put("aaid", "");
        map.put("mac", GlobalInfoManager.getInstance().getMacAddress());
        map.put("utdid", Utils.urlEncode(GlobalInfoManager.getInstance().getUtdid()));
        map.put(IRequestConst.OAID, GlobalInfoManager.getInstance().getOaid());
        map.put("net", String.valueOf(Utils.getNetworkType(AdSdkManager.getInstance().getAppContext())));
        map.put(IRequestConst.ISP, Utils.urlEncode(GlobalInfoManager.getInstance().getNetworkOperatorName()));
        map.put(IRequestConst.AW, "a");
        map.put(IRequestConst.MDL, Utils.urlEncode(Build.getMODEL()));
        map.put(IRequestConst.VS, "1.0");
        map.put(IRequestConst.BT, GlobalInfoManager.getInstance().getDeviceType());
        map.put(IRequestConst.BD, Utils.urlEncode(Build.getBRAND()));
        if (i == 7) {
            map.put(IRequestConst.NEED_AD, "1");
            map.put(IRequestConst.NEED_BF, "2");
        }
        map.put("rst", YKLAnimationViewAdapter.TYPE_MP4);
        map.put("ua", Utils.urlEncode(Utils.getDefaultUserAgent()));
        map.put("os", GlobalInfoManager.getInstance().getOsType());
        map.put(IRequestConst.OSV, Utils.urlEncode(Build.VERSION.getRELEASE()));
        map.put(IRequestConst.AVS, GlobalInfoManager.getInstance().getAppVersion());
        map.put(IRequestConst.SVER, GlobalInfoManager.getInstance().getAdSdkVersion());
        map.put("dvh", String.valueOf(GlobalInfoManager.getInstance().getScreenHeight()));
        map.put("dvw", String.valueOf(GlobalInfoManager.getInstance().getScreenWidth()));
        map.put(IRequestConst.IM, GlobalInfoManager.getInstance().getImei());
        map.put(IRequestConst.WINTYPE, "mdevice");
        String previewAdAssetId = GlobalInfoManager.getInstance().getPreviewAdAssetId();
        if (!TextUtils.isEmpty(previewAdAssetId)) {
            map.put(IRequestConst.ADEXT, previewAdAssetId);
        }
        String stoken = GlobalInfoManager.getInstance().getStoken();
        if (i != 7 && stoken != null) {
            map.put(IRequestConst.STOKEN, stoken);
        }
        String ipV4 = GlobalInfoManager.getInstance().getIpV4();
        if (!TextUtils.isEmpty(ipV4)) {
            map.put(IRequestConst.REAL_IPV4, ipV4);
        }
        map.put(IRequestConst.PROTOCOL_VERSION, "2.0");
        return map;
    }
}
