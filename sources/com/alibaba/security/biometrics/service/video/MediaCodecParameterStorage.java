package com.alibaba.security.biometrics.service.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MediaCodecParameterStorage {
    private static final String KEY_COLOR_FORMAT = "colorFormat";
    private static final String KEY_ENCODE_NAME = "encodeName";
    private static final String PREF_PREFIX = "libstreaming-encode-";
    private final Context mContext;
    private int mEncoderColorFormat;
    private String mEncoderName;
    private final SharedPreferences mSharedPreferences;

    public MediaCodecParameterStorage(Context context) {
        this.mContext = context;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mSharedPreferences = defaultSharedPreferences;
        this.mEncoderName = defaultSharedPreferences.getString("libstreaming-encode-encodeName", "");
        this.mEncoderColorFormat = defaultSharedPreferences.getInt("libstreaming-encode-colorFormat", -1);
    }

    public int getEncoderColorFormat() {
        return this.mEncoderColorFormat;
    }

    public String getEncoderName() {
        return this.mEncoderName;
    }

    public void saveColorFormat(int i) {
        setEncoderColorFormat(i);
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt("libstreaming-encode-colorFormat", i);
        edit.apply();
    }

    public void saveEncodeName(String str) {
        setEncoderName(str);
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("libstreaming-encode-encodeName", str);
        edit.apply();
    }

    public void setEncoderColorFormat(int i) {
        this.mEncoderColorFormat = i;
    }

    public void setEncoderName(String str) {
        this.mEncoderName = str;
    }
}
