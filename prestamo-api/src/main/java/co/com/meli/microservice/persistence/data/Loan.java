/**
 * 
 */
package co.com.meli.microservice.persistence.data;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@Entity
@Table(name = Constant.TABLE_STRING_NAME_LOAN, schema = Constant.DATABASE_STRING_SCHEMA)
@org.hibernate.annotations.Table(comment = Constant.TABLE_STRING_COMMENT_LOAN, appliesTo = Constant.COMMON_STRING_LOAN)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constant.COLUMN_STRING_NAME_ID_LOAN)
    private Long id;

    @Column(name = Constant.COLUMN_STRING_NAME_DESCRIPTION_LOAN, columnDefinition = Constant.COLUMN_DEFINITION_STRING_DESCRIPTION_LOAN)
    private String description;

    @Column(name = Constant.COLUMN_STRING_NAME_INSTALLMENT_LOAN, columnDefinition = Constant.COLUMN_DEFINITION_STRING_INSTALLMENT_LOAN)
    private Double installment;

    @Column(name = Constant.COLUMN_STRING_NAME_AMOUNT_LOAN, columnDefinition = Constant.COLUMN_DEFINITION_STRING_AMOUNT_LOAN)
    private Double amount;

    @Column(name = Constant.COLUMN_STRING_NAME_RATE_LOAN, columnDefinition = Constant.COLUMN_DEFINITION_STRING_RATE_LOAN)
    private Double rate;

    @Column(name = Constant.COLUMN_STRING_NAME_TERM_LOAN, columnDefinition = Constant.COLUMN_DEFINITION_STRING_TERM_LOAN)
    private Integer term;

    @Column(name = Constant.COLUMN_STRING_NAME_STATUS_LOAN, columnDefinition = Constant.COLUMN_DEFINITION_STRING_STATUS_LOAN)
    private Integer status;

    @Column(name = Constant.COLUMN_STRING_NAME_CREATION_USER_LOAN, columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_USER_LOAN)
    private String creationUser;

    @Column(name = Constant.COLUMN_STRING_NAME_CREATION_DATE_LOAN, columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_DATE_LOAN)
    private LocalDateTime creationDate;

    @Column(name = Constant.COLUMN_STRING_NAME_MODIFICATION_USER_LOAN, columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_USER_LOAN)
    private String modificationUser;

    @Column(name = Constant.COLUMN_STRING_NAME_MODIFICATION_DATE_LOAN, columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_DATE_LOAN)
    private LocalDateTime modificationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Constant.COLUMN_STRING_NAME_ID_CLIENT)
    private Client client;

    @OneToMany(mappedBy = Constant.COMMON_STRING_LOAN, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Payment> payments;

}
