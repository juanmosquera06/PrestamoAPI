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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Comment;

import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@Entity
@Table(name = "CLIENT", schema = "CREDITDB")
@org.hibernate.annotations.Table(comment = "Stores the different users with their personal information", appliesTo = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENT")
    private Long id;

    @Column(name = "FIRST_NAME", length = 100)
    @Comment("User first name")
    private String firstName;

    @Column(name = "LAST_NAME", length = 100)
    @Comment("User last name")
    private String lastName;

    @Column(name = "NATIONAL_ID", unique = true, length = 30)
    @Comment("User national id")
    @NotNull
    private String nationalId;

    @Column(name = "TYPE_NATIONAL_ID", length = 5)
    @Comment("User identity document")
    @NotNull
    private String typeNationalId;

    @Column(name = "STATUS", columnDefinition = Constant.COLUMN_DEFINITION_STRING_STATUS_CLIENT)
    private Integer status;

    @Column(name = "CREATION_USER", columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_USER_CLIENT)
    private String creationUser;

    @Column(name = "CREATION_DATE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_DATE_CLIENT)
    private Date creationDate;

    @Column(name = "MODIFICATION_USER", columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_USER_CLIENT)
    private String modificationUser;

    @Column(name = "MODIFICATION_DATE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_DATE_CLIENT)
    private Date modificationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TARGET")
    @NotNull
    private Target target;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Loan> loans;

}
