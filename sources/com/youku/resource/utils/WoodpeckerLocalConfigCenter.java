package com.youku.resource.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import com.youku.middlewareservice.provider.kvdata.HighPerfSPProviderProxy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WoodpeckerLocalConfigCenter implements Serializable {
    public static final String SP_CONFIGS_KEY = "configs";
    public static final String SP_NAME_SPACE = "woodpecker_local_config";

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class ConfigItem implements Serializable {
        public String id;
        public String label;
        public ArrayList<RadioItem> radios;

        @JSONField(serialize = false)
        public RadioItem getCheckedRadio() {
            ArrayList<RadioItem> arrayList = this.radios;
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            Iterator<RadioItem> it = this.radios.iterator();
            while (it.hasNext()) {
                RadioItem next = it.next();
                if (next.isChecked) {
                    return next;
                }
            }
            return null;
        }

        @JSONField(serialize = false)
        public String getCheckedVal() {
            RadioItem checkedRadio = getCheckedRadio();
            return checkedRadio == null ? "" : checkedRadio.value;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class RadioItem implements Serializable {
        public boolean isChecked;
        public String label;
        public String value;
    }

    @NonNull
    public static String getCheckedVal(String str) {
        ArrayList arrayList;
        try {
            arrayList = (ArrayList) JSON.parseObject(HighPerfSPProviderProxy.getString(SP_NAME_SPACE, SP_CONFIGS_KEY, ""), new TypeReference<ArrayList<ConfigItem>>() { // from class: com.youku.resource.utils.WoodpeckerLocalConfigCenter.1
            }, new Feature[0]);
        } catch (Exception unused) {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConfigItem configItem = (ConfigItem) it.next();
                if (TextUtils.equals(str, configItem.id)) {
                    return configItem.getCheckedVal();
                }
            }
        }
        return "";
    }
}
