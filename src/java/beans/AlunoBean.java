/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import daos.AlunoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import models.Aluno;

/**
 *
 * @author Marcos
 */

@ManagedBean(name="alunoBean")
@ViewScoped
public class AlunoBean{
    
    Aluno aluno;
    List alunos = new ArrayList();
    
    AlunoDao alunoDao;

    //construtor
    public AlunoBean() {        
        limpar();
    }

    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        alunoDao.adicionar(aluno);

        limpar();
    }

    public void alterar(ActionEvent actionEvent) {
        alunoDao.beginTransaction();
        alunoDao.atualizar(aluno);
        alunoDao.commit();
        
        limpar();
    }

    public void excluir(ActionEvent actionEvent) {
        alunoDao.beginTransaction();
        alunoDao.remover(aluno);
        alunoDao.commit();
        
        limpar();
    }
    
    public void limpar(){
        alunos = new AlunoDao().listar();
        aluno = new Aluno();        
        alunoDao = new AlunoDao();
    }

    //getters and setters
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List getAlunos() {
        return alunos;
    }

    public void setAlunos(List alunos) {
        this.alunos = alunos;
    }

}
