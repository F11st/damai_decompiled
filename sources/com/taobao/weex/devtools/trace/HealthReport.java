package com.taobao.weex.devtools.trace;

import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class HealthReport {
    private static final String TAG = "Inspector-HearthReport";
    private String bundleUrl;
    public int componentCount;
    @JSONField(serialize = false)
    public int componentNumOfBigCell;
    public List<EmbedDesc> embedDescList;
    public int estimateContentHeight;
    public String estimatePages;
    @JSONField(serialize = false)
    public Map<String, String> extendProps;
    public boolean hasBigCell;
    public boolean hasEmbed;
    public boolean hasList;
    public boolean hasScroller;
    public Map<String, ListDesc> listDescMap;
    @JSONField(serialize = false)
    public int maxCellViewNum;
    @JSONField(name = "maxLayerOfVDom")
    public int maxLayer;
    public int maxLayerOfRealDom;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class EmbedDesc {
        public int actualMaxLayer;
        public int beginLayer;
        public String src;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ListDesc {
        public int cellNum;
        public String ref;
        public int totalHeight;
    }

    public HealthReport() {
    }

    public void writeToConsole() {
        Log.d(TAG, "health report(" + this.bundleUrl + jn1.BRACKET_END_STR);
        StringBuilder sb = new StringBuilder();
        sb.append("[health report] maxLayer:");
        sb.append(this.maxLayer);
        Log.d(TAG, sb.toString());
        Log.d(TAG, "[health report] maxLayerOfRealDom:" + this.maxLayerOfRealDom);
        Log.d(TAG, "[health report] hasList:" + this.hasList);
        Log.d(TAG, "[health report] hasScroller:" + this.hasScroller);
        Log.d(TAG, "[health report] hasBigCell:" + this.hasBigCell);
        Log.d(TAG, "[health report] maxCellViewNum:" + this.maxCellViewNum);
        Map<String, ListDesc> map = this.listDescMap;
        if (map != null && !map.isEmpty()) {
            Log.d(TAG, "[health report] listNum:" + this.listDescMap.size());
            for (ListDesc listDesc : this.listDescMap.values()) {
                Log.d(TAG, "[health report] listDesc: (ref:" + listDesc.ref + ",cellNum:" + listDesc.cellNum + ",totalHeight:" + listDesc.totalHeight + "px)");
            }
        }
        Log.d(TAG, "[health report] hasEmbed:" + this.hasEmbed);
        List<EmbedDesc> list = this.embedDescList;
        if (list != null && !list.isEmpty()) {
            Log.d(TAG, "[health report] embedNum:" + this.embedDescList.size());
            for (EmbedDesc embedDesc : this.embedDescList) {
                Log.d(TAG, "[health report] embedDesc: (src:" + embedDesc.src + ",layer:" + embedDesc.actualMaxLayer + jn1.BRACKET_END_STR);
            }
        }
        Log.d(TAG, "[health report] estimateContentHeight:" + this.estimateContentHeight + "px,estimatePages:" + this.estimatePages);
        Log.d(TAG, StringUtils.LF);
        Map<String, String> map2 = this.extendProps;
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                Log.d(TAG, "[health report] " + entry.getKey() + ":" + entry.getValue() + jn1.BRACKET_END_STR);
            }
        }
    }

    public HealthReport(@NonNull String str) {
        this.bundleUrl = str;
    }
}
