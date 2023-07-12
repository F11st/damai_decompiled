package com.ali.user.mobile.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ElderUtil {
    public static void fontScale(Activity activity) {
    }

    public static int getScaleSize(int i) {
        if (DataProviderFactory.getDataProvider().enableElder()) {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions != null && loginApprearanceExtensions.getScaleHelper() != null) {
                try {
                    return ((IElderScale) AliUserLogin.mAppreanceExtentions.getScaleHelper().newInstance()).getScale(i);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                }
            }
            if (i < 12) {
                return 15;
            }
            if (i < 12 || i >= 15) {
                if (i < 15 || i >= 18) {
                    return (i < 18 || i >= 21) ? 30 : 24;
                }
                return 21;
            }
            return 18;
        }
        return i;
    }

    public static void scaleTextSize(TextView... textViewArr) {
        if (DataProviderFactory.getDataProvider().enableElder()) {
            for (TextView textView : textViewArr) {
                if (textView != null) {
                    int pxTodip = ScreenUtil.pxTodip(DataProviderFactory.getApplicationContext(), textView.getTextSize());
                    int scaleSize = getScaleSize(pxTodip);
                    if (scaleSize != pxTodip) {
                        textView.setTextSize(1, scaleSize);
                    }
                }
            }
        }
    }

    public static void viewScale(final View view, final float f, final int i) {
        if (DataProviderFactory.getDataProvider().enableElder() && view != null) {
            view.post(new Runnable() { // from class: com.ali.user.mobile.utils.ElderUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.width = Math.round(view.getWidth() * f);
                    layoutParams.height = Math.round(view.getHeight() * f);
                    try {
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = i;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    view.setLayoutParams(layoutParams);
                }
            });
        }
    }
}
