package android.taobao.windvane.cache;

import android.taobao.windvane.util.TaoLog;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVFileInfoParser {
    public static final long DEFAULT_MAX_AGE = 2592000000L;
    public static final int FILE_INFO_MIN_LEN = 60;
    public static final long S_MAX_AGE = 300000;

    public static WVFileInfo getFileInfo(byte[] bArr, int i, int i2) {
        try {
            return getFileInfo(new String(bArr, i, i2, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void refreshFileInfo(WVFileInfo wVFileInfo, FileChannel fileChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        byte[] composeFileInfoStr = wVFileInfo.composeFileInfoStr();
        if (composeFileInfoStr == null) {
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(composeFileInfoStr.length + 1);
        allocate.put(composeFileInfoStr);
        allocate.put((byte) 10);
        allocate.position(0);
        try {
            fileChannel.write(allocate, wVFileInfo.pos);
        } catch (IOException e) {
            TaoLog.e("FileInfoParser", "refreshFileInfo: write error. " + e.getMessage());
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.d("FileInfoParser", "refreshFileInfo time cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static WVFileInfo updateFileInfo(int i, WVFileInfo wVFileInfo, FileChannel fileChannel) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("FileInfoParser", "updateFileInfo filename:" + wVFileInfo.fileName + "operation:" + i);
        }
        if (i == 1) {
            refreshFileInfo(wVFileInfo, fileChannel);
        } else if (i == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (wVFileInfo.expireTime == 0) {
                wVFileInfo.expireTime = currentTimeMillis + 300000;
            }
            refreshFileInfo(wVFileInfo, fileChannel);
        } else if (i == 3) {
            wVFileInfo.valid = false;
            refreshFileInfo(wVFileInfo, fileChannel);
        } else if (i == 4) {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (wVFileInfo.expireTime == 0) {
                wVFileInfo.expireTime = currentTimeMillis2 + 300000;
            }
            try {
                wVFileInfo.pos = fileChannel.size();
            } catch (IOException e) {
                TaoLog.e("FileInfoParser", "updateFileInfo setPos error:" + wVFileInfo.fileName + ". fChannel.size():" + e.getMessage());
            }
            refreshFileInfo(wVFileInfo, fileChannel);
        }
        return wVFileInfo;
    }

    private static WVFileInfo getFileInfo(String str) {
        if (str.length() > 60 && str.charAt(13) == '~' && str.charAt(27) == '~' && str.charAt(60) == '~') {
            WVFileInfo wVFileInfo = new WVFileInfo();
            String[] split = str.split(Constants.WAVE_SEPARATOR);
            if (7 != split.length) {
                return null;
            }
            try {
                wVFileInfo.expireTime = Long.parseLong(split[0]);
                try {
                    wVFileInfo.lastModified = Long.parseLong(split[1]);
                    wVFileInfo.fileName = split[2];
                    wVFileInfo.sha256ToHex = split[3];
                    wVFileInfo.mimeType = split[4];
                    wVFileInfo.etag = split[5];
                    wVFileInfo.encoding = split[6];
                    return wVFileInfo;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
