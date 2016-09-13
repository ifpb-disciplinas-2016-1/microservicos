/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.pos.microservicos.dao;

import ifpb.ads.pos.microservicos.entity.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kaique Candido
 */
@Stateless
public class ProdutoDao {

    @PersistenceContext(unitName = "MicroServicosProduto")
    EntityManager em;

    public Produto salvar(Produto produto) {
        em.persist(produto);
        return produto;

    }

    public Produto remover(long key) {
        Produto produto = this.buscar(key);
        em.remove(produto);
        return produto;
    }

    public Produto atualizar(Produto produto) {
        return em.merge(produto);
    }

    public Produto buscar(long key) {
        return em.find(Produto.class, key);
    }

    public List<Produto> listar() {
        return em.createQuery("FROM Produto p", Produto.class).getResultList();
    }

}
