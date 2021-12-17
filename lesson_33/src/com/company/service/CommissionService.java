package com.company.service;

import com.company.constants.CommissionConstant;
import com.company.enums.CardType;
import com.company.exceptions.CardTypeNotFoundException;

public class CommissionService {

    public static   Double getTransactionCommission(CardType CardA, CardType CardB){
        if (CardA.equals(CardType.UZCARD) && CardB.equals(CardType.UZCARD)){
            return CommissionConstant.UzcardToUzcard;
        }
        else if (CardA.equals(CardType.HUMO) && CardB.equals(CardType.HUMO)){
            return CommissionConstant.HumoToHumo;
        }
        else if (CardA.equals(CardType.UZCARD) || CardB.equals(CardType.HUMO)){
            return CommissionConstant.UzcardToHumo;
        }
        else {
           throw  new CardTypeNotFoundException("Not found");
        }


    }


}
