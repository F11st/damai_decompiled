package com.youku.tinywindow.floatwindow;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.google.android.material.badge.BadgeDrawable;
import com.youku.tinywindow.R;
import com.youku.tinywindow.utils.TinyLogger;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FloatWindowManager {
    private static final String TAG = "FloatWindowManager";
    private static FloatingLayout mFloatLayout;
    private static boolean mHasShown;
    private static boolean mIsMute;
    private static boolean mIsPause;
    private static FrameLayout mPlayerLayout;
    private static WindowManager mWindowManager;
    private static WindowManager.LayoutParams wmParams;

    public static void createFloatWindow(Context context, View view, int i, int i2, boolean z, boolean z2, final FloatingWindowClickCallBack floatingWindowClickCallBack) {
        mIsMute = z;
        mIsPause = z2;
        wmParams = new WindowManager.LayoutParams();
        WindowManager windowManager = getWindowManager(context);
        FloatingLayout floatingLayout = new FloatingLayout(context, floatingWindowClickCallBack);
        mFloatLayout = floatingLayout;
        mPlayerLayout = (FrameLayout) floatingLayout.findViewById(R.id.content);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        TinyLogger.log(TAG, "floatingwindow width is" + i + " height is" + i2);
        mPlayerLayout.addView(view, layoutParams);
        ((RelativeLayout) mFloatLayout.findViewById(R.id.btn_close_layout)).setOnClickListener(new View.OnClickListener() { // from class: com.youku.tinywindow.floatwindow.FloatWindowManager.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FloatingWindowClickCallBack floatingWindowClickCallBack2 = FloatingWindowClickCallBack.this;
                if (floatingWindowClickCallBack2 != null) {
                    floatingWindowClickCallBack2.onCloseBtnClick();
                }
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) mFloatLayout.findViewById(R.id.btn_mute_layout);
        final ImageButton imageButton = (ImageButton) mFloatLayout.findViewById(R.id.btn_mute);
        if (mIsMute) {
            imageButton.setBackgroundResource(R.drawable.tiny_btn_volume_close);
        } else {
            imageButton.setBackgroundResource(R.drawable.tiny_btn_volume_open);
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.youku.tinywindow.floatwindow.FloatWindowManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean unused = FloatWindowManager.mIsMute = !FloatWindowManager.mIsMute;
                imageButton.setBackgroundResource(FloatWindowManager.mIsMute ? R.drawable.tiny_btn_volume_close : R.drawable.tiny_btn_volume_open);
                FloatingWindowClickCallBack floatingWindowClickCallBack2 = floatingWindowClickCallBack;
                if (floatingWindowClickCallBack2 != null) {
                    floatingWindowClickCallBack2.onMuteBtnClick(FloatWindowManager.mIsMute);
                }
            }
        });
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            wmParams.type = 2038;
        } else if (i3 >= 24) {
            wmParams.type = 2002;
        } else {
            if (context.getPackageManager().checkPermission("android.permission.SYSTEM_ALERT_WINDOW", context.getPackageName()) == 0) {
                wmParams.type = 2002;
            } else {
                wmParams.type = 2005;
            }
        }
        WindowManager.LayoutParams layoutParams2 = wmParams;
        layoutParams2.format = 1;
        layoutParams2.flags = 8;
        layoutParams2.gravity = BadgeDrawable.TOP_START;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(mWindowManager.getDefaultDisplay(), displayMetrics);
        int i4 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i5 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        WindowManager.LayoutParams layoutParams3 = wmParams;
        layoutParams3.x = i4;
        layoutParams3.y = i5;
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        mFloatLayout.setParams(layoutParams3);
        windowManager.addView(mFloatLayout, wmParams);
        mHasShown = true;
    }

    private static WindowManager getWindowManager(Context context) {
        if (mWindowManager == null) {
            mWindowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
        }
        return mWindowManager;
    }

    public static void hide() {
        if (mHasShown) {
            mPlayerLayout.removeAllViews();
            if (mFloatLayout.isAttachedToWindow()) {
                mWindowManager.removeViewImmediate(mFloatLayout);
            }
        }
        mHasShown = false;
    }

    public static void removeFloatWindowManager() {
        WindowManager windowManager;
        FloatingLayout floatingLayout = mFloatLayout;
        if (floatingLayout != null) {
            boolean isAttachedToWindow = Build.VERSION.SDK_INT >= 19 ? floatingLayout.isAttachedToWindow() : true;
            if (mHasShown && isAttachedToWindow && (windowManager = mWindowManager) != null) {
                windowManager.removeView(mFloatLayout);
            }
        }
    }

    public static void show() {
        if (!mHasShown) {
            mWindowManager.addView(mFloatLayout, wmParams);
        }
        mHasShown = true;
    }

    public static void updateMuteState(boolean z) {
        mIsMute = z;
        FloatingLayout floatingLayout = mFloatLayout;
        if (floatingLayout != null) {
            ((ImageButton) floatingLayout.findViewById(R.id.btn_mute)).setBackgroundResource(mIsMute ? R.drawable.tiny_btn_volume_close : R.drawable.tiny_btn_volume_open);
        }
    }

    public static void updatePauseState(boolean z) {
    }
}
