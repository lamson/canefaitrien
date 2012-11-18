package ;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table MARKETPLACE.
 */
public class Marketplace {

    private Long id;
    private Integer lastDock;
    private String itemStock;
    private String itemBuyPrices;
    private String itemSellPrices;

    public Marketplace() {
    }

    public Marketplace(Long id) {
        this.id = id;
    }

    public Marketplace(Long id, Integer lastDock, String itemStock, String itemBuyPrices, String itemSellPrices) {
        this.id = id;
        this.lastDock = lastDock;
        this.itemStock = itemStock;
        this.itemBuyPrices = itemBuyPrices;
        this.itemSellPrices = itemSellPrices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLastDock() {
        return lastDock;
    }

    public void setLastDock(Integer lastDock) {
        this.lastDock = lastDock;
    }

    public String getItemStock() {
        return itemStock;
    }

    public void setItemStock(String itemStock) {
        this.itemStock = itemStock;
    }

    public String getItemBuyPrices() {
        return itemBuyPrices;
    }

    public void setItemBuyPrices(String itemBuyPrices) {
        this.itemBuyPrices = itemBuyPrices;
    }

    public String getItemSellPrices() {
        return itemSellPrices;
    }

    public void setItemSellPrices(String itemSellPrices) {
        this.itemSellPrices = itemSellPrices;
    }

}