package com.youku.live.widgets.protocol;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface IDataCenter {
    void addDataHandler(String str, IDataBridgeHandler iDataBridgeHandler);

    void addDataHandler(String str, IDataHandler iDataHandler);

    void addDataHandlers(List<String> list, IDataBridgeHandler iDataBridgeHandler);

    void addDataHandlers(List<String> list, IDataHandler iDataHandler);

    void addDataHandlers(String[] strArr, IDataBridgeHandler iDataBridgeHandler);

    void addDataHandlers(String[] strArr, IDataHandler iDataHandler);

    void asyncPutData(String str, Object obj);

    void asyncPutData(String str, Object obj, Object obj2);

    Object getData(String str);

    void getData(String str, IResult iResult);

    void putData(String str, Object obj);

    void putData(String str, Object obj, Object obj2);

    void putDataOnly(String str, Object obj);

    void putDataOnly(String str, Object obj, Object obj2);

    void removeData(String str);

    void removeDataHandler(String str, IDataHandler iDataHandler);
}
