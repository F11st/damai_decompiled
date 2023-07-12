package com.taobao.weex.ui.component.binding;

import android.os.AsyncTask;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taobao.weex.ui.component.list.template.TemplateViewHolder;
import com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList;
import com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Layouts {
    public static void doLayoutAsync(TemplateViewHolder templateViewHolder, boolean z) {
        WXComponent component = templateViewHolder.getComponent();
        int holderPosition = templateViewHolder.getHolderPosition();
        AsyncTask<Void, Void, Void> asyncTask = templateViewHolder.asyncTask;
        if (asyncTask != null) {
            asyncTask.cancel(false);
            templateViewHolder.asyncTask = null;
        }
        if (z) {
            AsynLayoutTask asynLayoutTask = new AsynLayoutTask(templateViewHolder, holderPosition, component);
            templateViewHolder.asyncTask = asynLayoutTask;
            asynLayoutTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            return;
        }
        doLayoutOnly(component, templateViewHolder);
        setLayout(component, false);
        if (templateViewHolder.getHolderPosition() >= 0) {
            templateViewHolder.getTemplateList().fireEvent(TemplateDom.ATTACH_CELL_SLOT, TemplateDom.findAllComponentRefs(templateViewHolder.getTemplateList().getRef(), holderPosition, component));
        }
    }

    public static void doLayoutOnly(WXComponent wXComponent, TemplateViewHolder templateViewHolder) {
        doSafeLayout(wXComponent, templateViewHolder.getTemplateList().getLayoutWidth(), templateViewHolder.getTemplateList().getLayoutHeight());
    }

    public static void doLayoutSync(WXCell wXCell, float f, float f2) {
        doSafeLayout(wXCell, f, f2);
        setLayout(wXCell, false);
    }

    private static void doSafeLayout(WXComponent wXComponent, float f, float f2) {
        try {
            System.currentTimeMillis();
            int nativeLayoutRenderObject = NativeRenderObjectUtils.nativeLayoutRenderObject(wXComponent.getRenderObjectPtr(), f, f2);
            WXEnvironment.isOpenDebugLog();
            if (nativeLayoutRenderObject <= 0) {
                WXLogUtils.e(WXRecyclerTemplateList.TAG, " WXTemplateList doSafeLayout wrong template " + wXComponent.getAttrs().get(Constants.Name.Recycler.SLOT_TEMPLATE_CASE) + " cell height " + nativeLayoutRenderObject);
            }
        } catch (Exception e) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(WXRecyclerTemplateList.TAG, e);
            }
        }
    }

    public static final void setLayout(WXComponent wXComponent, boolean z) {
        if (wXComponent.isWaste()) {
            return;
        }
        if (wXComponent.getAttrs().containsKey(TemplateDom.KEY_RESET_ANIMATION) && WXUtils.getBoolean(wXComponent.getAttrs().get(TemplateDom.KEY_RESET_ANIMATION), Boolean.TRUE).booleanValue()) {
            TemplateDom.resetAnimaiton(wXComponent.getHostView());
        }
        long renderObjectPtr = wXComponent.getRenderObjectPtr();
        if (NativeRenderObjectUtils.nativeRenderObjectHasNewLayout(renderObjectPtr)) {
            NativeRenderObjectUtils.nativeRenderObjectUpdateComponent(renderObjectPtr, wXComponent);
        }
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            int childCount = wXVContainer.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WXComponent child = wXVContainer.getChild(i);
                if (child != null) {
                    setLayout(child, z);
                }
            }
        }
    }
}
