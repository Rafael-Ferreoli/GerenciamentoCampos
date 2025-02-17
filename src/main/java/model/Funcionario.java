package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(
    name = "funcionario",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cpf"}),
        @UniqueConstraint(columnNames = {"matricula"})
    }
)
public abstract class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @Column(unique = true)
    private String cpf;
    
    @Column(unique = true)
    private String matricula;
    
    private String senha;
    
    private String email;
    
    // Esse atributo será definido como "ADMINISTRADOR" ou "OPERADOR" nas subclasses
    private String cargo;
}
