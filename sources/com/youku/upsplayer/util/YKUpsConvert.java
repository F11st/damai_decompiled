package com.youku.upsplayer.util;

import android.util.Log;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youku.upsplayer.module.Segs;
import com.youku.upsplayer.module.Stream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKUpsConvert {
    public static final char CHAR_A = 'A';
    public static final char CHAR_F = 'F';
    public static final char CHAR_NINE = '9';
    public static final char CHAR_ZERO = '0';
    public static final String FILEID = "fileid";
    public static final String FLAG_ARRAY = "_a";
    public static final String SEGS = "segs";
    public static final int SEQ_0 = 8;
    public static final int SEQ_1 = 9;
    public static final String TAG = "UpsPlayer";
    public static final int URL_LENGTH = 256;
    private long c;
    private boolean isCdn;
    private boolean isCdnBackup;
    private int sSize;
    private HashMap<String, Object> targetDatas = new HashMap<>();
    private HashMap<String, Object> backUpDatas = new HashMap<>();
    private List<Template> targetTemplate = new ArrayList();
    private List<Template> backTemplate = new ArrayList();
    private Stream[] streams = null;
    private String cdnBackKey = null;
    private int cdnBackArrayLength = 0;
    private int adLength = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class Template {
        public String key;
        public String value;

        private Template() {
        }
    }

    private Stream[] convertImpl(JSONArray jSONArray) {
        if (jSONArray != null) {
            int size = jSONArray.size();
            this.sSize = size;
            if (size <= 0) {
                return null;
            }
            try {
                this.c = System.currentTimeMillis();
                parseStream(jSONArray);
                log("stream parse:" + (System.currentTimeMillis() - this.c));
                this.c = System.currentTimeMillis();
                streamSegConvert(jSONArray);
                log("stream convert:" + (System.currentTimeMillis() - this.c));
            } catch (Exception e) {
                e.printStackTrace();
                log(Log.getStackTraceString(e));
            }
            return this.streams;
        }
        return null;
    }

    private boolean convertTargetDatas(Segs segs, JSONObject jSONObject) {
        HashMap<String, Object> hashMap;
        String str;
        this.targetTemplate.clear();
        this.backTemplate.clear();
        this.adLength = 0;
        if (!isEmpty(segs.cdn_url_template)) {
            this.isCdn = true;
            hashMap = this.targetDatas;
            str = segs.cdn_url_template;
        } else if (isEmpty(segs.rtmp_url_template)) {
            return false;
        } else {
            this.isCdn = false;
            hashMap = this.targetDatas;
            str = segs.rtmp_url_template;
        }
        matcher(hashMap, str, this.targetTemplate);
        if (isEmpty(segs.cdn_backup_template)) {
            this.isCdnBackup = false;
        } else {
            this.isCdnBackup = true;
            matcher(this.backUpDatas, segs.cdn_backup_template, this.backTemplate);
            this.cdnBackArrayLength = jSONObject.getJSONArray(this.cdnBackKey).size();
        }
        return true;
    }

    private String increaseSeq(String str) {
        char[] charArray = str.toCharArray();
        if (charArray[9] == 'F') {
            if (charArray[8] == '9') {
                charArray[8] = CHAR_A;
            } else {
                charArray[8] = (char) (charArray[8] + 1);
            }
            charArray[9] = CHAR_ZERO;
        } else if (charArray[9] == '9') {
            charArray[9] = CHAR_A;
        } else {
            charArray[9] = (char) (charArray[9] + 1);
        }
        if (charArray[8] > 'F') {
            log("filedid error");
            return null;
        }
        return String.valueOf(charArray);
    }

    public static void log(String str) {
        Log.e("UpsPlayer", str);
    }

    private void matcher(HashMap<String, Object> hashMap, String str, List<Template> list) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == '}') {
                Template template = new Template();
                String substring = str.substring(i + 1, i3);
                template.key = substring;
                if (substring.contains(FLAG_ARRAY)) {
                    this.cdnBackKey = template.key;
                }
                if (i2 != i) {
                    template.value = str.substring(i2, i);
                } else {
                    template.value = "";
                }
                list.add(template);
                hashMap.put(template.key, null);
                i2 = i3 + 1;
            } else if (str.charAt(i3) == '{') {
                i = i3;
            }
        }
        if (str.charAt(length - 1) != '}') {
            Template template2 = new Template();
            template2.key = "";
            template2.value = str.substring(str.indexOf(125) + 1);
            list.add(template2);
        }
    }

    private void parseStream(JSONArray jSONArray) {
        this.streams = new Stream[this.sSize];
        for (int i = 0; i < this.sSize; i++) {
            this.streams[i] = (Stream) ((JSONObject) jSONArray.get(i)).toJavaObject(Stream.class);
        }
    }

    private void parseStream(JSONArray jSONArray, Segs[] segsArr) {
        if (segsArr == null || segsArr.length <= 0) {
            return;
        }
        if (convertTargetDatas(segsArr[0], jSONArray.getJSONObject(0))) {
            int length = segsArr.length;
            for (int i = 0; i < length; i++) {
                if (segsArr[i].ad == 1) {
                    this.adLength++;
                } else {
                    prcessTemplate(segsArr, i, jSONArray);
                }
            }
        }
    }

    private void prcessBackUpSeg(Segs[] segsArr, int i, JSONArray jSONArray) {
        JSONObject jSONObject = jSONArray.getJSONObject(i);
        Segs segs = segsArr[i];
        int i2 = this.cdnBackArrayLength;
        segs.cdn_backup = new String[i2];
        StringBuilder[] sbArr = new StringBuilder[i2];
        for (int i3 = 0; i3 < this.cdnBackArrayLength; i3++) {
            sbArr[i3] = new StringBuilder(256);
        }
        for (Template template : this.backTemplate) {
            String str = template.key;
            String str2 = template.value;
            if (str != null) {
                Object obj = jSONObject.get(str);
                if (obj != null) {
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) obj;
                        for (int i4 = 0; i4 < this.cdnBackArrayLength; i4++) {
                            sbArr[i4].append(str2);
                            sbArr[i4].append(jSONArray2.get(i4));
                        }
                    } else {
                        for (int i5 = 0; i5 < this.cdnBackArrayLength; i5++) {
                            sbArr[i5].append(str2);
                            sbArr[i5].append(obj);
                        }
                    }
                    this.targetDatas.put(str, obj);
                } else {
                    Object obj2 = this.targetDatas.get(str);
                    if (FILEID.equals(str) && i != 0 && isEmpty(segsArr[i].fileid)) {
                        segsArr[i].fileid = increaseSeq(segsArr[(i - 1) - this.adLength].fileid);
                        obj2 = segsArr[i].fileid;
                        this.targetDatas.put(str, obj2);
                    }
                    if (obj2 instanceof JSONArray) {
                        JSONArray jSONArray3 = (JSONArray) obj2;
                        for (int i6 = 0; i6 < this.cdnBackArrayLength; i6++) {
                            sbArr[i6].append(str2);
                            sbArr[i6].append(jSONArray3.get(i6));
                        }
                    } else {
                        for (int i7 = 0; i7 < this.cdnBackArrayLength; i7++) {
                            sbArr[i7].append(str2);
                            sbArr[i7].append(obj2);
                        }
                    }
                }
            } else {
                for (int i8 = 0; i8 < this.cdnBackArrayLength; i8++) {
                    sbArr[i8].append(str2);
                }
            }
        }
        for (int i9 = 0; i9 < this.cdnBackArrayLength; i9++) {
            segsArr[i].cdn_backup[i9] = sbArr[i9].toString();
        }
    }

    private void prcessTargetSeg(Segs[] segsArr, int i, JSONArray jSONArray) {
        StringBuilder sb = new StringBuilder(256);
        JSONObject jSONObject = jSONArray.getJSONObject(i);
        for (Template template : this.targetTemplate) {
            String str = template.key;
            String str2 = template.value;
            if (str != null) {
                Object obj = jSONObject.get(str);
                if (obj != null) {
                    String valueOf = String.valueOf(obj);
                    sb.append(str2);
                    sb.append(valueOf);
                    this.targetDatas.put(str, valueOf);
                } else {
                    Object obj2 = this.targetDatas.get(str);
                    if (FILEID.equals(str) && i != 0 && isEmpty(segsArr[i].fileid)) {
                        segsArr[i].fileid = increaseSeq(segsArr[(i - 1) - this.adLength].fileid);
                        obj2 = segsArr[i].fileid;
                        this.targetDatas.put(str, obj2);
                    }
                    sb.append(str2);
                    sb.append(obj2);
                }
            } else {
                sb.append(str2);
            }
        }
        if (this.isCdn) {
            segsArr[i].cdn_url = sb.toString();
            return;
        }
        segsArr[i].rtmp_url = sb.toString();
    }

    private void prcessTemplate(Segs[] segsArr, int i, JSONArray jSONArray) {
        segsArr[i].total_milliseconds_audio = segsArr[i].tma;
        segsArr[i].total_milliseconds_video = segsArr[i].tmv;
        if (segsArr[i].key != null && (segsArr[i].key instanceof Integer) && ((Integer) segsArr[i].key).intValue() == -1) {
            return;
        }
        prcessTargetSeg(segsArr, i, jSONArray);
        if (this.isCdnBackup) {
            prcessBackUpSeg(segsArr, i, jSONArray);
        }
        this.adLength = 0;
    }

    private void streamSegConvert(JSONArray jSONArray) {
        for (int i = 0; i < this.sSize; i++) {
            parseStream(((JSONObject) jSONArray.get(i)).getJSONArray(SEGS), this.streams[i].segs);
        }
    }

    public Stream[] convert(JSONArray jSONArray) {
        return convertImpl(jSONArray);
    }

    public boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
