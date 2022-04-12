package jpabook.jpashop.domain.voucher;

import javax.persistence.*;

@Entity
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
