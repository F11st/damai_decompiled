package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.AnchorLevelCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.DagoCell;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.FaceCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.GiftCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.ImageCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.MedalCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.TextCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.UserLevelCellItem;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dago.widgetlib.util.WXAttrParse;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.danmaku.DanmakuConfig;
import com.youku.live.dsl.danmaku.DanmakuItem;
import com.youku.live.dsl.danmaku.IDanmakuController;
import com.youku.live.dsl.danmaku.IDanmakuFactory;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoDanmuComponent extends ProxyWXComponent<View> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoDanmuComponent";
    private IDanmakuController mDanmakuController;
    private int rows;
    private boolean show;

    public DagoDanmuComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    private SpannableStringBuilder drawCell(DagoCell dagoCell) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-805311820")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("-805311820", new Object[]{this, dagoCell});
        }
        if (dagoCell == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (BaseCellItem baseCellItem : dagoCell.cell) {
            if (baseCellItem instanceof TextCellItem) {
                spannableStringBuilder.append(DrawCellItemUtils.drawTextCellItem((TextCellItem) baseCellItem, null));
            } else if (baseCellItem instanceof ImageCellItem) {
                spannableStringBuilder.append(DrawCellItemUtils.drawImageCellItem((ImageCellItem) baseCellItem, null));
            } else if (baseCellItem instanceof FaceCellItem) {
                spannableStringBuilder.append(DrawCellItemUtils.drawFaceCellItem((FaceCellItem) baseCellItem));
            } else if (baseCellItem instanceof GiftCellItem) {
                spannableStringBuilder.append(DrawCellItemUtils.drawGiftCellItem((GiftCellItem) baseCellItem));
            } else if (baseCellItem instanceof MedalCellItem) {
                spannableStringBuilder.append(DrawCellItemUtils.drawMedalCellItem((MedalCellItem) baseCellItem));
            } else if (baseCellItem instanceof AnchorLevelCellItem) {
                spannableStringBuilder.append(DrawCellItemUtils.drawAnchorLevelCellItem((AnchorLevelCellItem) baseCellItem));
            } else if (baseCellItem instanceof UserLevelCellItem) {
                spannableStringBuilder.append(DrawCellItemUtils.drawUserLevelCellItem((UserLevelCellItem) baseCellItem));
            }
        }
        return spannableStringBuilder;
    }

    @JSMethod
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "894349828")) {
            ipChange.ipc$dispatch("894349828", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.TAG_CLEAR_STRING);
        IDanmakuController iDanmakuController = this.mDanmakuController;
        if (iDanmakuController != null) {
            iDanmakuController.clearDanmu();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572356553")) {
            ipChange.ipc$dispatch("-1572356553", new Object[]{this});
            return;
        }
        super.destroy();
        ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.Event.SLOT_LIFECYCLE.DESTORY);
        IDanmakuController iDanmakuController = this.mDanmakuController;
        if (iDanmakuController != null) {
            iDanmakuController.destroy();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237455827")) {
            return (View) ipChange.ipc$dispatch("237455827", new Object[]{this, context});
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initComponentHostView");
        if (this.mDanmakuController == null) {
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "initComponentHostView createController");
            this.mDanmakuController = ((IDanmakuFactory) Dsl.getService(IDanmakuFactory.class)).createController(context.getApplicationContext());
        }
        IDanmakuController iDanmakuController = this.mDanmakuController;
        if (iDanmakuController != null) {
            return iDanmakuController.getView();
        }
        return new View(context);
    }

    @JSMethod
    public void insert(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575764453")) {
            ipChange.ipc$dispatch("1575764453", new Object[]{this, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "insert: " + map);
        int color = WXAttrParse.getColor(map.get("bgColor"), 0);
        int i = WXAttrParse.getInt(map.get("fontSize"), 14);
        int i2 = WXAttrParse.getInt(map.get(Constants.Name.BORDER_WIDTH), 0);
        int color2 = WXAttrParse.getColor(map.get("borderColor"), 0);
        DanmakuItem danmakuItem = new DanmakuItem(drawCell(new DagoCell(map)));
        DanmakuConfig danmakuConfig = danmakuItem.danmuConfig;
        danmakuConfig.danmuBg = color;
        danmakuConfig.textSize = UIUtil.dip2px(i);
        DanmakuConfig danmakuConfig2 = danmakuItem.danmuConfig;
        danmakuConfig2.borderColor = color2;
        danmakuConfig2.borderWidth = i2;
        IDanmakuController iDanmakuController = this.mDanmakuController;
        if (iDanmakuController != null) {
            iDanmakuController.addDanmu(danmakuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773845623")) {
            ipChange.ipc$dispatch("-1773845623", new Object[]{this, view});
            return;
        }
        super.onHostViewInitialized(view);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onHostViewInitialized");
        WXAttr attrs = getBasicComponentData().getAttrs();
        this.rows = WXAttrParse.getInt(attrs.get(Constants.Name.ROWS), 3);
        this.show = WXAttrParse.getBoolean(attrs.get("show"));
        IDanmakuController iDanmakuController = this.mDanmakuController;
        if (iDanmakuController != null) {
            iDanmakuController.getView().setVisibility(this.show ? 0 : 8);
        }
    }

    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1377744315")) {
            ipChange.ipc$dispatch("1377744315", new Object[]{this});
            return;
        }
        IDanmakuController iDanmakuController = this.mDanmakuController;
        if (iDanmakuController != null) {
            iDanmakuController.pause();
        }
    }

    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1408187308")) {
            ipChange.ipc$dispatch("1408187308", new Object[]{this});
            return;
        }
        IDanmakuController iDanmakuController = this.mDanmakuController;
        if (iDanmakuController != null) {
            iDanmakuController.resume();
        }
    }

    public DagoDanmuComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
    }
}
