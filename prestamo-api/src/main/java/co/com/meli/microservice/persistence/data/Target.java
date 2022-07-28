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
@Table(name = "TARGET")
@org.hibernate.annotations.Table(comment = "Stores the different user targets", appliesTo = "target")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TARGET")
    @Comment("Table identifier")
    private Long id;

    @Column(name = "DESCRIPTION")
    @Enumerated(EnumType.STRING)
    @Comment("Target name")
    private co.com.meli.microservice.enums.Target description;

    @Column(name = "STATUS")
    @Comment("Target status. Active=1, Inactive=0")
    @NotNull
    private Integer status;

    @Column(name = "CREATION_USER")
    @Comment("Audit for record creation user")
    @NotNull
    private String creationUser;

    @Column(name = "CREATION_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mmz")
    @Comment("Audit for record creation date")
    @NotNull
    private Date creationDate;

    @Column(name = "MODIFICATION_USER")
    @Comment("Audit for record modification user")
    private String modificationUser;

    @Column(name = "MODIFICATION_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mmz")
    @Comment("Audit for record modification date")
    private Date modificationDate;

    @OneToMany(mappedBy = "target", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TargetConfig> targetConfigs;

}
