package com.my;
public class StatusCodeAndTextErrors {
    private static int SUCCESS_CREATE_COURIER_STATUS_CODE = 201;
    private static int LOGIN_DUPLICATE_STATUS_CODE = 409;
    private static int NOT_ENOUGH_DATA_STATUS_CODE = 400;
    private static int SUCCESS_LOGIN_COURIER_STATUS_CODE = 200;
    private static int LOGIN_ERROR_WITHOUT_LOGIN_OR_PASSWORD_STATUS_CODE = 400;
    private static int LOGIN_ERROR_NOT_FOUND_STATUS_CODE = 404;
    private static String ERROR_NOT_FOUND_STATUS_CODE= "Учетная запись не найдена";
    private static String ERROR_LOGIN_WITHOUT_LOGIN_OR_PASSWORD = "Недостаточно данных для входа";
    private static String ERROR_CREATE_WITHOUT_LOGIN_OR_PASSWORD = "Недостаточно данных для создания учетной записи";
    private static int SUCCESS_CREATE_ORDER = 201;
    private static int SUCCESS_GET_ORDER_LIST = 200;
    public static int getSuccessGetOrderList() {
        return SUCCESS_GET_ORDER_LIST;
    }
    public static int getSuccessCreateOrder() {
        return SUCCESS_CREATE_ORDER;
    }

    public static String getErrorLoginWithoutLoginOrPassword() {
        return ERROR_LOGIN_WITHOUT_LOGIN_OR_PASSWORD;
    }
    public static String getErrorNotFound() {
        return ERROR_NOT_FOUND_STATUS_CODE;
    }
    public static int getLoginErrorNotFoundStatusCode() {
        return LOGIN_ERROR_NOT_FOUND_STATUS_CODE;
    }
    public static int getLoginErrorStatusCode() {
        return LOGIN_ERROR_WITHOUT_LOGIN_OR_PASSWORD_STATUS_CODE;
    }
    public static String getCreateErrorWithoutLoginOrPassword() {
        return ERROR_CREATE_WITHOUT_LOGIN_OR_PASSWORD;
    }
    public static int getSuccessLoginCourier() {
        return SUCCESS_LOGIN_COURIER_STATUS_CODE;
    }
    public static int getSuccessCreateCourierStatusCode() {
        return SUCCESS_CREATE_COURIER_STATUS_CODE;
    }
    public static int getLoginDuplicateStatusCode() {
        return LOGIN_DUPLICATE_STATUS_CODE;
    }
    public static int getNotEnoughDataStatusCode() {
        return NOT_ENOUGH_DATA_STATUS_CODE;
    }

}
