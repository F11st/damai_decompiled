package com.youku.playerservice.axp.playinfo;

import android.text.TextUtils;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.player.PlayCostTime;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.constants.TableField;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayInfo {
    private static final String TAG = "PlayInfo";
    public static final int VIDEO_VR_180_3D_LEFT_RIGHT = 5;
    public static final int VIDEO_VR_180_3D_TOP_DOWN = 4;
    public static final int VIDEO_VR_360_2D = 1;
    public static final int VIDEO_VR_360_3D_LEFT_RIGHT = 3;
    public static final int VIDEO_VR_360_3D_TOP_DOWN = 2;
    public static final int VIDEO_VR_NULL = 0;
    private AdInfo mAdInfo;
    private int mDuration;
    private boolean mIsRealVideoStarted;
    private boolean mIsRecycled;
    private int mPlayIndex;
    private PlayInfoResponse mPlayInfoResponse;
    private PlayItem mPlayItem;
    private PlayParams mPlayParams;
    private PlayDefinition.PlayScene mPlayScene;
    private PlayerConfig mPlayerConfig;
    private int mProgress;
    private int mCurrentAdIndex = -1;
    private Map<String, Object> mTags = new ConcurrentHashMap();
    private final IVpmFullInfo mFullInfo = new IVpmFullInfo() { // from class: com.youku.playerservice.axp.playinfo.PlayInfo.1
        @Override // com.youku.vpm.IMonitor
        public double getDouble(String str, double d) {
            return PlayInfo.this.getDouble(str, d);
        }

        @Override // com.youku.vpm.IExt, com.youku.vpm.IMonitor
        public String getString(String str, String str2) {
            return PlayInfo.this.getString(str, str2);
        }

        @Override // com.youku.vpm.IVpmFullInfo
        public Object getTag(String str) {
            return PlayInfo.this.getTag(str);
        }
    };
    private PlayCostTime mPlayCostTime = new PlayCostTime();

    public PlayInfo(PlayParams playParams, PlayerConfig playerConfig) {
        this.mPlayParams = playParams;
        this.mPlayerConfig = playerConfig;
        this.mPlayScene = playParams.getPlayScene();
    }

    public AdInfo getAdInfo() {
        return this.mAdInfo;
    }

    public List<BidInfo> getBitInfoByAdType(int i) {
        List<BidInfo> bidInfoListByType;
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null || (bidInfoListByType = adInfo.getBidInfoListByType(i)) == null || bidInfoListByType.size() < this.mCurrentAdIndex) {
            return null;
        }
        return bidInfoListByType;
    }

    public double getDouble(String str, double d) {
        return TextUtils.equals(str, "duration") ? getDuration() : d;
    }

    public int getDuration() {
        PlayItem playItem = this.mPlayItem;
        return (playItem == null || playItem.getDuration() <= this.mDuration) ? this.mDuration : this.mPlayItem.getDuration();
    }

    public PlayCostTime getPlayCostTime() {
        return this.mPlayCostTime;
    }

    public String getPlayId() {
        PlayInfoResponse playInfoResponse = this.mPlayInfoResponse;
        if (playInfoResponse != null) {
            return playInfoResponse.getPlayId();
        }
        PlayParams playParams = this.mPlayParams;
        return playParams == null ? "" : playParams.getPlayIdParams() != null ? this.mPlayParams.getPlayIdParams().getPlayId() : this.mPlayParams.getPlayUrlParams() != null ? this.mPlayParams.getPlayUrlParams().getPlayUrl() : "";
    }

    public int getPlayIndex() {
        return this.mPlayIndex;
    }

    public PlayInfoResponse getPlayInfoResponse() {
        return this.mPlayInfoResponse;
    }

    public PlayItem getPlayItem() {
        return this.mPlayItem;
    }

    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    public PlayDefinition.PlayScene getPlayScene() {
        return this.mPlayParams.getPlayScene();
    }

    public PlayDefinition.PlayType getPlayType() {
        return this.mPlayParams.getPlayType();
    }

    public PlayerConfig getPlayerConfig() {
        return this.mPlayerConfig;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getRealPosition(boolean z, int i) {
        boolean z2;
        PlayInfoResponse playInfoResponse = this.mPlayInfoResponse;
        if (playInfoResponse == null) {
            return i;
        }
        int i2 = -1;
        List<Point> cutAdPoints = playInfoResponse instanceof PlayInfoUpsResponse ? ((PlayInfoUpsResponse) playInfoResponse).getCutAdPoints() : null;
        int i3 = 0;
        if (cutAdPoints != null && cutAdPoints.size() > 0) {
            i2 = 0;
            int i4 = -1;
            while (true) {
                if (i2 >= cutAdPoints.size()) {
                    i2 = i4;
                    break;
                }
                double d = cutAdPoints.get(i2).start;
                double d2 = cutAdPoints.get(i2).start + cutAdPoints.get(i2).al;
                double d3 = i;
                if (d3 >= d && d3 <= d2) {
                    z2 = true;
                    break;
                } else if (d3 < d) {
                    break;
                } else {
                    if (d3 > d2) {
                        i4 = i2;
                    }
                    i2++;
                }
            }
        }
        z2 = false;
        if (i2 > 0 && cutAdPoints != null && cutAdPoints.size() > 0) {
            int i5 = 0;
            while (i3 < i2) {
                i5 += cutAdPoints.get(i3).al;
                i3++;
            }
            i3 = i5;
        }
        return (!z2 || cutAdPoints == null || cutAdPoints.size() <= 0) ? i - i3 : z ? i - ((int) cutAdPoints.get(i2).start) : ((int) cutAdPoints.get(i2).start) - i3;
    }

    public String getString(String str, String str2) {
        if (TextUtils.equals(str, "vid")) {
            if (this.mPlayParams.getPlayType() != PlayDefinition.PlayType.LIVE) {
                return getPlayId();
            }
            PlayInfoResponse playInfoResponse = this.mPlayInfoResponse;
            if (playInfoResponse != null) {
                return playInfoResponse.getProperties("vid", (String) null);
            }
        } else if (TextUtils.equals(str, "showId") && this.mPlayParams.getPlayType() == PlayDefinition.PlayType.VOD) {
            PlayInfoResponse playInfoResponse2 = this.mPlayInfoResponse;
            if (playInfoResponse2 != null) {
                return playInfoResponse2.getProperties("showId", (String) null);
            }
            return null;
        }
        if (this.mPlayItem != null) {
            if (TextUtils.equals(str, TableField.FILE_FORMAT)) {
                return this.mPlayItem.getPlayFormat().getStatistics();
            }
            if (TextUtils.equals(str, TableField.VIDEO_FORMAT)) {
                return this.mPlayItem.getVideoFormat();
            }
            if (TextUtils.equals(str, TableField.STREAM_TYPE)) {
                return this.mPlayItem.getStreamType();
            }
            if (TextUtils.equals(str, "playQuality")) {
                return this.mPlayItem.getQuality().toString();
            }
            PlayInfoResponse playInfoResponse3 = this.mPlayInfoResponse;
            if (playInfoResponse3 != null) {
                String properties = playInfoResponse3.getProperties(str, (String) null);
                if (!TextUtils.isEmpty(properties)) {
                    return properties;
                }
            }
        }
        return this.mPlayParams.getString(str, str2);
    }

    public Object getTag(String str) {
        return this.mTags.get(str);
    }

    public int getVRMode() {
        int vrType;
        if (getPlayType() != PlayDefinition.PlayType.VOD) {
            getPlayType();
            PlayDefinition.PlayType playType = PlayDefinition.PlayType.LIVE;
            return 101;
        } else if (getPlayItem() == null || (vrType = ((VodItem) getPlayItem()).getBitStream().getVrType()) == 0) {
            return 101;
        } else {
            if (vrType != 1) {
                return vrType != 2 ? 101 : 102;
            }
            return 103;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getVRType() {
        /*
            r6 = this;
            java.lang.String r0 = "PlayInfo"
            java.lang.String r1 = "getVRType: enter"
            com.youku.playerservice.axp.utils.Logger.d(r0, r1)
            com.youku.playerservice.axp.axpinterface.PlayDefinition$PlayType r1 = r6.getPlayType()
            com.youku.playerservice.axp.axpinterface.PlayDefinition$PlayType r2 = com.youku.playerservice.axp.axpinterface.PlayDefinition.PlayType.VOD
            r3 = 0
            if (r1 != r2) goto Le4
            boolean r1 = r6.isPanorama()
            if (r1 != 0) goto L1c
            java.lang.String r1 = "getVRType: return after isPanorama"
            com.youku.playerservice.axp.utils.Logger.d(r0, r1)
            return r3
        L1c:
            com.youku.playerservice.axp.playinfo.PlayInfoResponse r1 = r6.mPlayInfoResponse
            if (r1 == 0) goto L6d
            com.youku.playerservice.axp.playinfo.NetUpsInfo r1 = r1.getUpsInfo()
            if (r1 == 0) goto L6d
            com.youku.playerservice.axp.playinfo.PlayInfoResponse r1 = r6.mPlayInfoResponse
            com.youku.playerservice.axp.playinfo.NetUpsInfo r1 = r1.getUpsInfo()
            com.youku.upsplayer.module.VideoInfo r1 = r1.getVideoInfo()
            if (r1 == 0) goto L6d
            com.youku.playerservice.axp.playinfo.PlayInfoResponse r1 = r6.mPlayInfoResponse
            com.youku.playerservice.axp.playinfo.NetUpsInfo r1 = r1.getUpsInfo()
            com.youku.upsplayer.module.VideoInfo r1 = r1.getVideoInfo()
            com.youku.upsplayer.module.Video r1 = r1.getVideo()
            java.lang.String r1 = r1.vrType
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L6d
            com.youku.playerservice.axp.playinfo.PlayInfoResponse r1 = r6.mPlayInfoResponse
            com.youku.playerservice.axp.playinfo.NetUpsInfo r1 = r1.getUpsInfo()
            com.youku.upsplayer.module.VideoInfo r1 = r1.getVideoInfo()
            com.youku.upsplayer.module.Video r1 = r1.getVideo()
            java.lang.String r1 = r1.vrType
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getVRType ----> videoInfo :"
            r2.append(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.youku.playerservice.axp.utils.Logger.d(r0, r2)
            goto L74
        L6d:
            java.lang.String r1 = "getVRType ----> is null"
            com.youku.playerservice.axp.utils.Logger.d(r0, r1)
            java.lang.String r1 = ""
        L74:
            com.youku.playerservice.axp.item.PlayItem r0 = r6.getPlayItem()
            if (r0 == 0) goto Le3
            com.youku.playerservice.axp.item.PlayItem r0 = r6.getPlayItem()
            com.youku.playerservice.axp.item.VodItem r0 = (com.youku.playerservice.axp.item.VodItem) r0
            r2 = 2
            r4 = 1
            if (r0 == 0) goto L9d
            com.youku.playerservice.axp.item.BitStream r5 = r0.getBitStream()
            if (r5 == 0) goto L9d
            com.youku.playerservice.axp.item.BitStream r0 = r0.getBitStream()
            int r0 = r0.getVrType()
            if (r0 == 0) goto L9d
            if (r0 == r4) goto L9b
            if (r0 == r2) goto L99
            goto L9d
        L99:
            r0 = 1
            goto L9e
        L9b:
            r0 = 2
            goto L9e
        L9d:
            r0 = 0
        L9e:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto Le3
            java.lang.String r5 = "1"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto Lb0
            int r0 = r0 * 10
            int r0 = r0 + r4
            return r0
        Lb0:
            java.lang.String r4 = "2"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto Lbc
            int r0 = r0 * 10
            int r0 = r0 + r2
            return r0
        Lbc:
            java.lang.String r2 = "3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto Lc9
            int r0 = r0 * 10
            int r0 = r0 + 3
            return r0
        Lc9:
            java.lang.String r2 = "4"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto Ld6
            int r0 = r0 * 10
            int r0 = r0 + 4
            return r0
        Ld6:
            java.lang.String r2 = "5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Le3
            int r0 = r0 * 10
            int r0 = r0 + 5
            return r0
        Le3:
            return r3
        Le4:
            r6.getPlayType()
            com.youku.playerservice.axp.axpinterface.PlayDefinition$PlayType r0 = com.youku.playerservice.axp.axpinterface.PlayDefinition.PlayType.LIVE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.playinfo.PlayInfo.getVRType():int");
    }

    public IVpmFullInfo getVpmFullInfo() {
        return this.mFullInfo;
    }

    public boolean isPanorama() {
        PlayInfoResponse playInfoResponse = this.mPlayInfoResponse;
        if (playInfoResponse != null) {
            return "1".equals(playInfoResponse.getProperties("isPanorama", ""));
        }
        return false;
    }

    public boolean isRealVideoStarted() {
        return this.mIsRealVideoStarted;
    }

    public boolean isRecycled() {
        return this.mIsRecycled;
    }

    public void putString(String str, String str2) {
        this.mPlayParams.putString(str, str2);
    }

    public void recycle() {
        this.mIsRecycled = true;
    }

    public void setAdInfo(AdInfo adInfo) {
        this.mAdInfo = adInfo;
    }

    public void setCurrentAdIndex(int i) {
        this.mCurrentAdIndex = i;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setPlayIndex(int i) {
        this.mPlayIndex = this.mPlayIndex;
    }

    public void setPlayInfoResponse(PlayInfoResponse playInfoResponse) {
        this.mPlayInfoResponse = playInfoResponse;
        this.mAdInfo = playInfoResponse.getAdInfo();
    }

    public void setPlayItem(PlayItem playItem) {
        this.mPlayItem = playItem;
    }

    public void setPlayParams(PlayParams playParams) {
        this.mPlayParams = playParams;
    }

    public void setPlayerConfig(PlayerConfig playerConfig) {
        this.mPlayerConfig = playerConfig;
    }

    public void setProgress(int i) {
        this.mProgress = i;
        this.mPlayCostTime.onPositionUpdate(i);
    }

    public void setRealVideoStarted(boolean z) {
        this.mIsRealVideoStarted = z;
    }

    public void setTag(String str, Object obj) {
        if (obj != null) {
            this.mTags.put(str, obj);
        } else {
            this.mTags.remove(str);
        }
    }
}
