package com.youku.live.dago.widgetlib.ailproom.adapter.likeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.weex.common.Constants;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener;
import com.youku.live.dago.widgetlib.ailproom.favor.FavorLayout;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.List;
import tb.nh0;
import tb.ui2;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoLikeView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoLikeView";
    private BitmapDrawable mAvatar;
    private FavorLayout mFavorLayout;
    private int mLikeTotalCount;

    public DagoLikeView(@NonNull Context context) {
        super(context);
        this.mLikeTotalCount = 0;
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373207795")) {
            ipChange.ipc$dispatch("373207795", new Object[]{this, context});
            return;
        }
        FavorLayout favorLayout = new FavorLayout(context);
        this.mFavorLayout = favorLayout;
        addView(favorLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Drawable> split(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640222068")) {
            return (List) ipChange.ipc$dispatch("-1640222068", new Object[]{this, bitmap, Integer.valueOf(i)});
        }
        ArrayList arrayList = new ArrayList();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width / i;
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(new BitmapDrawable(Bitmap.createBitmap(bitmap, i3 * i, 0, i, height)));
        }
        return arrayList;
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326532006")) {
            ipChange.ipc$dispatch("326532006", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.Event.SLOT_LIFECYCLE.DESTORY);
        FavorLayout favorLayout = this.mFavorLayout;
        if (favorLayout != null) {
            favorLayout.destroy();
            this.mFavorLayout = null;
        }
    }

    public void setAvatar(String str) {
        FavorLayout favorLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "649774959")) {
            ipChange.ipc$dispatch("649774959", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setAvatar: " + str);
        if (TextUtils.isEmpty(str)) {
            FavorLayout favorLayout2 = this.mFavorLayout;
            if (favorLayout2 != null) {
                favorLayout2.setAvatar(null);
                return;
            }
            return;
        }
        BitmapDrawable bitmapDrawable = this.mAvatar;
        if (bitmapDrawable != null && (favorLayout = this.mFavorLayout) != null) {
            favorLayout.setAvatar(bitmapDrawable);
        }
        DagoImageLoader.getInstance().loadCircle(getContext(), str, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onFail() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1803880124")) {
                    ipChange2.ipc$dispatch("1803880124", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onSuccess(BitmapDrawable bitmapDrawable2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1255301630")) {
                    ipChange2.ipc$dispatch("-1255301630", new Object[]{this, bitmapDrawable2});
                } else if (bitmapDrawable2 != null) {
                    DagoLikeView.this.mAvatar = bitmapDrawable2;
                    ((ILog) Dsl.getService(ILog.class)).i(DagoLikeView.TAG, "mDrawables: " + bitmapDrawable2);
                    if (DagoLikeView.this.mFavorLayout != null) {
                        DagoLikeView.this.mFavorLayout.setAvatar(DagoLikeView.this.mAvatar);
                    }
                }
            }
        });
    }

    public void setFlow(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1056132653")) {
            ipChange.ipc$dispatch("-1056132653", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setFlow: " + i);
        int i2 = this.mLikeTotalCount;
        if (i > i2) {
            this.mLikeTotalCount = i;
            this.mFavorLayout.addFavor(i - i2);
            return;
        }
        this.mLikeTotalCount = i;
    }

    public void setLikeViewSrc(String str, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1351753035")) {
            ipChange.ipc$dispatch("-1351753035", new Object[]{this, str, Integer.valueOf(i)});
        } else {
            ur1.o().s(str).Q(new IPhenixListener<ui2>() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(ui2 ui2Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "371212675")) {
                        return ((Boolean) ipChange2.ipc$dispatch("371212675", new Object[]{this, ui2Var})).booleanValue();
                    }
                    if (ui2Var.f() != null && !ui2Var.i()) {
                        List<Drawable> split = DagoLikeView.this.split(ui2Var.f().getBitmap(), i);
                        if (!split.isEmpty()) {
                            ((ILog) Dsl.getService(ILog.class)).i(DagoLikeView.TAG, "mDrawables: " + split);
                            if (DagoLikeView.this.mFavorLayout != null) {
                                DagoLikeView.this.mFavorLayout.setDrawables(split);
                            }
                        }
                    }
                    return true;
                }
            }).m(new IPhenixListener<nh0>() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.likeview.DagoLikeView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(nh0 nh0Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2061583138")) {
                        return ((Boolean) ipChange2.ipc$dispatch("-2061583138", new Object[]{this, nh0Var})).booleanValue();
                    }
                    return false;
                }
            }).n();
        }
    }

    public DagoLikeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLikeTotalCount = 0;
        initView(context);
    }

    public DagoLikeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLikeTotalCount = 0;
        initView(context);
    }
}
