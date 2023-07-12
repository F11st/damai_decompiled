package cn.damai.tool2.bufferkit;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface BufferRequest<T> {
    void cancel();

    void doRequest(BufferListener<T> bufferListener);

    String getGroupType();

    String getUniKey();
}
