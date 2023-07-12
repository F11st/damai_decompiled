package com.taobao.weex.devtools.trace;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.WXA;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXDiv;
import com.taobao.weex.ui.component.WXEmbed;
import com.taobao.weex.ui.component.WXHeader;
import com.taobao.weex.ui.component.WXImage;
import com.taobao.weex.ui.component.WXInput;
import com.taobao.weex.ui.component.WXLoading;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.ui.component.WXSlider;
import com.taobao.weex.ui.component.WXSwitch;
import com.taobao.weex.ui.component.WXText;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.WXVideo;
import com.taobao.weex.ui.component.list.HorizontalListComponent;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.component.list.WXListComponent;
import com.taobao.weex.ui.view.WXEditText;
import com.taobao.weex.utils.WXLogUtils;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ViewUtils {
    private static final AtomicInteger sNextGeneratedId;
    private static final Map<Class, String> sVDomMap;

    static {
        HashMap hashMap = new HashMap();
        sVDomMap = hashMap;
        hashMap.put(WXComponent.class, "component");
        hashMap.put(WXText.class, "text");
        hashMap.put(WXVContainer.class, "container");
        hashMap.put(WXDiv.class, WXBasicComponentType.DIV);
        hashMap.put(WXEditText.class, WXBasicComponentType.TEXTAREA);
        hashMap.put(WXA.class, "a");
        hashMap.put(WXInput.class, "input");
        hashMap.put(WXLoading.class, "loading");
        hashMap.put(WXScroller.class, WXBasicComponentType.SCROLLER);
        hashMap.put(WXSwitch.class, "switch");
        hashMap.put(WXSlider.class, "slider");
        hashMap.put(WXVideo.class, "video");
        hashMap.put(WXImage.class, "image");
        hashMap.put(WXHeader.class, "header");
        hashMap.put(WXEmbed.class, WXBasicComponentType.EMBED);
        hashMap.put(WXListComponent.class, "list");
        hashMap.put(HorizontalListComponent.class, WXBasicComponentType.HLIST);
        hashMap.put(WXCell.class, WXBasicComponentType.CELL);
        sNextGeneratedId = new AtomicInteger(1);
    }

    private ViewUtils() {
    }

    public static float dp2px(@NonNull Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static double findSuitableVal(double d, int i) {
        if (d <= 0.0d || i <= 0) {
            return 0.0d;
        }
        int i2 = (int) d;
        while (i2 % i != 0) {
            i2++;
        }
        return i2;
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = sNextGeneratedId;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    @NonNull
    public static String getComponentName(@NonNull WXComponent wXComponent) {
        String str = sVDomMap.get(wXComponent.getClass());
        return TextUtils.isEmpty(str) ? "component" : str;
    }

    @Nullable
    public static WXComponent getNestedRootComponent(@NonNull WXEmbed wXEmbed) {
        try {
            Field declaredField = wXEmbed.getClass().getDeclaredField("mNestedInstance");
            declaredField.setAccessible(true);
            WXSDKInstance wXSDKInstance = (WXSDKInstance) declaredField.get(wXEmbed);
            if (wXSDKInstance == null) {
                return null;
            }
            return wXSDKInstance.getRootComponent();
        } catch (Exception e) {
            WXLogUtils.e(e.getMessage());
            return null;
        }
    }

    public static int getScreenHeight(@NonNull Context context) {
        return DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics());
    }

    public static boolean isVerticalScroller(@NonNull WXScroller wXScroller) {
        return (wXScroller == null || wXScroller.getAttrs() == null || !LiveBundleLayout.TYPE_VERTICAL.equals(wXScroller.getAttrs().getScrollDirection())) ? false : true;
    }

    public static float px2dp(@NonNull Context context, float f) {
        return f / (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static float sp2px(@NonNull Context context, int i) {
        return TypedValue.applyDimension(2, i, context.getResources().getDisplayMetrics());
    }
}
