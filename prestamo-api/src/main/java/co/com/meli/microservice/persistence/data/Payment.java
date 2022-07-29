/**
 * 
 */
package co.com.meli.microservice.persistence.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@Entity
@Table(name = "PAYMENT", schema = "CREDITDB")
@org.hibernate.annotations.Table(comment = "Stores records of payments made on a loan", appliesTo = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAYMENT")
    private Long id;

    @Column(name = "AMOUNT", columnDefinition = Constant.COLUMN_DEFINITION_STRING_AMOUNT_PAYMENT)
    private Double amount;

    @Column(name = "CREATION_DATE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_DATE_PAYMENT)
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LOAN")
    @NotNull
    private Loan loan;

}
