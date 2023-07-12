package com.alibaba.pictures.bricks.component.artist.project.more;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$string;
import com.alibaba.pictures.bricks.view.BricksIconFontTextView;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterPresent;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ProjectFooterView extends GenericFooterView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private BricksIconFontTextView rightRow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProjectFooterView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        View renderView = getRenderView();
        this.rightRow = renderView != null ? (BricksIconFontTextView) renderView.findViewById(R$id.right_arrow) : null;
    }

    private final boolean isExpend() {
        Boolean bool;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734081248")) {
            return ((Boolean) ipChange.ipc$dispatch("1734081248", new Object[]{this})).booleanValue();
        }
        JSONObject rawJson = ((GenericItem) ((GenericFooterPresent) getPresenter()).getItem()).getComponent().getProperty().getRawJson();
        if (rawJson == null || (bool = rawJson.getBoolean(GenericFooterPresent.KEY_EXPEND_STATE)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.alient.onearch.adapter.component.footer.v2.GenericFooterView, com.alient.onearch.adapter.component.footer.v2.GenericFooterContract.View
    public void renderFooter(@NotNull String str) {
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "371095133")) {
            ipChange.ipc$dispatch("371095133", new Object[]{this, str});
            return;
        }
        b41.i(str, WXBasicComponentType.FOOTER);
        super.renderFooter(str);
        BricksIconFontTextView bricksIconFontTextView = this.rightRow;
        if (bricksIconFontTextView != null) {
            if (isExpend()) {
                string = getView().getContext().getString(R$string.iconfont_xiangshangjiantou_);
            } else {
                string = getView().getContext().getString(R$string.iconfont_xiangxiajiantou_);
            }
            bricksIconFontTextView.setText(string);
        }
    }
}
