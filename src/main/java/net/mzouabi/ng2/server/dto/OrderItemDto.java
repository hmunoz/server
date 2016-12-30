package net.mzouabi.ng2.server.dto;

/**
 * @author Filip Hrisafov
 */
public class OrderItemDto  extends AbstractDTO{

     String name;
     Long quantity;

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
