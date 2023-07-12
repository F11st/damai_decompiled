package com.youku.alixplayer;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AlixPlayerConfig {
    private String player_id;
    private String player_name;
    private AlixPlayerType player_type;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum AlixPlayerType {
        PLAYER_ALIX(10),
        PLAYER_ANDROID(20),
        PLAYER_HUAWEI(30);
        
        private int moduleId;

        AlixPlayerType(int i) {
            this.moduleId = i;
        }

        public int getModuleId() {
            return this.moduleId;
        }
    }

    public AlixPlayerConfig() {
        this.player_type = AlixPlayerType.PLAYER_ALIX;
    }

    public AlixPlayerConfig(AlixPlayerType alixPlayerType) {
        this.player_type = alixPlayerType;
    }

    public String getPlayerID() {
        return this.player_id;
    }

    public AlixPlayerType getPlayerType() {
        return this.player_type;
    }

    public void setPlayerID(String str) {
        this.player_id = str;
    }

    public void setPlayerType(AlixPlayerType alixPlayerType) {
        this.player_type = alixPlayerType;
    }
}
