package com.youku.resource.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.youku.resource.R;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Utils {
    public static String getAddFollow1Path() {
        return "addfollow1.json";
    }

    public static String getAddFollow2Path() {
        return "addfollow2.json";
    }

    public static String getAddFollow3Path() {
        return "addfollow3.json";
    }

    public static String getAddFollow4Path() {
        return "addfollow4.json";
    }

    public static String getAddReservationGoldPath() {
        return "addreservation_gold.json";
    }

    public static String getAddReservationPath() {
        return "addreservation.json";
    }

    public static String getBirdJsonPath() {
        return "copyright_bird.json";
    }

    public static String getCancelFollow1Path() {
        return "cancelfollow1.json";
    }

    public static String getCancelFollow2Path() {
        return "cancelfollow2.json";
    }

    public static String getCancelFollow3Path() {
        return "cancelfollow3.json";
    }

    public static String getCancelFollow4Path() {
        return "cancelfollow4.json";
    }

    public static String getCancelReservationGoldPath() {
        return "cancelreservation_gold.json";
    }

    public static String getCancelReservationPath() {
        return "cancelreservation.json";
    }

    public static int getColorWithAlpha(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    public static String getCopyrightMonkeyJsonPath() {
        return "copyright_monkey.json";
    }

    public static GradientDrawable getDrawable(int i, int i2, int i3, float f, int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        if (i3 != 0) {
            gradientDrawable.setStroke(i3, i2);
            gradientDrawable.setColor(0);
        }
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setAlpha(i4);
        return gradientDrawable;
    }

    public static String getEmptyMonkeyJsonPath() {
        return "empty_monkey.json";
    }

    public static int getEndColor(Context context, int i) {
        if (AppPerfABUtils.isOpenPerf()) {
            if (i == 1) {
                return Color.parseColor("#FF6DE7F3");
            }
            if (i == 2) {
                return Color.parseColor("#FFFFAB9C");
            }
            if (i == 3) {
                return Color.parseColor("#FFFFFADC");
            }
            if (i == 4) {
                return Color.parseColor("#99000000");
            }
            return Color.parseColor("#e6f92253");
        }
        Color.parseColor("#66000000");
        if (i == 1) {
            return context.getResources().getColor(R.C8071color.cb_2);
        }
        if (i == 2) {
            return context.getResources().getColor(R.C8071color.cr_1);
        }
        if (i == 3) {
            return context.getResources().getColor(R.C8071color.cv_1);
        }
        if (i == 4) {
            return Color.parseColor("#99000000");
        }
        return Color.parseColor("#e6f92253");
    }

    public static String getFavCancelIconGoldPath() {
        return "favcancelicon_gold.json";
    }

    public static String getFavCancelIconPath() {
        return "favcancelicon.json";
    }

    public static String getFavCancelPath() {
        return "favcancel.json";
    }

    public static String getFavConfirmIconGoldPath() {
        return "favconfirmicon_gold.json";
    }

    public static String getFavConfirmIconPath() {
        return "favconfirmicon.json";
    }

    public static String getFavConfirmPath() {
        return "favconfim.json";
    }

    public static int getHeight(Context context) {
        return ((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getHeight();
    }

    public static String getLoginMonkeyJsonPath() {
        return "login_monkey.json";
    }

    public static int getStartColor(Context context, int i) {
        if (AppPerfABUtils.isOpenPerf()) {
            if (i == 1) {
                return Color.parseColor("#FF4BB5FF");
            }
            if (i == 2) {
                return Color.parseColor("#FFFF658D");
            }
            if (i == 3) {
                return Color.parseColor("#FFFFC19F");
            }
            if (i == 4) {
                return ColorResourceUtils.color_99000000;
            }
            return ColorResourceUtils.color_e6f92253;
        }
        Color.parseColor("#66000000");
        if (i == 1) {
            return context.getResources().getColor(R.C8071color.cb_2);
        }
        if (i == 2) {
            return context.getResources().getColor(R.C8071color.cr_1);
        }
        if (i == 3) {
            return context.getResources().getColor(R.C8071color.cv_1);
        }
        if (i == 4) {
            return Color.parseColor("#99000000");
        }
        return Color.parseColor("#e6f92253");
    }

    public static int getTextColor(Context context, int i) {
        if (i == 3) {
            return Color.parseColor("#FF4E2D03");
        }
        return -1;
    }

    public static String getThumbsupFirstIconPath() {
        return "thumbs_up_first_52.json";
    }

    public static String getThumbsupIconPath() {
        return "thumbs_up_52.json";
    }

    public static String getUploadMonkeyJsonPath() {
        return "upload_monkey.json";
    }

    public static int getWidth(Context context) {
        return ((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getWidth();
    }

    public static String getWifiMonkeyJsonPath() {
        return "wifi_monkey.json";
    }

    public static boolean isDebug(Context context) {
        return (context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static int maxDeep(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 0) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                int maxDeep = maxDeep(viewGroup.getChildAt(i2)) + 1;
                if (maxDeep > i) {
                    i = maxDeep;
                }
            }
            return i;
        }
        return 0;
    }

    public static ViewGroup.LayoutParams setViewMargin(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (view == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        marginLayoutParams.setMargins(i, i3, i2, i4);
        view.setLayoutParams(marginLayoutParams);
        return marginLayoutParams;
    }

    public static Drawable zoomDrawable(Drawable drawable, Resources resources, int i, int i2) {
        if (drawable == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        int width = bitmapDrawable.getBitmap().getWidth();
        int height = bitmapDrawable.getBitmap().getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return new BitmapDrawable(resources, Bitmap.createBitmap(bitmapDrawable.getBitmap(), 0, 0, width, height, matrix, true));
    }

    public static GradientDrawable getDrawable(GradientDrawable.Orientation orientation, int[] iArr, int i, int i2, float f, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
        if (i2 != 0) {
            gradientDrawable.setStroke(i2, i);
        }
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setAlpha(i3);
        return gradientDrawable;
    }
}
