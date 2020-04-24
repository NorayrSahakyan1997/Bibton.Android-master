package am.spaysapps.bibton.shared.utils;

import java.util.ArrayList;
import java.util.List;

;import am.spaysapps.bibton.model.getTransactionList.TransactionResponse;

public final class Constants {
    private Constants() {
    }

    public static int CURRENT_PAGE = 0;
    public static int COINS_TRANSFERRING_DURABILITY = 3000;

    public static  String TOKEN  ;
    public static String PHONE_NUMBER;

    public static String COUNTRY_SHORT_NAME;
    public static String COUNTRY_CODE;
    public static String UNIQUE_ID;
    public static boolean IS_REGISTERED;

    public static List<TransactionResponse> TRANSACTION_LIST= new ArrayList<>();
    public static boolean IS_WALLET=true;
    public static int CURRENCY_ID=1;

    public static List<String> DATE= new ArrayList<>();
    public static List<TransactionResponse> DATELIST= new ArrayList<>();

}
