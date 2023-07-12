package com.youku.gaiax.impl.register;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import com.youku.gaiax.common.utils.ScreenUtils;
import com.youku.gaiax.impl.GaiaXKey;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ4\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionContainerItemBind;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerItemBind;", "", "tag", "Landroid/view/ViewGroup;", "itemContainer", "Lcom/alibaba/gaiax/GXTemplateEngine$f;", "gxMeasureSize", "Lcom/alibaba/gaiax/GXTemplateEngine$i;", "gxTemplateItem", "Lcom/alibaba/gaiax/GXTemplateEngine$d;", "gxExtendParams", "bindViewHolder", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionContainerItemBind implements GXRegisterCenter.GXIExtensionContainerItemBind {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionContainerItemBind
    @Nullable
    public Object bindViewHolder(@Nullable Object obj, @NotNull ViewGroup viewGroup, @NotNull GXTemplateEngine.C3343f c3343f, @NotNull GXTemplateEngine.C3347i c3347i, @NotNull GXTemplateEngine.C3341d c3341d) {
        Integer c;
        Map<GaiaX.IRule, GaiaX.IDataPipeline5> dataPipelines5;
        GaiaX.IScrollItemStatusDelegate scrollItemStatusDelegate;
        GaiaX.IScrollDelegate scrollDelegate;
        GaiaX.IAnimationDelegate animationDelegate;
        final GaiaX.ITrackDelegate3 trackDelegate3;
        final GaiaX.IRouterDelegate2 routerDelegate2;
        final GaiaX.IEventDelegate eventDelegate;
        b41.i(viewGroup, "itemContainer");
        b41.i(c3343f, "gxMeasureSize");
        b41.i(c3347i, "gxTemplateItem");
        b41.i(c3341d, "gxExtendParams");
        JSONObject b = c3341d.b();
        if (b == null || (c = c3341d.c()) == null) {
            return null;
        }
        final int intValue = c.intValue();
        b.put((JSONObject) GaiaXKey.GAIAX_SCROLL_POSITION, (String) Integer.valueOf(intValue));
        GaiaX.Params params = obj instanceof GaiaX.Params ? (GaiaX.Params) obj : null;
        GaiaX.Params.Builder data = new GaiaX.Params.Builder().templateId(c3347i.d()).templateBiz(c3347i.a()).container(viewGroup).data(b);
        LoadType childLoadMode$GaiaX_Android = params == null ? null : params.getChildLoadMode$GaiaX_Android();
        if (childLoadMode$GaiaX_Android == null) {
            childLoadMode$GaiaX_Android = params == null ? null : params.getMode();
            if (childLoadMode$GaiaX_Android == null) {
                childLoadMode$GaiaX_Android = LoadType.ASYNC_NORMAL;
            }
        }
        GaiaX.Params.Builder mode = data.mode(childLoadMode$GaiaX_Android);
        Float b2 = c3343f.b();
        GaiaX.Params.Builder width = mode.width(b2 == null ? ScreenUtils.INSTANCE.getScreenWidthPx() : b2.floatValue());
        Float a = c3343f.a();
        if (a != null) {
            width.height(a.floatValue());
        }
        GaiaX.Params build = width.build();
        build.setGxExtendParams(c3341d);
        build.setIndexPosition$GaiaX_Android(intValue);
        if (params != null && (eventDelegate = params.getEventDelegate()) != null) {
            build.setEventDelegate(new GaiaX.IEventDelegate() { // from class: com.youku.gaiax.impl.register.GXExtensionContainerItemBind$bindViewHolder$1$1
                @Override // com.youku.gaiax.GaiaX.IEventDelegate
                public void onEvent(@NotNull EventParams eventParams) {
                    b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
                    eventParams.setPosition(Integer.valueOf(intValue));
                    eventDelegate.onEvent(eventParams);
                }
            });
        }
        if (params != null && (routerDelegate2 = params.getRouterDelegate2()) != null) {
            build.setRouterDelegate2(new GaiaX.IRouterDelegate2() { // from class: com.youku.gaiax.impl.register.GXExtensionContainerItemBind$bindViewHolder$2$1
                @Override // com.youku.gaiax.GaiaX.IRouterDelegate2
                public void onAction(@NotNull View view, @NotNull String str, int i, @NotNull JSONObject jSONObject, @NotNull GaiaX.Params params2) {
                    b41.i(view, "targetView");
                    b41.i(str, "targetViewId");
                    b41.i(jSONObject, "targetData");
                    b41.i(params2, "targetParams");
                    GaiaX.IRouterDelegate2.this.onAction(view, str, intValue, jSONObject, params2);
                }
            });
        }
        if (params != null && (trackDelegate3 = params.getTrackDelegate3()) != null) {
            build.setTrackDelegate3(new GaiaX.ITrackDelegate3() { // from class: com.youku.gaiax.impl.register.GXExtensionContainerItemBind$bindViewHolder$3$1
                @Override // com.youku.gaiax.GaiaX.ITrackDelegate3
                public void onTrack(@NotNull TrackParams trackParams) {
                    b41.i(trackParams, "trackParams");
                    trackParams.setPosition(Integer.valueOf(intValue));
                    trackDelegate3.onTrack(trackParams);
                }
            });
        }
        if (params != null && (animationDelegate = params.getAnimationDelegate()) != null) {
            build.setAnimationDelegate(animationDelegate);
        }
        if (params != null && (scrollDelegate = params.getScrollDelegate()) != null) {
            build.setScrollDelegate(scrollDelegate);
        }
        if (params != null && (scrollItemStatusDelegate = params.getScrollItemStatusDelegate()) != null) {
            build.setScrollItemStatusDelegate(scrollItemStatusDelegate);
        }
        if (params != null && (dataPipelines5 = params.getDataPipelines5()) != null) {
            build.getDataPipelines5().putAll(dataPipelines5);
        }
        build.setMessage(params != null ? params.getMessage() : null);
        GaiaX.Companion.getInstance().bindView(build);
        return build;
    }
}
