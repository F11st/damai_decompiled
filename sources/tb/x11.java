package tb;

import android.text.TextUtils;
import cn.damai.h5container.H5MainActivity;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.ui.WebConstant;
import com.alibaba.pictures.bricks.coupon.view.ImageConfig;
import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alimm.xadsdk.base.constant.AdConstants;
import com.alipay.sdk.m.u.C4318n;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.youku.alixplayer.MsgID;
import com.youku.alixplayer.util.PlaybackParamKey;
import com.youku.arch.v3.core.Constants;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import com.youku.passport.libs.BuildConfig;
import com.youku.resource.widget.PlayerGuideTipsView;
import com.youku.uplayer.AliMediaPlayer;
import java.util.Arrays;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class x11 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String IMAGE_TO_WEBP = "damai_webp";
    @NotNull
    public static final x11 INSTANCE = new x11();
    @Nullable
    private static int[][] a = {new int[]{16, 16}, new int[]{20, 20}, new int[]{24, 24}, new int[]{30, 30}, new int[]{32, 32}, new int[]{36, 36}, new int[]{40, 40}, new int[]{48, 48}, new int[]{50, 50}, new int[]{60, 30}, new int[]{60, 60}, new int[]{60, 90}, new int[]{64, 64}, new int[]{70, 70}, new int[]{70, 1000}, new int[]{72, 72}, new int[]{75, 75}, new int[]{75, 100}, new int[]{80, 40}, new int[]{80, 60}, new int[]{80, 65}, new int[]{81, 65}, new int[]{80, 80}, new int[]{80, 1000}, new int[]{88, 88}, new int[]{90, 45}, new int[]{90, 60}, new int[]{90, 90}, new int[]{90, 135}, new int[]{96, 54}, new int[]{100, 50}, new int[]{100, 75}, new int[]{100, 100}, new int[]{100, 150}, new int[]{100, 1000}, new int[]{110, 90}, new int[]{110, 110}, new int[]{110, 10000}, new int[]{115, 100}, new int[]{120, 60}, new int[]{120, 97}, new int[]{120, 90}, new int[]{120, 120}, new int[]{120, 160}, new int[]{121, 75}, new int[]{125, 125}, new int[]{128, 128}, new int[]{130, 130}, new int[]{135, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{140, 70}, new int[]{140, 100}, new int[]{140, 140}, new int[]{140, 10000}, new int[]{142, 142}, new int[]{145, 145}, new int[]{150, 150}, new int[]{150, 200}, new int[]{150, 10000}, new int[]{157, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{160, 80}, new int[]{160, 90}, new int[]{160, 130}, new int[]{160, 160}, new int[]{160, 180}, new int[]{160, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{165, 5000}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 10000}, new int[]{AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 120}, new int[]{180, 90}, new int[]{180, 180}, new int[]{180, PlayerGuideTipsView.ANIM_DURATION_ALPHA}, new int[]{AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, 43}, new int[]{AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH}, new int[]{196, 196}, new int[]{200, 100}, new int[]{200, 200}, new int[]{200, 162}, new int[]{210, 140}, new int[]{210, 210}, new int[]{210, 1000}, new int[]{220, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD}, new int[]{220, 220}, new int[]{220, 330}, new int[]{220, 5000}, new int[]{220, 10000}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 5000}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, 87}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, PlayerGuideTipsView.ANIM_DURATION_ALPHA}, new int[]{PlayerGuideTipsView.ANIM_DURATION_ALPHA, 10000}, new int[]{234, 234}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 180}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, BuildConfig.VERSION_CODE}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 5000}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 10000}, new int[]{250, 225}, new int[]{250, 250}, new int[]{H5MainActivity.REQUEST_REALNAME, SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE}, new int[]{H5MainActivity.REQUEST_REALNAME, H5MainActivity.REQUEST_REALNAME}, new int[]{WebConstant.OPEN_WEB_LOGIN_IV_REQCODE, 100}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 180}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE}, new int[]{AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 450}, new int[]{ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, 192}, new int[]{ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, 410}, new int[]{284, 284}, new int[]{288, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{290, 290}, new int[]{290, 10000}, new int[]{292, 292}, new int[]{294, 430}, new int[]{300, 1000}, new int[]{300, 10000}, new int[]{310, 310}, new int[]{312, 312}, new int[]{300, 300}, new int[]{315, 315}, new int[]{320, H5MainActivity.REQUEST_REALNAME}, new int[]{320, 320}, new int[]{320, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{320, 5000}, new int[]{336, 336}, new int[]{350, 350}, new int[]{350, 1000}, new int[]{PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH, PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH}, new int[]{360, 234}, new int[]{360, 360}, new int[]{360, 10000}, new int[]{375, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{375, 375}, new int[]{400, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR}, new int[]{400, 200}, new int[]{400, 400}, new int[]{420, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE}, new int[]{430, 430}, new int[]{438, 438}, new int[]{440, 440}, new int[]{450, 300}, new int[]{450, 600}, new int[]{450, 5000}, new int[]{450, 10000}, new int[]{C4318n.g, C4318n.g}, new int[]{468, 468}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, 420}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{485, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_LOADING_FACTOR_STEP}, new int[]{490, 330}, new int[]{490, 490}, new int[]{500, 375}, new int[]{500, 450}, new int[]{500, 500}, new int[]{500, 1000}, new int[]{540, 540}, new int[]{560, AdConstants.TEMPLATE_LONG_VIDEO_INTERACTION}, new int[]{560, 560}, new int[]{560, 840}, new int[]{568, 568}, new int[]{570, 570}, new int[]{570, 10000}, new int[]{580, 580}, new int[]{580, 10000}, new int[]{600, 600}, new int[]{600, 800}, new int[]{620, 10000}, new int[]{640, 360}, new int[]{640, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH}, new int[]{640, 640}, new int[]{660, 440}, new int[]{667, 667}, new int[]{670, 670}, new int[]{LoginConstant.RESULT_WINDWANE_CLOSEW, LoginConstant.RESULT_WINDWANE_CLOSEW}, new int[]{728, 728}, new int[]{FeatureFactory.PRIORITY_ABOVE_NORMAL, 388}, new int[]{FeatureFactory.PRIORITY_ABOVE_NORMAL, 1000}, new int[]{760, 760}, new int[]{790, 420}, new int[]{790, 10000}, new int[]{800, 800}, new int[]{960, 960}, new int[]{970, 970}, new int[]{1080, 1800}, new int[]{1136, 1136}, new int[]{1152, 1920}, new int[]{1200, 1200}, new int[]{1280, 960}, new int[]{1280, 1280}, new int[]{2200, 2200}, new int[]{10000, 220}, new int[]{10000, MsgID.TYPE_MSG_BEGIN_PLAYBACK}, new int[]{10000, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}, new int[]{10000, 500}};

    private x11() {
    }

    private final int[] a(int i, int i2, boolean z) {
        int length;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800367761")) {
            return (int[]) ipChange.ipc$dispatch("-1800367761", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
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
        if (iArr == null) {
            length = 0;
        } else {
            b41.f(iArr);
            length = iArr.length;
        }
        int i5 = -100;
        int i6 = -100;
        for (int i7 = 0; i7 < length; i7++) {
            int[][] iArr2 = a;
            b41.f(iArr2);
            int i8 = iArr2[i7][0];
            int[][] iArr3 = a;
            b41.f(iArr3);
            int i9 = iArr3[i7][1];
            if (i8 >= i && i9 >= i2 && (i3 = i8 * i9) < i4) {
                i5 = i8;
                i6 = i9;
                i4 = i3;
            }
        }
        return new int[]{i5, i6};
    }

    private final boolean e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1609399939")) {
            return ((Boolean) ipChange.ipc$dispatch("-1609399939", new Object[]{this})).booleanValue();
        }
        return true;
    }

    private final boolean f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911161014")) {
            return ((Boolean) ipChange.ipc$dispatch("-1911161014", new Object[]{this})).booleanValue();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0100, code lost:
        if (f() != false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String g(java.lang.String r13, com.alibaba.pictures.bricks.coupon.view.ImageConfig r14) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.x11.g(java.lang.String, com.alibaba.pictures.bricks.coupon.view.ImageConfig):java.lang.String");
    }

    private final String h(String str, ImageConfig imageConfig) {
        boolean K;
        boolean K2;
        String format;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10534898")) {
            return (String) ipChange.ipc$dispatch("-10534898", new Object[]{this, str, imageConfig});
        }
        StringBuilder sb = new StringBuilder(str);
        K = StringsKt__StringsKt.K(str, "x-oss-process=", false, 2, null);
        if (K) {
            return str;
        }
        K2 = StringsKt__StringsKt.K(str, ".gif", false, 2, null);
        if (K2) {
            return str;
        }
        sb.append("?x-oss-process=image");
        int[] a2 = a(imageConfig.i(), imageConfig.h(), true);
        if (a2[0] > 0 && a2[1] > 0) {
            sb.append("/resize");
            sb.append(",");
            sb.append("w_");
            sb.append(a2[0]);
            sb.append(",");
            sb.append("h_");
            sb.append(a2[1]);
        }
        if (imageConfig.g()) {
            if (imageConfig.c() != null) {
                if (imageConfig.c() == ImageConfig.DMImageQuality.q90) {
                    format = "q_90";
                } else if (imageConfig.c() == ImageConfig.DMImageQuality.q75) {
                    format = "q_75";
                } else if (imageConfig.c() == ImageConfig.DMImageQuality.q60) {
                    format = "q_60";
                } else if (imageConfig.c() == ImageConfig.DMImageQuality.q50) {
                    format = "q_50";
                } else {
                    format = imageConfig.c() == ImageConfig.DMImageQuality.q30 ? "q_30" : "";
                }
            } else if (f()) {
                eh2 eh2Var = eh2.INSTANCE;
                b41.h("q", "this as java.lang.String…ing(startIndex, endIndex)");
                b41.h("90", "this as java.lang.String).substring(startIndex)");
                format = String.format("%s_%s", Arrays.copyOf(new Object[]{"q", "90"}, 2));
                b41.h(format, "format(format, *args)");
            } else {
                eh2 eh2Var2 = eh2.INSTANCE;
                b41.h("q", "this as java.lang.String…ing(startIndex, endIndex)");
                b41.h("75", "this as java.lang.String).substring(startIndex)");
                format = String.format("%s_%s", Arrays.copyOf(new Object[]{"q", "75"}, 2));
                b41.h(format, "format(format, *args)");
            }
            if (!TextUtils.isEmpty(format)) {
                sb.append("/quality");
                sb.append(",");
                sb.append(format);
            }
        }
        if (imageConfig.d()) {
            sb.append("/sharpen");
            sb.append(",");
            if (f()) {
                b41.h("150", "this as java.lang.String).substring(startIndex)");
                sb.append("150");
            } else {
                b41.h("150", "this as java.lang.String).substring(startIndex)");
                sb.append("150");
            }
        }
        if (imageConfig.e()) {
            sb.append("/format,webp");
        }
        String sb2 = sb.toString();
        b41.h(sb2, "cdnUrl.toString()");
        return sb2;
    }

    @NotNull
    public final ImageConfig b(@NotNull String str, int i, int i2) {
        boolean K;
        boolean K2;
        boolean K3;
        boolean z;
        ImageConfig imageConfig;
        int[] a2;
        boolean K4;
        boolean K5;
        boolean K6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1277592786")) {
            return (ImageConfig) ipChange.ipc$dispatch("-1277592786", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        b41.i(str, "imageUrl");
        if (!e()) {
            return new ImageConfig();
        }
        if (TextUtils.isEmpty(str)) {
            return new ImageConfig();
        }
        K = StringsKt__StringsKt.K(str, ".gif", false, 2, null);
        if (K) {
            return new ImageConfig();
        }
        K2 = StringsKt__StringsKt.K(str, ".alicdn.com", false, 2, null);
        if (!K2) {
            K5 = StringsKt__StringsKt.K(str, ".aliyun-inc.com", false, 2, null);
            if (!K5) {
                K6 = StringsKt__StringsKt.K(str, ".aliyuncs.com", false, 2, null);
                if (!K6) {
                    return new ImageConfig();
                }
            }
        }
        K3 = StringsKt__StringsKt.K(str, ".aliyun-inc.com", false, 2, null);
        if (!K3) {
            K4 = StringsKt__StringsKt.K(str, ".aliyuncs.com", false, 2, null);
            if (!K4) {
                z = false;
                imageConfig = new ImageConfig();
                imageConfig.j("default");
                a2 = a(i, i2, z);
                if (a2[0] > 0 && a2[1] > 0) {
                    imageConfig.r(a2[0]);
                    imageConfig.q(a2[1]);
                }
                imageConfig.m(true);
                imageConfig.n(true);
                imageConfig.o(false);
                imageConfig.p(true);
                return imageConfig;
            }
        }
        z = true;
        imageConfig = new ImageConfig();
        imageConfig.j("default");
        a2 = a(i, i2, z);
        if (a2[0] > 0) {
            imageConfig.r(a2[0]);
            imageConfig.q(a2[1]);
        }
        imageConfig.m(true);
        imageConfig.n(true);
        imageConfig.o(false);
        imageConfig.p(true);
        return imageConfig;
    }

    @NotNull
    public final String c(@NotNull String str, @NotNull ImageConfig imageConfig) {
        boolean F;
        boolean F2;
        boolean F3;
        boolean K;
        boolean K2;
        boolean K3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-610146628")) {
            return (String) ipChange.ipc$dispatch("-610146628", new Object[]{this, str, imageConfig});
        }
        b41.i(str, "imageUrl");
        b41.i(imageConfig, Constants.CONFIG);
        if (e() && !TextUtils.isEmpty(str)) {
            F = C8604o.F(str, "res://", false, 2, null);
            if (F) {
                return str;
            }
            F2 = C8604o.F(str, "file://", false, 2, null);
            if (F2) {
                return str;
            }
            F3 = C8604o.F(str, "asset://", false, 2, null);
            if (F3) {
                return str;
            }
            K = StringsKt__StringsKt.K(str, ".alicdn.com", false, 2, null);
            if (K) {
                return g(str, imageConfig);
            }
            K2 = StringsKt__StringsKt.K(str, ".aliyun-inc.com", false, 2, null);
            if (!K2) {
                K3 = StringsKt__StringsKt.K(str, ".aliyuncs.com", false, 2, null);
                if (!K3) {
                    return str;
                }
            }
            return h(str, imageConfig);
        }
        return str;
    }

    public final boolean d(@NotNull String str) {
        boolean K;
        int f0;
        boolean K2;
        boolean K3;
        boolean K4;
        boolean K5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1132001834")) {
            return ((Boolean) ipChange.ipc$dispatch("-1132001834", new Object[]{this, str})).booleanValue();
        }
        b41.i(str, "imageUrl");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        K = StringsKt__StringsKt.K(str, ".alicdn.com", false, 2, null);
        if (K) {
            f0 = StringsKt__StringsKt.f0(str, "/", 0, false, 6, null);
            String substring = str.substring(f0);
            b41.h(substring, "this as java.lang.String).substring(startIndex)");
            K2 = StringsKt__StringsKt.K(substring, ".png_", false, 2, null);
            if (!K2) {
                K3 = StringsKt__StringsKt.K(substring, ".jpeg_", false, 2, null);
                if (!K3) {
                    K4 = StringsKt__StringsKt.K(substring, ".jpg_", false, 2, null);
                    if (!K4) {
                        K5 = StringsKt__StringsKt.K(substring, ".gif", false, 2, null);
                        return !K5;
                    }
                }
            }
        }
        return false;
    }
}
