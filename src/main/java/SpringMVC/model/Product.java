package SpringMVC.model;

public enum Product {
    MobilePHONE(10.0),
    BOOK(5.5),
    PICTURE(20.0);

    Double productPrice;

    Product(double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductPrice() {
        return productPrice;
    }
}

