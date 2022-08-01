/**
 * 
 */
package co.com.meli.microservice.persistence.data;

import java.time.LocalDateTime;
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
 * Entity class annotated with @Entity that contains the information related to
 * the target.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see Entity
 *
 */
@Entity
@Table(name = Constant.TABLE_STRING_NAME_TARGET, schema = Constant.DATABASE_STRING_SCHEMA)
@org.hibernate.annotations.Table(comment = Constant.TABLE_STRING_COMMENT_TARGET, appliesTo = Constant.COMMON_STRING_TARGET)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constant.COLUMN_STRING_NAME_ID_TARGET)
    private Long id;

    @Column(name = Constant.COLUMN_STRING_NAME_DESCRIPTION_TARGET, columnDefinition = Constant.COLUMN_DEFINITION_STRING_DESCRIPTION_TARGET)
    @Enumerated(EnumType.STRING)
    private co.com.meli.microservice.enums.Target description;

    @Column(name = Constant.COLUMN_STRING_NAME_STATUS_TARGET, columnDefinition = Constant.COLUMN_DEFINITION_STRING_STATUS_TARGET)
    private Integer status;

    @Column(name = Constant.COLUMN_STRING_NAME_CREATION_USER_TARGET, columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_USER_TARGET)
    private String creationUser;

    @Column(name = Constant.COLUMN_STRING_NAME_CREATION_DATE_TARGET, columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_DATE_TARGET)
    private LocalDateTime creationDate;

    @Column(name = Constant.COLUMN_STRING_NAME_MODIFICATION_USER_TARGET, columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_USER_TARGET)
    private String modificationUser;

    @OneToMany(mappedBy = Constant.COMMON_STRING_TARGET, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TargetConfig> targetConfigs;

    @OneToMany(mappedBy = Constant.COMMON_STRING_TARGET, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Client> clients;

}
