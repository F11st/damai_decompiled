package cn.damai.serialize.pbdecoder.pb;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface Seat3DVrPB$Seat3DVrInfoOrBuilder extends MessageLiteOrBuilder {
    long getFloorId();

    double getFov();

    double getHorizontal();

    String getImg();

    ByteString getImgBytes();

    String getImgHash();

    ByteString getImgHashBytes();

    long getSid();

    String getThumb();

    ByteString getThumbBytes();

    double getVertical();
}
