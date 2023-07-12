package tb;

import cn.damai.common.image.DMImageStrategyConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.TaobaoImageUrlStrategy;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class wr {
    private static transient /* synthetic */ IpChange $ipChange;

    public static TaobaoImageUrlStrategy.ImageQuality a(DMImageStrategyConfig.DMImageQuality dMImageQuality) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1513675462")) {
            return (TaobaoImageUrlStrategy.ImageQuality) ipChange.ipc$dispatch("1513675462", new Object[]{dMImageQuality});
        }
        if (dMImageQuality.equals(DMImageStrategyConfig.DMImageQuality.q90)) {
            return TaobaoImageUrlStrategy.ImageQuality.q90;
        }
        if (dMImageQuality.equals(DMImageStrategyConfig.DMImageQuality.q75)) {
            return TaobaoImageUrlStrategy.ImageQuality.q75;
        }
        if (dMImageQuality.equals(DMImageStrategyConfig.DMImageQuality.q60)) {
            return TaobaoImageUrlStrategy.ImageQuality.q60;
        }
        if (dMImageQuality.equals(DMImageStrategyConfig.DMImageQuality.q50)) {
            return TaobaoImageUrlStrategy.ImageQuality.q50;
        }
        if (dMImageQuality.equals(DMImageStrategyConfig.DMImageQuality.q30)) {
            return TaobaoImageUrlStrategy.ImageQuality.q30;
        }
        return TaobaoImageUrlStrategy.ImageQuality.non;
    }

    public static ImageStrategyConfig.SizeLimitType b(DMImageStrategyConfig.DMImageSizeLimitType dMImageSizeLimitType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522855992")) {
            return (ImageStrategyConfig.SizeLimitType) ipChange.ipc$dispatch("-522855992", new Object[]{dMImageSizeLimitType});
        }
        if (dMImageSizeLimitType.equals(DMImageStrategyConfig.DMImageSizeLimitType.HEIGHT_LIMIT)) {
            return ImageStrategyConfig.SizeLimitType.HEIGHT_LIMIT;
        }
        if (dMImageSizeLimitType.equals(DMImageStrategyConfig.DMImageSizeLimitType.WIDTH_LIMIT)) {
            return ImageStrategyConfig.SizeLimitType.WIDTH_LIMIT;
        }
        return ImageStrategyConfig.SizeLimitType.ALL_LIMIT;
    }
}
