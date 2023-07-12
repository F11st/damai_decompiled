package com.alient.onearch.adapter.util;

import android.os.Bundle;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.nav.Action;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/alient/onearch/adapter/util/MediaBrowserUtil;", "", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "item", "Lcom/alient/oneservice/nav/Action;", "action", "Ltb/wt2;", "processMediaBrowserParams", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class MediaBrowserUtil {
    @NotNull
    public static final MediaBrowserUtil INSTANCE = new MediaBrowserUtil();

    private MediaBrowserUtil() {
    }

    public final void processMediaBrowserParams(@NotNull IItem<ItemValue> iItem, @NotNull Action action) {
        b41.i(iItem, "item");
        b41.i(action, "action");
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = iItem.getComponent().getItems().iterator();
        while (it.hasNext()) {
            JSONObject data = ((IItem) it.next()).getProperty().getData();
            if (data != null) {
                HashMap hashMap = new HashMap();
                String string = data.getString("picUrl");
                b41.h(string, "getString(\"picUrl\")");
                hashMap.put("img", string);
                Boolean bool = data.getBoolean("isVideo");
                if (bool == null) {
                    bool = null;
                } else if (bool.booleanValue()) {
                    String string2 = data.getString("videoUrl");
                    b41.h(string2, "getString(\"videoUrl\")");
                    hashMap.put("url", string2);
                    arrayList.add(hashMap);
                } else {
                    arrayList2.add(hashMap);
                }
                if (bool == null) {
                    arrayList2.add(hashMap);
                } else {
                    bool.booleanValue();
                }
            }
        }
        bundle.putSerializable("pic_info_map", arrayList2);
        bundle.putSerializable("video_info_map", arrayList);
        bundle.putInt("position", iItem.getIndex());
        action.setExtra(bundle);
        action.setActionType(1);
    }
}
