package utils;

public enum GenericConstants {
    URL_BASE("https://reqres.in"),
    USER_DATA("user_data"),
    LOGE("loge");

    private final String message;

    GenericConstants(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
