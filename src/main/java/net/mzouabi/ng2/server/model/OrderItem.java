package net.mzouabi.ng2.server.model;

/**
 * @author Filip Hrisafov
 */
public class OrderItem extends AbstractEntity {


    private String name;
    private Long quantity;

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
}
