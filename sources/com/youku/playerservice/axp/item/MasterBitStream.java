package com.youku.playerservice.axp.item;

import com.youku.playerservice.axp.item.MediaMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MasterBitStream extends BitStream {
    private Map<Quality, MasterStreamInfo> mStreams;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class MasterStreamInfo {
        public long bandWidth;
        public int fps;
        public int resolution;
        public long size;
        public String streamType;

        public MasterStreamInfo(String str, long j, long j2, int i, int i2) {
            this.streamType = str;
            this.bandWidth = j;
            this.size = j2;
            this.resolution = i;
            this.fps = i2;
        }
    }

    public MasterBitStream(Quality quality, String str, Codec codec, int i) {
        super(quality, str, codec, i);
        this.mStreams = new LinkedHashMap();
    }

    private int findNextUnquoted(String str, char c, int i) {
        boolean z = false;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                z = !z;
            } else if (charAt == c && !z) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public Quality findAbsGear(String str) {
        MediaMap.MediaFormat media = MediaMap.getMedia(str);
        return media != null ? media.getQuality() : Quality.UNKNOWN;
    }

    public Map getMasterInfoByUrl(String str) {
        String str2;
        int i;
        int i2;
        long j;
        String str3;
        int i3;
        String[] split = str.split(SocketClient.NETASCII_EOL);
        HashMap hashMap = new HashMap();
        int length = split.length;
        boolean z = false;
        int i4 = 0;
        while (i4 < length) {
            String str4 = split[i4];
            int i5 = 1;
            boolean z2 = "#EXTM3U".equals(str4) ? true : z;
            if (z2) {
                String str5 = null;
                if (str4.startsWith("#EXT-X-STREAM-INF")) {
                    String substring = str4.substring(str4.indexOf(58) + 1);
                    int i6 = -1;
                    long j2 = -1;
                    long j3 = -1;
                    int i7 = -1;
                    int i8 = 0;
                    while (i8 < substring.length()) {
                        int findNextUnquoted = findNextUnquoted(substring, ',', i8);
                        if (findNextUnquoted < 0) {
                            findNextUnquoted = substring.length();
                        }
                        String trim = substring.substring(i8, findNextUnquoted).trim();
                        int i9 = findNextUnquoted + i5;
                        int indexOf = trim.indexOf(61);
                        if (indexOf < 0) {
                            i8 = i9;
                        } else {
                            String[] strArr = split;
                            String trim2 = trim.substring(0, indexOf).trim();
                            String trim3 = trim.substring(indexOf + 1).trim();
                            if ("BANDWIDTH".equals(trim2)) {
                                str2 = str5;
                                i = i6;
                                i2 = i7;
                                j = Long.parseLong(trim3);
                            } else {
                                if ("STREAMTYPE".equals(trim2)) {
                                    str5 = trim3.substring(1, trim3.length() - 1);
                                } else if ("SIZE".equals(trim2)) {
                                    j3 = Long.parseLong(trim3);
                                } else if ("RESOLU".equals(trim2)) {
                                    i6 = Integer.parseInt(trim3);
                                } else if ("FPS".equals(trim2)) {
                                    i7 = Integer.parseInt(trim3);
                                }
                                str2 = str5;
                                i = i6;
                                i2 = i7;
                                j = j2;
                            }
                            long j4 = j3;
                            if (j == -1 || str2 == null) {
                                str3 = substring;
                                i3 = length;
                            } else {
                                i3 = length;
                                str3 = substring;
                                hashMap.put(findAbsGear(str2), new MasterStreamInfo(str2, j, j4, i, i2));
                            }
                            str5 = str2;
                            i8 = i9;
                            i6 = i;
                            split = strArr;
                            i7 = i2;
                            j2 = j;
                            j3 = j4;
                            length = i3;
                            substring = str3;
                        }
                        i5 = 1;
                    }
                }
            }
            i4++;
            z = z2;
            split = split;
            length = length;
        }
        return hashMap;
    }

    @Override // com.youku.playerservice.axp.item.BitStream
    public BitStream setM3u8Url(String str) {
        this.mStreams = getMasterInfoByUrl(str);
        return super.setM3u8Url(str);
    }
}
