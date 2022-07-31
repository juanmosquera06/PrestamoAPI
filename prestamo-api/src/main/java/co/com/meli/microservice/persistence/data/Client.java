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
@Table(name = Constant.TABLE_STRING_NAME_CLIENT, schema = Constant.DATABASE_STRING_SCHEMA)
@org.hibernate.annotations.Table(comment = Constant.TABLE_STRING_COMMENT_CLIENT, appliesTo = Constant.COMMON_STRING_CLIENT)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constant.COLUMN_STRING_NAME_ID_CLIENT)
    private Long id;

    @Column(name = Constant.COLUMN_STRING_NAME_FIRST_NAME_CLIENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_FIRST_NAME_CLIENT)
    private String firstName;

    @Column(name = Constant.COLUMN_STRING_NAME_LAST_NAME_CLIENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_LAST_NAME_CLIENT)
    private String lastName;

    @Column(name = Constant.COLUMN_STRING_NAME_NATIONAL_ID_CLIENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_NATIONAL_ID_CLIENT)
    private String nationalId;

    @Column(name = Constant.COLUMN_STRING_NAME_TYPE_NATIONAL_ID_CLIENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_TYPE_NATIONAL_ID_CLIENT)
    private String typeNationalId;

    @Column(name = Constant.COLUMN_STRING_NAME_STATUS_CLIENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_STATUS_CLIENT)
    private Integer status;

    @Column(name = Constant.COLUMN_STRING_NAME_CREATION_USER_CLIENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_USER_CLIENT)
    private String creationUser;

    @Column(name = Constant.COLUMN_STRING_NAME_CREATION_DATE_CLIENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_DATE_CLIENT)
    private LocalDateTime creationDate;

    @Column(name = Constant.COLUMN_STRING_NAME_MODIFICATION_USER_CLIENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_USER_CLIENT)
    private String modificationUser;

    @Column(name = Constant.COLUMN_STRING_NAME_MODIFICATION_DATE_CLIENT, columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_DATE_CLIENT)
    private LocalDateTime modificationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Constant.COLUMN_STRING_NAME_ID_TARGET)
    private Target target;

    @OneToMany(mappedBy = Constant.COMMON_STRING_CLIENT, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Loan> loans;

}
