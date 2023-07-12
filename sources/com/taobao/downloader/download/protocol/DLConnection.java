package com.taobao.downloader.download.protocol;

import java.io.IOException;
import java.net.URL;
import tb.C9613qq;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface DLConnection {
    void addRequestProperty(String str, String str2);

    void connect() throws IOException;

    void disConnect();

    long getDownloadLength();

    String getErrorMsg();

    String getHeaderField(String str);

    DLInputStream getInputStream() throws IOException;

    int getStatusCode() throws Exception;

    void openConnection(URL url, C9613qq c9613qq) throws IOException;
}
