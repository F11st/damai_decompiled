package com.youku.gaiax.impl;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.impl.js.GaiaXJSDelegate;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.v;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/youku/gaiax/impl/GXEventListener;", "Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;", "Lcom/alibaba/gaiax/GXTemplateEngine$e;", "gxGesture", "Ltb/wt2;", "onGestureEvent", "Lcom/alibaba/gaiax/GXTemplateEngine$g;", "gxScroll", "onScrollEvent", "Lcom/alibaba/gaiax/GXTemplateEngine$b;", v.TAK_ABILITY_SHOW_POP_ANIMATION, "onAnimationEvent", "Lcom/youku/gaiax/impl/GaiaXContext;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/gaiax/impl/GaiaXContext;", "getContext", "()Lcom/youku/gaiax/impl/GaiaXContext;", "<init>", "(Lcom/youku/gaiax/impl/GaiaXContext;)V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXEventListener implements GXTemplateEngine.GXIEventListener {
    @NotNull
    private final GaiaXContext context;

    public GXEventListener(@NotNull GaiaXContext gaiaXContext) {
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        this.context = gaiaXContext;
    }

    @NotNull
    public final GaiaXContext getContext() {
        return this.context;
    }

    @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
    public void onAnimationEvent(@NotNull GXTemplateEngine.b bVar) {
        GaiaX.IAnimationDelegate animationDelegate;
        b41.i(bVar, v.TAK_ABILITY_SHOW_POP_ANIMATION);
        String b = bVar.b();
        View d = bVar.d();
        JSONObject a = bVar.a();
        if (b == null || d == null || a == null) {
            return;
        }
        if (b41.d(bVar.c(), GXTemplateEngine.b.STATE_START)) {
            GaiaX.IAnimationDelegate animationDelegate2 = this.context.getParams().getAnimationDelegate();
            if (animationDelegate2 == null) {
                return;
            }
            animationDelegate2.onAnimationStart(b, d, a);
        } else if (!b41.d(bVar.c(), GXTemplateEngine.b.STATE_END) || (animationDelegate = this.context.getParams().getAnimationDelegate()) == null) {
        } else {
            animationDelegate.onAnimationFinish(b, d, a);
        }
    }

    @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
    public void onGestureEvent(@NotNull GXTemplateEngine.e eVar) {
        b41.i(eVar, "gxGesture");
        String gestureType = eVar.getGestureType();
        View view = eVar.getView();
        String nodeId = eVar.getNodeId();
        Integer index = eVar.getIndex();
        JSONObject eventParams = eVar.getEventParams();
        GaiaX.Params params = this.context.getParams();
        if (view == null || nodeId == null || index == null || eventParams == null) {
            return;
        }
        GaiaX.IRouterDelegate2 routerDelegate2 = this.context.getParams().getRouterDelegate2();
        if (routerDelegate2 != null) {
            routerDelegate2.onAction(view, nodeId, index.intValue(), eventParams, params);
        }
        GaiaX.IEventDelegate eventDelegate = this.context.getParams().getEventDelegate();
        if (eventDelegate == null) {
            return;
        }
        EventParams eventParams2 = new EventParams();
        eventParams2.setType(gestureType);
        eventParams2.setData(eventParams);
        eventParams2.setView(view);
        eventParams2.setViewId(nodeId);
        eventParams2.setPosition(index);
        eventParams2.setParams(getContext().getParams());
        eventDelegate.onEvent(eventParams2);
    }

    @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
    public void onScrollEvent(@NotNull GXTemplateEngine.g gVar) {
        GaiaX.IScrollDelegate scrollDelegate;
        b41.i(gVar, "gxScroll");
        View e = gVar.e();
        if (e != null) {
            if (b41.d(gVar.d(), GXTemplateEngine.g.TYPE_ON_SCROLL_STATE_CHANGED)) {
                int c = gVar.c();
                GaiaX.IScrollDelegate scrollDelegate2 = this.context.getParams().getScrollDelegate();
                if (scrollDelegate2 != null) {
                    scrollDelegate2.onScrollStateChanged(e, c);
                }
                if (c == 0) {
                    if (e.canScrollHorizontally(-1)) {
                        GaiaXJSDelegate.INSTANCE.onLoadMoreComponent(this.context, new JSONObject());
                    } else if (e.canScrollVertically(-1)) {
                        GaiaXJSDelegate.INSTANCE.onLoadMoreComponent(this.context, new JSONObject());
                    }
                }
            } else if (!b41.d(gVar.d(), GXTemplateEngine.g.TYPE_ON_SCROLLED) || (scrollDelegate = this.context.getParams().getScrollDelegate()) == null) {
            } else {
                scrollDelegate.onScrolled(e, gVar.a(), gVar.b());
            }
        }
    }
}
