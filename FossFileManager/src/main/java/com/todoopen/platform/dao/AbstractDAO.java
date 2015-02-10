/*
 * com.todoopen.platform.dao.AbstractDAO - Programa Fuente
 * Licencia TodoOpen
 * Derechos Reservados 2014 Nicolai Carlo Abruzzese Aguirre <nicolai@todoOpen.com>.
 *
 * Se concede permiso, libre de cargos, a cualquier persona que obtenga una copia de este programa (codigo) 
 * fuente, archivos, documentos y/o cualquier otro tipo asociado, denominado de ahora en adelante como
 * "Software", para utilizar el Software sin restricción, incluyendo los derechos de uso, copiar,modificar,
 * fusionar, publicar, distribuir, sublicenciar y/o vender copias del Software y a quien la adquiera bajo 
 * las siguientes condiciones:
 *
 * La licencia y Derechos Reservados, junto con los nombres completos de autores debe ser incluida en 
 * toda copia, parte sustancial, porcion o derivado del Software.
 *
 * El registro propietario, derechos de autor, algoritmos, programas, rutinas, procedimientos, funciones,
 * copia total, copia parcial, parte sustancial, porcion o derivado del Software, deben ser reconocidos 
 * a nombre de los autores y se deben garantizar sus derechos y autoria.
 *
 * EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O IMPLÍCITA, INCLUYENDO
 * PERO NO LIMITADO A LAS GARANTÍAS DE COMERCIALIZACIÓN, ADECUADO PARA UN PROPÓSITO PARTICULAR E 
 * INCUMPLIMIENTO. EN NINGÚN CASO LOS AUTORES O TITULARES DE LOS DERECHOS RESERVADOS SERÁN RESPONSABLES DE 
 * NINGUN RECLAMO, DAÑOS U OTRA RESPONSABILIDAD, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O CUALQUIER OTRA
 * FORMA, DERIVADOS DE,O EN CONEXION CON EL SOFTWARE O DEL USO U OTROS TRATOS EN EL SOFTWARE.
 * 
 */

package com.todoopen.platform.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
//import javax.inject.Inject;

/**
 *
 * @author Nicolai Carlo Abruzzese Aguirre <nicolai@todoOpen.com>
 */
public abstract class AbstractDAO<T> implements Serializable {
    private Class<T> entityClass;

    //@Inject
    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
