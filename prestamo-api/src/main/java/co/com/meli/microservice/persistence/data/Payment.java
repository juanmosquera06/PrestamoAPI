/**
 * 
 */
package co.com.meli.microservice.persistence.data;

import java.time.LocalDateTime;

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
 * Entity class annotated with @Entity that contains the information related to
 * the payment.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see Entity
 *
 */
@Entity
@Table(name = Constant.TABLE_STRING_NAME_PAYMENT, schema = Constant.DATABASE_STRING_SCHEMA)
@org.hibernate.annotations.Table(comment = Constant.TABLE_STRING_COMMENT_PAYMENT, appliesTo = Constant.COMMON_STRING_PAYMENT)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constant.COLUMN_STRING_NAME_ID_PAYMENT)
    private Long id;

    @Column(name = Constant.COLUMN_STRING_NAME_AMOUNT_PAYMENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_AMOUNT_PAYMENT)
    private Double amount;

    @Column(name = Constant.COLUMN_STRING_NAME_CREATION_DATE_PAYMENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_DATE_PAYMENT)
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Constant.COLUMN_STRING_NAME_ID_LOAN)
    @NotNull
    private Loan loan;

}
