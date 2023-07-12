package com.alibaba.pictures.bricks.component.artist.project.more;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$string;
import com.alibaba.pictures.bricks.view.BricksIconFontTextView;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterPresent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ProjectFooterPresent extends GenericFooterPresent {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private BricksIconFontTextView rightRow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProjectFooterPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
        this.rightRow = view != null ? (BricksIconFontTextView) view.findViewById(R$id.right_arrow) : null;
    }

    private final boolean isExpend() {
        Boolean bool;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-760145526")) {
            return ((Boolean) ipChange.ipc$dispatch("-760145526", new Object[]{this})).booleanValue();
        }
        JSONObject rawJson = ((GenericItem) getItem()).getComponent().getProperty().getRawJson();
        if (rawJson == null || (bool = rawJson.getBoolean(GenericFooterPresent.KEY_EXPEND_STATE)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.alient.onearch.adapter.component.footer.v2.GenericFooterPresent, com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view) {
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097012108")) {
            ipChange.ipc$dispatch("1097012108", new Object[]{this, view});
            return;
        }
        b41.i(view, "view");
        super.onItemClick(view);
        BricksIconFontTextView bricksIconFontTextView = this.rightRow;
        if (bricksIconFontTextView != null) {
            if (isExpend()) {
                string = view.getContext().getString(R$string.iconfont_xiangshangjiantou_);
            } else {
                string = view.getContext().getString(R$string.iconfont_xiangxiajiantou_);
            }
            bricksIconFontTextView.setText(string);
        }
    }
}
