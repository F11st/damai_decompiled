package com.alient.onearch.adapter.component.header.sticky;

import androidx.exifinterface.media.ExifInterface;
import com.alient.onearch.adapter.pom.StickyHeaderTabValue;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.alient.onearch.adapter.widget.RichTitle;
import com.google.android.material.tabs.TabLayout;
import com.youku.arch.v3.view.IContract;
import com.youku.css.constraint.CssConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderContract;", "Lcom/youku/arch/v3/view/IContract;", "<init>", "()V", ExifInterface.TAG_MODEL, "Presenter", CssConst.CssScenes.VIEW, "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class StickyHeaderContract implements IContract {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderContract$Model;", "", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface Model {
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH&¨\u0006\u000f"}, d2 = {"Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderContract$Presenter;", "", "", "Lcom/alient/onearch/adapter/pom/StickyHeaderTabValue;", "tabs", "", "Lcom/alient/onearch/adapter/widget/RichTitle;", "createTitles", "", "selectedPosition", "stickyHeaderTabValue", "Ltb/wt2;", "tabSelected", "unSelectedPosition", "tabUnSelected", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface Presenter {
        @NotNull
        List<RichTitle> createTitles(@NotNull List<StickyHeaderTabValue> list);

        void tabSelected(int i, @NotNull StickyHeaderTabValue stickyHeaderTabValue);

        void tabUnSelected(int i);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J \u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0014\u001a\u00020\u0013H&¨\u0006\u0015"}, d2 = {"Lcom/alient/onearch/adapter/component/header/sticky/StickyHeaderContract$View;", "", "", "Lcom/alient/onearch/adapter/pom/StickyHeaderTabValue;", "tabs", "Ltb/wt2;", "renderTab", "", "position", "", "positionOffset", "", "updateSelectedText", "setScrollPosition", "selectedPosition", "Lcom/alient/onearch/adapter/widget/OneTabLayout;", "tabLayout", "isScroll", "updateTabTextSize", "Lcom/google/android/material/tabs/TabLayout;", "headerView", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface View {
        @NotNull
        TabLayout headerView();

        void renderTab(@NotNull List<StickyHeaderTabValue> list);

        void setScrollPosition(int i, float f, boolean z);

        void updateTabTextSize(int i, @NotNull OneTabLayout oneTabLayout, boolean z);
    }
}
