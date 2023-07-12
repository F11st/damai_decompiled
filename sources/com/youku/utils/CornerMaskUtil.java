package com.youku.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.baseproject.basecard.widget.CustomView;
import com.baseproject.basecard.widget.WithCornerMaskImageView;
import com.baseproject.basecard.widget.WithMaskImageView;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$drawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.weex.annotation.JSMethod;
import tb.h62;
import tb.ui2;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CornerMaskUtil {
    private static final String TAG = "CornerMaskUtil";
    public static final int TYPEV_VIP_FOUR = 4;
    public static final int TYPE_ACTIVITY_TWO = 2;
    public static final int TYPE_AD_SEVEN = 7;
    public static final int TYPE_AD_TEN = 10;
    public static final int TYPE_OPERATION_THREE = 3;
    public static final int TYPE_RECOMMEND_SIX = 6;
    private static LruCache<String, Drawable> mDrabblecache = new LruCache<>(32);
    private static LruCache<String, Bitmap> mBitmapCache = new LruCache<>(32);

    public static void clearCornerMask(ImageView imageView) {
        if (imageView instanceof WithCornerMaskImageView) {
            ((WithCornerMaskImageView) imageView).setMask(null);
        } else if (imageView instanceof WithMaskImageView) {
            ((WithMaskImageView) imageView).removeCornerMask();
        }
    }

    public static void clearStripeMiddleMark(ImageView imageView) {
        if (imageView instanceof WithMaskImageView) {
            ((WithMaskImageView) imageView).removeStripeMiddleMask();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBitmapKey(String str, int i) {
        return str + JSMethod.NOT_SET + i;
    }

    private static int getCornerColor(int i) {
        if (i == 4) {
            return Color.parseColor("#E6CCA558");
        }
        if (i == 6) {
            return Color.parseColor("#99000000");
        }
        if (i == 7) {
            return Color.parseColor("#99000000");
        }
        if (i == 10) {
            return Color.parseColor("#E63882FF");
        }
        return Color.parseColor("#E6F92253");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getDrawableKey(String str, int i, int i2, int i3) {
        return str + JSMethod.NOT_SET + i + JSMethod.NOT_SET + i2 + JSMethod.NOT_SET + i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap getRoundBitmap(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        float f = i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static void setCornerMark(Context context, int i, String str, ImageView imageView) {
        setCornerMark(context, i, str, imageView, (View) null);
    }

    public static void setCornerMarkData(Context context, int i, String str, ImageView imageView) {
        setCornerMarkData(context, i, str, imageView, (View) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setMask(Drawable drawable, View view, ImageView imageView) {
        if (view == null) {
            if (imageView instanceof WithCornerMaskImageView) {
                ((WithCornerMaskImageView) imageView).setMask(drawable);
                return;
            } else if (imageView instanceof WithMaskImageView) {
                ((WithMaskImageView) imageView).setCornerMask(drawable);
                return;
            } else {
                return;
            }
        }
        ((CustomView) view).setMask(drawable);
    }

    public static void setCornerMark(Context context, int i, String str, ImageView imageView, boolean z) {
        setCornerMark(context, i, str, imageView, null, z);
    }

    public static void setCornerMarkData(Context context, int i, String str, ImageView imageView, boolean z) {
        setCornerMarkData(context, i, str, imageView, null, z);
    }

    public static void setCornerMark(Context context, int i, String str, ImageView imageView, View view) {
        setCornerMark(context, i, str, imageView, view, true);
    }

    public static void setCornerMarkData(Context context, int i, String str, ImageView imageView, View view) {
        setCornerMarkData(context, i, str, imageView, view, true);
    }

    public static void setCornerMark(Context context, final int i, final String str, final ImageView imageView, final View view, boolean z) {
        Resources resources = context.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.home_personal_movie_22px);
        final int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.home_personal_movie_6px);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.home_personal_movie_32px);
        final int dimensionPixelSize3 = z ? resources.getDimensionPixelSize(R$dimen.home_personal_movie_12px) : 0;
        final int dimensionPixelSize4 = resources.getDimensionPixelSize(R$dimen.home_personal_movie_4px);
        int i2 = R$drawable.corner_mark_red;
        if (i == 4) {
            i2 = R$drawable.corner_mark_yellow;
        } else if (i == 6) {
            i2 = R$drawable.corner_mark_black;
        } else if (i == 7) {
            i2 = R$drawable.corner_mark_black;
        } else if (i == 10) {
            i2 = R$drawable.corner_mark_blue;
        }
        final int cornerColor = getCornerColor(i);
        ur1.o().s(h62.r(i2)).Q(new IPhenixListener<ui2>() { // from class: com.youku.utils.CornerMaskUtil.3
            @Override // com.taobao.phenix.intf.event.IPhenixListener
            public boolean onHappen(ui2 ui2Var) {
                System.nanoTime();
                if (ui2Var != null) {
                    Drawable drawable = (Drawable) CornerMaskUtil.mDrabblecache.get(CornerMaskUtil.getDrawableKey(str, i, imageView.getWidth(), imageView.getHeight()));
                    if (drawable == null) {
                        Paint paint = new Paint(5);
                        paint.setTextSize(dimensionPixelSize);
                        paint.setColor(-1);
                        paint.setFakeBoldText(true);
                        Bitmap bitmap = (Bitmap) CornerMaskUtil.mBitmapCache.get(CornerMaskUtil.getBitmapKey(str, i));
                        if (bitmap == null) {
                            Bitmap createBitmap = Bitmap.createBitmap((int) (paint.measureText(str) + (dimensionPixelOffset * 2)), dimensionPixelSize2, Bitmap.Config.ARGB_8888);
                            createBitmap.eraseColor(cornerColor);
                            bitmap = CornerMaskUtil.getRoundBitmap(createBitmap, dimensionPixelSize4);
                            float width = (bitmap.getWidth() / 2) - (paint.measureText(str) / 2.0f);
                            Canvas canvas = new Canvas(bitmap);
                            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                            float f = fontMetrics.descent;
                            canvas.drawText(str, width, ((dimensionPixelSize2 / 2) - f) + ((f - fontMetrics.ascent) / 2.0f), paint);
                            canvas.save(31);
                            canvas.restore();
                            CornerMaskUtil.mBitmapCache.put(CornerMaskUtil.getBitmapKey(str, i), bitmap);
                        }
                        drawable = new BitmapDrawable(imageView.getResources(), bitmap);
                        int width2 = imageView.getWidth() - dimensionPixelSize3;
                        int i3 = dimensionPixelSize3;
                        drawable.setBounds(width2 - bitmap.getWidth(), i3, width2, dimensionPixelSize2 + i3);
                        CornerMaskUtil.mDrabblecache.put(CornerMaskUtil.getDrawableKey(str, i, imageView.getWidth(), imageView.getHeight()), drawable);
                    }
                    CornerMaskUtil.setMask(drawable, view, imageView);
                    imageView.post(new Runnable() { // from class: com.youku.utils.CornerMaskUtil.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.postInvalidate();
                        }
                    });
                    return false;
                }
                return false;
            }
        }).n();
    }

    public static void setCornerMarkData(final Context context, final int i, final String str, final ImageView imageView, final View view, final boolean z) {
        if (view == null) {
            if (imageView.getHeight() > 0) {
                setCornerMark(context, i, str, imageView, z);
            } else {
                imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.youku.utils.CornerMaskUtil.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        CornerMaskUtil.setCornerMark(context, i, str, imageView, z);
                        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                        if (Build.VERSION.SDK_INT >= 16) {
                            viewTreeObserver.removeOnGlobalLayoutListener(this);
                        } else {
                            viewTreeObserver.removeGlobalOnLayoutListener(this);
                        }
                    }
                });
            }
        } else if (view.getHeight() > 0) {
            setCornerMark(context, i, str, imageView, view, z);
        } else {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.youku.utils.CornerMaskUtil.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    CornerMaskUtil.setCornerMark(context, i, str, imageView, view, z);
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }
}
