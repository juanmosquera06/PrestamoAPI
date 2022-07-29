/**
 * 
 */
package co.com.meli.microservice.persistence.data;

import java.util.Date;
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
@Table(name = "LOAN", schema = "CREDITDB")
@org.hibernate.annotations.Table(comment = "Stores money loans by user with the respective credit conditions", appliesTo = "loan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOAN")
    private Long id;

    @Column(name = "DESCRIPTION", columnDefinition = Constant.COLUMN_DEFINITION_STRING_DESCRIPTION_LOAN)
    private String description;

    @Column(name = "INSTALLMENT", columnDefinition = Constant.COLUMN_DEFINITION_STRING_INSTALLMENT_LOAN)
    private Double installment;

    @Column(name = "AMOUNT", columnDefinition = Constant.COLUMN_DEFINITION_STRING_AMOUNT_LOAN)
    private Double amount;

    @Column(name = "RATE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_RATE_LOAN)
    private Double rate;

    @Column(name = "TERM", columnDefinition = Constant.COLUMN_DEFINITION_STRING_TERM_LOAN)
    private Integer term;

    @Column(name = "STATUS", columnDefinition = Constant.COLUMN_DEFINITION_STRING_STATUS_LOAN)
    private Integer status;

    @Column(name = "CREATION_USER", columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_USER_LOAN)
    private String creationUser;

    @Column(name = "CREATION_DATE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_DATE_LOAN)
    private Date creationDate;

    @Column(name = "MODIFICATION_USER", columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_USER_LOAN)
    private String modificationUser;

    @Column(name = "MODIFICATION_DATE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_DATE_LOAN)
    private Date modificationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Payment> payments;

}
