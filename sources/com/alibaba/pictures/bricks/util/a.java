package com.alibaba.pictures.bricks.util;

import android.text.TextUtils;
import cn.damai.h5container.H5MainActivity;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.ui.WebConstant;
import com.alibaba.pictures.bricks.util.DMImageStrategyConfig;
import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
import com.alibaba.wireless.security.SecExceptionCode;
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

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String IMAGE_TO_WEBP = "damai_webp";
    public static int[][] a = {new int[]{16, 16}, new int[]{20, 20}, new int[]{24, 24}, new int[]{30, 30}, new int[]{32, 32}, new int[]{36, 36}, new int[]{40, 40}, new int[]{48, 48}, new int[]{50, 50}, new int[]{60, 30}, new int[]{60, 60}, new int[]{60, 90}, new int[]{64, 64}, new int[]{70, 70}, new int[]{70, 1000}, new int[]{72, 72}, new int[]{75, 75}, new int[]{75, 100}, new int[]{80, 40}, new int[]{80, 60}, new int[]{80, 65}, new int[]{81, 65}, new int[]{80, 80}, new int[]{80, 1000}, new int[]{88, 88}, new int[]{90, 45}, new int[]{90, 60}, new int[]{90, 90}, new int[]{90, 135}, new int[]{96, 54}, new int[]{100, 50}, new int[]{100, 75}, new int[]{100, 100}, new int[]{100, 150}, new int[]{100, 1000}, new int[]{110, 90}, new int[]{110, 110}, new int[]{110, 10000}, new int[]{115, 100}, new int[]{120, 60}, new int[]{120, 97}, new int[]{120, 90}, new int[]{120, 120}, new int[]{120, 160}, new int[]{121, 75}, new int[]{125, 125}, new int[]{128, 128}, new int[]{130, 130}, new int[]{135, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{140, 70}, new int[]{140, 100}, new int[]{140, 140}, new int[]{140, 10000}, new int[]{142, 142}, new int[]{145, 145}, new int[]{150, 150}, new int[]{150, 200}, new int[]{150, 10000}, new int[]{157, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{160, 80}, new int[]{160, 90}, new int[]{160, 130}, new int[]{160, 160}, new int[]{160, 180}, new int[]{160, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{165, 5000}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 10000}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 120}, new int[]{180, 90}, new int[]{180, 180}, new int[]{180, PlayerGuideTipsView.ANIM_DURATION_ALPHA}, new int[]{AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, 43}, new int[]{AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH}, new int[]{196, 196}, new int[]{200, 100}, new int[]{200, 200}, new int[]{200, 162}, new int[]{210, 140}, new int[]{210, 210}, new int[]{210, 1000}, new int[]{220, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD}, new int[]{220, 220}, new int[]{220, 330}, new int[]{220, 5000}, new int[]{220, 10000}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 5000}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, 87}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, PlayerGuideTipsView.ANIM_DURATION_ALPHA}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, 10000}, new int[]{234, 234}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 180}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, BuildConfig.VERSION_CODE}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 5000}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 10000}, new int[]{250, 225}, new int[]{250, 250}, new int[]{H5MainActivity.REQUEST_REALNAME, SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE}, new int[]{H5MainActivity.REQUEST_REALNAME, H5MainActivity.REQUEST_REALNAME}, new int[]{WebConstant.OPEN_WEB_LOGIN_IV_REQCODE, 100}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 180}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 450}, new int[]{ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, 192}, new int[]{ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, 410}, new int[]{284, 284}, new int[]{288, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{290, 290}, new int[]{290, 10000}, new int[]{292, 292}, new int[]{294, 430}, new int[]{300, 1000}, new int[]{300, 10000}, new int[]{310, 310}, new int[]{312, 312}, new int[]{300, 300}, new int[]{315, 315}, new int[]{320, H5MainActivity.REQUEST_REALNAME}, new int[]{320, 320}, new int[]{320, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{320, 5000}, new int[]{336, 336}, new int[]{350, 350}, new int[]{350, 1000}, new int[]{PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH, PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH}, new int[]{360, 234}, new int[]{360, 360}, new int[]{360, 10000}, new int[]{375, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{375, 375}, new int[]{400, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR}, new int[]{400, 200}, new int[]{400, 400}, new int[]{420, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{430, 430}, new int[]{438, 438}, new int[]{440, 440}, new int[]{450, 300}, new int[]{450, 600}, new int[]{450, 5000}, new int[]{450, 10000}, new int[]{n.g, n.g}, new int[]{468, 468}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, 420}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{485, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_LOADING_FACTOR_STEP}, new int[]{490, 330}, new int[]{490, 490}, new int[]{500, 375}, new int[]{500, 450}, new int[]{500, 500}, new int[]{500, 1000}, new int[]{540, 540}, new int[]{560, AdConstants.TEMPLATE_LONG_VIDEO_INTERACTION}, new int[]{560, 560}, new int[]{560, 840}, new int[]{568, 568}, new int[]{570, 570}, new int[]{570, 10000}, new int[]{580, 580}, new int[]{580, 10000}, new int[]{600, 600}, new int[]{600, 800}, new int[]{620, 10000}, new int[]{640, 360}, new int[]{640, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{640, 640}, new int[]{660, 440}, new int[]{667, 667}, new int[]{670, 670}, new int[]{LoginConstant.RESULT_WINDWANE_CLOSEW, LoginConstant.RESULT_WINDWANE_CLOSEW}, new int[]{728, 728}, new int[]{FeatureFactory.PRIORITY_ABOVE_NORMAL, 388}, new int[]{FeatureFactory.PRIORITY_ABOVE_NORMAL, 1000}, new int[]{760, 760}, new int[]{790, 420}, new int[]{790, 10000}, new int[]{800, 800}, new int[]{960, 960}, new int[]{970, 970}, new int[]{1080, 1800}, new int[]{1136, 1136}, new int[]{1152, 1920}, new int[]{1200, 1200}, new int[]{1280, 960}, new int[]{1280, 1280}, new int[]{2200, 2200}, new int[]{10000, 220}, new int[]{10000, MsgID.TYPE_MSG_BEGIN_PLAYBACK}, new int[]{10000, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}, new int[]{10000, 500}};

    private static int[] a(int i, int i2, boolean z) {
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086410373")) {
            return (int[]) ipChange.ipc$dispatch("-1086410373", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
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
        if (AndroidInstantRuntime.support(ipChange, "-2101846234")) {
            return (DMImageStrategyConfig) ipChange.ipc$dispatch("-2101846234", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (TextUtils.isEmpty(str) || str.contains(".gif")) {
            return null;
        }
        if (str.contains(".alicdn.com") || str.contains(".aliyun-inc.com") || str.contains(".aliyuncs.com")) {
            boolean z = str.contains(".aliyun-inc.com") || str.contains(".aliyuncs.com");
            DMImageStrategyConfig dMImageStrategyConfig = new DMImageStrategyConfig();
            int[] a2 = a(i, i2, z);
            if (a2[0] > 0 && a2[1] > 0) {
                dMImageStrategyConfig.g = a2[0];
                dMImageStrategyConfig.f = a2[1];
            }
            dMImageStrategyConfig.a = true;
            dMImageStrategyConfig.b = false;
            dMImageStrategyConfig.e = true;
            return dMImageStrategyConfig;
        }
        return null;
    }

    public static String c(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523154681")) {
            return (String) ipChange.ipc$dispatch("-1523154681", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        DMImageStrategyConfig b = b(str, i, i2);
        if (TextUtils.isEmpty(str) || str.startsWith("res://") || str.startsWith("file://") || str.startsWith("asset://")) {
            return str;
        }
        if (str.contains(".alicdn.com")) {
            return d(str, b);
        }
        return (str.contains(".aliyun-inc.com") || str.contains(".aliyuncs.com")) ? e(str, b) : str;
    }

    private static String d(String str, DMImageStrategyConfig dMImageStrategyConfig) {
        DMImageStrategyConfig.DMImageCropType dMImageCropType;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195633030")) {
            return (String) ipChange.ipc$dispatch("-1195633030", new Object[]{str, dMImageStrategyConfig});
        }
        StringBuilder sb = new StringBuilder(str);
        String substring = str.substring(str.lastIndexOf("/"));
        if (substring.contains(".png_") || substring.contains(".jpeg_") || substring.contains(".jpg_") || substring.contains(".gif")) {
            return str;
        }
        int[] a2 = a(dMImageStrategyConfig.g, dMImageStrategyConfig.f, false);
        sb.append(JSMethod.NOT_SET);
        if (a2[0] > 0 && a2[1] > 0) {
            sb.append(a2[0]);
            sb.append(Constants.Name.X);
            sb.append(a2[1]);
        }
        String str3 = "";
        if (dMImageStrategyConfig.b && (dMImageCropType = dMImageStrategyConfig.c) != null) {
            if (dMImageCropType.equals(DMImageStrategyConfig.DMImageCropType.cy500)) {
                str2 = "cy500i";
            } else {
                str2 = dMImageStrategyConfig.c.equals(DMImageStrategyConfig.DMImageCropType.cy100) ? "cy100i" : "";
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
                sb.append(dMImageStrategyConfig.d);
            }
        }
        if (dMImageStrategyConfig.e) {
            DMImageStrategyConfig.DMImageQuality dMImageQuality = dMImageStrategyConfig.h;
            if (dMImageQuality != null) {
                if (dMImageQuality.equals(DMImageStrategyConfig.DMImageQuality.q90)) {
                    str3 = "q90";
                } else if (dMImageStrategyConfig.h.equals(DMImageStrategyConfig.DMImageQuality.q75)) {
                    str3 = "q75";
                } else if (dMImageStrategyConfig.h.equals(DMImageStrategyConfig.DMImageQuality.q60)) {
                    str3 = "q60";
                } else if (dMImageStrategyConfig.h.equals(DMImageStrategyConfig.DMImageQuality.q50)) {
                    str3 = "q50";
                } else if (dMImageStrategyConfig.h.equals(DMImageStrategyConfig.DMImageQuality.q30)) {
                    str3 = "q30";
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                sb.append(str3);
            }
        }
        sb.append(".jpg");
        if (dMImageStrategyConfig.a) {
            sb.append("_.webp");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(java.lang.String r5, com.alibaba.pictures.bricks.util.DMImageStrategyConfig r6) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.util.a.$ipChange
            java.lang.String r1 = "1066673764"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r5
            r2[r4] = r6
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.lang.String r5 = (java.lang.String) r5
            return r5
        L1a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            java.lang.String r1 = "x-oss-process="
            boolean r1 = r5.contains(r1)
            if (r1 == 0) goto L28
            return r5
        L28:
            java.lang.String r1 = ".gif"
            boolean r1 = r5.contains(r1)
            if (r1 == 0) goto L31
            return r5
        L31:
            java.lang.String r5 = "?x-oss-process=image"
            r0.append(r5)
            int r5 = r6.g
            int r1 = r6.f
            int[] r5 = a(r5, r1, r4)
            r1 = r5[r3]
            java.lang.String r2 = ","
            if (r1 <= 0) goto L67
            r1 = r5[r4]
            if (r1 <= 0) goto L67
            java.lang.String r1 = "/resize"
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = "w_"
            r0.append(r1)
            r1 = r5[r3]
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = "h_"
            r0.append(r1)
            r5 = r5[r4]
            r0.append(r5)
        L67:
            boolean r5 = r6.e
            if (r5 == 0) goto Lc1
            com.alibaba.pictures.bricks.util.DMImageStrategyConfig$DMImageQuality r5 = r6.h
            if (r5 == 0) goto Lae
            com.alibaba.pictures.bricks.util.DMImageStrategyConfig$DMImageQuality r1 = com.alibaba.pictures.bricks.util.DMImageStrategyConfig.DMImageQuality.q90
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L7a
            java.lang.String r5 = "q_90"
            goto Lb0
        L7a:
            com.alibaba.pictures.bricks.util.DMImageStrategyConfig$DMImageQuality r5 = r6.h
            com.alibaba.pictures.bricks.util.DMImageStrategyConfig$DMImageQuality r1 = com.alibaba.pictures.bricks.util.DMImageStrategyConfig.DMImageQuality.q75
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L87
            java.lang.String r5 = "q_75"
            goto Lb0
        L87:
            com.alibaba.pictures.bricks.util.DMImageStrategyConfig$DMImageQuality r5 = r6.h
            com.alibaba.pictures.bricks.util.DMImageStrategyConfig$DMImageQuality r1 = com.alibaba.pictures.bricks.util.DMImageStrategyConfig.DMImageQuality.q60
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L94
            java.lang.String r5 = "q_60"
            goto Lb0
        L94:
            com.alibaba.pictures.bricks.util.DMImageStrategyConfig$DMImageQuality r5 = r6.h
            com.alibaba.pictures.bricks.util.DMImageStrategyConfig$DMImageQuality r1 = com.alibaba.pictures.bricks.util.DMImageStrategyConfig.DMImageQuality.q50
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto La1
            java.lang.String r5 = "q_50"
            goto Lb0
        La1:
            com.alibaba.pictures.bricks.util.DMImageStrategyConfig$DMImageQuality r5 = r6.h
            com.alibaba.pictures.bricks.util.DMImageStrategyConfig$DMImageQuality r1 = com.alibaba.pictures.bricks.util.DMImageStrategyConfig.DMImageQuality.q30
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto Lae
            java.lang.String r5 = "q_30"
            goto Lb0
        Lae:
            java.lang.String r5 = ""
        Lb0:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto Lc1
            java.lang.String r1 = "/quality"
            r0.append(r1)
            r0.append(r2)
            r0.append(r5)
        Lc1:
            boolean r5 = r6.a
            if (r5 == 0) goto Lca
            java.lang.String r5 = "/format,webp"
            r0.append(r5)
        Lca:
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.util.a.e(java.lang.String, com.alibaba.pictures.bricks.util.DMImageStrategyConfig):java.lang.String");
    }
}
