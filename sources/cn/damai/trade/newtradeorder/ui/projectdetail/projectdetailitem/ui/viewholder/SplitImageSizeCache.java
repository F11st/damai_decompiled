package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageStrategyConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SplitImageSizeCache {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final HashMap<String, ImageSizeCache> a = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class ImageSizeCache implements Serializable {
        public final int imgHeight;
        public final int imgWidth;
        public final String key;

        public ImageSizeCache(String str, int i, int i2) {
            this.key = str;
            this.imgWidth = i;
            this.imgHeight = i2;
        }
    }

    public static void a(String str, ImageSizeCache imageSizeCache) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "395381726")) {
            ipChange.ipc$dispatch("395381726", new Object[]{str, imageSizeCache});
        } else {
            a.put(str, imageSizeCache);
        }
    }

    public static void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-572916801")) {
            ipChange.ipc$dispatch("-572916801", new Object[0]);
        } else {
            a.clear();
        }
    }

    @Nullable
    public static ImageSizeCache c(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1216631552") ? (ImageSizeCache) ipChange.ipc$dispatch("-1216631552", new Object[]{str}) : a.get(str);
    }

    public static String d(String str, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917276244")) {
            return (String) ipChange.ipc$dispatch("-1917276244", new Object[]{str, dMImageCropType, Integer.valueOf(i)});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (dMImageCropType != null) {
            sb.append(dMImageCropType.name());
        }
        sb.append(JSMethod.NOT_SET);
        sb.append(i);
        return sb.toString();
    }
}
