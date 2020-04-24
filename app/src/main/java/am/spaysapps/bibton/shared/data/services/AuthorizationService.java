package am.spaysapps.bibton.shared.data.services;

import am.spaysapps.bibton.model.ResponseModel;
import am.spaysapps.bibton.model.getTransactionList.TransactionFilterRequestModel;
import am.spaysapps.bibton.model.checkPassCode.CheckPassCodeModel;
import am.spaysapps.bibton.model.countryModel.CountryParentModel;
import am.spaysapps.bibton.model.createAccountModel.CreateAccountModel;
import am.spaysapps.bibton.model.forgetPassCodeModel.ForgetPassCodeModel;
import am.spaysapps.bibton.model.getTransactionList.TransactionParentModel;
import am.spaysapps.bibton.model.phoneNumberCodeModel.CountryCode;
import am.spaysapps.bibton.model.singUpModel.SignUp;
import am.spaysapps.bibton.model.walletCurrency.WalletCurrencyParentResponse;
import am.spaysapps.bibton.shared.data.api.IAuthorizationService;
import am.spaysapps.bibton.shared.data.services.root.BaseService;
import io.reactivex.Flowable;

public class AuthorizationService extends BaseService {

    private final IAuthorizationService mService;

    public AuthorizationService(IAuthorizationService service) {
        mService = service;
    }

    public Flowable<ResponseModel<CountryParentModel>> getCountryList() {
        return request(mService.getCountryList());
    }

    public Flowable<ResponseModel<CountryCode>> getCountryCode() {
        return request(mService.getCountryCode());
    }

    public Flowable<ResponseModel<SignUp>> getUserInfo(String shortName, String phoneNumber) {
        return request(mService.getUserInfo(shortName, phoneNumber));
    }


    public Flowable<ResponseModel<CheckPassCodeModel>> checkPassCode(String unique_id, String code) {
        return request(mService.checkPassCode(unique_id, code));
    }

    public Flowable<ResponseModel<SignUp>> checkValidationPhoneNumber(String shortName, String phoneNumber) {
        return request(mService.checkPhoneNumberValidation(shortName, phoneNumber));
    }

    public Flowable<ResponseModel<CreateAccountModel>> createAccount(String unique_id, String code, String passcode) {
        return request(mService.createAccount(unique_id, code, passcode));
    }

    public Flowable<ResponseModel<ForgetPassCodeModel>> forgetPass(String unique_id, String passCode) {
        return request(mService.forgetPassCode(unique_id, passCode));
    }

//    public Flowable<ResponseModel<TransactionParentModel>> getTransaction(TransactionRequestModel transactionRequestModel) {
//        return request(mService.getTransactionList(transactionRequestModel));
//    }
    public Flowable<ResponseModel<TransactionParentModel>> getTransaction() {
        return request(mService.getTransactionList());
    }
    public Flowable<ResponseModel<WalletCurrencyParentResponse>> getCurrency() {
        return request(mService.getCurrencyList());
    }
    public Flowable<ResponseModel<TransactionParentModel>> getTransactionFiltered(TransactionFilterRequestModel transactionFilterRequestModel) {
        return request(mService.getFilteredListTransaction(transactionFilterRequestModel));
    }
    public Flowable<ResponseModel<TransactionParentModel>> getTransactionsUnfiltered() {
        return request(mService.getTransactionListUnfiltered());
    }

}