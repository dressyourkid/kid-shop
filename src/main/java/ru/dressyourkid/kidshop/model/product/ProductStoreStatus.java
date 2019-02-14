package ru.dressyourkid.kidshop.model.product;

/**
 * Product store status
 */
public enum ProductStoreStatus {

    FREE(0), PREORDERED(10), ORDERED(100), SOLD(900), OUT_OF_STORE(-1);

    private Integer statusCode;

    ProductStoreStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
