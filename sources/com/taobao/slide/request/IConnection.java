package com.taobao.slide.request;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IConnection {
    void addHeader(String str, String str2);

    void connect() throws IOException;

    void disconnect();

    Map<String, List<String>> getHeadFields();

    String getResponse() throws IOException;

    int getResponseCode() throws IOException;

    void openConnection(String str) throws IOException;

    void setBody(byte[] bArr) throws IOException;

    void setMethod(String str) throws ProtocolException;

    void setParams(Map<String, String> map);
}
