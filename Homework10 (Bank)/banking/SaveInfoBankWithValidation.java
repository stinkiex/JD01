package banking;

import java.util.List;

public class SaveInfoBankWithValidation extends SaveInfoBank {

    @Override
    public void saveInfo(List<Bank> listBank) {
        validate(listBank);
        beforeLog();
        super.saveInfo(listBank);
    }

    public void validate(List<Bank> list){
        for (Bank bank : list) {
            if(bank.getName() == null){
                throw new IllegalArgumentException("Всё очень плохо");
            }
        }
    }

    public void beforeLog(){
        System.out.println("Начало сохранения");
    }
}
