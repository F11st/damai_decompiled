package com.youku.youkuplayer.plugin.watermark;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.youku.youkuplayer.IWaterMarkImageViewWrap;
import com.youku.youkuplayer.plugin.watermark.WaterMarkBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WaterMarkRootView extends FrameLayout {
    private static final String TAG = "WaterMarkView";
    private IWaterMarkImageViewWrap extWaterMarkImageView;
    private Configuration mConfiguration;
    private int mCurrentPosition;
    private final Handler mUiHandler;
    private List<WaterMarkWrap> mWaterMarks;

    public WaterMarkRootView(@NonNull Context context) {
        super(context);
        this.mUiHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canShow(WaterMarkBean waterMarkBean) {
        int i;
        Configuration configuration = this.mConfiguration;
        if (configuration == null || (i = configuration.orientation) == 1) {
            boolean z = getHeight() > getWidth();
            int i2 = waterMarkBean.displayMode;
            return z ? i2 == 0 || i2 == 2 : i2 == 0 || i2 == 3;
        } else if (i == 2) {
            int i3 = waterMarkBean.displayMode;
            return i3 == 0 || i3 == 1;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        this.mUiHandler.post(new Runnable() { // from class: com.youku.youkuplayer.plugin.watermark.WaterMarkRootView.3
            @Override // java.lang.Runnable
            public void run() {
                if (WaterMarkRootView.this.mWaterMarks == null) {
                    return;
                }
                for (int i = 0; i < WaterMarkRootView.this.mWaterMarks.size(); i++) {
                    WaterMarkWrap waterMarkWrap = (WaterMarkWrap) WaterMarkRootView.this.mWaterMarks.get(i);
                    WaterMarkBean waterMarkBean = waterMarkWrap.getWaterMarkBean();
                    if (WaterMarkRootView.this.canShow(waterMarkBean)) {
                        WaterMarkBean.DisplayDTOS displayDTOS = waterMarkBean.getDisplayDTOS(WaterMarkRootView.this.mCurrentPosition);
                        if (displayDTOS != null) {
                            waterMarkWrap.updateDisplayDTOS(displayDTOS);
                            if (waterMarkWrap.isRefresh(displayDTOS)) {
                                waterMarkWrap.show();
                            }
                        }
                    } else {
                        waterMarkWrap.hide();
                    }
                }
            }
        });
    }

    public void bindData(final Collection<WaterMarkBean> collection) {
        this.mUiHandler.post(new Runnable() { // from class: com.youku.youkuplayer.plugin.watermark.WaterMarkRootView.1
            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                WaterMarkWrap waterMarkWrap;
                if (WaterMarkRootView.this.getChildCount() > 0) {
                    WaterMarkRootView.this.removeAllViews();
                }
                WaterMarkRootView.this.mWaterMarks = new ArrayList();
                for (WaterMarkBean waterMarkBean : collection) {
                    WaterMarkBean.DisplayDTOS displayDTOS = waterMarkBean.getDisplayDTOS(WaterMarkRootView.this.mCurrentPosition);
                    if (displayDTOS != null) {
                        if (waterMarkBean.rsType == 1) {
                            WaterMarkTextView waterMarkTextView = new WaterMarkTextView(WaterMarkRootView.this.getContext(), waterMarkBean, displayDTOS);
                            WaterMarkRootView.this.addView(waterMarkTextView);
                            waterMarkWrap = new WaterMarkWrap(waterMarkTextView, waterMarkBean, displayDTOS);
                        } else {
                            if (WaterMarkRootView.this.extWaterMarkImageView == null || WaterMarkRootView.this.extWaterMarkImageView.getWaterMarkImageView() == null) {
                                imageView = new WaterMarkTextView(WaterMarkRootView.this.getContext(), waterMarkBean, displayDTOS);
                            } else {
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                WaterMarkUtil.setLayoutParams(WaterMarkRootView.this.getContext(), layoutParams, waterMarkBean.refCoord, displayDTOS);
                                ImageView waterMarkImageView = WaterMarkRootView.this.extWaterMarkImageView.getWaterMarkImageView();
                                waterMarkImageView.setLayoutParams(layoutParams);
                                WaterMarkRootView.this.extWaterMarkImageView.setImageUrl(waterMarkImageView, waterMarkBean.rsUrl);
                                ViewParent parent = waterMarkImageView.getParent();
                                imageView = waterMarkImageView;
                                if (parent != null) {
                                    imageView = waterMarkImageView;
                                    if (parent instanceof ViewGroup) {
                                        ((ViewGroup) parent).removeView(waterMarkImageView);
                                        imageView = waterMarkImageView;
                                    }
                                }
                            }
                            WaterMarkRootView.this.addView(imageView);
                            waterMarkWrap = new WaterMarkWrap(imageView, waterMarkBean, displayDTOS);
                        }
                        WaterMarkRootView.this.mWaterMarks.add(waterMarkWrap);
                        if (WaterMarkRootView.this.canShow(waterMarkBean)) {
                            waterMarkWrap.show();
                        } else {
                            waterMarkWrap.hide();
                        }
                    }
                }
            }
        });
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mConfiguration = configuration;
        refresh();
    }

    public void onSizeChanged(final int i, final int i2) {
        this.mUiHandler.post(new Runnable() { // from class: com.youku.youkuplayer.plugin.watermark.WaterMarkRootView.4
            @Override // java.lang.Runnable
            public void run() {
                WaterMarkRootView.this.getLayoutParams().width = i;
                WaterMarkRootView.this.getLayoutParams().height = i2;
                WaterMarkRootView.this.requestLayout();
            }
        });
    }

    public void setExtWaterMarkImageView(IWaterMarkImageViewWrap iWaterMarkImageViewWrap) {
        this.extWaterMarkImageView = iWaterMarkImageViewWrap;
    }

    public void updateCurrentPosition(final int i) {
        this.mUiHandler.post(new Runnable() { // from class: com.youku.youkuplayer.plugin.watermark.WaterMarkRootView.2
            @Override // java.lang.Runnable
            public void run() {
                WaterMarkRootView.this.mCurrentPosition = i;
                WaterMarkRootView.this.refresh();
            }
        });
    }
}
