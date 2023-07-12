package com.youku.alixplayer.opensdk.ups.data;

import com.youku.alixplayer.opensdk.ups.data.MediaMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class MasterBitStream extends BitStream {
    private Map<Quality, MasterStreamInfo> mStreams;

    public MasterBitStream(String str, Quality quality, String str2, Codec codec, int i) {
        super(str, quality, str2, codec, i);
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
        if (media != null) {
            return media.getQuality();
        }
        return Quality.UNKNOWN;
    }

    public Map getMasterInfoByUrl(String str) {
        String[] split = str.split(SocketClient.NETASCII_EOL);
        HashMap hashMap = new HashMap();
        int length = split.length;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            String str2 = split[i2];
            int i3 = 1;
            if ("#EXTM3U".equals(str2)) {
                z = true;
            }
            if (z) {
                String str3 = null;
                if (str2.startsWith("#EXT-X-STREAM-INF")) {
                    String substring = str2.substring(str2.indexOf(58) + 1);
                    int i4 = -1;
                    int i5 = -1;
                    int i6 = 0;
                    long j = -1;
                    long j2 = -1;
                    while (i6 < substring.length()) {
                        int findNextUnquoted = findNextUnquoted(substring, ',', i6);
                        if (findNextUnquoted < 0) {
                            findNextUnquoted = substring.length();
                        }
                        String trim = substring.substring(i6, findNextUnquoted).trim();
                        i6 = findNextUnquoted + 1;
                        int indexOf = trim.indexOf(61);
                        if (indexOf >= 0) {
                            String trim2 = trim.substring(i, indexOf).trim();
                            String trim3 = trim.substring(indexOf + 1).trim();
                            if ("BANDWIDTH".equals(trim2)) {
                                j = Long.parseLong(trim3);
                            } else if ("STREAMTYPE".equals(trim2)) {
                                str3 = trim3.substring(i3, trim3.length() - i3);
                            } else if ("SIZE".equals(trim2)) {
                                j2 = Long.parseLong(trim3);
                            } else if ("RESOLU".equals(trim2)) {
                                i4 = Integer.parseInt(trim3);
                            } else if ("FPS".equals(trim2)) {
                                i5 = Integer.parseInt(trim3);
                            }
                            if (j != -1 && str3 != null) {
                                hashMap.put(findAbsGear(str3), new MasterStreamInfo(str3, j, j2, i4, i5));
                            }
                            i = 0;
                            i3 = 1;
                        }
                    }
                }
            }
            i2++;
            i = 0;
        }
        return hashMap;
    }

    @Override // com.youku.alixplayer.opensdk.ups.data.BitStream
    public BitStream setM3u8Text(String str) {
        this.mStreams = getMasterInfoByUrl(str);
        return super.setM3u8Text(str);
    }
}
