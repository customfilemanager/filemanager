/*
 * lv.archivos.entity.Archivo - Programa Fuente
 * Licencia TodoOpen
 * Derechos Reservados 2015 Nicolai Carlo Abruzzese Aguirre <nicolai@todoOpen.com>.
 *
 * Se concede permiso, libre de cargos, a cualquier persona que obtenga una copia
 * de este programa (codigo) fuente, archivos, documentos y/o cualquier otro tipo asociado, 
 * denominado de ahora en adelante como "Software", para utilizar 
 * el Software sin restricción, incluyendo los derechos de uso, copiar, modificar, fusionar, publicar, 
 * distribuir, sublicenciar y/o vender copias del Software y a quien la adquiera bajo las siguientes condiciones:
 *
 * La licencia y Derechos Reservados, junto con los nombres completos de autores debe ser incluida en 
 * toda copia, parte sustancial, porcion o derivado del Software.
 *
 * El registro propietario, derechos de autor, algoritmos, programas, rutinas, procedimeintos, funciones,
 * copia total, copia parcial, parte sustancial, porcion o derivado del Software, deben ser reconocidos 
 * a nombre de los autores y se deben garantizar sus derechos y autoria.
 *
 * EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O 
 * IMPLÍCITA, INCLUYENDO PERO NO LIMITADO A LAS GARANTÍAS DE COMERCIALIZACIÓN,
 * ADECUADO PARA UN PROPÓSITO PARTICULAR E INCUMPLIMIENTO. EN NINGÚN CASO LOS
 * AUTORES O TITULARES DE LOS DERECHOS RESERVADOS SERÁN RESPONSABLES DE NINGUN RECLAMO, DAÑOS U OTRA
 * RESPONSABILIDAD, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O CUALQUIER OTRA FORMA, DERIVADOS DE,
 * O EN CONEXION CON EL SOFTWARE O DEL USO U OTROS TRATOS EN
 * EL SOFTWARE.
 */
package com.todoopen.archivos.entity;

import java.util.Date;
import javax.persistence.Basic;

/**
 *
 * @author Nicolai Carlo Abruzzese Aguirre <nicolai@todoOpen.com>
 */
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "archivo")
public class Archivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private TipoArchivo tipoArchivo;
    
    public static enum TipoArchivo { OTRO };
    
    private String rutaParcial;
    
    private Long creador;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    private Long duenoUs;
    
    private String md5;
    
    private boolean isEncrypted;

    private String tipoDeContenido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoArchivo getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(TipoArchivo tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getRutaParcial() {
        return rutaParcial;
    }

    public void setRutaParcial(String rutaParcial) {
        this.rutaParcial = rutaParcial;
    }

    public Long getCreador() {
        return creador;
    }

    public void setCreador(Long creador) {
        this.creador = creador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getDuenoUs() {
        return duenoUs;
    }

    public void setDuenoUs(Long duenoUs) {
        this.duenoUs = duenoUs;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public boolean isIsEncrypted() {
        return isEncrypted;
    }

    public void setIsEncrypted(boolean isEncrypted) {
        this.isEncrypted = isEncrypted;
    }

    public String getTipoDeContenido() {
        return tipoDeContenido;
    }

    public void setTipoDeContenido(String tipoDeContenido) {
        this.tipoDeContenido = tipoDeContenido;
    }
}
