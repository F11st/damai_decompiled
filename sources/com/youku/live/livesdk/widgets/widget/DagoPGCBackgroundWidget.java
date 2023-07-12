package com.youku.live.livesdk.widgets.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.youku.live.livesdk.R;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.ThemeDTO;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import java.util.List;
import tb.ui2;
import tb.ur1;
import tb.wr1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoPGCBackgroundWidget extends BaseWidget implements IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String WIDGET_NAME = "PGCBackground";
    private ImageView mBottomDecorateView;
    private RelativeLayout mContainer;
    private ImageView mPlayerDecorateView;

    private void clearBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099894956")) {
            ipChange.ipc$dispatch("-2099894956", new Object[]{this});
            return;
        }
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(R.drawable.dago_container_live_room_common_bg);
        }
        ImageView imageView = this.mBottomDecorateView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ImageView imageView2 = this.mPlayerDecorateView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
        }
    }

    private int getWindowWidth(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-801461344")) {
            return ((Integer) ipChange.ipc$dispatch("-801461344", new Object[]{this, activity})).intValue();
        }
        try {
            WindowManager windowManager = activity.getWindowManager();
            int width = windowManager.getDefaultDisplay().getWidth();
            int height = windowManager.getDefaultDisplay().getHeight();
            return width < height ? width : height;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private void initWithLiveFullInfoData(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2008077992")) {
            ipChange.ipc$dispatch("2008077992", new Object[]{this, liveFullInfoData});
            return;
        }
        setBackgroundColors(liveFullInfoData);
        setLiveDecorate(liveFullInfoData);
        setBottomDecorate(liveFullInfoData);
        setPlayerDecorate(liveFullInfoData);
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "774741560")) {
            ipChange.ipc$dispatch("774741560", new Object[]{this});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            engineInstance.addDataHandler("mtop.youku.live.com.livefullinfo", this);
        }
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-953849733")) {
            ipChange.ipc$dispatch("-953849733", new Object[]{this});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        if (engineInstance != null) {
            engineInstance.removeDataHandler("mtop.youku.live.com.livefullinfo", this);
        }
    }

    private void setBackgroundColors(LiveFullInfoData liveFullInfoData) {
        ThemeDTO themeDTO;
        List<String> list;
        int[] iArr;
        Drawable gradientDrawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2105842901")) {
            ipChange.ipc$dispatch("-2105842901", new Object[]{this, liveFullInfoData});
        } else if (liveFullInfoData != null && (themeDTO = liveFullInfoData.theme) != null && (list = themeDTO.phoneBackgroundColors) != null) {
            Drawable drawable = null;
            try {
                iArr = new int[list.size()];
                int i = 0;
                for (String str : list) {
                    int i2 = i + 1;
                    iArr[i] = Color.parseColor(str);
                    i = i2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                iArr = null;
            }
            if (iArr != null) {
                try {
                    if (iArr.length == 1) {
                        gradientDrawable = new ColorDrawable(iArr[0]);
                    } else if (iArr.length > 1) {
                        gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
                    }
                    drawable = gradientDrawable;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            RelativeLayout relativeLayout = this.mContainer;
            if (relativeLayout == null || drawable == null) {
                return;
            }
            relativeLayout.setBackground(drawable);
        }
    }

    private void setBottomDecorate(LiveFullInfoData liveFullInfoData) {
        ThemeDTO themeDTO;
        ImageView imageView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998529979")) {
            ipChange.ipc$dispatch("-998529979", new Object[]{this, liveFullInfoData});
        } else if (liveFullInfoData == null || (themeDTO = liveFullInfoData.theme) == null || TextUtils.isEmpty(themeDTO.phoneBottomBackgroundUrl) || (imageView = this.mBottomDecorateView) == null) {
        } else {
            Context context = imageView != null ? imageView.getContext() : null;
            final int[] v = context != null ? wr1.v(context) : null;
            ur1.o().s(liveFullInfoData.theme.phoneBottomBackgroundUrl).Q(new IPhenixListener<ui2>() { // from class: com.youku.live.livesdk.widgets.widget.DagoPGCBackgroundWidget.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(ui2 ui2Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1450326579")) {
                        return ((Boolean) ipChange2.ipc$dispatch("1450326579", new Object[]{this, ui2Var})).booleanValue();
                    }
                    BitmapDrawable f = ui2Var.f();
                    if (f != null) {
                        int intrinsicWidth = f.getIntrinsicWidth();
                        int intrinsicHeight = f.getIntrinsicHeight();
                        ImageView imageView2 = DagoPGCBackgroundWidget.this.mBottomDecorateView;
                        if (imageView2 != null) {
                            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                                try {
                                    int[] iArr = v;
                                    if (iArr != null && iArr.length >= 2 && iArr[0] > 0 && iArr[1] > 0) {
                                        int i = (iArr[0] * intrinsicHeight) / intrinsicWidth;
                                        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
                                        if (layoutParams != null) {
                                            layoutParams.width = -1;
                                            layoutParams.height = i;
                                            imageView2.setLayoutParams(layoutParams);
                                        }
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            imageView2.setImageDrawable(f);
                        }
                    }
                    return false;
                }
            }).n();
        }
    }

    private void setLiveDecorate(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1578398854")) {
            ipChange.ipc$dispatch("1578398854", new Object[]{this, liveFullInfoData});
        }
    }

    private void setPlayerDecorate(final LiveFullInfoData liveFullInfoData) {
        ThemeDTO themeDTO;
        ImageView imageView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598256123")) {
            ipChange.ipc$dispatch("598256123", new Object[]{this, liveFullInfoData});
        } else if (liveFullInfoData == null || (themeDTO = liveFullInfoData.theme) == null || TextUtils.isEmpty(themeDTO.phoneBackgroundUrl) || (imageView = this.mPlayerDecorateView) == null) {
        } else {
            Context context = imageView != null ? imageView.getContext() : null;
            final int[] v = context != null ? wr1.v(context) : null;
            ur1.o().s(liveFullInfoData.theme.phoneBackgroundUrl).Q(new IPhenixListener<ui2>() { // from class: com.youku.live.livesdk.widgets.widget.DagoPGCBackgroundWidget.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(ui2 ui2Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "283630260")) {
                        return ((Boolean) ipChange2.ipc$dispatch("283630260", new Object[]{this, ui2Var})).booleanValue();
                    }
                    BitmapDrawable f = ui2Var.f();
                    if (f != null) {
                        int intrinsicWidth = f.getIntrinsicWidth();
                        int intrinsicHeight = f.getIntrinsicHeight();
                        ImageView imageView2 = DagoPGCBackgroundWidget.this.mPlayerDecorateView;
                        if (imageView2 != null) {
                            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                                try {
                                    int[] iArr = v;
                                    if (iArr != null && iArr.length >= 2 && iArr[0] > 0 && iArr[1] > 0) {
                                        int i = iArr[0];
                                        int i2 = (iArr[0] * intrinsicHeight) / intrinsicWidth;
                                        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
                                        if (layoutParams != null) {
                                            layoutParams.width = -1;
                                            layoutParams.height = i2;
                                            imageView2.setLayoutParams(layoutParams);
                                        }
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            ur1.o().s(liveFullInfoData.theme.phoneBackgroundUrl).y(imageView2);
                        }
                    }
                    return false;
                }
            }).n();
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol.IWidget, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059205717")) {
            ipChange.ipc$dispatch("1059205717", new Object[]{this});
        } else {
            releaseWithNothing();
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577805953")) {
            ipChange.ipc$dispatch("1577805953", new Object[]{this});
            return;
        }
        initWithNothing();
        clearBackground();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308801754")) {
            ipChange.ipc$dispatch("308801754", new Object[]{this});
        } else {
            releaseWithNothing();
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067070100")) {
            return (View) ipChange.ipc$dispatch("-2067070100", new Object[]{this, context});
        }
        this.mContainer = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        ImageView imageView = new ImageView(context);
        this.mBottomDecorateView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mContainer.addView(this.mBottomDecorateView, layoutParams);
        try {
            Integer.valueOf(getEngineInstance().getOptions().getString("safeAreaTopWx", "0")).intValue();
        } catch (Throwable unused) {
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        layoutParams2.topMargin = ((-getWindowWidth((Activity) context)) * 80) / FeatureFactory.PRIORITY_ABOVE_NORMAL;
        ImageView imageView2 = new ImageView(context);
        this.mPlayerDecorateView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mContainer.addView(this.mPlayerDecorateView, layoutParams2);
        return this.mContainer;
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-896728218")) {
            ipChange.ipc$dispatch("-896728218", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str) && (obj instanceof LiveFullInfoData)) {
            initWithLiveFullInfoData((LiveFullInfoData) obj);
        }
    }
}
