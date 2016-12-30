package net.mzouabi.ng2.server.model;

import java.util.Date;

/**
 * @author Filip Hrisafov
 */
public class OrderItem extends AbstractEntity {


    private String name;
    private Long quantity;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
