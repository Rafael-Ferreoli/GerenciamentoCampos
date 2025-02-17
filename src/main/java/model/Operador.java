package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "operador")
public class Operador extends Funcionario {
    
    @ManyToOne
    @JoinColumn(name = "administrador_id")
    @ToString.Exclude // Para evitar recursão no toString
    private Administrador administrador;
    
    public Operador(String nome, String cpf, String matricula, String senha, String email) {
        super(null, nome, cpf, matricula, senha, email, "OPERADOR");
    }
}
