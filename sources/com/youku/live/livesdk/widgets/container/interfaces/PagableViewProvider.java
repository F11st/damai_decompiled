package com.youku.live.livesdk.widgets.container.interfaces;

import android.view.View;
import com.youku.live.livesdk.widgets.helper.Accessor;
import com.youku.live.livesdk.widgets.helper.Caller;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface PagableViewProvider<DataType, ContentViewType extends View> {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnItemInfoListener {
        void onItemInfo(int i, int i2, Map<String, Object> map);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnPagingLifecycleListener<DataType, ContentViewType> {
        void onPageDeinit(int i, DataType datatype, ContentViewType contentviewtype);

        void onPageIdleChanged(int i, DataType datatype, ContentViewType contentviewtype, boolean z);

        void onPageInit(int i, DataType datatype, ContentViewType contentviewtype);

        void onPageInvisible(int i, DataType datatype, ContentViewType contentviewtype);

        void onPageVisible(int i, DataType datatype, ContentViewType contentviewtype);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface PagingContentCreator<ContentViewType> {
        ContentViewType createPageItem();

        void releasePageItem(ContentViewType contentviewtype);
    }

    void addOnPagingLifecycleListener(OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener);

    <Params, RetValue> RetValue callActiveView(Caller<ContentViewType, Params, RetValue> caller, Params params, RetValue retvalue);

    View getContentView();

    void notifyActiveView(Accessor<ContentViewType> accessor);

    void notifyAllViews(Accessor<ContentViewType> accessor);

    void setDataList(List<DataType> list);

    void setLimit(int i, int i2);

    void setPagingContentCreator(PagingContentCreator<ContentViewType> pagingContentCreator);

    void setRoomSwitch(boolean z);

    void updateDataList();
}
