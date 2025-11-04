package com.example.demo.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="producto")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nombre;
  
    private String descripcion;
    private String lote;
    private float precioUnitario;
    private LocalDate fechaCaducidad;

    @JsonManagedReference
    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comment> comentarios;

    public Product(String nombre, String descripcion, String lote, float precioUnitario, LocalDate fechaCaducidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lote = lote;
        this.precioUnitario = precioUnitario;
        this.fechaCaducidad = fechaCaducidad;
    }
    public Product(String nombre, String descripcion, String lote, float precioUnitario, LocalDate fechaCaducidad, Set<Comment> comentarioList) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lote = lote;
        this.precioUnitario = precioUnitario;
        this.fechaCaducidad = fechaCaducidad;
        this.comentarios = comentarioList;
    }

    public Product(String id, String nombre, String descripcion, String lote, float precioUnitario,
            LocalDate fechaCaducidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lote = lote;
        this.precioUnitario = precioUnitario;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLote() {
        return lote;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public Set<Comment> getComentarios() {
        return comentarios;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setComentarios(Set<Comment> comentarios) {
        this.comentarios = comentarios;
    }

    
}
