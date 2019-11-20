package banking;

import java.io.Serializable;

public enum AccountCurrency implements Serializable {
    USD(840, "USD"),
    EUR(978, "EUR"),
    BYN(933, "BYN"),
    RUB(643, "RUB");

    int code;
    String accCur;

    public int getCode() {
        return code;
    }

    public String getAccCur() {
        return accCur;
    }

    AccountCurrency(int code, String val) {
        this.code = code;
        this.accCur = accCur;

    }
}
