package cn.damai.serialize.pbdecoder.pb;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface Seat3DVrPB$FloorSeat3DVrInfoOrBuilder extends MessageLiteOrBuilder {
    long getFloorId();

    Seat3DVrPB$Seat3DVrInfo getSeatList(int i);

    int getSeatListCount();

    List<Seat3DVrPB$Seat3DVrInfo> getSeatListList();
}
