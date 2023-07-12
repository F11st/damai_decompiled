package com.alibaba.pictures.bricks.component.artist.bigtitle;

import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.ArtistBigTitleBean;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ArtistNowBigTitleHolder extends BaseViewHolder<ArtistBigTitleBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final TextView subTitle;
    @NotNull
    private final TextView title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtistNowBigTitleHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        View findViewById = view.findViewById(R$id.artist_now_big_title_tv);
        b41.h(findViewById, "itemView.findViewById(R.….artist_now_big_title_tv)");
        this.title = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.artist_now_subtitle_tv);
        b41.h(findViewById2, "itemView.findViewById(R.id.artist_now_subtitle_tv)");
        this.subTitle = (TextView) findViewById2;
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982322130")) {
            ipChange.ipc$dispatch("-1982322130", new Object[]{this, iItem});
            return;
        }
        b41.i(iItem, "item");
        ArtistBigTitleBean value = getValue();
        if (value != null) {
            TextView textView = this.title;
            String str = value.title;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            TextView textView2 = this.subTitle;
            String str2 = value.subTitle;
            textView2.setText(str2 != null ? str2 : "");
        }
    }
}
