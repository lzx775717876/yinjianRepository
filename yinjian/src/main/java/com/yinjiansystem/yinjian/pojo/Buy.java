package com.yinjiansystem.yinjian.pojo;

/**
 * @Description 氪金记录 实体类
 * @Author DT
 * @Date 2020/11/27
 */
public class Buy extends BaseModel {

    //用户id
    private String userId;

    //游戏名
    private String gameName;

    //金额
    private String money;

    //备注
    private String remark;

    //图片地址
    private String photoPath;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
