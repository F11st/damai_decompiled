package org.apache.commons.net.ntp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import org.apache.commons.net.DatagramSocketClient;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class NTPUDPClient extends DatagramSocketClient {
    public static final int DEFAULT_PORT = 123;
    private int _version = 3;

    public TimeInfo getTime(InetAddress inetAddress, int i) throws IOException {
        if (!isOpen()) {
            open();
        }
        NtpV3Impl ntpV3Impl = new NtpV3Impl();
        ntpV3Impl.setMode(3);
        ntpV3Impl.setVersion(this._version);
        DatagramPacket datagramPacket = ntpV3Impl.getDatagramPacket();
        datagramPacket.setAddress(inetAddress);
        datagramPacket.setPort(i);
        NtpV3Impl ntpV3Impl2 = new NtpV3Impl();
        DatagramPacket datagramPacket2 = ntpV3Impl2.getDatagramPacket();
        ntpV3Impl.setTransmitTime(TimeStamp.getCurrentTime());
        this._socket_.send(datagramPacket);
        this._socket_.receive(datagramPacket2);
        return new TimeInfo((NtpV3Packet) ntpV3Impl2, System.currentTimeMillis(), false);
    }

    public int getVersion() {
        return this._version;
    }

    public void setVersion(int i) {
        this._version = i;
    }

    public TimeInfo getTime(InetAddress inetAddress) throws IOException {
        return getTime(inetAddress, 123);
    }
}
