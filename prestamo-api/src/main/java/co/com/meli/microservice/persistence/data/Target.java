/**
 * 
 */
package co.com.meli.microservice.persistence.data;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TARGET", schema = "CREDITDB")
@org.hibernate.annotations.Table(comment = "Stores the different user targets", appliesTo = "target")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TARGET")
    private Long id;

    @Column(name = "DESCRIPTION", columnDefinition = Constant.COLUMN_DEFINITION_STRING_DESCRIPTION_TARGET)
    @Enumerated(EnumType.STRING)
    private co.com.meli.microservice.enums.Target description;

    @Column(name = "STATUS", columnDefinition = Constant.COLUMN_DEFINITION_STRING_STATUS_TARGET)
    private Integer status;

    @Column(name = "CREATION_USER", columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_USER_TARGET)
    private String creationUser;

    @Column(name = "CREATION_DATE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_DATE_TARGET)
    private Date creationDate;

    @Column(name = "MODIFICATION_USER", columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_USER_TARGET)
    private String modificationUser;

    @Column(name = "MODIFICATION_DATE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_DATE_TARGET)
    private Date modificationDate;

    @OneToMany(mappedBy = "target", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TargetConfig> targetConfigs;

    @OneToMany(mappedBy = "target", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Client> clients;

}
