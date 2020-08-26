/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import conf.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import models.Aluno;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos H. Costa
 */
public class AlunoDao {
    
    private Session session;
    private Transaction transaction;
    
    public AlunoDao(){
        this.session = HibernateUtil.getSession();
    }
    
    public void beginTransaction(){
        this.transaction = this.session.beginTransaction();
    }
    
    public void commit(){
        this.transaction.commit();
        this.transaction = null;
    }
    
    public void adicionar(Aluno a){
        this.session.save(a);
    }
    
    public void remover(Aluno a){
        this.session.delete(a);
    }
    
    public void atualizar(Aluno a){
        this.session.update(a);
    }
    
    public List<Aluno> listar(){
        return this.session.createCriteria(Aluno.class).list();
    }
    
    public Aluno localizar(Long id){
        return (Aluno) session.get(Aluno.class, id);
    }
}