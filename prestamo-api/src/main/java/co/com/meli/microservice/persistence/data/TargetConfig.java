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

import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class annotated with @Entity that contains the information related to
 * the configuration of target.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see Entity
 *
 */
@Entity
@Table(name = Constant.TABLE_STRING_NAME_TARGET_CONFIG, schema = Constant.DATABASE_STRING_SCHEMA)
@org.hibernate.annotations.Table(comment = Constant.TABLE_STRING_COMMENT_TARGET_CONFIG, appliesTo = Constant.COMMON_STRING_TARGET_CONFIG)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constant.COLUMN_STRING_NAME_ID_TARGET_CONFIG)
    private Long id;

    @Column(name = Constant.COLUMN_STRING_NAME_DESCRIPTION_TARGET_CONFIG, columnDefinition = Constant.COLUMN_DEFINITION_STRING_DESCRIPTION_TARGET_CONFIG)
    private String description;

    @Column(name = Constant.COLUMN_STRING_NAME_TYPE_CONFIG_TARGET_CONFIG, columnDefinition = Constant.COLUMN_DEFINITION_STRING_TYPE_CONFIG_TARGET_CONFIG)
    private Integer typeConfig;

    @Column(name = Constant.COLUMN_STRING_NAME_FIXED_VALUE_TARGET_CONFIG, columnDefinition = Constant.COLUMN_DEFINITION_STRING_FIXED_VALUE_TARGET_CONFIG)
    private Double value;

    @Column(name = Constant.COLUMN_STRING_NAME_MIN_VALUE_TARGET_CONFIG, columnDefinition = Constant.COLUMN_DEFINITION_STRING_MIN_VALUE_TARGET_CONFIG)
    private Double minValue;

    @Column(name = Constant.COLUMN_STRING_NAME_MAX_VALUE_TARGET_CONFIG, columnDefinition = Constant.COLUMN_DEFINITION_STRING_MAX_VALUE_TARGET_CONFIG)
    private Double maxValue;

    @Column(name = Constant.COLUMN_STRING_NAME_STATUS_TARGET_CONFIG, columnDefinition = Constant.COLUMN_DEFINITION_STRING_STATUS_TARGET_CONFIG)
    private Integer status;

    @Column(name = Constant.COLUMN_STRING_NAME_CREATION_USER_TARGET_CONFIG, columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_USER_TARGET_CONFIG)
    private String creationUser;

    @Column(name = Constant.COLUMN_STRING_NAME_CREATION_DATE_TARGET_CONFIG, columnDefinition = Constant.COLUMN_DEFINITION_STRING_CREATION_DATE_TARGET_CONFIG)
    private LocalDateTime creationDate;

    @Column(name = Constant.COLUMN_STRING_NAME_MODIFICATION_USER_TARGET_CONFIG, columnDefinition = Constant.COLUMN_DEFINITION_STRING_MODIFICATION_USER_TARGET_CONFIG)
    private String modificationUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Constant.COLUMN_STRING_NAME_ID_TARGET)
    private Target target;

}
