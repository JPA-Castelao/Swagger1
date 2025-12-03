package org.example.model;

import jakarta.persistence.*;


@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String apelidos;
    private int idTitor;

    public Alumno() {
    }

    public Alumno(String nome, String apelidos, int idTitor) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.idTitor = idTitor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public int getIdTitor() {
        return idTitor;
    }

    public void setIdTitor(int idTitor) {
        this.idTitor = idTitor;
    }
}
