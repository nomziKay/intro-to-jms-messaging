package za.co.entelect.invest.easy.dojo.messaging.domain;

import java.io.Serializable;

public class ShareNotification implements Serializable {
    private ShareCode shareCode;
    private Integer newPrice;
    private Integer oldPrice;

    public ShareNotification() {
    }

    public ShareNotification(ShareCode shareCode, Integer newPrice, Integer oldPrice) {
        this.shareCode = shareCode;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
    }

    public ShareCode getShareCode() {
        return shareCode;
    }

    public void setShareCode(ShareCode shareCode) {
        this.shareCode = shareCode;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    @Override
    public String toString() {
        return "ShareNotification{" +
                "shareCode=" + shareCode +
                ", newPrice=" + newPrice +
                ", oldPrice=" + oldPrice +
                '}';
    }
}
