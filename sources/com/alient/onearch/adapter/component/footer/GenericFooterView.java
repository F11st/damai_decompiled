package com.alient.onearch.adapter.component.footer;

import android.view.View;
import android.widget.TextView;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.footer.GenericFooterContract;
import com.alient.onearch.adapter.view.AbsView;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GenericFooterView extends AbsView<GenericItem<ItemValue>, GenericFooterModel, GenericFooterPresent> implements GenericFooterContract.View {
    private final View arrow;
    private final TextView content;

    public GenericFooterView(View view) {
        super(view);
        this.content = (TextView) view.findViewById(R.id.footer_content);
        this.arrow = view.findViewById(R.id.right_arrow);
    }

    @Override // com.alient.onearch.adapter.component.footer.GenericFooterContract.View
    public TextView getContentView() {
        return this.content;
    }

    @Override // com.alient.onearch.adapter.component.footer.GenericFooterContract.View
    public void hideArrowIndicator() {
        this.arrow.setVisibility(8);
    }

    @Override // com.alient.onearch.adapter.component.footer.GenericFooterContract.View
    public void renderContent(String str) {
        this.content.setText(str);
    }

    @Override // com.alient.onearch.adapter.component.footer.GenericFooterContract.View
    public void showArrowIndicator() {
        this.arrow.setVisibility(0);
    }
}
