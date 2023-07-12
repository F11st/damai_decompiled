package com.youku.live.dago.widgetlib.wedome.image;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.compat.effects.RoundedCornersBitmapProcessor;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener;
import tb.cq;
import tb.nh0;
import tb.ui2;
import tb.ur1;
import tb.wr1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoImageHelper extends DagoBaseImageLoader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "YKLImageHelper";

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
    public void load(Context context, String str, ImageLoadListener imageLoadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233685960")) {
            ipChange.ipc$dispatch("1233685960", new Object[]{this, context, str, imageLoadListener});
        } else {
            load(context, str, imageLoadListener, 0);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
    public void loadCircle(Context context, String str, ImageLoadListener imageLoadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1181939944")) {
            ipChange.ipc$dispatch("-1181939944", new Object[]{this, context, str, imageLoadListener});
        } else {
            loadCircle(context, str, imageLoadListener, 0);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
    public void show(Context context, String str, ImageView imageView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1590668121")) {
            ipChange.ipc$dispatch("1590668121", new Object[]{this, context, str, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            ur1.o().s(str).H(i).k(i2).y(imageView);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
    public void showCircle(Context context, String str, ImageView imageView) {
        wr1 s;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1200182441")) {
            ipChange.ipc$dispatch("1200182441", new Object[]{this, context, str, imageView});
            return;
        }
        ur1 o = ur1.o();
        if (o == null || (s = o.s(str)) == null) {
            return;
        }
        s.p(true);
        s.h(new cq()).y(imageView);
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
    public void showDefault(Context context, String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315984234")) {
            ipChange.ipc$dispatch("-315984234", new Object[]{this, context, str, imageView});
        } else {
            ur1.o().s(str).y(imageView);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
    public void showGif(Context context, String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1356037095")) {
            ipChange.ipc$dispatch("-1356037095", new Object[]{this, context, str, imageView});
        } else {
            ur1.o().s(str).y(imageView);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
    public void showRoundCorner(Context context, String str, int i, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460102047")) {
            ipChange.ipc$dispatch("1460102047", new Object[]{this, context, str, Integer.valueOf(i), imageView});
        } else {
            ur1.o().s(str).h(new RoundedCornersBitmapProcessor(i, 0)).y(imageView);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
    public void load(Context context, String str, final ImageLoadListener imageLoadListener, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-410411461")) {
            ipChange.ipc$dispatch("-410411461", new Object[]{this, context, str, imageLoadListener, Integer.valueOf(i)});
        } else if (imageLoadListener == null) {
        } else {
            wr1 s = ur1.o().s(str);
            if (i > 0) {
                s.H(i);
            }
            s.Q(new IPhenixListener<ui2>() { // from class: com.youku.live.dago.widgetlib.wedome.image.DagoImageHelper.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(ui2 ui2Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "123322665")) {
                        return ((Boolean) ipChange2.ipc$dispatch("123322665", new Object[]{this, ui2Var})).booleanValue();
                    }
                    if (ui2Var.f() != null && !ui2Var.i()) {
                        imageLoadListener.onSuccess(ui2Var.f());
                    }
                    return true;
                }
            }).m(new IPhenixListener<nh0>() { // from class: com.youku.live.dago.widgetlib.wedome.image.DagoImageHelper.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(nh0 nh0Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1985494148")) {
                        return ((Boolean) ipChange2.ipc$dispatch("1985494148", new Object[]{this, nh0Var})).booleanValue();
                    }
                    imageLoadListener.onFail();
                    return false;
                }
            }).n();
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
    public void loadCircle(Context context, String str, final ImageLoadListener imageLoadListener, int i) {
        wr1 s;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2014596843")) {
            ipChange.ipc$dispatch("2014596843", new Object[]{this, context, str, imageLoadListener, Integer.valueOf(i)});
            return;
        }
        ur1 o = ur1.o();
        if (o == null || (s = o.s(str)) == null) {
            return;
        }
        s.p(true);
        if (i > 0) {
            s.H(i);
        }
        s.h(new cq()).Q(new IPhenixListener<ui2>() { // from class: com.youku.live.dago.widgetlib.wedome.image.DagoImageHelper.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.phenix.intf.event.IPhenixListener
            public boolean onHappen(ui2 ui2Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2084897323")) {
                    return ((Boolean) ipChange2.ipc$dispatch("2084897323", new Object[]{this, ui2Var})).booleanValue();
                }
                if (ui2Var.f() != null && !ui2Var.i()) {
                    imageLoadListener.onSuccess(ui2Var.f());
                }
                return true;
            }
        }).m(new IPhenixListener<nh0>() { // from class: com.youku.live.dago.widgetlib.wedome.image.DagoImageHelper.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.phenix.intf.event.IPhenixListener
            public boolean onHappen(nh0 nh0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-347898490")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-347898490", new Object[]{this, nh0Var})).booleanValue();
                }
                imageLoadListener.onFail();
                return false;
            }
        }).n();
    }

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
    public void showCircle(Context context, String str, ImageView imageView, @DrawableRes int i) {
        wr1 s;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1449020550")) {
            ipChange.ipc$dispatch("-1449020550", new Object[]{this, context, str, imageView, Integer.valueOf(i)});
            return;
        }
        ur1 o = ur1.o();
        if (o == null || (s = o.s(str)) == null) {
            return;
        }
        s.p(true);
        s.h(new cq()).H(i).y(imageView);
    }
}
