package com.taobao.android.dinamicx.widget.recycler.manager.datasource;

import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.Collection;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDXDataSourceManager {
    void addAllItem(int i, Collection<DXWidgetNode> collection);

    void addItem(int i, DXWidgetNode dXWidgetNode);

    void addItem(DXWidgetNode dXWidgetNode);

    DXWidgetNode getItem(int i);

    int getItemSize();

    int getRealCount();

    int indexOfItem(DXWidgetNode dXWidgetNode);

    boolean isItemsEmpty();

    boolean isItemsNull();

    DXWidgetNode removeItem(int i);

    void setItem(int i, DXWidgetNode dXWidgetNode);
}
