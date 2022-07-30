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

import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@Entity
@Table(name = "TARGET_CONFIG", schema = "CREDITDB")
@org.hibernate.annotations.Table(comment = "Stores user target settings", appliesTo = "target_config")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TARGET_CONFIG")
    private Long id;

    @Column(name = "DESCRIPTION", columnDefinition = Constant.COLUMN_DEFINITION_STRING_DESCRIPTION_TARGET_CONFIG)
    private String description;

    @Column(name = "TYPE_CONFIG", columnDefinition = Constant.COLUMN_DEFINITION_STRING_TYPE_CONFIG_TARGET_CONFIG)
    private Integer typeConfig;

    @Column(name = "FIXED_VALUE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_FIXED_VALUE_TARGET_CONFIG)
    private Double value;

    @Column(name = "MIN_VALUE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_MIN_VALUE_TARGET_CONFIG)
    private Double minValue;

    @Column(name = "MAX_VALUE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_MAX_VALUE_TARGET_CONFIG)
    private Double maxValue;

    @Column(name = "STATUS", columnDefinition = Constant.COLUMN_DEFINITION_STRING_STATUS_TARGET_CONFIG)
    private Integer status;

    @Column(name = "CREATION_USER", columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_USER_TARGET_CONFIG)
    private String creationUser;

    @Column(name = "CREATION_DATE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_DATE_TARGET_CONFIG)
    private Date creationDate;

    @Column(name = "MODIFICATION_USER", columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_USER_TARGET_CONFIG)
    private String modificationUser;

    @Column(name = "MODIFICATION_DATE", columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_DATE_TARGET_CONFIG)
    private Date modificationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TARGET")
    private Target target;

}
