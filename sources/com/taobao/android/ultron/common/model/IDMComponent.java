package com.taobao.android.ultron.common.model;

import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import tb.xw2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDMComponent extends Serializable {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface CustomValidate {
        xw2 onCustomValidate(IDMComponent iDMComponent);
    }

    String getCardGroup();

    List<IDMComponent> getChildren();

    JSONObject getContainerInfo();

    String getContainerType();

    JSONObject getData();

    Map<String, List<IDMEvent>> getEventMap();

    JSONObject getEvents();

    ArrayMap<String, Object> getExtMap();

    JSONObject getFields();

    JSONObject getHidden();

    String getId();

    String getKey();

    LinkageType getLinkageType();

    int getModifiedCount();

    IDMComponent getParent();

    String getPosition();

    JSONObject getStashData();

    int getStatus();

    String getTag();

    String getType();

    void record();

    void rollBack();

    void setCustomValidate(CustomValidate customValidate);

    void updateModifiedCount();

    xw2 validate();

    void writeFields(String str, Object obj);
}
