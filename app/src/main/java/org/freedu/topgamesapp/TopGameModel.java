package org.freedu.topgamesapp;

public class TopGameModel {
    private String gameName, companyName;
    private int gameImg;

    public TopGameModel(String gameName, String companyName, int gameImg) {
        this.gameName = gameName;
        this.companyName = companyName;
        this.gameImg = gameImg;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getGameImg() {
        return gameImg;
    }

    public void setGameImg(int gameImg) {
        this.gameImg = gameImg;
    }
}
