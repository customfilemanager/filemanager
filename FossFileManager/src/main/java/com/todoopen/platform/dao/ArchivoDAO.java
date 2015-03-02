/*
 * Copyright (C) 2015 Nicolai Carlo Abruzzese Aguirre <nicolai@todoOpen.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.todoopen.platform.dao;

import com.todoopen.archivos.entity.Archivo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nicolai Carlo Abruzzese Aguirre <nicolai@todoOpen.com>
 */
public class ArchivoDAO extends AbstractDAO<Archivo> {

    public ArchivoDAO(Class<Archivo> entityClass) {
        super(entityClass);
    }

    @PersistenceContext(unitName = "punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        if(em == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit");
            em = emf.createEntityManager();
        }
        return em;
    }
}
