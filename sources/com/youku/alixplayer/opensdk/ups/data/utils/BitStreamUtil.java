package com.youku.alixplayer.opensdk.ups.data.utils;

import android.content.Context;
import android.text.TextUtils;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.ups.data.BitStream;
import com.youku.alixplayer.opensdk.ups.data.BitStreamFinder;
import com.youku.alixplayer.opensdk.ups.data.Codec;
import com.youku.alixplayer.opensdk.ups.data.MasterBitStream;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.PlayerUtil;
import com.youku.upsplayer.module.Master;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class BitStreamUtil {
    public static final String TAG = "BitStreamUtil";

    public static void buildMasterBitStream(YoukuVideoInfo youkuVideoInfo, Master[] masterArr, List<BitStream> list, List<BitStream> list2) {
        MasterBitStream masterBitStream;
        String str;
        PlayVideoInfo playVideoInfo = youkuVideoInfo.getPlayVideoInfo();
        HashSet<String> hashSet = new HashSet();
        for (Master master : masterArr) {
            String str2 = master.language;
            Iterator<BitStream> it = list.iterator();
            while (true) {
                masterBitStream = null;
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                BitStream next = it.next();
                if (next.getQuality() != Quality.SOUND && str2 != null && str2.equals(next.getAudioLang())) {
                    str = next.getDrmKey();
                    break;
                }
            }
            if (!TextUtils.isEmpty(master.h264)) {
                masterBitStream = new MasterBitStream(master.logo, Quality.AUTO, "auto", Codec.H264, 0);
                masterBitStream.setAudioLang(master.language);
                masterBitStream.setDrmKey(str);
                masterBitStream.setM3u8Text(master.h264);
                masterBitStream.setHlsSubtitle(master.subtitle);
                masterBitStream.setStreamSegList(new ArrayList());
                list2.add(masterBitStream);
            }
            if (!TextUtils.isEmpty(master.h265)) {
                MasterBitStream masterBitStream2 = new MasterBitStream(master.logo, Quality.AUTO, "auto", Codec.H265, 0);
                masterBitStream2.setAudioLang(master.language);
                masterBitStream2.setDrmKey(str);
                masterBitStream2.setM3u8Text(master.h265);
                masterBitStream2.setHlsSubtitle(master.subtitle);
                masterBitStream2.setStreamSegList(new ArrayList());
                list.add(masterBitStream2);
                hashSet.add(master.language);
                Logger.d("ups parse master ：auto format=3 h265=true lang=" + master.language);
            } else if (masterBitStream != null) {
                list.add(masterBitStream);
                hashSet.add(master.language);
                Logger.d("ups parse master ：auto format=3 h265=false lang=" + master.language);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str3 : hashSet) {
            stringBuffer.append(str3);
            stringBuffer.append(",");
        }
        playVideoInfo.putString("hasMaster", stringBuffer.toString());
    }

    public static BitStream getRealVideoQuality(Context context, Quality quality, String str, YoukuVideoInfo youkuVideoInfo) {
        String str2;
        List<BitStream> bitStreamList = youkuVideoInfo.getBitStreamList();
        String vid = youkuVideoInfo.getPlayVideoInfo().getVid();
        if (bitStreamList == null || bitStreamList.isEmpty()) {
            return null;
        }
        Quality quality2 = Quality.AUTO;
        Quality quality3 = Quality.UNKNOWN;
        if (quality != quality3) {
            quality2 = quality;
        }
        BitStreamFinder bitStreamFinder = new BitStreamFinder(youkuVideoInfo, PlayerUtil.isWifi(context));
        BitStream findBitStream = bitStreamFinder.findBitStream(quality2, str);
        if (findBitStream == null) {
            Logger.d("can not find bitStream vid:" + vid + " qualityType:" + quality2 + " langCode:" + str + ", find other bitstream!");
            findBitStream = bitStreamFinder.findBitStream(quality2, null);
            str2 = "找流忽略语言";
        } else {
            str2 = "找流降档";
        }
        if (findBitStream == null) {
            Logger.d("can not find bitStream vid:" + vid + " qualityType:" + quality2 + " langCode:" + str + ", find other bitstream!");
            findBitStream = bitStreamFinder.findFirstBitStream();
            str2 = "找第一个流";
        }
        if (quality != quality3 && quality != findBitStream.getQuality()) {
            youkuVideoInfo.getPlayVideoInfo().putString("bitStreamChange", str2);
        }
        return findBitStream;
    }
}
