package com.alibaba.gaiax.studio.third.socket.java_websocket.framing;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidDataException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidFrameException;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public abstract class ControlFrame extends FramedataImpl1 {
    public ControlFrame(Opcode opcode) {
        super(opcode);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.FramedataImpl1
    public void isValid() throws InvalidDataException {
        if (isFin()) {
            if (!isRSV1()) {
                if (!isRSV2()) {
                    if (isRSV3()) {
                        throw new InvalidFrameException("Control frame cant have rsv3==true set");
                    }
                    return;
                }
                throw new InvalidFrameException("Control frame cant have rsv2==true set");
            }
            throw new InvalidFrameException("Control frame cant have rsv1==true set");
        }
        throw new InvalidFrameException("Control frame cant have fin==false set");
    }
}
