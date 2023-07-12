package cn.damai.common.image.luban;

import android.graphics.BitmapFactory;
import android.util.Log;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
enum Checker {
    SINGLE;
    
    private static final String JPG = ".jpg";
    private static final String TAG = "Luban";
    private final byte[] JPEG_SIGNATURE = {-1, -40, -1};

    Checker() {
    }

    private int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (bArr[i] & 255) | (i4 << 8);
            i += i3;
            i2 = i5;
        }
    }

    private byte[] toByteArray(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                } catch (Exception unused2) {
                    byte[] bArr2 = new byte[0];
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    return bArr2;
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
                throw th;
            }
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String extSuffix(InputStreamProvider inputStreamProvider) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamProvider.open(), null, options);
            return options.outMimeType.replace("image/", ".");
        } catch (Exception unused) {
            return JPG;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getOrientation(InputStream inputStream) {
        return getOrientation(toByteArray(inputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isJPG(InputStream inputStream) {
        return isJPG(toByteArray(inputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needCompress(int i, String str) {
        if (i > 0) {
            File file = new File(str);
            return file.exists() && file.length() > ((long) (i << 10));
        }
        return true;
    }

    private int getOrientation(byte[] bArr) {
        int i;
        int i2;
        if (bArr == null) {
            return 0;
        }
        int i3 = 0;
        while (i3 + 3 < bArr.length) {
            int i4 = i3 + 1;
            if ((bArr[i3] & 255) == 255) {
                int i5 = bArr[i4] & 255;
                if (i5 != 255) {
                    i4++;
                    if (i5 != 216 && i5 != 1) {
                        if (i5 != 217 && i5 != 218) {
                            int pack = pack(bArr, i4, 2, false);
                            if (pack >= 2 && (i2 = i4 + pack) <= bArr.length) {
                                if (i5 == 225 && pack >= 8 && pack(bArr, i4 + 2, 4, false) == 1165519206 && pack(bArr, i4 + 6, 2, false) == 0) {
                                    i3 = i4 + 8;
                                    i = pack - 8;
                                    break;
                                }
                                i3 = i2;
                            } else {
                                Log.e(TAG, "Invalid length");
                                return 0;
                            }
                        }
                    }
                }
                i3 = i4;
            }
            i3 = i4;
        }
        i = 0;
        if (i > 8) {
            int pack2 = pack(bArr, i3, 4, false);
            if (pack2 != 1229531648 && pack2 != 1296891946) {
                Log.e(TAG, "Invalid byte order");
                return 0;
            }
            boolean z = pack2 == 1229531648;
            int pack3 = pack(bArr, i3 + 4, 4, z) + 2;
            if (pack3 >= 10 && pack3 <= i) {
                int i6 = i3 + pack3;
                int i7 = i - pack3;
                int pack4 = pack(bArr, i6 - 2, 2, z);
                while (true) {
                    int i8 = pack4 - 1;
                    if (pack4 <= 0 || i7 < 12) {
                        break;
                    } else if (pack(bArr, i6, 2, z) == 274) {
                        int pack5 = pack(bArr, i6 + 8, 2, z);
                        if (pack5 != 1) {
                            if (pack5 != 3) {
                                if (pack5 != 6) {
                                    if (pack5 != 8) {
                                        Log.e(TAG, "Unsupported orientation");
                                        return 0;
                                    }
                                    return AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
                                }
                                return 90;
                            }
                            return 180;
                        }
                        return 0;
                    } else {
                        i6 += 12;
                        i7 -= 12;
                        pack4 = i8;
                    }
                }
            } else {
                Log.e(TAG, "Invalid offset");
                return 0;
            }
        }
        Log.e(TAG, "Orientation not found");
        return 0;
    }

    private boolean isJPG(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(this.JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }
}
