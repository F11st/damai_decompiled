package com.alibaba.aliweex.adapter.adapter;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.DrawableStrategy;
import com.taobao.weex.adapter.IDrawableLoader;
import tb.ui2;
import tb.ur1;
import tb.wr1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PhenixBasedDrawableLoader implements IDrawableLoader {

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.adapter.PhenixBasedDrawableLoader$a */
    /* loaded from: classes5.dex */
    private static class C3007a implements IPhenixListener<ui2> {
        private IDrawableLoader.DrawableTarget a;

        C3007a(IDrawableLoader.DrawableTarget drawableTarget) {
            this.a = drawableTarget;
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(ui2 ui2Var) {
            BitmapDrawable f = ui2Var.f();
            if (f != null && !ui2Var.i()) {
                f.setGravity(119);
                IDrawableLoader.DrawableTarget drawableTarget = this.a;
                if (drawableTarget instanceof IDrawableLoader.StaticTarget) {
                    ((IDrawableLoader.StaticTarget) drawableTarget).setDrawable(f, true);
                }
            }
            return true;
        }
    }

    @Override // com.taobao.weex.adapter.IDrawableLoader
    public void setDrawable(final String str, final IDrawableLoader.DrawableTarget drawableTarget, final DrawableStrategy drawableStrategy) {
        try {
            WXSDKManager.v().N(new Runnable() { // from class: com.alibaba.aliweex.adapter.adapter.PhenixBasedDrawableLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    if (drawableTarget == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(str)) {
                        IDrawableLoader.DrawableTarget drawableTarget2 = drawableTarget;
                        if (drawableTarget2 instanceof IDrawableLoader.StaticTarget) {
                            ((IDrawableLoader.StaticTarget) drawableTarget2).setDrawable(null, false);
                            return;
                        }
                    }
                    wr1 s = ur1.o().s(str);
                    DrawableStrategy drawableStrategy2 = drawableStrategy;
                    s.B(null, drawableStrategy2.width, drawableStrategy2.height).F(true).Q(new C3007a(drawableTarget)).n();
                }
            }, 0L);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
