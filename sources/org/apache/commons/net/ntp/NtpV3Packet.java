package org.apache.commons.net.ntp;

import java.net.DatagramPacket;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface NtpV3Packet {
    public static final int LI_ALARM_CONDITION = 3;
    public static final int LI_LAST_MINUTE_HAS_59_SECONDS = 2;
    public static final int LI_LAST_MINUTE_HAS_61_SECONDS = 1;
    public static final int LI_NO_WARNING = 0;
    public static final int MODE_BROADCAST = 5;
    public static final int MODE_CLIENT = 3;
    public static final int MODE_CONTROL_MESSAGE = 6;
    public static final int MODE_PRIVATE = 7;
    public static final int MODE_RESERVED = 0;
    public static final int MODE_SERVER = 4;
    public static final int MODE_SYMMETRIC_ACTIVE = 1;
    public static final int MODE_SYMMETRIC_PASSIVE = 2;
    public static final int NTP_MAXCLOCK = 10;
    public static final int NTP_MAXPOLL = 14;
    public static final int NTP_MINCLOCK = 1;
    public static final int NTP_MINPOLL = 4;
    public static final int NTP_PORT = 123;
    public static final String TYPE_DAYTIME = "DAYTIME";
    public static final String TYPE_ICMP = "ICMP";
    public static final String TYPE_NTP = "NTP";
    public static final String TYPE_TIME = "TIME";
    public static final int VERSION_3 = 3;
    public static final int VERSION_4 = 4;

    DatagramPacket getDatagramPacket();

    int getLeapIndicator();

    int getMode();

    String getModeName();

    TimeStamp getOriginateTimeStamp();

    int getPoll();

    int getPrecision();

    TimeStamp getReceiveTimeStamp();

    int getReferenceId();

    String getReferenceIdString();

    TimeStamp getReferenceTimeStamp();

    int getRootDelay();

    double getRootDelayInMillisDouble();

    int getRootDispersion();

    long getRootDispersionInMillis();

    double getRootDispersionInMillisDouble();

    int getStratum();

    TimeStamp getTransmitTimeStamp();

    String getType();

    int getVersion();

    void setDatagramPacket(DatagramPacket datagramPacket);

    void setLeapIndicator(int i);

    void setMode(int i);

    void setOriginateTimeStamp(TimeStamp timeStamp);

    void setPoll(int i);

    void setReceiveTimeStamp(TimeStamp timeStamp);

    void setReferenceId(int i);

    void setReferenceTime(TimeStamp timeStamp);

    void setStratum(int i);

    void setTransmitTime(TimeStamp timeStamp);

    void setVersion(int i);
}
