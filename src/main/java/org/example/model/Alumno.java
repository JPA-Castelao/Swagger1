package org.example.model;

import jakarta.persistence.*;


@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "apelidos")
    private String apelidos;

    @ManyToOne
    @JoinColumn
    private Titor titor;

    public Alumno() {
    }

    public Alumno(String nome, String apelidos) {
        this.nome = nome;
        this.apelidos = apelidos;}

    public long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getApelidos() {return apelidos;}

    public void setApelidos(String apelidos) {this.apelidos = apelidos;}

    public Titor getTitor() {return titor;}

    public void setTitor(Titor titor) {this.titor = titor;
    }
}
