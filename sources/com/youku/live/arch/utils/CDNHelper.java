package com.youku.live.arch.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alipay.sdk.m.u.n;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import com.youku.live.dsl.oss.IXOSSProcessFormaterImp;
import com.youku.resource.widget.PlayerGuideTipsView;
import com.youku.uplayer.AliMediaPlayer;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CDNHelper implements ICDNInterface {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Pattern sTFSHadAppendPattern = Pattern.compile("((\\d+)x(\\d+))");
    public int[] TFS_SIZE_RANGE = {16, 20, 24, 30, 32, 36, 40, 48, 50, 60, 64, 70, 72, 75, 80, 88, 90, 100, 110, 120, 125, 128, 130, 140, 142, 145, 150, 160, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 180, AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, 196, 200, 210, 220, PlayerGuideTipsView.ANIM_DURATION_ALPHA, 234, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 250, AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 284, 290, 292, 300, 310, 320, 336, 350, 360, 400, 430, 440, n.g, 468, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, 490, 540, 560, 570, 580, 600, 640, 670, LoginConstant.RESULT_WINDWANE_CLOSEW, 728, 760, 960, 970, 1200};
    public String[] DEFAULT_TFS_DOMAINS = {"tfs.alipayobjects.com"};
    public String[] DEFAULT_OSS_DOMAINS = {"image.laifeng.com", "ykimg.alicdn.com", "m.ykimg.com", "img3.soku.com", "oss-comments.youku.com", "img2.soku.com", "global.alicdn.com", "galitv.alicdn.com", "cn-vmc-images.alicdn.com", "ykpic.alicdn.com", "liangcang-material.alicdn.com", "pgc-cdn.youku.com", "r1.ykimg.com", "img.alicdn.com"};

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class CDNHelperHolder {
        public static CDNHelper instance = new CDNHelper();

        private CDNHelperHolder() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class Processor {
        private String url;

        public Processor(String str) {
            this.url = str;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class UriCDNInfo {
        public final String host;
        public final Uri uri;
        public final String url;

        public UriCDNInfo(String str) {
            this.url = str;
            Uri parse = Uri.parse(str);
            this.uri = parse;
            if (parse != null && parse.getHost() != null) {
                this.host = parse.getHost();
            } else {
                this.host = "";
            }
        }
    }

    private String getFitOSSSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964882437")) {
            return (String) ipChange.ipc$dispatch("-1964882437", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i <= 0 || i2 <= 0) {
            return "";
        }
        int i3 = 1024;
        if (i > 1024) {
            i2 = (i2 * 1024) / i;
            i = 1024;
        }
        if (i2 > 1024) {
            i = (i * 1024) / i2;
        } else {
            i3 = i2;
        }
        return "/resize,m_mfit,h_" + i3 + ",w_" + i;
    }

    private String getFitTFSSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "517233837")) {
            return (String) ipChange.ipc$dispatch("517233837", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i <= 0 || i2 <= 0) {
            return "";
        }
        return JSMethod.NOT_SET + getFitTFSSize(i) + Constants.Name.X + getFitTFSSize(i2);
    }

    public static CDNHelper getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-719122035") ? (CDNHelper) ipChange.ipc$dispatch("-719122035", new Object[0]) : CDNHelperHolder.instance;
    }

    @Override // com.youku.live.arch.utils.ICDNInterface
    public String blurUrl(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1874681084") ? (String) ipChange.ipc$dispatch("-1874681084", new Object[]{this, str}) : blurUrl(str, 15, 15);
    }

    @Override // com.youku.live.arch.utils.ICDNInterface
    public String blurWithSize(String str, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-440504684")) {
            return (String) ipChange.ipc$dispatch("-440504684", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        if (!TextUtils.isEmpty(str) && i >= 0 && i2 >= 0 && i <= 50 && i2 <= 50 && isOSSDomain(new UriCDNInfo(str).host)) {
            if (str.contains(IXOSSProcessFormaterImp.X_OSS_PROCESS)) {
                str = str.substring(0, str.indexOf(IXOSSProcessFormaterImp.X_OSS_PROCESS) - 1);
            }
            StringBuilder sb = new StringBuilder(str);
            String fitOSSSize = getFitOSSSize(i3, i4);
            sb.append(str.contains("?") ? "&" : "?");
            sb.append(IXOSSProcessFormaterImp.X_OSS_PROCESS);
            sb.append(fitOSSSize);
            sb.append("/blur,r_");
            sb.append(i);
            sb.append(",s_");
            sb.append(i2);
            return sb.toString();
        }
        return str;
    }

    @Override // com.youku.live.arch.utils.ICDNInterface
    public String decideUrl(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1974886077") ? (String) ipChange.ipc$dispatch("-1974886077", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)}) : decideUrl(str, i, i2, false);
    }

    @Override // com.youku.live.arch.utils.ICDNInterface
    public boolean isOSSDomain(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1997616609")) {
            return ((Boolean) ipChange.ipc$dispatch("-1997616609", new Object[]{this, str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.DEFAULT_OSS_DOMAINS) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.youku.live.arch.utils.ICDNInterface
    public boolean isTFSDomain(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1933543853")) {
            return ((Boolean) ipChange.ipc$dispatch("1933543853", new Object[]{this, str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.DEFAULT_TFS_DOMAINS) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    private int getFitTFSSize(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1470783325")) {
            return ((Integer) ipChange.ipc$dispatch("-1470783325", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (i <= 0) {
            return 0;
        }
        if (i < 16) {
            i = 16;
        }
        if (i > 1200) {
            i = 1200;
        }
        while (true) {
            int[] iArr = this.TFS_SIZE_RANGE;
            if (i2 >= iArr.length) {
                return i;
            }
            if (iArr[i2] >= i) {
                return iArr[i2];
            }
            i2++;
        }
    }

    @Override // com.youku.live.arch.utils.ICDNInterface
    public String blurUrl(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1174207068")) {
            return (String) ipChange.ipc$dispatch("-1174207068", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (!TextUtils.isEmpty(str) && i >= 0 && i2 >= 0 && i <= 50 && i2 <= 50) {
            UriCDNInfo uriCDNInfo = new UriCDNInfo(str);
            StringBuilder sb = new StringBuilder(str);
            if (isOSSDomain(uriCDNInfo.host)) {
                if (!str.contains(IXOSSProcessFormaterImp.X_OSS_PROCESS)) {
                    sb.append(str.contains("?") ? "&" : "?");
                    sb.append(IXOSSProcessFormaterImp.X_OSS_PROCESS);
                }
                sb.append("/blur,r_");
                sb.append(i);
                sb.append(",s_");
                sb.append(i2);
            }
            return sb.toString();
        }
        return str;
    }

    @Override // com.youku.live.arch.utils.ICDNInterface
    public String decideUrl(String str, int i, int i2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1646832649")) {
            return (String) ipChange.ipc$dispatch("1646832649", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        }
        if (TextUtils.isEmpty(str) || i <= 0 || i2 <= 0 || str.endsWith(".gif") || str.endsWith(".webp")) {
            return str;
        }
        UriCDNInfo uriCDNInfo = new UriCDNInfo(str);
        StringBuilder sb = new StringBuilder(str);
        if (isTFSDomain(uriCDNInfo.host)) {
            if (sTFSHadAppendPattern.matcher(str).find()) {
                return str;
            }
            sb.append(getFitTFSSize(i, i2));
            sb.append("Q90");
            if (z) {
                sb.append("_.webp");
            }
        } else if (isOSSDomain(uriCDNInfo.host)) {
            if (str.contains(IXOSSProcessFormaterImp.X_OSS_PROCESS)) {
                return str;
            }
            String fitOSSSize = getFitOSSSize(i, i2);
            sb.append(str.contains("?") ? "&" : "?");
            sb.append(IXOSSProcessFormaterImp.X_OSS_PROCESS);
            sb.append(fitOSSSize);
            sb.append("/quality,q_90");
            if (z) {
                sb.append("/format,webp");
            }
        }
        return sb.toString();
    }
}
