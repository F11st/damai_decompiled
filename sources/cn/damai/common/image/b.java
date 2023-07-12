package cn.damai.common.image;

import android.net.NetworkInfo;
import android.text.TextUtils;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.image.DMImageStrategyConfig;
import cn.damai.h5container.H5MainActivity;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.ui.WebConstant;
import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alimm.xadsdk.base.constant.AdConstants;
import com.alipay.sdk.m.u.n;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.MsgID;
import com.youku.alixplayer.util.PlaybackParamKey;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import com.youku.passport.libs.BuildConfig;
import com.youku.resource.widget.PlayerGuideTipsView;
import com.youku.uplayer.AliMediaPlayer;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String IMAGE_TO_WEBP = "damai_webp";
    public static int[][] a = {new int[]{16, 16}, new int[]{20, 20}, new int[]{24, 24}, new int[]{30, 30}, new int[]{32, 32}, new int[]{36, 36}, new int[]{40, 40}, new int[]{48, 48}, new int[]{50, 50}, new int[]{60, 30}, new int[]{60, 60}, new int[]{60, 90}, new int[]{64, 64}, new int[]{70, 70}, new int[]{70, 1000}, new int[]{72, 72}, new int[]{75, 75}, new int[]{75, 100}, new int[]{80, 40}, new int[]{80, 60}, new int[]{80, 65}, new int[]{81, 65}, new int[]{80, 80}, new int[]{80, 1000}, new int[]{88, 88}, new int[]{90, 45}, new int[]{90, 60}, new int[]{90, 90}, new int[]{90, 135}, new int[]{96, 54}, new int[]{100, 50}, new int[]{100, 75}, new int[]{100, 100}, new int[]{100, 150}, new int[]{100, 1000}, new int[]{110, 90}, new int[]{110, 110}, new int[]{110, 10000}, new int[]{115, 100}, new int[]{120, 60}, new int[]{120, 97}, new int[]{120, 90}, new int[]{120, 120}, new int[]{120, 160}, new int[]{121, 75}, new int[]{125, 125}, new int[]{128, 128}, new int[]{130, 130}, new int[]{135, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{140, 70}, new int[]{140, 100}, new int[]{140, 140}, new int[]{140, 10000}, new int[]{142, 142}, new int[]{145, 145}, new int[]{150, 150}, new int[]{150, 200}, new int[]{150, 10000}, new int[]{157, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{160, 80}, new int[]{160, 90}, new int[]{160, 130}, new int[]{160, 160}, new int[]{160, 180}, new int[]{160, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{165, 5000}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 10000}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 120}, new int[]{180, 90}, new int[]{180, 180}, new int[]{180, PlayerGuideTipsView.ANIM_DURATION_ALPHA}, new int[]{AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, 43}, new int[]{AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH}, new int[]{196, 196}, new int[]{200, 100}, new int[]{200, 200}, new int[]{200, 162}, new int[]{210, 140}, new int[]{210, 210}, new int[]{210, 1000}, new int[]{220, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD}, new int[]{220, 220}, new int[]{220, 330}, new int[]{220, 5000}, new int[]{220, 10000}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 5000}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, 87}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, PlayerGuideTipsView.ANIM_DURATION_ALPHA}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, 10000}, new int[]{234, 234}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 180}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, BuildConfig.VERSION_CODE}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 5000}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 10000}, new int[]{250, 225}, new int[]{250, 250}, new int[]{H5MainActivity.REQUEST_REALNAME, SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE}, new int[]{H5MainActivity.REQUEST_REALNAME, H5MainActivity.REQUEST_REALNAME}, new int[]{WebConstant.OPEN_WEB_LOGIN_IV_REQCODE, 100}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 180}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 450}, new int[]{ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, 192}, new int[]{ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, 410}, new int[]{284, 284}, new int[]{288, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{290, 290}, new int[]{290, 10000}, new int[]{292, 292}, new int[]{294, 430}, new int[]{300, 1000}, new int[]{300, 10000}, new int[]{310, 310}, new int[]{312, 312}, new int[]{300, 300}, new int[]{315, 315}, new int[]{320, H5MainActivity.REQUEST_REALNAME}, new int[]{320, 320}, new int[]{320, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{320, 5000}, new int[]{336, 336}, new int[]{350, 350}, new int[]{350, 1000}, new int[]{PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH, PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH}, new int[]{360, 234}, new int[]{360, 360}, new int[]{360, 10000}, new int[]{375, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{375, 375}, new int[]{400, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR}, new int[]{400, 200}, new int[]{400, 400}, new int[]{420, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{430, 430}, new int[]{438, 438}, new int[]{440, 440}, new int[]{450, 300}, new int[]{450, 600}, new int[]{450, 5000}, new int[]{450, 10000}, new int[]{n.g, n.g}, new int[]{468, 468}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, 420}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{485, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_LOADING_FACTOR_STEP}, new int[]{490, 330}, new int[]{490, 490}, new int[]{500, 375}, new int[]{500, 450}, new int[]{500, 500}, new int[]{500, 1000}, new int[]{540, 540}, new int[]{560, AdConstants.TEMPLATE_LONG_VIDEO_INTERACTION}, new int[]{560, 560}, new int[]{560, 840}, new int[]{568, 568}, new int[]{570, 570}, new int[]{570, 10000}, new int[]{580, 580}, new int[]{580, 10000}, new int[]{600, 600}, new int[]{600, 800}, new int[]{620, 10000}, new int[]{640, 360}, new int[]{640, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{640, 640}, new int[]{660, 440}, new int[]{667, 667}, new int[]{670, 670}, new int[]{LoginConstant.RESULT_WINDWANE_CLOSEW, LoginConstant.RESULT_WINDWANE_CLOSEW}, new int[]{728, 728}, new int[]{FeatureFactory.PRIORITY_ABOVE_NORMAL, 388}, new int[]{FeatureFactory.PRIORITY_ABOVE_NORMAL, 1000}, new int[]{760, 760}, new int[]{790, 420}, new int[]{790, 10000}, new int[]{800, 800}, new int[]{960, 960}, new int[]{970, 970}, new int[]{1080, 1800}, new int[]{1136, 1136}, new int[]{1152, 1920}, new int[]{1200, 1200}, new int[]{1280, 960}, new int[]{1280, 1280}, new int[]{2200, 2200}, new int[]{10000, 220}, new int[]{10000, MsgID.TYPE_MSG_BEGIN_PLAYBACK}, new int[]{10000, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}, new int[]{10000, 500}};

    private static int[] a(int i, int i2, boolean z) {
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091809319")) {
            return (int[]) ipChange.ipc$dispatch("1091809319", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        }
        if (i < 0 || i2 < 0) {
            return new int[]{i, i2};
        }
        if (z) {
            float f = i;
            float f2 = i2;
            float max = Math.max(f / 4096.0f, f2 / 4096.0f);
            return max > 1.0f ? new int[]{Math.min(4096, (int) (f / max)), Math.min(4096, (int) (f2 / max))} : new int[]{i, i2};
        }
        int i4 = Integer.MAX_VALUE;
        int[][] iArr = a;
        int length = iArr == null ? 0 : iArr.length;
        int i5 = -100;
        int i6 = -100;
        for (int i7 = 0; i7 < length; i7++) {
            int[][] iArr2 = a;
            int i8 = iArr2[i7][0];
            int i9 = iArr2[i7][1];
            if (i8 >= i && i9 >= i2 && (i3 = i8 * i9) < i4) {
                i6 = i9;
                i5 = i8;
                i4 = i3;
            }
        }
        return new int[]{i5, i6};
    }

    public static DMImageStrategyConfig b(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-941823884")) {
            return (DMImageStrategyConfig) ipChange.ipc$dispatch("-941823884", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (!e() || TextUtils.isEmpty(str) || str.contains(".gif")) {
            return null;
        }
        if (str.contains(".alicdn.com") || str.contains(".aliyun-inc.com") || str.contains(".aliyuncs.com")) {
            boolean z = str.contains(".aliyun-inc.com") || str.contains(".aliyuncs.com");
            DMImageStrategyConfig dMImageStrategyConfig = new DMImageStrategyConfig();
            dMImageStrategyConfig.i = "default";
            int[] a2 = a(i, i2, z);
            if (a2[0] > 0 && a2[1] > 0) {
                dMImageStrategyConfig.h = a2[0];
                dMImageStrategyConfig.g = a2[1];
            }
            dMImageStrategyConfig.b = true;
            dMImageStrategyConfig.a = true;
            dMImageStrategyConfig.c = false;
            dMImageStrategyConfig.f = true;
            return dMImageStrategyConfig;
        }
        return null;
    }

    public static String c(String str, DMImageStrategyConfig dMImageStrategyConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058618550")) {
            return (String) ipChange.ipc$dispatch("1058618550", new Object[]{str, dMImageStrategyConfig});
        }
        if (!e() || TextUtils.isEmpty(str) || str.startsWith("res://") || str.startsWith("file://") || str.startsWith("asset://")) {
            return str;
        }
        String b = OrangeConfigCenter.c().b("damai_webp", "blackListHost", "");
        if (!TextUtils.isEmpty(b)) {
            if (b.contains(",")) {
                String[] split = b.split(",");
                int length = split == null ? 0 : split.length;
                for (int i = 0; i < length; i++) {
                    if (str.contains(split[i])) {
                        return str;
                    }
                }
            } else if (str.contains(b)) {
                return str;
            }
        }
        if (str.contains(".alicdn.com")) {
            return g(str, dMImageStrategyConfig);
        }
        return (str.contains(".aliyun-inc.com") || str.contains(".aliyuncs.com")) ? h(str, dMImageStrategyConfig) : str;
    }

    public static boolean d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402704926")) {
            return ((Boolean) ipChange.ipc$dispatch("402704926", new Object[]{str})).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && str.contains(".alicdn.com")) {
            String substring = str.substring(str.lastIndexOf("/"));
            return (substring.contains(".png_") || substring.contains(".jpeg_") || substring.contains(".jpg_") || substring.contains(".gif")) ? false : true;
        }
        return false;
    }

    public static boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2120356299") ? ((Boolean) ipChange.ipc$dispatch("-2120356299", new Object[0])).booleanValue() : "1".equals(OrangeConfigCenter.c().b("damai_webp", "openImageOpt", "0"));
    }

    private static boolean f() {
        NetworkInfo activeNetworkInfo;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1235901438") ? ((Boolean) ipChange.ipc$dispatch("-1235901438", new Object[0])).booleanValue() : (mu0.a() == null || (activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) mu0.a().getSystemService("connectivity"))) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }

    private static String g(String str, DMImageStrategyConfig dMImageStrategyConfig) {
        DMImageStrategyConfig.DMImageCropType dMImageCropType;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587795062")) {
            return (String) ipChange.ipc$dispatch("-587795062", new Object[]{str, dMImageStrategyConfig});
        }
        StringBuilder sb = new StringBuilder(str);
        String substring = str.substring(str.lastIndexOf("/"));
        if (substring.contains(".png_") || substring.contains(".jpeg_") || substring.contains(".jpg_") || substring.contains(".gif")) {
            return str;
        }
        int[] a2 = a(dMImageStrategyConfig.h, dMImageStrategyConfig.g, false);
        sb.append(JSMethod.NOT_SET);
        if (a2[0] > 0 && a2[1] > 0) {
            sb.append(a2[0]);
            sb.append(Constants.Name.X);
            sb.append(a2[1]);
        }
        String str3 = "";
        if (dMImageStrategyConfig.c && (dMImageCropType = dMImageStrategyConfig.d) != null) {
            if (dMImageCropType.equals(DMImageStrategyConfig.DMImageCropType.cy500)) {
                str2 = "cy500i";
            } else {
                str2 = dMImageStrategyConfig.d.equals(DMImageStrategyConfig.DMImageCropType.cy100) ? "cy100i" : "";
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
                sb.append(dMImageStrategyConfig.e);
            }
        }
        if (dMImageStrategyConfig.f) {
            DMImageStrategyConfig.DMImageQuality dMImageQuality = dMImageStrategyConfig.j;
            if (dMImageQuality != null) {
                if (dMImageQuality.equals(DMImageStrategyConfig.DMImageQuality.q90)) {
                    str3 = "q90";
                } else if (dMImageStrategyConfig.j.equals(DMImageStrategyConfig.DMImageQuality.q75)) {
                    str3 = "q75";
                } else if (dMImageStrategyConfig.j.equals(DMImageStrategyConfig.DMImageQuality.q60)) {
                    str3 = "q60";
                } else if (dMImageStrategyConfig.j.equals(DMImageStrategyConfig.DMImageQuality.q50)) {
                    str3 = "q50";
                } else if (dMImageStrategyConfig.j.equals(DMImageStrategyConfig.DMImageQuality.q30)) {
                    str3 = "q30";
                }
            } else if (f()) {
                str3 = OrangeConfigCenter.c().b("damai_webp", "highNetQ", "q90");
            } else {
                str3 = OrangeConfigCenter.c().b("damai_webp", "lowNetQ", "q75");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb.append(str3);
            }
        }
        if (dMImageStrategyConfig.b) {
            if (f()) {
                sb.append(OrangeConfigCenter.c().b("damai_webp", "highNetSharpen", "s150"));
            } else {
                sb.append(OrangeConfigCenter.c().b("damai_webp", "lowNetSharpen", "s150"));
            }
        }
        sb.append(".jpg");
        if (dMImageStrategyConfig.a) {
            sb.append("_.webp");
        }
        return sb.toString();
    }

    private static String h(String str, DMImageStrategyConfig dMImageStrategyConfig) {
        String format;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-853528056")) {
            return (String) ipChange.ipc$dispatch("-853528056", new Object[]{str, dMImageStrategyConfig});
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("x-oss-process=") || str.contains(".gif")) {
            return str;
        }
        sb.append("?x-oss-process=image");
        int[] a2 = a(dMImageStrategyConfig.h, dMImageStrategyConfig.g, true);
        if (a2[0] > 0 && a2[1] > 0) {
            sb.append("/resize");
            sb.append(",");
            sb.append("w_");
            sb.append(a2[0]);
            sb.append(",");
            sb.append("h_");
            sb.append(a2[1]);
        }
        if (dMImageStrategyConfig.f) {
            DMImageStrategyConfig.DMImageQuality dMImageQuality = dMImageStrategyConfig.j;
            if (dMImageQuality != null) {
                if (dMImageQuality.equals(DMImageStrategyConfig.DMImageQuality.q90)) {
                    format = "q_90";
                } else if (dMImageStrategyConfig.j.equals(DMImageStrategyConfig.DMImageQuality.q75)) {
                    format = "q_75";
                } else if (dMImageStrategyConfig.j.equals(DMImageStrategyConfig.DMImageQuality.q60)) {
                    format = "q_60";
                } else if (dMImageStrategyConfig.j.equals(DMImageStrategyConfig.DMImageQuality.q50)) {
                    format = "q_50";
                } else {
                    format = dMImageStrategyConfig.j.equals(DMImageStrategyConfig.DMImageQuality.q30) ? "q_30" : "";
                }
            } else if (f()) {
                String b = OrangeConfigCenter.c().b("damai_webp", "highNetQ", "q90");
                format = String.format("%s_%s", b.substring(0, 1), b.substring(1));
            } else {
                String b2 = OrangeConfigCenter.c().b("damai_webp", "lowNetQ", "q75");
                format = String.format("%s_%s", b2.substring(0, 1), b2.substring(1));
            }
            if (!TextUtils.isEmpty(format)) {
                sb.append("/quality");
                sb.append(",");
                sb.append(format);
            }
        }
        if (dMImageStrategyConfig.b) {
            sb.append("/sharpen");
            sb.append(",");
            if (f()) {
                sb.append(OrangeConfigCenter.c().b("damai_webp", "highNetSharpen", "s150").substring(1));
            } else {
                sb.append(OrangeConfigCenter.c().b("damai_webp", "lowNetSharpen", "s150").substring(1));
            }
        }
        if (dMImageStrategyConfig.a) {
            sb.append("/format,webp");
        }
        return sb.toString();
    }
}
