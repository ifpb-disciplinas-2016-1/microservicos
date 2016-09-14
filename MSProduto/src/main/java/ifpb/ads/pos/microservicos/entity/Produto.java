/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.microservicos.entity;

import java.io.Serializable;
import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Kaique Candido
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Produto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private double valor;
}
