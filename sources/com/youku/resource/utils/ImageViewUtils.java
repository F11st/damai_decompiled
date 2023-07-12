package com.youku.resource.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.taobao.uikit.extend.feature.features.PhenixOptions;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.middlewareservice.provider.LogProviderProxy;
import com.youku.resource.R;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ImageViewUtils {
    private static final String TAG = "ImageViewUtils";
    private static boolean sNoResizeForR1YkimgCom = AppPerfABUtils.isNoResizeR1YkimgCom();
    private static Handler sSetImageHandler = null;
    private static ThreadLocal<StringBuilder> sAppendingUrl = new ThreadLocal<StringBuilder>() { // from class: com.youku.resource.utils.ImageViewUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder(256);
        }
    };
    private static int sCommonMargin = -1;
    private static int sCommonDiv = -1;
    private static int p3s1ImgWidth = -1;
    private static int[] imgWidthForSpan = new int[4];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class SetImageUrlRunnable implements Runnable {
        public TUrlImageView imageView;
        public boolean noResize;
        public PhenixOptions options;
        public String url;

        private SetImageUrlRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.imageView.setImageUrl(this.url, this.options);
            } catch (Exception e) {
                LogProviderProxy.loge(ImageViewUtils.TAG, "SetImageUrlRunnable.run: " + e.getMessage(), e);
                this.imageView.postInvalidate();
            }
        }
    }

    private ImageViewUtils() {
    }

    public static String appendParamsToUrl(String str, boolean z) {
        return appendParamsToUrl(str, z, false);
    }

    public static String appendSizeParamForR1YkimgCom(Context context, String str, int i, int i2) {
        return (TextUtils.isEmpty(str) || !str.contains("://r1.ykimg.com/") || str.contains("noResize=1")) ? str : appendSizeParamsToImgUrl(str, i, i2, true);
    }

    public static String appendSizeParamsToImgUrl(@NonNull String str, int i, int i2, boolean z) {
        if (i <= 0 || i2 <= 0) {
            return str;
        }
        StringBuilder sb = sAppendingUrl.get();
        sb.setLength(0);
        sb.append(str);
        if (str.indexOf(63) >= 0) {
            sb.append('&');
        } else {
            sb.append(jn1.CONDITION_IF);
        }
        sb.append("x-oss-process=image/resize,h_");
        sb.append(i2);
        sb.append(",w_");
        sb.append(i);
        sb.append(",m_fill,limit_0");
        if (z) {
            sb.append("/format,webp");
        }
        return sb.toString();
    }

    public static int[] getCalculatedSize(Context context, int i, int i2, int i3, int i4, int i5) {
        return getCalculatedSize(context, i, i2, i3, i4, i5, null);
    }

    public static int getImageWidthForSpan(@NonNull Context context, int i) {
        if (i <= 0 || i >= 4) {
            return 0;
        }
        if (imgWidthForSpan[i] <= 0) {
            initMarginAndDiv(context);
            imgWidthForSpan[i] = ((DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()) - (sCommonMargin * 2)) - ((i - 1) * sCommonDiv)) / i;
        }
        return imgWidthForSpan[i];
    }

    public static int getP3S1ImgWdith(@NonNull Context context) {
        if (p3s1ImgWidth < 0) {
            initMarginAndDiv(context);
            int i = DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()) - (sCommonMargin * 2);
            int i2 = sCommonDiv;
            p3s1ImgWidth = ((i - (i2 * 2)) / 3) - i2;
        }
        return p3s1ImgWidth;
    }

    public static String getStaticImageUrl(String str) {
        boolean z;
        String queryParameter;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String lowerCase = str.toLowerCase();
        boolean z2 = false;
        if (lowerCase.endsWith(".gif")) {
            if (!str.contains("x-oss-process=")) {
                return str + "?x-oss-process=image/format,png";
            }
        } else if (!lowerCase.contains(".gif?")) {
            z = false;
            if (!z && (queryParameter = Uri.parse(str).getQueryParameter("x-oss-process")) != null) {
                String[] split = queryParameter.split("/");
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String str2 = split[i];
                        if (str2 != null && str2.startsWith("format,")) {
                            str = str.replace(str2, "format,png");
                            z2 = true;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (z2) {
                    return str;
                }
                return str.replace(queryParameter, queryParameter + "/format,png");
            }
        } else if (!str.contains("x-oss-process=")) {
            return str + "&x-oss-process=image/format,png";
        }
        z = true;
        return !z ? str : str;
    }

    public static void initImageHandler() {
        if (sSetImageHandler == null) {
            HandlerThread handlerThread = new HandlerThread("setImageUrl");
            handlerThread.start();
            sSetImageHandler = new Handler(handlerThread.getLooper());
        }
    }

    private static void initMarginAndDiv(Context context) {
        if (sCommonMargin <= 0) {
            Resources resources = context.getResources();
            sCommonMargin = resources.getDimensionPixelSize(R.dimen.dim_9);
            sCommonDiv = resources.getDimensionPixelSize(R.dimen.dim_6);
        }
    }

    public static boolean isGif(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(".gif") || str.contains(".GIF");
    }

    public static boolean isNoResizeForR1YkimgCom() {
        return sNoResizeForR1YkimgCom;
    }

    public static void setImageUrlInBackground(TUrlImageView tUrlImageView, String str) {
        setImageUrlInBackground(tUrlImageView, str, false);
    }

    public static void setImageUrlInBackgroundDouble(TUrlImageView tUrlImageView, String str) {
        setImageUrlInBackgroundInner(tUrlImageView, str, !AppPerfABUtils.isOpenBackgroundSetImageUrlDouble(), false, null, false);
    }

    private static void setImageUrlInBackgroundInner(TUrlImageView tUrlImageView, String str, boolean z, boolean z2, PhenixOptions phenixOptions, boolean z3) {
        String appendParamsToUrl = appendParamsToUrl(str, z2, z3);
        if (!TextUtils.equals(appendParamsToUrl, tUrlImageView.getImageUrl())) {
            tUrlImageView.setImageUrl(null);
        }
        if (z) {
            tUrlImageView.setImageUrl(appendParamsToUrl, phenixOptions);
            return;
        }
        initImageHandler();
        SetImageUrlRunnable setImageUrlRunnable = new SetImageUrlRunnable();
        setImageUrlRunnable.imageView = tUrlImageView;
        setImageUrlRunnable.url = appendParamsToUrl;
        setImageUrlRunnable.noResize = z2;
        setImageUrlRunnable.options = phenixOptions;
        sSetImageHandler.post(setImageUrlRunnable);
    }

    public static boolean setImageUrlInBackgroundWithSize(TUrlImageView tUrlImageView, String str, int i, int i2) {
        String appendSizeParamForR1YkimgCom = !sNoResizeForR1YkimgCom ? appendSizeParamForR1YkimgCom(tUrlImageView.getContext(), str, i, i2) : str;
        setImageUrlInBackground(tUrlImageView, appendSizeParamForR1YkimgCom, false);
        return appendSizeParamForR1YkimgCom != str;
    }

    public static void setsCommonDiv(int i) {
        sCommonDiv = i;
    }

    public static void setsCommonMargin(int i) {
        sCommonMargin = i;
    }

    public static String appendParamsToUrl(String str, boolean z, boolean z2) {
        if (AppPerfABUtils.isForbidGifImg() && !z2) {
            str = getStaticImageUrl(str);
        }
        if (z) {
            if (str.contains("?")) {
                return str + "&noResize=1";
            }
            return str + "?noResize=1";
        }
        return str;
    }

    public static int[] getCalculatedSize(Context context, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        if (iArr == null) {
            iArr = new int[2];
        }
        initMarginAndDiv(context);
        if (i4 == -1) {
            i4 = sCommonMargin;
        }
        if (i5 == -1) {
            i5 = sCommonDiv;
        }
        if (i != 1) {
            if (i == 2) {
                i6 = (i2 * 3) / 2;
            } else if (i == 3) {
                i6 = (i2 * 4) / 3;
            } else if (i == 4) {
                i6 = (i2 * 3) / 4;
            } else if (i == 9) {
                i6 = (i2 * 16) / 9;
            } else if (i == 16) {
                i6 = (i2 * 9) / 16;
            } else if (i == 91) {
                i2 = ((Math.min(DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics())) - (i4 * 2)) - (i5 * 2)) / 3;
                i6 = (i2 * 16) / 9;
            } else if (i == 41) {
                i2 = ((Math.min(DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics())) - (i4 * 2)) - (i5 * 2)) / 3;
                i6 = (i2 * 3) / 4;
            } else if (i == 42) {
                i2 = (((Math.min(DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics())) - (i4 * 2)) - (i5 * 2)) / 3) + i4 + 1;
                i6 = (i2 * 3) / 4;
            } else if (i == 998) {
                i6 = i2 / 2;
            } else if (i != 999) {
                switch (i) {
                    case 11:
                        i2 = ((Math.min(DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics())) - (i4 * 2)) - (i5 * 2)) / 3;
                        break;
                    case 12:
                        i2 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_81);
                        break;
                    case 13:
                        i2 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_52);
                        break;
                    case 14:
                        i2 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_40);
                        break;
                    default:
                        switch (i) {
                            case 21:
                                i2 = (((Math.min(DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics())) - (i4 * 2)) - (i5 * 2)) / 3) - i5;
                                i6 = (i2 * 3) / 2;
                                break;
                            case 22:
                                i2 = (((Math.min(DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics())) - (i4 * 2)) - (i5 * 2)) / 3) + i4 + 1;
                                i6 = (i2 * 3) / 2;
                                break;
                            case 23:
                                i2 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_60);
                                i6 = (i2 * 3) / 2;
                                break;
                            default:
                                switch (i) {
                                    case 31:
                                    case 32:
                                        i2 = ((Math.min(DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics())) - (i4 * 2)) - (i5 * 2)) / 3;
                                        i6 = (i2 * 4) / 3;
                                        break;
                                    case 33:
                                        i2 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_60);
                                        i6 = (i2 * 4) / 3;
                                        break;
                                    case 34:
                                        i2 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_36);
                                        i6 = (i2 * 4) / 3;
                                        break;
                                    default:
                                        switch (i) {
                                            case 161:
                                                i2 = (((Math.min(DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics())) - (i4 * 2)) - (i5 * 2)) / 3) + i4 + 1;
                                                i6 = (i2 * 9) / 16;
                                                break;
                                            case 162:
                                                i2 = ((Math.min(DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics())) - (i4 * 2)) - (i5 * 2)) / 3;
                                                i6 = (i2 * 9) / 16;
                                                break;
                                            case 163:
                                                i2 = (Math.min(DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()), DisplayMetrics.getheightPixels(context.getResources().getDisplayMetrics())) - (i4 * 2)) - (i4 * 6);
                                                i6 = (i2 * 9) / 16;
                                                break;
                                            default:
                                                i6 = i3;
                                                break;
                                        }
                                }
                        }
                }
            } else {
                i6 = (i2 * 9) / 16;
            }
            iArr[0] = i2;
            iArr[1] = i6;
            return iArr;
        }
        i6 = i2;
        iArr[0] = i2;
        iArr[1] = i6;
        return iArr;
    }

    public static void setImageUrlInBackground(TUrlImageView tUrlImageView, String str, PhenixOptions phenixOptions) {
        setImageUrlInBackgroundInner(tUrlImageView, str, AppPerfABUtils.isDisableBackgroundSetImageUrl(), false, phenixOptions, false);
    }

    public static void setImageUrlInBackground(TUrlImageView tUrlImageView, String str, boolean z, boolean z2) {
        setImageUrlInBackgroundInner(tUrlImageView, str, AppPerfABUtils.isDisableBackgroundSetImageUrl(), z, null, z2);
    }

    public static void setImageUrlInBackground(TUrlImageView tUrlImageView, String str, boolean z) {
        setImageUrlInBackgroundInner(tUrlImageView, str, AppPerfABUtils.isDisableBackgroundSetImageUrl(), z, null, false);
    }
}
