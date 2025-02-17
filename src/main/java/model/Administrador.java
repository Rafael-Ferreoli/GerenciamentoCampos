package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "administrador")
public class Administrador extends Funcionario {

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude // Para evitar recursão no toString
    private List<Operador> operadores = new ArrayList<>();

    public Administrador(String nome, String cpf, String matricula, String senha, String email) {
        super(null, nome, cpf, matricula, senha, email, "ADMINISTRADOR");
    }

@Override
public String toString() {
        return this.getNome() + " (" + this.getMatricula() + ")";
    }

}
