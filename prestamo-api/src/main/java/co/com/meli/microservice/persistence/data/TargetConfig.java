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

import org.hibernate.annotations.Comment;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(name = "DESCRIPTION", length = 50)
    @Comment("Configuration name")
    @NotNull
    private String description;

    @Column(name = "TYPE_CONFIG")
    @Comment("Target config type. Fixed Value=1, Range Value=2")
    @NotNull
    private Integer typeConfig;

    @Column(name = "STATUS")
    @Comment("Target config status. Active=1, Inactive=0")
    @NotNull
    private Integer status;

    @Column(name = "FIXED_VALUE")
    @Comment("Defines the fixed value of the target configuration")
    private Double value;

    @Column(name = "MIN_VALUE")
    @Comment("Defines the minimum value")
    private Double minValue;

    @Column(name = "MAX_VALUE")
    @Comment("Defines the maximum value")
    private Double maxValue;

    @Column(name = "CREATION_USER", length = 100)
    @Comment("Audit for record creation user")
    @NotNull
    private String creationUser;

    @Column(name = "CREATION_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mmz")
    @Comment("Audit for record creation date")
    @NotNull
    private Date creationDate;

    @Column(name = "MODIFICATION_USER", length = 100)
    @Comment("Audit for record modification user")
    private String modificationUser;

    @Column(name = "MODIFICATION_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mmz")
    @Comment("Audit for record modification date")
    private Date modificationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TARGET")
    @Comment("Target relationship")
    @NotNull
    private Target target;

}
