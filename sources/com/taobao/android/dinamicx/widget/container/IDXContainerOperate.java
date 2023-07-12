package com.taobao.android.dinamicx.widget.container;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDXContainerOperate {
    boolean appendItem(@NonNull DXWidgetNode dXWidgetNode);

    boolean deleteItem(int i, @Nullable Object... objArr);

    boolean insertItem(@NonNull DXWidgetNode dXWidgetNode, int i);

    boolean refreshAllItems();

    boolean updateItem(int i, @Nullable JSONObject jSONObject);
}
