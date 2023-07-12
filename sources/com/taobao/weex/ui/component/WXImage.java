package com.taobao.weex.ui.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXImageSharpen;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.common.WXRuntimeException;
import com.taobao.weex.dom.WXImageQuality;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.WXImageView;
import com.taobao.weex.ui.view.border.BorderDrawable;
import com.taobao.weex.utils.ImageDrawable;
import com.taobao.weex.utils.ImgURIUtil;
import com.taobao.weex.utils.SingleFunctionParser;
import com.taobao.weex.utils.WXDomUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewToImageUtil;
import com.taobao.weex.utils.WXViewUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.gz2;
import tb.jn1;

/* compiled from: Taobao */
@Component(lazyload = false)
/* loaded from: classes11.dex */
public class WXImage extends WXComponent<ImageView> {
    private static SingleFunctionParser.FlatMapper<Integer> BLUR_RADIUS_MAPPER = new SingleFunctionParser.FlatMapper<Integer>() { // from class: com.taobao.weex.ui.component.WXImage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.taobao.weex.utils.SingleFunctionParser.FlatMapper
        public Integer map(String str) {
            return WXUtils.getInteger(str, 0);
        }
    };
    public static final String ERRORDESC = "errorDesc";
    public static final String SUCCEED = "success";
    private static final int WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 2;
    private boolean mAutoRecycle;
    private int mBlurRadius;
    private String mSrc;
    private String preImgUrlStr;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Creator implements ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new WXImage(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface Measurable {
        int getNaturalHeight();

        int getNaturalWidth();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class MyImageListener implements WXImageStrategy.ImageListener {
        private String rewritedStr;
        private WeakReference<WXImage> wxImageWeakReference;

        MyImageListener(WXImage wXImage, String str) {
            this.wxImageWeakReference = new WeakReference<>(wXImage);
            this.rewritedStr = str;
        }

        @Override // com.taobao.weex.common.WXImageStrategy.ImageListener
        public void onImageFinish(String str, ImageView imageView, boolean z, Map map) {
            WXImage wXImage = this.wxImageWeakReference.get();
            if (wXImage == null) {
                return;
            }
            if (wXImage.getEvents().contains("load")) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap(2);
                if (imageView != null && (imageView instanceof Measurable)) {
                    Measurable measurable = (Measurable) imageView;
                    hashMap2.put("naturalWidth", Integer.valueOf(measurable.getNaturalWidth()));
                    hashMap2.put("naturalHeight", Integer.valueOf(measurable.getNaturalHeight()));
                } else {
                    hashMap2.put("naturalWidth", 0);
                    hashMap2.put("naturalHeight", 0);
                }
                if (wXImage.containsEvent("load")) {
                    hashMap.put("success", Boolean.valueOf(z));
                    hashMap.put("size", hashMap2);
                    wXImage.fireEvent("load", hashMap);
                }
            }
            wXImage.monitorImgSize(imageView, this.rewritedStr);
        }
    }

    @Deprecated
    public WXImage(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitorImgSize(ImageView imageView, String str) {
        WXSDKInstance wXComponent;
        if (imageView == null || (wXComponent = getInstance()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Drawable drawable = imageView.getDrawable();
        if (layoutParams == null || drawable == null) {
            return;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (this.preImgUrlStr.equals(str)) {
            return;
        }
        this.preImgUrlStr = str;
        if (intrinsicHeight > 1081 && intrinsicWidth > 721) {
            wXComponent.getApmForInstance().B(WXInstanceApm.KEY_PAGE_STATS_LARGE_IMG_COUNT, 1.0d);
            if (gz2.a) {
                gz2.d(getInstanceId(), "details", WXInstanceApm.KEY_PAGE_STATS_LARGE_IMG_COUNT, intrinsicWidth + jn1.MUL + intrinsicHeight + "," + str);
            }
        }
        long j = intrinsicHeight * intrinsicWidth;
        long measuredHeight = imageView.getMeasuredHeight() * imageView.getMeasuredWidth();
        if (measuredHeight != 0 && j / measuredHeight > 1.2d && j - measuredHeight > 1600) {
            wXComponent.getWXPerformance().wrongImgSizeCount += 1.0d;
            wXComponent.getApmForInstance().B(WXInstanceApm.KEY_PAGE_STATS_WRONG_IMG_SIZE_COUNT, 1.0d);
            if (gz2.a) {
                gz2.d(getInstanceId(), "details", WXInstanceApm.KEY_PAGE_STATS_WRONG_IMG_SIZE_COUNT, String.format(Locale.ROOT, "imgSize:[%d,%d],viewSize:[%d,%d],urL:%s", Integer.valueOf(intrinsicWidth), Integer.valueOf(intrinsicHeight), Integer.valueOf(imageView.getMeasuredWidth()), Integer.valueOf(imageView.getMeasuredHeight()), str));
            }
        }
    }

    private int parseBlurRadius(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        try {
            List parse = new SingleFunctionParser(str, BLUR_RADIUS_MAPPER).parse("blur");
            if (parse != null && !parse.isEmpty()) {
                return ((Integer) parse.get(0)).intValue();
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private void setBlurRadius(@NonNull String str, int i) {
        if (getInstance() == null || i == this.mBlurRadius) {
            return;
        }
        Uri rewriteUri = getInstance().rewriteUri(Uri.parse(str), "image");
        if ("local".equals(rewriteUri.getScheme())) {
            return;
        }
        setRemoteSrc(rewriteUri, i);
    }

    private void setLocalSrc(Uri uri) {
        ImageView hostView;
        Drawable drawableFromLoaclSrc = ImgURIUtil.getDrawableFromLoaclSrc(getContext(), uri);
        if (drawableFromLoaclSrc == null || (hostView = getHostView()) == null) {
            return;
        }
        hostView.setImageDrawable(drawableFromLoaclSrc);
    }

    private void setRemoteSrc(Uri uri, int i) {
        WXImageStrategy wXImageStrategy = new WXImageStrategy(getInstanceId());
        wXImageStrategy.isClipping = true;
        wXImageStrategy.isSharpen = getAttrs().getImageSharpen() == WXImageSharpen.SHARPEN;
        wXImageStrategy.blurRadius = Math.max(0, i);
        this.mBlurRadius = i;
        String uri2 = uri.toString();
        wXImageStrategy.setImageListener(new MyImageListener(this, uri2));
        String str = null;
        if (getAttrs().containsKey(Constants.Name.PLACEHOLDER)) {
            str = (String) getAttrs().get(Constants.Name.PLACEHOLDER);
        } else if (getAttrs().containsKey(Constants.Name.PLACE_HOLDER)) {
            str = (String) getAttrs().get(Constants.Name.PLACE_HOLDER);
        }
        if (str != null) {
            wXImageStrategy.placeHolder = getInstance().rewriteUri(Uri.parse(str), "image").toString();
        }
        wXImageStrategy.instanceId = getInstanceId();
        IWXImgLoaderAdapter imgLoaderAdapter = getInstance().getImgLoaderAdapter();
        if (imgLoaderAdapter != null) {
            imgLoaderAdapter.setImage(uri2, getHostView(), getImageQuality(), wXImageStrategy);
        }
    }

    private void updateBorderRadius() {
        if (getHostView() instanceof WXImageView) {
            WXImageView wXImageView = (WXImageView) getHostView();
            BorderDrawable borderDrawable = WXViewUtils.getBorderDrawable(getHostView());
            float[] borderInnerRadius = borderDrawable != null ? borderDrawable.getBorderInnerRadius(new RectF(0.0f, 0.0f, WXDomUtils.getContentWidth(this), WXDomUtils.getContentHeight(this))) : new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            wXImageView.setBorderRadius(borderInnerRadius);
            if (wXImageView.getDrawable() instanceof ImageDrawable) {
                ImageDrawable imageDrawable = (ImageDrawable) wXImageView.getDrawable();
                if (Arrays.equals(imageDrawable.getCornerRadii(), borderInnerRadius)) {
                    return;
                }
                imageDrawable.setCornerRadii(borderInnerRadius);
            }
        }
    }

    public void autoRecoverImage() {
        if (this.mAutoRecycle) {
            setSrc(this.mSrc);
        }
    }

    public void autoReleaseImage() {
        if (!this.mAutoRecycle || getHostView() == null || getInstance().getImgLoaderAdapter() == null) {
            return;
        }
        getInstance().getImgLoaderAdapter().setImage(null, (ImageView) this.mHost, null, null);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        if ((getHostView() instanceof WXImageView) && getInstance().getImgLoaderAdapter() != null) {
            getInstance().getImgLoaderAdapter().setImage(null, (ImageView) this.mHost, null, null);
        }
        super.destroy();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected WXImageQuality getImageQuality() {
        return getAttrs().getImageQuality();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected ImageView.ScaleType getResizeMode(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        if (TextUtils.isEmpty(str)) {
            return scaleType;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c = 0;
                    break;
                }
                break;
            case 94852023:
                if (str.equals("cover")) {
                    c = 1;
                    break;
                }
                break;
            case 951526612:
                if (str.equals("contain")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return ImageView.ScaleType.FIT_XY;
            case 1:
                return ImageView.ScaleType.CENTER_CROP;
            case 2:
                return ImageView.ScaleType.FIT_CENTER;
            default:
                return scaleType;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onFinishLayout() {
        super.onFinishLayout();
        updateBorderRadius();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void recycled() {
        super.recycled();
        if (getInstance().getImgLoaderAdapter() != null) {
            getInstance().getImgLoaderAdapter().setImage(null, (ImageView) this.mHost, null, null);
        } else if (!WXEnvironment.isApkDebugable()) {
            WXLogUtils.e("Error getImgLoaderAdapter() == null");
        } else {
            throw new WXRuntimeException("getImgLoaderAdapter() == null");
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void refreshData(WXComponent wXComponent) {
        super.refreshData(wXComponent);
        if (wXComponent instanceof WXImage) {
            setSrc(wXComponent.getAttrs().getImageSrc());
        }
    }

    @JSMethod(uiThread = false)
    public void save(final JSCallback jSCallback) {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0 && (getContext() instanceof Activity)) {
            ActivityCompat.requestPermissions((Activity) getContext(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
        }
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            if (jSCallback != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("success", Boolean.FALSE);
                hashMap.put(ERRORDESC, "Permission denied: android.permission.WRITE_EXTERNAL_STORAGE");
                jSCallback.invoke(hashMap);
            }
        } else if (this.mHost == 0) {
            if (jSCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("success", Boolean.FALSE);
                hashMap2.put(ERRORDESC, "Image component not initialized");
                jSCallback.invoke(hashMap2);
            }
        } else {
            String str = this.mSrc;
            if (str != null && !str.equals("")) {
                WXViewToImageUtil.generateImage(this.mHost, 0, -460552, new WXViewToImageUtil.OnImageSavedCallback() { // from class: com.taobao.weex.ui.component.WXImage.2
                    @Override // com.taobao.weex.utils.WXViewToImageUtil.OnImageSavedCallback
                    public void onSaveFailed(String str2) {
                        if (jSCallback != null) {
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("success", Boolean.FALSE);
                            hashMap3.put(WXImage.ERRORDESC, str2);
                            jSCallback.invoke(hashMap3);
                        }
                    }

                    @Override // com.taobao.weex.utils.WXViewToImageUtil.OnImageSavedCallback
                    public void onSaveSucceed(String str2) {
                        if (jSCallback != null) {
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("success", Boolean.TRUE);
                            jSCallback.invoke(hashMap3);
                        }
                    }
                });
            } else if (jSCallback != null) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("success", Boolean.FALSE);
                hashMap3.put(ERRORDESC, "Image does not have the correct src");
                jSCallback.invoke(hashMap3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        int i = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -1285653259:
                if (str.equals(Constants.Name.AUTO_RECYCLE)) {
                    c = 0;
                    break;
                }
                break;
            case -1274492040:
                if (str.equals(Constants.Name.FILTER)) {
                    c = 1;
                    break;
                }
                break;
            case -934437708:
                if (str.equals(Constants.Name.RESIZE)) {
                    c = 2;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c = 3;
                    break;
                }
                break;
            case 1249477412:
                if (str.equals(Constants.Name.IMAGE_QUALITY)) {
                    c = 4;
                    break;
                }
                break;
            case 2049757303:
                if (str.equals(Constants.Name.RESIZE_MODE)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                boolean booleanValue = WXUtils.getBoolean(obj, Boolean.valueOf(this.mAutoRecycle)).booleanValue();
                this.mAutoRecycle = booleanValue;
                if (!booleanValue && getInstance() != null) {
                    getInstance().getApmForInstance().B(WXInstanceApm.KEY_PAGE_STATS_IMG_UN_RECYCLE_NUM, 1.0d);
                }
                return true;
            case 1:
                if (obj != null && (obj instanceof String)) {
                    i = parseBlurRadius((String) obj);
                }
                if (!TextUtils.isEmpty(this.mSrc)) {
                    setBlurRadius(this.mSrc, i);
                }
                return true;
            case 2:
                String string = WXUtils.getString(obj, null);
                if (string != null) {
                    setResize(string);
                }
                return true;
            case 3:
                String string2 = WXUtils.getString(obj, null);
                if (string2 != null) {
                    setSrc(string2);
                }
                return true;
            case 4:
                break;
            case 5:
                String string3 = WXUtils.getString(obj, null);
                if (string3 != null) {
                    setResizeMode(string3);
                    break;
                }
                break;
            default:
                return super.setProperty(str, obj);
        }
        return true;
    }

    @WXComponentProp(name = Constants.Name.RESIZE)
    public void setResize(String str) {
        setResizeMode(str);
    }

    @WXComponentProp(name = Constants.Name.RESIZE_MODE)
    public void setResizeMode(String str) {
        getHostView().setScaleType(getResizeMode(str));
        getHostView().setImageDrawable(getHostView().getDrawable());
    }

    @WXComponentProp(name = "src")
    public void setSrc(String str) {
        if (getInstance().getImageNetworkHandler() != null) {
            String fetchLocal = getInstance().getImageNetworkHandler().fetchLocal(str);
            if (!TextUtils.isEmpty(fetchLocal)) {
                str = fetchLocal;
            }
        }
        if (str == null) {
            return;
        }
        ImageView hostView = getHostView();
        if ("".equals(str) && hostView != null) {
            hostView.setImageDrawable(null);
            return;
        }
        if (hostView != null && hostView.getDrawable() != null && !TextUtils.equals(this.mSrc, str)) {
            hostView.setImageDrawable(null);
        }
        this.mSrc = str;
        Uri rewriteUri = getInstance().rewriteUri(Uri.parse(str), "image");
        if ("local".equals(rewriteUri.getScheme())) {
            setLocalSrc(rewriteUri);
        } else {
            setRemoteSrc(rewriteUri, parseBlurRadius(getStyles().getBlur()));
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(Map<String, Object> map) {
        super.updateProperties(map);
        updateBorderRadius();
    }

    public WXImage(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mAutoRecycle = true;
        this.preImgUrlStr = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.taobao.weex.ui.component.WXComponent
    public ImageView initComponentHostView(@NonNull Context context) {
        WXImageView wXImageView = new WXImageView(context);
        wXImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (Build.VERSION.SDK_INT >= 16) {
            wXImageView.setCropToPadding(true);
        }
        wXImageView.holdComponent(this);
        return wXImageView;
    }
}
