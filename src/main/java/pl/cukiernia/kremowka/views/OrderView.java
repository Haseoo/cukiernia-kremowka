package pl.cukiernia.kremowka.views;

public final class OrderView {
    private final String product;
    private final int qty;
    private final String personalInfo;

    public OrderView(String product, int qty, String personalInfo) {
        this.product = product;
        this.qty = qty;
        this.personalInfo = personalInfo;
    }

    public String getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public String getPersonalInfo() {
        return personalInfo;
    }

}
