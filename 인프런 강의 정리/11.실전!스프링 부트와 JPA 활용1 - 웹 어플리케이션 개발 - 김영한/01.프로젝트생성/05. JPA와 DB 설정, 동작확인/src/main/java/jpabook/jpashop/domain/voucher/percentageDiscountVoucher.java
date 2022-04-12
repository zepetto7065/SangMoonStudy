package jpabook.jpashop.domain.voucher;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class percentageDiscountVoucher extends voucher {
    private int percentage;
}
